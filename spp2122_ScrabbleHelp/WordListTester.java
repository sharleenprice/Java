//
//Created by spp2122
//This code tests out methods from wordList
//and catches exceptions
import java.io.*;
import java.util.*;
public class WordListTester
{

	public static void main(String[] args) 
	{
try
{   
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter File name");
	String nameFile = scan.nextLine(); //allows user to input file name
	
		 	  WordLists wl = new WordLists(nameFile); //creates wordlist object
	
		   
		      String[] SuggestedWords;
		      
		      System.out.println("Please enter your desired word length: ");
		      int length = scan.nextInt();
		      
		      SuggestedWords = wl.lengthN(length);
		      
		      try 
			    {
			    	  FileWriter writeLength = new FileWriter("WordsOfLengthN.txt");
			    	  for(String s: SuggestedWords)
			    	  {
			    		  writeLength.write(" " +s+ " ") ;//writes results to text file
			    	  }
			    	  writeLength.close();
				} 
			      catch (IOException e) 
			    {
					e.printStackTrace();
				}
		      System.out.println("Please enter first letter of desired word");
		      char character = scan.next().charAt(0);
		      
		      System.out.println("Please enter your desired word length: ");
		      int longWord = scan.nextInt();
		      
		      String [] WordStartsWith = wl.startsWith(longWord , character);
		      
		      try 
			    {
			    	  FileWriter WriteStarts = new FileWriter("WordsStartingWith.txt");
			    	  for(String s: WordStartsWith)
			    	  {
			    		  WriteStarts.write(" " +s+ " ") ;
			    	  }
			    	   WriteStarts.close();
				} 
			      catch (IOException e) 
			    {
					e.printStackTrace();
				}
		     
		      
		      System.out.println("Enter Character you wish your word to include");
		      char c = scan.next().charAt(0);
		      
		      System.out.println("Please enter your desired word length: ");
		      int desiredLen = scan.nextInt();
		      
		      String[] WordsInclude = wl.containsLetter(desiredLen, c);
		      try 
			    {
			    	  FileWriter WriteContains = new FileWriter("WordsContaining.txt");//name of file
			    	  for(String s: WordsInclude)
			    	  {
			    		  WriteContains.write(" " +s+ " ") ;
			    	  }
			    	  WriteContains.close();
				} 
			      catch (IOException e) 
			    {
					e.printStackTrace();
			    }
		      
		      System.out.println("Enter the amount of vowels you desire");
		      int vowels = scan.nextInt();
		      
		      System.out.println("Please enter your desired word length: ");
		      int LengthOfWord = scan.nextInt();
		      
		      String [] WithVowels = wl.vowelHeavy(LengthOfWord, vowels);
		      try 
			    {
			    	  FileWriter WriteVowels = new FileWriter("VowelWords.txt");
			    	  for(String s: WithVowels)
			    	  {
			    		  WriteVowels.write(" " +s+ " ") ;
			    	  }
			    	  WriteVowels.close();
				} 
			      catch (IOException e) 
			    {
					e.printStackTrace();
				}
		      
		      System.out.println("Please enter Character desired of multiple occurences");
		      char LetterDesired = scan.next().charAt(0);
		      System.out.println("Please enter your desired occurences: ");
		      int Amount = scan.nextInt();
		      String [] occurs = wl.multiLetter(Amount, LetterDesired);
		      for(int i=0;i<occurs.length;i++)
		    	  System.out.println(occurs[i]);
		      try 
			    {
			    	  FileWriter WriteOccur = new FileWriter("CharacterOcurrences.txt");
			    	  for(String s: occurs)
			    	  {
			    		  WriteOccur.write(" " +s+ " ") ;
			    	  }
			    	  WriteOccur.close();
				} 
			      catch (IOException j) 
			    {
					j.printStackTrace();
				}

		      
		}
			catch (FileNotFoundException e) //exception for if user inputs something other than a file
			{
				System.out.println("Please enter valid file name");
				System.out.println(e);
			}
			catch (InputMismatchException i) //exception if user inputs wrong format for input
			{
				System.out.println("Please enter the correct format");
				System.out.println(i);
			}
	}
		
}

