package javaLvl2.animal.oop_interface.animal;

import javaLvl2.animal.oop_interface.main.Participant;

public class Animal implements Participant {
    protected  String name;
    protected String type;
    protected int maxRusDistance;
    protected int maxJumpHeight;
    protected int maxSwimDistance;
    protected boolean onDistance;

    public Animal (String name, String type, int maxJumpHeight, int maxRusDistance, int maxSwimDistance){
        this.name = name;
        this.type = type;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRusDistance = maxRusDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;

    }
@Override
    public void jump(int height) {
        if (height <= maxJumpHeight){
            System.out.println(type+ " "+name+ " Перепрыгнул");
        } else { System.out.println(type+ " "+name+ " Не перепрыгнул");
            getOutFromDistance();}
    }
    @Override
    public void run (int dist){
        if (dist <= maxRusDistance){
            System.out.println(type+ " "+name+ " пробобежал");
        } else { System.out.println(type+ " "+name+ " Не пробобежал");
            getOutFromDistance();}

    }
    @Override
    public void swim (int dist){
        if (dist == 0){System.out.println(type+" "+name+" Воды то и нет");
        return;}
        if (maxSwimDistance == 0){
            System.out.println(type+ " " +name+" Не умеет плавать");
            getOutFromDistance();
            return;
        }
        if ( dist <= maxSwimDistance){
            System.out.println(type+ " "+name+ " Проплыл");
        } else { System.out.println(type+ " "+name+ " Не проплыл");
            getOutFromDistance();}
    }

    public void getOutFromDistance(){
        onDistance = false;
        System.out.println(type+ " "+name+" Сошел с дистанции");
    }
    public void printWin(){
        System.out.println(type+ " "+name+" Прошел все!!!");
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void info(){
        System.out.println(type+ " "+name);
    }
}
