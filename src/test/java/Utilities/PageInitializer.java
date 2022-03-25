package Utilities;
import pagesClass.CareersPage;
import pagesClass.CommonPage;

public class PageInitializer extends Driver{

    public static CommonPage ComP;
    public static CareersPage CarP;



    public static void initialize() {

        ComP = new CommonPage();
        CarP = new CareersPage();
    }

}


	

