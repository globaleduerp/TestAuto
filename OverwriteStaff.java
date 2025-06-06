package SalaryModule;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Test for version
public class OverwriteStaff {

public void OverwriteStaff1(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//		driver.get("http://ge-erp.com/Admin/Login/Index");
//		driver.findElement(By.id("txtEmail")).sendKeys("Bhumisaini@gmail.com");
//	    driver.findElement(By.id("txtPassword")).sendKeys("School@123");
//	    driver.findElement(By.xpath(" //button[text()='Login']")).click();  
//	  //button[text()='Login']
//	    driver.findElement(By.xpath("//span[text()='HR Module']")).click();
	     driver.findElement(By.xpath("//a[text()='Employee Leave Management']")).click();
	     driver.findElement(By.xpath("//a[normalize-space()='Overwrite Staff Attendance']")).click();
//	     driver.findElement(By.xpath("//a[text()='Employee Leave Management']")).click();
	     Thread.sleep(2000);
//	     driver.findElement(By.xpath(" //button[normalize-space()='Add']")).click();

		String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\cal_master_data.xlsx";
		int rows=Excelutils.getRowCount(filePath, "Overwrite Attendance");
		
		for(int i=1;i<=rows;i++)
		{
			//read data form excel
			String Date=Excelutils.getCellData(filePath, "Overwrite Attendance",i,0);
			String Employee=Excelutils.getCellData(filePath, "Overwrite Attendance",i,1);
			String RevisedDayStatus=Excelutils.getCellData(filePath, "Overwrite Attendance",i,2 );
			String RevisedRemarks=Excelutils.getCellData(filePath, "Overwrite Attendance",i,3);
			
//			pass above data into application
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='search table']"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_undefined_attendancedate']"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_undefined_attendancedate']"))).sendKeys(Date); 
//			  driver.findElement(By.xpath("//input[@placeholder='search table']")).clear();
//			  driver.findElement(By.xpath("//div[@id='id_undefined_empmaster_id']")).click();
//			  driver.findElement(By.xpath("(//span[text()='Clear'])")).click();  
//			  Thread.sleep(1000);
//			  WebElement element1=driver.findElement(By.xpath("//div[@id='id_undefined_empmaster_id']"));
//			  element1.click();
////			  element1.sendKeys(Employee);
//			  
//			  System.out.println("Print");
			WebElement element1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='search table']")));
			element1.sendKeys("\b".repeat(element1.getAttribute("value").length()));
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='search table']"))).sendKeys(Employee);
//			  driver.findElement(By.xpath("//input[@placeholder='search table']")).clear();
			
//			  driver.findElement(By.xpath("//div[normalize-space(text())='" + Employee + "']")).click();   
//			  driver.findElement(By.xpath("//div[@id='id_-1_reviseddaystatus_id']")).click();
//			  driver.findElement(By.xpath("(//span[text()='Clear'])[2]")).click();
//			  driver.findElement(By.xpath("//div[@id='id_-1_reviseddaystatus_id']")).click();
			 WebElement B1= driver.findElement(By.xpath("(//div[@class='dx-lookup-field-wrapper'])[3]"));
			 B1.click();
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='textbox']"))).click();
//			  .sendKeys(RevisedDayStatus);
			  Thread.sleep(2000);
//			  System.out.println("Status");
			 WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='" + RevisedDayStatus + "']")));
			 element.click();    
			 WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@placeholder='Revised Remarks'])[2]")));

			 textArea.sendKeys("\b".repeat(textArea.getAttribute("value").length()));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@placeholder='Revised Remarks'])[2]"))).sendKeys(RevisedRemarks); 

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])"))).click();
		     System.out.println("Date save");
		     
			//validation 
		     Thread.sleep(2000);

		 		    // Wait for toast message to appear
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
				WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
				
				System.out.println(error.getText());
				Thread.sleep(2000);
//				WebElement textArea = driver.findElement(By.xpath("(//textarea[@placeholder='Revised Remarks'])[2]"));
//
//				 textArea.sendKeys("\b".repeat(textArea.getAttribute("value").length()));
			
				if(error.getText().contains("Sucessfullly"))

		     {
		    	 System.out.println("Test Pass");
		    	 Excelutils.setCellData(filePath, "Overwrite Attendance",i,6,"Passed");
		    	 Excelutils.setCellData(filePath, "Overwrite Attendance",i,5,error.getText());
		    	 Excelutils.fillGreenColor(filePath, "Overwrite Attendance",i,5);
		     }

}
	}
}
