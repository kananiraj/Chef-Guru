package com.intern.chefguru.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.intern.chefguru.model.CategoryModel;
import com.intern.chefguru.model.RecipeModel;

import java.util.ArrayList;

public class CategoryViewModel extends AndroidViewModel {
    private ArrayList<CategoryModel> mGujaratiLists;
    private ArrayList<CategoryModel> mPunjabiLists;
    private ArrayList<CategoryModel> mChineseLists;
    private ArrayList<CategoryModel> mSouthIndian;
    private ArrayList<CategoryModel> mAmericanLists;
    private ArrayList<CategoryModel> mfastfoodLists;

    private ArrayList<CategoryModel> mMexicanLists;

    private CategoryModel mCategoryModel;
    private RecipeModel mRecipeModel;
    private String mCurrentCategory;

    public CategoryViewModel(@NonNull Application application) {
        super(application);

        fillGujarati();
        fillPunjabi();
        fillchinese();
        fillSouthIndian();
        fillAmerican();
        fillMexican();
        fillFastfood();
    }

    public RecipeModel getRecipeModel() {
        return mRecipeModel;
    }

    public void setRecipeModel(RecipeModel recipeModel) {
        this.mRecipeModel = recipeModel;
    }

    public CategoryModel getCategoryModel() {
        return mCategoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.mCategoryModel = categoryModel;
    }
    private void fillFastfood()
    {
        mfastfoodLists=new ArrayList<>();
        mfastfoodLists.add(new CategoryModel("Pav Baji","https://www.thespruceeats.com/thmb/xoSWjy3I9d3U-KThzlCxVK25XHQ=/1944x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/GettyImages-1157700503-4e978c3b85d2484aaad9a2be39212305.jpg"));
        mfastfoodLists.add(new CategoryModel("Bhelpuri","https://www.thespruceeats.com/thmb/S5b7aEnu-OwoUVS-lNG6UmiBgUg=/1785x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/bhel-puri-puffed-rice-snack-1958033.Hero-5b61c5f046e0fb0050474bd0.jpg"));
        mfastfoodLists.add(new CategoryModel("Bajiya(pakora)","https://www.thespruceeats.com/thmb/O7jdvyuxK5F_EZ6_rxdTsWbp4uw=/2123x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/GettyImages-103015651-5b16e5dffa6bcc003695d571.jpg"));
        mfastfoodLists.add(new CategoryModel("Samosa","https://www.thespruceeats.com/thmb/C-Bc8gO_JBqIC_ZcIrpLVbHTf3Y=/1902x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/GettyImages-152690215-5b16d9b91d64040036052610.jpg"));
        mfastfoodLists.add(new CategoryModel("Vada pav","https://www.thespruceeats.com/thmb/XDWIAuDFfHo4oNpM5M9dPYsn4nI=/960x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/vadapav-56ac12145f9b58b7d00a409e.jpg"));
        mfastfoodLists.add(new CategoryModel("Dabeli","https://www.whiskaffair.com/wp-content/uploads/2019/06/Dabeli-1-1.jpg"));
        mfastfoodLists.add(new CategoryModel("kathi Rolls","https://ministryofcurry.com/wp-content/uploads/2019/10/paneer-kathi-rolls-1.jpg"));
        mfastfoodLists.add(new CategoryModel("Misal pav","https://i2.wp.com/www.vegrecipesofindia.com/wp-content/uploads/2011/06/misal-pav.jpg"));
        mfastfoodLists.add(new CategoryModel("Momos","https://i.pinimg.com/originals/d6/17/6e/d6176e3fafa69036f41442b3737ab644.jpg"));
        mfastfoodLists.add(new CategoryModel("Litti Chokha","https://img-global.cpcdn.com/recipes/be42f02f9c75dbef/640x640sq70/photo.jpg"));


    }
    private void fillSouthIndian()
    {
        mSouthIndian = new ArrayList<>();
        mSouthIndian.add(new CategoryModel("MYSORE MASALA DOSA","https://i1.wp.com/www.antoskitchen.com/wp-content/uploads/2017/07/Untitled-design.jpg?w=940&amp;ssl=1"));
        mSouthIndian.add(new CategoryModel("IDLI","https://i2.wp.com/www.antoskitchen.com/wp-content/uploads/2017/07/idli.jpg?w=940&amp;ssl=1"));
        mSouthIndian.add(new CategoryModel("MEDU VADA","a. https://i2.wp.com/www.antoskitchen.com/wp-content/uploads/2017/05/medu-vadai.jpg?w=940&amp;ssl=1"));
        mSouthIndian.add(new CategoryModel("PARUPPU VADA","https://i0.wp.com/www.antoskitchen.com/wp-content/uploads/2017/07/paruppu-vada.jpg?w=940&ssl=1"));
        mSouthIndian.add(new CategoryModel("PANIYARAM","https://i2.wp.com/www.antoskitchen.com/wp-content/uploads/2017/07/paniyaram.jpg?w=940&ssl=1"));
        mSouthIndian.add(new CategoryModel("COCONUT RICE","https://i0.wp.com/www.antoskitchen.com/wp-content/uploads/2017/07/coconut-rice.jpg?w=940&ssl=1"));
        mSouthIndian.add(new CategoryModel("PODI DOSA","https://i0.wp.com/www.antoskitchen.com/wp-content/uploads/2017/05/podi-dosa-1.jpg?w=940&ssl=1"));
        mSouthIndian.add(new CategoryModel("RAGI LADOO","https://i2.wp.com/www.antoskitchen.com/wp-content/uploads/2017/07/ragi-ladoo.jpg?w=940&ssl=1"));
        mSouthIndian.add(new CategoryModel("UTTAPAM","https://www.archanaskitchen.com/images/archanaskitchen/1-Author/kitchennandoos/vegetable_uttapam_.jpg"));
        mSouthIndian.add(new CategoryModel("PUTTU","https://www.archanaskitchen.com/images/archanaskitchen/Indian_Breakfast_Tiffins/Kerala_Style_Puttu_Recipe_Steamed_Rice_Cakes_with_Coconut-1.jpg"));

    }
    private void fillMexican()
    {
        mMexicanLists = new ArrayList<>();
        mMexicanLists.add(new CategoryModel("patato tagos","https://abbyphon.com/wp-content/uploads/2018/04/IMG_9602-e1523942853624.jpg"));
        mMexicanLists.add(new CategoryModel("burritos","https://www.onceuponachef.com/images/2018/03/Breakfast-Burritos-850x636.jpg"));
        mMexicanLists.add(new CategoryModel("chips","https://www.budgetbytes.com/wp-content/uploads/2015/11/Homemade-Baked-Tortilla-Chips-V2.jpg"));
        mMexicanLists.add(new CategoryModel("pinto pole","https://cookieandkate.com/images/2018/04/pinto-posole-recipe-768x1151.jpg"));
        mMexicanLists.add(new CategoryModel("lime soup","https://www.budgetbytes.com/wp-content/uploads/2012/10/Chicken-and-Lime-Soup-spoon.jpg"));
        mMexicanLists.add(new CategoryModel("tamales","https://164787-476375-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads/2018/09/jackfruit-vegan-tamales-26.jpg"));
        mMexicanLists.add(new CategoryModel("yamadillas","https://www.heinens.com/wp-content/uploads/2020/04/Black-Bean-and-Cheese-Yamadillas_800x550.jpg"));
        mMexicanLists.add(new CategoryModel("enchilada","https://freshisbestonbroadway.ca/wp-content/uploads/2017/04/ENCHILADAS_5507.jpeg"));
        mMexicanLists.add(new CategoryModel("guacamole","https://i.ndtvimg.com/i/2015-03/guacamole_625x350_51426065036.jpg"));
        mMexicanLists.add(new CategoryModel("tomato salsa","https://i.ndtvimg.com/i/2015-03/tomato-salsa_625x350_71426066139.jpg"));
    }
    private void fillAmerican()
    {
        mAmericanLists = new ArrayList<>();
        mAmericanLists.add(new CategoryModel("Hot-dog","https://i.ndtvimg.com/i/2015-07/hot-dog-625_625x350_51435919105.jpg"));
        mAmericanLists.add(new CategoryModel("burger","https://i.ndtvimg.com/i/2015-07/burger-625_625x350_51435922877.jpg"));
        mAmericanLists.add(new CategoryModel("mac cheese","https://i.ndtvimg.com/i/2015-07/america-food_624x350_71435923721.jpg"));
        mAmericanLists.add(new CategoryModel("pancakes","https://i.ndtvimg.com/i/2015-07/pancakes-625_625x350_71435918903.jpg"));
        mAmericanLists.add(new CategoryModel("cronut","https://i.ndtvimg.com/i/2015-07/cronut-625_625x350_71435922943.jpg"));
        mAmericanLists.add(new CategoryModel("sausage","https://i.ndtvimg.com/i/2015-07/sausage-625_625x350_71435918358.jpg"));
        mAmericanLists.add(new CategoryModel("vegan cornbread","https://eluxemagazine.com/wp-content/uploads/2020/06/Vegan-Cornbread-15.jpg"));
        mAmericanLists.add(new CategoryModel("haystacks","https://minimalistbaker.com/wp-content/uploads/2016/02/7-Ingredient-CRISPY-HASH-BROWN-Haystacks-with-corn-parsley-and-shallot.-Crispy-savory-SO-perfect-for-breakfast-or-brunch-vegan-glutenfree-breakfast-recipe-minimalistbaker.jpg"));
        mAmericanLists.add(new CategoryModel("fries","https://eluxemagazine.com/wp-content/uploads/2018/07/The-Best-Vegan-French-Fries-3.jpg"));
        mAmericanLists.add(new CategoryModel("apple","https://eluxemagazine.com/wp-content/uploads/2018/07/Apple-Pie-Made-With-The-Flakiest-Vegan-Pie-Crust-7.jpg.webp"));

    }


