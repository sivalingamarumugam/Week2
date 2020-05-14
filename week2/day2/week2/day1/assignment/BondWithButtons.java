package week2.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BondWithButtons {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();		
		Point locator = driver.findElement(By.xpath("//button[@id='position']")).getLocation();
		System.out.println(locator);
		String color = driver.findElement(By.xpath("//button[@style='background-color:lightgreen']")).getCssValue("background-color");
		System.out.println("color of the button: "+color);
		Dimension size = driver.findElement(By.xpath("//button[@id='size']")).getSize();
		System.out.println("height and Size of the button" + size);
		
		

	}

}
