import java.text.ParseException;
import java.util.Random;


public class Principal {
	
   public static void main(String[] args) throws ParseException {
	   Perro perritoRex1 = new Perro();
	   Random rand = new Random();
	   
	   int n = rand.nextInt(3);
	   
	   if( n == 3)
		   perritoRex1.dormir();
	   if( n == 2)
		   perritoRex1.comer();
	   if( n == 1)
		   	perritoRex1.morder();
	   
   }
   
} 