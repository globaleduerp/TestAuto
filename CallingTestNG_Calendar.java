package SalaryModule;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CallingTestNG_Calendar {
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
//	       
//	        System.out.println("Logged In");
//	       Thread.sleep(3000);
//	       Before_Report R1=new Before_Report();
//	       R1.Before_Report1(driver, wait);
//	       
//	       Thread.sleep(3000);
//	       Calendarmaster mast= new Calendarmaster();
//	      mast.add_master(driver, wait);       
//	     
//	        Thread.sleep(3000);
//	        CalendarDetail detail= new CalendarDetail();
//	       detail.detail_cal(driver, wait);
//	       
//	       Thread.sleep(3000);
//	       StaffMappingScreen s1=new StaffMappingScreen();
//	       s1.staff(driver, wait);
//	       
//	       Thread.sleep(3000);
//	       EmpLeaveAllo S2 = new EmpLeaveAllo();
//	       S2.EmpLeaveAllo1(driver, wait);
//	       
	       Thread.sleep(3000);
	       EmpLaeaveApp S3 = new EmpLaeaveApp();
           S3.emp_application(driver, wait);
           
	       Thread.sleep(3000);
	       EmployeeApproval S4=new EmployeeApproval();
	       S4.EmployeeApproval1(driver,wait);
////	       
	       Thread.sleep(3000);
	       EmpSalary S5=new EmpSalary();
	       S5.EmpSalary1(driver, wait);
	       
	       Thread.sleep(3000);
	       OverwriteStaff S6=new OverwriteStaff();
	       S6.OverwriteStaff1(driver, wait);
	       
	      
	       
	       Thread.sleep(2000);
	       
	       
	       Thread.sleep(2000);
	       Re_report R3= new Re_report();
	       R3.Re_report1(driver, wait);
//	       driver.close();
//	       
//	       Thread.sleep(2000);
//	       Report R2=new Report();
//	       R2.Report1(driver, wait);
	    }

}