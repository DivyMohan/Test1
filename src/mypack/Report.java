package mypack;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Report {

	
	//load function here

public static void MyReport(String S1, String S2, String S3, String S4) {
	
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
	    	  
	       // System.out.println("File created: " + myObj.getName());
	      } else {
	       // System.out.println("File already exists.");
	         
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

	
	 public static void main(String[] args) {
		    try {
		    //file creation as per need
		    /*	
		      File myObj = new File("index.html");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      */
		    	   	
		    	
		    	
		    	//write desired info
		      File htmlTemplateFile = new File("indexTest.html");
		      String htmlString = FileUtils.readFileToString(htmlTemplateFile);
		      String title = "TestCase Report";
		      //String body = "";
		      htmlString = htmlString.replace("$title", title);
		     // htmlString = htmlString.replace("$body", body);
		      
		      String content="<tr><td>1<td>TC1<td>Pass<td>Pass";
		      htmlString = htmlString.replace("$content", content);
		      
		      String scenario1="<tr><td>2<td>TC2<td>Pass<td>Pass";
		      htmlString = htmlString.replace("$Scenario1", scenario1);
		      
		      String scenario2="<tr><td>2<td>TC2<td>Pass<td>Pass";
		      htmlString = htmlString.replace("$Scenario2", scenario2);
		      
		      String scenario3="<tr><td>2<td>TC2<td>Pass<td>Pass";
		      htmlString = htmlString.replace("$Scenario3", scenario3);
		      
		      File newHtmlFile = new File("Report.html");
		      FileUtils.writeStringToFile(newHtmlFile, htmlString);
		      System.out.println("Test Report generated!");
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }


	
}
