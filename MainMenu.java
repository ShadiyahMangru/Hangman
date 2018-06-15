package Hangman;
import java.io.*;

/**
*  The MainMenu class presents the user with a menu of word difficulty options
* 
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/

public class MainMenu{
	
	private WordBank decideLevel;
	
	/**
	* No-argument constructor loads the select-difficulty-level menu
	*/
	public MainMenu(){
		userOptions();
	}
	
	/**
	* returns the word bank corresponding to the user's difficulty-level selection
	* @return WordBank 
	*/
	public WordBank getDecideLevel(){
		return decideLevel;
	}
	
	/**
	* a method that outputs a menu to select word difficulty for current round
	*/
	public void userOptions(){
		System.out.println("\nSELECT LEVEL OF DIFFICULTY!");
		System.out.println("\nMake a choice:\n1.) Easy\n2.) Medium\n3.) Hard \n\n4.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
				switch(userChoice){
					case 1: System.out.print("You selected: Easy");
						decideLevel = new WordBank(0);
						break;
					case 2: System.out.println("You selected: Medium");
						decideLevel = new WordBank(1);
						break;
					case 3: System.out.println("You selected: Hard");
						decideLevel = new WordBank(2);
						break;
					case 4: System.out.print("You selected: EXIT");
						System.exit(0);
						break;
					default: userOptions(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		userOptions();
		}
	}
}