package SalaryModule;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaffMappingScreen {
	public void staff (WebDriver driver, WebDriverWait wait) throws IOException, InterruptedException  {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Manage Calendar']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Map Calendar to Staff']"))).click();
		String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\cal_master_data.xlsx";
		int rows=Excelutils.getRowCount(filePath, "Sheet3");
		
          for(int i=1; i<=rows;i++) {
			
			//reading data from Excel
			String emp_name= Excelutils.getCellData(filePath, "Sheet3", i,0);
			String cal_name= Excelutils.getCellData(filePath, "Sheet3", i,1);
			//String End_date=excelutils.getCellData(filePath, "Sheet1",i,2);
			//String cal_type=excelutils.getCellData(filePath, "Sheet1",i,3);
			//String Remark=excelutils.getCellData(filePath, "Sheet1",i,4);
         //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Manage Calendar']"))).click();
		//WebElement calname= driver.findElement(By.id("id_undefined_calendarmaster_id"));
		//calname.click();
		//calname.sendKeys(cal_name);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_undefined_calendarmaster_id"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gridTable\"]/thead[1]/tr/th[2]/input"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gridTable\"]/thead[1]/tr/th[2]/input"))).sendKeys(emp_name);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='combobox'])[2]"))).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='dx-texteditor-input']"))).sendKeys(cal_name);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+cal_name+"']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']"))).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//input[@name='nm_undefined_startdate']")).sendKeys("08-03-2025");
		//Thread.sleep(2000);

		/*Thread.sleep(1000);
		driver.findElement(By.name("nm_undefined_enddate")).sendKeys(End_date);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='Calendar Type Name'][1]")).click();
		driver.findElement(By.xpath("//div[text()='"+cal_type+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='nm_undefined_remarks']")).sendKeys(Remark);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
		System.out.println(error.getText());
		
		if(error.getText().contains("Sucessfullly"))
		{
			System.out.println("Test Pass");
			Excelutils.setCellData(filePath, "Sheet3",i,2,"Passed");
			Excelutils.setCellData(filePath, "Sheet3",i,4,error.getText());
			Excelutils.fillGreenColor(filePath, "Sheet3",i,4);
	    //	 driver.findElement(By.xpath("//i[@class='fas fa-cog']")).click();
			//driver.findElement(By.xpath("//a[@id='submit']")).click();
		}
		else
			{System.out.println("test pass with error message");
			Excelutils.setCellData(filePath, "Sheet3",i,2,"Pass with");
			Excelutils.setCellData(filePath, "Sheet3",i,4,error.getText());
			Excelutils.fillGreenColor(filePath, "Sheet3",i,4);
   	 	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--error']")));
     	// driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--error']")).click();
   	         //Thread.sleep(5000);
   	 	    // driver.findElement(By.xpath("//button[text()='Cancel']")).click();
   
			}
	}
          Thread.sleep(5000);
}

}

