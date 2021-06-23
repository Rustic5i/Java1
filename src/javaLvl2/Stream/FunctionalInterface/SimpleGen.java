package javaLvl2.Stream.FunctionalInterface;

import java.util.List;

public class SimpleGen {
    private int number;

    public SimpleGen(int number) {
        super();
        this.number = number;
    }
    public SimpleGen(){
        super();
    }

    public int getNumber() {
        int temp = number;
        number = number +1;
        return temp;
    }

    public static int getRandomNumber (){
        return (int) (Math.random()*10);
    }
    public boolean rest (String e){
        return e.length() >5;
    }
}