    private void fillchinese() {
        mChineseLists = new ArrayList<>();
        mChineseLists.add(new CategoryModel(
                "manchuriyan",
                "https://holycowvegan.net/wp-content/uploads/2020/03/veg-manchurian-6-768x892.jpg"));
        mChineseLists.add(new CategoryModel(
                "chili_patato",
                "https://img-global.cpcdn.com/recipes/c95edbe10fb81f22/640x640sq70/photo.jpg"));
        mChineseLists.add(new CategoryModel(
                "noodel",
                "https://www.ndtv.com/cooks/images/quick-noodles-%20with-whatever-620.jpg"));
        mChineseLists.add(new CategoryModel(
                "spring_roll",
                "https://i.ndtvimg.com/i/2015-10/spring-roll_625x350_81446202259.jpg"));
        mChineseLists.add(new CategoryModel(
                "soup",
                "https://i.ndtvimg.com/i/2018-05/veg-manchow-soup_620x350_71525942064.jpg"));
        mChineseLists.add(new CategoryModel(
                "stir_fry",
                "https://therecipecritic.com/wp-content/uploads/2019/08/vegetable_stir_fry.jpg"));
        mChineseLists.add(new CategoryModel(
                "garli_sauce",
                "https://www.saucefanatic.com/wp-content/uploads/2019/01/Chinese-Garlic-Sauce-2.jpg"));
        mChineseLists.add(new CategoryModel(
                "rice_fries",
                "https://i.ndtvimg.com/i/2015-09/chinese-fried-rice_625x350_41441399259.jpg"));
        mChineseLists.add(new CategoryModel(
                "chowmein",
                "https://i.ndtvimg.com/i/2015-09/noodles-625_625x350_51441392094.jpg"));
        mChineseLists.add(new CategoryModel(
                "samosa_chinese",
                "https://1.bp.blogspot.com/-S_-SZ2kA_c8/XaDcT8vZt1I/AAAAAAAACdQ/4H4DQNK8efUeKfdR4y5yugYQhocgcT_SQCLcBGAsYHQ/s1600/IMG_2229.JPG"));

    }


