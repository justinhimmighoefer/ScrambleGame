//Justin Himmighoefer
//A file with a list of words is used to select a random word that then has
//it's letter rearranged and the user must guess the correct word by
//arranging the letters in the correct order.

import java.io.*;
import java.util.*;

public class ScrambleGame
{
	public static void main(String[] args)
	{
		String myString;
		myString = ScrambleAString.Scramble("Hello");
		System.out.println(myString);
		
		int fileLength = 0;
		int randNumTokenToFind = 0;
		String answer = "";
		String tokenRead = "";
		String stringToScramble = "";
		String scrambledString = "";
		Scanner inputStream = null;
		Random randNum = new Random();
		Scanner keyboard = new Scanner(System.in);
		
		try
		{
			inputStream = new Scanner(new FileInputStream("DictionaryNoDups.txt"));
		}//end try
		
		catch(FileNotFoundException e)
		{
			System.out.println("File cound not be opened, program will close");
			System.exit(0);
		}//end catch
		
		while(inputStream.hasNext())
		{
			inputStream.nextLine();
			++fileLength;
		}//end while
		
		inputStream.close();
		
		randNumTokenToFind = randNum.nextInt(fileLength);
		
		//open file to get string
		try
		{
			inputStream = new Scanner(new FileInputStream("DictionaryNoDups.txt"));
		}//end try
		
		catch(FileNotFoundException e)
		{
			System.out.println("File cound not be opened, program will close");
			System.exit(0);
		}//end catch
		
		for(int i = 0; i < fileLength; ++i)
		{
			tokenRead = inputStream.nextLine();
			if(i == randNumTokenToFind)
			{
				stringToScramble = tokenRead;
				break;
			}//end if
		}//end for
		
		scrambledString = ScrambleAString.Scramble(stringToScramble);
		
		System.out.println("Hint: " + stringToScramble);
		
		System.out.println("What is the word: " + scrambledString);
		answer = keyboard.nextLine();
		
		if(answer.equals(stringToScramble))
		{
			System.out.println("Correct!");
		}//end if
		else
			System.out.println("Incorrect");
		
	}//end main
}//end class
