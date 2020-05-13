package week2.day2.xpath;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAppUsingXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElementByXPath("//input[@id='username']").sendKeys("DemosalesManager");
		driver.findElementByXPath("//input[@type='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@value='Login']").click();
		driver.findElementByXPath("//img[contains(@src,'integrating')]").click();
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[contains(@href,'createLeadForm')]").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("SivalignamArumugam Pvt Ltd");
		driver.findElementById("createLeadForm_firstName").sendKeys("Sivalingam");
		driver.findElementById("createLeadForm_lastName").sendKeys("Arumugam");
		Select source = new Select (driver.findElementByXPath("//select[@name='dataSourceId']"));
		source.selectByVisibleText("Employee");
		Select marketingCampaign = new Select(driver.findElementByXPath("//select[@name='marketingCampaignId']"));
		marketingCampaign.selectByValue("9001");
		Select ownerShip = new Select (driver.findElementByXPath("//select[@id='createLeadForm_ownershipEnumId']"));
		ownerShip.selectByIndex(5);
		Select country = new Select(driver.findElementByName("generalCountryGeoId"));
		country.selectByVisibleText("India");
		driver.findElementByName("submitButton").click();
		Thread.sleep(500);
		String title = driver.getTitle();
		System.out.println("Title of the page :" +title);
		
	}

}
