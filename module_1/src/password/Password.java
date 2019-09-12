package password;

public class Password {

    static boolean checkPassword(String theWord) {
        return (checkLength(theWord) && checkForOnlyDigitsAndLetters(theWord)
                && checkThatContainsAtLeastThreeDigits(theWord));
    }

    static private boolean checkLength(String password) {
        return password.length() >= 10;
    }

    static private boolean checkForOnlyDigitsAndLetters(String password) {
        String OnlyDigitsAndLettersPattern = "^[a-zA-Z0-9]*$";
        if (password.matches(OnlyDigitsAndLettersPattern)) {
            return true;
        }
        return false;
    }

    static boolean checkThatContainsAtLeastThreeDigits(String password) {
        String AtLeastThreeDigitsPattern = "(?:\\D*\\d){3,}.*";
        if (password.matches(AtLeastThreeDigitsPattern)) {
            return true;
        }
        return false;
    }
}
