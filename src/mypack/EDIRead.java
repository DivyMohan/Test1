package mypack;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import mypack.dateConvertor;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Pattern;

import org.checkerframework.checker.index.qual.LengthOf;
		
public class EDIRead {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//String EDIpath = "D:\\BLUME\\Visibility\\856_1.txt";
		  //Provide filepath
		//String fPath = "D:\\BLUME\\Visibility\\856_5.txt";
		//call function
				//String[] retval=MyFunction1(fPath);   
		      }	 

@SuppressWarnings("null")
public static String[] MyFunction1(String fPathLocal) throws Exception {
File myObj = new File(fPathLocal);
Scanner myReader = new Scanner(myObj);
String masterShipmentRefNum=null;
String VESSELNAME = null;
String vesselArrival=null;
String vesselDeparture=null;
String railArrival=null;
String dropOff=null;
String Pieces=null;
String Unit=null;
String Volume=null;
String[] Weight={"one","Two","three","four"};
String[] CONTAINERID= {"one","Two","three","four"};
String houseBillNumber=null;
String bookingNumber =null;
String billOfLading=null;
String frieghtDesc=null;
String CONSIGNEE=null;
int cont_count = 0;
String CONREFNUM=null;
String[] arrOfStr2=null;
String[] arrOfStr1=null;
String[] arrOfStr11=null;
String PONumber=null;
try{
while (myReader.hasNextLine()) {
  String data = myReader.nextLine();

  	if(data.contains("BSN")) {
  	 arrOfStr1 = data.split("\\*");
  	 masterShipmentRefNum = (arrOfStr1[2]);
  	}
  	if(data.contains("TD3")) {
  		cont_count++;
  		for(int i=cont_count;i>0;i--){
			arrOfStr2 = data.split("\\*");
	  		 CONTAINERID[i] = (arrOfStr2[2]+arrOfStr2[3]);
	      	Weight[i]=arrOfStr2[5];
	      	break;
		      
    }
  	 
	   }
	  	
  
   
    if(data.contains("N1") &  data.contains("UC")) {
  	  			String[] arrOfStr7 = data.split("\\*");
  	  			CONSIGNEE = (arrOfStr7[2]);
                 
           }
     else if(data.contains("TD5") &  data.contains("S")) {
                 String[] arrOfStr8 = data.split("\\*");
                 String CARRIERCODE = (arrOfStr8[3]);
               
           }
           else if(data.contains("REF") &  data.contains("WU")) {
                 String[] arrOfStr9 = data.split("\\*");
                  VESSELNAME = (arrOfStr9[2]);
                 
           }
           else if(data.contains("REF") &  data.contains("V3")) {
                 String[] arrOfStr10 = data.split("\\*");
                 String VOYAGENUMBER = (arrOfStr10[2]);
              
           }
           else if(data.contains("REF") &  data.contains("CO")) {
                  arrOfStr11 = data.split("\\*");
                  CONREFNUM = (arrOfStr11[2]);
          
           }
           else if (data.contains("DTM") & data.contains("369")) {
        	   String[] arrOfStr12 = data.split("\\*");
                vesselDeparture = (arrOfStr12[2]);
           }
           else if (data.contains("DTM") & data.contains("371")) {
        	   String[] arrOfStr13 = data.split("\\*");
                vesselArrival = (arrOfStr13[2]);
           }
    
           else if (data.contains("DTM") & data.contains("597")) {
        	   String[] arrOfStr14 = data.split("\\*");
                railArrival = (arrOfStr14[2]);
           }
           else if (data.contains("DTM") & data.contains("017")) {
        	   String[] arrOfStr15 = data.split("\\*");
                dropOff = (arrOfStr15[2]);
           }
  
     if(data.contains("REF") &  data.contains("BM")) {
  	  String[] arrOfStr3 = data.split("\\*");
      	 billOfLading = (arrOfStr3[2]);
    }
    if(data.contains("REF") &  data.contains("BN")) {
  	  	String[] arrOfStr4 = data.split("\\*");
      	 bookingNumber = (arrOfStr4[2]);
    }
    if(data.contains("REF") &  data.contains("HB")) {
  	  String[] arrOfStr5 = data.split("\\*");
      	 houseBillNumber = (arrOfStr5[2]);
           
    }
    if(data.contains("MEA") &  data.contains("SQ")) {
			String[] arrOfStr21 = data.split("\\*");
			 Pieces = (arrOfStr21[3]);
         
   }
    
    if(data.contains("MEA") &  data.contains("SQ")) {
		String[] arrOfStr22 = data.split("\\*");
		 Unit = (arrOfStr22[4]);
     
}
    
    if(data.contains("MEA") &  data.contains("VOL")) {
		String[] arrOfStr23 = data.split("\\*");
		 Volume = (arrOfStr23[3]);
     
}
    if(data.contains("PRF")) {
    	  String[] arrOfStr6 = data.split("\\*");
        	 PONumber = (arrOfStr6[1]);
      }

    
    if(data.contains("REF") &  data.contains("STB")) {
		String[] arrOfStr24 = data.split("\\*");
		 frieghtDesc = (arrOfStr24[2]);
     
}
}
myReader.close();
    }
catch (Exception e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
}

System.out.println("billOfLading"+billOfLading);
 System.out.println("houseBillNumber"+houseBillNumber);          
System.out.println("No of containers :"+cont_count);
System.out.println(vesselDeparture);
System.out.println(PONumber);
String vesseldeparture_conv=mypack.dateConvertor.toconvertStringtoDate(vesselDeparture);
System.out.println("Container:"+CONTAINERID[2]);
String railArrival_conv=mypack.dateConvertor.toconvertStringtoDate(railArrival);
String vesselArrival_conv=mypack.dateConvertor.toconvertStringtoDate(vesselArrival);
String dropOff_conv=mypack.dateConvertor.toconvertStringtoDate(dropOff);
System.out.println(vesseldeparture_conv+vesselArrival_conv+railArrival_conv+dropOff_conv);
String myarray[]={masterShipmentRefNum,VESSELNAME,vesseldeparture_conv,vesselArrival_conv,railArrival_conv,dropOff_conv,CONTAINERID[1],Pieces,Unit,Volume,Weight[1],
		houseBillNumber,billOfLading,bookingNumber,null,CONSIGNEE,String.valueOf(cont_count),PONumber,CONTAINERID[2]};

String myarrayThreeContainer[]={masterShipmentRefNum,VESSELNAME,vesseldeparture_conv,vesselArrival_conv,railArrival_conv,dropOff_conv,CONTAINERID[1],Pieces,Unit,Volume,Weight[1],
		houseBillNumber,billOfLading,bookingNumber,null,CONSIGNEE,String.valueOf(cont_count),PONumber,CONTAINERID[2],CONTAINERID[3]};
 //myArray[0] = {masterShipmentRefNum};
 //myArray[1]= {VESSELNAME};


if (cont_count==3) {
	return myarrayThreeContainer;
}
else
	return myarray;
}


