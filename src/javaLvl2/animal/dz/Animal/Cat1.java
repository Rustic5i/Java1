package javaLvl2.animal.dz.Animal;

public class Cat1 extends Animal {

    public Cat1(String name) {
        super(name, "Кот", 100,5,500); // super вызывает конструктор суперКласса
    }

    @Override
    public void run(int dist) {
    }
}
