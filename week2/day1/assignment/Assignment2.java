package week2.day1.assignment;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromeDriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.findElementById("email").sendKeys("sivalingam.gct14@gmail.com");
		String givenText = (driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input")).getText();
		String appendText = givenText.concat("Siva");
		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input").sendKeys(appendText);
		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input").sendKeys(Keys.TAB);
		String defaultText = (driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input")).getAttribute("value");
		System.out.println("DefaultText: "+defaultText);
		Thread.sleep(100);
		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input").clear();
		boolean enable = driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input").isEnabled();
		if(enable== true)
		{
			System.out.println("the text box is is not diabled");
		}
		else
		{
			System.out.println("The text box is disabled");
		}
		
		

	}

}
