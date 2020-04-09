package mypack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import mypack.Report;
import mypack.EDIEventRead;
import mypack.EDIRead;
public class visibility_Automation{
	
	@SuppressWarnings("deprecation")
	@Test

		public static void  Scenario1(String fPathLocal,String fEVentpathLocal,String fEventpathLocal_Update,String AGeventpathLocal) throws Exception {
			WebDriver driver;
			InputStream inputStream;
			InputStream inputStream1;
			String statusSUmmary=null;
			String status_detail =null;
			String Planned_date=null;
			String Reported_date=null;
			String railArrivalEst=null;
			String outGateEst=null;
			String pickUpEst=null;
			String railDepartureEst=null;
			String containerUnloadEst=null;
			String vesselArrivalEst=null;
			String containerID_scn4=null;
			String vesselArrival_scn4=null;
			String vesselDep_scn4=null;
			String railDep_scn4=null;
			String railArrival_scn4=null;
			String dropOff_scn4=null;
			String vesselDeparture_nocon=null;
			String	vesselArrival_nocon=null;
			String	containerUnload_nocon=null;
			String	railDeparture_nocon=null;
			String	railArrival_nocon=null;
			String	outGate_nocon=null;
			String	pickUp_nocon=null;
			String	dropOff_nocon=null;
			String vesselDeparture_con=null;
			String	vesselArrival_con=null;
			String	containerUnload_con=null;
			String	railDeparture_con=null;
			String	railArrival_con=null;
			String	outGate_con=null;
			String	pickUp_con=null;
			String	dropOff_con=null;
			String statusSUmmary_scn5=null;
			String e2Estatus_scn5=null;
			String Planned_date_PK =null;
			String Planned_date_VD  =null;
			String Planned_date_VA =null;
			String Planned_date_UV  =null;
			String Planned_date_RL  =null;
			String Planned_date_AR =null;
			String Planned_date_OA =null;
			String Planned_date_dropoff=null;
			String Planned_date_CL=null;
			String Estimated_date_PK =null;
			String Estimated_date_VD  =null;
			String Estimated_date_VA =null;
			String Estimated_date_UV  =null;
			String Estimated_date_RL  =null;
			String Estimated_date_AR =null;
			String Estimated_date_OA =null;
			String Estimated_date_dropoff=null;
			String Estimated_date_CL=null;
			String[] event_type = mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal);
			String[] eventType_update=mypack.EDIEventRead.MyFunctionEventtype(fEventpathLocal_Update);
			String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal);
			//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
			String[] shipment=mypack.EDIRead.MyFunction_containerEDI(fPathLocal);
	
			//String[] noContainer=mypack.EDIRead.MyFunction_nocontainerEDI();
			//String containerEDI[]=mypack.EDIRead.MyFunction_containerEDI();
			try {
			String currentDir = System.getProperty("user.dir");
		    System.out.println("Current dir using System:" +currentDir);		
			inputStream = new FileInputStream(currentDir+"\\CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
		
			driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
			driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
			Thread.sleep(20000);
			mypack.Report.MyReport("1", "TC01", "Create and upload events","Pass");
			
			
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[2]/div/div/div[1]/div/div[2]/div[1]")));
//Scenario 1 : Save as view		
			int adv_Filter=0;
			int sav_view=0;
			driver.findElement(By.xpath("//*[contains(@class, 'MuiSvgIcon-root align-right grid-filter')]")).click();
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/form/div/div/div[2]/button")).click();
			Select advFilter = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[1]/select")));
			advFilter.selectByIndex(0);
			Thread.sleep(3000);
			Select attchVal  = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[3]/select")));
			attchVal.selectByValue("No");;
			Thread.sleep(3000);
			/*if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/div/div[2]/button[2]")).isEnabled()){
				System.out.println("Advance Filter is working");
				adv_Filter=1;
			}
			else
			{
				System.out.println("Advance Filter is not working");
				adv_Filter=2;
			}*/
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/div/div[2]/button[2]")).click();
			Thread.sleep(1000);
			WebElement Element_attachment = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[23]"));
			
	        //This will scroll the page Horizontally till the element is found		
	  
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;",Element_attachment);
			if (Element_attachment.getText().equals("NO")) {
				System.out.println("Advance Filter is working");
				adv_Filter=1;
			}
			else
			{
				System.out.println("Advance Filter is not working");
				adv_Filter=2;
			}
			System.out.println("Element_attachment.getText() "+Element_attachment.getText());
			Thread.sleep(2000);	
			driver.findElement(By.xpath("//*[contains(@class, 'MuiSvgIcon-root align-right save-view')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[last()-1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/label[1]/input")).sendKeys("NewView");
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div/button[2]")).isEnabled()) {
				System.out.println("New View can be saved");
				sav_view=1;
			}
			else {
				System.out.println("New View cannot be saved");
				sav_view=2;
			}
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div/button[2]")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//*[contains(@class, 'MuiSvgIcon-root align-right save-view')]")).click();
			//driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[last()]")).click();
			//driver.switchTo().activeElement();
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/svg")).click();
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[last()]")).click();
			//driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[3]/button[2]")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div/button[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[contains(@class, 'MuiSvgIcon-root align-right save-view')]")).click();
			driver.findElement(By.xpath("//*[@id=\"save-grid-menu\"]/div[3]/ul/li[1]")).click();
			Thread.sleep(300000);
			
						
//Scenario 1 : check for summary
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
			statusSUmmary=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div/div[1]/div[1]")).getText();
			System.out.println(statusSUmmary.split(" ")[1]);
			if (statusSUmmary.split(" ")[1].equals("Transit")) {
				
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			}
			else if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]")).isDisplayed()){
		
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]")).click();
			}
			else
				System.out.println("Status of Shipment is still Planned");
		
		
			System.out.println("Status in summary page :"+statusSUmmary);
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			 status_detail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText();
			 System.out.println("Status in detail page : "+status_detail);
			//String status_summary = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div/div[1]")).getText();
			
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[2]/div[3]/span/svg")).getAttribute("upload");
			
			
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/div[3]/span")).click();
			Thread.sleep(3000);
			int attach_comm=0;
			if (driver.findElement(By.xpath("//div[@class='attachment-modal']")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@class='MuiFormControl-root attachment-type-dropdown']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[3]")).click();
				Thread.sleep(1000);
				
				//File from_file = new File ("C:\\Users\\divya.mohan08\\eclipse-workspace\\EDI\\attachment.xlsx");
				
				WebElement droparea = driver.findElement(By.xpath("//div[@class='drag-drop-file']"));
				droparea.click();
				Thread.sleep(1000);
				Runtime.getRuntime().exec(currentDir+"\\FileUpload.exe");
				Thread.sleep(3000);
				// drop the file
			/*DropFile(new File("D:\\BLUME\\Capture.PNG"), droparea, 0, 0);
				System.out.println("Drag and Drop fn called");
				Thread.sleep(3000);
				*/
				
			if (driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[2]")).isEnabled()) {
				System.out.println("Yes");
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[2]")).click();
			attach_comm=1;
				
			}
			else
				
			attach_comm=2;
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[1]")).click();
			Thread.sleep(3000);

	
			
	
			//Events, Milestones and Exceptions
			int eventVal =0;
			//take value of eventType from EDI Event Read class
			int eventdatediff=0;
			if (event_type[0].equals("AE")){
					if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
						System.out.println("Container Load event is reported ");
						eventVal=1;
						eventdatediff =event_type[1].compareTo(shipment[2]);
						if (eventdatediff>0) {
							
							if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[1]")).isDisplayed()) {
								System.out.println("Exception");
								eventVal=1;
							}
							else
								System.out.println("Exception not displayed in UI");
								
						}
					}
					else
						System.out.println("Event reported is Container Load but is not highlighted in UI");
					
					Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
					Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
					System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (event_type[0].equals("VD")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Vessel Departure event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(shipment[2]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
							
					}
				}
				else
					System.out.println("Event reported is Vessel Departure but is not highlighted in UI");
				
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
		
			else if (event_type[0].equals("VA")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Vessel Arrival event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(shipment[2]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
						
					}
				}
				else
					System.out.println("Event reported is Vessel Arrival  but is not highlighted in UI");
				
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			 
			else if (event_type[0].equals("UV")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Container UnLoad event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(shipment[2]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
							
					}
				}
				else
					System.out.println("Event reported is Container UnLoad but is not highlighted in UI");
				
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (event_type[0].equals("RL")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Rail Departure event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(shipment[2]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
					
					}
				}
				else
					System.out.println("Event reported is Rail Departure but is not highlighted in UI");
			
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("///*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (event_type[0].equals("AR")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Rail Arrival event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(shipment[2]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
					
					}
				}
				else
					System.out.println("Event reported is Rail Arrival but is not highlighted in UI");
		
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}	
			else if (event_type[0].equals("OA")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Out Gate event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(shipment[2]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
						
					}
				}
				else
					System.out.println("Event reported is OutGate but is not highlighted in UI");
				
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			
			String exceptionMssg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr/td")).getText();
			if (exceptionMssg.equals("No records found")){
				System.out.println("No records in Exceptions table");
				
				
			}
			else
				System.out.println("Exceptions are present in the Exceptions table");
			
			System.out.println("EventVal= "+eventVal);	
			if (eventVal==1){
				mypack.Report.MyReport("1", "TC02","Create and upload shipments with purpose code 04", "Pass");
				
			}
			else {
				mypack.Report.MyReport("1", "TC02","Create and upload shipments with purpose code 04", "Fail");
				
			}
			//Comments
			int comm=0;
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[1]/div/div[1]/div")).click();
			if (driver.findElement(By.xpath("//*[@id=\"note\"]")).isEnabled()) {
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/button")).click();
				System.out.println("Comments can be added");
				comm=2;
			}
			else {
				System.out.println("Not able to add comments");
			}
			
	
// Call ftp function to upload another event and check for milestones
			//String fileType, String host, String userName , String password, String localFilePath, String ftpDirectory
			inputStream1 = new FileInputStream(currentDir+"\\Scenario1\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook1 = new XSSFWorkbook(inputStream1);
			Sheet sheet1 = wBook1.getSheetAt(0);
			int rowCount = sheet1.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount;i++) {
				Row row1 = sheet1.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
		
			
	int eventVal_1 =0;
	
	 driver.navigate().refresh();
	 Thread.sleep(300000);
		driver.switchTo().frame(0);
		
	/* Select selectMyElement1 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
		selectMyElement1.selectByVisibleText("Master Shipment Ref #");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();*/
		Thread.sleep(5000);
	 statusSUmmary=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div/div[1]/div[1]")).getText();
	
		if (statusSUmmary.split(" ")[1].equals("Transit")) {
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
		}
		else if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]")).isDisplayed()){
	
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]")).click();
		}
		else
			System.out.println("Status of Shipment is still Planned after new event upload");
	
	
		
		Thread.sleep(3000);

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		
	 
			//take value of eventType from EDI Event Read class
			int eventdatediff_1=0;
			System.out.println("Event Update :"+eventType_update[0]);
			if (eventType_update[0].equals("AE")){
					if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
						System.out.println("Container Load event is reported ");
						eventVal_1=1;
						eventdatediff_1 =eventType_update[1].compareTo(shipment[2]);
						if (eventdatediff_1>0) {
							
							if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[1]/span/div")).isDisplayed()) {
								System.out.println("Exception");
								eventVal_1=1;
							}
							else
								System.out.println("Exception not displayed in UI");
							
						}
					}
					else
						System.out.println("Event reported is Container Load but is not highlighted in UI");
				
					Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
					Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
					System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (eventType_update[0].equals("VD")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Vessel Departure event is reported ");
					eventVal_1=1;
					eventdatediff_1 =eventType_update[1].compareTo(shipment[2]);
					if (eventdatediff_1>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[1]/span")).isDisplayed()) {
							System.out.println("Exception");
							eventVal_1=1;
						}
						else
							System.out.println("Exception not displayed in UI");
					
					}
				}
				else
					System.out.println("Event reported is Vessel Departure but is not highlighted in UI");
		
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
		
			else if (eventType_update[0].equals("VA")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Vessel Arrival event is reported ");
					eventVal_1=1;
					eventdatediff_1 =eventType_update[1].compareTo(shipment[2]);
					if (eventdatediff_1>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]/span")).isDisplayed()) {
							System.out.println("Exception");
							eventVal_1=1;
						}
						else
							System.out.println("Exception not displayed in UI");
				
					}
				}
				else
					System.out.println("Event reported is Vessel Arrival  but is not highlighted in UI");
			
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			 
			else if (eventType_update[0].equals("UV")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Container UnLoad event is reported ");
					eventVal_1=1;
					eventdatediff_1 =eventType_update[1].compareTo(shipment[2]);
					if (eventdatediff_1>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/span")).isDisplayed()) {
							System.out.println("Exception");
							eventVal_1=1;
						}
						else
							System.out.println("Exception not displayed in UI");
						
					}
				}
				else
					System.out.println("Event reported is Container UnLoad but is not highlighted in UI");
			
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (eventType_update[0].equals("RL")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Rail Departure event is reported ");
					eventVal_1=1;
					eventdatediff_1 =eventType_update[1].compareTo(shipment[2]);
					if (eventdatediff_1>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[1]/span")).isDisplayed()) {
							System.out.println("Exception");
							eventVal_1=1;
						}
						else
							System.out.println("Exception not displayed in UI");
						
					}
				}
				else
					System.out.println("Event reported is Rail Departure but is not highlighted in UI");
			
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("///*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (eventType_update[0].equals("AR")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Rail Arrival event is reported ");
					eventVal_1=1;
					eventdatediff_1 =eventType_update[1].compareTo(shipment[2]);
					if (eventdatediff_1>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[1]/span")).isDisplayed()) {
							System.out.println("Exception");
							eventVal_1=1;
						}
						else
							System.out.println("Exception not displayed in UI");
						
					}
				}
				else
					System.out.println("Event reported is Rail Arrival but is not highlighted in UI");
			
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}	
			else if (eventType_update[0].equals("OA")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Out Gate event is reported ");
					eventVal_1=1;
					eventdatediff_1 =eventType_update[1].compareTo(shipment[2]);
					if (eventdatediff_1>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[1]/span")).isDisplayed()) {
							System.out.println("Exception");
							eventVal_1=1;
						}
						else
							System.out.println("Exception not displayed in UI");
						
					}
				}
				else
					System.out.println("Event reported is OutGate but is not highlighted in UI");
		
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			
			String exceptionMssg_1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr/td")).getText();
			if (exceptionMssg_1.equals("No records found")){
				System.out.println("No records in Exceptions table");
			
				
			}
			else
				System.out.println("Exceptions are present in the Exceptions table");
		
			
				
			
			
			
//AG event
			//call ftp function and upload AG event EDI
			
			System.out.println("AG event");
			int agEve=0;
if (eventAG[1].equals("USMES")) {
				
				
				railArrivalEst=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				outGateEst=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				pickUpEst=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
				if (railArrivalEst.equals(eventAG[0]) & railArrivalEst.equals(eventAG[0]) & pickUpEst.equals(eventAG[0])) {
					System.out.println("Rail Estimated dates are updated from AG event EDI");
					agEve=1;
				}
				else 	 
					System.out.println("RailEstimates are  not updated from AG event EDI");	
					
				}
				
			
			
							
			else if (eventAG[1].equals("USSEA")){
				 	
				vesselArrivalEst =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				containerUnloadEst =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				railDepartureEst = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[2]")).getText().split(" ")[0];
				if ((vesselArrivalEst.equals(eventAG[0])) & (containerUnloadEst.equals(eventAG[0])) & (railDepartureEst.equals(eventAG[0]))){
					System.out.println("Ocean Estimated dates are updated from AG event EDI");
					agEve=2;
				}
				else System.out.println("Ocean Estimates are  not updated from AG event EDI");	
				
			}
System.out.println("AG :"+agEve);
if (eventVal_1==1){
	mypack.Report.MyReport("1", "TC03","Create and upload another event", "Pass");
	
}
else {
	mypack.Report.MyReport("1", "TC03","Create and upload another event", "Fail");
	
}
if(agEve>0) {
	mypack.Report.MyReport("1", "TC04", "Create and upload an AG event to see if the estimate is getting updated ","Pass");
}
else
	mypack.Report.MyReport("1", "TC04", "Create and upload an AG event to see if the estimate is getting updated ","Fail");
if (adv_Filter==1) {
	mypack.Report.MyReport("1", "TC05","Advanced Filter", "Pass");
	
}
else 
	mypack.Report.MyReport("1", "TC05","Advanced Filter ", "Fail");
if (sav_view==1) {
	mypack.Report.MyReport("1", "TC06","check Save view functionality", "Pass");
	
}
else 
	mypack.Report.MyReport("1", "TC06","check Save view functionality", "Fail");
if(attach_comm==1) {

mypack.Report.MyReport("1", "TC07","Add attachments ", "Pass");
}
else
	mypack.Report.MyReport("1", "TC07","Add attachments ", "Fail");
if(comm==2) {
	mypack.Report.MyReport("1", "TC08","Add Comments", "Pass");
	
}
else if((attach_comm!=2))
	mypack.Report.MyReport("1", "TC08","Add Comments", "Fail");

			driver.close();
			}
			}
			
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

		

	
		
//Scenario2:
			@SuppressWarnings("deprecation")
			public static void Scenario2(String fPathLocal_2,String fEVentpathLocal_2,String AGeventpathLocal_2) throws Exception{
				
				WebDriver driver;
				InputStream inputStream;
				InputStream inputStream2;
				InputStream inputStream2_event;
				String masterShipmenrRefnumUI=null;
				String statusSUmmary=null;
				String status_detail =null;
				String statusSUmmary_scn3=null;
				String status_detail_scn3=null;
				String status_e2eShipment=null;
				String legStatus_scn3=null;
				String Planned_date=null;
				String Reported_date=null;
				String railArrivalEst=null;
				String outGateEst=null;
				String pickUpEst=null;
				String railDepartureEst=null;
				String containerUnloadEst=null;
				String vesselArrivalEst=null;
				String	railArrival_nocon=null;
				String	outGate_nocon=null;
				String	pickUp_nocon=null;
				String	dropOff_nocon=null;
				String vesselDeparture_con=null;
				String	vesselArrival_con=null;
				String	containerUnload_con=null;
				String	railDeparture_con=null;
				String	railArrival_con=null;
				String	outGate_con=null;
				String	pickUp_con=null;
				String	dropOff_con=null;
				String statusSUmmary_scn5=null;
				String e2Estatus_scn5=null;
				String Planned_date_PK =null;
				String Planned_date_VD  =null;
				String Planned_date_VA =null;
				String Planned_date_UV  =null;
				String Planned_date_RL  =null;
				String Planned_date_AR =null;
				String Planned_date_OA =null;
				String Planned_date_dropoff=null;
				String Planned_date_CL=null;
				String Estimated_date_PK =null;
				String Estimated_date_VD  =null;
				String Estimated_date_VA =null;
				String Estimated_date_UV  =null;
				String Estimated_date_RL  =null;
				String Estimated_date_AR =null;
				String Estimated_date_OA =null;
				String Estimated_date_dropoff=null;
				String Estimated_date_CL=null;
				String[] event_type = mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_2);
			
				String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal_2);
				//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
				String[] shipment=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_2);
		
				//String[] noContainer=mypack.EDIRead.MyFunction_nocontainerEDI();
				//String containerEDI[]=mypack.EDIRead.MyFunction_containerEDI();
				try {
				String currentDir = System.getProperty("user.dir");			
				inputStream2 = new FileInputStream(currentDir+"\\Scenario2\\1_SecureFile1.xlsx");
				XSSFWorkbook wBook2 = new XSSFWorkbook(inputStream2);
				Sheet sheet2 = wBook2.getSheetAt(0);
				int rowCount = sheet2.getLastRowNum();
				//System.out.println("Number of rows : "+rowCount);
				
				for( int i=1;i<=rowCount;i++) {
					Row row1 = sheet2.getRow(i);
					System.out.println(row1.getCell(4).getStringCellValue());
					//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
				
				
				mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
				
				}
				Thread.sleep(300000);
				inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
				XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
				Sheet sheet = wBook.getSheetAt(0);
				Row row = sheet.getRow(2);
				String password=row.getCell(2).getStringCellValue();
				String username=row.getCell(1).getStringCellValue();
				String url=row.getCell(0).getStringCellValue();
				System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				driver = new ChromeDriver(capabilities);
				driver.get(url);
			  	driver.findElement(By.id("username")).sendKeys(username);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.name("submit")).click();
				wBook.close();
				inputStream.close();
				driver.manage().window().maximize() ;
		
				WebDriverWait wait = new WebDriverWait(driver,60);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
				
				
				driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
				driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
				Thread.sleep(20000);
				
				driver.switchTo().frame(0);
				
	//Scenario 1 : Save as view		
				int adv_Filter=0;
				int sav_view=0;
				driver.findElement(By.xpath("//*[contains(@class, 'MuiSvgIcon-root align-right grid-filter')]")).click();
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/form/div/div/div[2]/button")).click();
				Select advFilter = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[1]/select")));
				advFilter.selectByIndex(0);
				
				Select attchVal  = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[3]/select")));
				attchVal.selectByIndex(1);
				
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/div/div[2]/button[2]")).isEnabled()){
					System.out.println("Advance Filter is working");
					adv_Filter=1;
				}
				else
				{
					System.out.println("Advance Filter is not working");
					adv_Filter=2;
				}
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/div/div[2]/button[2]")).click();
				Thread.sleep(3000);
				WebElement Element_attachment = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[23]"));

		        //This will scroll the page Horizontally till the element is found		
		  
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;",Element_attachment);
				if (Element_attachment.getText().equalsIgnoreCase("Yes")) {
					System.out.println("Advance Filter is working");
					adv_Filter=1;
				}
				else
				{
					System.out.println("Advance Filter is not working");
					adv_Filter=2;
				}
				
				Thread.sleep(2000);	
				driver.findElement(By.xpath("//*[contains(@class, 'MuiSvgIcon-root align-right save-view')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[last()-1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/label[1]/input")).sendKeys("NewView");
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div/button[2]")).isEnabled()) {
					System.out.println("New View can be saved");
					sav_view=1;
				}
				else {
					System.out.println("New View cannot be saved");
					sav_view=2;
				}
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div/button[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[contains(@class, 'MuiSvgIcon-root align-right save-view')]")).click();
				driver.findElement(By.xpath("//*[@id=\"save-grid-menu\"]/div[3]/ul/li[1]")).click();
				Thread.sleep(3000);
				
							
	//Scenario 1 : check for summary
				
				Select selectMyElement = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
				selectMyElement.selectByVisibleText("Master Shipment Ref #");
				
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
				Thread.sleep(6000);
				driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
				Thread.sleep(100000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
				statusSUmmary=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div/div[1]/div[1]")).getText();
				System.out.println(statusSUmmary.split(" ")[1]);
				if (statusSUmmary.split(" ")[1].equals("Transit")) {
					
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
				}
				else if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]")).isDisplayed()){
			
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]")).click();
				}
				else
					System.out.println("Status of Shipment is still Planned");
			
			
				System.out.println("Status in summary page :"+statusSUmmary);
				Thread.sleep(3000);
				//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
				
				 status_detail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText();
				 System.out.println("Status in detail page : "+status_detail);
				//String status_summary = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div/div[1]")).getText();
				
				//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div[2]/div[3]/span/svg")).getAttribute("upload");
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/div[3]/span")).click();
				Thread.sleep(3000);
				int  retain_check=0;
				if (driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div[1]")).isDisplayed()) {
					retain_check=1;
				}
				else
					retain_check=2;
				int attach_comm=0;
				if (driver.findElement(By.xpath("//div[@class='attachment-modal']")).isDisplayed()) {
					driver.findElement(By.xpath("//div[@class='MuiFormControl-root attachment-type-dropdown']")).click();
					driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[3]")).click();
					Thread.sleep(1000);
					
					//File from_file = new File ("C:\\Users\\divya.mohan08\\eclipse-workspace\\EDI\\attachment.xlsx");
					
					WebElement droparea = driver.findElement(By.xpath("//div[@class='drag-drop-file']"));
					droparea.click();
					Thread.sleep(1000);
					Runtime.getRuntime().exec(currentDir+"\\FileUpload_scn2.exe");
					Thread.sleep(3000);
			
					
				if (driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[2]")).isEnabled()) {
					System.out.println("Yes");
				driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[2]")).click();
				attach_comm=1;
					
				}
				else
					
				attach_comm=2;
				driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[1]")).click();
				Thread.sleep(3000);
			
		
			
					//Comments
				
				int comm=0;
				if (driver.findElement(By.xpath("//div[@class='comment']")).getText().contains("added a/an comment")){
					retain_check=1;
				}
				else
					retain_check=2;
				
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[1]/div/div[1]/div")).click();
					if (driver.findElement(By.xpath("//*[@id=\"note\"]")).isEnabled()) {
						driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/button")).click();
						System.out.println("Comments can be added");
						 comm=1;
					}
					else {
						System.out.println("Not able to add comments");
						comm=2;
					}
					
					
					//Events, Milestones and Exceptions
					//take value of eventType from EDI Event Read class
					int eventVal =0;
			
					
					
					//take value of eventType from EDI Event Read class
					
					inputStream2_event = new FileInputStream(currentDir+"\\Scenario2\\2_SecureFile1.xlsx");
					XSSFWorkbook wBook2_event = new XSSFWorkbook(inputStream2_event);
					Sheet sheet2_event = wBook2_event.getSheetAt(0);
					int rowCount_event = sheet2_event.getLastRowNum();
					//System.out.println("Number of rows : "+rowCount);
					
					for( int i=1;i<=rowCount_event;i++) {

					
						Row row1 = sheet2_event.getRow(i);
						System.out.println(row1.getCell(4).getStringCellValue());
						//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
					
					
					mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
					
					}
					Thread.sleep(300000);
					driver.navigate().refresh();
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));

					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
					int eventdatediff=0;
					if (event_type[0].equals("AE")){
							if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
								System.out.println("Container Load event is reported ");
								eventVal=1;
								eventdatediff =event_type[1].compareTo(shipment[2]);
								if (eventdatediff>0) {
									
									if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[1]")).isDisplayed()) {
										System.out.println("Exception");
										eventVal=1;
									}
									else
										System.out.println("Exception not displayed in UI");
										
								}
							}
							else
								System.out.println("Event reported is Container Load but is not highlighted in UI");
							
						
						
							System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
					}
					else if (event_type[0].equals("VD")) {
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
							System.out.println("Vessel Departure event is reported ");
							eventVal=1;
							eventdatediff =event_type[1].compareTo(shipment[2]);
							if (eventdatediff>0) {
								
								if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[1]")).isDisplayed()) {
									System.out.println("Exception");
									eventVal=1;
								}
								else
									System.out.println("Exception not displayed in UI");
									
							}
						}
						else
							System.out.println("Event reported is Vessel Departure but is not highlighted in UI");
						
						
						
						System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
					}
				
					else if (event_type[0].equals("VA")) {
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
							System.out.println("Vessel Arrival event is reported ");
							eventVal=1;
							eventdatediff =event_type[1].compareTo(shipment[2]);
							if (eventdatediff>0) {
								
								if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]")).isDisplayed()) {
									System.out.println("Exception");
									eventVal=1;
								}
								else
									System.out.println("Exception not displayed in UI");
								
							}
						}
						else
							System.out.println("Event reported is Vessel Arrival  but is not highlighted in UI");
						
						
						
						System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
					}
					 
					else if (event_type[0].equals("UV")) {
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
							System.out.println("Container UnLoad event is reported ");
							eventVal=1;
							eventdatediff =event_type[1].compareTo(shipment[2]);
							if (eventdatediff>0) {
								
								if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).isDisplayed()) {
									System.out.println("Exception");
									eventVal=1;
								}
								else
									System.out.println("Exception not displayed in UI");
									
							}
						}
						else
							System.out.println("Event reported is Container UnLoad but is not highlighted in UI");
						
						
						
						System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
					}
					else if (event_type[0].equals("RL")) {
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
							System.out.println("Rail Departure event is reported ");
							eventVal=1;
							eventdatediff =event_type[1].compareTo(shipment[2]);
							if (eventdatediff>0) {
								
								if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[1]")).isDisplayed()) {
									System.out.println("Exception");
									eventVal=1;
								}
								else
									System.out.println("Exception not displayed in UI");
							
							}
						}
						else
							System.out.println("Event reported is Rail Departure but is not highlighted in UI");
					
					}
						
					else if (event_type[0].equals("AR")) {
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
							System.out.println("Rail Arrival event is reported ");
							eventVal=1;
							eventdatediff =event_type[1].compareTo(shipment[2]);
							if (eventdatediff>0) {
								
								if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[1]")).isDisplayed()) {
									System.out.println("Exception");
									eventVal=1;
								}
								else
									System.out.println("Exception not displayed in UI");
							
							}
						}
						else
							System.out.println("Event reported is Rail Arrival but is not highlighted in UI");
				
						
						System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
					}	
					else if (event_type[0].equals("OA")) {
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
							System.out.println("Out Gate event is reported ");
							eventVal=1;
							eventdatediff =event_type[1].compareTo(shipment[2]);
							if (eventdatediff>0) {
								
								if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[1]")).isDisplayed()) {
									System.out.println("Exception");
									eventVal=1;
								}
								else
									System.out.println("Exception not displayed in UI");
								
							}
						}
						else
							System.out.println("Event reported is OutGate but is not highlighted in UI");
						
						
							System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
					}
					
					String exceptionMssg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr/td")).getText();
					if (exceptionMssg.equals("No records found")){
						System.out.println("No records in Exceptions table");
						
						
					}
					else
					
						System.out.println("Exceptions are present in the Exceptions table");
					
					
					System.out.println("RetainCheck= "+retain_check);	
					if (retain_check==1){
						mypack.Report.MyReport("2", "TC09","Send the same shipment with purpose code Replace (05) ", "Pass");	
					}
					else {
						mypack.Report.MyReport("2", "TC09","Send the same shipment with purpose code Replace (05) ", "Fail");
						
					}
					System.out.println("EventVal= "+eventVal);	
					if (eventVal==1){
						mypack.Report.MyReport("2", "TC10","Create and upload events ", "Pass");
						
					}
					else {
						mypack.Report.MyReport("2", "TC10","Create and upload events ", "Fail");
						
					}
					System.out.println("AG event");
					int dateDiff = 0;
					int agEve=0;
					if (eventAG[1].equals("USMES")) {
						
						if((driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-1]")).getText().split(" ")[0].equals(eventAG[0]))
								& (driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-2]")).getText().split(" ")[0].equals(eventAG[0]))) 
								
						
						 {
							System.out.println("Rail Estimated dates are updated from AG event EDI");
							agEve=1;
						}
						else 	 
							System.out.println("RailEstimates are  not updated from AG event EDI");	
							
						}
						
					
					
									
					else if (eventAG[1].equals("USSEA")){
						 	
						if((driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0].equals(eventAG[0]))
								|| (driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0].equals(eventAG[0])))
						{
								
							System.out.println("Ocean Estimated dates are updated from AG event EDI");
							agEve=2;
						}
						else System.out.println("Ocean Estimates are  not updated from AG event EDI");	
						
					}
					
					if (agEve>0){
						mypack.Report.MyReport("2", "TC11","Create and upload an AG event to see if the estimate is getting updated ", "Pass");
						
						
					}
					else
						mypack.Report.MyReport("2", "TC11","Create and upload an AG event to see if the estimate is getting updated ", "Fail");
					
					
					if (adv_Filter==1) {
						mypack.Report.MyReport("2", "TC12","Advanced Filter", "Pass");
						
					}
					else 
						mypack.Report.MyReport("2", "TC12","Advanced Filter", "Fail");
					
					if (sav_view==1) {
						mypack.Report.MyReport("2", "TC13","check Save view functionality", "Pass");
					}
					else
						mypack.Report.MyReport("2", "TC13","check Save view functionality", "Fail");
						
					if (attach_comm==1) {
						mypack.Report.MyReport("2", "TC14","Add attachments", "Pass");
					}
					else
						mypack.Report.MyReport("2", "TC14","Add attachments", "Fail");
					
					if (comm==1) {
						mypack.Report.MyReport("2", "TC15","Add Comments", "Pass");
					}
					else
						mypack.Report.MyReport("2", "TC15","Add Comments", "Fail");
					
					
					driver.close();
					}
				}catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			
			
			
			
			
