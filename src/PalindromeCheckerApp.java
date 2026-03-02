import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static boolean isPalindromeRecursive(String str) {
        if (str.length() <= 1)
            return true;

        if (str.charAt(0) != str.charAt(str.length() - 1))
            return false;

        return isPalindromeRecursive(str.substring(1, str.length() - 1));
    }

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node createLinkedList(String str) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(str.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static boolean isPalindromeLinkedList(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("\n----- Palindrome Results -----");

        String reversed1 = new StringBuilder(processed).reverse().toString();
        System.out.println("UC1 (StringBuilder Reverse): " + processed.equals(reversed1));

        String reversed2 = "";
        for (int i = processed.length() - 1; i >= 0; i--) {
            reversed2 += processed.charAt(i);
        }
        System.out.println("UC2 (Manual Loop): " + processed.equals(reversed2));

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

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < processed.length(); i++) {
            stack.push(processed.charAt(i));
        }

        String reversed4 = "";
        while (!stack.isEmpty()) {
            reversed4 += stack.pop();
        }
        System.out.println("UC4 (Stack Method): " + processed.equals(reversed4));

        System.out.println("UC5 (Recursion): " + isPalindromeRecursive(processed));

        Node head = createLinkedList(processed);
        System.out.println("UC8 (Linked List): " + isPalindromeLinkedList(head));

        scanner.close();
    }
}