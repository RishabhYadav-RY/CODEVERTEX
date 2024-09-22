import java.util.Random;
import java.util.Scanner;
public class Numbergame
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRounds = 0;
        int totalScore = 0;
        while (playAgain)
        {
            int numberToGuess = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;
            totalRounds++;
            System.out.println("Round" + totalRounds + ": Try to guess the number between 1 and 100. ");
            while(attempts < maxAttempts && !guessedCorrectly)
            {
                System.out.print("Enter your guess (Attempt " +(attempts + 1) +"/" + maxAttempts +"): ");
                int userGuess = sc.nextInt();
                attempts++;
                if(userGuess < numberToGuess)
                {
                    System.out.println("Too low!");
                }
                else if(userGuess > numberToGuess)
                {
                    System.out.println("Too high!");
                }
                else{
                    System.out.println("Correct! You have guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1);
                    guessedCorrectly = true;
                }
            }
            if(!guessedCorrectly)
            {
                System.out.println("Sorry, you have used all attempts.The correct number was " + numberToGuess);
            }
            System.out.print("Do you want to play again?(yes/no): ");
            String userResponse = sc.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        
        }
        System.out.println("Game over! You played " + totalRounds + " rounds. ");
        System.out.println("Your total score is: " + totalScore );
        sc.close();
    }
}