//Scenario 3 
@SuppressWarnings("deprecation")
public static void Scenario3(String fPathLocal_3,String fEVentpathLocal_3 ) throws Exception {
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream3;
	InputStream inputStream3_EDI;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	String[] event_type = mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_3);
	String[] shipment=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_3);

	try {
	
		String currentDir = System.getProperty("user.dir");	
		inputStream3 = new FileInputStream(currentDir+"\\Scenario3\\1_SecureFile1.xlsx");
		XSSFWorkbook wBook3 = new XSSFWorkbook(inputStream3);
		Sheet sheet3 = wBook3.getSheetAt(0);
		int rowCount = sheet3.getLastRowNum();
		System.out.println("Number of rows : "+rowCount);
		
		for( int i=1;i<=rowCount;i++) {
			Row row3 = sheet3.getRow(i);
		
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		
		mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());
		
		}
		//Thread.sleep(300000);
	 inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
  	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,300);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
	
	
	driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
	driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
	Thread.sleep(20000);
	
	driver.switchTo().frame(0);
	
	Select selectMyElement_Scn3 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
	selectMyElement_Scn3.selectByVisibleText("Master Shipment Ref #");
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
	Thread.sleep(100000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
	statusSUmmary_scn3=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div/div[1]/div[1]")).getText();

	
	System.out.println("Status in summary page :"+statusSUmmary_scn3);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
	mypack.Report.MyReport("3", "TC16","Create a new shipment (with purpose code 04) ", "Pass");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	
	 status_detail_scn3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText();
	 System.out.println("Status in detail page : "+status_detail_scn3);		 
				
				 
		if (status_detail_scn3.equals("Planned") & statusSUmmary_scn3.split(" ")[0].equals("Planned") ) {
			mypack.Report.MyReport("3", "TC17","Check for planned status on both Shipment summary and shipment details page ", "Pass");
		
		}
		else
			mypack.Report.MyReport("3", "TC17","Check for planned status on both Shipment summary and shipment details page ", "Fail");
	
		inputStream3_EDI = new FileInputStream(currentDir+"\\Scenario3\\2_SecureFile1.xlsx");
		XSSFWorkbook wBook3_EDI = new XSSFWorkbook(inputStream3_EDI);
		Sheet sheet3_EDI = wBook3_EDI.getSheetAt(0);
		int rowCount_EDI = sheet3_EDI.getLastRowNum();
		System.out.println("Number of rows : "+rowCount);
		
		for( int i=1;i<=rowCount;i++) {
			Row row3 = sheet3_EDI.getRow(i);
		
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		
		mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());
		
		}	
		
		Thread.sleep(300000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
		
		
		statusSUmmary_scn3=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div/div[1]/div[1]")).getText();
	
		
		System.out.println("STatus in summary page :"+statusSUmmary_scn3);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		
		status_e2eShipment = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText();
		 System.out.println("Status in detail page : "+status_e2eShipment);
		//check the status - Check if the e2e shipment status is “Active”  , and the status of the shipment legs should be “Planned” itself
	
			
		legStatus_scn3=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[1]/div/div[1]/div[1]/div[2]/span[2]")).getText();
		
		if(status_e2eShipment.equals("Active") & legStatus_scn3.equals("Planned") ) {
			mypack.Report.MyReport("3", "TC18","Send an event that does not match with milestone", "Pass");
		}
		else
			mypack.Report.MyReport("3", "TC18","Send an event that does not match with milestone", "Fail");
		Thread.sleep(1000);
		driver.close();
	}catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

			
//scenario : 4 : read two EDI files > take planned from EDI without container ID
	public static void Scenario4(String fPathLocal_nocont_4,String fPathLocal_cont_4,String fEVentpathLocal_4) throws Exception {		
		
		WebDriver driver;
		InputStream inputStream;
		InputStream inputStream4_nocontainer;
		InputStream inputStream4_container;
		InputStream inputStream2_eventEDI;
		String masterShipmenrRefnumUI=null;
		String statusSUmmary=null;
		String status_detail =null;
		String statusSUmmary_scn3=null;
		String status_detail_scn3=null;
		String status_e2eShipment=null;
		String legStatus_scn3=null;
		String Planned_date=null;
		String Reported_date=null;
		String railArrivalEst=null;
		String outGateEst=null;
		String pickUpEst=null;
		String dropOffEst=null;
		String railDepartureEst=null;
		String containerUnloadEst=null;
		String vesselArrivalEst=null;
		String containerID_scn4=null;
		String vesselArrival_scn4=null;
		String vesselDep_scn4=null;
		String railDep_scn4=null;
		String railArrival_scn4=null;
		String dropOff_scn4=null;
		String vesselDeparture_nocon=null;
		String	vesselArrival_nocon=null;
		String	containerUnload_nocon=null;
		String	railDeparture_nocon=null;
		String	railArrival_nocon=null;
		String	outGate_nocon=null;
		String	pickUp_nocon=null;
		String	dropOff_nocon=null;
		String vesselDeparture_con=null;
		String	vesselArrival_con=null;
		String	containerUnload_con=null;
		String	railDeparture_con=null;
		String	railArrival_con=null;
		String	outGate_con=null;
		String	pickUp_con=null;
		String	dropOff_con=null;
		String statusSUmmary_scn5=null;
		String e2Estatus_scn5=null;
		String Planned_date_PK =null;
		String Planned_date_VD  =null;
		String Planned_date_VA =null;
		String Planned_date_UV  =null;
		String Planned_date_RL  =null;
		String Planned_date_AR =null;
		String Planned_date_OA =null;
		String Planned_date_dropoff=null;
		String Planned_date_CL=null;
		String Estimated_date_PK =null;
		String Estimated_date_VD  =null;
		String Estimated_date_VA =null;
		String Estimated_date_UV  =null;
		String Estimated_date_RL  =null;
		String Estimated_date_AR =null;
		String Estimated_date_OA =null;
		String Estimated_date_dropoff=null;
		String Estimated_date_CL=null;
		String[] event_type = mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_4);
		String[] noContainer=mypack.EDIRead.MyFunction_nocontainerEDI(fPathLocal_nocont_4);
		String[] containerEDI=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_cont_4);
		try {
			String currentDir = System.getProperty("user.dir");
	        inputStream4_nocontainer = new FileInputStream(currentDir+"\\Scenario4\\1_SecureFile1.xlsx");
			XSSFWorkbook wBook4_nocontainer = new XSSFWorkbook(inputStream4_nocontainer);
			Sheet sheet4_nocontainer = wBook4_nocontainer.getSheetAt(0);
			int rowCount4_nocontainer = sheet4_nocontainer.getLastRowNum();
			System.out.println("Number of rows : "+rowCount4_nocontainer);
			
			for( int i=1;i<=rowCount4_nocontainer;i++) {
				Row row3 = sheet4_nocontainer.getRow(i);
			System.out.println(row3.getCell(5).getStringCellValue());
			System.out.println(row3.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());
			
			}	
			
		//Thread.sleep(300000);
		inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");	
		XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
		Sheet sheet = wBook.getSheetAt(0);
		Row row = sheet.getRow(2);
		String password=row.getCell(2).getStringCellValue();
		String username=row.getCell(1).getStringCellValue();
		String url=row.getCell(0).getStringCellValue();
		System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		driver = new ChromeDriver(capabilities);
		driver.get(url);
	  	driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		wBook.close();
		inputStream.close();
		driver.manage().window().maximize() ;

		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
		
		
		driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
		driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
		Thread.sleep(30000);

		
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		Select selectMyElement_Scn4 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
		selectMyElement_Scn4.selectByVisibleText("Master Shipment Ref #");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(noContainer[0]);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
		Thread.sleep(100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(noContainer[0]);
		String cont_grid = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[8]")).getText();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			containerID_scn4=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText();
			System.out.println("Container ID "+ containerID_scn4);
			System.out.println("Container ID in grid "+ cont_grid);
			if(containerID_scn4.equals("- - -"))  {
				mypack.Report.MyReport("4", "TC19","Create a new shipment without container ID ", "Pass");
			}
			else
				mypack.Report.MyReport("4", "TC19","Create a new shipment without container ID ", "Fail");
			
			//Add attachments
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/div[3]/span")).click();
			Thread.sleep(3000);
			int attach_comm=0;
			if (driver.findElement(By.xpath("//div[@class='attachment-modal']")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@class='MuiFormControl-root attachment-type-dropdown']")).click();
				driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[3]")).click();
				Thread.sleep(2000);
				
				//File from_file = new File ("C:\\Users\\divya.mohan08\\eclipse-workspace\\EDI\\attachment.xlsx");
				
				WebElement droparea = driver.findElement(By.xpath("//div[@class='drag-drop-file']"));
				droparea.click();
				Thread.sleep(2000);
				Runtime.getRuntime().exec(currentDir+"\\FileUpload_scn4.exe");
				Thread.sleep(2000);
				// drop the file
			/*DropFile(new File("D:\\BLUME\\Capture.PNG"), droparea, 0, 0);
				System.out.println("Drag and Drop fn called");
				Thread.sleep(3000);*/
				
//check which shipment is having attachment				
			if (driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[2]")).isEnabled()) {
			
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[2]")).click();
			attach_comm=1;
				
			}
			else
				
			attach_comm=2;
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[1]")).click();
			Thread.sleep(3000);
			
			//Add comments
			int comm=0;
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[1]/div/div[1]/div")).click();
			if (driver.findElement(By.xpath("//*[@id=\"note\"]")).isEnabled()) {
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/button")).click();
				System.out.println("Comments can be added");
				comm=2;
			}
			else {
				System.out.println("Not able to add comments");
			}
			
			if ((comm==2) & (attach_comm==1)) {
				mypack.Report.MyReport("4", "TC20","Add Comments & Attachments", "Pass");
			}
			else
				mypack.Report.MyReport("4", "TC20","Add Comments & Attachments", "Fail");
			
			
			
			
//call ftp and upload shipment with containerID
			
			inputStream4_container = new FileInputStream(currentDir+"\\Scenario4\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook4_container = new XSSFWorkbook(inputStream4_container);
			Sheet sheet4_container = wBook4_container.getSheetAt(0);
			int rowCount4_container = sheet4_container.getLastRowNum();
			System.out.println("Number of rows : "+rowCount4_container);
			
			for( int i=1;i<=rowCount4_container;i++) {
				Row row3 = sheet4_container.getRow(i);
			
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
				System.out.println(row3.getCell(5).getStringCellValue());
				System.out.println(row3.getCell(4).getStringCellValue());
			mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());
			
			}	
			
			Thread.sleep(300000);
			driver.navigate().refresh();
			
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			String cont_id=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[8]")).getText();
			//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();	
			WebElement Element_attachment = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[23]"));
			
	        //This will scroll the page Horizontally till the element is found		
	  
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;",Element_attachment);
			Thread.sleep(3000);
			
			if (Element_attachment.getText().equals("YES")) {
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();	
			}
			else
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			String cont_idDetail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText();
			System.out.println("containerEDI[6] "+containerEDI[6]);
			System.out.println("containerEDI[5]) "+containerEDI[5]);
			System.out.println("Container ID after replacing "+cont_id+" "+cont_idDetail);
			if(((cont_idDetail.equals(containerEDI[5])) || (cont_idDetail.equals(containerEDI[6])))
			& ((cont_id.equals(containerEDI[5])) || (cont_id.equals(containerEDI[6]))))
			{
				mypack.Report.MyReport("4", "TC21","Send the same shipment that now contains a container ID", "Pass");
			}
			else
				mypack.Report.MyReport("4", "TC21","Send the same shipment  that now contains a container ID", "Fail");
				
			vesselDeparture_con=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
			vesselArrival_con=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
			containerUnload_con=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
			railDeparture_con=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
			railArrival_con=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
			outGate_con=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
			pickUp_con=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
			dropOff_con=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];
			
			vesselDeparture_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			vesselArrival_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			containerUnload_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			railDeparture_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			railArrival_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			outGate_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			pickUp_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			dropOff_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			int date_check=0;
			
			System.out.println("noContainer[3]"+noContainer[3]);
			System.out.println("vesselArrival_nocon"+vesselArrival_nocon);
			if ((noContainer[3].equals(vesselArrival_nocon)) & (noContainer[3].equals(containerUnload_nocon)) & 
					(noContainer[3].equals(railDeparture_nocon)) & (noContainer[2].equals(railArrival_nocon)) & 
							(noContainer[2].equals(outGate_nocon)) &   (noContainer[2].equals(pickUp_nocon)))
					
			{
				System.out.println("Planned dates are updated from the no container EDI");
				date_check=1;
			}
			else
				
				System.out.println("Planned dates are not updated from the no container EDI");
			System.out.println("containerEDI[3]"+containerEDI[3]);
			System.out.println("vesselArrival_con"+vesselArrival_con);
			if ((containerEDI[3].equals(vesselArrival_con)) & (containerEDI[3].equals(containerUnload_con)) & 
					(containerEDI[3].equals(railDeparture_con)) 
					& (containerEDI[2].equals(railArrival_con)) & (containerEDI[2].equals(outGate_con)) &  
					(containerEDI[2].equals(pickUp_con)))
				
			{
				System.out.println("Estimated dates are updated from the  container EDI");
				date_check=1;
			}
			else
				System.out.println("Estimated dates are not updated from the  container EDI");
			
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/div[3]/span")).click();
			Thread.sleep(3000);
			int  retain_check=0;
			if (driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div[1]")).isDisplayed()) {
				retain_check=1;
			}
			else
				retain_check=2;
			
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/button[1]")).click();
		
			if (driver.findElement(By.xpath("//div[@class='comment']")).getText().contains("added a/an comment")){
				retain_check=1;
			}
			else
				retain_check=2;
			
			if((retain_check==1) & (date_check==1)) {
				mypack.Report.MyReport("4", "TC22","Check to confirm the shipment is created with correct details", "Pass");
			}
			else
				mypack.Report.MyReport("4", "TC22","Check to confirm the shipment is created with correct details", "Fail");
			}
		
			
			//Drop EDI file and check for exceptions
			int eventVal=0;
			inputStream2_eventEDI = new FileInputStream(currentDir+"\\Scenario4\\3_SecureFile1.xlsx");
			XSSFWorkbook wBook2_eventEDI = new XSSFWorkbook(inputStream2_eventEDI);
			Sheet sheet2_eventEDI = wBook2_eventEDI.getSheetAt(0);
			int rowCount_eventEDI = sheet2_eventEDI.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount_eventEDI;i++) {

			
				Row row1 = sheet2_eventEDI.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
			Thread.sleep(300000);
			driver.navigate().refresh();
			
			Thread.sleep(50000);
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(noContainer[0]);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			int eventdatediff=0;
			if (event_type[0].equals("AE")){
					if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
						System.out.println("Container Load event is reported ");
						eventVal=1;
						eventdatediff =event_type[1].compareTo(containerEDI[1]);
						if (eventdatediff>0) {
							
							if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[1]")).isDisplayed()) {
								System.out.println("Exception");
								eventVal=1;
							}
							else
								System.out.println("Exception not displayed in UI");
								
						}
					}
					else
						System.out.println("Event reported is Container Load but is not highlighted in UI");
					
				
				
					System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (event_type[0].equals("VD")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Vessel Departure event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(containerEDI[1]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
							
					}
				}
				else
					System.out.println("Event reported is Vessel Departure but is not highlighted in UI");
				
				
				
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
		
			else if (event_type[0].equals("VA")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Vessel Arrival event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(containerEDI[3]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
						
					}
				}
				else
					System.out.println("Event reported is Vessel Arrival  but is not highlighted in UI");
				
				
				
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			 
			else if (event_type[0].equals("UV")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Container UnLoad event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(containerEDI[3]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
							
					}
				}
				else
					System.out.println("Event reported is Container UnLoad but is not highlighted in UI");
				
				
				
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (event_type[0].equals("RL")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Rail Departure event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(containerEDI[3]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
					
					}
				}
				else
					System.out.println("Event reported is Rail Departure but is not highlighted in UI");
			
			}
				
			else if (event_type[0].equals("AR")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Rail Arrival event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(containerEDI[2]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
					
					}
				}
				else
					System.out.println("Event reported is Rail Arrival but is not highlighted in UI");
		
				
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}	
			else if (event_type[0].equals("OA")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Out Gate event is reported ");
					eventVal=1;
					eventdatediff =event_type[1].compareTo(containerEDI[2]);
					if (eventdatediff>0) {
						
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[1]")).isDisplayed()) {
							System.out.println("Exception");
							eventVal=1;
						}
						else
							System.out.println("Exception not displayed in UI");
						
					}
				}
				else
					System.out.println("Event reported is OutGate but is not highlighted in UI");
				
				
					System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			
			String exceptionMssg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr/td")).getText();
			if (exceptionMssg.equals("No records found")){
				System.out.println("No records in Exceptions table");
				
				
			}
			else
			
				System.out.println("Exceptions are present in the Exceptions table");
		if (eventVal==1) {
			mypack.Report.MyReport("4", "TC23","Report any event with exception", "Pass");
		}
		else
			mypack.Report.MyReport("4", "TC23","Report any event with exception", "Fail");	
		
		
		driver.close();
	
		}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	//scenario : 5
			
	public static void Scenario5(String fPathLocal_5,String fPathLocal_5Cancelled) throws Exception {
		WebDriver driver;
		InputStream inputStream;
		InputStream inputStream5;
		InputStream inputStream5_cancelled;
		String masterShipmenrRefnumUI=null;
		String statusSUmmary=null;
		String status_detail =null;
		String statusSUmmary_scn3=null;
		String status_detail_scn3=null;
		String status_e2eShipment=null;
		String legStatus_scn3=null;
		String Planned_date=null;
		String Reported_date=null;
		String railArrivalEst=null;
		String outGateEst=null;
		String pickUpEst=null;
		String dropOffEst=null;
		String railDepartureEst=null;
		String containerUnloadEst=null;
		String vesselArrivalEst=null;
		String containerID_scn4=null;
		String vesselArrival_scn4=null;
		String vesselDep_scn4=null;
		String railDep_scn4=null;
		String railArrival_scn4=null;
		String dropOff_scn4=null;
		String vesselDeparture_nocon=null;
		String	vesselArrival_nocon=null;
		String	containerUnload_nocon=null;
		String	railDeparture_nocon=null;
		String	railArrival_nocon=null;
		String	outGate_nocon=null;
		String	pickUp_nocon=null;
		String	dropOff_nocon=null;
		String vesselDeparture_con=null;
		String	vesselArrival_con=null;
		String	containerUnload_con=null;
		String	railDeparture_con=null;
		String	railArrival_con=null;
		String	outGate_con=null;
		String	pickUp_con=null;
		String	dropOff_con=null;
		String statusSUmmary_scn5=null;
		String e2Estatus_scn5=null;
		String Planned_date_PK =null;
		String Planned_date_VD  =null;
		String Planned_date_VA =null;
		String Planned_date_UV  =null;
		String Planned_date_RL  =null;
		String Planned_date_AR =null;
		String Planned_date_OA =null;
		String Planned_date_dropoff=null;
		String Planned_date_CL=null;
		String Estimated_date_PK =null;
		String Estimated_date_VD  =null;
		String Estimated_date_VA =null;
		String Estimated_date_UV  =null;
		String Estimated_date_RL  =null;
		String Estimated_date_AR =null;
		String Estimated_date_OA =null;
		String Estimated_date_dropoff=null;
		String Estimated_date_CL=null;
		//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
		String[] shipment=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_5);
		String[] shipment_cancel=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_5Cancelled);
		//String[] noContainer=mypack.EDIRead.MyFunction_nocontainerEDI();
		//String containerEDI[]=mypack.EDIRead.MyFunction_containerEDI();
		String currentDir = System.getProperty("user.dir");
		inputStream5 = new FileInputStream(currentDir+"\\Scenario5\\1_SecureFile1.xlsx");
		XSSFWorkbook wBook5 = new XSSFWorkbook(inputStream5);
		Sheet sheet5 = wBook5.getSheetAt(0);
		int rowCount5 = sheet5.getLastRowNum();
		//System.out.println("Number of rows : "+rowCount);
		
		for( int i=1;i<=rowCount5;i++) {
			Row row1 = sheet5.getRow(i);
			System.out.println(row1.getCell(4).getStringCellValue());
			System.out.println(row1.getCell(3).getStringCellValue());
			System.out.println(row1.getCell(2).getStringCellValue());
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		
		mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		}
	
					Thread.sleep(300000);
					
					


					inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
					
					XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
					Sheet sheet = wBook.getSheetAt(0);
					Row row = sheet.getRow(2);
					String password=row.getCell(2).getStringCellValue();
					String username=row.getCell(1).getStringCellValue();
					String url=row.getCell(0).getStringCellValue();
					System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
					DesiredCapabilities capabilities = new DesiredCapabilities();
					driver = new ChromeDriver(capabilities);
					driver.get(url);
				  	driver.findElement(By.id("username")).sendKeys(username);
					driver.findElement(By.id("password")).sendKeys(password);
					driver.findElement(By.name("submit")).click();
					wBook.close();
					inputStream.close();
					driver.manage().window().maximize() ;
			
					WebDriverWait wait = new WebDriverWait(driver,60);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
					
					
					
					driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
					driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
					Thread.sleep(20000);
					
					driver.switchTo().frame(0);
					
					Select selectMyElement = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
					selectMyElement.selectByVisibleText("Master Shipment Ref #");
					
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
					Thread.sleep(3000);
					System.out.println("Master Shipment :"+shipment[0]);
					driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
					Thread.sleep(100000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
					
					statusSUmmary_scn5=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).getText().split(" ")[0];
					System.out.println("Status in summary page :"+statusSUmmary_scn5);
					System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).getText());
					if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).getText().equals(shipment[0])) {
						mypack.Report.MyReport("5", "TC24","Create a new shipment (with purpose code 04)", "Pass");
					}
					else
						mypack.Report.MyReport("5", "TC24","Create a new shipment (with purpose code 04)", "Fail");	
					
					
