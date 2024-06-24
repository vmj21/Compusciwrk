package CS210;

import java.util.Random;
public class dice {
	
	public static void main(String[]args)
	{
		
		int N =1000000; // Number of discrete steps in simulation
		double estimatedE = estiE(N); // call the estieE method to estimate e 
		double absoluteError = Math.abs(estimatedE - 2.71828); // This estimates the absolute error
		
		System.out.println("Estimated E: " + estimatedE); // prints out the estimated E
		System.out.println("Absolute error: " + absoluteError);// prints out the Absolute error
		
	}
	
	public static double estiE(int N) // estieE method
	{
		Random rm = new Random(); // random number generator
		int countin = 0;  // start a counter for points in the range of 0-1.
		
		for(int i =0; i<N; i++) // loop repeats for N times ***i<=N*******
		{
			double x = rm.nextDouble(); // generates a random number between 0and1
			if(x<=1) { // if number is less or equal to 1 it increments the count
				countin++;
			}
		}
		return(double) N/countin; // calculate and return the estimated value of 'e';
 	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
