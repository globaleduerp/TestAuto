package AdmissionModule;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calling_AdmissionModuleTest {
		 WebDriver driver;
		    WebDriverWait wait;

		    @BeforeClass
		    void setup() {
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();  // Create WebDriver instance
		        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		        driver.manage().window().maximize();
		        driver.get("https://ge-erp.com/Admin/Login");
		    }

		 
		    void openapp() {
		        driver.findElement(By.id("txtEmail")).sendKeys("Bhumisaini@gmail.com");
		        driver.findElement(By.id("txtPassword")).sendKeys("School@123");
		        driver.findElement(By.id("btnLogin")).click();
		        
		    }

		   
		    @Test
		    void testlogin() throws InterruptedException, IOException {
		        openapp(); //login
		       
		        System.out.println("Logged In");
//		       Thread.sleep(3000);
//		       DirectRegistration R1=new DirectRegistration();
//		       R1.DirectRegistration1(driver, wait);
		       
		       Thread.sleep(3000);
		       FinalizeAdmi R2=new FinalizeAdmi();
		       R2.FinalizeAdmi1(driver, wait);
		       
		       
		       
		       
}
}