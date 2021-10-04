package Utils;

import TestSteps.hepsiBuradaElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
    public static void closeDialog() {
        WebElement yenHizmet= BaseDriverSingle.driver.findElement(By.xpath("//div[text()='Yeni Hizmet!']"));
        waitVisibleOfElement(yenHizmet);
        WebElement closeDialog= BaseDriverSingle.driver.findElement(By.cssSelector("div[class*='ShippingLocation-deliveryPopover']>div>div:nth-of-type(1)"));
        closeDialog.click();
        ESC();
    }

    public static void waitVisibleOfElement(WebElement element) {
        WebDriverWait wait=new WebDriverWait(BaseDriverSingle.driver,20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitInvisibleOfElement(WebElement element) {
        WebDriverWait wait=new WebDriverWait(BaseDriverSingle.driver,20);
        wait.until(ExpectedConditions.visibilityOf(element));
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
