package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;


public class FirstTask {
    WebDriver driver;

    @BeforeTest
    public void driverSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
    }

  /*  @Test(dataProvider = "LoginData")
    public void sampleTest1() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("mngr481736");
        loginPage.enterPasswoerd("ypEhEmA");
        loginPage.clickLoginbtn();
        softAssert.assertEquals(loginPage.getConfirmId(), "Manger Id : mngr481736");
        softAssert.assertAll();
        driver.close();
    }*/
    @Test(dataProvider = "LoginData")
    public void loginTest(String user,String pwd){
        String actualTitle;
        String actualBoxMsg;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId(user);
        loginPage.enterPasswoerd(pwd);
        loginPage.clickLoginbtn();

        try{

            Alert alt = driver.switchTo().alert();
            actualBoxMsg = alt.getText(); // get content of the Alter Message
            alt.accept();
            // Compare Error Text with Expected Error Value
            assertEquals(actualBoxMsg,LoginPage.EXPECT_ERROR);

        }
        catch (NoAlertPresentException Ex){
            actualTitle = driver.getTitle();
            // On Successful login compare Actual Page Title with Expected Title
            assertEquals(actualTitle,LoginPage.EXPECT_TITLE);
        }


    }
    @DataProvider(name = "LoginData")
    public String[][] getData(){
        String loginData[][]={
                {"mngr451736","mpEhEmA"},
                {"mngr491736","ypEhEmA"},
                {"mngr481736","ypEhEaA"},
                {"mngr481736","ypEhEmA"},

        };

         return loginData;
    }
    @AfterTest
    public void closeweb(){
        driver.close();
    }


}
