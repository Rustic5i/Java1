package javaLvl2.animal.dz.main;

public class Robocop implements Interface {
    private String name;
    private String type;
    private int maxSwim;
    private int maxJump;
    private int maxRun;

    public Robocop(String name) {
        this.name = name;
        type = "Robot";
        maxSwim = 0;
        maxJump = 10;
        maxRun = 2000;
    }

    @Override
    public void swim (int dist){
        if (dist>maxSwim){
            System.out.println(type+" "+name+" Не смог проплыть");
        }else System.out.println(type+" "+name+" Проплыл");
    }

    @Override
    public void run (int dist){
        if (dist>maxRun){
            System.out.println(type+" "+name+" Не смог пробежать");
        }else System.out.println(type+" "+name+" Пробежал");
    }

    @Override
    public void jump (int dist){
        if (dist>maxJump){
            System.out.println(type+" "+name+" Не смог перепрыгнуть");
        }else System.out.println(type+" "+name+" Перепрыгнул");
    }
}

