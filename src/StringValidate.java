public class StringValidate {

    public String PickWord() {
        String userInput;
        while (true) {
            try {
                System.out.print("Your word/words: ");
                userInput = MainClass.scanner.nextLine().toLowerCase().trim();
                
                // if true.
                if (Validate(userInput, "Your word/words can only contain letters")) {
                    break;   
                }
            } catch (Exception e) {
                System.out.println("An error has occurred");
            }
        }
        return userInput;
    }

    public boolean Validate(String string, String errorMsg) {
        // if String word is empty.
        if (string.length() == 0) {
            System.out.println("The input field must not be empty");
            return false;
        }

        // Removes all whitespace and creates an char array out of String word.
        char[] charArray = string.replace(" ", "").toCharArray();

        for (char i : charArray) {
            // if the charArray index is not a letter.
            if (!Character.isLetter(i)) {
                System.out.println(errorMsg.trim());
                return false;
            }
        }
        return true;
    }
}