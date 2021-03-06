package TestSteps;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class hepsiBuradaElements  {

    public hepsiBuradaElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

 @FindBy(id = "myAccount")
 public WebElement myAccount;

   @FindBy(css = "div#myAccount>span")
    public WebElement myAccountText;

    @FindBy(css = "input.desktopOldAutosuggestTheme-input")
    public WebElement searchInput;

    @FindBy(xpath = "//div[text()='ARA']")
    public WebElement searchBtn;

    @FindBy(css = "ol#categoryList>li:nth-child(2)")
    public WebElement telefonBtn;

    @FindBy(css = "ol#categoryList>li:nth-child(4)")
    public WebElement ceptelefonBtn;

    @FindBy(css = "div#productresults>header")
    public WebElement searchResultsText;

    @FindBy(css = "div#pagination>ul>li:nth-child(2)")
    public WebElement secondPageBtn;

   @FindBy(css = "ul.product-list.results-container.do-flex.list>li")
   public List <WebElement> secondPagProdList;

    @FindBy(css = "h1#product-name")
    public WebElement desiredProductName;

    @FindBy(xpath = "//div[text()='Beğen']")
    public WebElement begenButton;

    @FindBy(css = "div.hb-toast-text")
    public WebElement listeEklediPopup;

   @FindBy(linkText = "Beğendiklerim")
   public WebElement Begendiklerim;

    @FindBy(css = "div.infinite-scroll-holder>ul>div")
    public List<WebElement> begendiklerimList;

    @FindBy(xpath = "(//button[text()='Seç'])[2]")
    public WebElement secButton;

    @FindBy(xpath = "//button[text()='Sepete Ekle']")
    public WebElement sepeteEkleButton;

    @FindBy(css = "form#addToCartForm")
    public WebElement sepetEklePupup;

    @FindBy(xpath = "//div[@class='hb-toast-text']")
    public WebElement sepEkpopUpText;

    @FindBy(xpath = "//span[text()='Sepetim']")
    public WebElement sepetimButton;

   @FindBy(css = "section#onboarding_item_list>ul>li")  // sepProd Names:  div.product_name_3Lh3t
   public List<WebElement> sepProductList;

    @FindBy(css = "a[aria-label='Ürünü Kaldır']")  // "//a[@aria-label='Ürünü Kaldır']"
    public List<WebElement>  kaldirButns;

    @FindBy(xpath = "//button[text()='Sil']")
    public WebElement silButton;

    @FindBy(xpath = "//span[text()='Ürün sepetinizden silinmiştir']")
    public WebElement SepSilPupupText;

    @FindBy(xpath = " //span[text()='KK']")
    public WebElement kaanBtn;

    @FindBy(xpath = "//a[text()='Beğendiklerim']")
    public WebElement begendiklerimTitle;

   @FindBy(css = "button#StickActionHeader-RemoveSelected")
    public WebElement deleteBtn;

    @FindBy(xpath = "(//button[text()='Sil'])[2]")
    public WebElement confirmDeleteBtn;


}
