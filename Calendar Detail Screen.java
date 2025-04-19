package datadriventest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cal_detail {
public void detail_cal(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='School Configuration']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Manage Calendar']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Calendar Detail']"))).click();
		String filePath="C:\\Users\\formu\\eclipse-workspace\\automation\\src\\test\\java\\datadriventest\\cal_master_data.xlsx";
		int rows=excelutils.getRowCount(filePath, "Sheet1");
		
          for(int i=1; i<=rows;i++) {
			
			//reading data from Excel
			String cal_name= excelutils.getCellData(filePath, "Sheet1", i,0);
			String Start_date= excelutils.getCellData(filePath, "Sheet1", i,1);
			String End_date=excelutils.getCellData(filePath, "Sheet1",i,2);
			String cal_type=excelutils.getCellData(filePath, "Sheet1",i,3);
			String Remark=excelutils.getCellData(filePath, "Sheet1",i,4);
			
		
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Manage Calendar']"))).click();
		//WebElement calname= driver.findElement(By.id("id_undefined_calendarmaster_id"));
		//calname.click();
		//calname.sendKeys(cal_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_undefined_calendarmaster_id"))).click();
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
	    	 excelutils.setCellData(filePath, "Sheet1",i,5,"passed:");
	    	 excelutils.setCellData(filePath, "Sheet1",i,6,error.getText());
	    	 excelutils.fillGreenColor(filePath, "Sheet1",i,5);
	    //	 driver.findElement(By.xpath("//i[@class='fas fa-cog']")).click();
			//driver.findElement(By.xpath("//a[@id='submit']")).click();
		}
		else
			{System.out.println("test pass with error message");
   	 		excelutils.setCellData(filePath, "Sheet1",i,5,"Pass with");
   	 	excelutils.setCellData(filePath, "Sheet1",i,6,error.getText());
   	 	     excelutils.fillGreenColor(filePath, "Sheet1",i,5);
   	 	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--error']")));
     	// driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--error']")).click();
   	         //Thread.sleep(5000);
   	 	    // driver.findElement(By.xpath("//button[text()='Cancel']")).click();
   
			}
	}
          Thread.sleep(5000);
}

}
