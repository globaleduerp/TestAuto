package TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllocateScreen {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		to loging in
		driver.get("http://ge-erp.com/Admin/Login");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("Bhumisaini@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("School@123");
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
	    Thread.sleep(3000);
	//navigate to HR Module
		driver.findElement(By.xpath("//span[text()='Transport']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Allocation Transport']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='AllStops']"))).click();
		Thread.sleep(2000);
		highlight(driver, driver.findElement(By.xpath("//th[text()='Select Pick UP']")));
		highlight(driver, driver.findElement(By.xpath("//table[@id='tblroutstopdetails']/tbody/tr[1]/td[7]")));
		WebElement W=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
				("(//label[@class='custom-control-label'])[2]")));
		W.click();
		
		
	}

	private static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:5px solid black; background:Green')", element);
	}

}
