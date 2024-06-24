package CS210;

import java.util.Scanner;

public class PrimeNumbersno2 {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the start of the range.");
		  int start=sc.nextInt();
		  int finsh=sc.nextInt();
		  int co=0;
		  int y =0;
		 
		  
		 if(start>finsh)
		 {
			 y=finsh;
			 finsh=start;
			 start=y;
			 
             
		 }
		  for(int i=start;i<=finsh; i++)
		  {
			  if(i<=1)
			  {
				  continue;
			  }
			  
			  boolean prime=true;
			  
			  for(int j=2; j<=i/2; j++) // from j = 2  . continues if j is less than half of i then j is incremneted 
			  {
				  if(i%j==0) {//  if i divided by j is 0 then it is not a prime number
					  prime=false; 
					  break; // to break the sequence and start again
				  }
			  }
			  
			  if(prime)
			  {
			     co++;
			  }
		  }
		  
		  System.out.println(co);
	}
}
	         
	        
		
		




