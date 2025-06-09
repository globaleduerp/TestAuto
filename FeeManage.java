package AdmissionModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import SalaryModule.Excelutils;

public class FeeManage {

		public void FeeManage1(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fas fa-bars']"))).click();	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Fee Management']"))).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Collect Fee']"))).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='New admission LS']"))).click();
			String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\Admission_Module.xlsx";
			int rows=Excelutils.getRowCount(filePath, "FeeMgmt");
			
			System.out.println(rows);
			
	          for(int i=1; i<=rows;i++) {
				System.out.println("row no. is "+i);
				
				//reading data from Excel
				String name= Excelutils.getCellData(filePath, "FeeMgmt", i,0);
				String Amount= Excelutils.getCellData(filePath, "FeeMgmt", i,1);

WebElement t=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-search']")));
t.click();		 
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search Data']"))).sendKeys(name);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='mybtn']"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='radio'])[3]"))).click();
		WebElement G= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
		G.click(); 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='ck-cash']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtCashAmount']"))).sendKeys(Amount);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Collect Candidate Fee']"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
			if(error.getText().contains("Successfully"))
			{
				System.out.println("Test Pass");
		    	 Excelutils.setCellData(filePath, "FeeMgmt",i,3,error.getText());
		    	 Excelutils.fillGreenColor(filePath, "FeeMgmt",i,3);
			
			}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Print Receipt']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Print Receipt']"))).click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space(text())='Close'])[1]"))).click();
	          }

	}

}