//refreshing page>no records found,search again.record should be there					
				
					inputStream5_cancelled = new FileInputStream(currentDir+"\\Scenario5\\2_SecureFile1.xlsx");
					XSSFWorkbook wBook5_cancelled = new XSSFWorkbook(inputStream5_cancelled);
					Sheet sheet5_cancelled = wBook5_cancelled.getSheetAt(0);
					int rowCount5_cancelled = sheet5_cancelled.getLastRowNum();
					//System.out.println("Number of rows : "+rowCount);
					
					for( int i=1;i<=rowCount5_cancelled;i++) {
						Row row1 = sheet5_cancelled.getRow(i);
						System.out.println(row1.getCell(4).getStringCellValue());
						//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
					
					
					mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
					
					}
					Thread.sleep(300000);
					driver.navigate().refresh();
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
					mypack.Report.MyReport("5", "TC25","Send the same shipment with purpose code “Cancel” (01)", "Pass");
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).clear();
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
					Thread.sleep(3000);
				
					driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
					Thread.sleep(100000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
					
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
					
					e2Estatus_scn5 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText();
					if (e2Estatus_scn5.equals("Cancelled")) {
						System.out.println("Status is cancelled");
						mypack.Report.MyReport("5", "TC26","Verify that on searching with the Ship ref Number in the search bar and in the Advanced filter , the shipment comes up in the UI", "Pass");
					}
					else {
						System.out.println("Status is not displayed as Cancelled");
						mypack.Report.MyReport("5", "TC26","Verify that on searching with the Ship ref Number in the search bar and in the Advanced filter , the shipment comes up in the UI", "Fail");
		
					
	}
					
					driver.close();

	}

					
	//scenario 6
			
public static void Scenario6(String fPathLocal_6,String fEVentpathLocal_6, String AGeventpathLocal_6, String fPathLocal_6Replace ) throws Exception{
	WebDriver driver;
	InputStream inputStream6;
	InputStream inputStream;
	InputStream inputStream6_Replace;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment=mypack.EDIRead.MyFunction1(fPathLocal_6);
	String[] shipmentReplace = mypack.EDIRead.MyFunction1(fPathLocal_6Replace);
	String[] event_type = mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_6);
	String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal_6);

			//call ftp function and post a shipment with code 04
			//call ftp and post an AG event
			//call ftp and post milestone event with event time>AG event time
			//change purpose code to 05 and send the shipment again
	String currentDir = System.getProperty("user.dir");
    System.out.println("Current dir using System:" +currentDir);

    inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	inputStream6 = new FileInputStream(currentDir+"\\Scenario6\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook6 = new XSSFWorkbook(inputStream6);
	Sheet sheet6 = wBook6.getSheetAt(0);
	int rowCount6 = sheet6.getLastRowNum();
	System.out.println("Number of rows : "+rowCount6);
	
	for( int i=1;i<=rowCount6;i++) {
		Row row1 = sheet6.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
	Thread.sleep(300000);
	
	
	
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
 	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
	
	
	driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
	driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
	Thread.sleep(20000);
	
	driver.switchTo().frame(0);
	Thread.sleep(3000);
	Select selectMyElement = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
	selectMyElement.selectByVisibleText("Master Shipment Ref #");
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
	System.out.println("master shipment :"+shipment[0]);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
	Thread.sleep(100000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).getText().equals(shipment[0])) {
		mypack.Report.MyReport("6", "TC27","Create a new shipment (with purpose code 04)", "Pass");
	}
	else
		mypack.Report.MyReport("6", "TC27","Create a new shipment (with purpose code 04)", "Fail");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	
	
	int dateDiff = 0;
	int agEve=0;
	if (eventAG[1].equals("USMES")) {
		
		
		railArrivalEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-3]")).getText().split(" ")[0];
		outGateEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-2]")).getText().split(" ")[0];
		pickUpEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-1]")).getText().split(" ")[0];
		System.out.println("railArrivalEst "+railArrivalEst);
		System.out.println("eventAG "+eventAG[0]);
		if((railArrivalEst.equals(eventAG[0])) & (outGateEst.equals(eventAG[0])) & (pickUpEst.equals(eventAG[0]))) {
			System.out.println("Rail Estimated dates are updated from AG event EDI");
			agEve=1;
		}
		else 	 
			System.out.println("RailEstimates are  not updated from AG event EDI");	
			
		}
		
	
	
					
	else if (eventAG[1].equals("USSEA")){
		 	
		vesselArrivalEst =  driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-6]")).getText().split(" ")[0];
		containerUnloadEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-5]")).getText().split(" ")[0];
		railDepartureEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-4]")).getText().split(" ")[0];
		
		if ((vesselArrivalEst.equals(eventAG[0])) & (containerUnloadEst.equals(eventAG[0])) & (railDepartureEst.equals(eventAG[0]))){
			System.out.println("Ocean Estimated dates are updated from AG event EDI");
			agEve=2;
		}
		else System.out.println("Ocean Estimates are  not updated from AG event EDI");	
		
	}
	if (agEve>0){
		mypack.Report.MyReport("6", "TC28","Create and upload an AG event to see if the estimate is getting updated", "Pass");
		
		
	}
	else
		mypack.Report.MyReport("6", "TC28","Create and upload an AG event to see if the estimate is getting updated", "Fail");
	
	
	int scn6_flag=0;
			if (event_type[0].equals("AE")){
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Container Load event is reported ");
					scn6_flag=1;
				}
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
		}
		else if (event_type[0].equals("VD")) {
			if (driver.findElement(By.xpath("///*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
				System.out.println("Vessel Departure event is reported ");
				scn6_flag=1;
			}
			Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
		}
	
		else if (event_type[0].equals("VA")) {
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
				System.out.println("Vessel Arrival event is reported ");
				scn6_flag=1;
			}
			Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			scn6_flag=1;
		}
		 
		else if (event_type[0].equals("UV")) {
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
				System.out.println("Container UnLoad event is reported ");
				scn6_flag=1;
			}
			Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
		}
		else if (event_type[0].equals("RL")) {
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
				System.out.println("Rail Departure event is reported ");
				scn6_flag=1;
			}
			Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
			 Planned_date = driver.findElement(By.xpath("///*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
		}
		else if (event_type[0].equals("AR")) {
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
				System.out.println("Rail Arrival event is reported ");
				scn6_flag=1;
			}
			Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
		}	
		else if (event_type[0].equals("OA")) {
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
				System.out.println("Out Gate event is reported ");
				scn6_flag=1;
			}
			Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
		}
		
		
	if((Reported_date.equals(event_type[1])) & (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText().equals("Active"))){
mypack.Report.MyReport("6", "TC29","Post a milestone event (For Example: Vessel Arrival, Rail Departure etc.) with event time > AG event time", "Pass");
		
		
	}
	else
		mypack.Report.MyReport("6", "TC29","Post a milestone event (For Example: Vessel Arrival, Rail Departure etc.) with event time > AG event time", "Fail");
	
		
		
		inputStream6_Replace = new FileInputStream(currentDir+"\\Scenario6\\2_SecureFile1.xlsx");
		XSSFWorkbook wBook6_Replace = new XSSFWorkbook(inputStream6_Replace);
		Sheet sheet6_Replace = wBook6_Replace.getSheetAt(0);
		int rowCount6_Replace = sheet6_Replace.getLastRowNum();
		System.out.println("Number of rows : "+rowCount6_Replace);
		
		for( int i=1;i<=rowCount6_Replace;i++) {
			Row row1 = sheet6_Replace.getRow(i);
			System.out.println(row1.getCell(4).getStringCellValue());
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		
		mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		}
		Thread.sleep(300000);
		
		//planned date should be equal to event date in event EDI file	
		
		driver.navigate().refresh();
		Thread.sleep(100000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	
		//ask Sasi what all needs to be checked
		Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-1]")).getText().split(" ")[0];
		
		Estimated_date_VA= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-6]")).getText().split(" ")[0];
		Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-5]")).getText().split(" ")[0];
		Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-4]")).getText().split(" ")[0];
		Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-3]")).getText().split(" ")[0];
		Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()-2]")).getText().split(" ")[0];
		Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[last()]")).getText().split(" ")[0];
		
System.out.println("Estimated_date_AR "+Estimated_date_AR);
System.out.println("shipmentReplace "+shipmentReplace[4]);
		if (Estimated_date_AR.equals(shipmentReplace[4]) &  Estimated_date_OA.equals(shipmentReplace[4]) & Estimated_date_PK.equals(shipmentReplace[4]) &
						Estimated_date_RL.equals(shipmentReplace[3]) & Estimated_date_VA.equals(shipmentReplace[3]) & Estimated_date_UV.equals(shipmentReplace[3]) & Estimated_date_dropoff.equals(shipmentReplace[5]))
					 {
			System.out.println("Estimated Dates  are updated from Replaced EDI");
			mypack.Report.MyReport("6", "TC30","Replace the shipment with change in estimates", "Pass");
			mypack.Report.MyReport("6", "TC31","Check to confirm if all the events and milestones are getting processed", "Pass");
		}
		else
		{
			mypack.Report.MyReport("6", "TC30","Replace the shipment with change in estimates", "Fail");
			mypack.Report.MyReport("6", "TC31","Check to confirm if all the events and milestones are getting processed", "Fail");
		}
	
		
		driver.close();
}

			
			
//scenario 7

public static void Scenario7(String fPathLocal_7_woDTM,String fPathLocal_7_withDTM,String fPathLocal_7_DTMChanged, String AGeventpathLocal_7_Greater, String AGeventpathLocal_7_Less ) throws Exception {
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream7_DTM;
	InputStream inputStream7;
	InputStream inputStream7_ReplacedDTM;
	InputStream inputStreamAG_Greater;
	InputStream inputStreamAG_Lessr;	
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment_noDTM=mypack.EDIRead.MyFunction2_noDTM(fPathLocal_7_woDTM);
	String[] shipment_DTM=mypack.EDIRead.MyFunction1(fPathLocal_7_withDTM);
	String[] shipment_ChangedDTM=mypack.EDIRead.MyFunction1(fPathLocal_7_DTMChanged);
	String[] eventAG_Greater=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal_7_Greater);
	String[] eventAG_Less=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal_7_Less);

			//call ftp to upload shipment without dtm 369 segment
	String currentDir = System.getProperty("user.dir");
	
	inputStream7 = new FileInputStream(currentDir+"\\Scenario7\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook7= new XSSFWorkbook(inputStream7);
	Sheet sheet7 = wBook7.getSheetAt(0);
	int rowCount7 = sheet7.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount7;i++) {
		Row row1 = sheet7.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
			Thread.sleep(300000);
			//click on draft shipment
			inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
			
			
			driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
			driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
			Thread.sleep(20000);
			
			driver.switchTo().frame(0);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div/div[4]")).click();
			Thread.sleep(20000);
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_noDTM[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_noDTM[0]);
			int draftVal=0;
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).isDisplayed()){
				System.out.println("Shipment is present in Draft Shipments");
				draftVal=1;
			}
			else
				System.out.println("Shipment is not present in Draft Shipments");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).isDisplayed()) {
				draftVal=-1;
			}
			else
				draftVal=3;
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText().equals("Draft")) {
				System.out.println("Shipment is in Draft Status");
				draftVal=2;
			}
			else
				System.out.println("Shipment is not in draft status");
			System.out.println(draftVal);
			if (draftVal>0) {
				mypack.Report.MyReport("7", "TC32","Create a shipment without DTM 369 segment. Validate whether the shipment is created in Draft status and there is no planned or estimated dates for that shipment.", "Pass");
			}
			else
				mypack.Report.MyReport("7", "TC32","Create a shipment without DTM 369 segment. Validate whether the shipment is created in Draft status and there is no planned or estimated dates for that shipment.", "Fail");
			//call ftp and upload shipment with purpose code 05 and dtm segment
			
			inputStream7_DTM = new FileInputStream(currentDir+"\\Scenario7\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook7_DTM= new XSSFWorkbook(inputStream7_DTM);
			Sheet sheet7_DTM = wBook7_DTM.getSheetAt(0);
			int rowCount7_DTM = sheet7_DTM.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount7_DTM;i++) {
				Row row1 = sheet7_DTM.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
			
			Thread.sleep(300000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			int planStat=0;
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			if ((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[10]/div[2]")).getText().equals("Planned")) &
			(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).isDisplayed()))
			{
				System.out.println("Shipment is in Planned Status");
				mypack.Report.MyReport("7", "TC33","Replace the shipment (purpose code 05) with DTM 369 segment. Validate whether the planned and estimated dates for all the legs are displayed and status of the shipment is Planned", "Pass");
			}
			else {
				System.out.println("Shipment is not in Planned status");
				mypack.Report.MyReport("7", "TC33","Replace the shipment (purpose code 05) with DTM 369 segment. Validate whether the planned and estimated dates for all the legs are displayed and status of the shipment is Planned", "Fail");
			}
		// Dates replaced shipment - FTP call
			
			inputStream7_ReplacedDTM = new FileInputStream(currentDir+"\\Scenario7\\3_SecureFile1.xlsx");
			XSSFWorkbook wBook7_ReplacedDTM= new XSSFWorkbook(inputStream7_ReplacedDTM);
			Sheet sheet7_ReplacedDTM = wBook7_ReplacedDTM.getSheetAt(0);
			int rowCount7_ReplacedDTM = sheet7_ReplacedDTM.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount7_ReplacedDTM;i++) {
				Row row1 = sheet7_ReplacedDTM.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
			
			Thread.sleep(300000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			
			Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			int dateCheck=0;
			if((Planned_date_AR.equals(shipment_DTM[4])) & (Planned_date_OA.equals(shipment_DTM[4])) & (Planned_date_PK.equals(shipment_DTM[4]))
			& (Planned_date_VA.equals(shipment_DTM[3])) & (Planned_date_UV.equals(shipment_DTM[3])) & (Planned_date_RL.equals(shipment_DTM[3])))
			{
			
				System.out.println(" Planned dates are updated from DTM EDI");
				dateCheck=1;
			}
			else 	 
				System.out.println(" Planned are  not updated from DTM EDI");	
			
	
			
		
		
			
			//Estimated Dates
			railArrivalEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
			outGateEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
			pickUpEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
			vesselArrivalEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
			containerUnloadEst =  driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
			railDepartureEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
			
				
			if ((railArrivalEst.equals(shipment_ChangedDTM[4])) & (railArrivalEst.equals(shipment_ChangedDTM[4])) & (pickUpEst.equals(shipment_ChangedDTM[4])) &
				(vesselArrivalEst.equals(shipment_ChangedDTM[3])) & (containerUnloadEst.equals(shipment_ChangedDTM[3])) & (railDepartureEst.equals(shipment_ChangedDTM[3]))){
			
				System.out.println(" Estimated dates are updated from Updated DTM EDI");
				dateCheck=2;
			}
			else 	 
				System.out.println("Estimates are  not updated from Updated DTM EDI");	
			
			
		System.out.println("dateCheck "+dateCheck);
		
			if (dateCheck==2) {
				mypack.Report.MyReport("7", "TC34","Replace the shipment (purpose code 05) with change in dates in the DTM segment", "Pass");
			}
	 
			else
				mypack.Report.MyReport("7", "TC34","Replace the shipment (purpose code 05) with change in dates in the DTM segment", "Fail");
			//call ftp and post AG event
		
			
			inputStreamAG_Greater = new FileInputStream(currentDir+"\\Scenario7\\4_SecureFile1.xlsx");
			XSSFWorkbook wBook7_AGGreate= new XSSFWorkbook(inputStreamAG_Greater);
			Sheet sheet7_AGGreate = wBook7_AGGreate.getSheetAt(0);
			int rowCount7_AGGreate = sheet7_AGGreate.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount7_AGGreate;i++) {
				Row row1 = sheet7_AGGreate.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}	
			
			Thread.sleep(300000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			int agEve1=0;
			//AG event such that AG event time for that milestone is greater than the Existing estimated date for that milestone. AG event should get processed
			
	if (eventAG_Greater[1].equals("USMES")) {
				
				
		railArrivalEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
		outGateEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
		pickUpEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
				if (railArrivalEst.equals(eventAG_Greater[0]) & railArrivalEst.equals(eventAG_Greater[0]) & pickUpEst.equals(eventAG_Greater[0])) {
					System.out.println("Rail Estimated dates are updated from AG event EDI");
					agEve1=1;
				}
				else 	 
					System.out.println("RailEstimates are  not updated from AG event EDI");	
				}
				
			
			
							
			else if (eventAG_Greater[1].equals("USSEA")){
				 
				vesselArrivalEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
				containerUnloadEst =  driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
				railDepartureEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
				
				if ((vesselArrivalEst.equals(eventAG_Greater[0])) & (containerUnloadEst.equals(eventAG_Greater[0])) & (railDepartureEst.equals(eventAG_Greater[0]))){
					System.out.println("Ocean Estimated dates are updated from AG event EDI");
					agEve1=2;
				}
				else System.out.println("Ocean Estimates are  not updated from AG event EDI");	
			}
		
	if (agEve1>0) {
		mypack.Report.MyReport("7", "TC35","Post an AG event such that AG event time for that milestone is greater than the Existing estimated date for that milestone", "Pass");
	}

	else
		mypack.Report.MyReport("7", "TC35","Post an AG event such that AG event time for that milestone is greater than the Existing estimated date for that milestone", "Fail");
	
	//call ftp
	
	inputStreamAG_Lessr = new FileInputStream(currentDir+"\\Scenario7\\5_SecureFile1.xlsx");
	XSSFWorkbook wBook7_AGLessr= new XSSFWorkbook(inputStreamAG_Lessr);
	Sheet sheet7_AGLessr = wBook7_AGLessr.getSheetAt(0);
	int rowCount7_AGLessr = sheet7_AGLessr.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount7_AGLessr;i++) {
		Row row1 = sheet7_AGLessr.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}	
	
	Thread.sleep(300000);
	driver.navigate().refresh();
	Thread.sleep(3000);
	driver.switchTo().frame(0);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	
	//AG event such that AG event time is less than the Existing estimated date for that milestone. AG event should not get processed
	
	int agEve2=0;
	
	Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

	Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
	Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
	Estimated_date_VA= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
	Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
	Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
	Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
	Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
	Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];
	Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];

System.out.println("Planned_date_AR "+Planned_date_AR);
System.out.println("shipment_DTM "+shipment_DTM[4]);

System.out.println("Estimated_date_RL "+Estimated_date_RL);
System.out.println("shipment_DTM "+shipment_DTM[3]);

	if (Planned_date_AR.equals(shipment_DTM[4]) & Planned_date_OA.equals(shipment_DTM[4]) & Planned_date_PK.equals(shipment_DTM[4]) & 
			Estimated_date_AR.equals(shipment_ChangedDTM[4]) &  Estimated_date_OA.equals(shipment_ChangedDTM[4]) & Estimated_date_PK.equals(shipment_ChangedDTM[4]) &
			Planned_date_RL.equals(shipment_DTM[3]) & Planned_date_VA.equals(shipment_DTM[3]) & Planned_date_UV.equals(shipment_DTM[3]) & Planned_date_dropoff.equals(shipment_DTM[5]) &
					Estimated_date_RL.equals(shipment_ChangedDTM[3]) & Estimated_date_VA.equals(shipment_ChangedDTM[3]) & Estimated_date_UV.equals(shipment_ChangedDTM[3]) & Estimated_date_dropoff.equals(shipment_ChangedDTM[5])
					&Planned_date_CL.equals(shipment_DTM[2]) & Planned_date_VD.equals(shipment_DTM[2]) & Estimated_date_CL.equals(shipment_ChangedDTM[2]) & Estimated_date_VD.equals(shipment_ChangedDTM[2])) {
		System.out.println("Planned Dates and Estimated Dates  are updated from Replaced EDI");
		agEve2=1;
	}
	else
		System.out.println("Planned Dates and Estimated Dates are not updated from Replaced EDI");

	if (agEve2>0) {
		mypack.Report.MyReport("7", "TC36","Post an AG event such that AG event time for that milestone is less than the Existing estimated date for that milestone", "Pass");
	}

	else
		mypack.Report.MyReport("7", "TC36","Post an AG event such that AG event time for that milestone is less than the Existing estimated date for that milestone", "Fail");
	
	
	
	driver.close();
}

			

//scenario 8
public static void Scenario8(String fPathLocal_8_woDTM,String fPathLocal_8_withDTM, String AGeventpathLocal_8 ) throws Exception {			

	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream8;
	InputStream inputStream8_replaced;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	//String[] shipment_noDTM=mypack.EDIRead.MyFunction1(fPathLocal_8_woDTM);
	String[] shipment_DTM=mypack.EDIRead.MyFunction1(fPathLocal_8_withDTM);
	String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal_8);	
			//call ftp and upload AG event 
			//call ftp and upload shipment without dtm 369 segment
	String currentDir = System.getProperty("user.dir");
	inputStream8 = new FileInputStream(currentDir+"\\Scenario8\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook8 = new XSSFWorkbook(inputStream8);
	Sheet sheet8 = wBook8.getSheetAt(0);
	int rowCount8 = sheet8.getLastRowNum();
	System.out.println("Number of rows : "+rowCount8);
	
	for( int i=1;i<=rowCount8;i++) {
		Row row1 = sheet8.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		System.out.println(row1.getCell(3).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
	mypack.Report.MyReport("8", "TC37","Post an AG event such that AG event time for that milestone is less than the Existing estimated date for that milestone", "Pass");
	Thread.sleep(300000);
	
	inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
 	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
	
	
	driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
	driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
	Thread.sleep(20000);
	
	driver.switchTo().frame(0);
	
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div/div[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_DTM[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_DTM[0]);
			int statusVal=0;
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).isDisplayed()){
				System.out.println("Shipment is present in Draft Shipments");
				statusVal=1;
			}
			else
			{
				System.out.println("Shipment is not present in Draft Shipments");
			}
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			if ((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText().equals("Draft")))
			
			{
				System.out.println("Shipment is in Draft Status");
				statusVal=2;
			}
			else
				System.out.println("Shipment is not in draft status");
			
			
			if (statusVal==2) {
				mypack.Report.MyReport("8", "TC38","Create a shipment without DTM 369 segment. Validate whether the shipment is created in Draft status and there is no planned or estimated dates for that shipment.", "Pass");
			}

			else
				mypack.Report.MyReport("8", "TC38","Create a shipment without DTM 369 segment. Validate whether the shipment is created in Draft status and there is no planned or estimated dates for that shipment.", "Fail");
			
			
			//call ftp and drop replaced 369 edi
			

			inputStream8_replaced = new FileInputStream(currentDir+"\\Scenario8\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook8_replaced = new XSSFWorkbook(inputStream8_replaced);
			Sheet sheet8_replaced = wBook8_replaced.getSheetAt(0);
			int rowCount8_replaced = sheet8_replaced.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
							
					for( int i=1;i<=rowCount8_replaced;i++) {
							Row row1 = sheet8_replaced.getRow(i);
							System.out.println(row1.getCell(4).getStringCellValue());
							//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
							
							
							mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
							
							}
							
					Thread.sleep(300000);
					driver.navigate().refresh();
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			//check for Estimated dates
			Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
			Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
			Estimated_date_VA= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
			Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
			Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
			Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
			Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
			Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];
			Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];


			//check for Planned Dates
			int agEve=0;
			Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			if (Planned_date_AR.equals(shipment_DTM[4]) & Planned_date_OA.equals(shipment_DTM[4]) & Planned_date_PK.equals(shipment_DTM[4]) & 
					Estimated_date_AR.equals(shipment_DTM[4]) &  Estimated_date_OA.equals(shipment_DTM[4]) & Estimated_date_PK.equals(shipment_DTM[4]) &
					Planned_date_RL.equals(shipment_DTM[3]) & Planned_date_VA.equals(shipment_DTM[3]) & Planned_date_UV.equals(shipment_DTM[3]) & Planned_date_dropoff.equals(shipment_DTM[5]) &
							Estimated_date_RL.equals(shipment_DTM[3]) & Estimated_date_VA.equals(shipment_DTM[3]) & Estimated_date_UV.equals(shipment_DTM[3]) & Estimated_date_dropoff.equals(shipment_DTM[5])
							&Planned_date_CL.equals(shipment_DTM[2]) & Planned_date_VD.equals(shipment_DTM[2]) & Estimated_date_CL.equals(shipment_DTM[2]) & Estimated_date_VD.equals(shipment_DTM[2])) {
				System.out.println("Planned & Estimated Dates are updated from Replaced EDI");
				agEve=1;
			}
			else
				System.out.println("Planned & Estimated Dates are not updated from Replaced EDI");
			System.out.println("agEve"+agEve);
			if (agEve==1) {
				mypack.Report.MyReport("8", "TC39","Replace the shipment (purpose code 05) with DTM 369 segment. Validate whether the planned and estimated dates for all the legs is updated from the Replace EDI856", "Pass");
			}

			else
			{
				mypack.Report.MyReport("8", "TC39","Replace the shipment (purpose code 05) with DTM 369 segment. Validate whether the planned and estimated dates for all the legs is updated from the Replace EDI856", "Fail");
			
			}
			
			driver.close();
			
}

			
//scenario9
	
public static void Scenario9(String fPathLocal_9_woDTM,String fPathLocal_9_withDTM, String AGeventpathLocal_9 ) throws Exception {			

	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream9;
	InputStream inputStream9_replaced;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment_noDTM=mypack.EDIRead.MyFunction2_noDTM(fPathLocal_9_woDTM);
	String[] shipment_DTM=mypack.EDIRead.MyFunction1(fPathLocal_9_withDTM);
	String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal_9);	
			//call ftp and upload AG event 
			//call ftp and upload shipment without dtm 369 segment
	String currentDir = System.getProperty("user.dir");
	inputStream9 = new FileInputStream(currentDir+"\\Scenario9\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook9 = new XSSFWorkbook(inputStream9);
	Sheet sheet9 = wBook9.getSheetAt(0);
	int rowCount9 = sheet9.getLastRowNum();
	System.out.println("Number of rows : "+rowCount9);
	
	for( int i=1;i<=rowCount9;i++) {
		Row row1 = sheet9.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		System.out.println(row1.getCell(3).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}

	Thread.sleep(300000);
	
	inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
 	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
	
	mypack.Report.MyReport("9", "TC40","Post an AG event such that AG event time for that milestone is greater than the Existing estimated date for that milestone", "Pass");
	driver.findElement(By.xpath("//*[@id='toggle'][2]")).click();
	driver.findElement(By.xpath("//*[@id='10']/a[1]")).click();
	Thread.sleep(20000);
	
	driver.switchTo().frame(0);
	
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div/div[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_DTM[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_DTM[0]);
			int draftVal=0;
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).isDisplayed()){
				System.out.println("Shipment is present in Draft Shipments");
				draftVal=1;
			}
			else
				System.out.println("Shipment is not present in Draft Shipments");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText().equals("Draft"))
			
