package Hangman;
import java.util.*;

/**
* The WordBank class groups available word banks by difficulty-level.
* 
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/

public class WordBank{
	private ArrayList<String> Wds = new ArrayList<String>();
	
	/**
	* Constructor -- initializes a user-selected word bank
	* @param choice 0/1/2 for easy/medium/hard words, respectively
	*/
	public WordBank(int choice){
		switch(choice){
		case 0: setWordsEasy();
			break;
		case 1: setWordsMedium();
			break;
		case 2: setWordsHard();
			break;
		}
	}
	
	/**
	* creates (and shuffles) an 'easy' hangman word bank
	*/
	public void setWordsEasy(){
		Wds.add("flower");
		Wds.add("cake");
		Wds.add("rain");
		Wds.add("tree");
		Wds.add("bee");
		Wds.add("frozen");
		Wds.add("snow");
		Wds.add("leaf");
		Wds.add("hot");
		Wds.add("apple");
		Wds.add("star");
		Wds.add("four");
		Wds.add("cat");
		Wds.add("zoo");
		Wds.add("car");
		Wds.add("train");
		Wds.add("jump");
		Wds.add("bag");
		Wds.add("store");
		Wds.add("heart");
		Wds.add("hat");
		Wds.add("sun");	
		
		Collections.shuffle(Wds);
	}
	
	/**
	* creates (and shuffles) a 'medium' hangman word bank
	*/
	public void setWordsMedium(){
		Wds.add("January");
		Wds.add("computer");
		Wds.add("television");
		Wds.add("soccer");
		Wds.add("dinosaur");
		Wds.add("shovel");
		Wds.add("garden");
		Wds.add("cucumber");
		Wds.add("parade");
		Wds.add("watermelon");
		Wds.add("cupcake");
		Wds.add("pizza");
		Wds.add("tiger");
		Wds.add("giant");
		Wds.add("unicorn");
		Wds.add("octopus");
		Wds.add("volcano");
		Wds.add("meteor");
		Wds.add("ocean");
		Wds.add("beach");
		Wds.add("cloud");
		Wds.add("elephant");
		Wds.add("bakery");
		
		Collections.shuffle(Wds);
	}
	
	/**
	* creates (and shuffles) a 'hard' hangman word bank
	*/
	public void setWordsHard(){
		Wds.add("dolphin");
		Wds.add("instrument");
		Wds.add("blender");
		Wds.add("gasoline");
		Wds.add("cantaloupe");
		Wds.add("firefighter");
		Wds.add("icicle");
		Wds.add("thunder");
		Wds.add("telephone");
		Wds.add("locomotive");
		Wds.add("triangle");
		Wds.add("thirteen");
		Wds.add("eight");
		Wds.add("tricycle");
		Wds.add("automobile");
		Wds.add("circle");
		Wds.add("gymnastics");
		Wds.add("subtraction");
		Wds.add("skyscraper");
		Wds.add("piano");
		Wds.add("ballet");
		Wds.add("rectangle");	
		Wds.add("astronaut");
		
		Collections.shuffle(Wds);
	}
	
	/**
	* returns the hangman word bank chosen by the user, based on level of difficulty
	* @return ArrayList the word bank
	*/
	public ArrayList<String> getWords(){
		return Wds;	
	}
}