//Justin Himmighoefer

import java.util.Random;

public class ScrambleAString
{
	public static String Scramble(String stringPassed)
	{
		Random randNum = new Random();
		String scrambledString = "";
		int lengthPassedString, possible;//, numberFoundAtPositioni;
		//char charFoundAtPositioni;
		int[] compGenNum;
	
		lengthPassedString = stringPassed.length();
		compGenNum = new int[lengthPassedString];
	
		//populate array with dummy values
		for(int i = 0; i < lengthPassedString; ++i)
		{
			compGenNum[i] = -99;
		}//end for loop
	
		//generate the random number with no repeats
		for(int i = 0; i < lengthPassedString; ++i)
		{
			possible = randNum.nextInt(lengthPassedString);
			for(int j = 0; j < lengthPassedString; ++j)
			{
				if(possible == compGenNum[j])
				{
					j = -1;
					possible = randNum.nextInt(lengthPassedString);
				}//end if
			}//end for loop
		
			compGenNum[i] = possible;
		}//end for loop
	
		for(int i = 0; i < lengthPassedString; ++i)
		{
			scrambledString = scrambledString + stringPassed.charAt(compGenNum[i]);
		}//end for loop
	
		return scrambledString;
	}//end method
}//end class