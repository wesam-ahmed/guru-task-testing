package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
WebDriver driver;
By UserId=By.xpath("//input[@name=\"uid\"]");
    public static final String EXPECT_ERROR = "User or Password is not valid";
    public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
By Password=By.xpath("//input[@name=\"password\"]");
By Loginbtn=By.xpath("//input[@name=\"btnLogin\"]");
By idconfirm=By.xpath("//td[@style=\"color: green\"]");
public LoginPage(WebDriver driver){this.driver=driver;}
public void timeTofindElement(By Text){
    WebDriverWait wait=new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(Text));
}
public void enterUserId(String Text){
    timeTofindElement(UserId);
    driver.findElement(UserId).sendKeys(Text);}
    public void enterPasswoerd(String Text){
    timeTofindElement(Password);
    driver.findElement(Password).sendKeys(Text);}
    public void clickLoginbtn() {
        timeTofindElement(Loginbtn);
        driver.findElement(Loginbtn).click();
    }
    public String getConfirmId(){
    timeTofindElement(idconfirm);
    return driver.findElement(idconfirm).getText();}

}
