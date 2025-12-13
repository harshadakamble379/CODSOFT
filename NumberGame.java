import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        String playAgainInput;

        do {
            int number = rand.nextInt(100) + 1; // Random number 1–100
            int attempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nNumber Guessing Game");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + attempts + " attempts");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts--;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                System.out.println("Attempts left: " + attempts);
            }

            if (!guessedCorrectly) {
                System.out.println("You lost! The number was: " + number);
            }

            System.out.println("Current Score: " + score);

           
            System.out.print("Do you want to play again? (yes/no): ");
            playAgainInput = sc.next().toLowerCase(); // accepts yes or no

           
            sc.nextLine();  

        } while (playAgainInput.equals("yes"));

        System.out.println("\nThank you for playing! Final Score: " + score);
        sc.close();
    }
}
