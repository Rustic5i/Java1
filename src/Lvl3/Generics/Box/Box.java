package Lvl3.Generics.Box;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> arrayFruit = new ArrayList<>();

    public Box(T fruit, int counter) {
        for (int i = 0; i < counter; i++) {
            arrayFruit.add(i,fruit);
        }

    }

    public double getWeight (){
        double weightFruit = 0;
        for (T e: arrayFruit) {
            weightFruit = weightFruit +e.getWEIGHT();
        }
        return weightFruit;
    }
    public boolean compare(Box box){
        if (box.getWeight()== this.getWeight()) return true;
        return false;
    }
}
