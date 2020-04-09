package mypack;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Pattern;
import mypack.dateConvertor;		
public class EDIEventRead {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//String EDIpath = "D:\\BLUME\\Visibility\\856_1.txt";
		
	//call function
		//String[] retval_event=MyFunctionEventtype();
		//String[] retvalAG=   MyFunctionAGEventtype();		      
		      
		      }	 

	public static String[] MyFunctionEventtype(String eventPathLocal) throws Exception {
		File myObj = new File(eventPathLocal);
		Scanner myReader = new Scanner(myObj);
		String eventType=null;
		String reportedDate = null;
		try{
		while (myReader.hasNextLine()) {
		  String data = myReader.nextLine();

		  	if(data.contains("B4")) {
		  	String[] arrOfStr1 = data.split("\\*");
		  	eventType = (arrOfStr1[3]);
		  	reportedDate= (arrOfStr1[4]);
		  	}

		}
		System.out.println(eventType);
		}catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	}
		//System.out.println("Event Date in EDI :"+reportedDate);
		String reportedDate_conv=mypack.dateConvertor.toconvertStringtoDate(reportedDate);
		//System.out.println("Event Date in after function call :"+reportedDate_conv);
		String myarrayEvent[]={eventType,reportedDate_conv};
		return myarrayEvent;
	}
	
	public static String[] MyFunctionEventtype2(String eventPathLocal) throws Exception {
		File myObj = new File(eventPathLocal);
		Scanner myReader = new Scanner(myObj);
		String eventType=null;
		String reportedDate = null;
		try{
		while (myReader.hasNextLine()) {
		  String data = myReader.nextLine();

		  	if(data.contains("B4")) {
		  	String[] arrOfStr1 = data.split("\\^");
		  	eventType = (arrOfStr1[3]);
		  	reportedDate= (arrOfStr1[4]);
		  	}

		}
		System.out.println(eventType);
		}catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	}
		//System.out.println("Event Date in EDI :"+reportedDate);
		String reportedDate_conv=mypack.dateConvertor.toconvertStringtoDate(reportedDate);
		//System.out.println("Event Date in after function call :"+reportedDate_conv);
		String myarrayEvent[]={eventType,reportedDate_conv};
		return myarrayEvent;
	}

	public static String[] MyFunctionAGEventtype(String agEventpathLocal) throws Exception {
		File myObj = new File(agEventpathLocal);
		Scanner myReader = new Scanner(myObj);
		String reportedDateAG = null;
		String location=null;
		try{
		while (myReader.hasNextLine()) {
		  String data = myReader.nextLine();

		  	if(data.contains("B4")) {
		  	String[] arrOfStr1 = data.split("\\*");
		  	reportedDateAG= (arrOfStr1[4]);
		  	location = (arrOfStr1[11]);
		  	}

		}
		
		}catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	}
		System.out.println("Event Date in AG event EDI :"+reportedDateAG);
		String reportedDateAG_conv=mypack.dateConvertor.toconvertStringtoDate(reportedDateAG);
		//System.out.println("Event Date in after function call :"+reportedDateAG_conv);
		String myarrayAGEvent[]={reportedDateAG_conv,location};
		return myarrayAGEvent;
	}
	

}

	
		   


	
	
		      

	



