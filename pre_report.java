package datadriventest;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pre_report {

	public static void main(String[] args) throws InterruptedException, IOException {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        driver.manage().window().maximize();
	        driver.get("https://ge-erp.com/Admin/Login");
	        driver.findElement(By.id("txtEmail")).sendKeys("Umang@gmail.com");
	        driver.findElement(By.id("txtPassword")).sendKeys("School@123");
	        driver.findElement(By.id("btnLogin")).click();
	        driver.findElement(By.xpath("//span[text()='Reports']")).click();
			driver.findElement(By.xpath("//a[text()='Hr Reports']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[text()='View'])[3]")).click();
			String parent1=driver.getWindowHandle();
			System.out.println("parent window is-"+parent1);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			Set<String>windowhandles=driver.getWindowHandles();
			for(String windowhandle:windowhandles)
			{
				if (!windowhandle.equals(parent1))
				{
					driver.switchTo().window(windowhandle);
					driver.manage().window().maximize();
					System.out.println(driver.getCurrentUrl());
					highlight(driver, driver.findElement(By.xpath("//h5[text()='Employee Salary Report ']")));
				Thread.sleep(10000);
				WebElement frameElement = driver.findElement(By.tagName("iframe"));

				// Get the ID attribute (if present)
				String frameId = frameElement.getAttribute("id");
				System.out.println("Frame ID: " + frameId);

				// Switch to the frame
				driver.switchTo().frame(frameElement);
				driver.findElement(By.id("ReportViewer1_ctl04_ctl03_ddValue")).click();
				driver.findElement(By.xpath("//option[text()='November']")).click();
				driver.findElement(By.id("ReportViewer1_ctl04_ctl00")).click();
				Thread.sleep(6000);
				
				highlight(driver, driver.findElement(By.xpath("//div[text()='SANT RAMKRISHNA KANYA INTER COLLEGE']")));
				Thread.sleep(3000);
				
				// Interact with the table element
				// ... your code here ...
				// name
				System.out.println("...........................................");
				WebElement element=driver.findElement(By.xpath("//div[normalize-space()='ALKA JAIN']"));
				String n=element.getText();
				System.out.println("name="+n);
				//call days
				WebElement element1=driver.findElement(By.xpath("//tbody/tr[3]/td[5]/div[1]"));
				String d=element1.getText();
				int cd = Integer.parseInt(d);
				System.out.println("Cal_days="+cd);
				//Week off
				WebElement element2=driver.findElement(By.xpath("//tbody/tr[3]/td[6]"));
				String wf=element2.getText();
				System.out.println("Week_off="+wf);
				//holiday	
				WebElement element3=driver.findElement(By.xpath("//tbody/tr[3]/td[7]/div[1]"));
				String hd=element3.getText();
				System.out.println("holiday="+hd);
				// Week days
				WebElement element4=driver.findElement(By.xpath("//tbody/tr[3]/td[8]/div[1]"));
				String wd=element4.getText();
				System.out.println("Working Days="+wd);
				//leave
				WebElement element5=driver.findElement(By.xpath("//tbody/tr[3]/td[9]"));
				String lv=element5.getText();
				System.out.println("leave="+lv);
				//absent
				WebElement element6=driver.findElement(By.xpath("//tbody/tr[3]/td[10]/div[1]"));
				String ab=element6.getText();
				System.out.println("Absent="+ab);
				//present
				WebElement element7=driver.findElement(By.xpath("//tbody/tr[3]/td[11]"));
				String pt=element7.getText();
				System.out.println("Present="+pt);
				//LC
				WebElement element8=driver.findElement(By.xpath("//tbody/tr[3]/td[12]/div[1]"));
				String LC=element8.getText();
				System.out.println("late Comming="+LC);
				//attendance miss
				WebElement element9=driver.findElement(By.xpath("//tbody/tr[3]/td[13]/div[1]"));
				String Am=element9.getText();
				System.out.println("Attendance_miss="+Am);
				//sal
				WebElement element10=driver.findElement(By.xpath("//tbody/tr[3]/td[14]"));
				String sal=element10.getText();
				System.out.println("salary="+sal);
				//dec sal
				WebElement element11=driver.findElement(By.xpath("//tbody/tr[3]/td[15]/div[1]"));
				String Dec_sal=element11.getText();
				System.out.println("deducted_salary="+Dec_sal);
				// Net Sal
				WebElement element12=driver.findElement(By.xpath("//tbody/tr[3]/td[16]"));
				String net_sal=element12.getText();
				System.out.println("net Salary="+net_sal);
				System.out.println(" data print successfully");
				System.out.println("...........................................");
				
				//2nd record printing
				WebElement ele1=driver.findElement(By.xpath("//div[normalize-space()='ANITA SHARMA']"));
				String n1=ele1.getText();
				System.out.println("name="+n1);
				//call days
				WebElement ele2=driver.findElement(By.xpath("//tbody/tr[5]/td[5]/div[1]"));
				String cd1=ele2.getText();
				System.out.println("Cal_days="+cd1);
				//Week off
				WebElement ele3=driver.findElement(By.xpath("//tbody/tr[5]/td[6]"));
				String wf1=ele3.getText();
				System.out.println("Week_off="+wf1);
				//holiday	
				WebElement ele4=driver.findElement(By.xpath("//tbody/tr[5]/td[7]/div[1]"));
				String hd1=ele4.getText();
				System.out.println("holiday="+hd1);
				// Week days
				WebElement elem4=driver.findElement(By.xpath("//tbody/tr[5]/td[8]/div[1]"));
				String wd1=elem4.getText();
				System.out.println("Working Days="+wd1);
				//leave
				WebElement ele5=driver.findElement(By.xpath("//tbody/tr[5]/td[9]"));
				String lv1=ele5.getText();
				System.out.println("leave="+lv1);
				//absent
				WebElement ele6=driver.findElement(By.xpath("//tbody/tr[5]/td[10]/div[1]"));
				String ab1=ele6.getText();
				System.out.println("Absent="+ab1);
				//present
				WebElement ele7=driver.findElement(By.xpath("//tbody/tr[5]/td[11]"));
				String pt1=ele7.getText();
				System.out.println("Present="+pt1);
				//LC
				WebElement ele8=driver.findElement(By.xpath("//tbody/tr[5]/td[12]/div[1]"));
				String LC1=ele8.getText();
				System.out.println("late Comming="+LC1);
				//attendance miss
				WebElement ele9=driver.findElement(By.xpath("//tbody/tr[5]/td[13]/div[1]"));
				String Am1=ele9.getText();
				System.out.println("Attendance_miss="+Am1);
				//sal
				WebElement ele10=driver.findElement(By.xpath("//tbody/tr[5]/td[14]"));
				String sal1=ele10.getText();
				System.out.println("salary="+sal1);
				//dec sal
				WebElement ele11=driver.findElement(By.xpath("//tbody/tr[5]/td[15]/div[1]"));
				String Dec_sal1=ele11.getText();
				System.out.println("deducted_salary="+Dec_sal1);
				// Net Sal
				WebElement ele12=driver.findElement(By.xpath("//tbody/tr[5]/td[16]"));
				String net_sal1=ele12.getText();
				System.out.println("net Salary="+net_sal1);
				System.out.println("...........................................");
				String filePath="C:\\Users\\formu\\eclipse-workspace\\automation\\src\\test\\java\\datadriventest\\cal_master_data.xlsx";						
				int x=1;	
			 	    excelutils.setCellData(filePath, "Sheet4",1,x,element.getText());
					excelutils.setCellData(filePath, "Sheet4",2,x,element1.getText());
					excelutils.setCellData(filePath, "Sheet4",3,x,element2.getText());
					excelutils.setCellData(filePath, "Sheet4",4,x,element3.getText());
					excelutils.setCellData(filePath, "Sheet4",5,x,element4.getText());
					excelutils.setCellData(filePath, "Sheet4",6,x,element5.getText());
					excelutils.setCellData(filePath, "Sheet4",7,x,element6.getText());
					excelutils.setCellData(filePath, "Sheet4",8,x,element7.getText());
					excelutils.setCellData(filePath, "Sheet4",9,x,element8.getText());
					excelutils.setCellData(filePath, "Sheet4",10,x,element9.getText());
					excelutils.setCellData(filePath, "Sheet4",11,x,element10.getText());
					excelutils.setCellData(filePath, "Sheet4",12,x,element11.getText());
					excelutils.setCellData(filePath, "Sheet4",13,x,element12.getText());
					
					//2nd record accepting
					
					excelutils.setCellData(filePath, "Sheet4",14,x,ele1.getText());
					excelutils.setCellData(filePath, "Sheet4",15,x,ele2.getText());
					excelutils.setCellData(filePath, "Sheet4",16,x,ele3.getText());
					excelutils.setCellData(filePath, "Sheet4",17,x,ele4.getText());
					excelutils.setCellData(filePath, "Sheet4",18,x,elem4.getText());
					excelutils.setCellData(filePath, "Sheet4",19,x,ele5.getText());
					excelutils.setCellData(filePath, "Sheet4",20,x,ele6.getText());
					excelutils.setCellData(filePath, "Sheet4",21,x,ele7.getText());
					excelutils.setCellData(filePath, "Sheet4",22,x,ele8.getText());
					excelutils.setCellData(filePath, "Sheet4",23,x,ele9.getText());
					excelutils.setCellData(filePath, "Sheet4",24,x,ele10.getText());
					excelutils.setCellData(filePath, "Sheet4",25,x,ele11.getText());
					excelutils.setCellData(filePath, "Sheet4",26,x,ele12.getText());
			    driver.switchTo().defaultContent();
				}
			}
			
	}

	public static void highlight(WebDriver driver, WebElement webElement) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:5px solid black; background:Green')", webElement);
}
}

