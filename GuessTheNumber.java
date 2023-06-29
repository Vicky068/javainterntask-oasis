import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain = true;
        
        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");
        
        while (playAgain) {
            int targetNumber = generateRandomNumber(minRange, maxRange);
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Enter a number between " + minRange + " and " + maxRange + ":");
                
                if (input == null) {
                    // User clicked cancel or closed the dialog
                    JOptionPane.showMessageDialog(null, "Game terminated.");
                    System.exit(0);
                }
                
                int guess = Integer.parseInt(input);
                
                if (guess == targetNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
                
                attempts++;
            }
            
            if (guessedCorrectly) {
                score += maxAttempts - attempts;
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number correctly.");
            } else {
                JOptionPane.showMessageDialog(null, "Out of attempts! The number was: " + targetNumber);
            }
            
            int choice = JOptionPane.showConfirmDialog(null, "Your score: " + score + "\nDo you want to play again?");
            playAgain = (choice == JOptionPane.YES_OPTION);
        }
        
        JOptionPane.showMessageDialog(null, "Thank you for playing Guess the Number. Goodbye!");
    }
    
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
