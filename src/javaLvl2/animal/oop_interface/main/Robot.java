package javaLvl2.animal.oop_interface.main;

public class Robot implements Participant {
    private String name;
    private int maxRus;
    private int maxJump;
    private boolean onDistance;


    public Robot(String name, int maxRus, int maxJump) {
        this.name = name;
        this.maxRus = maxRus;
        this.maxJump = maxJump;
        this.onDistance = true;
    }

    @Override
    public void jump(int height) {
        if (height <= maxJump){
            System.out.println("Robot "+name+ " Перепрыгнул");
        } else { System.out.println("Robot "+name+ " Не перепрыгнул");
            getOutFromDistance();}
    }
    @Override
    public void run (int dist){
        if (dist <= maxRus){
            System.out.println("Robot "+name+ " пробобежал");
        } else { System.out.println("Robot "+name+ " Не пробобежал");
            getOutFromDistance();}

    }
    @Override
    public void swim (int dist){
        if (dist == 0){System.out.println("Robot "+name+" Воды то и нет");
            return;}else
            System.out.println("Robot " +name+" Не умеет плавать");
            getOutFromDistance();

    }

    public void getOutFromDistance(){
        onDistance = false;
        System.out.println("Robot "+name+" Сошел с дистанции");
    }
    @Override
    public void printWin(){
        System.out.println("Robot "+name+" Прошел все!!!");
    }
    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info(){
        System.out.println("Robot "+ name);
    }
}
