package SalaryModule;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpSalary {

	public void EmpSalary1(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
//        WebDriver driver = new ChromeDriver();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//		driver.get("http://ge-erp.com/Admin/Login/Index");
//		driver.findElement(By.id("txtEmail")).sendKeys("Bhumisaini@gmail.com");
//	    driver.findElement(By.id("txtPassword")).sendKeys("School@123");
//	    driver.findElement(By.xpath(" //button[text()='Login']")).click();  
//	  //button[text()='Login']
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//span[text()='HR Module']")).click();
//	    Thread.sleep(2000);
	     driver.findElement(By.xpath("//a[text()='Employee Leave Management']")).click();
	     driver.findElement(By.xpath("//a[text()='Employee Salary']")).click();


		String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\cal_master_data.xlsx";
		int rows=Excelutils.getRowCount(filePath, "Emp Salary");
		
		for(int i=1;i<=rows;i++)
			
		{
			//read data form excel
		
			String Search=Excelutils.getCellData(filePath, "Emp Salary",i,0);
//			String Startdate=Excelutils.getCellData(filePath, "Sheet1",i,1);
//			String Enddate=Excelutils.getCellData(filePath, "Sheet1",i,2);
			String MonthlySal=Excelutils.getCellData(filePath, "Emp Salary",i,1);
			String LWP=Excelutils.getCellData(filePath, "Emp Salary",i,2);
			
//			pass above data into application
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='search table']"))).clear();
				Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-12 border-left p-3 bg-light']"))).click();
				
				Thread.sleep(2000);
//				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='search table']"))).sendKeys(Search);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-12 border-left p-3 bg-light']"))).click();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_-1_startdate']"))).sendKeys(Startdate);	
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_-1_enddate']"))).sendKeys(Enddate);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_-1_monthlysalary']"))).clear();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_-1_monthlysalary']"))).sendKeys(MonthlySal);
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_-1_lwp_deductionperday']"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_-1_lwp_deductionperday']"))).sendKeys(LWP);
 			 Thread.sleep(1000);
 		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[2]"))).click();
 			Thread.sleep(1000);
             System.out.println("Search emp");
            
             // Wait for toast message to appear
	    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
				WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
				System.out.println(error.getText());
				Excelutils.setCellData(filePath, "Emp Salary",i,4,error.getText());
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='search table']"))).clear();
//				Thread.sleep(2000);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_-1_monthlysalary']"))).clear();
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_-1_lwp_deductionperday']"))).clear();
		}
	}

}