{
				System.out.println("Shipment is in Draft Status and there are no Planned dates present");
				draftVal=2;
			}
			else
				System.out.println("Shipment is not in draft status");
			
			if (draftVal==2) {
				mypack.Report.MyReport("9", "TC41","Create a shipment without DTM 369 segment. Validate whether the shipment is created in Draft status and there is no planned or estimated dates for that shipment.", "Pass");
			}

			else
				mypack.Report.MyReport("9", "TC41","Create a shipment without DTM 369 segment. Validate whether the shipment is created in Draft status and there is no planned or estimated dates for that shipment.", "Fail");
			
			
					
			//call ftp and drop replaced 369 edi
			

			inputStream9_replaced = new FileInputStream(currentDir+"\\Scenario9\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook9_replaced = new XSSFWorkbook(inputStream9_replaced);
			Sheet sheet9_replaced = wBook9_replaced.getSheetAt(0);
			int rowCount9_replaced = sheet9_replaced.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
							
					for( int i=1;i<=rowCount9_replaced;i++) {
							Row row1 = sheet9_replaced.getRow(i);
							System.out.println(row1.getCell(4).getStringCellValue());
							//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
							
							
							mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
							
							}
							
			Thread.sleep(300000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			
			//call ftp and upload Replace the shipment(purpose code 05) with DTM 369 segment.
			
			

			Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

			Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
			Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
			Estimated_date_VA= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
			Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
			Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
			Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
			Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
			Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];
			Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
			
			if (Planned_date_AR.equals(shipment_DTM[4]) & Planned_date_OA.equals(shipment_DTM[4]) & Planned_date_PK.equals(shipment_DTM[4]) & 
					Estimated_date_AR.equals(shipment_DTM[4]) &  Estimated_date_OA.equals(shipment_DTM[4]) & Estimated_date_PK.equals(shipment_DTM[4]) &
					Planned_date_RL.equals(shipment_DTM[3]) & Planned_date_VA.equals(shipment_DTM[3]) & Planned_date_UV.equals(shipment_DTM[3]) & Planned_date_dropoff.equals(shipment_DTM[5]) &
							Estimated_date_RL.equals(shipment_DTM[3]) & Estimated_date_VA.equals(shipment_DTM[3]) & Estimated_date_UV.equals(shipment_DTM[3]) & Estimated_date_dropoff.equals(shipment_DTM[5])
							&Planned_date_CL.equals(shipment_DTM[2]) & Planned_date_VD.equals(shipment_DTM[2]) & Estimated_date_CL.equals(shipment_DTM[2]) & Estimated_date_VD.equals(shipment_DTM[2])) {
				System.out.println("Planned Dates and Estimated Dates  are updated from Replaced EDI");
				mypack.Report.MyReport("9", "TC42","Replace the shipment (purpose code 05) with DTM 369 segment. Validate whether the AG event time is updated in the Estimated dates ,and the Planned dates is updated from the Replace EDI856", "Pass");
			}
			else
			{
				mypack.Report.MyReport("9", "TC42","Replace the shipment (purpose code 05) with DTM 369 segment. Validate whether the AG event time is updated in the Estimated dates ,and the Planned dates is updated from the Replace EDI856", "Fail");
			}
			
			driver.close();
			
}


public static void Scenario10(String fPathLocal_10,String AGeventpathLocal_10,String fEVentpathLocal_10, String fPathLocal_10_Replacement) throws Exception{
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream10;
	InputStream inputStream10_UVEvent;
	InputStream inputStream10_Replacement;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	String containerLoad=null;
	String vesselDeparture=null;
	String scenario10_legStatus=null;
	String billofLadingUI=null;
	String houseBillNumUI=null;
	String bookingNumUI=null;
	String importFilenumUI=null;
	String consigneeRefUI=null;
	String ultimateConsignee=null;
	String PONumber=null;
	String scenario10_legStatus_afterReplacement=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment=mypack.EDIRead.MyFunction1(fPathLocal_10);
	String[] shipment_EstDates=mypack.EDIRead.MyFunction1(fPathLocal_10_Replacement);
	//String[] shipment_PONum=mypack.EDIRead.MyFunction1(fPathLocal_10_Replacement2);
	String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal_10);	
	String[] eventType=mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_10);
			//call ftp and upload AG event 
			//call ftp and upload shipment without dtm 369 segment
	String currentDir = System.getProperty("user.dir");
	inputStream10 = new FileInputStream(currentDir+"\\Scenario10\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook10 = new XSSFWorkbook(inputStream10);
	Sheet sheet10 = wBook10.getSheetAt(0);
	int rowCount10 = sheet10.getLastRowNum();
	System.out.println("Number of rows : "+rowCount10);
	
	for( int i=1;i<=rowCount10;i++) {
		Row row1 = sheet10.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		System.out.println(row1.getCell(3).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}

	Thread.sleep(300000);
	
	inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
 	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
	
	
	driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
	driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
	Thread.sleep(20000);
	
	driver.switchTo().frame(0);
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
	
	Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
	selectMyElement.selectByVisibleText("Master Shipment Ref #");
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);

	driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
	Thread.sleep(100000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
	
	  java.util.List<WebElement>  rows = driver.findElements(By.tagName("tr"));
	  int rowCount=rows.size()-1;
	    System.out.println("No of containers are : " + rowCount);

	    if (rowCount==2) {
	    	mypack.Report.MyReport("10", "TC43","Create a new shipment with atleast 2 containers", "Pass");
		
	    }
	    else
	    	mypack.Report.MyReport("10", "TC43","Create a new shipment with atleast 2 containers", "Fail");
		Thread.sleep(1000);
	    
		
		System.out.println("Number of containers from EDI "+shipment[16]);
		int agEve=0;
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		if (eventAG[1].equals("USMES")) {
			
			
			railArrivalEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
			outGateEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
			pickUpEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
			if ((railArrivalEst.equals(eventAG[0])) & (railArrivalEst.equals(eventAG[0])) & (pickUpEst.equals(eventAG[0]))) {
				System.out.println("Rail Estimated dates are updated from AG event EDI");
				agEve=1;
				
			}
			else 	 
				System.out.println("RailEstimates are  not updated from AG event EDI");	
			}
			
		
						
		else if (eventAG[1].equals("USSEA")){
			 
			vesselArrivalEst =driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
			containerUnloadEst =driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
			railDepartureEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
			if ((vesselArrivalEst.equals(eventAG[0])) & (containerUnloadEst.equals(eventAG[0])) & (railDepartureEst.equals(eventAG[0]))){
				System.out.println("Ocean Estimated dates are updated from AG event EDI");
				agEve=1;
				
			}
			else System.out.println("Ocean Estimates are  not updated from AG event EDI");	
		}
		System.out.println("railArrivalEst "+railArrivalEst);
		System.out.println("eventAG "+eventAG[0]);
		
		if (agEve==1) {
			mypack.Report.MyReport("10", "TC44","Post an AG event such that AG event time for that milestone is less than the Existing estimated date for that milestone", "Pass");
		}

		else
			mypack.Report.MyReport("10", "TC44","Post an AG event such that AG event time for that milestone is less than the Existing estimated date for that milestone", "Fail");
		
		
	
//call ftp and upload UV event EDI file and check for exceptions in UI
		
		inputStream10_UVEvent = new FileInputStream(currentDir+"\\Scenario10\\2_SecureFile1.xlsx");
		XSSFWorkbook wBook10_UVEvent = new XSSFWorkbook(inputStream10_UVEvent);
		Sheet sheet10_UVEvent = wBook10_UVEvent.getSheetAt(0);
		int rowCount10_UVEvent = sheet10.getLastRowNum();
		System.out.println("Number of rows : "+rowCount10_UVEvent);
		
		for( int i=1;i<=rowCount10_UVEvent;i++) {
			Row row1 = sheet10_UVEvent.getRow(i);
			System.out.println(row1.getCell(4).getStringCellValue());
			System.out.println(row1.getCell(3).getStringCellValue());
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		
		mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		}
	
		Thread.sleep(300000);
	driver.navigate().refresh();
	driver.switchTo().frame(0);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));

	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	int uv_check=0;
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
			System.out.println("Container UnLoad event is reported ");
	
				
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).isDisplayed()) {
					System.out.println("Exception");
					uv_check=1;
				}
				else
					System.out.println("Exception not displayed in UI");
					
			
		}
		else
			System.out.println("Event reported is Container UnLoad but is not highlighted in UI");

	scenario10_legStatus = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[1]/div/div[1]/div[1]/div[2]/span[2]")).getText();
	System.out.println("Leg status of Ocean leg :"+scenario10_legStatus);
	
	if((uv_check==1) & (scenario10_legStatus.equals("Completed"))) {
		mypack.Report.MyReport("10", "TC45","Verify that the event is reported, exception is generated and the ocean leg gets completed when UV(Container Unload is reported)", "Pass");
	}
	else
		mypack.Report.MyReport("10", "TC45","Verify that the event is reported, exception is generated and the ocean leg gets completed when UV(Container Unload is reported)", "Fail");
	
//call ftp and upload the replacement EDI
	
	inputStream10_Replacement = new FileInputStream(currentDir+"\\Scenario10\\3_SecureFile1.xlsx");
	XSSFWorkbook wBook10_Replacement = new XSSFWorkbook(inputStream10_Replacement);
	Sheet sheet10_Replacement = wBook10_Replacement.getSheetAt(0);
	int rowCount10_Replacement = sheet10_Replacement.getLastRowNum();
	System.out.println("Number of rows : "+rowCount10_Replacement);
	
	for( int i=1;i<=rowCount10_Replacement;i++) {
		Row row1 = sheet10_Replacement.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		System.out.println(row1.getCell(3).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}

	Thread.sleep(300000);
driver.navigate().refresh();
driver.switchTo().frame(0);
int dateCheck=0;
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));


driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));

//check for Estimated Dates
vesselArrival_con=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
containerUnload_con=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
railDeparture_con=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
railArrival_con=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
outGate_con=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
pickUp_con=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
dropOff_con=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[2]")).getText().split(" ")[0];

if((shipment_EstDates[3].equals(railDeparture_con)) 
		& (shipment_EstDates[2].equals(railArrival_con)) & (shipment_EstDates[2].equals(outGate_con)) &   
		(shipment_EstDates[2].equals(pickUp_con))) {
	
	System.out.println("Estimated dates of the 2nd and 3rd leg are updated from the Replace file which was dropped since Replace file dates is greater than AG event");
	dateCheck=1;
}

else
	System.out.println("Estimated dates of the 2nd and 3rd leg are not updated from the Replace file which was dropped since Replace file dates is greater than AG event");


driver.navigate().refresh();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));

containerLoad=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
vesselDeparture = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];

if((shipment_EstDates[3].equals(vesselArrival_con)) & (shipment_EstDates[3].equals(containerUnload_con)) & (shipment_EstDates[3].equals(railDeparture_con)) 
		& (shipment_EstDates[2].equals(railArrival_con)) & (shipment_EstDates[2].equals(outGate_con)) &   
		(shipment_EstDates[2].equals(pickUp_con)) & (dropOff_con.equals(shipment_EstDates[5])) & shipment_EstDates[2].equals(containerLoad) & (shipment_EstDates[2].equals(vesselDeparture))) {
	
	System.out.println("Estimated dates of all legs are updated from the Replace file which was dropped since Replace file dates is greater than AG event");
	dateCheck=2;
}

else
	System.out.println("Estimated dates of all legs are not updated from the Replace file which was dropped since Replace file dates is greater than AG event");


if(dateCheck==2) {
	mypack.Report.MyReport("10", "TC46","Verify that the estimated dates gets updated from the Replace EDI for all the shipments when a replace shipment with change in estimated dates was dropped", "Pass");
}
else
	mypack.Report.MyReport("10", "TC46","Verify that the estimated dates gets updated from the Replace EDI for all the shipments when a replace shipment with change in estimated dates was dropped", "Fail");

//check for Shipment References 
int refCheck=0;
billofLadingUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[cvzsdm1]/div[1]/div[2]")).getText();
houseBillNumUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div[2]")).getText();
bookingNumUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[3]/div[1]/div[2]")).getText();
importFilenumUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[2]/div[1]/div[2]")).getText();
consigneeRefUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[2]/div[2]/div[2]")).getText();

if((billofLadingUI.equals(shipment_EstDates[12])) & (houseBillNumUI.equals(shipment_EstDates[11])) & (bookingNumUI.equals(shipment_EstDates[13]))
		& (importFilenumUI.equals(shipment_EstDates[0]))) {
	
	System.out.println("References are updated from Replacement EDI");
	refCheck=1;
}

else
	System.out.println("References are not updated from Replacement EDI");


//Click on Trade Partner Link

driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[2]")).click();

ultimateConsignee = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[8]/td[4]")).getText();

if(ultimateConsignee.equals(shipment_EstDates[15])){
	System.out.println("Trade partners updated");
	refCheck=2;
}
else
	System.out.println("Trade partners not updated");

//add more trade partners if needed

//Purchase Orders - Link

driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[3]")).click();
PONumber = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).getText();
if (PONumber.equals(shipment_EstDates[16])) {
	System.out.println("PO Number updated");
	refCheck=3;
}
else
	System.out.println("PO number not updated");

if (refCheck==3) {
	mypack.Report.MyReport("10", "TC47","Verify that the the PO number, Shipment References and trade partners are updated from the Replace EDI for all the shipments when a replace shipment is dropped", "Pass");
	}
	else
		mypack.Report.MyReport("10", "TC47","Verify that the the PO number, Shipment References and trade partners are updated from the Replace EDI for all the shipments when a replace shipment is dropped", "Fail");

//Check if the event reported is retained
int event_retain=0;
if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
	System.out.println("Container UnLoad event is reported ");

		
		if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).isDisplayed()) {
			System.out.println("Exception");
			event_retain=1;
		
		}
		else
			System.out.println("Exception not displayed in UI");
			
	
}
else
	System.out.println("Event reported is Container UnLoad but is not highlighted in UI");

if (event_retain==1){
	mypack.Report.MyReport("10", "TC48","Verify that the the events and the exceptions are also retained when a replace shipment is dropped", "Pass");
}
else
	mypack.Report.MyReport("10", "TC48","Verify that the the events and the exceptions are also retained when a replace shipment is dropped", "Fail");


driver.close();
}

	

public static void Scenario11(String fPathLocal_11,String fEVentpathLocal_11) throws Exception{
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream11;
	InputStream inputStream11_Event;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	String serviceType_details=null;
	String serviceType_Grid=null;
	String e2eStatus_scn11 = null;
	String detailStatus_scn11=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment=mypack.EDIRead.MyFunction_OceanLeg(fPathLocal_11);
	String[] eventAG=mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_11);
			
	//call ftp and upload shipment
	String currentDir = System.getProperty("user.dir");
	inputStream11 = new FileInputStream(currentDir+"\\Scenario11\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook11 = new XSSFWorkbook(inputStream11);
	Sheet sheet11 = wBook11.getSheetAt(0);
	int rowCount11 = sheet11.getLastRowNum();
	System.out.println("Number of rows : "+rowCount11);
	
	for( int i=1;i<=rowCount11;i++) {
		Row row1 = sheet11.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		System.out.println(row1.getCell(3).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}

	Thread.sleep(300000);
	
	inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
 	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,100);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
	
	
	driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
	driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
	Thread.sleep(20000);
	
	driver.switchTo().frame(0);
	
		
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
	
	Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
	selectMyElement.selectByVisibleText("Master Shipment Ref #");
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);

	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
	Thread.sleep(100000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
	
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).getText().equals(shipment[0])) {
		mypack.Report.MyReport("11", "TC49","Create a new shipment with just ocean leg", "Pass");
	}
	else
		mypack.Report.MyReport("11", "TC49","Create a new shipment with just ocean leg", "Fail");

	
	WebElement Element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[1]/div/table/thead/tr/th[31]/a"));

    //This will scroll the page Horizontally till the element is found		

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;",Element);
		
	
	serviceType_Grid = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[31]")).getText();
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	
	serviceType_details = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[9]/div[2]")).getText();
	System.out.println("serviceType_Grid "+serviceType_Grid);
	System.out.println("serviceType_details "+serviceType_details);
		if (serviceType_Grid.equals(serviceType_details)) {
			System.out.println("Service Type is same in both shipment grid and details page");
			mypack.Report.MyReport("11", "TC50","Validate that  Service type is populated with CY/CY in the Shipment Summary grid and is also populated in the header section in the Shipment Details page.", "Pass");
		}
		
		else
		{
			mypack.Report.MyReport("11", "TC50","Validate that  Service type is populated with CY/CY in the Shipment Summary grid and is also populated in the header section in the Shipment Details page.", "Fail");
		}
		
		//call FTP and drop event EDI
		inputStream11_Event = new FileInputStream(currentDir+"\\Scenario11\\2_SecureFile1.xlsx");
		XSSFWorkbook wBook11_Event = new XSSFWorkbook(inputStream11_Event);
		Sheet sheet11_Event = wBook11_Event.getSheetAt(0);
		int rowCount11_Event = sheet11_Event.getLastRowNum();
		System.out.println("Number of rows : "+rowCount11_Event);
		for( int i=1;i<=rowCount11_Event;i++) {
			Row row1 = sheet11_Event.getRow(i);
			System.out.println(row1.getCell(4).getStringCellValue());
			System.out.println(row1.getCell(3).getStringCellValue());
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		
		mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		}

		Thread.sleep(300000);
		
		driver.navigate().refresh();
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));

		
		e2eStatus_scn11=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div/div[1]/div[1]")).getText().split(" ")[0];
		System.out.println("e2eStatus_scn11 "+e2eStatus_scn11);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		
		detailStatus_scn11=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[10]/div[2]")).getText();
		System.out.println("detailStatus_scn11 "+detailStatus_scn11);
	if ((e2eStatus_scn11.equals("At")) & (detailStatus_scn11.equals("Completed"))) {
		System.out.println("Status is completed");
		mypack.Report.MyReport("11", "TC51","Validate that the on reporting the Vessel Arrival milestone, the e2e shipment status and the shipment leg status changes to Completed", "Pass");
	}
	
	else
	{
		mypack.Report.MyReport("11", "TC51","Validate that the on reporting the Vessel Arrival milestone, the e2e shipment status and the shipment leg status changes to Completed", "Fail");
	}
	
	//Check for search and advanced Search
	int advFilterCheck=0;
	driver.navigate().refresh();
	driver.switchTo().frame(0);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));

	Select selectMyElement1 = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
	selectMyElement1.selectByVisibleText("Service Type");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys("CY/CY");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
	Thread.sleep(100000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]")).isDisplayed()) {
		System.out.println("Search Functionality is working");
		advFilterCheck=1;
	}
	else
		System.out.println("Search Functionality not is working");
	
	int adv_Filter=0;
	driver.findElement(By.xpath("//*[contains(@class, 'MuiSvgIcon-root align-right grid-filter')]")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/form/div/div/div[2]/button")).click();
	Select advFilter = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[1]/select")));
	advFilter.selectByVisibleText("Service Type");
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[3]/input")).sendKeys("CY/CY");
	
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/div/div[2]/button[2]")).isEnabled()){
		adv_Filter=1;
	}
	else
	
		adv_Filter=0;
	
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/button[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[3]/input")).sendKeys("CY/CY");
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/div/div[2]/button[2]")).isEnabled()){
		adv_Filter=2;
	}
	else
	
		adv_Filter=-1;
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/button[3]")).click();
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/div/div[2]/button[2]")).isEnabled()){
		adv_Filter=3;
	}
	else
	
		adv_Filter=-2;
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/div/div[2]/button[2]")).click();
	System.out.println("Adv Filter :"+adv_Filter);
	if ((adv_Filter==3) & (advFilterCheck==1)){
		System.out.println("Advance Filter is working correctly");
		mypack.Report.MyReport("11", "TC52","Validate that the search and the advanced filter works as expected with the new field Service Type", "Pass");
	}
	else
	{
			mypack.Report.MyReport("11", "TC52","Validate that the search and the advanced filter works as expected with the new field Service Type", "Fail");
}
}


public static void Scenario12(String fPathLocal_nocont_12,String fPathLocal_cont_12) throws Exception {		
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream12_nocontainer;
	InputStream inputStream12_container;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String[] event_type = mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_12);
	//String[] eventType_update=mypack.EDIEventRead.MyFunctionEventtype(fEventpathLocal_Update);
	//String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal);
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	//String[] shipment=mypack.EDIRead.MyFunction1(fPathLocal);

	String[] noContainer=mypack.EDIRead.MyFunction_nocontainerEDI(fPathLocal_nocont_12);
	String containerEDI[]=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_cont_12);
	try {
		
		String currentDir = System.getProperty("user.dir");
	 inputStream12_nocontainer = new FileInputStream(currentDir+"\\Scenario12\\1_SecureFile1.xlsx");
		XSSFWorkbook wBook12_nocontainer = new XSSFWorkbook(inputStream12_nocontainer);
		Sheet sheet12_nocontainer = wBook12_nocontainer.getSheetAt(0);
		int rowCount12_nocontainer = sheet12_nocontainer.getLastRowNum();
		System.out.println("Number of rows : "+rowCount12_nocontainer);
		
		for( int i=1;i<=rowCount12_nocontainer;i++) {
			Row row3 = sheet12_nocontainer.getRow(i);
		System.out.println(row3.getCell(5).getStringCellValue());
		System.out.println(row3.getCell(4).getStringCellValue());
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		
		mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());
		
		}	
		
	Thread.sleep(300000);
		

	inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
  	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,3600);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
	
	
	driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
	driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
	Thread.sleep(100000);

	
	driver.switchTo().frame(0);
	Thread.sleep(1000);
	Select selectMyElement_Scn4 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
	selectMyElement_Scn4.selectByVisibleText("Master Shipment Ref #");
	//System.out.println("mmmmmmmmmmmm"+noContainer[0]);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(noContainer[0]);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
	Thread.sleep(100000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(noContainer[0]);
	String cont_grid = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[8]")).getText();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		
		containerID_scn4=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText();
		System.out.println("Container ID "+ containerID_scn4);
		System.out.println("Container ID in grid "+ cont_grid);
		if( (containerID_scn4.equals("- - -")) & cont_grid.equals(" ")) {
			mypack.Report.MyReport("12", "TC53","Create a new shipment (with purpose code 04) without container ID", "Pass");
		}
		else
			mypack.Report.MyReport("12", "TC53","Create a new shipment (with purpose code 04) without container ID", "Fail");
			
		
		
//call ftp and upload shipment with containerID
		
		inputStream12_container = new FileInputStream(currentDir+"\\Scenario12\\2_SecureFile1.xlsx");
		XSSFWorkbook wBook12_container = new XSSFWorkbook(inputStream12_container);
		Sheet sheet12_container = wBook12_container.getSheetAt(0);
		int rowCount12_container = sheet12_container.getLastRowNum();
		System.out.println("Number of rows : "+rowCount12_container);
		
		for( int i=1;i<=rowCount12_container;i++) {
			Row row3 = sheet12_container.getRow(i);
		
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
			System.out.println(row3.getCell(5).getStringCellValue());
			System.out.println(row3.getCell(4).getStringCellValue());
		mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());
		
		}	
		
		 
			
		
		Thread.sleep(300000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).getText().equals(noContainer[0])){
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();

		}
		else {
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(noContainer[0]);

			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
		}

		Thread.sleep(100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(noContainer[0]);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		
		
		//Planned Dates
		containerID_scn4=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText();
		if (containerID_scn4.equals(containerEDI[5])) {
			System.out.println(containerID_scn4+containerEDI[5]);
			mypack.Report.MyReport("12", "TC54","Send the same shipment (with purpose code 05) that now contains a container ID with change in dates in the DTM segment", "Pass");
			
		}
		else
			mypack.Report.MyReport("12", "TC54","Send the same shipment (with purpose code 05) that now contains a container ID with change in dates in the DTM segment", "Fail");
		int dateCheck=0;
		vesselDeparture_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		vesselArrival_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		containerUnload_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		railDeparture_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		railArrival_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		outGate_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		pickUp_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		dropOff_nocon=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
		System.out.println(noContainer[3]+" "+vesselArrival_nocon);
		if ((noContainer[3].equals(vesselArrival_nocon) & noContainer[3].equals(containerUnload_nocon) & noContainer[3].equals(railDeparture_nocon)) &
				 (noContainer[2].equals(railArrival_nocon )& noContainer[2].equals(outGate_nocon) &  noContainer[2].equals(pickUp_nocon)) & 
				 	dropOff_nocon.equals(noContainer[4]))
				
		{
			System.out.println("Planned dates are updated from the no container EDI");
			dateCheck=1;
		}
		else
			
			System.out.println("Planned dates are not updated from the no container EDI");
		
		vesselArrival_con = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
		containerUnload_con = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
		railDeparture_con = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
		railArrival_con = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
		outGate_con = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0]; 	
		pickUp_con= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
		dropOff_con = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];
		System.out.println(containerEDI[3]+" "+vesselArrival_con);
		if((containerEDI[3].equals(vesselArrival_con)) & (containerEDI[3].equals(containerUnload_con)) & (containerEDI[3].equals(railDeparture_con)) 
				& (containerEDI[2].equals(railArrival_con)) & (containerEDI[2].equals(outGate_con)) &   
				(containerEDI[2].equals(pickUp_con)))
			
		{
			System.out.println("Estimated dates are updated from the  container EDI");
			dateCheck=2;
		}
		else
			System.out.println("Estimated dates are not updated from the  container EDI");
		
		if (dateCheck==2) {
			mypack.Report.MyReport("12", "TC55","Validate that the estimated dates is updated from the replace edi856 that was send and the planned dates is from the original EDI856", "Pass");
			
		}
		else
			mypack.Report.MyReport("12", "TC55","Validate that the estimated dates is updated from the replace edi856 that was send and the planned dates is from the original EDI856", "Fail");
		
}catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}