public static String[] MyFunction_OceanLeg(String fPathLocal) throws Exception {
File myObj = new File(fPathLocal);
Scanner myReader = new Scanner(myObj);
String masterShipmentRefNum=null;
String VESSELNAME = null;
String vesselArrival=null;
String vesselDeparture=null;
String railArrival=null;
String dropOff=null;
String Pieces=null;
String Unit=null;
String Volume=null;
String[] Weight={"one","Two","three"};
String[] CONTAINERID= {"one","Two","three"};
String houseBillNumber=null;
String bookingNumber =null;
String billOfLading=null;
String frieghtDesc=null;
String CONSIGNEE=null;
int cont_count = 0;
String CONREFNUM=null;
String[] arrOfStr2=null;
String[] arrOfStr1=null;
try{
while (myReader.hasNextLine()) {
  String data = myReader.nextLine();

  	if(data.contains("BSN")) {
  	 arrOfStr1 = data.split("\\*");
  	 masterShipmentRefNum = (arrOfStr1[2]);
  	}
  	if(data.contains("TD3")) {
  		cont_count++;
  		for(int i=cont_count;i>0;i--){
			arrOfStr2 = data.split("\\*");
	  		 CONTAINERID[i] = (arrOfStr2[2]+arrOfStr2[3]);
	      	Weight[i]=arrOfStr2[5];
	      	break;
		      
    }
  	 
	   }
	  	
  
    if(data.contains("PRF")) {
  	  String[] arrOfStr6 = data.split("\\*");
      	String PONumber = (arrOfStr6[1]);
    }

    if(data.contains("N1") &  data.contains("UC")) {
  	  			String[] arrOfStr7 = data.split("\\*");
  	  			CONSIGNEE = (arrOfStr7[2]);
                 
           }
     else if(data.contains("TD5") &  data.contains("S")) {
                 String[] arrOfStr8 = data.split("\\*");
                 String CARRIERCODE = (arrOfStr8[3]);
               
           }
           else if(data.contains("REF") &  data.contains("WU")) {
                 String[] arrOfStr9 = data.split("\\*");
                  VESSELNAME = (arrOfStr9[2]);
                 
           }
           else if(data.contains("REF") &  data.contains("V3")) {
                 String[] arrOfStr10 = data.split("\\*");
                 String VOYAGENUMBER = (arrOfStr10[2]);
              
           }
           else if(data.contains("REF") &  data.contains("CO")) {
                 String[] arrOfStr11 = data.split("\\*");
                  CONREFNUM = (arrOfStr11[2]);
          
           }
           else if (data.contains("DTM") & data.contains("369")) {
        	   String[] arrOfStr12 = data.split("\\*");
                vesselDeparture = (arrOfStr12[2]);
           }
           else if (data.contains("DTM") & data.contains("371")) {
        	   String[] arrOfStr13 = data.split("\\*");
                vesselArrival = (arrOfStr13[2]);
           }
    
          
  
     if(data.contains("REF") &  data.contains("BM")) {
  	  String[] arrOfStr3 = data.split("\\*");
      	 billOfLading = (arrOfStr3[2]);
    }
    if(data.contains("REF") &  data.contains("BN")) {
  	  	String[] arrOfStr4 = data.split("\\*");
      	 bookingNumber = (arrOfStr4[2]);
    }
    if(data.contains("REF") &  data.contains("HB")) {
  	  String[] arrOfStr5 = data.split("\\*");
      	 houseBillNumber = (arrOfStr5[2]);
           
    }
    if(data.contains("MEA") &  data.contains("SQ")) {
			String[] arrOfStr21 = data.split("\\*");
			 Pieces = (arrOfStr21[3]);
         
   }
    
    if(data.contains("MEA") &  data.contains("SQ")) {
		String[] arrOfStr22 = data.split("\\*");
		 Unit = (arrOfStr22[4]);
     
}
    
    if(data.contains("MEA") &  data.contains("VOL")) {
		String[] arrOfStr23 = data.split("\\*");
		 Volume = (arrOfStr23[3]);
     
}
    
    
    if(data.contains("REF") &  data.contains("STB")) {
		String[] arrOfStr24 = data.split("\\*");
		 frieghtDesc = (arrOfStr24[2]);
     
}
}
myReader.close();
    }
catch (Exception e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	
            }
System.out.println("No of containers :"+cont_count);

String vesseldeparture_conv=mypack.dateConvertor.toconvertStringtoDate(vesselDeparture);
System.out.println("Container:"+CONTAINERID[2]);

String vesselArrival_conv=mypack.dateConvertor.toconvertStringtoDate(vesselArrival);

String myarray[]={masterShipmentRefNum,VESSELNAME,vesseldeparture_conv,vesselArrival_conv,CONTAINERID[1],Pieces,Unit,Volume,Weight[1],houseBillNumber,billOfLading,bookingNumber,CONREFNUM,CONSIGNEE,String.valueOf(cont_count)};

 //myArray[0] = {masterShipmentRefNum};
 //myArray[1]= {VESSELNAME};

return myarray;
}

