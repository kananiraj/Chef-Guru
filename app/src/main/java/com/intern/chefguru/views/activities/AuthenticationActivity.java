package com.intern.chefguru.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.intern.chefguru.R;
import com.intern.chefguru.utils.SharedPreference;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class AuthenticationActivity extends AppCompatActivity {

    Button hello;
    EditText email, password;
    TextView forpasss, registration;
    private SignInButton signInButton;
    //   private Button Google;
    private GoogleSignInClient mgoogleSignInClient;
    private LoginButton loginButton;
    private String name,mail;

    private FirebaseAuth mAuth;
    private int RC_SIGN_IN = 1;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_authentication);
        loginButton = findViewById(R.id.fblogin_button);
        signInButton = findViewById(R.id.signinbutton);
        mAuth = FirebaseAuth.getInstance();
        callbackManager = CallbackManager.Factory.create();
        loginButton.setPermissions(Arrays.asList("email", "public_profile"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mgoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signIn();

            }
        });

    }

    private void signIn() {
        Intent intent = mgoogleSignInClient.getSignInIntent();

        startActivityForResult(intent, RC_SIGN_IN);
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("Facebook", "handleFacebookAccessToken:" + token);

        loadUserProfile(token);
    }

    private void saveUserDataOnFirebase(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Facebook", "signInWithCredential:success");

                            Intent intent = new Intent(AuthenticationActivity.this, MainActivity.class);
                            startActivity(intent);

                            finishAffinity();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("hello", "signInWithCredential:failure", task.getException());
                            Toast.makeText(AuthenticationActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            //GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                //GoogleSignInAccount account = result.getSignInAccount();

                Toast.makeText(this, "signed in successful", Toast.LENGTH_SHORT).show();
                Firebasegoogleauth(account);
            } catch (Exception e) {
//                Toast.makeText(this, "signed in Failed", Toast.LENGTH_SHORT).show();
//                Firebasegoogleauth(null);
                //updateUI(null);
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "SignIn: failed!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void Firebasegoogleauth(final GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Toast.makeText(MainActivity.this, "successfull", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            SharedPreference.getInstance(AuthenticationActivity.this).setIsLoggedIn(true);
                            SharedPreference.getInstance(AuthenticationActivity.this).setLoginType("Google");
                            SharedPreference.getInstance(AuthenticationActivity.this).setUserName(account.getDisplayName());
                            SharedPreference.getInstance(AuthenticationActivity.this).setUserEmail(account.getEmail());
                            Log.e("Firebase", " + " + account.getPhotoUrl());
                            SharedPreference.getInstance(AuthenticationActivity.this).setProfilePic(String.valueOf(account.getPhotoUrl()));

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                            Log.e("Firebase", user.getDisplayName());
                        } else {

                            Toast.makeText(AuthenticationActivity.this, "Sorry Auth failed", Toast.LENGTH_SHORT).show();

                        }


                    }
                });
    }


    private void loadUserProfile(final AccessToken newAccessToken) {

        GraphRequest request = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                try {
                    String firstName = object.getString("name");
                    String email = object.getString("email");
                    String userFacebookId = object.getString("id");
                    String userProfilePicUrl = object.getJSONObject("picture").
                            getJSONObject("data").getString("url");
                    // String userProfilePicUrl = "https://graph.facebook.com/" + userFacebookId + "/picture?type=normal";

                    Log.e("Facebook", "User Name: " + firstName);
                    Log.e("Facebook", "Email: " + email);
                    Log.e("Facebook", "ID: " + userFacebookId);
                    Log.e("Facebook", "Profile Picture URL: " + userProfilePicUrl);

                    SharedPreference.getInstance(AuthenticationActivity.this)
                            .setUserEmail(email);
                    SharedPreference.getInstance(AuthenticationActivity.this)
                            .setUserName(firstName);
                    SharedPreference.getInstance(AuthenticationActivity.this)
                            .setProfilePic(userProfilePicUrl);

                    SharedPreference.getInstance(AuthenticationActivity.this).setIsLoggedIn(true);
                    SharedPreference.getInstance(AuthenticationActivity.this).setLoginType("Facebook");

                    // save user login data on Firebase
                    saveUserDataOnFirebase(newAccessToken);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameter = new Bundle();
        parameter.putString("fields", "id,name,email,picture.width(200)");
        request.setParameters(parameter);
        request.executeAsync();
    }
}
