import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    private int _life = 10;

    private String _wordToGuess;
    private List<Character> _gussedChars = new ArrayList<Character>(); 

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

        // Took from stack overflow, quick fix, not done.
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        //

        for (int i = 0; i < _wordToGuess.length(); i++) {
            if (_wordToGuess.charAt(i) == ' ') {
                System.out.print(" ");   
            }
            else {
                System.out.print("_ ");
            }
        }

        System.out.println("\n\nYou have " + _life);

        while (true) {
            
            // Execute PlayerGuess method. 
            PlayerGuess();

            // Remove me.
            if (_life == 0) {
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
                System.out.print("\n\nWrite the letter you are guessing at: ");
                inputGuess = scanner.nextLine().toLowerCase().trim();

                // If inputGuess String is a letter then return true and break the loop.
                if (_stringValidate.Validate(inputGuess, errorMsg)) {
                    if (inputGuess.length() > 1) {
                        System.out.println("You can only type one letter.");
                    }
                    else if (_gussedChars.contains(inputGuess.charAt(0))) {
                        System.out.println("You've already guessed at that letter.");
                    }
                    else {
                        CompareInputAndGuess(inputGuess);
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("An error has occurred");
            }
        }
    }

    public void CompareInputAndGuess(String inputGuess) {

        if (_wordToGuess.contains(inputGuess)) {
            _gussedChars.add(inputGuess.charAt(0));
            System.out.println("\nYour guess was right");
        }
        else {
            _life--;
            System.out.println("\nYour guess was wrong");
        }

        System.out.println("Guess back: " + _life + "\n");

        for (int i = 0; i < _wordToGuess.length(); i++) {

            if (_gussedChars.contains(_wordToGuess.charAt(i))) {

                System.out.print(_wordToGuess.charAt(i) + " ");
                _gussedChars.add(inputGuess.charAt(0));

            }
            else if (_wordToGuess.charAt(i) == ' ')
                System.out.print(" ");
            else
                System.out.print("_ ");
        }

        if (_life == 0) {
            System.out.println("\nYou lost!");
            return;
        }
    }
}