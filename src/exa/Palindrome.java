package exa;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome("abcbaaa"));
    }

    public String isPalindrome(String s) {
        if (isPal(s)) {
            return "pal";
        } else if (validPalindrome(s)) {
            return "almost";
        } else {
            return "not";
        }
    }

    private boolean isPal(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
