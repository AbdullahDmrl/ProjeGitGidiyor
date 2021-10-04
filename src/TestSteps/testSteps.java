package TestSteps;


import Utils.BaseDriverSingle;
import Utils.Tools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testSteps extends BaseDriverSingle {
    String urun;
    @Test
    public void test1EntryCheck() {
        hepsiBuradaElements elements=new hepsiBuradaElements(driver);
        String expected="Giriş Yap";
       // System.out.println(elements.myAcoountText.getText());
        Assert.assertTrue(elements.myAccountText.getText().contains(expected));
    }

        @Test
        public void test2LoginCheck() {
            Tools.Login();
            //Tools.closeDialog();
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            String expected="Hesabım";
           // System.out.println(elements.myAcoountText.getText());
            Assert.assertTrue(elements.myAccountText.getText().contains(expected));

        }

        @Test(dependsOnMethods = "test2LoginCheck")
        public void test3SearchResultsCheck() {
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            elements.searchInput.clear();
            elements.searchInput.sendKeys("samsung");
            elements.searchBtn.click();
            elements.telefonBtn.click();
            elements.ceptelefonBtn.click();
            String expected="samsung ile ilgili";
           // System.out.println(elements.searchResultsText.getText());
            Assert.assertTrue(elements.searchResultsText.getText().contains(expected));

        }

        @Test(dependsOnMethods = "test3SearchResultsCheck")
        public void test4UrunListePopupCheck() {
          hepsiBuradaElements elements=new hepsiBuradaElements(driver);
          elements.secondButton.click();
         // System.out.println(elements.besinciUrun.getText());
          urun=elements.besinciUrun.getText();
          elements.besinciUrun.click();
          WebDriverWait wait=new WebDriverWait(driver,20);
          wait.until(ExpectedConditions.elementToBeClickable(elements.begenButton));
          elements.begenButton.click();
          Tools.waitVisibleOfElement(elements.listeEklediPopup);
          Assert.assertEquals(elements.listeEklediPopup.getText(),"Ürün listenize eklendi.");
          Tools.waitInvisibleOfElement(elements.listeEklediPopup);

        }
        @Test(dependsOnMethods = "test4UrunListePopupCheck")
        public void test5BegendiklerimCheck() {
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            elements.myAccount.click();
            elements.begendiklerimBtn.click();
            boolean result=false;
            for (WebElement e:elements.begendiklerimList)
            {
                System.out.println(e.getText());
                if (e.getText().equalsIgnoreCase(urun)){
                   System.out.println("urun "+urun);
                    System.out.println(e.getText());
                   e.click();
                    result=true;
                    break;
                }
            }
            if (!result)
                Assert.fail();

        }

        @Test(dependsOnMethods = "test5BegendiklerimCheck")
        public void test6SepetEklendiPupUpCheck() {
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            elements.secButton.click();
            for (WebElement e:elements.begendiklerimList)
            {
               if (e.getText().equalsIgnoreCase(urun))
                   e.click();
            }
            elements.sepeteEkleButton.click();
            WebDriverWait wait=new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(elements.sepEkpopUpText));
           // System.out.println("text= "+ elements.popUpText.getText());
            Assert.assertEquals(elements.sepEkpopUpText.getText(),"Ürün sepete eklendi");
        }

        @Test(dependsOnMethods = "test6SepetEklendiPupUpCheck")
        public void test7urunSepettenSilmeCheck() {
            hepsiBuradaElements elements=new hepsiBuradaElements(driver);
            elements.sepetimButton.click();

            for (WebElement e:elements.sepetProductNames){
                if(e.getText().equalsIgnoreCase(urun))
                    elements.kaldirButton.click();
            }
            WebDriverWait wait=new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(elements.silButton));
            elements.silButton.click();

           Assert.assertEquals(elements.kaldirKontrol.getText(),"Ürün sepetinizden silinmiştir");
        }


    @Test(dependsOnMethods = "test7urunSepettenSilmeCheck")
    public void test8urunBegendiklerdenSilmeCheck() {
        hepsiBuradaElements elements=new hepsiBuradaElements(driver);
        elements.kaanBtn.click();
        elements.begendiklerimTitle.click();
        elements.secButton.click();
        for (WebElement e:elements.begendiklerimList)
        {
            if (e.getText().equalsIgnoreCase(urun))
                e.click();
        }
        elements.sillBtn.click();
        elements.confsilBtn.click();
    }




}
