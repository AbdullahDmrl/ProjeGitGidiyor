package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseDriverSingle {
    public static WebDriver driver;

    @BeforeClass
    public void Login(){
        if (!runningFromIntelij()) {
            // Hafizada calisma yani headless work(Jenkins) bu durumda intelij den calismaz ve option vermeliyiz
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400"); //width, height
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
            driver = new ChromeDriver(options);

        }
        else {     // Intelij den calisiyorsa asagidakini set ediyor

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        System.out.println("Intellij den mi calisiyor= "+runningFromIntelij());
        driver.get("http://www.hepsiburada.com/");


    }

    @AfterClass
    public void BitisIslemleri(ITestContext context)  {
        IResultMap sonuclar=context.getPassedTests();
        Set<ITestResult> results=sonuclar.getAllResults();

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("Test bitti");
        for (ITestResult e:results) {
            System.out.println("Test adi= " + e.getName() + "Test gecti mi= " + e.isSuccess());

        }
        for (ITestResult result:results) {
            ExcelUtility.writeExcel("src/ApachePOIExcell/TestsStatus.xlsx",result,date.format(formatter));

        }

        Tools.Sleep(5);
        driver.quit();
    }

    public static boolean runningFromIntelij()
    {
        //   System.out.println("classPath = "+System.getProperty("java.class.path"));
        //     classPath = C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.3.2\lib\idea_rt.jar

        String classPath=System.getProperty("java.class.path");
        return classPath.contains("idea_rt.jar");
    }


}
