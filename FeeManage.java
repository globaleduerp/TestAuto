package AdmissionModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import SalaryModule.Excelutils;

public class FeeManage {

		public void DirectRegistration1(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admission']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Direct Registration']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='New admission LS']"))).click();
			String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\Admission_Module.xlsx";
			int rows=Excelutils.getRowCount(filePath, "DirectRegistration");
			
			System.out.println(rows);
			
	          for(int i=1; i<=rows;i++) {
//	        	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
				System.out.println("row no. is "+i);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
						("//input[@name='nm_undefined_enquiryforsessionyear_id']"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
						("//div[text()='2025-2026           ']"))).click();			
	  System.out.println("Sessionyear");
				
				//reading data from Excel
				String Class= Excelutils.getCellData(filePath, "DirectRegistration", i,0);
				String Name= Excelutils.getCellData(filePath, "DirectRegistration", i,1);
				String DOB=Excelutils.getCellData(filePath, "DirectRegistration",i,2);
				String CNo=Excelutils.getCellData(filePath, "DirectRegistration",i,3);
				String Gender=Excelutils.getCellData(filePath, "DirectRegistration",i,4);
				String EMAIL=Excelutils.getCellData(filePath, "DirectRegistration",i,5);
				String AdharNo=Excelutils.getCellData(filePath, "DirectRegistration",i,6);
				String FatherName=Excelutils.getCellData(filePath, "DirectRegistration",i,7);
				String MotherName=Excelutils.getCellData(filePath, "DirectRegistration",i,8);
				String CorespondanceAddress=Excelutils.getCellData(filePath, "DirectRegistration",i,9);
				String PermanentAddress=Excelutils.getCellData(filePath, "DirectRegistration",i,10);
				String Pincode=Excelutils.getCellData(filePath, "DirectRegistration",i,11);
				System.out.println("Hello");

	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nm_undefined_enquiryforsessionyear_id']"))).click();
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='2025-2026           ']"))).click();

		 WebElement t=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Admission For Class']")));
		 t.click();
		 t.sendKeys(Class);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Class+"']"))).click();
		boolean isClassMandatory = t.getAttribute("required") == null;
			System.out.println(isClassMandatory);
			if (Class == null || Class.trim().isEmpty()) {
				System.out.println("Class is mandatory."); 
		
			}
			else {
				System.out.println("Class is not mandatory."); 
				}
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Class+"']"))).click();
		WebElement n= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_undefined_firstname']")));
		n.sendKeys(Name);
		 boolean isNameMandatory = n.getAttribute("required") == null;
			System.out.println(isNameMandatory);
			if (Name == null || Name.trim().isEmpty()) {
				System.out.println("Name is mandatory."); 

			}
			else {
				System.out.println("Name is not mandatory."); 
				}
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_undefined_dob']"))).sendKeys(DOB);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_undefined_contactmobileno']"))).sendKeys(CNo);
		WebElement G= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='id_undefined_gender_id']")));
		G.click(); 
	          }

	}

}
