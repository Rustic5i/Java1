package dz_oop;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Cat1 c1 = new Cat1("Barsik");
        //Cat1 c2 = new Cat1("Oleg");
        //Dog1 d1 = new Dog1("Буги");
        //Dog1 d2 = new Dog1("Буги man");

        System.out.println("Введите дистанцию бега");
        int l = sc.nextInt();
        System.out.println("Введите дистанцию заплыва");
        int x = sc.nextInt();

        Animal[] arr = {new Cat("Barsik"),
                new Cat("Oleg"),
                new Dog("Буги"),
                new Dog("Буги man")};


        for (Animal a1: arr) {
            if (!a1.onDistance){ continue;} a1.run(l);
            if (!a1.onDistance){ continue; }a1.swim(x);
        }

        for (Animal a1: arr) {
            if (a1.isOnDistance()){
                System.out.println(a1.getName()+" Выйграл");
            }
        }
    }
}
