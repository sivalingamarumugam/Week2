package week2.day1.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://leafground.com/pages/Dropdown.html");
		// select using index - dropdown1
		Select dd1 = new Select(driver.findElement(By.xpath("//select[@id='dropdown1']")));
		dd1.selectByIndex(1);
		// select using text - dropdown 2
		Select dd2 = new Select (driver.findElement(By.xpath("//select[@name='dropdown2']")));
		dd2.selectByVisibleText("Selenium");
		//select using vale - dd3
		Select dd3 = new Select (driver.findElement(By.xpath("//select[@name='dropdown3']")));
		dd3.selectByValue("1");
		// get the number of dd options
		Select dd4 = new Select (driver.findElement(By.className("dropdown")));
		List<WebElement> allOptions = dd4.getOptions();
		System.out.println("NO of dd options "+ allOptions.size());
		//You can also use sendKeys to select
		driver.findElement(By.xpath("(//div[@class='example']/select)[5]")).sendKeys("Selenium");
		// mulitple select
		Select dd5= new Select(driver.findElement(By.xpath("(//div[@class='example']/select)[6]")));
		dd5.selectByValue("1");
		dd5.selectByVisibleText("Appium");
		

		
		
		
		

	}

}