public static String[] MyFunction2_noDTM(String fPathLocal) throws Exception {
File myObj = new File(fPathLocal);
Scanner myReader = new Scanner(myObj);
String masterShipmentRefNum=null;
String VESSELNAME = null;
String vesselArrival=null;
String vesselDeparture=null;
String railArrival=null;
String dropOff=null;
String Pieces=null;
String Unit=null;
String Volume=null;
String Weight=null;
String PONumber=null;
try{
while (myReader.hasNextLine()) {
  String data = myReader.nextLine();

  	if(data.contains("BSN")) {
  	String[] arrOfStr1 = data.split("\\*");
  	 masterShipmentRefNum = (arrOfStr1[2]);
  	}
  	if(data.contains("TD3")) {
  		String[] arrOfStr2 = data.split("\\*");
      	String CONTAINERID = (arrOfStr2[2]+arrOfStr2[3]);
      	Weight=arrOfStr2[5];
      	System.out.println(CONTAINERID);
           
    }
     if(data.contains("REF") &  data.contains("BM")) {
  	  String[] arrOfStr3 = data.split("\\*");
      	String billOfLading = (arrOfStr3[2]);
    }
    if(data.contains("REF") &  data.contains("BN")) {
  	  	String[] arrOfStr4 = data.split("\\*");
      	String bookingNumber = (arrOfStr4[2]);
    }
    if(data.contains("REF") &  data.contains("HB")) {
  	  String[] arrOfStr5 = data.split("\\*");
      	String houseBillNumber = (arrOfStr5[2]);
           
    }
    if(data.contains("PRF")) {
    	  String[] arrOfStr6 = data.split("\\*");
        	 PONumber = (arrOfStr6[1]);
      }

    if(data.contains("PRF")) {
  	  String[] arrOfStr6 = data.split("\\*");
      	//String masterShipmentRefNum = (arrOfStr6[2]);
    }

    if(data.contains("N1") &  data.contains("UC")) {
  	  			String[] arrOfStr7 = data.split("\\*");
  	  			String CONSIGNEE = (arrOfStr7[2]);
                 
           }
    if(data.contains("MEA") &  data.contains("SQ")) {
			String[] arrOfStr21 = data.split("\\*");
			 Pieces = (arrOfStr21[3]);
         
   }
    
    if(data.contains("MEA") &  data.contains("SQ")) {
		String[] arrOfStr22 = data.split("\\*");
		 Unit = (arrOfStr22[4]);
     
}
    
    if(data.contains("MEA") &  data.contains("VOL")) {
		String[] arrOfStr23 = data.split("\\*");
		 Volume = (arrOfStr23[3]);
     
}
           else if(data.contains("TD5") &  data.contains("S")) {
                 String[] arrOfStr8 = data.split("\\*");
                 String CARRIERCODE = (arrOfStr8[3]);
               
           }
           else if(data.contains("REF") &  data.contains("WU")) {
                 String[] arrOfStr9 = data.split("\\*");
                  VESSELNAME = (arrOfStr9[2]);
                 
           }
           else if(data.contains("REF") &  data.contains("V3")) {
                 String[] arrOfStr10 = data.split("\\*");
                 String VOYAGENUMBER = (arrOfStr10[2]);
              
           }
           else if(data.contains("REF") &  data.contains("CO")) {
                 String[] arrOfStr11 = data.split("\\*");
                 String CONREFNUM = (arrOfStr11[2]);
          
           }

           
           else if (data.contains("DTM") & data.contains("371")) {
        	   String[] arrOfStr13 = data.split("\\*");
                vesselArrival = (arrOfStr13[2]);
           }
    
           else if (data.contains("DTM") & data.contains("597")) {
        	   String[] arrOfStr14 = data.split("\\*");
                railArrival = (arrOfStr14[2]);
           }
           else if (data.contains("DTM") & data.contains("017")) {
        	   String[] arrOfStr15 = data.split("\\*");
                dropOff = (arrOfStr15[2]);
           }
}
myReader.close();
    }
catch (Exception e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	
            }
System.out.println("Vessel Departure from EDI :"+vesselDeparture);
String railArrival_conv=mypack.dateConvertor.toconvertStringtoDate(railArrival);
String vesselArrival_conv=mypack.dateConvertor.toconvertStringtoDate(vesselArrival);
String dropOff_conv=mypack.dateConvertor.toconvertStringtoDate(dropOff);
String myarray[]={masterShipmentRefNum,VESSELNAME,vesselArrival_conv,railArrival_conv,dropOff_conv,Pieces,Unit,Weight,Volume,PONumber};

 //myArray[0] = {masterShipmentRefNum};
 //myArray[1]= {VESSELNAME};

return myarray;
}
	
		  
public static String[] MyFunction_nocontainerEDI(String fPathLocal_nocont_4) throws Exception {
File myObj = new File(fPathLocal_nocont_4);
Scanner myReader = new Scanner(myObj);
String masterShipmentRefNum_nocont=null;
String vesselArrival_nocont=null;
String vesselDeparture_nocont=null;
String railArrival_nocont=null;
String dropOff_nocont=null;
String PONumber=null;
try{
while (myReader.hasNextLine()) {
  String data = myReader.nextLine();

  	if(data.contains("BSN")) {
  	String[] arrOfStr1 = data.split("\\*");
  	 masterShipmentRefNum_nocont = (arrOfStr1[2]);
  	}
           else if (data.contains("DTM") & data.contains("369")) {
        	   String[] arrOfStr12 = data.split("\\*");
                vesselDeparture_nocont = (arrOfStr12[2]);
           }
           else if (data.contains("DTM") & data.contains("371")) {
        	   String[] arrOfStr13 = data.split("\\*");
                vesselArrival_nocont = (arrOfStr13[2]);
           }
    
           else if (data.contains("DTM") & data.contains("597")) {
        	   String[] arrOfStr14 = data.split("\\*");
                railArrival_nocont = (arrOfStr14[2]);
           }
           else if (data.contains("DTM") & data.contains("017")) {
        	   String[] arrOfStr15 = data.split("\\*");
                dropOff_nocont = (arrOfStr15[2]);
           }
  	 if(data.contains("PRF")) {
   	  String[] arrOfStr6 = data.split("\\*");
       	 PONumber = (arrOfStr6[1]);
     }

}
myReader.close();
    }
catch (Exception e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	
            }

String vesseldeparture_nocont_conv=mypack.dateConvertor.toconvertStringtoDate(vesselDeparture_nocont);
String railArrival_nocont_conv=mypack.dateConvertor.toconvertStringtoDate(railArrival_nocont);
String vesselArrival_nocont_conv=mypack.dateConvertor.toconvertStringtoDate(vesselArrival_nocont);
String dropOff_nocont_conv=mypack.dateConvertor.toconvertStringtoDate(dropOff_nocont);
System.out.println(vesseldeparture_nocont_conv);
String myarray[]={masterShipmentRefNum_nocont,vesseldeparture_nocont_conv,railArrival_nocont_conv,vesselArrival_nocont_conv,dropOff_nocont_conv,PONumber};

 //myArray[0] = {masterShipmentRefNum};
 //myArray[1]= {VESSELNAME};

return myarray;
}

