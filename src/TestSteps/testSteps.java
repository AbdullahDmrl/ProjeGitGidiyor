package TestSteps;


import Utils.BaseDriverSingle;
import Utils.Tools;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testSteps extends BaseDriverSingle {

   WebElement fifthProduct;
   String text;


    @Test
    public void test1EntryCheck() {
        hepsiBuradaElements elements=new hepsiBuradaElements(driver);
        Tools.verifyContainsText(elements.myAccountText,"Giriş Yap");
    }

        @Test
        public void test2LoginCheck() {
            Tools.Login();
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            Tools.verifyContainsText(elements.myAccountText,"Hesabım");
        }

        @Test(dependsOnMethods = "test2LoginCheck")
        public void test3SearchResultsCheck() {
           hepsiBuradaElements elements=new hepsiBuradaElements(driver);
           Tools.sendKeysFunction(elements.searchInput,"samsung");

           Tools.clickFunction(elements.searchBtn);
           Tools.clickFunction(elements.telefonBtn);
           Tools.clickFunction(elements.ceptelefonBtn);
           Tools.verifyContainsText(elements.searchResultsText,"samsung ile ilgili");
    }

        @Test(dependsOnMethods = "test3SearchResultsCheck")
        public void test4UrunListePopupCheck() {
          hepsiBuradaElements elements=new hepsiBuradaElements(driver);
          Tools.clickFunction(elements.secondPageBtn);
          Tools.selElementFromListByIndex(elements.secondPagProdList,6,fifthProduct);
          text=elements.desiredProductName.getText();
          Tools.clickFunction(elements.begenButton);
          Tools.verifyContainsText(elements.listeEklediPopup,"Ürün listenize eklendi.");
          Tools.waitInvisibleOfElement(elements.listeEklediPopup);
        }
        @Test(dependsOnMethods = "test4UrunListePopupCheck")
        public void test5BegendiklerimPageCheck() {
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            Tools.clickFunction(elements.myAccount);
            Tools.clickFunction(elements.Begendiklerim);
            Tools.verifyListContainsElement(elements.begendiklerimList,text);
        }

        @Test(dependsOnMethods = "test5BegendiklerimPageCheck")
        public void test6SepetEklendiPupUpCheck() {
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            Tools.clickFunction(elements.secButton);
            Tools.clickElementFromList(elements.begendiklerimList,text);
            Tools.clickFunction(elements.sepeteEkleButton);
            Tools.verifyContainsText(elements.sepEkpopUpText,"Ürün sepete eklendi");
            Tools.waitInvisibleOfElement(elements.sepEkpopUpText);

        }

        @Test(dependsOnMethods = "test6SepetEklendiPupUpCheck")
        public void test7urunSepettenSilmeCheck() {
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            Tools.clickFunction(elements.sepetimButton);
            Tools.delElementfromList(elements.sepProductList,elements.kaldirButns,text);
           // ToolstVisi.waibleOfElement(elements.kaldirButton);
           // Tools.clickFunction(elements.kaldirButton);
            Tools.clickFunction(elements.silButton);
            Tools.verifyContainsText(elements.SepSilPupupText,"Ürün sepetinizden silinmiştir");
            Tools.waitInvisibleOfElement(elements.SepSilPupupText);
        }


    @Test(dependsOnMethods = "test7urunSepettenSilmeCheck")
    public void test8urunBegendiklerdenSilmeCheck() {
        hepsiBuradaElements elements=new hepsiBuradaElements(driver);
        Tools.clickFunction(elements.kaanBtn);
        Tools.clickFunction(elements.begendiklerimTitle);
        Tools.clickFunction(elements.secButton);
        Tools.clickElementFromList(elements.begendiklerimList,text);
        Tools.clickFunction(elements.deleteBtn);
        Tools.clickFunction(elements.confirmDeleteBtn);

    }




}