public static void Scenario13(String fPathLocal_13,String fPathLocal_13Replaced) throws Exception{
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream13;
	InputStream inputStream13_new;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	String serviceType_details=null;
	String serviceType_Grid=null;
	String e2eStatus_scn11 = null;
	String detailStatus_scn11=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment=mypack.EDIRead.MyFunction1(fPathLocal_13);
	String[] shipment_Replaced=mypack.EDIRead.MyFunction1(fPathLocal_13Replaced);
	
	String currentDir = System.getProperty("user.dir");
	inputStream13 = new FileInputStream(currentDir+"\\Scenario13\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook13 = new XSSFWorkbook(inputStream13);
	Sheet sheet13 = wBook13.getSheetAt(0);
	int rowCount13 = sheet13.getLastRowNum();
	System.out.println("Number of rows : "+rowCount13);
	for( int i=1;i<=rowCount13;i++) {
		Row row1 = sheet13.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		System.out.println(row1.getCell(3).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}

	Thread.sleep(300000);

	inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
 	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,100);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
	
	
	driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
	driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
	Thread.sleep(20000);
	
	driver.switchTo().frame(0);
	
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
	
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
			int chkscn13=0;
			if(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).getText().equals(shipment[0])) {
				chkscn13=1;
			}
			
			
		
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			if(driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[1]")).getText().equals("Container Load")
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[2]")).getText().equals("Vessel Departure")
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[5]")).getText().equals("Rail Departure")
				
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[last()-2]")).getText().equals("Outgate")
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[last()-1]")).getText().equals("Pickup")
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[last()]")).getText().equals("Dropoff")) {
				System.out.println("Shipments should be created with ocean, rail and dray legs");
				chkscn13=2;
			}
			
			if (chkscn13==2) {
				mypack.Report.MyReport("13", "TC56","Create a new shipment (with purpose code 04) with ocean, rail and dray legs", "Pass");
			}
			else
				mypack.Report.MyReport("13", "TC56","Create a new shipment (with purpose code 04) with ocean, rail and dray legs", "Fail");
			
			
			inputStream13_new = new FileInputStream(currentDir+"\\Scenario13\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook13_new = new XSSFWorkbook(inputStream13_new);
			Sheet sheet13_new = wBook13_new.getSheetAt(0);
			int rowCount13_new = sheet13_new.getLastRowNum();
			System.out.println("Number of rows : "+rowCount13_new);
			for( int i=1;i<=rowCount13_new;i++) {
				Row row1 = sheet13_new.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				System.out.println(row1.getCell(3).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}

			Thread.sleep(300000);
			
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));

			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));

			
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[1]/div/div[1]/div[2]/div/span[3]/span[1]")).isDisplayed()
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[1]")).getText().equals("Container Load")
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[2]")).getText().equals("Vessel Departure")
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[5]")).getText().equals("Rail Departure")				
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[last()-2]")).getText().equals("Outgate")
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[last()-1]")).getText().equals("Pickup")
					& driver.findElement(By.xpath("(//div[@class='apptinfo-milnme'])[last()]")).getText().equals("Dropoff"))
			{
				System.out.println("Origin is Ocean and all legs are displayed");
				mypack.Report.MyReport("13", "TC57","Send the same shipment by changing the origin location of the 1st legand validate whether the legs are displayed in the correct order", "Pass");
			}
			else
				mypack.Report.MyReport("13", "TC57","Send the same shipment by changing the origin location of the 1st leg and validate whether the legs are displayed in the correct order", "Fail");
			
			String rail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[1]")).getAttribute("src");
			String railLeg=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[1]/div/div[2]/div[1]/div[1]")).getAttribute("src");
			
		System.out.println("Rail "+rail+" "+"Rail Leg "+railLeg);

driver.close();

}


public static void Scenario14(String fPathLocal_14_woDTMandcont,String fPathLocal_14_withDTMandcont,String fPathLocal_14_withDTMandcont2 ) throws Exception {
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream14;
	InputStream inputStream14_DTMandcont;	
	InputStream inputStream14_DTMandcont2;	
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment_noDTMandcont=mypack.EDIRead.MyFunction2_noDTM(fPathLocal_14_woDTMandcont);
	String[] shipment_replace1=mypack.EDIRead.MyFunction1(fPathLocal_14_withDTMandcont);
	String[] shipment_replace2=mypack.EDIRead.MyFunction1(fPathLocal_14_withDTMandcont2);
			//call ftp to upload shipment without dtm 369 segment
	
	
	String currentDir = System.getProperty("user.dir");
	inputStream14 = new FileInputStream(currentDir+"\\Scenario14\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook14= new XSSFWorkbook(inputStream14);
	Sheet sheet14 = wBook14.getSheetAt(0);
	int rowCount14 = sheet14.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount14;i++) {
		Row row1 = sheet14.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
			Thread.sleep(300000);
			//click on draft shipment
			inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
			
			
			driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
			driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
			Thread.sleep(20000);
			
			driver.switchTo().frame(0);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div/div[4]")).click();
			Thread.sleep(20000);
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_noDTMandcont[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_noDTMandcont[0]);
			int draftVal=0;
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).isDisplayed()){
				System.out.println("Shipment is present in Draft Shipments");
				draftVal=1;

			}
			else
				System.out.println("Shipment is not present in Draft Shipments");
			
			if(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr/td[8]")).getText().isEmpty()) {
				System.out.println("Container is empty");
				draftVal=2;
			}
			else
				System.out.println("Container is not empty");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			if ((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[last()]/div[2]")).getText().equals("Draft")))

			{
				System.out.println("Shipment is in Draft Status and Planned and Estimated dates are not present");
				draftVal=3;
				
			}
			else
				System.out.println("Shipment is not in draft status");
			System.out.println("DraftVal: "+draftVal);
			if(draftVal==3) {
				mypack.Report.MyReport("14", "TC58","Create shipments with purpose code “Original” (04) without DTM*369 & Conatiner segment", "Pass");
			}
			else
				mypack.Report.MyReport("14", "TC58","Create shipments with purpose code “Original” (04) without DTM*369 & Conatiner segment", "Fail");
			//call ftp and upload shipment with purpose code 05 and dtm segment and container
			
			inputStream14_DTMandcont = new FileInputStream(currentDir+"\\Scenario14\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook14_DTMandcont= new XSSFWorkbook(inputStream14_DTMandcont);
			Sheet sheet14_DTMandcont = wBook14_DTMandcont.getSheetAt(0);
			int rowCount14_DTMandcont = sheet14_DTMandcont.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount14_DTMandcont;i++) {
				Row row1 = sheet14_DTMandcont.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
			
			Thread.sleep(300000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			Thread.sleep(3000);
			 java.util.List<WebElement>  rows = driver.findElements(By.tagName("tr"));
			  int numberOfShipments=rows.size()-1;
			System.out.println("No of shipments are are : " + numberOfShipments);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			
			Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			int dateCh=0;
			System.out.println("Planned_date_AR"+Planned_date_AR);
			System.out.println("shipment_replace1 "+shipment_replace1[4]);
			if((Planned_date_AR.equals(shipment_replace1[4])) & (Planned_date_OA.equals(shipment_replace1[4])) & (Planned_date_PK.equals(shipment_replace1[4]))
			& (Planned_date_VA.equals(shipment_replace1[3])) & (Planned_date_UV.equals(shipment_replace1[3])) & (Planned_date_RL.equals(shipment_replace1[3]))
			& (Planned_date_CL.equals(shipment_replace1[2])) & (Planned_date_VD.equals(shipment_replace1[2]))
			& (Planned_date_dropoff.equals(shipment_replace1[5]))){
				System.out.println(" Planned dates are updated from EDI with container and DTM");
				dateCh=1;
		
			}
			else 	 
				System.out.println(" Planned are  not updated from EDI with container and DTM");	
			
	
			
			
			//Estimated Dates
			railArrivalEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
			outGateEst= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
			pickUpEst=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
			vesselArrivalEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
			containerUnloadEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
			railDepartureEst = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
			
			System.out.println("railArrivalEst"+railArrivalEst);
			System.out.println("shipment_replace1[4] "+shipment_replace1[4]);	
			if ((railArrivalEst.equals(shipment_replace1[4])) & (railArrivalEst.equals(shipment_replace1[4])) & (pickUpEst.equals(shipment_replace1[4])) &
				(vesselArrivalEst.equals(shipment_replace1[3])) & (containerUnloadEst.equals(shipment_replace1[3])) & (railDepartureEst.equals(shipment_replace1[3]))){
			
				System.out.println(" Estimated dates are updated from Updated DTM EDI");
				dateCh=2;
				
			}
			else 	 
				System.out.println("Estimates are  not updated from Updated DTM EDI");	
			
			System.out.println(dateCh);
			if((dateCh==2) & (numberOfShipments==2)) {

				 mypack.Report.MyReport("14", "TC59","Replace the Shipment with DTM*369 and 2 new containers", "Pass");
			}
			else

				mypack.Report.MyReport("14", "TC59","Replace the Shipment with DTM*369 and 2 new containers", "Fail");
//Drop edi856(05) by Replacing the same shipment with by editing one of the existing container and add one new container
		
			
			inputStream14_DTMandcont2 = new FileInputStream(currentDir+"\\Scenario14\\3_SecureFile1.xlsx");
			XSSFWorkbook wBook14_DTMandcont2= new XSSFWorkbook(inputStream14_DTMandcont2);
			Sheet sheet14_DTMandcont2 = wBook14_DTMandcont2.getSheetAt(0);
			int rowCount14_DTMandcont2 = sheet14_DTMandcont2.getLastRowNum();
			System.out.println("Number of rows : "+rowCount14_DTMandcont2);
			
			for( int i=1;i<=rowCount14_DTMandcont2;i++) {
				Row row1 = sheet14_DTMandcont2.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}	
			
			Thread.sleep(500000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			Thread.sleep(3000);
			 java.util.List<WebElement>  rows1 = driver.findElements(By.tagName("tr"));
			  int numberOfShipments1=rows.size()-1;
			System.out.println("No of shipments are : " + numberOfShipments1);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	
	int dateCh2=0;
	Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
	Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];



Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
		Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
		Estimated_date_VA= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
		Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
		Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
		Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
		Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
		Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];
		Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
	System.out.println("Planned_date_AR "+Planned_date_AR);
	System.out.println("shipment_replace1[4] "+shipment_replace1[4]);
	if ((Planned_date_AR.equals(shipment_replace1[4])) & (Planned_date_OA.equals(shipment_replace1[4])) & (Planned_date_PK.equals(shipment_replace1[4]))
			& (Planned_date_VA.equals(shipment_replace1[3])) & (Planned_date_UV.equals(shipment_replace1[3])) & (Planned_date_RL.equals(shipment_replace1[3]))
			&(Planned_date_CL.equals(shipment_replace1[2])) & (Planned_date_VD.equals(shipment_replace1[2])) & (Planned_date_dropoff.equals(shipment_replace1[5])))
			{
			
				System.out.println(" Planned dates are updated from EDI - Original");
				dateCh2=1;
				
			}
			else 	 
				System.out.println(" Planned are  not updated from EDI - Original");	
	
	System.out.println("Estimated_date_VA"+Estimated_date_VA);
	System.out.println("shipment_replace2[4] "+shipment_replace2[4]);
	if((shipment_replace2[3].equals(Estimated_date_VA)) & (shipment_replace2[3].equals(Estimated_date_UV)) & (shipment_replace2[3].equals(Estimated_date_RL)) 
			& (shipment_replace2[4].equals(Estimated_date_AR)) & (shipment_replace2[4].equals(Estimated_date_OA)) & (shipment_replace2[4].equals(Estimated_date_PK)) &
			(shipment_replace2[2].equals(Estimated_date_CL)) & (shipment_replace2[2].equals(Estimated_date_VD)) &  (shipment_replace2[5].equals(Estimated_date_dropoff)))
		
	{
		System.out.println("Estimated dates are updated from  EDI - Replace");
		dateCh2=2;
	}
	else
		System.out.println("Estimated dates are not updated from  EDI - Replace");
	
	
	if((dateCh2==2) & (numberOfShipments1==3)) {

			mypack.Report.MyReport("14", "TC60","Again replace the Shipment by editing name of the one existing container and add one more new container", "Pass");
	}
	else

			mypack.Report.MyReport("14", "TC60","Again replace the Shipment by editing name of the one existing container and add one more new container", "Fail");
}

public static void Scenario15(String fPathLocal_15, String fEVentpathLocal_15,String fPathLocal_15Replace1,String fEVentpathLocal_15_1, String fPathLocal_15Replace2) throws Exception {
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream15;
	InputStream inputStream15_ReplaceEvent1;	
	InputStream inputStream15_Replace1;	
	InputStream inputStream15_Replace2;	
	InputStream inputStream15_EDI;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment_create=mypack.EDIRead.MyFunction1(fPathLocal_15);
	String[] shipment_replace1=mypack.EDIRead.MyFunction1(fPathLocal_15Replace1);
	String[] shipment_replace2=mypack.EDIRead.MyFunction1(fPathLocal_15Replace2);
	String[] event_1=mypack.EDIEventRead.MyFunctionEventtype2(fEVentpathLocal_15);
	String[] event_2=mypack.EDIEventRead.MyFunctionEventtype2(fEVentpathLocal_15_1);
			//call ftp to upload shipment without dtm 369 segment
	
	String currentDir = System.getProperty("user.dir");
	inputStream15 = new FileInputStream(currentDir+"\\Scenario15\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook15= new XSSFWorkbook(inputStream15);
	Sheet sheet15 = wBook15.getSheetAt(0);
	int rowCount15 = sheet15.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount15;i++) {
		Row row1 = sheet15.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
			Thread.sleep(300000);
			
			inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
			
			
			driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
			driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
			Thread.sleep(20000);
			
			driver.switchTo().frame(0);
			
			Thread.sleep(10000);
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_create[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_create[0]);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			String scn15_References = "- - -";
			System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div[2]")).getText());
			if (((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[1]/div[2]")).getText()).equals(scn15_References))
					& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div[2]")).getText().equals(scn15_References))
					& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[2]/div[2]/div[2]")).getText().equals(scn15_References))
					& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[3]/div[1]/div[2]")).getText().equals(scn15_References)))
				
			{
				System.out.println("References value are null for Booking No, Bill of Lading, House Billing No & Consignee Ref No.");
				mypack.Report.MyReport("15", "TC61","Create shipments with purpose code “Original” (04) without Booking No, Bill of Lading, House Billing No & Consignee Ref No.", "Pass");
			}
			else
			{
				mypack.Report.MyReport("15", "TC61","Create shipments with purpose code “Original” (04) without Booking No, Bill of Lading, House Billing No & Consignee Ref No.", "Fail");
				
			}
			
			
						
			
			//call ftp and upload event EDI
			inputStream15_EDI = new FileInputStream(currentDir+"\\Scenario15\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook15_EDI= new XSSFWorkbook(inputStream15_EDI);
			Sheet sheet15_EDI = wBook15_EDI.getSheetAt(0);
			int rowCount15_EDI = sheet15_EDI.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount15_EDI;i++) {
				Row row1 = sheet15_EDI.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
					
			Thread.sleep(300000);
					
			driver.navigate().refresh();
			
			driver.switchTo().frame(0);
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
			
			//take value of eventType from EDI Event Read class
		int eventVal=0;
			if (event_1[0].equals("AE")){
					if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
						System.out.println("Container Load event is reported ");
						eventVal=1;
	
					}
					else
						System.out.println("Event reported is Container Load but is not highlighted in UI");
					
					Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
					Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
					System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (event_1[0].equals("VD")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Vessel Departure event is reported ");
					eventVal=1;
		
				}
				else
					System.out.println("Event reported is Vessel Departure but is not highlighted in UI");
				
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
		
			else if (event_1[0].equals("VA")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Vessel Arrival event is reported ");
					eventVal=1;
				
				}
				else
					System.out.println("Event reported is Vessel Arrival  but is not highlighted in UI");
				
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			 
			else if (event_1[0].equals("UV")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Container UnLoad event is reported ");
					eventVal=1;
				
		
				}
				else
					System.out.println("Event reported is Container UnLoad but is not highlighted in UI");
				
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (event_1[0].equals("RL")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Rail Departure event is reported ");
					eventVal=1;
					
				}
				else
					System.out.println("Event reported is Rail Departure but is not highlighted in UI");
			
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("///*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
			}
			else if (event_1[0].equals("AR")) {
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
					System.out.println("Rail Arrival event is reported ");
					eventVal=1;
			
					}
				}
				else
					System.out.println("Event reported is Rail Arrival but is not highlighted in UI");
		
				
				Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
				 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
				System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
				
				if (event_1[0].equals("OA")) {
					if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
							System.out.println("Out Gate event is reported ");
							eventVal=1;

				
					}
					else
						System.out.println("Event reported is OutGate but is not highlighted in UI");
		
		
		Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
		 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		 System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
				
				
			}	
				
				
				if (((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[1]/div[2]")).getText()).equals(scn15_References))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div[2]")).getText().equals(scn15_References))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[2]/div[2]/div[2]")).getText().equals(scn15_References))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[3]/div[1]/div[2]")).getText().equals(scn15_References))
						& (eventVal==1))
					
				{
					System.out.println("References value are null for Booking No, Bill of Lading, House Billing No & Consignee Ref No.");
					mypack.Report.MyReport("15", "TC62","Report any of the event with Booking No, Bill of Lading, House Billing No & Consignee Ref No", "Pass");
				}
				else
					{
					mypack.Report.MyReport("15", "TC62","Report any of the event with Booking No, Bill of Lading, House Billing No & Consignee Ref No", "Fail");
					}
				
				
				
				
				
				//call ftp and upload Replacement shipment EDI
				inputStream15_Replace1 = new FileInputStream(currentDir+"\\Scenario15\\3_SecureFile1.xlsx");
				XSSFWorkbook wBook15_Replace1= new XSSFWorkbook(inputStream15_Replace1);
				Sheet sheet15_Replace1 = wBook15_Replace1.getSheetAt(0);
				int rowCount15_Replace1 = sheet15_Replace1.getLastRowNum();
				//System.out.println("Number of rows : "+rowCount);
				
				for( int i=1;i<=rowCount15_Replace1;i++) {
					Row row1 = sheet15_Replace1.getRow(i);
					System.out.println(row1.getCell(4).getStringCellValue());
					//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
				
				
				mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
				
				}
						
				Thread.sleep(300000);
						
				driver.navigate().refresh();
				
				driver.switchTo().frame(0);
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
				
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
				if (((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[1]/div[2]")).getText()).equals(shipment_replace1[12]))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div[2]")).getText().equals(shipment_replace1[11]))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[3]/div[1]/div[2]")).getText().equals(shipment_replace1[13])))
					
				{
					System.out.println("References value  for Booking No, Bill of Lading, House Billing No & Consignee Ref No. are updated");
					mypack.Report.MyReport("15", "TC63","Replace the shipment with Booking No, Bill of Lading, House Billing No & Consignee Ref No", "Pass");
				
				}
				else
				{
					System.out.println("References value  for Booking No, Bill of Lading, House Billing No & Consignee Ref No. are not updated");
					mypack.Report.MyReport("15", "TC63","Replace the shipment with Booking No, Bill of Lading, House Billing No & Consignee Ref No", "Fail");
				}
				
				
				
				//call ftp and upload event EDI and Verify that Booking No, Bill of Lading, House Billing No & Consignee Ref No remains same from replace file and does not came from event 315 value
				inputStream15_ReplaceEvent1 = new FileInputStream(currentDir+"\\Scenario15\\4_SecureFile1.xlsx");
				XSSFWorkbook wBook15_ReplaceEvent1= new XSSFWorkbook(inputStream15_ReplaceEvent1);
				Sheet sheet15_ReplaceEvent1 = wBook15_ReplaceEvent1.getSheetAt(0);
				int rowCount15_ReplaceEvent1 = sheet15_ReplaceEvent1.getLastRowNum();
				//System.out.println("Number of rows : "+rowCount);
				
				for( int i=1;i<=rowCount15_ReplaceEvent1;i++) {
					Row row1 = sheet15_ReplaceEvent1.getRow(i);
					System.out.println(row1.getCell(4).getStringCellValue());
					//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
				
				
				mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
				
				}
						
				Thread.sleep(300000);
						
				driver.navigate().refresh();
				
				driver.switchTo().frame(0);
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
				
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));

				if (((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[1]/div[2]")).getText()).equals(shipment_replace1[12]))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div[2]")).getText().equals(shipment_replace1[11]))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[3]/div[1]/div[2]")).getText().equals(shipment_replace1[13])))
					
				{
					System.out.println("References value  for Booking No, Bill of Lading, House Billing No & Consignee Ref No. remains same from replace file and does not came from event 315 value");
					mypack.Report.MyReport("15", "TC64","Again report any of the event with Booking No, Bill of Lading, House Billing No & Consignee Ref No", "Pass");
				}
				else
				{
				mypack.Report.MyReport("15", "TC64","Again report any of the event with Booking No, Bill of Lading, House Billing No & Consignee Ref No", "Fail");
				
				}
				
				
				
		//call ftp and upload second replacement shipment EDI and Verify that references value are populated from edi856 replace file for Booking No, Bill of Lading, House Billing No & Consignee Ref No. as "Null"
				
				inputStream15_Replace2 = new FileInputStream(currentDir+"\\Scenario15\\5_SecureFile1.xlsx");
				XSSFWorkbook wBook15_Replace2= new XSSFWorkbook(inputStream15_Replace2);
				Sheet sheet15_Replace2 = wBook15_Replace2.getSheetAt(0);
				int rowCount15_Replace2 = sheet15_Replace2.getLastRowNum();
				//System.out.println("Number of rows : "+rowCount);
				
				for( int i=1;i<=rowCount15_Replace2;i++) {
					Row row1 = sheet15_Replace2.getRow(i);
					System.out.println(row1.getCell(4).getStringCellValue());
					//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
				
				
				mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
				
				}
						
				Thread.sleep(300000);
						
				driver.navigate().refresh();
				
				driver.switchTo().frame(0);
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
				
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
				System.out.println("driver.findElement(By.xpath(\"//*[@id=\\\"root\\\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[1]/div[2]\")).getText() "+driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[1]/div[2]")).getText());
				System.out.println("shipment_replace2[12] "+shipment_replace2[12]);
				System.out.println("shipment_replace2[12] "+shipment_replace2[11]);
				System.out.println("shipment_replace2[12] "+shipment_replace2[13]);
				System.out.println("shipment_replace2[12] "+shipment_replace2[14]);
				if (((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[1]/div[2]")).getText()).equals(scn15_References))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div[2]")).getText().equals(scn15_References))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[2]/div[2]/div[2]")).getText().equals(scn15_References))
						& (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[3]/div[1]/div[2]")).getText().equals(scn15_References)))
					
				{
					System.out.println("References value  for Booking No, Bill of Lading, House Billing No & Consignee Ref No. are updated");
					mypack.Report.MyReport("15", "TC65","Again replace the shipment with Booking No,Bill of Lading, House Billing No & Consignee Ref no value as Null", "Pass");
				}
				else
				{
				mypack.Report.MyReport("15", "TC65","Again replace the shipment with Booking No,Bill of Lading, House Billing No & Consignee Ref no value as Null", "Fail");
				}
				
				driver.close();
				
}				


public static void Scenario16(String fPathLocal_16,String fPathLocal_16_Replace1,String fPathLocal_16_Replace2) throws Exception {
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream16;
	InputStream inputStream16_Replace1;	
	InputStream inputStream16_Replace2;	
	InputStream inputStream15_EDI;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment_create=mypack.EDIRead.MyFunction1(fPathLocal_16);
	String[] shipment_replace1=mypack.EDIRead.MyFunction1(fPathLocal_16_Replace1);
	String[] shipment_replace2=mypack.EDIRead.MyFunction1(fPathLocal_16_Replace2);
	
	
	String currentDir = System.getProperty("user.dir");
	inputStream16 = new FileInputStream(currentDir+"\\Scenario16\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook16= new XSSFWorkbook(inputStream16);
	Sheet sheet16 = wBook16.getSheetAt(0);
	int rowCount16 = sheet16.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount16;i++) {
		Row row1 = sheet16.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
			Thread.sleep(300000);
			
			inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
			
			
			driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
			driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
			Thread.sleep(20000);
			
			driver.switchTo().frame(0);
			
			Thread.sleep(10000);
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_create[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_create[0]);;
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		
int dateChk=0;
			Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

			Estimated_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			if (Planned_date_AR.equals(shipment_create[4]) & Planned_date_OA.equals(shipment_create[4]) & Planned_date_PK.equals(shipment_create[4]) & 
					Estimated_date_AR.equals(shipment_create[4]) &  Estimated_date_OA.equals(shipment_create[4]) & Estimated_date_PK.equals(shipment_create[4]) &
					Planned_date_RL.equals(shipment_create[3]) & Planned_date_VA.equals(shipment_create[3]) & Planned_date_UV.equals(shipment_create[3]) & Planned_date_dropoff.equals(shipment_create[5]) &
							Estimated_date_RL.equals(shipment_create[3]) & Estimated_date_VA.equals(shipment_create[3]) & Estimated_date_UV.equals(shipment_create[3]) & Estimated_date_dropoff.equals(shipment_create[5])
							&Planned_date_CL.equals(shipment_create[2]) & Planned_date_VD.equals(shipment_create[2]) & Estimated_date_CL.equals(shipment_create[2]) & Estimated_date_VD.equals(shipment_create[2])) {
				System.out.println("Planned Dates and Estimated Dates  are updated from Replaced EDI");
				dateChk=1;
			}
			else
				System.out.println("Planned Dates and Estimated Dates are not updated from Replaced EDI");
		
	
			if (dateChk==1) {
				mypack.Report.MyReport("16", "TC66","Create shipments with purpose code “Original” (04) with Only one Container", "Pass");
			}
			else
				mypack.Report.MyReport("16", "TC66","Create shipments with purpose code “Original” (04) with Only one Container", "Fail");
			//call ftp and upload  the EDI856 file with purpose code 05 added with one Container and change in DTM segments
			
			inputStream16_Replace1 = new FileInputStream(currentDir+"\\Scenario16\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook16_Replace1= new XSSFWorkbook(inputStream16_Replace1);
			Sheet sheet16_Replace1 = wBook16_Replace1.getSheetAt(0);
			int rowCount16_Replace1 = sheet16_Replace1.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount16_Replace1;i++) {
				Row row1 = sheet16_Replace1.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
					Thread.sleep(300000);
					driver.navigate().refresh();
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
					int dateChk1=0;
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[8]")).getText().equals(shipment_create[6])) {
					
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
			
					if (Planned_date_AR.equals(shipment_create[4]) & Planned_date_OA.equals(shipment_create[4]) & Planned_date_PK.equals(shipment_create[4]) & 
							Estimated_date_AR.equals(shipment_replace1[4]) &  Estimated_date_OA.equals(shipment_replace1[4]) & Estimated_date_PK.equals(shipment_replace1[4]) &
							Planned_date_RL.equals(shipment_create[3]) & Planned_date_VA.equals(shipment_create[3]) & Planned_date_UV.equals(shipment_create[3]) & Planned_date_dropoff.equals(shipment_create[5]) &
									Estimated_date_RL.equals(shipment_replace1[3]) & Estimated_date_VA.equals(shipment_replace1[3]) & Estimated_date_UV.equals(shipment_replace1[3]) & Estimated_date_dropoff.equals(shipment_replace1[5])
									&Planned_date_CL.equals(shipment_create[2]) & Planned_date_VD.equals(shipment_create[2]) & Estimated_date_CL.equals(shipment_replace1[2]) & Estimated_date_VD.equals(shipment_replace1[2])) {
						System.out.println("Planned Dates and Estimated Dates  are updated as expected");
						dateChk1=1;
					}
					else
						System.out.println("Planned Dates and Estimated Dates are not updated as expected");
					
					driver.navigate().refresh();
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
				
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
					if (Planned_date_AR.equals(shipment_replace1[4]) & Planned_date_OA.equals(shipment_replace1[4]) & Planned_date_PK.equals(shipment_replace1[4]) & 
							Estimated_date_AR.equals(shipment_replace1[4]) &  Estimated_date_OA.equals(shipment_replace1[4]) & Estimated_date_PK.equals(shipment_replace1[4]) &
							Planned_date_RL.equals(shipment_replace1[3]) & Planned_date_VA.equals(shipment_replace1[3]) & Planned_date_UV.equals(shipment_replace1[3]) & Planned_date_dropoff.equals(shipment_replace1[5]) &
									Estimated_date_RL.equals(shipment_replace1[3]) & Estimated_date_VA.equals(shipment_replace1[3]) & Estimated_date_UV.equals(shipment_replace1[3]) & Estimated_date_dropoff.equals(shipment_replace1[5])
									&Planned_date_CL.equals(shipment_replace1[2]) & Planned_date_VD.equals(shipment_replace1[2]) & Estimated_date_CL.equals(shipment_replace1[2]) & Estimated_date_VD.equals(shipment_replace1[2])) {
						System.out.println("Planned Dates and Estimated Dates for newly added container are updated as expected");
						dateChk1=2;
					}
					else
						System.out.println("Planned Dates and Estimated Dates for newly added container are not updated as expected");
				}	
				else
				{
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
					if (Planned_date_AR.equals(shipment_replace1[4]) & Planned_date_OA.equals(shipment_replace1[4]) & Planned_date_PK.equals(shipment_replace1[4]) & 
							Estimated_date_AR.equals(shipment_replace1[4]) &  Estimated_date_OA.equals(shipment_replace1[4]) & Estimated_date_PK.equals(shipment_replace1[4]) &
							Planned_date_RL.equals(shipment_replace1[3]) & Planned_date_VA.equals(shipment_replace1[3]) & Planned_date_UV.equals(shipment_replace1[3]) & Planned_date_dropoff.equals(shipment_replace1[5]) &
									Estimated_date_RL.equals(shipment_replace1[3]) & Estimated_date_VA.equals(shipment_replace1[3]) & Estimated_date_UV.equals(shipment_replace1[3]) & Estimated_date_dropoff.equals(shipment_replace1[5])
									&Planned_date_CL.equals(shipment_replace1[2]) & Planned_date_VD.equals(shipment_replace1[2]) & Estimated_date_CL.equals(shipment_replace1[2]) & Estimated_date_VD.equals(shipment_replace1[2])) {
						System.out.println("Planned Dates and Estimated Dates for newly added container are updated as expected");
						dateChk1=1;
					}
					else
						System.out.println("Planned Dates and Estimated Dates for newly added container are not updated as expected");
					driver.navigate().refresh();
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
					if (Planned_date_AR.equals(shipment_create[4]) & Planned_date_OA.equals(shipment_create[4]) & Planned_date_PK.equals(shipment_create[4]) & 
							Estimated_date_AR.equals(shipment_replace1[4]) &  Estimated_date_OA.equals(shipment_replace1[4]) & Estimated_date_PK.equals(shipment_replace1[4]) &
							Planned_date_RL.equals(shipment_create[3]) & Planned_date_VA.equals(shipment_create[3]) & Planned_date_UV.equals(shipment_create[3]) & Planned_date_dropoff.equals(shipment_create[5]) &
									Estimated_date_RL.equals(shipment_replace1[3]) & Estimated_date_VA.equals(shipment_replace1[3]) & Estimated_date_UV.equals(shipment_replace1[3]) & Estimated_date_dropoff.equals(shipment_replace1[5])
									&Planned_date_CL.equals(shipment_create[2]) & Planned_date_VD.equals(shipment_create[2]) & Estimated_date_CL.equals(shipment_replace1[2]) & Estimated_date_VD.equals(shipment_replace1[2])) {
						System.out.println("Planned Dates and Estimated Dates  are updated as expected");
						dateChk1=2;
					}
					else
						System.out.println("Planned Dates and Estimated Dates are not updated as expected");
				}
				if (dateChk1==2) {
					mypack.Report.MyReport("16", "TC67","Replace the shipment with one more container and change in DTM Segment", "Pass");
				}
				else
					mypack.Report.MyReport("16", "TC67","Replace the shipment with one more container and change in DTM Segment", "Fail");
				
			
		//Launch the SFTP location and drop the EDI856 file with purpose code 05 added with one Container and change in DTM segments
		
					inputStream16_Replace2 = new FileInputStream(currentDir+"\\Scenario16\\3_SecureFile1.xlsx");
					XSSFWorkbook wBook16_Replace2= new XSSFWorkbook(inputStream16_Replace2);
					Sheet sheet16_Replace2 = wBook16_Replace2.getSheetAt(0);
					int rowCount16_Replace2 = sheet16_Replace2.getLastRowNum();
					//System.out.println("Number of rows : "+rowCount);
					
					for( int i=1;i<=rowCount16_Replace2;i++) {
						Row row1 = sheet16_Replace2.getRow(i);
						System.out.println(row1.getCell(4).getStringCellValue());
						//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
					
					
					mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
					
					}
							Thread.sleep(300000);
							driver.navigate().refresh();
							Thread.sleep(3000);
							driver.switchTo().frame(0);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
							int dateChk2=0;
						if(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[8]")).getText().equals(shipment_replace2[19])) {
							
							driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
							Thread.sleep(3000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
							
							if (Planned_date_AR.equals(shipment_replace2[4]) & Planned_date_OA.equals(shipment_replace2[4]) & Planned_date_PK.equals(shipment_replace2[4]) & 
									Estimated_date_AR.equals(shipment_replace2[4]) &  Estimated_date_OA.equals(shipment_replace2[4]) & Estimated_date_PK.equals(shipment_replace2[4]) &
									Planned_date_RL.equals(shipment_replace2[3]) & Planned_date_VA.equals(shipment_replace2[3]) & Planned_date_UV.equals(shipment_replace2[3]) & Planned_date_dropoff.equals(shipment_replace2[5]) &
											Estimated_date_RL.equals(shipment_replace2[3]) & Estimated_date_VA.equals(shipment_replace2[3]) & Estimated_date_UV.equals(shipment_replace2[3]) & Estimated_date_dropoff.equals(shipment_replace2[5])
											&Planned_date_CL.equals(shipment_replace2[2]) & Planned_date_VD.equals(shipment_replace2[2]) & Estimated_date_CL.equals(shipment_replace2[2]) & Estimated_date_VD.equals(shipment_replace2[2])) {
								System.out.println("Planned Dates and Estimated Dates of third container  are updated as expected");
								dateChk2=1;
							}
							else
								System.out.println("Planned Dates and Estimated Dates of third container  are not updated as expected");
							
							driver.navigate().refresh();
							Thread.sleep(3000);
							driver.switchTo().frame(0);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
							driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
							Thread.sleep(3000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
							
							if (Planned_date_AR.equals(shipment_replace1[4]) & Planned_date_OA.equals(shipment_replace1[4]) & Planned_date_PK.equals(shipment_replace1[4]) & 
									Estimated_date_AR.equals(shipment_replace2[4]) &  Estimated_date_OA.equals(shipment_replace2[4]) & Estimated_date_PK.equals(shipment_replace2[4]) &
									Planned_date_RL.equals(shipment_replace1[3]) & Planned_date_VA.equals(shipment_replace1[3]) & Planned_date_UV.equals(shipment_replace1[3]) & Planned_date_dropoff.equals(shipment_replace1[5]) &
											Estimated_date_RL.equals(shipment_replace2[3]) & Estimated_date_VA.equals(shipment_replace2[3]) & Estimated_date_UV.equals(shipment_replace2[3]) & Estimated_date_dropoff.equals(shipment_replace2[5])
											&Planned_date_CL.equals(shipment_replace1[2]) & Planned_date_VD.equals(shipment_replace1[2]) & Estimated_date_CL.equals(shipment_replace2[2]) & Estimated_date_VD.equals(shipment_replace2[2])) {
								System.out.println("Planned Dates and Estimated Dates of second container  are updated as expected");
								dateChk2=2;
							}
							else
								System.out.println("Planned Dates and Estimated Dates of second container  are not updated as expected");
							
							driver.navigate().refresh();
							Thread.sleep(3000);
							driver.switchTo().frame(0);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
							driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[3]/td[4]/a")).click();
							Thread.sleep(3000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
							
							if (Planned_date_AR.equals(shipment_create[4]) & Planned_date_OA.equals(shipment_create[4]) & Planned_date_PK.equals(shipment_create[4]) & 
									Estimated_date_AR.equals(shipment_replace2[4]) &  Estimated_date_OA.equals(shipment_replace2[4]) & Estimated_date_PK.equals(shipment_replace2[4]) &
									Planned_date_RL.equals(shipment_create[3]) & Planned_date_VA.equals(shipment_create[3]) & Planned_date_UV.equals(shipment_create[3]) & Planned_date_dropoff.equals(shipment_create[5]) &
											Estimated_date_RL.equals(shipment_replace2[3]) & Estimated_date_VA.equals(shipment_replace2[3]) & Estimated_date_UV.equals(shipment_replace2[3]) & Estimated_date_dropoff.equals(shipment_replace2[5])
											&Planned_date_CL.equals(shipment_create[2]) & Planned_date_VD.equals(shipment_create[2]) & Estimated_date_CL.equals(shipment_replace2[2]) & Estimated_date_VD.equals(shipment_replace2[2])) {
								System.out.println("Planned Dates and Estimated Dates of first container  are updated as expected");
								dateChk2=3;
							}
							else
								System.out.println("Planned Dates and Estimated Dates of first container  are not updated as expected");
							
						}
						
						if (dateChk1==3) {
							mypack.Report.MyReport("16", "TC68","Again replace the shipment with one more container and change in DTM Segment", "Pass");
						}
						else
							mypack.Report.MyReport("16", "TC68","Again replace the shipment with one more container and change in DTM Segment", "Fail");
						
						
						
						driver.close();
											
}


public static void Scenario17(String fPathLocal_17,String fPathLocal_17Replace1,String fPathLocal_17Replace2,String fPathLocalReplacecontID, String fEvent ) throws Exception {
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream17;
	InputStream inputStream17_onecnt;
	InputStream inputStream17_threecnt;
	InputStream inputStream17_contId;
	InputStream inputStream17_event;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	String PiecesUI_val=null;
	String PiecesUI_unit=null;
	String grossWeightUI=null;
	String volumneUI=null;
	String commodityUI=null;
	String equipmentDescUI=null;
	String billofladingUI=null;
	String houseBillnumUI=null;
	String bookingNumUI=null;
	String consigneeRefnum=null;
	String PiecesEDI_Unit=null;

	//String[] event_type = mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_12);
	//String[] eventType_update=mypack.EDIEventRead.MyFunctionEventtype(fEventpathLocal_Update);
	//String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal);
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment=mypack.EDIRead.MyFunction_nocontainerEDI(fPathLocal_17);
	String[] shipment1=mypack.EDIRead.MyFunction_nocontainerEDI(fPathLocal_17Replace1);
	String[] shipment2=mypack.EDIRead.MyFunction_nocontainerEDI(fPathLocal_17Replace2);
	String [] shipment3=mypack.EDIRead.MyFunction1(fPathLocalReplacecontID);
	String[] event_type=mypack.EDIEventRead.MyFunctionEventtype(fEvent);

	try {
		
		String currentDir = System.getProperty("user.dir");
	 inputStream17 = new FileInputStream(currentDir+"\\Scenario17\\1_SecureFile1.xlsx");
		XSSFWorkbook wBook17 = new XSSFWorkbook(inputStream17);
		Sheet sheet17 = wBook17.getSheetAt(0);
		int rowCount17 = sheet17.getLastRowNum();
		System.out.println("Number of rows : "+rowCount17);
		
		for( int i=1;i<=rowCount17;i++) {
			Row row3 = sheet17.getRow(i);
		System.out.println(row3.getCell(5).getStringCellValue());
		System.out.println(row3.getCell(4).getStringCellValue());
			//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
		
		
		mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());
		
		}	
		
	Thread.sleep(300000);
		

	inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
	XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
	Sheet sheet = wBook.getSheetAt(0);
	Row row = sheet.getRow(2);
	String password=row.getCell(2).getStringCellValue();
	String username=row.getCell(1).getStringCellValue();
	String url=row.getCell(0).getStringCellValue();
	System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	driver = new ChromeDriver(capabilities);
	driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("submit")).click();
	wBook.close();
	inputStream.close();
	driver.manage().window().maximize() ;

	WebDriverWait wait = new WebDriverWait(driver,3600);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));


	driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
	driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
	Thread.sleep(20000);
	
	driver.switchTo().frame(0);
	
	Thread.sleep(10000);
	Select selectMyElement_Scn4 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
	selectMyElement_Scn4.selectByVisibleText("Master Shipment Ref #");
	//System.out.println("mmmmmmmmmmmm"+noContainer[0]);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
	Thread.sleep(100000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
	
	  java.util.List<WebElement>  rows = driver.findElements(By.tagName("tr"));
	  int numberOfShipments=rows.size()-1;
	System.out.println("No of shipments are are : " + numberOfShipments);
	
	int scn17Chk=0;
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	if(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals("- - -")) {
		scn17Chk=1;
	}
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[3]")).click();
	if(shipment[5] != null) {
		if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).getText().equals(shipment[5])) {
	
		System.out.println("PO number is matching");
		scn17Chk=2;
		}
		else
			System.out.println("PO number is not matching");
	}

	else
		System.out.println("PO number is not present in EDI file");
	scn17Chk=2;
	
if ((scn17Chk==2) & (numberOfShipments==2))	{
	mypack.Report.MyReport("17", "TC69","Create a shipment (Purpose code 04) with 2 containers without the Container ID", "Pass");
}
else
	mypack.Report.MyReport("17", "TC69","Create a shipment (Purpose code 04) with 2 containers without the Container ID", "Fail");

//Launch the SFTP location and drop the EDI856 file with purpose code 05 added with one Container without Container ID and by changing the some details in the Equipment section and dates in the DTM segment
inputStream17_onecnt = new FileInputStream(currentDir+"\\Scenario17\\2_SecureFile1.xlsx");
XSSFWorkbook wBook17_onecnt = new XSSFWorkbook(inputStream17_onecnt);
Sheet sheet17_onecnt = wBook17_onecnt.getSheetAt(0);
int rowCount17_onecnt = sheet17_onecnt.getLastRowNum();
System.out.println("Number of rows : "+rowCount17_onecnt);

for( int i=1;i<=rowCount17_onecnt;i++) {
	Row row3 = sheet17_onecnt.getRow(i);
System.out.println(row3.getCell(5).getStringCellValue());
System.out.println(row3.getCell(4).getStringCellValue());
	//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());


mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());

}	

Thread.sleep(300000);
driver.navigate().refresh();
Thread.sleep(3000);
driver.switchTo().frame(0);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));



