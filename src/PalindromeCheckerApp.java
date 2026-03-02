import java.util.Scanner;
import java.util.Stack;

// UC11 - Object Oriented Service Class
class PalindromeChecker {

    // Encapsulated palindrome logic
    public boolean checkPalindrome(String input) {

        // Normalize string (Ignore case & spaces)
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = processed.length() - 1;

        while (left < right) {
            if (processed.charAt(left) != processed.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    // UC5 - Recursion (Substring)
    public static boolean isPalindromeRecursive(String str) {
        if (str.length() <= 1)
            return true;

        if (str.charAt(0) != str.charAt(str.length() - 1))
            return false;

        return isPalindromeRecursive(str.substring(1, str.length() - 1));
    }

    // UC9 - Index Based Recursion
    public static boolean isPalindromeRecursiveIndex(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindromeRecursiveIndex(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("\n----- Palindrome Results -----");

        // UC1 - StringBuilder
        String reversed1 = new StringBuilder(processed).reverse().toString();
        System.out.println("UC1 (StringBuilder Reverse): " + processed.equals(reversed1));

        // UC2 - Manual Loop
        String reversed2 = "";
        for (int i = processed.length() - 1; i >= 0; i--) {
            reversed2 += processed.charAt(i);
        }
        System.out.println("UC2 (Manual Loop): " + processed.equals(reversed2));

        // UC3 - Two Pointer
        boolean isPalindrome3 = true;
        int left = 0;
        int right = processed.length() - 1;

        while (left < right) {
            if (processed.charAt(left) != processed.charAt(right)) {
                isPalindrome3 = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("UC3 (Two Pointer): " + isPalindrome3);

        // UC4 - Stack Method
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < processed.length(); i++) {
            stack.push(processed.charAt(i));
        }

        String reversed4 = "";
        while (!stack.isEmpty()) {
            reversed4 += stack.pop();
        }
        System.out.println("UC4 (Stack Method): " + processed.equals(reversed4));

        // UC5 - Recursion (Substring)
        System.out.println("UC5 (Recursion - Substring): " + isPalindromeRecursive(processed));

        // UC9 - Recursion (Index Based)
        System.out.println("UC9 (Recursion - Index Based): " +
                isPalindromeRecursiveIndex(processed, 0, processed.length() - 1));

        // UC10 - Ignore Case & Spaces
        System.out.println("UC10 (Ignore Case & Spaces): " +
                new PalindromeChecker().checkPalindrome(input));

        // UC11 - Object Oriented Service
        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);
        System.out.println("UC11 (OOP Service Class): " + result);

        scanner.close();
    }
}