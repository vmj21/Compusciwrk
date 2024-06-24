package CS210;

import java.util.Collections;
import java.util.PriorityQueue;

import queuepack.Queue;

public class StringProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		queue.offer("B");
	    queue.offer("C");
	    queue.offer("A");
		queue.offer("F");
		queue.offer("D");
		
			while(!queue.isEmpty())
			{
				System.out.println(queue.poll());
			}
			
			
			
		}
//		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			
			// queue = FIFO  data structure. First -in, First-out
			  // A collection designed for holding elements prior to processing
			// to add = enqueue, offer() 
			// to remove = dequeue, poll()
			
			
	        //  Scanner sc = new Scanner(System.in);
	        //  Queue<String> queue = new LinkedList<String>();
	          
	        //  queue.offer("Karen");
	       //   queue.offer("Chad");
	       //   queue.offer("Steve");
	        //  queue.offer("Harold");
	        //  System.out.println(queue);
	          
	      //   queue.poll();
	        // queue.poll();
	        // System.out.println(queue);
	         // System.out.println(queue.peek());
	        //  System.out.println(queue.isEmpty());
	          //System.out.println(queue.size());
	         //System.out.println(queue.contains("Harold"));
			
		
		
		
		
		
		
		
		
		
	}

}
