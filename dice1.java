package CS210;
import java.util.Random;
public class dice1 {
	
	
	



	    public static void main(String[] args) {
	        int N = 10000; // Number of steps
	        double estimatedE = estiE(N); // Call the estiE method to estimate e
	        double absoluteError = Math.abs(estimatedE - 2.71828); // Estimate the absolute error

	        System.out.println("Estimated E: " + estimatedE); // Print the estimated E
	        System.out.println("Absolute error: " + absoluteError); // Print the absolute error
	    }

	    public static double estiE(int N) {
	        Random rm = new Random();  // generate a random numbers
	        double sum = 0.0; // used to get the sum of exponential variables

	        for (int i = 0; i < N; i++) {
	            double d = -Math.log(1 - rm.nextDouble()); // Generate random exponential random variables
	            sum += d;
	        }

	        return sum / N; // Calculate and return the estimated value of 'e'
	    }
	}







