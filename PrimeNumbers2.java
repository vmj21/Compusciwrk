package CS210;
import java.util.Scanner;
public class PrimeNumbers2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc = new Scanner(System.in);

		    System.out.println("Enter start of the range.");
		    int num = sc.nextInt();
		    System.out.println("Enter end of the range.");
		    int num1 = sc.nextInt();

		    int cprime =0;
		                

		    System.out.println("Prime number in range ["+num+", "+num1+"] ");

		    for (int i = num; i<=num1; i++)
		    {
		    	
		    	if(i==1)
		    	{
		    		
		    	}

		        if(i%2==0||i%3==0||i%5==0)
		        {
		                    
		        }

		        else if(i==2|| i==5||i==3 || i==7)
		        {
		    		
		            cprime++;
		        }

		          else
		        {
		           cprime++;
		       }
		        
				
		    }
		    System.out.println("Number of Prime numbers are: "+cprime);
		   
		
		
		
	}

}