    public String getCurrentCategory() {
        return mCurrentCategory;
    }

    public void setCurrentCategory(String currentCategory) {
        this.mCurrentCategory = currentCategory;
    }

    private void fillGujarati() {
        mGujaratiLists = new ArrayList<>();
        mGujaratiLists.add(new CategoryModel(
                "Khandvi",
                "https://i.ndtvimg.com/i/2016-03/khandvi-625_625x350_81456813321.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Handvo",
                "https://www.nextcolumn.com/wp-content/uploads/2019/05/Handvo.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Kachori",
                "https://www.masala.tv/wp-content/uploads/2020/05/kachori-547.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Gujarati Kadhi",
                "https://1.bp.blogspot.com/-5ebQCQ4LWGU/Xq1zyTS7FhI/AAAAAAAAXN0/GJsMJZqUMDE1Un7e-07W4LHSIG6r-KrRACLcBGAsYHQ/s1600/traditional-gujarati-kadhi-4.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Undhiyu",
                "https://s3.amazonaws.com/indiafoodnetwork/wp-content/uploads/2020/01/16165717/Undhiyu-4.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Thepla",
                "https://upload.wikimedia.org/wikipedia/commons/7/74/Thepla_main.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Khakhara",
                "https://tiimg.tistatic.com/fp/1/005/748/hygienically-packed-tasty-khakhara-732.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Dhokala",
                "https://www.viniscookbook.com/wp-content/uploads/2018/06/2018-06-15-01-58-01.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Dal",
                "https://www.spiceupthecurry.com/wp-content/uploads/2020/08/Gujarati-dal-1.jpg"));
        mGujaratiLists.add(new CategoryModel(
                "Muthiya",
                "https://www.archanaskitchen.com/images/archanaskitchen/1-Author/Madhuli_Ajay/Methi_Muthiya_Wheat_flour_and_Fenugreek_dumplings.jpg"));
    }