java.util.List<WebElement>  rows1 = driver.findElements(By.tagName("tr"));
int numberOfShipments1=rows.size()-1;
System.out.println("No of shipments are are : " + numberOfShipments1);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
int scn17Chk1=0;

if(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals("- - -")) {
	scn17Chk1=1;
}

Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

Estimated_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
Estimated_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
Estimated_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
Estimated_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
Estimated_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
Estimated_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
Estimated_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
Estimated_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[2]")).getText().split(" ")[0];
Estimated_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
if (Planned_date_AR.equals(shipment[2]) & Planned_date_OA.equals(shipment[2]) & Planned_date_PK.equals(shipment[2]) & 
		Estimated_date_AR.equals(shipment1[2]) &  Estimated_date_OA.equals(shipment1[2]) & Estimated_date_PK.equals(shipment1[2]) &
		Planned_date_RL.equals(shipment[3]) & Planned_date_VA.equals(shipment[3]) & Planned_date_UV.equals(shipment[3]) & Planned_date_dropoff.equals(shipment[4]) &
				Estimated_date_RL.equals(shipment1[3]) & Estimated_date_VA.equals(shipment1[3]) & Estimated_date_UV.equals(shipment1[3]) & Estimated_date_dropoff.equals(shipment1[4])
				&Planned_date_CL.equals(shipment[1]) & Planned_date_VD.equals(shipment[1]) & Estimated_date_CL.equals(shipment1[1]) & Estimated_date_VD.equals(shipment1[1])) {
	System.out.println("Planned Dates and Estimated Dates  are updated as expected");
	scn17Chk1=2;
}
else
	System.out.println("Planned Dates and Estimated Dates are not updated as expected");


driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[3]")).click();
if(shipment[5] != null) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).getText().equals(shipment1[5])) {

	System.out.println("PO number is matching");
	scn17Chk1=3;
	}
	else
		System.out.println("PO number is not matching");
}

else
	System.out.println("PO number is not present in EDI file");
scn17Chk1=3;

if ((scn17Chk1==3) & (numberOfShipments1==1))	{
mypack.Report.MyReport("17", "TC70","Replace the shipment with 1 container, without Container ID and by changing the some details in the Equipment section and dates in the DTM segment", "Pass");
}
else
mypack.Report.MyReport("17", "TC70 ","Replace the shipment with 1 container, without Container ID and by changing the some details in the Equipment section and dates in the DTM segment", "Fail");
	

//Launch the SFTP location and drop the EDI856 file with purpose code 05 added with 3 Container without Container ID and by changing the some details in the Equipment section and dates in the DTM segment

inputStream17_threecnt = new FileInputStream(currentDir+"\\Scenario17\\3_SecureFile1.xlsx");
XSSFWorkbook wBook17_threecnt = new XSSFWorkbook(inputStream17_threecnt);
Sheet sheet17_threecnt = wBook17_threecnt.getSheetAt(0);
int rowCount17_threecnt = sheet17_threecnt.getLastRowNum();
System.out.println("Number of rows : "+rowCount17_threecnt);

for( int i=1;i<=rowCount17_threecnt;i++) {
	Row row3 = sheet17_threecnt.getRow(i);
System.out.println(row3.getCell(5).getStringCellValue());
System.out.println(row3.getCell(4).getStringCellValue());
	//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());


mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());

}	

Thread.sleep(300000);
driver.navigate().refresh();
Thread.sleep(3000);
driver.switchTo().frame(0);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));



java.util.List<WebElement>  rows2 = driver.findElements(By.tagName("tr"));
int numberOfShipments2=rows.size()-1;
System.out.println("No of shipments are are : " + numberOfShipments2);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
int scn17Chk2=0;

if(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals("- - -")) {
	scn17Chk2=1;
}


if (Planned_date_AR.equals(shipment[2]) & Planned_date_OA.equals(shipment[2]) & Planned_date_PK.equals(shipment[2]) & 
		Estimated_date_AR.equals(shipment2[2]) &  Estimated_date_OA.equals(shipment2[2]) & Estimated_date_PK.equals(shipment2[2]) &
		Planned_date_RL.equals(shipment[3]) & Planned_date_VA.equals(shipment[3]) & Planned_date_UV.equals(shipment[3]) & Planned_date_dropoff.equals(shipment[4]) &
				Estimated_date_RL.equals(shipment2[3]) & Estimated_date_VA.equals(shipment2[3]) & Estimated_date_UV.equals(shipment2[3]) & Estimated_date_dropoff.equals(shipment2[4])
				&Planned_date_CL.equals(shipment[1]) & Planned_date_VD.equals(shipment[1]) & Estimated_date_CL.equals(shipment2[1]) & Estimated_date_VD.equals(shipment2[1])) {
	System.out.println("Planned Dates and Estimated Dates  are updated as expected");
	scn17Chk2=2;
}
else
	System.out.println("Planned Dates and Estimated Dates are not updated as expected");


driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[3]")).click();
if(shipment[5] != null) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).getText().equals(shipment2[5])) {

	System.out.println("PO number is matching");
	scn17Chk2=3;
	}
	else
		System.out.println("PO number is not matching");
}

else
	System.out.println("PO number is not present in EDI file");
scn17Chk2=3;

if ((scn17Chk2==3) & (numberOfShipments2==3))	{
mypack.Report.MyReport("17", "TC71","Replace the shipment with 3 container, without Container ID and by changing the some details in the Equipment section and dates in the DTM segment", "Pass");
}
else
mypack.Report.MyReport("17", "TC71 ","Replace the shipment with 3 container, without Container ID and by changing the some details in the Equipment section and dates in the DTM segment", "Fail");
	

//Launch the SFTP location and drop the EDI856 file with purpose code 05 added with 2 Container with Container ID and by changing the some details in the Equipment section and dates in the DTM segment

inputStream17_contId = new FileInputStream(currentDir+"\\Scenario17\\4_SecureFile1.xlsx");
XSSFWorkbook wBook17_contId = new XSSFWorkbook(inputStream17_contId);
Sheet sheet17_contId = wBook17_contId.getSheetAt(0);
int rowCount17_contId = sheet17_contId.getLastRowNum();
System.out.println("Number of rows : "+rowCount17_contId);

for( int i=1;i<=rowCount17_contId;i++) {
	Row row3 = sheet17_contId.getRow(i);
System.out.println(row3.getCell(5).getStringCellValue());
System.out.println(row3.getCell(4).getStringCellValue());
	//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());


mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());

}	

Thread.sleep(300000);
driver.navigate().refresh();
Thread.sleep(3000);
driver.switchTo().frame(0);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));



java.util.List<WebElement>  rows3 = driver.findElements(By.tagName("tr"));
int numberOfShipments3=rows.size()-1;
System.out.println("No of shipments are are : " + numberOfShipments3);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
int scn17Chk3=0;

if(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals(shipment3[6])
		|| driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals(shipment3[18])) {
	scn17Chk3=1;
}


if (Planned_date_AR.equals(shipment[2]) & Planned_date_OA.equals(shipment[2]) & Planned_date_PK.equals(shipment[2]) & 
		Estimated_date_AR.equals(shipment3[2]) &  Estimated_date_OA.equals(shipment3[2]) & Estimated_date_PK.equals(shipment3[2]) &
		Planned_date_RL.equals(shipment[3]) & Planned_date_VA.equals(shipment[3]) & Planned_date_UV.equals(shipment[3]) & Planned_date_dropoff.equals(shipment[4]) &
				Estimated_date_RL.equals(shipment3[3]) & Estimated_date_VA.equals(shipment3[3]) & Estimated_date_UV.equals(shipment3[3]) & Estimated_date_dropoff.equals(shipment3[4])
				&Planned_date_CL.equals(shipment[1]) & Planned_date_VD.equals(shipment[1]) & Estimated_date_CL.equals(shipment3[1]) & Estimated_date_VD.equals(shipment3[1])) {
	System.out.println("Planned Dates and Estimated Dates  are updated as expected");
	scn17Chk3=2;
}
else
	System.out.println("Planned Dates and Estimated Dates are not updated as expected");


driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[3]")).click();
if(shipment[5] != null) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).getText().equals(shipment3[17])) {

	System.out.println("PO number is matching");
	scn17Chk3=3;
	}
	else
		System.out.println("PO number is not matching");
}

else
	System.out.println("PO number is not present in EDI file");
scn17Chk3=3;

if ((scn17Chk3==3) & (numberOfShipments3==2))	{
mypack.Report.MyReport("17", "TC72","Replace the shipment with 2 container with Container ID and by changing the some details in the Equipment section and dates in the DTM segment", "Pass");
}
else
mypack.Report.MyReport("17", "TC72 ","Replace the shipment with 2 container with Container ID and by changing the some details in the Equipment section and dates in the DTM segment", "Fail");

//Launch the SFTP location and drop the EDI315 file such that it reports event for any of the milestone

inputStream17_event = new FileInputStream(currentDir+"\\Scenario17\\5_SecureFile1.xlsx");
XSSFWorkbook wBook17_event = new XSSFWorkbook(inputStream17_event);
Sheet sheet17_event = wBook17_event.getSheetAt(0);
int rowCount17_event = sheet17_event.getLastRowNum();
System.out.println("Number of rows : "+rowCount17_event);

for( int i=1;i<=rowCount17_event;i++) {
	Row row3 = sheet17_event.getRow(i);
System.out.println(row3.getCell(5).getStringCellValue());
System.out.println(row3.getCell(4).getStringCellValue());
	//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());


mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());

}	

Thread.sleep(300000);
driver.navigate().refresh();
Thread.sleep(3000);
driver.switchTo().frame(0);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
int eventVal=0;
int eventdatediff=0;
if (event_type[0].equals("AE")){
		if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
			System.out.println("Container Load event is reported ");
			eventVal=1;
			eventdatediff =event_type[1].compareTo(shipment3[2]);
			if (eventdatediff>0) {
				
				if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[1]")).isDisplayed()) {
					System.out.println("Exception");
					eventVal=1;
				}
				else
					System.out.println("Exception not displayed in UI");
					
			}
		}
		else
			System.out.println("Event reported is Container Load but is not highlighted in UI");
		
		Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
		Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
		System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
}
else if (event_type[0].equals("VD")) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
		System.out.println("Vessel Departure event is reported ");
		eventVal=1;
		eventdatediff =event_type[1].compareTo(shipment3[2]);
		if (eventdatediff>0) {
			
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[1]")).isDisplayed()) {
				System.out.println("Exception");
				eventVal=1;
			}
			else
				System.out.println("Exception not displayed in UI");
				
		}
	}
	else
		System.out.println("Event reported is Vessel Departure but is not highlighted in UI");
	
	
	Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
	 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
}

else if (event_type[0].equals("VA")) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
		System.out.println("Vessel Arrival event is reported ");
		eventVal=1;
		eventdatediff =event_type[1].compareTo(shipment3[2]);
		if (eventdatediff>0) {
			
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]")).isDisplayed()) {
				System.out.println("Exception");
				eventVal=1;
			}
			else
				System.out.println("Exception not displayed in UI");
			
		}
	}
	else
		System.out.println("Event reported is Vessel Arrival  but is not highlighted in UI");
	
	
	Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
	 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
}
 
