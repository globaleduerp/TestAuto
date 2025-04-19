package datadriventest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class logintest {
	public static void main(String[] args) throws IOException, Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://ge-erp.com/Admin/Login/Index");
		//FileInputStream filePath=new FileInputStream("C:\\Users\\formu\\eclipse-workspace\\automation\\src\\test\\java\\excel_data\\test data\\login.xlsx");
		//String filePath=System.getProperty("user.dir")+"\\test data\\login.xlsx";
		String filePath="C:\\Users\\formu\\eclipse-workspace\\automation\\src\\test\\java\\datadriventest\\test data\\login.xlsx";
		int rows=excelutils.getRowCount(filePath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//read data form excel
			String User=excelutils.getCellData(filePath, "Sheet1",i,0);
			String pass=excelutils.getCellData(filePath, "Sheet1",i,1);
			String exresult=excelutils.getCellData(filePath, "Sheet1",i,2);
			//pass above data into application
			 driver.findElement(By.id("txtEmail")).sendKeys(User);
		     driver.findElement(By.id("txtPassword")).sendKeys(pass);
			
		     driver.findElement(By.id("btnLogin")).click();
			//validation 
		     
		     String act_mvalue=driver.findElement(By.xpath("//span[@id='divErrorText']")).getText();
		    
		     if  (exresult.equalsIgnoreCase(act_mvalue))
		     {
		    	 System.out.println("test PAss");
		    	 excelutils.setCellData(filePath, "Sheet1",i,3,"passed");
		    	 excelutils.fillGreenColor(filePath, "Sheet1",i,3);
		     }
		     else
		     {
		    	 System.out.println("Test fail");
		    	 excelutils.setCellData(filePath, "Sheet1",i,3,"failed");
		    	 excelutils.fillRedColor(filePath, "Sheet1",i,3);
		     }
		     Thread.sleep(3000);
		     driver.findElement(By.id("txtEmail")).clear();
		     driver.findElement(By.id("txtPassword")).clear();
		}

	}

}
