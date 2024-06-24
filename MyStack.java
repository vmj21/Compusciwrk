package stackpack;
//import java.util.Scanner;


	
	public class MyStack

	{

	    private int maxSize; // size of array

	    private String[] stackArray;

	    private int top; // top of stack





	    public MyStack(int s) // constructer

	    {

	        maxSize = s; // set array size

	        stackArray = new String[maxSize]; // creates array

	        top = -1; // empty

	    }



	    public void push(String value) // method to push value into the stack

	    {

	        if (top < maxSize - 1)

	        {

	            stackArray[++top] = value;

	            System.out.println("Pushed:  "+ value );

	        }

	        else{

	            System.out.println("Stack is full");

	        }

	    }



	    public void pop() // method to pop top element out

	    {

	        if(top >= 0)

	        {

	            String popVal = stackArray[top--];

	            System.out.println("Popped:  " + popVal);

	        }

	        else{

	            System.out.println("Stack is empty");

	        }

	    

	    }



	    public void output() // prints out current elements in the stack

	    {

	        if(top >=0)

	        {

	            System.out.print("Stack elements: ");

	            for(int i = 0; i <= top; i++)

	            {

	                System.out.print(stackArray[i] + " ");

	            }

	            System.out.println();



	        }

	        else{

	            System.out.println("Stack is empty!!");

	        }

	    }

	}






