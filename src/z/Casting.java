package z;

class Parent {
    int a = 1;

    Parent() {
        System.out.println("Parent cons");
    }

    public void test() {
        System.out.println("Patent Method");
    }
}

class Child extends Parent {
    int a = 2;

    Child() {
        System.out.println("Clhild cons");
    }

    public void test() {
        super.test();
        System.out.println("Clild Method");
    }
}

public class Casting {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();
        p.test();
        c.test();
        System.out.println(p.a);
        System.out.println(c.a);
    }
}
