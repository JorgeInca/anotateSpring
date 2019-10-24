import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mx.grupoTama.core.dao.tools.GeneralUtilities;


public class Principal {
	
   public static void main(String[] args) throws ParseException {
	 
	   Date hoy = new Date();
	   hoy = GeneralUtilities.removeTime(hoy);

	   System.out.println(hoy);
	   
	   //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd")  ;
	   DateFormat dateFormat = new SimpleDateFormat("MMMM dd,yyyy");
	   String strDate = dateFormat.format(hoy);  
	   
	   System.out.println(strDate);

	   
	   
	   
   }
   
} 