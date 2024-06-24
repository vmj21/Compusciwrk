package CS210;
import java.util.Scanner;
public class Scrabblesscore {

	
	
	
	public static void main(String[] args) 
    {
        int total=0;
        Scanner sc = new Scanner(System.in);
        int wordNo =sc.nextInt();

        String [] words = new String [wordNo];
        int [] postiton = new int [wordNo]; // total score of word 

        for(int i=0; i<words.length; i++)
        {
            words[i] =sc.next().toLowerCase();


            for(int j =0; j<words[i].length(); j++)
            {
                if (words[i].charAt(j)=='a'||words[i].charAt(j)=='e'||words[i].charAt(j)=='i'||words[i].charAt(j)=='o'||words[i].charAt(j)=='u'||words[i].charAt(j)=='l'||words[i].charAt(j)=='n'||words[i].charAt(j)=='s'||words[i].charAt(j)=='t'||words[i].charAt(j)=='r') 
                {
                    total=total+1;
                }
                else if (words[i].charAt(j)=='d'||words[i].charAt(j)=='g') 
                {
                    total=total+2;
                }
                else if (words[i].charAt(j)=='b'||words[i].charAt(j)=='c'||words[i].charAt(j)=='m'||words[i].charAt(j)=='p') 
                {
                    total=total+3;
                }
                else if (words[i].charAt(j)=='f'||words[i].charAt(j)=='h'||words[i].charAt(j)=='v'||words[i].charAt(j)=='w'||words[i].charAt(j)=='y') 
                {
                    total=total+4;
                }
                else if (words[i].charAt(j)=='k') 
                {
                    total=total+5;
                }
                else if (words[i].charAt(j)=='j'||words[i].charAt(j)=='x') 
                {
                    total=total+8;
                }
                else if(words[i].charAt(j)=='q'||words[i].charAt(j)=='z')
                {
                    total=total+10;
                }
            }
            postiton[i]=total; // adds total score of word to score 
            total=0; // resets to 0 for next word 
        }

        sort(postiton, words); // sorts words based on scores

        



    }

    public static void sort (int [] arrayName, String [] realarray) // checks scores of words
    {
        int temp;
        String temp2;

        for (int i = 0; i < arrayName.length-1; i++)
        {
            if(arrayName[i] > arrayName[i+1]) //Checks if the word is greater than the next word
          //  If true, it means that the elements are out of order, and a swap is needed.
            {
                temp=arrayName[i];
                temp2 = realarray[i];

                arrayName[i]=arrayName[i+1]; // put arrayname[i] in the next position
                realarray[i] = realarray[i+1];

                arrayName[i+1]=temp; //and [i=1] in the temp value.
                realarray[i+1]=temp2;
                i=-1; // This effectively restarts the loop from the beginning.
            }
        }

        int n =0;
        String temp3;


        for(int k=0; k<realarray.length; k++)
        {
            if (realarray[k] == realarray[k]) 
            {
                for (int j = 0; j < realarray.length; j++) 
                {
                    for (int i = j + 1; i < realarray.length; i++) 
                    {
                  // comparing adjacent strings
                        if (realarray[i].compareTo(realarray[j]) < 0) 
                        {
                            temp3 = realarray[j];
                            realarray[j] = realarray[i];
                            realarray[i] = temp3;
                        }
                    }
                }
                System.out.println(realarray[k]);
                System.out.println(arrayName[k]);
            }
            else
            {
                System.out.println(realarray[k]);
                System.out.println(arrayName[k]);
            }
            
        }

    }
}
