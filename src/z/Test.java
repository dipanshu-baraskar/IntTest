package z;

import java.util.*;

public class Test {

    static int nCr(int n, int r) {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n) {
        if (n == 0)
            return 1;
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

    private static int calc(int n) {


        int ans = ((n + 5) * (n + 4) * (n + 3) * (n + 2) * (n + 1) )/ 120;

        return ans;

    }

    // Driver code
    public static void main(String[] args) {
        System.out.println("op>" + calc(3));
    }
}
