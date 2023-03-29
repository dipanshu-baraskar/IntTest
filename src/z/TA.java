package z;

import java.util.*;

class Solution {

    public int solution(int[][] arr) {
        int[] a = new int[arr.length];
        int[] b = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i][0];
            b[i] = arr[i][1];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        //{{900, 1130}, {1131, 1140}, {1000, 1200}, {1400, 1800}, {2000, 2100}};

        //900  1000 1131 1400 2000
        //1130 1140 1200 1800 2100

        while (i < arr.length) {
            if (a[i] <= b[j]) {
                count++;
                max = Math.max(max, count);
                i++;
            } else if (a[i] > b[j]) {
                count--;
                j++;
            }
        }
        return max;
    }
}

class Main {

    public static void main(String[] args) {
        // Scanner myObj = new Scanner(System.in);
        // String line = myObj.nextLine();

        int[][] ip = {{900, 1230}, {1000, 1200}, {1400, 1800}, {2000, 2100}};
        //{{900, 1130}, {1131, 1140}, {1000, 1200}, {1400, 1800}, {2000, 2100}};
        int ans = new Solution().solution(ip);

        System.out.print(ans);
    }
}

// A company offers employees the facility to book their office space one day in advance.
// Employee registers their expected entry and exit times on the portal, before coming to the office.
// Given the data for the next day, find out how many minimum chairs will be required to serve all the employees for that particular day.
// The chairs can be reused across employees during the day.
// E.g. Employees log in and logout: in 9:00 - 12:30 10:00 - 12:00 14:00 - 18:00 20:00 - 21:00

// Ex-1:-

// time_stamps[][] = {{900, 1230}, {1000, 1200}, {1400, 1800}, {2000, 2100}}
// Chairs required: 2 (1st and 2nd users are present simultaneously to require a chair)
