/*
 * Title:            Challenge 5 (Hangman)
 * Files:            Challenge 5 (Hangman)
 *                   The program also has 2 files: words.txt and gamelog.txt
 *                  one holds the words and the other is to keep track of the
 *                  secret word and the number of guesses
 * Semester:         COP2250 Spring 2016
 *
 * Author:            id # 3323611
 * Instructor’ Name:    Charters
 * Lab Section:      Lab 1 (Mondays)
 * Description of Pgm: Asking the user if he/she wants to play Hangman
 *                      Diplaying the blanks for the user to guess
 *                      Display the number of guesses the user has left
 *                      If the user win display appropiate message, if the
 *                      user loses display appropiate message
 *                      Ask if the user wants to play again
 *                  As extra credit the program also reads the words from the file
 *              words.txt and writes some output to the file gamelog.txt
 */
package hangmangame;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author 3323611
 */
public class HangmanGame
{
    //Global Variables to hold the number of games played and the number of games won
    //and the number of guesses the user had to use.
        public static int numGames = 0;
        public static int numWon = 0;
        public static int numG;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
     
     //Outermost Loop:
        //0.  Do you wish to play a game of Hangman?  (enter "yes" or "no")
        //    If the user replies "no," the program will end immediately. 
        //1.  instantiating a new Hangman - domain object
        //2.  count the number of letters in the word, and display that many underscores on the screen, looking like this:
        //    Here is the word for you to guess: _ _ _ _ _ _ _ (one underscore for each letter in the word)
        //    You have x-number of guesses before you lose.  (x-number is calculated as the number of letters in the word times 3).
     //Innermost Loop:        
        //     3.  Ask the user:  What is your next letter guess? (enter 1 letter only)
        //     4.  Check if the letter exists in the secret word (hint:  use the String method indexOf(String str, int fromIndex) ).  
        //         a.)  For every location where the letter was found in the word, put the letter in place of the underscore.  
        //         b.)  Each time the user enters a letter, subtract 1 from the total number of guesses left.  
        //         c.)  Keep displaying the same prompt as before, with the updates of the letters in the secret word and the count of guesses decrementing. 
        //              The number of guesses is equal to the number of letters in the secret word multiplied by 3.
        //              Sample program output:
        //
        //              Here is the word for you to guess: _ a _ _ _ e _ (one underscore for each letter in the word).
        //              You have X-number of  guesses left before you lose.  (x-number is calculated as the number of letters in the word times 3).
        //              What is your letter guess? (enter 1 letter only)
        //     5. The game is over when either the number of guesses left is equal to 0, or when all the letters in the secret word are correctly guessed.  
        //        Display one of the following two messages, depending on whether the user guessed the word correctly or not:
        //        You correctly guessed the word.  Congratulations!  OR
        //        Sorry, you did not guess the word.  Better luck next time.
        
     //Once the innermost Loop is over, prepare to prompt user for the outermost loop:
     //Then, display the original menu again, and ask if users wants to play again.
     //Do you wish to play a game of Hangman?  (enter "yes" or "no")
     //If the user replies "no," the program will end immediately.  If the user replies "yes," the program will loop again, and start the innermost loop again, creating a whole new hangman object.
        Scanner keyboard = new Scanner(System.in);
        String userChoice;
        
        //Promts the user for input to start the loop
        System.out.println("Do you want to play Hangman??");
        userChoice = keyboard.next();
        
        while(userChoice.equalsIgnoreCase("yes"))
        {
            //Counter to keep track of the games played.
            numGames++;
           //instantiating a new Hangman - domain object
            Hangman aHangman = new Hangman();
           
            //Prints the secret word, the purpose is to see if the logic of the program works correctly
            //For debugging i'm printing the secretWord
            System.out.println(aHangman);
                      
            //Calls the findletter method
            findLetters(aHangman.getSecretWord());
            
            //Extra credit according to Professor Charters
            //If statement to write the secret word, the number of guesses
            //the user had to use and the number of games won out of the
            //total games to the file named "gamelog.txt"
            if(userChoice.equalsIgnoreCase("yes"))
        {
            FileWriter fw = new FileWriter("gamelog.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(aHangman + ", Number of Guesses: " + numG + "\n"
            + "You have won " + numWon + " out of " + numGames + " games of Hangman. Keep Playing!");
            
            pw.close();
        }
                  
            //Prompt the user for input to decide if the loop ends or starts over
            System.out.println("Would you like to play again??");
            userChoice = keyboard.next(); 
        } 
        //If statement to display to the user the number of games won
        //out of the total games
        if(!userChoice.equalsIgnoreCase("yes"))
        {
            System.out.println("You have won " + numWon + " out of " + numGames + " games of Hangman. Good Job! ");
        }
    }
       
    //This method displays the --- to the user in order to determine the number of
    //guesses and the number of letters in the word.
    public static void findLetters(String hangmanWord)
    {
        //Declaring variables
        Scanner keyboard = new Scanner(System.in);
        String secretWord = hangmanWord; 
        String displaySecretWord = ""; 
        String newSecretWord = "";
        
        
        System.out.println("Here is the word you have to guess!");
        //Loop to display the correct number of blanks according to the secret word
        for(int i = 0; i < hangmanWord.length(); i++)
                  {
                      
                      displaySecretWord += "-";
                  }
        
        
        System.out.println(displaySecretWord);
        int loc = 0;
        int numGuesses = secretWord.length() * 3;
        numG = 0;
        String letter;//replaced by asking user
        while (numGuesses > 0 && !displaySecretWord.equalsIgnoreCase(secretWord))
        {
            System.out.println("You have " + numGuesses + " number of guesses before you lose.");
            numGuesses --;
            System.out.println("Enter your guess!");
            letter = keyboard.next().substring(0,1);
            loc = 0;
            //Counter for numG (number of guesses the user used)
            numG++;
            while (loc < secretWord.length() && loc > -1 )
            {

                loc = secretWord.indexOf(letter, loc);
                if (loc > -1)
                {
                    newSecretWord = displaySecretWord.substring(0, loc);
                    newSecretWord += letter;
                    newSecretWord += displaySecretWord.substring(loc+1);
                    displaySecretWord = newSecretWord;
                    System.out.println(newSecretWord);
                    loc++;
                }
            }
            //Displays a message to the user if he/she wins the game.
            if(displaySecretWord.equalsIgnoreCase(secretWord))
            {
                System.out.println("You correctly guessed the word! Congratuations, you win this time! ");
                //Counter to keep track of the games won
                numWon++;
            }
            //Display a message to the user of he/she loses the game
            if (numGuesses == 0 && !displaySecretWord.equalsIgnoreCase(secretWord))
            {                
                 System.out.println("Sorry, you did not guess the word. Better luck next time!");                 
            }
        }      
    }

}