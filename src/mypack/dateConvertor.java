package mypack;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateConvertor {

	public static String toconvertStringtoDate(String strDate) throws Exception {
		 String ddate = null;
		 try {
		 
		//input date format
		 SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd");
		 
		//output date format
		 SimpleDateFormat dFormatFinal = new SimpleDateFormat("dd-MMM-yyyy");
		 Date date = dFormat.parse(strDate);
		 ddate = dFormatFinal.format(date);
		 } catch (Exception e) {
		 throw new Exception("Invalid Date!!!!", e);
		 }
		 return ddate;
		 }

}
