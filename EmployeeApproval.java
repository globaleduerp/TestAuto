package Day13;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeApproval {

	public static void main(String[] args) throws IOException, Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://ge-erp.com/Admin/Login/Index");
		driver.findElement(By.id("txtEmail")).sendKeys("Bhumisaini@gmail.com");
	    driver.findElement(By.id("txtPassword")).sendKeys("School@123");
	    driver.findElement(By.xpath(" //button[text()='Login']")).click();  
	  //button[text()='Login']
	    driver.findElement(By.xpath("//span[text()='HR Module']")).click();
	     driver.findElement(By.xpath("//a[text()='Employee Leave Management']")).click();
	     driver.findElement(By.xpath("//a[text()='Employee Leave Approval']")).click();
	  
	     Thread.sleep(2000);
//	     driver.findElement(By.xpath(" //button[normalize-space()='Add']")).click();

		String filePath="G:\\document\\selenium_maven\\target\\Emp Salary Module.xlsx";
		int rows=Excelutils.getRowCount(filePath, "Emp Approval");
		
		for(int i=1;i<=rows;i++)
		{
			//read data form excel
			String LeaveDate=Excelutils.getCellData(filePath, "Emp Approval",i,0);
			String Status=Excelutils.getCellData(filePath, "Emp Approval",i,1);
//			pass above data into application
			 driver.findElement(By.xpath("//input[@id='id_undefined_fromdate']")).sendKeys(LeaveDate); 
//			//validation 
		     Thread.sleep(2000);

		    	 driver.findElement(By.xpath("dx-lookup-field")).sendKeys(Status);		 
		    	 driver.findElement(By.xpath("//div[normalize-space(text())='" + Status + "']")).click(); 
		    	 driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
//		 		     Wait for toast message to appear
			     try {  
		     driver.findElement(By.xpath("//div[@role='alert']"));
				WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
				System.out.println(error.getText());
				if(error.getText().contains("Sucessfullly"))
     {
		    	 
					System.out.println("Test PAss");
		    	 Excelutils.setCellData(filePath, "Emp Approval",i,2,"passed");
		    	 Excelutils.fillGreenColor(filePath, "Emp Approval",i,2);
		    	 
		    	
		    	
		     }
		    	 
		     driver.findElement(By.xpath("dx-lookup-field")).click();	 
	    	 driver.findElement(By.xpath("//span[normalize-space()='Clear']")).click();
		     }
		     catch (Exception e)
		 	 	
		     {
		    	 
		    	 System.out.println("Test done ");
		    	 Excelutils.setCellData(filePath, "Emp Approval",i,2, "disp");
		    	 Excelutils.fillBlueColor(filePath, "Emp Approval",i,2); 
		    	 driver.findElement(By.xpath("(//button[text()='Cancel'])[2]")).click();
		     
		     }
Thread.sleep(2000);
		    
		}

	}

}