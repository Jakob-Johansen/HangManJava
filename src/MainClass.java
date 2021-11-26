import java.util.Scanner;

public class MainClass {

    private int _life = 10;
    private String _wordToGuess;

    private StringValidate _stringValidate;
    public static Scanner scanner = new Scanner(System.in);

    // REMEMBER THAT _wordToGuess IS CASE SENSITIV.
    // CANT USE Æ AND Å!

    public MainClass() {
        _stringValidate = new StringValidate();
    }

    public void Start() {
        // Outputs information about the game in the console.
        Information.GameInfo();
        _wordToGuess = _stringValidate.PickWord();

        while (true) {
            
            // Execute PlayerGuess method. 
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
        String inputGuess;
        String errorMsg = "You must type a letter";

        while (true) {
            try {
                System.out.print("Write the letter you are guessing at: ");
                inputGuess = scanner.nextLine().trim();

                // If inputGuess String is a letter then return true and break the loop.
                if (_stringValidate.Validate(inputGuess, errorMsg)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("An error has occurred");
            }
        }
    }

    // public void ChcekIfTrue(String inputGuess) {

    // }
}