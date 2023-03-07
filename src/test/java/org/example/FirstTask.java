package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Text;
import pages.LoginPage;
import org.testng.asserts.SoftAssert;


public class FirstTask {
    WebDriver driver;

    @BeforeTest
    public void driverSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
    }

    @Test
    public void sampleTest1() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("mngr481736");
        loginPage.enterPasswoerd("ypEhEmA");
        loginPage.clickLoginbtn();
        softAssert.assertEquals(loginPage.getConfirmId(), "Manger Id : mngr481736");
        softAssert.assertAll();
        driver.close();
    }


}
