package CS210;
import java.util.*;
public class Queuectd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //PRIORITY QUEUE = A FIFO data structure that serves 
                          // with the highest priorities first 
		                  // before elements with a lower priority
		
		
		    String queue[] = new String [1000];
		    int size;
		    int front;
		    int rear;

		    public void inQueue (String data)
		    {
		        queue[rear] = data;
		        rear = (rear +1)%1000;
		        size = size+1;
		    }

		    public void show()
		    {
		        System.out.println("Elements  :");
		        for(int i=0; i<size; i++)
		        {
		            System.out.println(queue[(front + i)%1000] +" ");
		        }

		    }

		    public String outQuene()
		    {
		        String data = queue[front];
		        front = (front+1)%1000;
		        size=size-1;

		        return data;
		    }

		    public String peak()
		    {
		        String data = queue[front];
		        return data;
		    }

		
		
}
}
