package SalaryModule;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendarmaster {

	 public void add_master (WebDriver driver, WebDriverWait Wait) throws IOException, InterruptedException {
//		     driver.get("https://ge-erp.com/Reports/AdmissionReport/AdmissionReportView");
//		     driver.findElement(By.xpath("//a[@class='btn btn-sm btn-dark']")).click();  
		 driver.findElement(By.xpath("//i[@class='fas fa-bars']")).click(); 
		 driver.findElement(By.xpath("//span[text()='School Configuration']")).click();
	     driver.findElement(By.xpath("//a[text()='Manage Calendar']")).click();
	     System.out.println("hello this is working");
		 driver.findElement(By.xpath("//a[text() ='Calendar Master'][1]")).click();		
	     Thread.sleep(5000);
		 
		String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\cal_master_data.xlsx";
		int rows=Excelutils.getRowCount(filePath, "Sheet2");
		System.out.println(rows);
		for(int i=1; i<rows;i++) {
			
			//reading data from Excel
			String code= Excelutils.getCellData(filePath, "Sheet2", i,0);
			String name= Excelutils.getCellData(filePath, "Sheet2", i,1);
			String usertype=Excelutils.getCellData(filePath, "Sheet2",i,2);
			String remarks=Excelutils.getCellData(filePath, "Sheet2",i,3);
			String weekoff=Excelutils.getCellData(filePath, "Sheet2",i,4);
//			String def=Excelutils.getCellData(filePath, "Sheet2",i,5);
			
		
			
			//passing data into cal master for add
			
	    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_undefined_code"))).sendKeys(code);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nm_undefined_calendarname"))).sendKeys(name);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dx-lookup-field' and @tabindex='0'][1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+usertype+"']"))).click();
		Thread.sleep(1000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_undefined_remarks"))).sendKeys(remarks);
		Thread.sleep(1000);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='select weekoff Type']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+weekoff+"']"))).click();
		Thread.sleep(1000);
		
			driver.findElement(By.id("id_undefined_isdefault")).click();
	
			 
	    
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	//validation
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
	System.out.println(error.getText());
		
		//String error=driver.findElement(By.xpath("//div[@id='root']")).getText();
		if(error.getText().contains("Sucessfullly"))
		{
			System.out.println("Test Pass");
			Excelutils.setCellData(filePath, "Sheet2",i,6,"Passed");
			Excelutils.setCellData(filePath, "Sheet2",i,8,error.getText());
			Excelutils.fillGreenColor(filePath, "Sheet2",i,6);
	    //	 driver.findElement(By.xpath("//i[@class='fas fa-cog']")).click();
			//driver.findElement(By.xpath("//a[@id='submit']")).click();
		}
		else
			{System.out.println("test pass");
			Excelutils.setCellData(filePath, "Sheet2",i,6,"Pass with existing data");
			Excelutils.setCellData(filePath, "Sheet2",i,8,error.getText());
			Excelutils.fillGreenColor(filePath, "Sheet2",i,6);
   	 	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Toastify_close-button Toastify_close-button--error']")));
     	// driver.findElement(By.xpath("//button[@class='Toastify_close-button Toastify_close-button--error']")).click();
   	       Thread.sleep(3000);
   	 	     driver.findElement(By.xpath("//button[text()='Cancel']")).click();
   
			}
		Thread.sleep(1000);
		}
		

		
	}

}