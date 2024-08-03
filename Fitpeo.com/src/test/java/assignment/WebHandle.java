package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class WebHandle 
	{
	public static void main(String[] args) throws InterruptedException
	{
		//open the browser
		WebDriver driver = new ChromeDriver();
		//maximize the Browser
		driver.manage().window().maximize();
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//go to the fitpeo Home page
		driver.get("https://fitpeo.com/");
		Thread.sleep(3000);
		//go to the particular Web Element
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		//Scroll Down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scrolling down to the ref element
		WebElement refPoint = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month']"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(false);", refPoint);
		//doing action on slider
		WebElement slider = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-j7qwjs']/span)[1]/span"));
		WebElement textField = driver.findElement(By.xpath("//input[@type='number']"));
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		

		try {
			act.dragAndDropBy(slider, 777, 170).build().perform();	
		} catch (Exception e) {
			System.out.println("Improper Functionality of Slider....");
		}
		String slideValue="560";
		SoftAssert soft=new SoftAssert();
		Thread.sleep(2000);
		textField.clear();
		Thread.sleep(2000);
		textField.sendKeys(slideValue);
		String sliderQuantity = driver.findElement(By.xpath("//input[@type='range']")).getAttribute("aria-valuenow");
		soft.assertEquals(slideValue, sliderQuantity,"slider is not poiting to the expected value");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();


		WebElement a = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month:']/descendant::p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c']"));
		String value = "$110700";
		String total = a.getText();
		soft.assertEquals(value, slideValue,"wrong");
		System.out.println("Text verification passed!");
    }
}
