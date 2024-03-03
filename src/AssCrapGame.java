import java.util.Random;
import java.util.Scanner;

public class AssCrapGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Welcome message
        System.out.println("Welcome to the Craps game!");

        // Main game loop
        do {
            // Roll two six-sided dice
            int die1 = rollDie(random);
            int die2 = rollDie(random);
            int sum = die1 + die2;

            // Display results of the dice roll
            displayRollResults(die1, die2, sum);

            // Check game outcome based on rules
            checkGameOutcome(sum, random);

            // Ask if user wants to play again
            System.out.print("Play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        // Farewell message
        System.out.println("Thanks for playing! Goodbye!");
    }

    // Simulate rolling a six-sided die
    private static int rollDie(Random random) {
        return random.nextInt(6) + 1;
    }

    // Display dice roll results
    private static void displayRollResults(int die1, int die2, int sum) {
        System.out.println("Rolling the dice...");
        System.out.println("Die 1: " + die1);
        System.out.println("Die 2: " + die2);
        System.out.println("Sum: " + sum);
    }

    // Check game outcome based on dice sum
    private static void checkGameOutcome(int sum, Random random) {
        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("Craps! You lost!");
        } else if (sum == 7 || sum == 11) {
            System.out.println("Natural! You won!");
        } else {
            System.out.println("Point is: " + sum);
            playSubsequentRolls(sum, random);
        }
    }

    // Handle subsequent rolls after establishing a point
    private static void playSubsequentRolls(int point, Random random) {
        Scanner scanner = new Scanner(System.in);
        int newRoll;

        do {
            // Roll two six-sided dice for subsequent rolls
            int die1 = rollDie(random);
            int die2 = rollDie(random);
            newRoll = die1 + die2;

            // Display results of subsequent roll
            displayRollResults(die1, die2, newRoll);

            // Check outcome of subsequent roll
            if (newRoll == point) {
                System.out.println("Made point! You won!");
                break;
            } else if (newRoll == 7) {
                System.out.println("Got a seven and lost!");
                break;
            } else {
                System.out.println("Trying for point...");
            }
        } while (true);
    }
}
