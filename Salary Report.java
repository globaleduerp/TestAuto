package datadriventest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class report {

	public void Rept (WebDriver driver, WebDriverWait wait) throws IOException, InterruptedException {
	    driver.findElement(By.xpath("//span[text()='Reports']")).click();
		driver.findElement(By.xpath("//a[text()='Hr Reports']")).click();
		
		//driver.findElement(By.xpath("(//a[text()='View'])[3]")).click();	
		//String parent1=driver.getWindowHandle();
		//System.out.println("parent window is-"+parent1);
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//a[text()='View'])[3]")).click();
		Thread.sleep(8000);
		
		WebElement element=driver.findElement(By.xpath("//table//table//table//tr[1]//tr[18]//td[9]"));
		System.out.println(element);
	//	String filePath="C:\\Users\\formu\\eclipse-workspace\\automation\\src\\test\\java\\datadriventest\\cal_master_data.xlsx";
		//int rows=excelutils.getRowCount(filePath, "Sheet2");
		
	//	for(int i=1; i<=rows;i++) {
			
			
	//	}
		
		
		//driver.findElement(By.id("newTabBtn")).click();
		
		//table//table//table//tr[1]//tr[18]//td[9]
		/* Set<String>windowhandles=driver.getWindowHandles();
		
		for(String windowhandle:windowhandles)
		{
			if (!windowhandle.equals(parent1))
			{
				driver.switchTo().window(windowhandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(2000);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReportViewer1_ctl04_ctl03_ddValue"))).click();
				 List <WebElement> frames = driver.findElements(By.tagName("iframe"));

			        // Check if there are any frames
			        if (frames.size() > 0) {
			            System.out.println("Number of frames on the page: " + frames.size());
			            for (int i = 0; i < frames.size(); i++) {
			                System.out.println("Frame " + (i + 1) + " details: " + frames.get(i).getAttribute("id"));
			                String frm=frames.get(i).getAttribute("id");
			                
			                List<WebElement> elements = driver.findElements(By.xpath("//*"));

					        // Print details of all elements in the frame
					        System.out.println("Number of elements in the frame: " + elements.size());
					        for (WebElement element : elements) {
					            System.out.println("Tag Name: " + element.getTagName() + ", Text: " + element.getText());
					        }
			            }
			        } else {
			            System.out.println("No frames found on the page.");
			        }
			    */
			        
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='November']"))).click();
				//highlight(driver, driver.findElement(By.xpath("//h5[text()='Employee Salary Report ']")));
				
			//	driver.switchTo().frame("r4b39d61b-39bb-4d4e-a7fd-9cb6e430f31d");
			//	driver.switchTo().frame(driver.findElement(By.id('" frm "')));
				//r98f00393-ef38-49eb-bda2-f6e1fc511202
				//System.out.println("enter into frame");
				//Thread.sleep(5000);
				//driver.switchTo().frame("frm4");
				//frame ID = rcf7d8b60-3efa-4d86-a2fb-c3ecc0bd09fb
				
				//highlight(driver, driver.switchTo().frame("r16f33bed-0e3c-4be8-883a-d31614f0b0a1"));
				
				//highlight(driver, driver.findElement(By.id("ReportViewer1_ctl04_ctl03_ddValue")));
				 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReportViewer1_ctl04_ctl00"))).click();
			}
	////	}

		
		
         //driver.navigate().refresh();
         //Thread.sleep(2000);
		//WebElement table = driver.findElement(By.id("ParametersGridReportViewer1_ctl04")); // Replace 'tableId' with the table's ID

        // Locate a specific cell (e.g., second row, third column)
        //WebElement cell = table.findElement(By.xpath("//tr[1]/td[2]"));
        //cell.click();
		//String parentwindow = driver.getWindowHandle();  //1
		//System.out.println("parent window is -"+ parentwindow+"     "+driver.getTitle());
		//driver.navigate().to("https://ge-erp.com/PrintReciept/ViewReport?Id=138&menuId=221&menuCode=2350&asgID=2&sgId=1&LeftMenuHide=true&TopMenuHide=true");
		// WebElement rec= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='aspNetDisabled']")));
		 //System.out.println(rec.getText());
		 //rec.click();
		 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='November']"))).click();
		  
		 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReportViewer1_ctl04_ctl00"))).click();
		 
		//option[text()='November']
/*	String filePath="C:\\Users\\formu\\eclipse-workspace\\automation\\src\\test\\java\\datadriventest\\cal_master_data.xlsx";
	int rows=excelutils.getRowCount(filePath, "Sheet2");
	
	for(int i=1; i<=rows;i++) {
		
		//reading data from Excel
		String code= excelutils.getCellData(filePath, "Sheet2", i,0);
		String name= excelutils.getCellData(filePath, "Sheet2", i,1);
		String usertype=excelutils.getCellData(filePath, "Sheet2",i,2);
		String remarks=excelutils.getCellData(filePath, "Sheet2",i,3);
		String weekoff=excelutils.getCellData(filePath, "Sheet2",i,4);
		String def=excelutils.getCellData(filePath, "Sheet2",i,5);
		
	
		//passing data into cal master for add
		
    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_undefined_code"))).sendKeys(code);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nm_undefined_calendarname"))).sendKeys(name);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dx-lookup-field' and @tabindex='0'][1]"))).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+usertype+"']"))).click();
	Thread.sleep(1000);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_undefined_remarks"))).sendKeys(remarks);
	Thread.sleep(1000);		
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='select weekoff Type']"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+weekoff+"']"))).click();
	Thread.sleep(1000);
	
		driver.findElement(By.id("id_undefined_isdefault")).click();

		 
    
    driver.findElement(By.xpath("//button[@type='submit']")).click();
//validation
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
	WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));
System.out.println(error.getText());
	
	//String error=driver.findElement(By.xpath("//div[@id='root']")).getText();
	if(error.getText().contains("Sucessfullly"))
	{
		System.out.println("Test Pass");
    	 excelutils.setCellData(filePath, "Sheet2",i,6,"passed:");
    	 excelutils.setCellData(filePath, "Sheet2",i,7,error.getText());
    	 excelutils.fillGreenColor(filePath, "Sheet2",i,6);
    //	 driver.findElement(By.xpath("//i[@class='fas fa-cog']")).click();
		//driver.findElement(By.xpath("//a[@id='submit']")).click();
	}
	else
		{System.out.println("test pass");
	 		excelutils.setCellData(filePath, "Sheet2",i,6,"Pass with");
	 	excelutils.setCellData(filePath, "Sheet2",i,7,error.getText());
	 	     excelutils.fillGreenColor(filePath, "Sheet2",i,6);
	 	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--error']")));
 	// driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--error']")).click();
	       Thread.sleep(5000);
	 	     driver.findElement(By.xpath("//button[text()='Cancel']")).click();

		}
	Thread.sleep(1000);
	}
	*/

	
//}
	public static void highlight(WebDriver driver, WebElement webElement) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:5px solid black; background:Green')", webElement);
}
}
