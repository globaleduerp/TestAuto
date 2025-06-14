package AdmissionModule;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalaryModule.Excelutils;

public class DirectRegistration {

	public void DirectRegistration1(WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admission']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Direct Registration']"))).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
		String filePath="C:\\Users\\RIYA\\eclipse-workspace\\Automation\\target\\Admission_Module.xlsx";
		int rows=Excelutils.getRowCount(filePath, "DirectRegistration");
		
		System.out.println(rows);
		
		
          for(int i=1; i<=rows;i++) {
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
			System.out.println("row no. is "+i);
			  //input[@name='nm_undefined_enquiryforsessionyear_id']
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//div[@id='id_undefined_enquiryforsessionyear_id']"))).click();
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
//	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Class+"']"))).click();
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
//	G.sendKeys(Gender);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Gender+"']"))).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nm_undefined_email']"))).sendKeys(EMAIL);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_undefined_aadharno']"))).sendKeys(AdharNo);
	 wait.until(ExpectedConditions.visibilityOfElementLocated
			 (By.xpath("//input[@id='id_undefined_fathefirstname']"))).sendKeys(FatherName); 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			 ("//input[@id='id_undefined_motherfirstname']"))).sendKeys(MotherName);
	 wait.until(ExpectedConditions.visibilityOfElementLocated
			 (By.xpath("//textarea[@id='id_undefined_address1']"))).sendKeys(CorespondanceAddress);
	 wait.until(ExpectedConditions.visibilityOfElementLocated
			 (By.xpath("//textarea[@id='id_undefined_address2']"))).sendKeys(PermanentAddress);
	 wait.until(ExpectedConditions.visibilityOfElementLocated
			 (By.xpath("//input[@id='id_undefined_pincode']"))).sendKeys(Pincode);
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']"))).click();
	 Thread.sleep(1000);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']"))).click();
	 try {
		    // Check if any alert appears (success or error)
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		    WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));

		    // Check the alert message for success or failure
//		    String alertText = alert.getText();
		    System.out.println("Alert Message: ");

		    // Handling Success Case
		    if (alert.getText().contains("Sucessfullly")) {
		        System.out.println("Test Passed");
		        Excelutils.setCellData(filePath, "DirectRegistration", i, 13, alert.getText());
		        Excelutils.fillGreenColor(filePath, "DirectRegistration", i, 13); // Green color for success
		       
		    } else {
		        // Handling Error Case (Failed submission or validation failure)
		        System.out.println("Test Failed");
		        Excelutils.setCellData(filePath, "DirectRegistration", i, 13, alert.getText());
		        Excelutils.PinkColor(filePath, "DirectRegistration", i, 13); // Pink color for error

		        // Close the warning toast or error message
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--warning']"))).click();
		        Thread.sleep(3000);  // Wait for a while before clicking again

		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--warning']"))).click();
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Back To List']"))).click();
		        continue;
		    }

		} catch (Exception e) {
		    // If any error occurs (like element not found, etc.)
		    System.out.println("Error occurred: " + e.getMessage());

		    try {
		        // If validation message appears due to invalid input, catch it using JavaScript
		        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='ContactNo./WhatsappNo.']")));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",element);
		        if (validationMessage.contains("Please lengthen"))

		        System.out.println("Validation Message: " + validationMessage);
		        Excelutils.setCellData(filePath, "DirectRegistration", i, 13, validationMessage);
		        Excelutils.PinkColor(filePath, "DirectRegistration", i, 13);

		        Thread.sleep(2000);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Back To List']"))).click();
		   
		    }
		   catch (Exception inner) {
		        System.out.println("Inner exception: " + inner.getMessage());
		    }
		    try {
		    	
		    }
		    catch (Exception inner) {
		        System.out.println("Inner exception: " + inner.getMessage());
		    }

		}
	}}}