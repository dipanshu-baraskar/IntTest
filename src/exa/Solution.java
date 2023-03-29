package exa;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        Given a tuples which contains source to destination
//        - [{1,2},{1,3},{2,3},{3,4},{3,5},{5,6}]
//        Given an array of stations,
//        find if there is a possible path existent from start to end. [1,3,4,6]
        //1 -> 2,3
        //2 -> 3
        //3 -> 4,5
        //5 -> 6

        List<Integer> ip = Arrays.asList(1, 2, 3, 5, 6);

        System.out.println(isPathAvailable(ip));
    }

    private static boolean isPathAvailable(List<Integer> list) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(2, 3));
        map.put(2, Collections.singletonList(3));
        map.put(3, Arrays.asList(4, 5));
        map.put(5, Collections.singletonList(6));

        for (int i = 0; i < list.size() - 1; ) {
            if (map.containsKey(list.get(i))) {
                List<Integer> valList = map.get(list.get(i));
                if (valList.contains(list.get(i + 1))) {
                    i++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
