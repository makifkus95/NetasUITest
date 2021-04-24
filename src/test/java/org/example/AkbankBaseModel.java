package org.example;

import org.openqa.selenium.WebDriver;

public class AkbankBaseModel
{
    WebDriver driver;

    public AkbankBaseModel(WebDriver driver){
        this.driver = driver;
    }

    public void gotoAkbank(){
        driver.get("https://www.akbank.com/");
    }
}
