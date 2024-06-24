package CS210;
import java.util.Random;
public class dicepart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		int N = 1000000; // number of random points to generate
		double estimatedPi = ePi(N); // calls the method below to estimate N
		System.out.println("Estimated N (PI): " + estimatedPi); // Prints the estimated value of N
		}
	
	public static double ePi(int N) // ePI method
	{
		Random rm = new Random(); // creates random number
		int countin = 0; // counter for points inside circle
		
		for(int i =0; i<N; i++) // repeats the following N times
		{
			double x = rm.nextDouble(); //generates a random number between 0 and 1 for x 
			double y = rm.nextDouble(); //'' '' '' '' '' ''  y
			if(x*x + y*y<=1)// if equation is <=(inside the unit circle)
			{
				countin++;// increment count
			}
		}
		return 4.0* countin/N; // calculate and return the estimated value of N
		
	}

}
