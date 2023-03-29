package ls;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        String s = "1.2.3,1.3.4,1.3.0";
        System.out.println(latest(s));
    }
    private static String latest(String s) {
        String[] sAr = s.split(",");
        Optional<String> first = Arrays.stream(sAr).max(Comparator.naturalOrder());
        return first.get();
    }
}
