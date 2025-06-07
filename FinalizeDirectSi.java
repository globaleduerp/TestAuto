package AdmissionModule;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalizeDirectSi {
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
//	to loging in
	driver.get("http://ge-erp.com/Admin/Login");
	driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("Bhumisaini@gmail.com");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("School@123");
	driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
    Thread.sleep(3000);
//navigate to HR Module
	driver.findElement(By.xpath("//span[text()='Admission']")).click();
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Finalize Admission']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-sm']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//input[@placeholder='Search Data']"))).clear();
Thread.sleep(5000);
Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//input[@placeholder='Search Data']"))).sendKeys("CHANCHAL");
	System.out.println("dummyyy");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='SearchPopupData()']"))).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='radio']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='...'])[2]"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='AllStops']"))).click();
	Thread.sleep(2000);
	highlight(driver, driver.findElement(By.xpath("//th[text()='Select Pick UP']")));
	WebElement Date=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GEE1750mdStartDate")));
	Date.click();
	WebElement M=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//select[@class='ui-datepicker-month']")));
	M.sendKeys("Aug");
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//a[text()='10']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//input[@id='GEE1750mdPickUPRoute']"))).sendKeys("Balkeshwar");
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//input[@id='GEE1750mdPickUPStop']"))).sendKeys("Balkeshwar");
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//input[@id='GEE1750mdDropRoute']"))).sendKeys("Balkeshwar");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			("//input[@id='GEE1750mdDropStop']"))).sendKeys("Balkeshwar"); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Back to Admission Qestion']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Save ']"))).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Estimate']"))).click();
	Thread.sleep(5000);
	WebElement T=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View Estimate']")));
	T.click();
	}

	private static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:5px solid black; background:Green')", element);
	}

}
