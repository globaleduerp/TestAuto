package datadriventest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import csvpackage.leaveapproval;
import io.github.bonigarcia.wdm.WebDriverManager;

public class cal_master_test_ng {
	 WebDriver driver;
	    WebDriverWait wait1;

	    @BeforeClass
	    void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();  // Create WebDriver instance
	        wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        driver.manage().window().maximize();
	        driver.get("https://ge-erp.com/Admin/Login");
	    }

	 
	    void openapp() {
	        driver.findElement(By.id("txtEmail")).sendKeys("Umang@gmail.com");
	        driver.findElement(By.id("txtPassword")).sendKeys("School@123");
	        driver.findElement(By.id("btnLogin")).click();
	        
	    }

	   
	    @Test
	    void testlogin() throws InterruptedException, IOException {
	        openapp(); //login
	       
	        System.out.println("Logged In");
	       Thread.sleep(3000);
	        cal_mast mast= new cal_mast();
	      mast.add_master(driver, wait1);
	     
	        Thread.sleep(3000);
	       cal_detail detail= new cal_detail();
	       detail.detail_cal(driver, wait1);
	       
	       Thread.sleep(3000);
	       staff_map s1=new staff_map();
	       s1.staff(driver, wait1);
	       
	       //Thread.sleep(3000);
	      // report s2=new report();
	    //   s2.Rept(driver, wait1);
	       
	        /*Thread.sleep(5000);
	        calender_detail ca=new calender_detail();
	        ca.detail_cal(driver, wait1);
	        Thread.sleep(5000);
	        driver.findElement(By.id("show-sidebar")).click();
	        Thread.sleep(5000);
	        s1 Leave = new s1();
	        Leave.EmpLeaveAllowance(driver, wait1);  
	        Thread.sleep(10000);
	        emp_leave_application app= new emp_leave_application();
	        app.application(driver, wait1);
	        Thread.sleep(5000);
	        emp_leave_approv leave1=new emp_leave_approv();
	        leave1.leavapp(driver,wait1);*/
	    }

}
