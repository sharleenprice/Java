//
//Created by spp2122
//This code outputs arrays of specified useful words for scrabble
//
//

import java.io.*;
import java.util.*;
public class WordLists {
ArrayList<String> words = new ArrayList<String>();
int vowelCount=0;
int multiples =0;
	
public WordLists (String fileName) throws FileNotFoundException//a constructor that takes 
//the name of the dictionary file as the only parameter.
	{	
			Scanner scan = new Scanner(new File(fileName)); 
			String s = "";
			while (scan.hasNext())
			{
					s=scan.nextLine();
					words.add(s);//adds words on txt file to array words
			}
	}
		
	public String[] lengthN(int n) throws InputMismatchException //returns an array of words of length n.
	{
		ArrayList<String> wordSize = new ArrayList<String>();
		for(int i=0; i<words.size(); i++)
		{
			if(words.get(i).length()==n)
			{
				wordSize.add(words.get(i));
			}
		}
		if(wordSize.size()==0)
			System.out.println("No words of that size");
		String [] SizeArray = wordSize.toArray(new String[wordSize.size()]);
		return SizeArray; 
	}
	
	public String [] startsWith(int n, char firstLetter) throws InputMismatchException//returns an array of words of length n beginning with the letter firstLetter
	{
		String[]temp = new String[lengthN(n).length];
		temp = lengthN(n);
		ArrayList<String> WordsOfSize = new ArrayList<String>(Arrays.asList(temp));
		
		ArrayList<String> wordLetter = new ArrayList<String>();
		for(String s: WordsOfSize)
		{
			if(s.charAt(0)==firstLetter)
			{
				wordLetter.add(s);
			}
		}
		String[] letter = wordLetter.toArray(new String[wordLetter.size()]);
		return letter; 
		
	}
	
	public String[] containsLetter(int n, char included) throws InputMismatchException
	{//returns an array of words of length n containing the letter included but not beginning with it.
		String[]temp = new String[lengthN(n).length];
		temp = lengthN(n);
		ArrayList<String> wordSize = new ArrayList<String>(Arrays.asList(temp));
		
		ArrayList<String> wordIncluded = new ArrayList<String>();
		for(String s: wordSize)
		{
			if(s.charAt(0)!=included)
			{
				String b = Character.toString(included);
				if(s.contains(b))
					wordIncluded.add(s);
			}
		}
		String[] including = wordIncluded.toArray(new String[wordIncluded.size()]);
		return including; 
		
	}

	public String getLetter (ArrayList<String> s, int index, int letter) throws InputMismatchException
	{// this method accesses one letter from one word in an array of strings
		
				String word = s.get(index);
				char c = word.charAt(letter);
				String a = Character.toString(c);
				return a;
	}
	
	public String[] vowelHeavy(int n, int m) throws InputMismatchException
	{//returns an array of words of length n containing at least m vowels.
		
		String [] wordsS= new String[lengthN(n).length];
		wordsS = lengthN(n);
		ArrayList<String>SizeWords = new ArrayList<String>(Arrays.asList(wordsS));	

		ArrayList<String> VowelWords = new ArrayList<String>();
		for(int i=0;i<SizeWords.size(); i++)
		{
			for(int j=0; j<SizeWords.get(i).length(); j++)
			{
				String a = getLetter(SizeWords, i, j);
				if(a.equals("a")||a.equals("e")||a.equals("i")||a.equals("o")||a.equals("u"))
				{
					vowelCount++;
				}
			}
			if(vowelCount>=m)
			{
				VowelWords.add(SizeWords.get(i));
				vowelCount =0;
			}
			else
				vowelCount =0;
		}
			
			String[] newWords = VowelWords.toArray(new String[VowelWords.size()]);
			return  newWords;
		
	}
		
		
	public String [] multiLetter(int m, char included) throws InputMismatchException
	{//returns an array of words with at least m occurrences of the letter included.
		String includes = Character.toString(included);
		ArrayList<String> MultiWords = new ArrayList<String>();
		for(int i=0;i<words.size(); i++)
		{
			for(int j=0; j<words.get(i).length(); j++)
			{
				String a = getLetter(words, i, j);
				if(a.equals(includes))
				{
					multiples++;
				}
			}
			if(multiples>=m)
			{
				MultiWords.add(words.get(i));
				multiples =0;
			}
			else
				multiples =0;
		}
		
		String [] severalOccur = MultiWords.toArray(new String[MultiWords.size()]);
			
		return severalOccur;
	}
	
}
