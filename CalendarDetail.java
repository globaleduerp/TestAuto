package SalaryModule;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarDetail {
public void detail_cal(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='School Configuration']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Manage Calendar']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Calendar Detail']"))).click();
		String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\cal_master_data.xlsx";
		int rows=Excelutils.getRowCount(filePath, "Sheet1");
		
          for(int i=1; i<rows;i++) {
			System.out.println("row no. is "+i);
			//reading data from Excel
			String cal_name= Excelutils.getCellData(filePath, "Sheet1", i,0);
			String Start_date= Excelutils.getCellData(filePath, "Sheet1", i,1);
			String End_date=Excelutils.getCellData(filePath, "Sheet1",i,2);
			String cal_type=Excelutils.getCellData(filePath, "Sheet1",i,3);
			String Remark=Excelutils.getCellData(filePath, "Sheet1",i,4);
			
		
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Manage Calendar']"))).click();
		//WebElement calname= driver.findElement(By.id("id_undefined_calendarmaster_id"));
		//calname.click();
		//calname.sendKeys(cal_name);
		WebElement t=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_undefined_calendarmaster_id")));
		t.click();
		Thread.sleep(2000);
//		t1.sendKeys(cal_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+cal_name+"']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//input[@name='nm_undefined_startdate']")).sendKeys("08-03-2025");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='nm_undefined_startdate']")).sendKeys(Start_date);
		Thread.sleep(1000);
		driver.findElement(By.name("nm_undefined_enddate")).sendKeys(End_date);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='Calendar Type Name'][1]")).click();
		driver.findElement(By.xpath("//div[text()='"+cal_type+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='nm_undefined_remarks']")).sendKeys(Remark);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
		System.out.println(error.getText());
		
		if(error.getText().contains("Sucessfullly"))
		{
			System.out.println("Test Pass");
			Excelutils.setCellData(filePath, "Sheet1",i,5,"passed:");
	    	 Excelutils.setCellData(filePath, "Sheet1",i,6,error.getText());
	    	 Excelutils.fillGreenColor(filePath, "Sheet1",i,5);
	    //	 driver.findElement(By.xpath("//i[@class='fas fa-cog']")).click();
			//driver.findElement(By.xpath("//a[@id='submit']")).click();
		}
		else
//			 driver.findElement(By.xpath("//button[text()='Cancel']")).click();
			{System.out.println("test pass with error message");
   	 		Excelutils.setCellData(filePath, "Sheet1",i,5,"Pass with");
   	 	Excelutils.setCellData(filePath, "Sheet1",i,6,error.getText());
   	 Excelutils.fillGreenColor(filePath, "Sheet1",i,5);
   	 	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
     	 driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).click();
   	         Thread.sleep(5000);
   	 	     driver.findElement(By.xpath("//button[text()='Cancel']")).click();
   
			}
	}
          
}

private void highlight(WebDriver driver, WebElement element) {
	// TODO Auto-generated method stub
	
}

}
