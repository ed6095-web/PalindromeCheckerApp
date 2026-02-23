public class PalindromeCheckerApp {

    public static void main(String[] args) {

<<<<<<< HEAD
        String word = "madam";

        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
=======
        String word = "racecar";
        char[] characters = word.toCharArray();

        boolean isPalindrome = true;

        for (int i = 0; i < characters.length / 2; i++) {
            if (characters[i] != characters[characters.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
>>>>>>> feature/UC4
            System.out.println("The given string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + word + "\" is NOT a Palindrome.");
        }

    }
}