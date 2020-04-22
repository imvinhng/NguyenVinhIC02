/*
 * File header comment block goes below here:
 * ==========================================
 * CS211, Spring 2020, 4/22
 * Vinh T. Nguyen
 * In-Class Exercise 02
 * PRogram is intened to scan through the mobydick.txt file, and print out any unique words
 * that appears more than 2000 times
 * The second part allows user to find a word of their choice in mobydick.txt, and finds out how many times that word has been repeated.
 */

import java.util.*;
import java.io.*;
   public class WordCountStart{  
      public static void main(String[] args) throws FileNotFoundException {
         Scanner input = new Scanner(new File("mobydick.txt"));
         input.useDelimiter("[^a-zA-Z']+");
         count(input);
      }
/*
 * Create code to surround the snippet below with what's needed to make it a 
 * method that accepts a Scanner object. At a minimum, there needs to be a method
 * signature line that defines its input parameter as a Scanner, and returns a 
 * Map<String, Integer> to the caller
 */
 
   public static void count(Scanner input) {
    // read file into a map of [word --> number of occurrences]
    Map<String, Integer> wordCount = new TreeMap<String, Integer>();
    Map<String, Integer> exclusiveCount = new TreeMap<String, Integer>();
    while (input.hasNext()) {
        String word = input.next();
        if (wordCount.containsKey(word)) {
            // seen this word before; increase count by 1
            int count = wordCount.get(word);
            wordCount.put(word, count + 1);
               if (count > 2000){
                  exclusiveCount.put(word,count);
               }
        } else {
            // never seen this word before
            wordCount.put(word, 1);
        }
    }
    //don't forget your return statement
    System.out.println(exclusiveCount);
    
    search(wordCount);
   }
    
/* 
 * User interaction snippet is below; it needs to be turned into a method also.
 * Be sure to provide this method with access to the data structure, and don't 
 * limit the user to a single query. Be sure to tell the user how to exit the 
 * program in your prompt
 */
   public static void search(Map wordCount){
    Scanner console = new Scanner(System.in);
    for(;;){
    System.out.print("Word to search for? (Enter 'STOP' to stop) "); //prompt the user for input
    String word = console.next();
    if (word.equals("STOP")){ //type STOP to end program
     break;
    }
      else {
            System.out.println("appears " + wordCount.get(word) + " times.");
    }
    }
  } 
}