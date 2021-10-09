package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Tools {

    public static void Sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void Login()
    {

        WebElement myAccount=BaseDriverSingle.driver.findElement(By.id("myAccount"));
        myAccount.click();
        WebElement girisYap= BaseDriverSingle.driver.findElement(By.xpath("//a[text()='Giriş Yap']"));
        girisYap.click();
        WebElement emailAddress= BaseDriverSingle.driver.findElement(By.id("txtUserName"));
        emailAddress.sendKeys("kaankan@yahoo.com");
        WebElement sifre= BaseDriverSingle.driver.findElement(By.id("txtPassword"));
        sifre.sendKeys("Burdur5429");
        WebElement buttonLogin= BaseDriverSingle.driver.findElement(By.id("btnLogin"));
        buttonLogin.click();
    }
    public static void sendKeysFunction(WebElement element, String value)
    {
        waitVisibleOfElement(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);

    }
    public static void clickFunction(WebElement element)
    {
        waitVisibleOfElement(element);
        scrollToElement(element);
        element.click();
    }


    public static void closeDialog() {
        WebElement yenHizmet= BaseDriverSingle.driver.findElement(By.xpath("//div[text()='Yeni Hizmet!']"));
        waitVisibleOfElement(yenHizmet);
        WebElement closeDialog= BaseDriverSingle.driver.findElement(By.cssSelector("div[class*='ShippingLocation-deliveryPopover']>div>div:nth-of-type(1)"));
        closeDialog.click();
        ESC();
    }
    public static void selElementFromListByIndex(List<WebElement> elementList, int index, WebElement element)
    {
        element=elementList.get(index);
        element.click();
    }

    public static void verifyListContainsElement(List<WebElement> elements, String text)
    {
        waitVisibleOfAllElements(elements);
      for (WebElement e:elements){
          if (e.getText().contains(text)){
              System.out.println("Liste elementi kapsiyor");  break;
          }
          else
           Assert.fail();
      }
    }

    public static void verifyContainsText(WebElement element, String msg)
    {
        waitVisibleOfElement(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(msg.toLowerCase()));
    }

    public static void clickElementFromList(List<WebElement> elementList, String text)
    {
        for (WebElement e:elementList)
        {
           if (e.getText().contains(text))
               e.click(); break;
        }
    }

    public static void delElementfromList(List<WebElement> elements,List<WebElement> butnsList, String text)
    {
        waitVisibleOfAllElements(elements);

        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j <butnsList.size() ; j++) {
                if (elements.get(i).getText().contains(text))
                    butnsList.get(j).click(); break;
            }
        }

    }

    public static void ActionHoverFunction(WebElement element,WebElement element1)
    {
        Actions aksiyonlar=new Actions(BaseDriverSingle.driver);
        Action action=aksiyonlar.moveToElement(element).moveToElement(element1).click(element1).build();
        action.perform();
    }



    public static void waitVisibleOfAllElements(List<WebElement> elementList){
        WebDriverWait wait=new WebDriverWait(BaseDriverSingle.driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public static void waitClickableOfElement(WebElement element) {
        WebDriverWait wait=new WebDriverWait(BaseDriverSingle.driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public static void waitVisibleOfElement(WebElement element) {
        WebDriverWait wait=new WebDriverWait(BaseDriverSingle.driver,20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitInvisibleOfElement(WebElement element) {
        WebDriverWait wait=new WebDriverWait(BaseDriverSingle.driver,20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void scrollToElement(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) BaseDriverSingle.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void ESC()  {
        Robot rbt= null;
        try {
            rbt = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        assert rbt != null;
        rbt.keyPress(KeyEvent.VK_ESCAPE);
        rbt.keyRelease(KeyEvent.VK_ESCAPE);
    }




}
