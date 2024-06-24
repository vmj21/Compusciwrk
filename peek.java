package stackpack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.LinkedList;
public class peek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 File file = new File("C:\\CS210\\queue.txt");

        
      PriorityQueue<String> wordPriorityQueue = new PriorityQueue<>(wordComparator());

         try (BufferedReader reader = new BufferedReader(new FileReader("queue.txt"))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 if (line.startsWith("INSERT")) {
                     String word = line.substring(7); // Extract the word after "INSERT"
                     wordPriorityQueue.offer(word);
                 } else if (line.startsWith("REMOVE")) {
                     wordPriorityQueue.poll();
                 }
                 
                 // Perform 10 PEEK operations and print the results
                 for (int i = 0; i < 10; i++) {
                     if (!wordPriorityQueue.isEmpty()) {
                         System.out.println(wordPriorityQueue.peek());
                     }
                 }

             } }
             catch (IOException e) {
                 e.printStackTrace();
             }
				
	}
	
	private static Comparator<String> wordComparator() {
        return Comparator.comparingInt(peek::countVowels)
                .thenComparing(Comparator.naturalOrder());
    }

    private static int countVowels(String word) {
        int count = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    
}
