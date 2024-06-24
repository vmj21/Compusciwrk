package CS210;

import java.util.Scanner;

public class cs210labb5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input base
        int base1 = scanner.nextInt();
        if(base1 < 2 || base1 > 32)
        {
        	System.out.println("Invalid base for Input Base");
        }
        
        // Output base
        int base2 = scanner.nextInt();
        if(base2 < 2 || base2 > 32)
        {
        	System.out.println("Invalid base for Output Base");
        }
       
        

        // Number in the specified base
        long n = scanner.nextLong();
        long t = Math.abs(n);
        String number = Long.toString(t);
        

        // Convert to decimal (base 10)
        int decimalNumber = convertToDecimal(number, base1);

        // Convert decimal to the desired base
        String result = convertFromDecimal(decimalNumber, base2);

        // Output the result
        System.out.println(result);

        scanner.close();
    }

   private static int convertToDecimal(String number, int base) {
        int decimalNumber = 0;
        int power = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            char digit = number.charAt(i);
            int digitValue = Character.isDigit(digit) ? (digit - '0') : (digit - 'a' + 10);
            decimalNumber += digitValue * Math.pow(base, power);
            power++;
        }

        return decimalNumber;
    }

    // Function to convert a decimal (base 10) number to any other base
    private static String convertFromDecimal(int decimalNumber, int base) {
        StringBuilder result = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            char digit = (char) (remainder < 10 ? (remainder + '0') : (remainder - 10 + 'a'));
            result.insert(0, digit);
            decimalNumber /= base;
        }

        return result.toString();
    }
}


