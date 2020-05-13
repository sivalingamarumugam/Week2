package week2.day2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithCheckBoxes {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
//		WebElement kkkk = driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::div)[2]/input"));
//		kkkk.click();
//		System.out.println(kkkk.getText());
		InteractWithCheckBoxes obj = new InteractWithCheckBoxes();
		obj.knownLanguages(driver);
		obj.deSelectCheckedBox(driver);
		obj.selectAllCheckBoxes(driver);
		
	}
	public void knownLanguages(WebDriver driver) 
	{
		String[] knownLanguages= {"Java","VB","SQL"};
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//label[text()='Select the languages that you know?']/following::div"));
	//	System.out.println(checkBoxes.size());
		for(int i=1;i<=checkBoxes.size();i++) 
		{
			String xpath="(//label[text()='Select the languages that you know?']/following::div)["+i+"]";
//			System.out.println(xpath);
			WebElement checkboxText = driver.findElement(By.xpath(xpath));
			String xpath2 = "("+xpath+")/input";
//			System.out.println(xpath2);
			
//			System.out.println(checkboxText.getText());
		
		for(int j=0;j<knownLanguages.length;j++)
		{
			
			if(checkboxText.getText().equals(knownLanguages[j]))
			{
				driver.findElement(By.xpath(xpath2)).click();
				System.out.println(checkboxText.getText()+" language is checked");
			}
		}
		
		if(checkboxText.getText().equals("Selenium"))
		{
			boolean selenium = driver.findElement(By.xpath(xpath2)).isSelected();
			if(selenium==true) {
				System.out.println("Selenium is checked already");
			}
			else
			{
				System.out.println("Selenium is not checked already");
			}
		}	
		
		}
		
	}
    
	public void deSelectCheckedBox(WebDriver driver) {
		List<WebElement> deselect = driver.findElements(By.xpath("//div[@class='example'][3]//input"));
		for(int i = 0;i<deselect.size();i++) 
		{
			
			if(deselect.get(i).isSelected()==true)
			{
				deselect.get(i).click();
			}
		}
	}
    public void selectAllCheckBoxes(WebDriver driver) 
    {
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class='example'][4]//input"));
    	for(int i=0;i<list.size();i++)
    	{
    		if(!list.get(i).isSelected())
    			list.get(i).click();
    	}
    	
    }

}
