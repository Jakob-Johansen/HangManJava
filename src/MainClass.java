import java.util.Scanner;

public class MainClass {

    private int _life = 10;
    private String _wordToGuess;

    public static Scanner scanner = new Scanner(System.in);

    // REMEMBER THAT _wordToGuess IS CASE SENSITIV.

    public void Start() {
        // Outputs information about the game in the console.
        Information.GameInfo();

        WordValidate wordValidate = new WordValidate();
        _wordToGuess = wordValidate.PickWord();

        while (true) {
            PlayerGuess();
            if (_life == 0) {
                System.out.println("you lost....");
                break;   
            }
        }
        System.out.println("x");
        scanner.close();
    }

    public void PlayerGuess() {
        String playerGuess;
        String errorMsg = "You must type a letter";

        while (true) {
            try {
                System.out.print("Write the letter you are guessing at: ");
                playerGuess = scanner.nextLine().trim();
                if (WordValidate.Validate(playerGuess, errorMsg)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("An error has occurred");
            }
        }
    }
}