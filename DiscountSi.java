package TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiscountSi {
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
//			to loging in
			driver.get("http://ge-erp.com/Admin/Login");
			driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("Bhumisaini@gmail.com");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("School@123");
			driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
	        Thread.sleep(3000);
//	    navigate to HR Module
			driver.findElement(By.xpath("//span[text()='Fee Management']")).click();
			driver.findElement(By.xpath("//a[text()='Manage Discounts']")).click();
			driver.findElement(By.xpath("//a[text()='Fee Discount User Mapping']")).click();
			
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='User Type ']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Student']"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select User']"))).sendKeys("Kashish testing");;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@role='textbox'])[9]"))).sendKeys("4678");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='4678 AJAY '])"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='ck-cash']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtCashAmount']"))).sendKeys("3000");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Collect Candidate Fee']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Print Receipt']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Print Receipt']"))).click();
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space(text())='Close'])[1]"))).click();
		}

	}

