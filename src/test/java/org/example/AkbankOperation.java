package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AkbankOperation {

    By btnCreditCalculation = By.id("ctl00_ucFooterMenu_rptMain_ctl02_rptChild_ctl00_linkChild");
    By txtCreditPrice = By.id("t-credit-price");
    By btnInsurance = By.xpath("//*[text()='SİGORTASIZ']/..");
    By sliderRange = By.xpath("//*[contains(@class,'ui-slider-range-min')]");
    By btnCalculationDetails = By.xpath("//*[text()='Hesaplama Detayları']");
    By checkCostRatio = By.id("content-1");
    By checkPaymentPlan = By.id("content-2");
    By btnPaymentPlan = By.id("accordion2");
    By jspContainerScroll = By.xpath("//*[@class='jspContainer']//td[text()='20']");
    WebDriver driver;
    WebDriverWait wait;

    public AkbankOperation(WebDriver driver){
        this.driver = driver;
    }

    public void scrollDown(){
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickCreditCalculation(){
        driver.findElement(btnCreditCalculation).click();
    }

    public void setAmount(String amount){
        driver.findElement(txtCreditPrice).clear();
        driver.findElement(txtCreditPrice).sendKeys(amount);
    }

    public void clickInsurance(){
        driver.findElement(btnInsurance).click();
    }

    public void setDraggable(){
        Actions acrion = new Actions(driver);
        //Perform drag and drop
        acrion.dragAndDropBy(driver.findElement(sliderRange), 10, 0).build().perform();
    }

    public void clickCalculationDetails(){
        try {
            driver.findElement(btnCalculationDetails).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkCostRatio(){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(checkCostRatio));
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean checkPaymentPlan(){
        wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(checkPaymentPlan));
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public void clickPaymentPlan(){
        driver.findElement(btnPaymentPlan).click();
    }

    public void scrollDownPaymentPlan(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(jspContainerScroll);
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

}
