import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to hangman! I will pick a word and you will guess it character by character\n" +
                            ". If you guess it wrong 6 times, then I win. If you can guess it before, then you win\n\n" +
                            ". You ready? I hope so, because I am!!");
        System.out.println();
        System.out.println("I have picked a word and below is a picture. Below is your current guess " +
                            "That starts as nothing.\n Every time you guess incorrectly, I will add a body part.\n" +
                            "When its a full person, you lose.");
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {
            System.out.println();
            System.out.println("Alright, Lets play");
            Hangman game = new Hangman();
            do {
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.println();

                // Get the guess
                System.out.println("Enter a character that you think is in the word");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println();

                // Check if the character has been guessed before
                if (game.isGuessedAlready(guess)) {
                    System.out.println("Try again. You have guessed this character already");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }

                if (game.playGuess(guess)) {
                    System.out.println("Great guess. That character is in in the word");
                }
                else {
                    System.out.println("Unfortunately that word is not in the guess");
                }
            }
            while (!game.gameOver());

            System.out.println();
            System.out.println("Do you want to play another game. Enter Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');
        }

    }
}