else if (event_type[0].equals("UV")) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
		System.out.println("Container UnLoad event is reported ");
		eventVal=1;
		eventdatediff =event_type[1].compareTo(shipment3[2]);
		if (eventdatediff>0) {
			
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).isDisplayed()) {
				System.out.println("Exception");
				eventVal=1;
			}
			else
				System.out.println("Exception not displayed in UI");
				
		}
	}
	else
		System.out.println("Event reported is Container UnLoad but is not highlighted in UI");
	
	
	Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
	 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
}
else if (event_type[0].equals("RL")) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
		System.out.println("Rail Departure event is reported ");
		eventVal=1;
		eventdatediff =event_type[1].compareTo(shipment3[2]);
		if (eventdatediff>0) {
			
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[1]")).isDisplayed()) {
				System.out.println("Exception");
				eventVal=1;
			}
			else
				System.out.println("Exception not displayed in UI");
		
		}
	}
	else
		System.out.println("Event reported is Rail Departure but is not highlighted in UI");

	
	Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
	 Planned_date = driver.findElement(By.xpath("///*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
}
else if (event_type[0].equals("AR")) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
		System.out.println("Rail Arrival event is reported ");
		eventVal=1;
		eventdatediff =event_type[1].compareTo(shipment3[2]);
		if (eventdatediff>0) {
			
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[1]")).isDisplayed()) {
				System.out.println("Exception");
				eventVal=1;
			}
			else
				System.out.println("Exception not displayed in UI");
		
		}
	}
	else
		System.out.println("Event reported is Rail Arrival but is not highlighted in UI");

	
	Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
	 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
}	
else if (event_type[0].equals("OA")) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)")){
		System.out.println("Out Gate event is reported ");
		eventVal=1;
		eventdatediff =event_type[1].compareTo(shipment3[2]);
		if (eventdatediff>0) {
			
			if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[1]")).isDisplayed()) {
				System.out.println("Exception");
				eventVal=1;
			}
			else
				System.out.println("Exception not displayed in UI");
			
		}
	}
	else
		System.out.println("Event reported is OutGate but is not highlighted in UI");
	
	
	Reported_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
	 Planned_date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
	System.out.println("Planned: "+Planned_date+" Reported: "+Reported_date);
}

String exceptionMssg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr/td")).getText();
if (exceptionMssg.equals("No records found")){
	System.out.println("No records in Exceptions table");
	
	
}
else
	System.out.println("Exceptions are present in the Exceptions table");

System.out.println("EventVal= "+eventVal);	
if (eventVal==1){
	mypack.Report.MyReport("17", "TC73","Report an event for any of the container and validate that the events are getting reported.", "Pass");
	
}
else {
	mypack.Report.MyReport("17", "TC73","Report an event for any of the container and validate that the events are getting reported.", "Fail");
	
}

if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[2]")).getText().length()>0) {
	mypack.Report.MyReport("17", "TC74","Validate whether the carrier column in the Events table in the Shipment details page is getting populated when events are reported using EDI315 file", "Pass");
	
	}
	else 
		mypack.Report.MyReport("17", "TC74","Validate whether the carrier column in the Events table in the Shipment details page is getting populated when events are reported using EDI315 file" ,"Fail");



driver.close();

}catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}

public static void Scenario18(String fPathLocal_18,String fPathLocal_18_Replace1,String fPathLocal_18_Replace2) throws Exception {

	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream18;
	InputStream inputStream18_Replace1;	
	InputStream inputStream18_Replace2;	
	InputStream inputStream15_EDI;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment_create=mypack.EDIRead.MyFunction2_noDTM(fPathLocal_18);
	String[] shipment_replace1=mypack.EDIRead.MyFunction1(fPathLocal_18_Replace1);
	String[] shipment_replace2=mypack.EDIRead.MyFunction1(fPathLocal_18_Replace2);
	
	
	String currentDir = System.getProperty("user.dir");
	inputStream18 = new FileInputStream(currentDir+"\\Scenario18\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook18= new XSSFWorkbook(inputStream18);
	Sheet sheet18 = wBook18.getSheetAt(0);
	int rowCount18 = sheet18.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount18;i++) {
		Row row1 = sheet18.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
			Thread.sleep(300000);
			
			inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
			
			
			driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
			driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
			Thread.sleep(20000);
			
			driver.switchTo().frame(0);
			
			Thread.sleep(10000);
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_create[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_create[0]);
			//count number of shipments
			//No.of rows 
			  java.util.List<WebElement>  rows = driver.findElements(By.tagName("tr"));
			  int numberOfShipments=rows.size()-1;
			System.out.println("No of shipments are  : " + numberOfShipments);

			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	int chkFlag=0;	
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals("- - -")){
		System.out.println("Container ID is blank");
		chkFlag=1;
	}
	else
		System.out.println("Conatainer ID is not blank");
	
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[10]/div[2]")).getText().equals("Draft")) {
		System.out.println("Shipment is in Draft status");
		chkFlag=2;
	}
	else
		System.out.println("Shipment is not in Draft status");
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[3]")).click();
	if(shipment_create[9] != null) {
		if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).getText().equals(shipment_create[9])) {
	
		System.out.println("PO number is matching");
		chkFlag=3;
		}
		else
			System.out.println("PO number is not matching");
	}

	else
		System.out.println("PO number is not present in EDI file");
	chkFlag=3;

//add for other sections in container details
	//Planned and Estimated dates blank
	if ((chkFlag==3) & (numberOfShipments==2)) {
		mypack.Report.MyReport("18", "TC75","Create a shipment (Purpose code 04) with 2 containers without the Container ID and DTM*369 segment", "Pass");
	}
	else
		mypack.Report.MyReport("18", "TC75","Create a shipment (Purpose code 04) with 2 containers without the Container ID and DTM*369 segment", "Fail");
	
	
//Launch the SFTP location and updated the EDI856 file with purpose code 05 with DTM*369 segment and change in References
	inputStream18_Replace1 = new FileInputStream(currentDir+"\\Scenario18\\2_SecureFile1.xlsx");
	XSSFWorkbook wBook18_Replace1= new XSSFWorkbook(inputStream18_Replace1);
	Sheet sheet18_Replace1 = wBook18_Replace1.getSheetAt(0);
	int rowCount18_Replace1 = sheet18_Replace1.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount18_Replace1;i++) {
		Row row1 = sheet18_Replace1.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}	

Thread.sleep(300000);
driver.navigate().refresh();
Thread.sleep(3000);
driver.switchTo().frame(0);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
int chkFlag1=0;	
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a")).click();
Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
java.util.List<WebElement>  rows1 = driver.findElements(By.tagName("tr"));
int numberOfShipments1=rows1.size()-1;
System.out.println("No of shipments are are : " + numberOfShipments1);

if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals("- - -")){
	System.out.println("Container ID is blank");
	chkFlag1=1;
}
else
	System.out.println("Container ID is not blank");

if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[10]/div[2]")).getText().equals("Planned")) {
	System.out.println("Shipment is in Planned status");
	chkFlag1=2;
}
else
	System.out.println("Shipment is not in Planned status");

driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[3]")).click();
if(shipment_replace1[17] != null) {
	if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).getText().equals(shipment_replace1[17])) {

	System.out.println("PO number is matching");
	chkFlag1=3;
	}
	else
		System.out.println("PO number is not matching");
}

else
	System.out.println("PO number is not present in EDI file");
chkFlag1=3;


if (Planned_date_AR.equals(shipment_replace1[4]) & Planned_date_OA.equals(shipment_replace1[4]) & Planned_date_PK.equals(shipment_replace1[4]) & 
		Estimated_date_AR.equals(shipment_replace1[4]) &  Estimated_date_OA.equals(shipment_replace1[4]) & Estimated_date_PK.equals(shipment_replace1[4]) &
		Planned_date_RL.equals(shipment_replace1[3]) & Planned_date_VA.equals(shipment_replace1[3]) & Planned_date_UV.equals(shipment_replace1[3]) & Planned_date_dropoff.equals(shipment_create[5]) &
				Estimated_date_RL.equals(shipment_replace1[3]) & Estimated_date_VA.equals(shipment_replace1[3]) & Estimated_date_UV.equals(shipment_replace1[3]) & Estimated_date_dropoff.equals(shipment_replace1[5])
				&Planned_date_CL.equals(shipment_replace1[2]) & Planned_date_VD.equals(shipment_replace1[2]) & Estimated_date_CL.equals(shipment_replace1[2]) & Estimated_date_VD.equals(shipment_replace1[2])) {
	System.out.println("Planned Dates and Estimated Dates  are updated as expected");
	chkFlag1=4;
}
else
	System.out.println("Planned Dates and Estimated Dates are not updated as expected");

if((chkFlag1==4) & (numberOfShipments1==2)) {
	mypack.Report.MyReport("18", "TC76","Replace the shipment with DTM*369 segment and change in References", "Pass");
}
else
	mypack.Report.MyReport("18", "TC76","Replace the shipment with DTM*369 segment and change in References", "Fail");

//Check for References -- to include

//Launch the SFTP location and drop the EDI856 file with purpose code 05 added with 3 Container with Container ID and by changing the some details in the Equipment section and dates in the DTM segment
inputStream18_Replace2 = new FileInputStream(currentDir+"\\Scenario18\\3_SecureFile1.xlsx");
XSSFWorkbook wBook18_Replace2= new XSSFWorkbook(inputStream18_Replace2);
Sheet sheet18_Replace2 = wBook18_Replace2.getSheetAt(0);
int rowCount18_Replace2 = sheet18_Replace2.getLastRowNum();
//System.out.println("Number of rows : "+rowCount);

for( int i=1;i<=rowCount18_Replace2;i++) {
	Row row1 = sheet18_Replace2.getRow(i);
	System.out.println(row1.getCell(4).getStringCellValue());
	//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());


mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());

}	

Thread.sleep(300000);
driver.navigate().refresh();
Thread.sleep(3000);
driver.switchTo().frame(0);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
int chkFlag2=0;	
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[3]/td[4]")).click();
Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
java.util.List<WebElement>  rows2 = driver.findElements(By.tagName("tr"));
int numberOfShipments2=rows2.size()-1;
System.out.println("No of shipments are are : " + numberOfShipments2);

if((driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals(shipment_replace2[6]))
		||  (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals(shipment_replace2[17]))
		||  (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[2]")).getText().equals(shipment_replace2[18]))){
System.out.println("Container ID populated");
 chkFlag2=1;	
}
else
System.out.println("Container ID is not populated");



driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/nav/a[3]")).click();
if(shipment_replace2[17] != null) {
if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[6]/div[2]/div[2]/div/div[3]/div/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).getText().equals(shipment_replace2[17])) {

System.out.println("PO number is matching");
chkFlag2=3;
}
else
	System.out.println("PO number is not matching");
}

else
System.out.println("PO number is not present in EDI file");
chkFlag2=3;

if (Planned_date_AR.equals(shipment_replace1[4]) & Planned_date_OA.equals(shipment_replace1[4]) & Planned_date_PK.equals(shipment_replace1[4]) & 
	Estimated_date_AR.equals(shipment_replace2[4]) &  Estimated_date_OA.equals(shipment_replace2[4]) & Estimated_date_PK.equals(shipment_replace2[4]) &
	Planned_date_RL.equals(shipment_replace1[3]) & Planned_date_VA.equals(shipment_replace1[3]) & Planned_date_UV.equals(shipment_replace1[3]) & Planned_date_dropoff.equals(shipment_replace1[5]) &
			Estimated_date_RL.equals(shipment_replace2[3]) & Estimated_date_VA.equals(shipment_replace2[3]) & Estimated_date_UV.equals(shipment_replace2[3]) & Estimated_date_dropoff.equals(shipment_replace2[5])
			&Planned_date_CL.equals(shipment_replace1[2]) & Planned_date_VD.equals(shipment_replace1[2]) & Estimated_date_CL.equals(shipment_replace2[2]) & Estimated_date_VD.equals(shipment_replace2[2])) {
System.out.println("Planned Dates and Estimated Dates  are updated as expected");
chkFlag2=4;
}
else
System.out.println("Planned Dates and Estimated Dates are not updated as expected");


if((chkFlag2==4) & (numberOfShipments2==3)) {
	mypack.Report.MyReport("18", "TC77","Replace the shipment with 3 container with Container ID and by changing the some details in the Equipment section and dates in the DTM segment", "Pass");
}
else
	mypack.Report.MyReport("18", "TC77","Replace the shipment with 3 container with Container ID and by changing the some details in the Equipment section and dates in the DTM segment", "Fail");

}


public static void Scenario19(String fPathLocal_19,String fPathLocal_19Event) throws Exception {
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream19;
	InputStream inputStream19_Replace1;	
	InputStream inputStream16_Replace2;	
	InputStream inputStream15_EDI;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment_create=mypack.EDIRead.MyFunction1(fPathLocal_19);
	String[] event_19 = mypack.EDIEventRead.MyFunctionEventtype(fPathLocal_19Event);
	
	String currentDir = System.getProperty("user.dir");
	inputStream19 = new FileInputStream(currentDir+"\\Scenario19\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook19= new XSSFWorkbook(inputStream19);
	Sheet sheet19 = wBook19.getSheetAt(0);
	int rowCount19 = sheet19.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount19;i++) {
		Row row1 = sheet19.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
			Thread.sleep(300000);
			
			inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
			
			
			driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
			driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
			Thread.sleep(20000);
			
			driver.switchTo().frame(0);
			
			Thread.sleep(10000);
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_create[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_create[0]);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		

			Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

			Estimated_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			if (Planned_date_AR.equals(shipment_create[4]) & Planned_date_OA.equals(shipment_create[4]) & Planned_date_PK.equals(shipment_create[4]) & 
					Estimated_date_AR.equals(shipment_create[4]) &  Estimated_date_OA.equals(shipment_create[4]) & Estimated_date_PK.equals(shipment_create[4]) &
					Planned_date_RL.equals(shipment_create[3]) & Planned_date_VA.equals(shipment_create[3]) & Planned_date_UV.equals(shipment_create[3]) & Planned_date_dropoff.equals(shipment_create[5]) &
							Estimated_date_RL.equals(shipment_create[3]) & Estimated_date_VA.equals(shipment_create[3]) & Estimated_date_UV.equals(shipment_create[3]) & Estimated_date_dropoff.equals(shipment_create[5])
							&Planned_date_CL.equals(shipment_create[2]) & Planned_date_VD.equals(shipment_create[2]) & Estimated_date_CL.equals(shipment_create[2]) & Estimated_date_VD.equals(shipment_create[2])) {
				
				System.out.println("Planned and Estimated dates of container are from original edi856(04) file");
				mypack.Report.MyReport("19", "TC78","Create shipments with purpose code 04", "Pass");
			}
			else
				System.out.println("Planned and Estimated dates of container are not from original edi856(04) file");
			mypack.Report.MyReport("19", "TC78","Create shipments with purpose code 04", "Fail");
		
	
			
			
			//Launch the SFTP location and drop the EDI315 file for the drop off milestone with 30 days more than planned date of pick up
			
			inputStream19_Replace1 = new FileInputStream(currentDir+"\\Scenario19\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook19_Replace1= new XSSFWorkbook(inputStream19_Replace1);
			Sheet sheet19_Replace1 = wBook19_Replace1.getSheetAt(0);
			int rowCount19_Replace1 = sheet19_Replace1.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount19_Replace1;i++) {
				Row row1 = sheet19_Replace1.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
					Thread.sleep(300000);
					driver.navigate().refresh();
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
				
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
					int eventDiff= event_19[1].compareTo(shipment_create[4]);
					if ((event_19[0].equals("X1")) & (eventDiff>30)) {
						if (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[10]/div[2]")).getText().equals("Completed") &
							 (driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[1]")).getCssValue("color").equals("rgba(0, 0, 0, 1)"))){
								System.out.println("DropOff event is correctly reported ");
								mypack.Report.MyReport("19", "TC79","Report Drop off event 30 days more than planned date of pick up", "Pass");
						
							
						}
						else
							System.out.println("DropOff event is not reported");
						mypack.Report.MyReport("19", "TC79","Report Drop off event 30 days more than planned date of pick up", "Fail");
					}
	
}

public static void Scenario20(String fPathLocal_20_Create1,String fPathLocal_20_Replace1,String fPathLocal_20_Create2,String fPathLocal_20_Replace2,
		String fPathLocal_20_Create3,String fPathLocal_20_Replace3,String fPathLocal_20_Create4,String fPathLocal_20_Replace4) throws Exception {
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream20_Create1;
	InputStream inputStream20_Replace1;
	InputStream inputStream20_Create2;
	InputStream inputStream20_Replace2;
	InputStream inputStream20_Create3;
	InputStream inputStream20_Replace3;
	InputStream inputStream20_Create4;
	InputStream inputStream20_Replace4;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment_Create1=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_20_Create1);
	String [] shipment_Replace1=mypack.EDIRead.MyFunction_OceanLeg(fPathLocal_20_Replace1);
	String[] shipment_Create2=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_20_Create2);
	String [] shipment_Replace2=mypack.EDIRead.MyFunction_containerEDI_OceanDray(fPathLocal_20_Replace2);
	String[] shipment_Create3=mypack.EDIRead.MyFunction_OceanLeg(fPathLocal_20_Create3);
	String [] shipment_Replace3=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_20_Replace3);
	String[] shipment_Create4=mypack.EDIRead.MyFunction_containerEDI_OceanDray(fPathLocal_20_Create4);
	String [] shipment_Replace4=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_20_Replace4);
	//String[] event_19 = mypack.EDIEventRead.MyFunctionEventtype(fPathLocal_19Event);
	
	
	String currentDir = System.getProperty("user.dir");
	inputStream20_Create1 = new FileInputStream(currentDir+"\\Scenario20\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook20_Create1= new XSSFWorkbook(inputStream20_Create1);
	Sheet sheet20_Create1 = wBook20_Create1.getSheetAt(0);
	int rowCount20_Create1 = sheet20_Create1.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount20_Create1;i++) {
		Row row1 = sheet20_Create1.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
			Thread.sleep(300000);
			inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
			
			
			driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
			driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
			Thread.sleep(20000);
			
			driver.switchTo().frame(0);
			
			Thread.sleep(10000);
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment_Create1[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment_Create1[0]);
			int dateC=0;
			int noOfLegs=0;
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));

			Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

			Estimated_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_VD = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_VA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_UV = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[2]")).getText().split(" ")[0];
			Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
			//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]
			//*[@id="root"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]
			//*[@id="root"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]
			//*[@id="root"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div
			
			if (Planned_date_AR.equals(shipment_Create1[2]) & Planned_date_OA.equals(shipment_Create1[2]) & Planned_date_PK.equals(shipment_Create1[2]) & 
					Estimated_date_AR.equals(shipment_Create1[2]) &  Estimated_date_OA.equals(shipment_Create1[2]) & Estimated_date_PK.equals(shipment_Create1[2]) &
					Planned_date_RL.equals(shipment_Create1[3]) & Planned_date_VA.equals(shipment_Create1[3]) & Planned_date_UV.equals(shipment_Create1[3]) & Planned_date_dropoff.equals(shipment_Create1[4]) &
							Estimated_date_RL.equals(shipment_Create1[3]) & Estimated_date_VA.equals(shipment_Create1[3]) & Estimated_date_UV.equals(shipment_Create1[3]) & Estimated_date_dropoff.equals(shipment_Create1[4])
							&Planned_date_CL.equals(shipment_Create1[1]) & Planned_date_VD.equals(shipment_Create1[1]) & Estimated_date_CL.equals(shipment_Create1[1]) & Estimated_date_VD.equals(shipment_Create1[1])) {
				
				System.out.println("Planned and Estimated dates are taken from the DTM segments in the EDI856");
				dateC=1;
				
				//cellOut_21.setCellValue("Pass");
			}
			else
				System.out.println("Planned and Estimated dates are not taken from the DTM segments in the EDI856");
			
			 noOfLegs = driver.findElements(By.xpath("//div[@class='names']")).size();
				System.out.println("Number of Legs :"+noOfLegs);
				
			if ((noOfLegs==3) & (dateC==1)) {
				mypack.Report.MyReport("20", "TC80","Create shipments with purpose code “Original” (04) (Ocean +Rail+Dray)", "Pass");
			}
			else
				mypack.Report.MyReport("20", "TC80","Create shipments with purpose code “Original” (04) (Ocean +Rail+Dray)", "Fail");
			
	//Launch the SFTP location and drop the EDI856 file with purpose code 05 with just the ocean
			inputStream20_Replace1 = new FileInputStream(currentDir+"\\Scenario20\\2_SecureFile1.xlsx");
			XSSFWorkbook wBook20_Replace1= new XSSFWorkbook(inputStream20_Replace1);
			Sheet sheet20_Replace1 = wBook20_Replace1.getSheetAt(0);
			int rowCount20_Replace1 = sheet20_Replace1.getLastRowNum();
			//System.out.println("Number of rows : "+rowCount);
			
			for( int i=1;i<=rowCount20_Replace1;i++) {
				Row row1 = sheet20_Replace1.getRow(i);
				System.out.println(row1.getCell(4).getStringCellValue());
				//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			
			mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
			
			}
					Thread.sleep(300000);
					
					driver.navigate().refresh();
					
					
					Thread.sleep(3000);
					driver.switchTo().frame(0);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
					int noOfLegs1=0;
					int dateD=0;
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
					Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
					Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
					Estimated_date_VA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
					Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
					
					if ((Planned_date_VA.equals(shipment_Create1[3])) & (Planned_date_UV.equals(shipment_Create1[3])) &
									 (Estimated_date_VA.equals(shipment_Replace1[3])) & (Estimated_date_UV.equals(shipment_Replace1[3]))
									& (Planned_date_CL.equals(shipment_Create1[1])) & (Planned_date_VD.equals(shipment_Create1[1])) &
									(Estimated_date_CL.equals(shipment_Replace1[2])) & (Estimated_date_VD.equals(shipment_Replace1[2]))) 
						
									
						
					{
						System.out.println("Planned and Estimated dates are taken as expected");
						dateD=1;
						 
					}
						else
							System.out.println("Dates are not taken as expected");
					noOfLegs1 = driver.findElements(By.xpath("//div[@class='names']")).size();
					System.out.println("Number of Legs :"+noOfLegs1);

					if((dateD==1) & (noOfLegs1==1)){
						mypack.Report.MyReport("20", "TC81","Replace shipments with purpose code “Original” (05) with just the ocean leg", "Pass");
					}
					else
						mypack.Report.MyReport("20", "TC81","Replace shipments with purpose code “Original” (05) with just the ocean leg", "Fail");

					

				//Launch the SFTP location and drop the EDI856 file with purpose code 04 and with 3 legs (Ocean +Rail+Dray)
						inputStream20_Create2 = new FileInputStream(currentDir+"\\Scenario20\\3_SecureFile1.xlsx");
						XSSFWorkbook wBook20_Create2 = new XSSFWorkbook(inputStream20_Create2);
						Sheet sheet20_Create2 = wBook20_Create2.getSheetAt(0);
						int rowCount20_Create2 = sheet20_Create2.getLastRowNum();
						//System.out.println("Number of rows : "+rowCount);
						
						for( int i=1;i<=rowCount20_Create2;i++) {
							Row row1 = sheet20_Create2.getRow(i);
							System.out.println(row1.getCell(4).getStringCellValue());
							//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
						
						
						mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
						
						}
								Thread.sleep(300000);
								
								driver.navigate().refresh();
								
								
								Thread.sleep(3000);
								driver.switchTo().frame(0);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
								int noOfLegs2=0;
								int dateE=0;
								driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
								Thread.sleep(3000);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
								
								Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
								Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
								Estimated_date_VA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
								Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
								Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
								Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
								Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
								Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
								Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];


								Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
								Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
								Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
								Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
								Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
								Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
								Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
								Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
								Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

								if ((Planned_date_AR.equals(shipment_Create2[2])) & (Planned_date_OA.equals(shipment_Create2[2])) & (Planned_date_PK.equals(shipment_Create2[2])) & 
										(Estimated_date_AR.equals(shipment_Create2[2])) &  (Estimated_date_OA.equals(shipment_Create2[2])) & (Estimated_date_PK.equals(shipment_Create2[2])) &
										(Planned_date_RL.equals(shipment_Create2[3])) & (Planned_date_VA.equals(shipment_Create2[3])) & (Planned_date_UV.equals(shipment_Create2[3])) & (Planned_date_dropoff.equals(shipment_Create2[4])) &
												(Estimated_date_RL.equals(shipment_Create2[3])) & (Estimated_date_VA.equals(shipment_Create2[3])) & (Estimated_date_UV.equals(shipment_Create2[3])) & (Estimated_date_dropoff.equals(shipment_Create2[4]))
												& (Planned_date_CL.equals(shipment_Create2[1])) & (Planned_date_VD.equals(shipment_Create2[1])) & (Estimated_date_CL.equals(shipment_Create2[1])) & (Estimated_date_VD.equals(shipment_Create2[1]))) {
									
									System.out.println("Planned and Estimated dates are taken as expected");
									dateE=1;
									
								}
								else
									System.out.println("Planned and Estimated dates are not as expected");
								
								 noOfLegs2 = driver.findElements(By.xpath("//div[@class='names']")).size();
									System.out.println("Number of Legs :"+noOfLegs2);
								if((dateE==1) & (noOfLegs2==3))
								{
											mypack.Report.MyReport("20", "TC82","Create shipments with purpose code “Original” (04) (Ocean +Rail+Dray)", "Pass");
													}
													else
											mypack.Report.MyReport("20", "TC82","Create shipments with purpose code “Original” (04) (Ocean +Rail+Dray)", "Fail");
		
					

