package dip;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        Keyboard keyboard = new WiredKeyboard();
        Mouse mouse = new WirelessMouse();
        MacBook macBook = new MacBook(keyboard, mouse);
        macBook.show();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        output: [3, 2, 5, 4, 7, 6, 9, 8, 11, 10] using java8
        Function<Integer, Integer> check = x -> x % 2 == 0 ? x : x + 2;
        List<Integer> collect = list.stream().map(check).collect(Collectors.toList());
        System.out.println(collect);

        final List<Integer> ll = Arrays.asList(1, 2, 3, 4);

        System.out.println(ll);

    }
}
