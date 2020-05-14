package week2.day1.assignment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemosalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByXPath("//*[@id=\"button\"]/a").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("SivalignamArumugam Pvt Ltd");
		driver.findElementById("createLeadForm_firstName").sendKeys("Sivalingam");
		driver.findElementById("createLeadForm_lastName").sendKeys("Arumugam");
		Select source = new Select (driver.findElementByName("dataSourceId"));
		source.selectByVisibleText("Employee");
		Select marketingCampaign = new Select(driver.findElementByXPath("//*[@id=\"createLeadForm_marketingCampaignId\"]"));
		marketingCampaign.selectByValue("9001");
		Select ownerShip = new Select (driver.findElementById("createLeadForm_ownershipEnumId"));
		ownerShip.selectByIndex(5);
		Select country = new Select(driver.findElementByName("generalCountryGeoId"));
		country.selectByVisibleText("India");
		driver.findElementByName("submitButton").click();
		Thread.sleep(500);
		String title = driver.getTitle();
		System.out.println("Title of the page :" +title);
	 
	}

}