//Launch the SFTP location and drop the EDI856 file with purpose code 05 with Ocean + Dray leg
					inputStream20_Replace2 = new FileInputStream(currentDir+"\\Scenario20\\4_SecureFile1.xlsx");
					XSSFWorkbook wBook20_Replace2 = new XSSFWorkbook(inputStream20_Replace2);
					Sheet sheet20_Replace2 = wBook20_Replace2.getSheetAt(0);
					int rowCount20_Replace2 = sheet20_Replace2.getLastRowNum();
					//System.out.println("Number of rows : "+rowCount);
											
							for( int i=1;i<=rowCount20_Replace2;i++) {
							Row row1 = sheet20_Replace2.getRow(i);
							System.out.println(row1.getCell(4).getStringCellValue());
							//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
											
											
							mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
											
											}
							Thread.sleep(300000);
													
							driver.navigate().refresh();
							Thread.sleep(3000);
							driver.switchTo().frame(0);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
							int noOfLegs3=0;
							int dateF=0;
							driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
							Thread.sleep(3000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
							Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
							Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
							Estimated_date_VA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
							Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
							Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
							Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
							Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
							Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
							Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];


							Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
							Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
							Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
							Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
							Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
							Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
							Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
							Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
							Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

							if ((Planned_date_VA.equals(shipment_Create2[3])) & (Planned_date_UV.equals(shipment_Create2[3])) & 
								(Planned_date_dropoff.equals(shipment_Create2[4])) &(Estimated_date_VA.equals(shipment_Replace2[2])) & 
								(Estimated_date_UV.equals(shipment_Replace2[2])) & (Estimated_date_dropoff.equals(shipment_Replace2[3]))
								& (Planned_date_CL.equals(shipment_Create2[1])) & (Planned_date_VD.equals(shipment_Create2[1])) & 
								(Estimated_date_CL.equals(shipment_Replace2[1])) & (Estimated_date_VD.equals(shipment_Replace2[1]))) 
								
										{
								
								System.out.println("Planned and Estimated dates are taken as expected");
								dateF=1;
								
							}
							else
								System.out.println("Planned and Estimated dates are not as expected");
							
							 noOfLegs3 = driver.findElements(By.xpath("//div[@class='names']")).size();
								System.out.println("Number of Legs :"+noOfLegs3);
													
							if((dateF==1) & (noOfLegs3==2))
							{
										mypack.Report.MyReport("20", "TC83","Replace shipments with purpose code “Original” (05) with Ocean + Dray leg", "Pass");
												}
												else
										mypack.Report.MyReport("20", "TC83","Replace shipments with purpose code “Original” (05) with Ocean + Dray leg", "Fail");
									
			
			
	//Launch the SFTP location and drop the EDI856 file with purpose code 04 with just the ocean leg

							inputStream20_Create3 = new FileInputStream(currentDir+"\\Scenario20\\5_SecureFile1.xlsx");
							XSSFWorkbook wBook20_Create3 = new XSSFWorkbook(inputStream20_Create3);
							Sheet sheet20_Create3 = wBook20_Create3.getSheetAt(0);
							int rowCount20_Create3 = sheet20_Create3.getLastRowNum();
							//System.out.println("Number of rows : "+rowCount);
							
							for( int i=1;i<=rowCount20_Create3;i++) {
								Row row1 = sheet20_Create3.getRow(i);
								System.out.println(row1.getCell(4).getStringCellValue());
								//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
							
							
							mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
							
							}
									Thread.sleep(300000);
									
									driver.navigate().refresh();
									
									
									Thread.sleep(3000);
									driver.switchTo().frame(0);
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
									int dateG=0;
									int noOfLegs4=0;
									driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
									Thread.sleep(3000);
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
									Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
									Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
									Estimated_date_VA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
									Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
									Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
									Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
									Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
									Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
									Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];


									Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
									Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
									Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
									Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
									Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
									Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
									Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
									Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
									Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

									if ((Planned_date_VA.equals(shipment_Create3[3])) & (Planned_date_UV.equals(shipment_Create3[3])) &
											 (Estimated_date_VA.equals(shipment_Create3[3])) & (Estimated_date_UV.equals(shipment_Create3[3]))
											& (Planned_date_CL.equals(shipment_Create3[2])) & (Planned_date_VD.equals(shipment_Create3[2])) &
											(Estimated_date_CL.equals(shipment_Create3[2])) & (Estimated_date_VD.equals(shipment_Create3[2]))) 
								
									{
										System.out.println("Planned and Estimated dates are taken as expected");
										dateG=1;
										
									}
									else
										System.out.println("Planned and Estimated dates are not as expected");				
									 noOfLegs4 = driver.findElements(By.xpath("//div[@class='names']")).size();
										System.out.println("Number of Legs :"+noOfLegs4);
									if((dateG==1) & (noOfLegs4==1))
									{
												mypack.Report.MyReport("20", "TC84","Create shipments with purpose code “Original” (04) with just the ocean leg", "Pass");
														}
														else
												mypack.Report.MyReport("20", "TC84","Create shipments with purpose code “Original” (04) with just the ocean leg", "Fail");
																		
	//Launch the SFTP location and drop the EDI856 file with purpose code 05 with (Ocean + Rail + Dray) leg
									inputStream20_Replace3= new FileInputStream(currentDir+"\\Scenario20\\6_SecureFile1.xlsx");
									XSSFWorkbook wBook20_Replace3 = new XSSFWorkbook(inputStream20_Replace3);
									Sheet sheet20_Replace3 = wBook20_Replace3.getSheetAt(0);
									int rowCount20_Replace3 = sheet20_Replace3.getLastRowNum();
									//System.out.println("Number of rows : "+rowCount);
									
									for( int i=1;i<=rowCount20_Replace3;i++) {
										Row row1 = sheet20_Replace3.getRow(i);
										System.out.println(row1.getCell(4).getStringCellValue());
										//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
									
									
									mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
									
									}
											Thread.sleep(300000);
											
											driver.navigate().refresh();
											
											
											Thread.sleep(3000);
											driver.switchTo().frame(0);
											wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
											int noOfLegs5=0;
											int dateH=0;
											
											driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
											Thread.sleep(3000);
											wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
											Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
											Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
											Estimated_date_VA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
											Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
											Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
											Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
											Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
											Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
											Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];


											Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
											Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
											Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
											Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
											Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
											Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
											Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
											Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
											Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

											
											if (Planned_date_AR.equals(shipment_Replace3[2]) & Planned_date_OA.equals(shipment_Replace3[2]) & 
													Planned_date_PK.equals(shipment_Replace3[2]) & 
													Estimated_date_AR.equals(shipment_Replace3[2]) &  Estimated_date_OA.equals(shipment_Replace3[2]) & 
													Estimated_date_PK.equals(shipment_Replace3[2]) &
													Estimated_date_dropoff.equals(shipment_Replace3[4]) & Planned_date_dropoff.equals(shipment_Replace3[4]) &
													Planned_date_RL.equals(shipment_Replace3[3]) & Planned_date_VA.equals(shipment_Create1[3]) & 
													Planned_date_UV.equals(shipment_Create1[3]) & 
															Estimated_date_RL.equals(shipment_Replace3[3]) & Estimated_date_VA.equals(shipment_Replace3[3]) & 
															Estimated_date_UV.equals(shipment_Replace3[3]) 
															&Planned_date_CL.equals(shipment_Create1[1]) & Planned_date_VD.equals(shipment_Create1[1]) & 
															Estimated_date_CL.equals(shipment_Replace3[1]) & Estimated_date_VD.equals(shipment_Replace3[1])) {
												
												System.out.println("Planned and Estimated dates are taken as expected");
												dateH=1;
												
											}
											else
												System.out.println("Planned and Estimated dates are not as expected");	
											noOfLegs5 = driver.findElements(By.xpath("//div[@class='names']")).size();
											System.out.println("Number of Legs :"+noOfLegs5);									
											if((dateH==1) & (noOfLegs5==3))
											{
														mypack.Report.MyReport("20", "TC85","Replace shipments with purpose code “Original” (05) with (Ocean + Rail + Dray) leg", "Pass");
																}
																else
														mypack.Report.MyReport("20", "TC85","Replace shipments with purpose code “Original” (05) with (Ocean + Rail + Dray) leg", "Fail");			
														
//Launch the SFTP location and drop the EDI856 file with purpose code 04 with (Ocean + Dray) legs
											inputStream20_Create4= new FileInputStream(currentDir+"\\Scenario20\\7_SecureFile1.xlsx");
											XSSFWorkbook wBook20_Create4 = new XSSFWorkbook(inputStream20_Create4);
											Sheet sheet20_Create4 = wBook20_Create4.getSheetAt(0);
											int rowCount20_Create4 = sheet20_Create4.getLastRowNum();
											//System.out.println("Number of rows : "+rowCount);
											
											for( int i=1;i<=rowCount20_Create4;i++) {
												Row row1 = sheet20_Create4.getRow(i);
												System.out.println(row1.getCell(4).getStringCellValue());
												//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
											
											
											mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
											
											}
													Thread.sleep(300000);
													
													driver.navigate().refresh();
													
													
													Thread.sleep(3000);
													driver.switchTo().frame(0);
													wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
													int noOfLegs6=0;
													int dateI=0;
													driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
													Thread.sleep(3000);
													wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
													
													Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
													Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
													Estimated_date_VA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
													Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
													Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
													Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
													Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
													Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
													Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];


													Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
													Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
													Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
													Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
													Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
													Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
													Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
													Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
													Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

													
													if (Planned_date_AR.equals(shipment_Create4[2]) & Planned_date_OA.equals(shipment_Create4[2]) & Planned_date_PK.equals(shipment_Create4[2]) & 
															Estimated_date_AR.equals(shipment_Create4[2]) &  Estimated_date_OA.equals(shipment_Create4[2]) & Estimated_date_PK.equals(shipment_Create4[2]) &
															Estimated_date_dropoff.equals(shipment_Create4[4]) & Planned_date_dropoff.equals(shipment_Create4[4]) &
															Planned_date_RL.equals(shipment_Create4[3]) & Planned_date_VA.equals(shipment_Create4[3]) & Planned_date_UV.equals(shipment_Create4[3]) & 
																	Estimated_date_RL.equals(shipment_Create4[3]) & Estimated_date_VA.equals(shipment_Create4[3]) & Estimated_date_UV.equals(shipment_Create4[3]) 
																	&Planned_date_CL.equals(shipment_Create4[1]) & Planned_date_VD.equals(shipment_Create4[1]) & Estimated_date_CL.equals(shipment_Create4[1])
																	& Estimated_date_VD.equals(shipment_Create4[1])) {
														
														System.out.println("Planned and Estimated dates are taken as expected");
														dateI=1;
														
													}
													else
														System.out.println("Planned and Estimated dates are not as expected");	
													
													noOfLegs6 = driver.findElements(By.xpath("//div[@class='names']")).size();
													System.out.println("Number of Legs :"+noOfLegs6);
													if((dateI==1) & (noOfLegs6==2))
													{
																mypack.Report.MyReport("20", "TC86","Create shipments with purpose code “Original” (04) with (Ocean + Dray) legs", "Pass");
																		}
																		else
																mypack.Report.MyReport("20", "TC86","Create shipments with purpose code “Original” (04) with (Ocean + Dray) legs", "Fail");

//Launch the SFTP location and drop the EDI856 file with purpose code 05 with (Ocean + Rail + Dray) leg

													inputStream20_Replace4= new FileInputStream(currentDir+"\\Scenario20\\8_SecureFile1.xlsx");
													XSSFWorkbook wBook20_Replace4 = new XSSFWorkbook(inputStream20_Replace4);
													Sheet sheet20_Replace4 = wBook20_Replace4.getSheetAt(0);
													int rowCount20_Replace4 = sheet20_Replace4.getLastRowNum();
													//System.out.println("Number of rows : "+rowCount);
													
													for( int i=1;i<=rowCount20_Replace4;i++) {
														Row row1 = sheet20_Replace4.getRow(i);
														System.out.println(row1.getCell(4).getStringCellValue());
														//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
													
													
													mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
													
													}
															Thread.sleep(300000);
															
															driver.navigate().refresh();
															
															
															Thread.sleep(3000);
															driver.switchTo().frame(0);
															wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[local-name() = 'svg']")));
															int noOfLegs7=0;
															int dateJ=0;
															driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a")).click();
															Thread.sleep(3000);
															wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
															
															Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
															Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
															Estimated_date_VA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
															Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
															Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
															Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
															Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
															Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
															Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];



															Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
															Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
															Estimated_date_VA= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
															Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
															Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
															Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
															Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
															Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];
															Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];

															
															if (Planned_date_AR.equals(shipment_Replace4[2]) & Planned_date_OA.equals(shipment_Replace4[2]) & Planned_date_PK.equals(shipment_Replace4[2]) & 
																	Estimated_date_AR.equals(shipment_Replace4[2]) &  Estimated_date_OA.equals(shipment_Replace4[2]) & Estimated_date_PK.equals(shipment_Replace4[2]) &
																	Estimated_date_dropoff.equals(shipment_Replace4[4]) & Planned_date_dropoff.equals(shipment_Create1[4]) &
																	Planned_date_RL.equals(shipment_Create4[3]) & Planned_date_VA.equals(shipment_Create1[3]) & Planned_date_UV.equals(shipment_Create1[3]) & 
																			Estimated_date_RL.equals(shipment_Replace4[3]) & Estimated_date_VA.equals(shipment_Replace4[3]) & Estimated_date_UV.equals(shipment_Replace4[3]) 
																			&Planned_date_CL.equals(shipment_Create1[1]) & Planned_date_VD.equals(shipment_Create1[1]) & Estimated_date_CL.equals(shipment_Replace4[1]) & 
																			Estimated_date_VD.equals(shipment_Replace4[1])) {
																
																System.out.println("Planned and Estimated dates are taken as expected");
																dateJ=1;
																 
															}
															else
																System.out.println("Planned and Estimated dates are not as expected");		
															noOfLegs7 = driver.findElements(By.xpath("//div[@class='names']")).size();
															System.out.println("Number of Legs :"+noOfLegs7);
													
															if((dateJ==1) & (noOfLegs7==3))
															{
																		mypack.Report.MyReport("20", "TC87","Replace shipments with purpose code “Original” (05) with (Ocean + Rail + Dray) leg", "Pass");
																				}
																				else
																		mypack.Report.MyReport("20", "TC87","Replace shipments with purpose code “Original” (05) with (Ocean + Rail + Dray) leg", "Fail");								
													
}
public static void Scenario21(String fPathLocal_21) throws Exception {
	
	WebDriver driver;
	InputStream inputStream;
	InputStream inputStream21;
	String masterShipmenrRefnumUI=null;
	String statusSUmmary=null;
	String status_detail =null;
	String statusSUmmary_scn3=null;
	String status_detail_scn3=null;
	String status_e2eShipment=null;
	String legStatus_scn3=null;
	String Planned_date=null;
	String Reported_date=null;
	String railArrivalEst=null;
	String outGateEst=null;
	String pickUpEst=null;
	String dropOffEst=null;
	String railDepartureEst=null;
	String containerUnloadEst=null;
	String vesselArrivalEst=null;
	String containerID_scn4=null;
	String vesselArrival_scn4=null;
	String vesselDep_scn4=null;
	String railDep_scn4=null;
	String railArrival_scn4=null;
	String dropOff_scn4=null;
	String vesselDeparture_nocon=null;
	String	vesselArrival_nocon=null;
	String	containerUnload_nocon=null;
	String	railDeparture_nocon=null;
	String	railArrival_nocon=null;
	String	outGate_nocon=null;
	String	pickUp_nocon=null;
	String	dropOff_nocon=null;
	String vesselDeparture_con=null;
	String	vesselArrival_con=null;
	String	containerUnload_con=null;
	String	railDeparture_con=null;
	String	railArrival_con=null;
	String	outGate_con=null;
	String	pickUp_con=null;
	String	dropOff_con=null;
	String statusSUmmary_scn5=null;
	String e2Estatus_scn5=null;
	String Planned_date_PK =null;
	String Planned_date_VD  =null;
	String Planned_date_VA =null;
	String Planned_date_UV  =null;
	String Planned_date_RL  =null;
	String Planned_date_AR =null;
	String Planned_date_OA =null;
	String Planned_date_dropoff=null;
	String Planned_date_CL=null;
	String Estimated_date_PK =null;
	String Estimated_date_VD  =null;
	String Estimated_date_VA =null;
	String Estimated_date_UV  =null;
	String Estimated_date_RL  =null;
	String Estimated_date_AR =null;
	String Estimated_date_OA =null;
	String Estimated_date_dropoff=null;
	String Estimated_date_CL=null;
	//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
	String[] shipment=mypack.EDIRead.MyFunction_containerEDI(fPathLocal_21);
	//String[] event_19 = mypack.EDIEventRead.MyFunctionEventtype(fPathLocal_19Event);
	
	String currentDir = System.getProperty("user.dir");
	inputStream21 = new FileInputStream(currentDir+"\\Scenario21\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook21= new XSSFWorkbook(inputStream21);
	Sheet sheet21 = wBook21.getSheetAt(0);
	int rowCount21 = sheet21.getLastRowNum();
	//System.out.println("Number of rows : "+rowCount);
	
	for( int i=1;i<=rowCount21;i++) {
		Row row1 = sheet21.getRow(i);
		System.out.println(row1.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	}
			Thread.sleep(300000);
			
	           
			inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
			XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
			Sheet sheet = wBook.getSheetAt(0);
			Row row = sheet.getRow(2);
			String password=row.getCell(2).getStringCellValue();
			String username=row.getCell(1).getStringCellValue();
			String url=row.getCell(0).getStringCellValue();
			System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			driver = new ChromeDriver(capabilities);
			driver.get(url);
		  	driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			wBook.close();
			inputStream.close();
			driver.manage().window().maximize() ;
	
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));
			
			
			driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
			driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
			Thread.sleep(20000);
			
			driver.switchTo().frame(0);
			
			Thread.sleep(10000);
			
			Select selectMyElement = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
			selectMyElement.selectByVisibleText("Master Shipment Ref #");
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
	
			driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
			Thread.sleep(100000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);
			int check=0;
			int noOfLegs=0;
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
		

			Planned_date_PK = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VD = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_VA= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_UV = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_RL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_AR = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_OA = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_dropoff=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div/div[3]/div")).getText().split(" ")[0];
			Planned_date_CL=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).getText().split(" ")[0];

			

		Estimated_date_PK = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[8]")).getText().split(" ")[0];
		Estimated_date_VD = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[2]")).getText().split(" ")[0];
		Estimated_date_VA= driver.findElement(By.xpath("(//div[contains(text(),'Est')])[3]")).getText().split(" ")[0];
		Estimated_date_UV = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[4]")).getText().split(" ")[0];
		Estimated_date_RL = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[5]")).getText().split(" ")[0];
		Estimated_date_AR = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[6]")).getText().split(" ")[0];
		Estimated_date_OA = driver.findElement(By.xpath("(//div[contains(text(),'Est')])[7]")).getText().split(" ")[0];
		Estimated_date_dropoff=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[9]")).getText().split(" ")[0];
		Estimated_date_CL=driver.findElement(By.xpath("(//div[contains(text(),'Est')])[1]")).getText().split(" ")[0];
			
			if (Planned_date_AR.equals(shipment[2]) & Planned_date_OA.equals(shipment[2]) & Planned_date_PK.equals(shipment[2]) & 
					Estimated_date_AR.equals(shipment[2]) &  Estimated_date_OA.equals(shipment[2]) & Estimated_date_PK.equals(shipment[2]) &
					Planned_date_RL.equals(shipment[3]) & Planned_date_VA.equals(shipment[3]) & Planned_date_UV.equals(shipment[3]) & Planned_date_dropoff.equals(shipment[4]) &
							Estimated_date_RL.equals(shipment[3]) & Estimated_date_VA.equals(shipment[3]) & Estimated_date_UV.equals(shipment[3]) & Estimated_date_dropoff.equals(shipment[4])
							&Planned_date_CL.equals(shipment[1]) & Planned_date_VD.equals(shipment[1]) & Estimated_date_CL.equals(shipment[1]) & Estimated_date_VD.equals(shipment[1])) {
				
				System.out.println("Planned and Estimated dates are taken from the DTM segments in the EDI856");
				check=1;
				 noOfLegs = driver.findElements(By.xpath("//div[@class='names']")).size();
				System.out.println("Number of Legs :"+noOfLegs);
				//cellOut_21.setCellValue("Pass");
			}
			else
				System.out.println("Planned and Estimated dates are not taken from the DTM segments in the EDI856");
			
			if((check==1) & (noOfLegs==3))
			{
						mypack.Report.MyReport("21", "TC88","Validating whether all the legs are getting displayed when rail and dray location are the same", "Pass");
								}
								else
						mypack.Report.MyReport("21", "TC88","Validating whether all the legs are getting displayed when rail and dray location are the same", "Fail");		
			
		
}		

public static void Scenario26(String fPathLocal_21) throws Exception {	

WebDriver driver;
InputStream inputStream;
InputStream inputStream21;
InputStream inputStream12_container;
String masterShipmenrRefnumUI=null;
String statusSUmmary=null;
String status_detail =null;
String statusSUmmary_scn3=null;
String status_detail_scn3=null;
String status_e2eShipment=null;
String legStatus_scn3=null;
String Planned_date=null;
String Reported_date=null;
String railArrivalEst=null;
String outGateEst=null;
String pickUpEst=null;
String dropOffEst=null;
String railDepartureEst=null;
String containerUnloadEst=null;
String vesselArrivalEst=null;
String containerID_scn4=null;
String vesselArrival_scn4=null;
String vesselDep_scn4=null;
String railDep_scn4=null;
String railArrival_scn4=null;
String dropOff_scn4=null;
String vesselDeparture_nocon=null;
String	vesselArrival_nocon=null;
String	containerUnload_nocon=null;
String	railDeparture_nocon=null;
String	railArrival_nocon=null;
String	outGate_nocon=null;
String	pickUp_nocon=null;
String	dropOff_nocon=null;
String vesselDeparture_con=null;
String	vesselArrival_con=null;
String	containerUnload_con=null;
String	railDeparture_con=null;
String	railArrival_con=null;
String	outGate_con=null;
String	pickUp_con=null;
String	dropOff_con=null;
String statusSUmmary_scn5=null;
String e2Estatus_scn5=null;
String Planned_date_PK =null;
String Planned_date_VD  =null;
String Planned_date_VA =null;
String Planned_date_UV  =null;
String Planned_date_RL  =null;
String Planned_date_AR =null;
String Planned_date_OA =null;
String Planned_date_dropoff=null;
String Planned_date_CL=null;
String Estimated_date_PK =null;
String Estimated_date_VD  =null;
String Estimated_date_VA =null;
String Estimated_date_UV  =null;
String Estimated_date_RL  =null;
String Estimated_date_AR =null;
String Estimated_date_OA =null;
String Estimated_date_dropoff=null;
String Estimated_date_CL=null;
String PiecesUI_val=null;
String PiecesUI_unit=null;
String grossWeightUI=null;
String volumneUI=null;
String commodityUI=null;
String equipmentDescUI=null;
String billofladingUI=null;
String houseBillnumUI=null;
String bookingNumUI=null;
String consigneeRefnum=null;
String PiecesEDI_Unit=null;

//String[] event_type = mypack.EDIEventRead.MyFunctionEventtype(fEVentpathLocal_12);
//String[] eventType_update=mypack.EDIEventRead.MyFunctionEventtype(fEventpathLocal_Update);
//String[] eventAG=mypack.EDIEventRead.MyFunctionAGEventtype(AGeventpathLocal);
//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
String[] shipment=mypack.EDIRead.MyFunction1(fPathLocal_21);


try {
	
	String currentDir = System.getProperty("user.dir");
 inputStream21 = new FileInputStream(currentDir+"\\Scenario21\\1_SecureFile1.xlsx");
	XSSFWorkbook wBook21 = new XSSFWorkbook(inputStream21);
	Sheet sheet21 = wBook21.getSheetAt(0);
	int rowCount21 = sheet21.getLastRowNum();
	System.out.println("Number of rows : "+rowCount21);
	
	for( int i=1;i<=rowCount21;i++) {
		Row row3 = sheet21.getRow(i);
	System.out.println(row3.getCell(5).getStringCellValue());
	System.out.println(row3.getCell(4).getStringCellValue());
		//ftp ftpobj=new ftp(row1.getCell(5).getStringCellValue(),row1.getCell(0).getStringCellValue(),row1.getCell(1).getStringCellValue(),row1.getCell(2).getStringCellValue(),row1.getCell(3).getStringCellValue(),row1.getCell(4).getStringCellValue());
	
	
	mypack.ftp.myFtp(row3.getCell(5).getStringCellValue(),row3.getCell(0).getStringCellValue(),row3.getCell(1).getStringCellValue(),row3.getCell(2).getStringCellValue(),row3.getCell(3).getStringCellValue(),row3.getCell(4).getStringCellValue());
	
	}	
	
Thread.sleep(300000);
	

inputStream = new FileInputStream(currentDir+"//CredentialsFile.xlsx");
XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
Sheet sheet = wBook.getSheetAt(0);
Row row = sheet.getRow(2);
String password=row.getCell(2).getStringCellValue();
String username=row.getCell(1).getStringCellValue();
String url=row.getCell(0).getStringCellValue();
System.setProperty("webdriver.chrome.driver",currentDir+"\\chromedriver.exe");
DesiredCapabilities capabilities = new DesiredCapabilities();
driver = new ChromeDriver(capabilities);
driver.get(url);
	driver.findElement(By.id("username")).sendKeys(username);
driver.findElement(By.id("password")).sendKeys(password);
driver.findElement(By.name("submit")).click();
wBook.close();
inputStream.close();
driver.manage().window().maximize() ;

WebDriverWait wait = new WebDriverWait(driver,3600);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggle")));


driver.findElement(By.xpath("//*[@id=\"toggle\"][2]")).click();
driver.findElement(By.xpath("//*[@id=\"11\"]/a[1]")).click();
Thread.sleep(100000);


driver.switchTo().frame(0);
Thread.sleep(1000);
Select selectMyElement_Scn4 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/select")));
selectMyElement_Scn4.selectByVisibleText("Master Shipment Ref #");
//System.out.println("mmmmmmmmmmmm"+noContainer[0]);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/input")).sendKeys(shipment[0]);
Thread.sleep(5000);
driver.findElement(By.xpath("//*[local-name() = 'svg']")).click();
Thread.sleep(100000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/a"))).getText().equals(shipment[0]);

//No.of rows 
  java.util.List<WebElement>  rows = driver.findElements(By.tagName("tr"));
System.out.println("No of rows are : " + rows.size());


Thread.sleep(1000);


System.out.println("Number of containers from EDI "+shipment[14]);
driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")).click();
Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/span")));
	
PiecesUI_val=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[4]/div[2]/div/div[2]/div/div[3]/div[2]/div[2]")).getText().split(" ")[0];
PiecesUI_unit=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[4]/div[2]/div/div[2]/div/div[3]/div[2]/div[2]/span")).getText();
grossWeightUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[4]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]")).getText().split(" ")[0];
volumneUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[4]/div[2]/div/div[2]/div/div[1]/div[4]/div[2]")).getTagName().split(" ")[0];
billofladingUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[1]/div[2]")).getText();
houseBillnumUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div[2]")).getText();
//consigneeRefnum;
bookingNumUI=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div/div/div[3]/div[1]/div[2]")).getText();
System.out.println("PiecesUI_val "+PiecesUI_val);
if (PiecesUI_val.equals(shipment[7])) {
	System.out.println("Pieces value is as per EDI");
	
}
else
	System.out.println("Pieces value is not as per EDI");


if (shipment[8].equals("CT")){
	PiecesEDI_Unit="CARTON";
}
else if (shipment[8].equals("PX")){
	PiecesEDI_Unit="PALLET";
}
else if (shipment[8].equals("PK")){
	PiecesEDI_Unit="PACKAGE";
}
else if (shipment[8].equals("PCS")){
	PiecesEDI_Unit="PIECES";
}
else if (shipment[8].equals("CS")){
	PiecesEDI_Unit="CASE";
}

System.out.println("PiecesEDI_Unit " +PiecesEDI_Unit);
System.out.println("PiecesUI_unit " +PiecesUI_unit);
if (PiecesEDI_Unit.equals(PiecesUI_unit)) {
	System.out.println("Unit value is as per EDI");
}
else
	System.out.println("Unit value is not as per EDI");

	
}catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
