package AdmissionModule;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalaryModule.Excelutils;

public class FinalizeAdmi {

	public void FinalizeAdmi1(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admission']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Finalize Admission']"))).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='New admission LS']"))).click();
		String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\Admission_Module.xlsx";
		int rows=Excelutils.getRowCount(filePath, "FinAdd");
		
		System.out.println(rows);
		
          for(int i=1; i<=rows;i++) {
//        	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
			System.out.println("row no. is "+i);
		
			//reading data from Excel
			String Name= Excelutils.getCellData(filePath, "FinAdd", i,0);
			String MonthName=Excelutils.getCellData(filePath, "FinAdd",i,1);
			String 	Date=Excelutils.getCellData(filePath, "FinAdd",i,2);
			String Pickuproute=Excelutils.getCellData(filePath, "FinAdd",i,3);
			String Pickupstop=Excelutils.getCellData(filePath, "FinAdd",i,4);
			String Droproute=Excelutils.getCellData(filePath, "FinAdd",i,5);
			String Dropstop=Excelutils.getCellData(filePath, "FinAdd",i,6);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-sm']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//input[@placeholder='Search Data']"))).clear();
		Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//input[@placeholder='Search Data']"))).sendKeys(Name);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='SearchPopupData()']"))).click();
			List<WebElement> results = driver.findElements(By.xpath("//input[@type='radio']"));
			if (results.isEmpty()) {
			    System.out.println("No result found for: " + Name + " at row " + i);
			    continue; // skip to next row in Excel
			}

			// Continue with rest if result found
			results.get(0).click();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='radio']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='...'])[2]"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='AllStops']"))).click();
			Thread.sleep(2000);
	 
			WebElement Datee=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GEE1750mdStartDate")));
			Datee.click();
			WebElement M=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//select[@class='ui-datepicker-month']")));
			M.sendKeys(MonthName);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//a[text()='" + Date + "']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//input[@id='GEE1750mdPickUPRoute']"))).sendKeys(Pickuproute);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//input[@id='GEE1750mdPickUPStop']"))).sendKeys(Pickupstop);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//input[@id='GEE1750mdDropRoute']"))).sendKeys(Droproute);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//input[@id='GEE1750mdDropStop']"))).sendKeys(Dropstop); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Back to Admission Qestion']"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add/Update']"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
			WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
				if(error.getText().contains("Successfully"))
				{
					System.out.println("Test Pass");
			    	 Excelutils.setCellData(filePath, "FinAdd",i,7,error.getText());
			    	 Excelutils.fillGreenColor(filePath, "FinAdd",i,7);
				
				}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Estimate']"))).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
			WebElement error1 = driver.findElement(By.xpath("//div[@role='alert']"));
				if(error1.getText().contains("generated"))
				{
					System.out.println("Test Pass");
			    	 Excelutils.setCellData(filePath, "FinAdd",i,8,error.getText());
			    	 Excelutils.fillGreenColor(filePath, "FinAdd",i,8);

				
				}
			WebElement T=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View Estimate']")));
			T.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='printCloseButton']"))).click();	
}
}}