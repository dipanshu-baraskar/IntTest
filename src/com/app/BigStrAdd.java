package com.app;

public class BigStrAdd {

    public static void main(String[] args) {
       String ss= add("123","123");

    }

    private static String add(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        int carry = 0;
        int l1 = s1.length() - 1;
        int l2 = s2.length() - 1;

        while (l1 >=0 || l2 >= 0 || carry == 1) {
            System.out.println(l1);
            if (l1>=0) {
                sum += Character.getNumericValue(s1.charAt(l1));
                System.out.println("ss->"+sum);
                l1--;
            }
            if (l2>=0) {
                sum += Character.getNumericValue(s2.charAt(l2));
                System.out.println("sss->"+sum);

                l2--;
            }
            sum += carry;
            carry = sum / 10;
            int op=sum%10;
//            System.out.println(op);
            sb.append(op);
            sum=0;
        }

        return sb.toString();
    }
}
