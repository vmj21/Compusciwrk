package CS210;
import java.util.Scanner;
public class CSLABWEEK5NO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new Scanner(System.in);
        
     
       int b1 = sc.nextInt();
       int b2 = sc.nextInt();
       String number = sc.next();
       
       int decimalNumber = Integer.parseInt(number,b1);
       
       String result = Integer.toString(decimalNumber,b2);
       
       System.out.println(result);
       
	}
}