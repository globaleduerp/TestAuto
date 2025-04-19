package Day13;
	import java.io.IOException;
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class EmpLeaveApp {

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
		     driver.findElement(By.xpath("//a[text()='Employee Leave Application']")).click();
//		     driver.findElement(By.xpath("//a[text()='Employee Leave Management']")).click();
		     Thread.sleep(2000);
//		     driver.findElement(By.xpath(" //button[normalize-space()='Add']")).click();

			String filePath="G:\\document\\selenium_maven\\target\\Emp Salary Module.xlsx";
			int rows=Excelutils.getRowCount(filePath, "Emp Application");
			
			for(int i=1;i<=rows;i++)
			{
				//read data form excel
				String Employee=Excelutils.getCellData(filePath, "Emp Application",i,0);
				String LeaveType="Sick Leave";
//				=Excelutils.getCellData(filePath, "Sheet1",i,1);
				String FromDate=Excelutils.getCellData(filePath, "Emp Application",i,2);
				String ToDate=Excelutils.getCellData(filePath, "Emp Application",i,3);
				
//				String exresult=Excelutils.getCellData(filePath, "Sheet1",i,2);
//				pass above data into application
				 driver.findElement(By.xpath(" //button[normalize-space()='Add']")).click();
     			 driver.findElement(By.xpath("//div[contains(text(),'Employee')]")).click();
				 driver.findElement(By.xpath("(//input[@class='dx-texteditor-input'])[12]")).sendKeys(Employee); 
				 Thread.sleep(1000);
				 driver.findElement(By.xpath("//div[normalize-space(text())='" + Employee + "']")).click(); 
				
				//  driver.findElement(By.xpath("(//div[text()='Leave Type'])")).click();
				  driver.findElement(By.xpath("(//div[text()='Leave Type'])[1]")).sendKeys(LeaveType);
				  driver.findElement(By.xpath("//div[normalize-space(text())='" + LeaveType + "']")).click(); 
				  
				  driver.findElement(By.xpath("(//input[@name='nm_undefined_fromdate'])")).sendKeys(FromDate);
//				  driver.findElement(By.xpath("(//input[@role='textbox'])[11]")).sendKeys(Employee); 
				 
                 driver.findElement(By.xpath("(//input[@name='nm_undefined_todate'])")).sendKeys(ToDate);
                 System.out.println("Date save1");
			     driver.findElement(By.xpath("(//button[text()='Save'])")).click();
			     driver.findElement(By.xpath("(//button[text()='Save'])")).click();
			     System.out.println("Date save");
				//validation 
			     Thread.sleep(2000);
//			     try {  
	
			 		    // Wait for toast message to appear
			     driver.findElement(By.xpath("//div[@role='alert']"));
					WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
					System.out.println(error.getText());
					
					if(error.getText().contains("Sucessfullly"))

			     {
			    	 System.out.println("Test PAss");
			    	 Excelutils.setCellData(filePath, "Emp Application",i,4,"passed");
			    	 Excelutils.fillGreenColor(filePath, "Emp Application",i,4);
			    	 
			    	
			     }
//			    	 }
//			     catch (Exception e)
			 		    else
			 		    	
			     {
			    	 
			    	 System.out.println("Test done ");
			    	 Excelutils.setCellData(filePath, "Emp Application",i,4, "disp");
			    	 Excelutils.fillBlueColor(filePath, "Emp Application",i,4); 
			    	 driver.findElement(By.xpath("//button[text()='Cancel']")).click();
			     
			     }
Thread.sleep(2000);
			    
			}

		}

	}
	