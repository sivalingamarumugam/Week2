package week2.day2.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Classroom1 {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.navigate().to("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.findElementByXPath("//input[@id='username']").sendKeys("DemosalesManager");
	driver.findElementByXPath("//input[@type='password']").sendKeys("crmsfa");
	driver.findElementByXPath("//input[@value='Login']").click();
	driver.findElementByXPath("//img[contains(@src,'integrating')]").click();
	driver.findElementByXPath("//a[text()='Leads']").click();
	System.out.println(driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')])[1]")).getText());
	driver.findElement(By.xpath("(//a[contains(@href,'/crmsfa/control/viewLead?partyId')])[1]")).click();
	
	

	}

}
