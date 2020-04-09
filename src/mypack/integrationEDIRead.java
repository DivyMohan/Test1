package mypack;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import mypack.EDIRead;
import mypack.visibility_Automation;
import mypack.Report;
import mypack.ftp;
public class integrationEDIRead {

	public static void main(String[] args) throws Exception {
		String currentDir = System.getProperty("user.dir");
		/*// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
	
		String projectPath = System.getProperty("user.dir");
		String dataFile = projectPath + "\\DataFiles\\2-CreateShip.txt";
		String dataFile1 = projectPath + "\\DataFiles\\1-Replace.txt";
		String eventFile = projectPath + "\\DataFiles\\3-Event.txt";
		String AGeventFile = projectPath + "\\DataFiles\\4-AgEvent.txt";
		
		String dropFIleName = "OLUSACreateShipment" + dateFormat.format(date) + ".txt";
		String edittedDataFile = projectPath + "\\data\\HL\\Output Files\\" + dropFIleName;
		
		String updateFIleName = "HLupdateWorkOrder_" + dateFormat.format(date) + ".txt";
		String updatedDataFile = projectPath + "\\data\\HL\\Output Files\\" + updateFIleName;
		
		String cancelFIleName = "HLcancelWorkOrder_" + dateFormat.format(date) + ".txt";
		String canceledDataFile = projectPath + "\\data\\HL\\Output Files\\" + cancelFIleName;
		
		String recreateFIleName = "HLRecreateWorkOrder_" + dateFormat.format(date) + ".txt";
		String recreatedDataFile = projectPath + "\\data\\HL\\Output Files\\" + recreateFIleName;
		
		try {
			
		workorderNumber = "WO" + dateFormat.format(date) + "-01";
		shipmentNumber="Ship" + dateFormat.format(date) + "-01";
		
		File file = new File(dataFile);
		
		Scanner sc = new Scanner(file);
		
		// Change WO number while fetching data
		int i=0;
		String[] lineSplit=new String[104];
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String [] temp = line.split("~");
			lineSplit[i]=temp[0];
			//System.out.println(lineSplit[i]);
			i++;
		}
		lineSplit[8]="L11*"+workorderNumber+"*WO";
		lineSplit[12]="L11*"+shipmentNumber+"*BN";
		//for(int j=0;j<lineSplit.length;j++) {
		//	System.out.println(lineSplit[j]);
		//}
		FileWriter fw = new FileWriter(edittedDataFile);
		BufferedWriter out = new BufferedWriter(fw);
		for (int k = 1; k <= lineSplit.length; k++) {
			out.write(lineSplit[k - 1]);
			if (k < lineSplit.length) {
				out.write("~");
				out.newLine();
			}
		}
		
		out.flush();*/
		
		String fPath = currentDir+"\\Scenario1\\2-CreateShip.edi";
		String eventtypePath=currentDir+"\\Scenario1\\1-Event.edi";
		String eventtypePath_Update=currentDir+"\\Scenario1\\3-Event.edi";
		String AGEVent=currentDir+"\\Scenario1\\4-AgEvent.edi";
		mypack.ftp.main(args);
		Thread.sleep(300000);
		System.out.println("Executing Scenario1");
		mypack.visibility_Automation.Scenario1(fPath,eventtypePath,eventtypePath_Update,AGEVent);

		String eventtypePath_2=currentDir+"\\Scenario2\\2-Event.edi";
		String fPath_2 = currentDir+"\\Scenario2\\1-Replace.edi";
		String AGEVent_2=currentDir+"\\Scenario2\\3-AgEvent.edi";
		System.out.println("Executing Scenario 2");
		mypack.visibility_Automation.Scenario2(fPath_2,eventtypePath_2,AGEVent_2);
		
		String eventtypePath_3=currentDir+"\\Scenario3\\2-Event.edi";
		String fPath_3 = currentDir+"\\Scenario3\\1-CreateShip.edi";
		System.out.println("Executing Scenario 3");
		mypack.visibility_Automation.Scenario3(fPath_3,eventtypePath_3);
		
		
		String fPath_4 =currentDir+"\\Scenario4\\1-CreateNoContainer.edi";
		String eventtypePath_4 = currentDir+"\\Scenario4\\2-Event.edi";
		String fPath_Container_4 = currentDir+"\\Scenario4\\2-ReplaceContainer.edi";
		System.out.println("Executing Scenario 4");
		mypack.visibility_Automation.Scenario4(fPath_4,fPath_Container_4,eventtypePath_4);
		
		
		String fPath_5 =currentDir+"\\Scenario5\\1-CreateShip.edi";
		String fPath_Cancel_5 = currentDir+"\\Scenario5\\2-DeleteShip.edi";
		System.out.println("Executing Scenario 5");
		mypack.visibility_Automation.Scenario5(fPath_5,fPath_Cancel_5);
		
		String eventtypePath_6=currentDir+"\\Scenario6\\3-Event.edi";
		String fPath_6 = currentDir+"\\Scenario6\\1-CreateShip.edi";
		String fPath_6_Replace = currentDir+"\\Scenario6\\4-Replace.edi";
		String AGEVent_6=currentDir+"\\Scenario6\\2-AgEvent.edi";
		System.out.println("Executing Scenario 6");
		mypack.visibility_Automation.Scenario6(fPath_6,eventtypePath_6,AGEVent_6,fPath_6_Replace);
		
		
	
		String fPath_7_noDTM = currentDir+"\\Scenario7\\1-no369.edi";
		String fPath_7_DTM = currentDir+"\\Scenario7\\2-Replace.edi";
		String fPath_7_ReplacedDTM= currentDir+"\\Scenario7\\3-Replace.edi";
		String AGEVent_7Greater=currentDir+"\\Scenario7\\4-AgEvent.edi";
		String AGEVent_7Less=currentDir+"\\Scenario7\\5-AgEvent.edi";
		System.out.println("Executing Scenario 7");
		mypack.visibility_Automation.Scenario7(fPath_7_noDTM,fPath_7_DTM,fPath_7_ReplacedDTM,AGEVent_7Greater,AGEVent_7Less);
		
		
		String fPath_8_noDTM = currentDir+"\\Scenario8\\2-no369.edi";
		String fPath_8_ReplacedDTM= currentDir+"\\Scenario8\\3-Replace.edi";
		String AGEVent_8=currentDir+"\\Scenario8\\2.AG.edi";
		System.out.println("Executing Scenario 8");
		mypack.visibility_Automation.Scenario8(fPath_8_noDTM,fPath_8_ReplacedDTM,AGEVent_8);
		
		
		
		String fPath_9_noDTM = currentDir+"\\Scenario9\\2-no369.edi";
		String fPath_9_ReplacedDTM= currentDir+"\\Scenario9\\3-Replace.edi";
		String AGEVent_9=currentDir+"\\Scenario9\\1-AgEvent.edi";
		System.out.println("Executing Scenario 9");
		mypack.visibility_Automation.Scenario9(fPath_9_noDTM,fPath_9_ReplacedDTM,AGEVent_9);
		
		
		/*String fPath_10 = currentDir+"\\Scenario10\\1-CreateShip.edi";
		String fPath_10_Replaced1= currentDir+"\\Scenario10\\4-Replace.edi";
		String AGEVent_10=currentDir+"\\Scenario10\\2-AgEvent.edi";
		String eventtypePath_10=currentDir+"\\Scenario10\\3-Event.edi";
		System.out.println("Executing Scenario 10");
		mypack.visibility_Automation.Scenario10(fPath_10,AGEVent_10,eventtypePath_10,fPath_10_Replaced1);
		
		
		String fPath_11 = currentDir+"\\Scenario11\\Scenario11-856.edi";
		String eventtypePath_11=currentDir+"\\Scenario11\\Scenario11-315.edi";
		System.out.println("Executing Scenario 11");
		mypack.visibility_Automation.Scenario11(fPath_11,eventtypePath_11);
		
		
		String fPath_12 =currentDir+"\\Scenario12\\2-ReplaceContainer.edi";
		String fPath_noContainer_12 = currentDir+"\\Scenario12\\1-CreateNoContainer.edi";
		System.out.println("Executing Scenario 12");
		mypack.visibility_Automation.Scenario12(fPath_noContainer_12,fPath_12);
		
		
		
		String fPath_13 = currentDir+"\\Scenario13\\EDI856_2802_1.EDI";
		String fPath_13Replaced=currentDir+"\\Scenario13\\EDI856_2802_2.EDI";
		System.out.println("Executing Scenario 13");
		mypack.visibility_Automation.Scenario13(fPath_13,fPath_13Replaced);
		
		String fPath_14 = currentDir+"\\Scenario14\\EDI856_2802_1.edi";
		String fPath_14Replaced1=currentDir+"\\Scenario14\\EDI856_2802_2.edi";
		String fPath_14Replaced2=currentDir+"\\Scenario14\\EDI856_2802_3.edi";
		System.out.println("Executing Scenario 14");
		mypack.visibility_Automation.Scenario14(fPath_14,fPath_14Replaced1,fPath_14Replaced2);
		
		
		String fPath_15 = currentDir+"\\Scenario15\\EDI856_2802_1.edi";
		String eventtypePath_15=currentDir+"\\Scenario15\\ONE_315_KWE_TestingNewone_2.edi";
		String fPath_15Replaced1=currentDir+"\\Scenario15\\EDI856_2802_3.edi";
		String eventtypePath_15_1=currentDir+"\\Scenario15\\ONE_315_KWE_TestingNewone_4.edi";
		String fPath_15Replaced2=currentDir+"\\Scenario15\\EDI856_2802_5.edi";
		System.out.println("Executing Scenario 15");
		mypack.visibility_Automation.Scenario15(fPath_15,eventtypePath_15,fPath_15Replaced1,eventtypePath_15_1,fPath_15Replaced2);

		
		String fPath_16 = currentDir+"\\Scenario16\\EDI856_2802_1.edi";
		String fPath_16Replaced1=currentDir+"\\Scenario16\\EDI856_2802_2.edi";
		String fPath_16Replaced2=currentDir+"\\Scenario16\\EDI856_2802_3.edi";
		System.out.println("Executing Scenario 16");
		mypack.visibility_Automation.Scenario16(fPath_16,fPath_16Replaced1,fPath_16Replaced2);
		
		
		String fPath_17 = currentDir+"\\Scenario17\\EDI856_without Container ID_1.EDI";
		String eventtypePath_17=currentDir+"\\Scenario17\\EVENT_2.EDI";
		String fPath_17Replaced1=currentDir+"\\Scenario17\\EDI856_without Container ID_2.EDI";
		String fPath_17Replaced2=currentDir+"\\Scenario17\\EDI856_without Container ID_3.EDI";
		String fPath_17Replaced3=currentDir+"\\Scenario17\\EDI856_without Container ID_4.EDI";
		System.out.println("Executing Scenario 17");
		mypack.visibility_Automation.Scenario17(fPath_17,fPath_17Replaced1,fPath_17Replaced2,fPath_17Replaced3,eventtypePath_17);

		
		String fPath_18 = currentDir+"\\Scenario18\\EDI856_1.EDI";
		String fPath_18Replaced1=currentDir+"\\Scenario18\\EDI856_2.EDI";
		String fPath_18Replaced2=currentDir+"\\Scenario18\\EDI856_3.EDI";
		System.out.println("Executing Scenario 18");
		mypack.visibility_Automation.Scenario18(fPath_18,fPath_18Replaced1,fPath_18Replaced2);
		
		
		String fPath_19 = currentDir+"\\Scenario19\\EDI856_2802_1.EDI";
		String eventtypePath_19=currentDir+"\\Scenario19\\EVENT_2.EDI";
		System.out.println("Executing Scenario 19");
		mypack.visibility_Automation.Scenario19(fPath_19,eventtypePath_19);
		

		String fPath_20Create1 = currentDir+"\\Scenario20\\EDI856_1.EDI";
		String fPath_20Replaced1=currentDir+"\\Scenario20\\EDI856_2.EDI";
		String fPath_20Create2 = currentDir+"\\Scenario20\\EDI856_3.EDI";
		String fPath_20Replaced2=currentDir+"\\Scenario20\\EDI856_4.EDI";
		String fPath_20Create3 = currentDir+"\\Scenario20\\EDI856_5.EDI";
		String fPath_20Replaced3=currentDir+"\\Scenario20\\EDI856_6.EDI";
		String fPath_20Create4 = currentDir+"\\Scenario20\\EDI856_7.EDI";
		String fPath_20Replaced4=currentDir+"\\Scenario20\\EDI856_8.EDI";
		System.out.println("Executing Scenario 20");
		mypack.visibility_Automation.Scenario20(fPath_20Create1,fPath_20Replaced1,fPath_20Create2,fPath_20Replaced2,fPath_20Create3,fPath_20Replaced3,fPath_20Create4,fPath_20Replaced4);
		
		
		String fPath_21 =currentDir+"\\Scenario21\\EDI856_1.EDI";
		mypack.visibility_Automation.Scenario21(fPath_21);*/
		
	
		
}
}