public static String[] MyFunction_containerEDI(String fPathLocal_cont_4) throws Exception {
File myObj = new File(fPathLocal_cont_4);
Scanner myReader = new Scanner(myObj);
String masterShipmentRefNum_cont=null;
String vesselArrival_cont=null;
String vesselDeparture_cont=null;
String railArrival_cont=null;
String dropOff_cont=null;
String[] CONTAINERID= {"one","Two","three"};
int container_count=0;
String[] arrOfStr2=null;
try{
while (myReader.hasNextLine()) {
  String data = myReader.nextLine();

  	if(data.contains("BSN")) {
  	String[] arrOfStr1 = data.split("\\*");
  	 masterShipmentRefNum_cont = (arrOfStr1[2]);
  	}
           else if (data.contains("DTM") & data.contains("369")) {
        	   String[] arrOfStr12 = data.split("\\*");
                vesselDeparture_cont = (arrOfStr12[2]);
           }
           else if (data.contains("DTM") & data.contains("371")) {
        	   String[] arrOfStr13 = data.split("\\*");
                vesselArrival_cont = (arrOfStr13[2]);
           }
    
           else if (data.contains("DTM") & data.contains("597")) {
        	   String[] arrOfStr14 = data.split("\\*");
                railArrival_cont = (arrOfStr14[2]);
           }
           else if (data.contains("DTM") & data.contains("017")) {
        	   String[] arrOfStr15 = data.split("\\*");
                dropOff_cont = (arrOfStr15[2]);
           }
	if(data.contains("TD3")) {
		container_count++;
  		for(int i=container_count;i>0;i--){
			arrOfStr2 = data.split("\\*");
	  		 CONTAINERID[i] = (arrOfStr2[2]+arrOfStr2[3]);
	     
	      	break;
		      
    }
  	 
	   }
}
myReader.close();
    }
catch (Exception e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	
            }

String vesseldeparture_cont_conv=mypack.dateConvertor.toconvertStringtoDate(vesselDeparture_cont);
String railArrival_cont_conv=mypack.dateConvertor.toconvertStringtoDate(railArrival_cont);
String vesselArrival_cont_conv=mypack.dateConvertor.toconvertStringtoDate(vesselArrival_cont);
String dropOff_cont_conv=mypack.dateConvertor.toconvertStringtoDate(dropOff_cont);
String myarray[]={masterShipmentRefNum_cont,vesseldeparture_cont_conv,railArrival_cont_conv,vesselArrival_cont_conv,dropOff_cont_conv,
		CONTAINERID[1],CONTAINERID[2]};

 //myArray[0] = {masterShipmentRefNum};
 //myArray[1]= {VESSELNAME};

return myarray;
}

