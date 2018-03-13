package com.example.plantep.javaforandroid;

import java.util.Random;

/*
    Guessing Game:holds the game logic
    The user has 5 attempts to guess a random computer generated number
 */
public class GuessingGame {
    Random rand = new Random();
    int guessingRandomNumber;
    int guessesLeft = 5;
    String answerResponse = "";

    //initializes the game
    public GuessingGame()
    {
        restart();
        //Initialize Random Number
        //guessingRandomNumber = rand.nextInt(100) + 1;

    }

    /*
        Given the users guess which is an integer, it will return an
        appropriate string to let the user know how they are doing
        in the game
     */
    public String guess(int guess)
    {
        //initial check to see if guess is within the correct range
        if (guess > 100 || guess < 0 )
        {
            return "Invalid input\nEnter a number between 0 and 100";
        } else {
            //initial check to see how many guesses left the user has
            if (guessesLeft > 0) {
                //checks guess
                if (guess == guessingRandomNumber) {
                    return "Your guess is correct!! BOOYA\nTo play again, click on restart!";
                } else {
                    //if guess is incorrect, it creates the answer response (higher or lower)
                    if (guess < guessingRandomNumber) {
                        answerResponse = "It's higher than " + String.valueOf(guess);
                    } else {
                        answerResponse = "It's lower than " + String.valueOf(guess);
                    }
                    //once response is recorded a response is given
                    guessesLeft -= 1;
                    return answerResponse + "\n" + "You have " + guessesLeft + " guesses left.";
                }
            } else {
                //returns this if out of guesses
                return "You're all out of guesses :(\nTo play again, click on restart!";
            }
        }
    }

    //restarts the game
    public void restart()
    {
        guessesLeft = 5;
        guessingRandomNumber = rand.nextInt(100) + 1;
    }
}
