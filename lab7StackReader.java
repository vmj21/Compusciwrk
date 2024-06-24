package stackpack;
import java.util.Scanner;
import java.io.File;
public class lab7StackReader {
	
	
	
	



	

	    public static void main(String[] args) {

	        File file = new File("C:\\CS210\\stack.txt");



	        MyStack myStack = new MyStack(1000);

	        //int inputSize = 1000;

	        //String[] input = new String[inputSize];

	        try {

	            Scanner scan = new Scanner(file);

	            

	            while(scan.hasNextLine())

	            {

	                String command = scan.nextLine();

	                process(myStack,command);

	            }

	            myStack.output(); // prints what elements are left in the stack

	            

	            //for(int i = 0; i < inputSize; i++) {

	                //input[i] = scan.nextLine();

	                //String command = input[i];

	            //}

	            scan.close();

	        } catch (Exception e) {

	            System.err.println(e);

	        }



	    }





	    private static void process(MyStack myStack, String command)

	    {

	        String[] parts = command.split("\\s+"); //splits the commands and the elements

	        String operation = parts[0];



	        switch(operation)

	        {

	            case "PUSH" : // checks the operation

	            if(parts.length == 2)

	            {

	                myStack.push(parts[1]);

	            }

	            //myStack.push(parts[1]);

	            break;

	        

	            case "POP" :

	            myStack.pop();

	            break;



	            default:

	            System.out.println("Invalid command " + command);

	        }

	    }

	}


