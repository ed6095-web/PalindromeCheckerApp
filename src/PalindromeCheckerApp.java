import java.util.*;

public class PalindromeCheckerApp {

    // Two Pointer Method
    public static boolean twoPointer(String input) {
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

    // Stack Method
    public static boolean stackMethod(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return processed.equals(reversed);
    }

    // StringBuilder Reverse
    public static boolean stringBuilderMethod(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();
        return processed.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\n----- UC13 Performance Comparison -----");

        // Two Pointer Timing
        long start1 = System.nanoTime();
        boolean result1 = twoPointer(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Stack Timing
        long start2 = System.nanoTime();
        boolean result2 = stackMethod(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // StringBuilder Timing
        long start3 = System.nanoTime();
        boolean result3 = stringBuilderMethod(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        System.out.println("Two Pointer Result: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Stack Method Result: " + result2 + " | Time: " + time2 + " ns");
        System.out.println("StringBuilder Result: " + result3 + " | Time: " + time3 + " ns");

        scanner.close();
    }
}