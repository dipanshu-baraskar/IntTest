package dip;

public class MacBook {
    private Keyboard keyboard;
    private Mouse mouse;

    public MacBook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public void show(){
        System.out.println(keyboard.toString());
        System.out.println(mouse.toString());
    }
}
