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
import java.util.Random;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author 3323611
 */
public class Hangman 
{
    
    private String secretWord;
    final private String wordChoice1;
    final private String wordChoice2;
    final private String wordChoice3;
    final private String wordChoice4;
    final private String wordChoice5;

    //Opens the file words.txt 
    File myFile = new File("words.txt");  //This is not part of the original assignment, Professor Charters 
    Scanner inFile;                       // said in class: extra credit is available if the program reads
                                          // the words from a file instead of having them hardcoded in the program.
    //Constructor
    public Hangman() throws IOException
    {
        //Reads the file
        this.inFile = new Scanner(myFile);
        
        //Assigns the words stored in the file to the variables in the constructor.
        this.wordChoice1 = inFile.nextLine();
        this.wordChoice2 = inFile.nextLine();
        this.wordChoice3 = inFile.nextLine();
        this.wordChoice4 = inFile.nextLine();
        this.wordChoice5 = inFile.nextLine();
        
        Random myRan = new Random();
        int myInt = myRan.nextInt(5) + 1;
        if (myInt == 1)
            secretWord = wordChoice1;
        else if (myInt == 2)
            secretWord = wordChoice2;
        else if (myInt == 3)
            secretWord = wordChoice3;
        else if (myInt == 4)
            secretWord = wordChoice4;
        else if (myInt == 5)
            secretWord = wordChoice5;
      
        inFile.close();
    }
    
     //Getters
     /**
     * This method gets the variable secretWord
     * @return secretWord
     */
    public String getSecretWord()
    {
        return secretWord;
    }
     //Setters
    /**
     * This method sets the variable secretWord
     * @param aSecretWord this represents secretWord
     */
    public void setSecretWord(String aSecretWord)
    {
        secretWord = aSecretWord;
    }
    
    //This method is a string representation of the Hangman object
    public String toString()
    {
        return "Secret Word is: " + secretWord;
    }
}
