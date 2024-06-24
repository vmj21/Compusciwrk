package CS210;
import java.util.Scanner;
public class CS210LAB5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
    
     
      int base1 = sc.nextInt(); // base 1

      
     
      int base2 = sc.nextInt(); // base 2. this is what we want the base1 to be converted to 

     
      String valueN = sc.next(); // the value of number N

      // Step 2: Convert to Decimal
      long decimalN = convertToDecimal(valueN, base1);  
       //In simpler terms, this line is calculating the decimal equivalent of a number (valueN)
      //that is currently represented in a particular base (base1)
      //and storing that decimal value in the variable decimalN.
     
      
      String result = convertToBase(decimalN, base2);
    //  In simpler terms, this line is taking the decimal value obtained earlier (decimalN) and
      //converting it to its representation in another base (base2)
      // storing the result as a string in the variable result. 
      //The final result is the representation of the number in the desired target base.

      
    // boolean isNegative = valueN.startsWith("-");
     // if(isNegative)
     // {
     // valueN = valueN.substring(1);
     // }
      
    // if(isNegative)
     // {
    //	  decimalN = -decimalN;
     // }
      
      
      
      
      
      
      
      // Step 4: Print Result
      System.out.println("Result:" + result);

 
     
  }

  // Function to convert N from base#1 to decimal
  private static long convertToDecimal(String valueN, int base1) {
      // Initialize result to 0
      long result = 0;

      
      boolean isNegative = valueN.startsWith("-");
     if(isNegative)
      {
     valueN = valueN.substring(1);
    }
            
      
      // Iterate through each digit in reverse order
      for (int i = valueN.length() -1 , power = 0; i >= 0; i--,power++)   { 
          char digit = valueN.charAt(i); // gets specific digit in (i);

          // Using a ternary operator to convert alphabetic characters to their numeric values
          int numericValue = Character.isDigit(digit) ? Character.getNumericValue(digit) : digit - 'a' + 10;   // converts it to its numeric value by subtracting the ASCII value of 'a' and adding 10.

          // Update the result using the given base
         result += numericValue * Math.pow(base1, power); // equation to get the decimal form of number N
          result = result * base1 + numericValue;
         return isNegative ? -result:result;
      }

      return result;
  }

  // Function to convert decimal value to base#2
  private static String convertToBase(long decimal, int base2) {
      //Check if the value is 0
      if (decimal == 0) {
          return "0";
      }

      // Initialize result to an empty string
      StringBuilder result = new StringBuilder();
      
      
      boolean isNegative = decimal<0;
      if(isNegative)
      {
    	  decimal =-decimal;
      }
      //if(isNegative)

      // Convert decimal to the target base 
      while (decimal != 0) {
          // Get the remainder when divided by the base2
        long remainder =  decimal % base2;

          // Convert remainder to the appropriate character
          char digit = (remainder < 10) ? (char) ('0' + remainder) : (char) ('a' + remainder - 10);
            // if less than 10, this adds the ASCII value of '0' to remainder to gives the character representation of the digit.
          // Adds the digit to the result
          result.insert(0,digit); // builds digit in reverse order

          // Update decimal to the quotient for the next iteration of loop
          decimal /= base2;
          
          if(isNegative)
          {
        	  result.insert(0,'-');
          }
      }

      return result.toString(); 
  }
}




