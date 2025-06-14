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

public class AddEnquirySi {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		to loging in
		driver.get("http://ge-erp.com/Admin/Login");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("Bhumisaini@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("School@123");
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
        Thread.sleep(3000);
//    navigate to HR Module
		driver.findElement(By.xpath("//span[text()='Admission']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Add Enquiry'])[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
		WebElement Adhar_box=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_undefined_aadharno']")));
boolean isAdhMandatory = Adhar_box.getAttribute("required") != null;
		
		if (isAdhMandatory) {
			System.out.println("Adhar is mandatory."); 
				Adhar_box.sendKeys("456219035821");
				}
		else {
			System.out.println("Adhar is not mandatory."); 			
		Adhar_box.sendKeys("45621Ab35821");
		}
		
		String AdharValue = Adhar_box.getAttribute("value"); 
		if (AdharValue.matches("[0-9]+$"))
		{ 
			System.out.println("Adhar is numeric!"); 
			}
			else {
			System.out.println("Adhar is invalid as it contains non-numeric characters!");
			}
		if (AdharValue.matches("^\\d{12}$"))
		{
			System.out.println("Adhar has exactly 12 digits!"); 
			}
			else {
				System.out.println("Adhar does not have exactly 12 digits!"); 
				}
		Thread.sleep(2000);
	WebElement name= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_undefined_firstname']")));
	String nameInput = "Jo";  
          name.sendKeys(nameInput);
          System.out.println("Input sent:" + nameInput);
	boolean isnameMandatory = name.getAttribute("required") != null;
	
	if (isnameMandatory) {
		System.out.println("name is mandatory."); 
		}
	else {
		System.out.println("name is not mandatory."); 
	}
	String enteredName = name.getAttribute("value");
	if (enteredName.length() < 3) {
        System.out.println("Name must be at least 3 characters long.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", name);
    } else {
        System.out.println("Name is valid.");
    }
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Admission For Class']"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='II']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='nm_undefined_dob'])"))).sendKeys("10/08/2019");
		
JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement input = driver.findElement(By.xpath("//input[@name='nm_undefined_contactmobileno']"));
input.sendKeys("584953212");
String isValid = (String) js.executeScript("return arguments[0].validationMessage;");
System.out.println(isValid);	
 		Thread.sleep(2000);
 		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='ck-cash']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtCashAmount']"))).sendKeys("3000");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Collect Candidate Fee']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Print Receipt']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Print Receipt']"))).click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space(text())='Close'])[1]"))).click();
	}

	private static boolean isValidName(String nameInput) {
		// TODO Auto-generated method stub
		return false;
	}

}


