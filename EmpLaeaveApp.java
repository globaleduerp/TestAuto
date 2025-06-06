package SalaryModule;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpLaeaveApp {

	public void emp_application(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
       /* WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://ge-erp.com/Admin/Login/Index");
		driver.findElement(By.id("txtEmail")).sendKeys("Bhumisaini@gmail.com");
	    driver.findElement(By.id("txtPassword")).sendKeys("School@123");
	    driver.findElement(By.xpath(" //button[text()='Login']")).click();  
	  //button[text()='Login']*/
	   driver.findElement(By.xpath("//span[text()='HR Module']")).click();
	     driver.findElement(By.xpath("//a[text()='Employee Leave Management']")).click();
	     driver.findElement(By.xpath("//a[text()='Employee Leave Application']")).click();
//	     driver.findElement(By.xpath("//a[text()='Employee Leave Management']")).click();
	     Thread.sleep(2000);
//	     driver.findElement(By.xpath(" //button[normalize-space()='Add']")).click();

		String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\cal_master_data.xlsx";
		int rows=Excelutils.getRowCount(filePath, "Emp Application");
		System.out.println(rows);
		int a=12;
		for(int i=1;i<=rows;i++)
			
		{
			//read data form excel
			String Employee=Excelutils.getCellData(filePath, "Emp Application",i,0);
			String LeaveType=Excelutils.getCellData(filePath, "Emp Application",i,1);
			String FromDate=Excelutils.getCellData(filePath, "Emp Application",i,2);
			String ToDate=Excelutils.getCellData(filePath, "Emp Application",i,3);
			
//			String exresult=Excelutils.getCellData(filePath, "Sheet1",i,2);
//			pass above data into application
			 driver.findElement(By.xpath(" //button[normalize-space()='Add']")).click();
			 Thread.sleep(1000);
 			 driver.findElement(By.xpath("//div[contains(text(),'Employee')]")).click();
 			Thread.sleep(1000);
 			//div[@class='dx-lookup-search-wrapper']
 			
 			//driver.findElement(By.xpath("//div[@class='dx-lookup-search dx-show-invalid-badge dx-textbox dx-texteditor dx-show-clear-button dx-editor-outlined dx-searchbox dx-widget dx-texteditor-empty dx-state-hover dx-state-focused']//input[@role='textbox']")).sendKeys(Employee);
 			//driver.findElement(By.xpath("//div[@class='dx-lookup-search-wrapper']")).sendKeys(Employee); 
 			//(//input[@role='textbox'])[10]
 			
 			if (a==12)
 					{
			 driver.findElement(By.xpath("(//input[@class='dx-texteditor-input'])[12]")).sendKeys(Employee); 
 				//driver.findElement(By.xpath("(//input[@role='textbox'])[10]")).sendKeys(Employee); 
 				a=a+1;
 					}
 			else
 			{
				 driver.findElement(By.xpath("(//input[@class='dx-texteditor-input'])[14]")).sendKeys(Employee); 
    					}
			 Thread.sleep(3000);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='" + Employee + "']"))).click(); 
			
			//  driver.findElement(By.xpath("(//div[text()='Leave Type'])")).click();
			  driver.findElement(By.xpath("(//div[text()='Leave Type'])[1]")).sendKeys(LeaveType);
			  driver.findElement(By.xpath("//div[normalize-space(text())='" + LeaveType + "']")).click(); 
			  
			  driver.findElement(By.xpath("(//input[@name='nm_undefined_fromdate'])")).sendKeys(FromDate);
//			  driver.findElement(By.xpath("(//input[@role='textbox'])[11]")).sendKeys(Employee); 
			 
			  driver.findElement(By.xpath("(//input[@name='nm_undefined_todate'])")).sendKeys(ToDate);
	             driver.findElement(By.xpath("//div[@id='id_undefined_leaveduration_id']")).click();
	             driver.findElement(By.xpath("//div[text()='Full Day']")).click();
				     driver.findElement(By.xpath("(//button[text()='Save'])")).click();
//			     driver.findElement(By.xpath("(//button[text()='Save'])")).click();
			     System.out.println("Date save");
				//validation 
			     


			     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
					WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
				    System.out.println(error.getText());
					
					if(error.getText().contains("Sucessfullly"))

		     {
		    	 System.out.println("Test PAss");
		    	 Excelutils.setCellData(filePath, "Emp Application",i,6,error.getText());
		    	// excelutils.fillGreenColor(filePath, "Emp Application",i,5,error.getText());
		    	 
		    	
		     }

		 		    else
		 		    	
		     {
		    	 
		    	 System.out.println("Test done ");
		    	 Excelutils.setCellData(filePath, "Emp Application",i,6, error.getText());
		    	 //excelutils.fillRedColor(filePath, "Emp Application",i,5,error.getText()); 
		    	 Thread.sleep(2000);
		    	 driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		     
		     }
					Thread.sleep(2000);
		    
		}

		
	}

}