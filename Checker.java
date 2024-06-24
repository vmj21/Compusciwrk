package CS210;
import java.util.Scanner;
public class Checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter A Number:");
        String num = sc.nextLine();
        int length = String.valueOf(num).length();  
        
        //   Calculate the length of string num and store it in the variable length.

        int Total = 0; // Used to add up every second digit from the last digit.
        

        for (int i = length; i>0; i=i-2) // for loop to get 
        {
          Total += Integer.valueOf(num.substring(i-1,i));  
       
        }  
      //  So, this code is used to calculate the sum of the digits at even positions in the input string number. 
                                                                                                                                                    // The for loop decrements by 2 to even number positions and then extracts the character and turn it to a number and goes again 

       int num1= 0;
       int num2 =0;  
       int Total1=0;

        for (int l = length-1; l>0; l=l-2)  // number from the second last digit 
        {

            num1= Integer.valueOf(num.substring(l-1,l))*2;  
            // This finds the character at position l-1(odd) and 
            //  multiplies it by 2 and stores it in num1
           

            if(num1>=9)
            {
                num1=num1-9;
                num2 =+ num1;
               
            }
                
            else
            {
               num2 =+ num1;
             
            }

           Total1= Total1+num2;

        }

        //System.out.print(Total2+Total);
        if((Total1+Total)%10==0)
        {
             System.out.print("VALID");
        }
        
        else
        {
            System.out.print("INVALID");
        }
        
	}
}
