package Lvl3.Generics.Box;

public class Main {
    


    public static void main(String[] args) {
        Box box = new Box(new Apple(),16);
        Box box1 = new Box(new Orange(),10);
        System.out.println(box.compare(box1));
    }

}
