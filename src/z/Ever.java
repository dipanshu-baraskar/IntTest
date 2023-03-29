package z;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ever {
    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";
        //abc->3
//        pwwkew
        //kew,
//        "bbbbb"
        //1
        System.out.println(longSubStrLen(s));
////////////////////////////////////////////////////////////////////////////
//    Input: A = [2, 3, 2, 1], K = 3
//    Output: 3
//    Explanation: 3 boxes with weights (1, 2), (2) and (3)
//    Input: A = [3, 5, 3, 4], K = 5
//    Output: 4
//    Explanation: 4 boxes with weights (3), (3), (4), (5)
        int[] ip = {3, 5, 3, 4, 1, 2, 2, 2};
        //1,2,2,2,3,3,4,5
        int k = 5;
        int[] ip2 = {2, 3, 2, 1};
        int k2 = 3;
        System.out.println(minBoxes(ip, k));
    }

    private static int longSubStrLen(String s) {
        char[] chAr = s.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        List<String> list = new ArrayList<>();
        StringBuilder op = new StringBuilder();
        for (int i = 0; i < chAr.length; i++) {
            if (!hs.contains(s.charAt(i))) {
                hs.add(s.charAt(i));
                op.append(s.charAt(i));
            } else {
                list.add(op.toString());
                hs.clear();
                op = new StringBuilder();
            }
        }
        list.add(op.toString());
        Optional<String> first = list.stream().min((o1, o2) -> o2.length() - o1.length());
        return first.get().length();
    }

    private static int minBoxes(int[] a, int k) {
        Arrays.sort(a);
        //1,2,2,2,3,3,4,5
        int i = 0;
        int j = a.length - 1;
        int op = 0;
        while (i <= j) {
            op++;
            if (a[i] + a[j] <= k) {
                i++;
            }
            j--;
        }
        return op;
    }
}