package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class HomePage{

	WebDriver driver;

	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;

	}
	// locator

	By btnmyacount = By.xpath("//a[@title='My Account']");
	// @FindBy (xpath="//a[@title='My Account']") WebElement btnmyacount;
	By btnregister = By.xpath("//a[normalize-space()='Register']");
	// @FindBy (xpath="//a[normalize-space()='Register']") WebElement btnregister;
	By btnLogin = By.xpath("//a[normalize-space()='Login']");

	// Action

	public void clickMyacount() {
		driver.findElement(btnmyacount).click();
		// btnmyacount.click();

	}

	public void clickRegister() {
		driver.findElement(btnregister).click();

		// btnregister.click();

	}

	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}

}
