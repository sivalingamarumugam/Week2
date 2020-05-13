package week2.day2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlayWithRadioButtons {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		driver.findElement(By.xpath("//label[@for='yes']")).click();
		//label[text()='Find default selected radio button']/parent::div
		WebElement radioBtn1 = driver.findElement(By.xpath("//label[@for='Unchecked']"));
		WebElement radioBtn2 = driver.findElement(By.xpath("//label[@for='Checked']"));		
		if(radioBtn1.isSelected()) 
		{
			System.out.println("The default selected: "+radioBtn1.getText());
		}
		else
		{
			System.out.println("The default selected: "+radioBtn2.getText());
		}
		int age =20;
		
		if(1<=age && age<=20) 
		{
			WebElement radiobtn1 = driver.findElement(By.xpath("//input[@name='age'][1]"));
			if(radiobtn1.isSelected()!=true)
				radiobtn1.click();
		}
		else if(21<=age && age<=40) 
		{
			WebElement radiobtn2 = driver.findElement(By.xpath("//input[@name='age'][2]"));
			if(radiobtn2.isSelected()!=true)
			radiobtn2.click();
		}
		else if(41<=age && age<=60)
		{
			WebElement radiobtn3 = driver.findElement(By.xpath("//input[@name='age'][3]"));
			if(radiobtn3.isSelected()!=true)
			radiobtn3.click();
		}
		
}
}