package javaLvl2.animal.dz.main;


import javaLvl2.animal.dz.Animal.Cat1;
import javaLvl2.animal.dz.Animal.Dog1;

public class Main {
    public static void main(String[] args) {
        Cat1 cat1 = new Cat1("Barsik");
        Dog1 dog1 = new Dog1 ("Bobik");
        Robocop robocop = new Robocop("Чудо");
        cat1.swim(100);
        cat1.jump(5);
        cat1.run(500);
        dog1.swim(600);
        dog1.jump(5);
        dog1.run(500);

        robocop.swim(100);
        robocop.jump(5);
        robocop.run(500);
    }
}