public static String[] MyFunction_containerEDI_OceanDray(String fPathLocal_cont_4) throws Exception {
File myObj = new File(fPathLocal_cont_4);
Scanner myReader = new Scanner(myObj);
String masterShipmentRefNum_cont=null;
String vesselArrival_cont=null;
String vesselDeparture_cont=null;
String railArrival_cont=null;
String dropOff_cont=null;
String[] CONTAINERID= {"one","Two","three"};
int container_count=0;
String[] arrOfStr2=null;
try{
while (myReader.hasNextLine()) {
  String data = myReader.nextLine();

  	if(data.contains("BSN")) {
  	String[] arrOfStr1 = data.split("\\*");
  	 masterShipmentRefNum_cont = (arrOfStr1[2]);
  	}
           else if (data.contains("DTM") & data.contains("369")) {
        	   String[] arrOfStr12 = data.split("\\*");
                vesselDeparture_cont = (arrOfStr12[2]);
           }
           else if (data.contains("DTM") & data.contains("371")) {
        	   String[] arrOfStr13 = data.split("\\*");
                vesselArrival_cont = (arrOfStr13[2]);
           }
    
          
           else if (data.contains("DTM") & data.contains("017")) {
        	   String[] arrOfStr15 = data.split("\\*");
                dropOff_cont = (arrOfStr15[2]);
           }
	if(data.contains("TD3")) {
		container_count++;
  		for(int i=container_count;i>0;i--){
			arrOfStr2 = data.split("\\*");
	  		 CONTAINERID[i] = (arrOfStr2[2]+arrOfStr2[3]);
	     
	      	break;
		      
    }
  	 
	   }
}
myReader.close();
    }
catch (Exception e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	
            }

String vesseldeparture_cont_conv=mypack.dateConvertor.toconvertStringtoDate(vesselDeparture_cont);

String vesselArrival_cont_conv=mypack.dateConvertor.toconvertStringtoDate(vesselArrival_cont);
String dropOff_cont_conv=mypack.dateConvertor.toconvertStringtoDate(dropOff_cont);
String myarray[]={masterShipmentRefNum_cont,vesseldeparture_cont_conv,vesselArrival_cont_conv,dropOff_cont_conv,
		CONTAINERID[1],CONTAINERID[2]};

 //myArray[0] = {masterShipmentRefNum};
 //myArray[1]= {VESSELNAME};

return myarray;
}


}

	
		      

	



