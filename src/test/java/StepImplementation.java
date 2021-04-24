import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import org.example.AkbankBaseModel;
import org.example.AkbankOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepImplementation {

    WebDriver driver;
    AkbankBaseModel akbankBaseModel;
    AkbankOperation akbankOperation;

    @BeforeScenario
    public void akbankSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chrome-driver\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
        akbankBaseModel = new AkbankBaseModel(driver);
        akbankOperation = new AkbankOperation(driver);
    }

    @Step("Enter Akbank Home Page; “akbank.com”")
    public void gotoAkbank() {
        akbankBaseModel.gotoAkbank();
    }

    @Step("Scroll down to the bottom of the page")
    public void scrollDown() {
        akbankOperation.scrollDown();
    }

    @Step("Click on Kredi Hesaplama")
    public void clickCreditCalculation() {
        akbankOperation.clickCreditCalculation();
    }

    @Step("Enter <key> TL in “TUTAR” field")
    public void setAmount(String key) {
        akbankOperation.setAmount(key);
    }

    @Step("Choose “SİGORTASIZ”")
    public void clickInsurance() {
        akbankOperation.clickInsurance();
    }

    @Step("Set “VADE” as 20 AY")
    public void setDraggable() {
        akbankOperation.setDraggable();
    }

    @Step("Click “Hesaplama Detayları”")
    public void clickCalculationDetails() {
        akbankOperation.clickCalculationDetails();
    }

    @Step("Check <key> is opened")
    public void checkCostRatio(String key) {
        if(key.contains("Masraf ve Maliyet Oranları")){
            akbankOperation.checkCostRatio();
        }
        else {
            akbankOperation.checkPaymentPlan();
        }
    }

    @Step("Click <key>")
    public void clickPaymentPlan(String key){
        akbankOperation.clickPaymentPlan();
    }

    @Step("Scroll down on the “Ödeme Planı” page until 20th is seen")
    public void scrollDownPaymentPlan(){
        akbankOperation.scrollDownPaymentPlan();
    }

    @AfterScenario
    public void driverQuit(){
        driver.quit();
    }
}
