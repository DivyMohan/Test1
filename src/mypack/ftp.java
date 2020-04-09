package mypack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ftp {
	
public static int iVal=0;
public ftp (String fileType, String host, String userName , String password, String localFilePath, String ftpDirectory) throws Exception {
		
		FTPClient ftp = null;

		System.out.println("FTP Upload Start");
		
		int mystatus=0;
		int myInitstatus=0;
		
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		try{
			ftp.connect(host);
		
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			
			mystatus=3;
			ftp.disconnect();
			
			throw new Exception("Exception in connecting to FTP Server");
			
		}
		}
		catch (Exception e) {
			// do nothing as file is already saved to server
			mystatus=3;
		}
		try{
			ftp.login(userName, password);
		}
		catch (Exception e) {
			// do nothing as file is already saved to server
			mystatus=4;
		}
		
		try{
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		ftp.enterLocalPassiveMode();
		
		String fileUploadName = fileType + ".edi";
		
		try{
			
		InputStream input = new FileInputStream(new File(localFilePath));
			ftp.storeFile(ftpDirectory + fileUploadName, input);
			mystatus=2;
			}
		catch (FileNotFoundException ex) {
			// do nothing as file is already saved to server
			mystatus=1;
		}
		
		if (ftp.isConnected()) {
			try {
				ftp.logout();
				ftp.disconnect();
			} catch (Exception f) {
				// do nothing as file is already saved to server
				mystatus=1;
			}
		}
		iVal++;
		int mystatusFinal=3;
		System.out.println("FTP Upload Done");
		
		
		String Status="";
		String TestStatus="";
		String TestCase="";
		String Scenario="";
		
		if(myInitstatus==0) {
			Scenario="1";
		}
		if(mystatusFinal==3) {
			 TestCase="TC0"+iVal;
		}
		if(mystatus==4) {
			 Status="Fail";
			 TestStatus="Fail";
		}
		if(mystatus==3) {
			 Status="Fail";
			 TestStatus="Fail";
		}
		if(mystatus==2) {
			 Status="Pass";
			 TestStatus="Pass";
		}
		if(mystatus==1) {
			 Status="Pass";
			 TestStatus="Fail";
		}
					
		//call Report function
		//MyReport(Scenario,TestCase,TestStatus) ;
		
		//return this;
	}

public static void myFtp(String fileType, String host, String userName , String password, String localFilePath, String ftpDirectory) throws Exception {
		
		FTPClient ftp = null;

		System.out.println("FTP Upload Start");
		
		int mystatus=0;
		int myInitstatus=0;
		
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		try{
			ftp.connect(host);
		
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			
			mystatus=3;
			ftp.disconnect();
			
			throw new Exception("Exception in connecting to FTP Server");
			
		}
		}
		catch (Exception e) {
			// do nothing as file is already saved to server
			mystatus=3;
		}
		try{
			ftp.login(userName, password);
		}
		catch (Exception e) {
			// do nothing as file is already saved to server
			mystatus=4;
		}
		
		try{
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		ftp.enterLocalPassiveMode();
		
		String fileUploadName = fileType + ".txt";
		
		try{
			
		InputStream input = new FileInputStream(new File(localFilePath));
			ftp.storeFile(ftpDirectory + fileUploadName, input);
			mystatus=2;
			}
		catch (FileNotFoundException ex) {
			// do nothing as file is already saved to server
			mystatus=1;
		}
		
		if (ftp.isConnected()) {
			try {
				ftp.logout();
				ftp.disconnect();
			} catch (Exception f) {
				// do nothing as file is already saved to server
				mystatus=1;
			}
		}
		iVal++;
		int mystatusFinal=3;
		System.out.println("FTP Upload Done");
		
		
		String Status="";
		String TestStatus="";
		String TestCase="";
		String Scenario="";
		
		if(myInitstatus==0) {
			Scenario="1";
		}
		if(mystatusFinal==3) {
			 TestCase="TC0"+iVal;
		}
		if(mystatus==4) {
			 Status="Fail";
			 TestStatus="Fail";
		}
		if(mystatus==3) {
			 Status="Fail";
			 TestStatus="Fail";
		}
		if(mystatus==2) {
			 Status="Pass";
			 TestStatus="Pass";
		}
		if(mystatus==1) {
			 Status="Pass";
			 TestStatus="Fail";
		}
					
		//call Report function
		//MyReport(Scenario,TestCase,TestStatus) ;
		
		//return this;
	}

public void MyReport(String S1, String S2, String S3, String S4) {
	
    try {
	    //file creation as per need
	    
	      File myObj = new File("TestReport.html");
	      if (myObj.createNewFile()) {
	    	  
	    	  //write desired info
		      File htmlTemplateFile = new File("index.html");
		      String htmlString = FileUtils.readFileToString(htmlTemplateFile);
		      String title = "TestCase Report";
		      //String body = "";
		      htmlString = htmlString.replace("$title", title);
		      String content="<table align=center border=1><tr><th>Scenario<th>TestCase<th>TestCase Description<th>TestStatus<tr><td>"+S1+"<td>"+S2+"<td>"+S3+"<td>"+S4+"</td>";
		      htmlString = htmlString.replace("$content", content);
		      
		      File newHtmlFile = new File("TestReport.html");
		      FileUtils.writeStringToFile(newHtmlFile, htmlString,true);
		     
		      System.out.println("Test Report generated!");
	    	  
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	         
	    	// write desired info
	      File htmlTemplateFile = new File("index.html");
	      String htmlString = FileUtils.readFileToString(htmlTemplateFile);
	     	      
	      String content="<tr><td>"+S1+"<td>"+S2+"<td>"+S3+"<td>"+S4+"</td>";
	      htmlString = htmlString.replace("$content", content);
	      File newHtmlFile = new File("TestReport.html");
	      FileUtils.writeStringToFile(newHtmlFile, htmlString,true);
	     
	      System.out.println("Test Report generated!");
	      }
	      
	      
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	
}


// Main method to invoke the above methods
public static void main(String[] args) {
    try {
    	//String fileType, String host, String userName , String password, String localFilePath, String ftpDirectory
    	String currentDir = System.getProperty("user.dir");
    	FileInputStream inputStream = new FileInputStream(currentDir+"\\Scenario1\\1_SecureFile1.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(inputStream);
		Sheet sheet = wBook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		//System.out.println("Number of rows : "+rowCount);
		
		for( int i=1;i<=rowCount;i++) {
			Row row = sheet.getRow(i);
			
			ftp ftpobj=new ftp(row.getCell(5).getStringCellValue(),row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),row.getCell(4).getStringCellValue());
			
		}
		
		
	//	ftp ftpobj2=new ftp("two",row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),row.getCell(4).getStringCellValue());
		
		//ftp ftpobj3=new ftp("one",row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),row.getCell(4).getStringCellValue());
	//	ftp ftpobj4=new ftp("two",row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),row.getCell(4).getStringCellValue());
		
        //ftp ftpobj = new ftp("one","data.interasset.com","olusa", "YzA@0LChKK4w38C","D:\\BLUME\\Visibility\\856_1.txt","/uat/receive/856/");
       // ftpobj.uploadFileFTP(, "edittedDataFile", "/uat/receive/856");
      //  ftpobj.disconnect();
      
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

