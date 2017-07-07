/**
 * @author Ziyi Yan cxfyzy@gmail.com
 *         Created on 08/07/2017.
 */
public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        for (char ch : word.toCharArray()) {
            wordDeque.addLast(ch);
        }

        return wordDeque;
    }

    public static boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    private static boolean isPalindrome(Deque<Character> wordDeque) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }

        char first = wordDeque.removeFirst();
        char last = wordDeque.removeLast();

        return first == last && isPalindrome(wordDeque);
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }

    private static boolean isPalindrome(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }

        char first = wordDeque.removeFirst();
        char last = wordDeque.removeLast();
        return cc.equalChars(first, last) && isPalindrome(wordDeque, cc);
    }
}
