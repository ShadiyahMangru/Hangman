package Hangman;
import java.io.*;

/**
* The PlayHangman class provides methods to load and play hangman.
* 
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/

public class PlayHangman{

	private MainMenu level;
	private int lives;
	private String mysteryWord;
	private StringBuilder answerKey;
	private StringBuilder alreadyGuess;
	
	/**
	* No-argument constructor -- loads a menu for user to select level of difficulty for this round
	*/
	public PlayHangman(){
		System.out.println("\n***********  LET'S PLAY HANGMAN  ***********\n");
		level = new MainMenu();
	}
	
	/**Constructor to initialize Hangman game fields
	* @param guess guesses remaining
	*/
	public PlayHangman(int guessLimit){
		this();
		lives = guessLimit;
		mysteryWord = level.getDecideLevel().getWords().get(0).toLowerCase();
		answerKey = new StringBuilder(mysteryWord.length());
		alreadyGuess = new StringBuilder();
	}

	
	
	/**
	* a method that outputs the format (letter-length) of the mystery word and requests user's initial letter guess
	*/
	public void playHangman(){
		for(int i = 0; i < mysteryWord.length() ; i++){
			answerKey.append("-");
		}
		System.out.print("\nMYSTERY WORD FORMAT: " + answerKey.toString() + "\n");
		guessLetter();
	}		
	
	/**
	* a method that requests letter guesses from user until user correctly guesses mystery word or has no remaining guesses.
	* If no guesses remain, this method outputs correct answer, informs the user that the game is over, and loads another round of game.
	* if the user correctly guesses the mystery word, a new round of hangman starts.
	* in this game, there is no penalty for duplicate guesses.
	*/
	public void guessLetter(){	
		try{ //retrieve user's letter guess
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\nGuess a letter in the word:  ");
			String guess = reader.readLine().toLowerCase();
			if(guess.length()!=1){ //reject input if not a single character
				System.out.println("Invalid entry.  Try again.");	
				playHangman();
			}
			else{ 
				char g = guess.charAt(0);
				//if current letter has already been guessed during this round, retrieve another guess from user
				if(alreadyGuess.toString().contains(guess)==true){
					System.out.println("You have already guessed '" + g + "'");
					System.out.println("\nMYSTERY WORD: " + answerKey.toString());
					guessLetter();
				}
				//if current letter guess is in word, update mystery word format key and reveal to user
				else if(mysteryWord.contains(guess)==true & alreadyGuess.indexOf(guess)==-1){
					for(int i=0; i<mysteryWord.length(); i++){
						if(mysteryWord.charAt(i)==g){
							answerKey.deleteCharAt(i);
							answerKey.insert(i, g);	
						}
					}
				System.out.println(answerKey.toString());
				alreadyGuess.append(guess); //add current letter to the list of guessed letters
				//ask user for another letter guess, if answer key still contains dashes
				if(answerKey.indexOf("-")!=-1){ 
					guessLetter();
				}
				else{ //output winner message if no dashes remain in answer key and load a new round of game
					System.out.println("*****YOU WON!*****");
					PlayHangman playAgain = new PlayHangman(6);
					playAgain.playHangman();
				}
				}
				else{ //if current letter guess not in word, decrease 'lives' by one
					alreadyGuess.append(g);
					System.out.println("That letter is not in the word.");
					lives--;
					System.out.println("You have " + lives + " guesses remaining.");
					if(lives>0){ //retrieve another letter guess from user if 'lives' remain
						System.out.println("MYSTERY WORD: " + answerKey.toString());
						guessLetter();
					}
					else{ //output mystery word and a game over message to user if no 'lives' remain; load another round of game
						System.out.println("The mystery word was: " + mysteryWord + ".  BETTER LUCK NEXT TIME!");
						System.out.println("\n***GAME OVER***");	
						PlayHangman tryAgain = new PlayHangman(6);
						tryAgain.playHangman();
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("oh noz, there is an exception: " + e);	
		}	
	}


	/**
	* the main method launches the application
	* @param args command line arguments
	*/
	public static void main(String[] args){
		PlayHangman startGame = new PlayHangman(6);
		startGame.playHangman();
	}
	
}