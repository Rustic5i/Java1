package javaLvl2.animal.dz.Animal;

import javaLvl2.animal.dz.main.Interface;

public class Animal implements Interface {
    private String name;
    private String type;
    private int maxSwim;
    private int maxJump;
    private int maxRun;
    private boolean Flag;


    public Animal(String name, String type, int maxSwim, int maxJump, int maxRun) {
        this.name = name;
        this.type = type;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        Flag = true;
    }

    public void swim (int dist){
        if (dist>maxSwim){
            System.out.println(type+" "+name+" Не смог проплыть");
        }else System.out.println(type+" "+name+" Проплыл");
    }
    public void run (int dist){
        if (dist>maxRun){
            System.out.println(type+" "+name+" Не смог пробежать");
        }else System.out.println(type+" "+name+" Пробежал");
    }
    public void jump (int dist){
        if (dist>maxJump){
            System.out.println(type+" "+name+" Не смог перепрыгнуть");
        }else System.out.println(type+" "+name+" Перепрыгнул");
    }
}
