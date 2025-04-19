package Day13;
	import java.io.IOException;
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpLeaveAllo { 

		public static void main(String[] args) throws IOException, Exception {
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.get("http://ge-erp.com/Admin/Login/Index");
			driver.findElement(By.id("txtEmail")).sendKeys("Bhumisaini@gmail.com");
		    driver.findElement(By.id("txtPassword")).sendKeys("School@123");
		    driver.findElement(By.xpath(" //button[text()='Login']")).click();  
		  //button[text()='Login']
		    driver.findElement(By.xpath("//span[text()='HR Module']")).click();
		     driver.findElement(By.xpath("//a[text()='Employee Leave Management']")).click();
		     driver.findElement(By.xpath("//a[normalize-space()='Employee Leave Allowance']")).click();


			String filePath="G:\\document\\selenium_maven\\target\\Emp Salary Module.xlsx";
			int rows=Excelutils.getRowCount(filePath, "Emp Allowance");
			
			for(int i=1;i<=rows;i++)
				
			{
				//read data form excel
				System.out.println("Checking");
				String Department=Excelutils.getCellData(filePath, "Emp Allowance",i,0);
				String LeaveType=Excelutils.getCellData(filePath, "Emp Allowance",i,1);
				String Employee=Excelutils.getCellData(filePath, "Emp Allowance",i,2);
				String Leave=Excelutils.getCellData(filePath,"Emp Allowance",i,3);
				System.out.println("Checking1");
//				pass above data into application
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='dx-lookup-field-wrapper'])[1]"))).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Clear']"))).click();
				Thread.sleep(2000);
				WebElement Element=driver.findElement(By.xpath("(//div[@class='dx-lookup-field-wrapper'])[1]"));
				Element.click();
//				Element.sendKeys(Department);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='dx-texteditor-input']"))).sendKeys(Department);
//				Element.sendKeys(Department);
				Thread.sleep(2000);
//				 driver.findElement(By.xpath("(//div[@class='dx-lookup-field-wrapper'])[1]")).sendKeys(Department);
     			 driver.findElement(By.xpath("//div[normalize-space(text())='" + Department + "']")).click();
     			 Thread.sleep(1000);
				  driver.findElement(By.xpath("//div[contains(text(),'Leave Type')]")).sendKeys(LeaveType);
				  driver.findElement(By.xpath("//div[normalize-space(text())='" + LeaveType + "']")).click(); 
				  Thread.sleep(1000);
				  driver.findElement(By.xpath("//input[@placeholder='search table']")).sendKeys(Employee);  
				  Thread.sleep(1000);
                 System.out.println("Search emp");
                 driver.findElement(By.xpath("//input[@id='id_-1_annualleave']")).clear()
                 ;
			     driver.findElement(By.xpath("//input[@id='id_-1_annualleave']")).sendKeys(Leave);
			     driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			     System.out.println("Date save");
				//validation 
			     Thread.sleep(2000);
//		     try { 
	
			 		    // Wait for toast message to appear
			     driver.findElement(By.xpath("//div[@role='alert']"));
					WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
					System.out.println(error.getText());
					
					System.out.println("Error");
				   if(error.getText().contains("Sucessfullly"))
                 {
			    	 System.out.println("Test pass");
			    	 Excelutils.setCellData(filePath, "Emp Allowance",i,4,"Pass");
			    	 Excelutils.setCellData(filePath, "Emp Allowance",i,5,error.getText());
			    	 Excelutils.fillGreenColor(filePath, "Emp Allowance",i,4);	
			     }
//			    	 }
//			     catch (Exception e)	  
				   else
			     {
//			    	 driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
//						WebElement error1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
//						System.out.println(error1.getText());
						Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--error']")));
				     	 driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--error']")).click();
//					   if(error1.getText().contains("Some error"))
					  
			    	 System.out.println("Test done ");
			    	 Excelutils.setCellData(filePath, "Emp Allowance",i,4, "Pass with error");
			    	 Excelutils.setCellData(filePath, "Emp Allowance",i,5,error.getText());
			    	 Excelutils.fillBlueColor(filePath, "Emp Allowance",i,5);
			    	
			    	
			     }
				   System.out.println("Checking3");
			    
			}
			Thread.sleep(2000);
			System.out.println("Checking3");
		}

		}
	