    private void fillPunjabi() {
        mPunjabiLists = new ArrayList<>();
        mPunjabiLists.add(new CategoryModel(
                "Chole Bhature",
                "https://indianambrosia.com/wp-content/uploads/2019/06/bhature-2223-2.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "Dal Makhani",
                "https://indianambrosia.com/wp-content/uploads/2018/12/instant-pot-dal-makhani-2550.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "punjabi Kadhi",
                "https://indianambrosia.com/wp-content/uploads/2019/04/Punjabi-Kadhi-2009.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "Punjabi Chole",
                "https://indianambrosia.com/wp-content/uploads/2019/05/Punjabi-Chole-.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "Dum Aloo",
                "https://indianambrosia.com/wp-content/uploads/2018/12/Punjabi-Dum-Aloo-1446.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "Maloi Kofta",
                "https://indianambrosia.com/wp-content/uploads/2018/11/Malai-kofta-1203.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "Rajma Masala",
                "https://indianambrosia.com/wp-content/uploads/2018/05/instant-pot-rajma-masala-2370.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "palak Paneer",
                "https://indianambrosia.com/wp-content/uploads/2018/04/palak-paneer-.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "Paneer Tika",
                "https://i.ndtvimg.com/i/2015-01/paneer-tikka-625_625x350_81420697374.jpg"));
        mPunjabiLists.add(new CategoryModel(
                "Aloo Paratha",
                "https://cdn.cdnparenting.com/articles/2020/01/19152919/Aloo-Paratha-Recipe.jpg"));

    }

    public ArrayList<CategoryModel> getGujaratiLists() {
        return this.mGujaratiLists;
    }

    public ArrayList<CategoryModel> getPunjabiLists() {
        return this.mPunjabiLists;
    }

    public ArrayList<CategoryModel> getChineseLists() {
        return this.mChineseLists;
    }

    public ArrayList<CategoryModel> getSouthIndianLists() { return this.mSouthIndian; }
    public ArrayList<CategoryModel> getAmericanLists() { return this.mAmericanLists; }
    public ArrayList<CategoryModel> getMexicanLists() { return this.mMexicanLists; }
    public ArrayList<CategoryModel> getfastfoodLists() { return this.mfastfoodLists; }

}
