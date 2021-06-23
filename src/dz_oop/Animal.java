package dz_oop;

public abstract class Animal {
    private String name;
    protected  int finalRun;
    protected int finalSwim;
    protected String tape;
    protected boolean onDistance = true;

    public Animal(String name){
        this.name = name;
    }

    public boolean isOnDistance(){
        return onDistance;
    }
    public String getName() {
        return name;
    }

    public void run (int l){

        if (finalRun >= l){
            System.out.println(getName()+" Прибежал дистанцию "+l);
        }else {
            onDistance = false;
            System.out.println(getName()+" Не смог пробежать дистанцию "+l);}
    }

    public void swim (int l){
        if (finalSwim == 0){
            onDistance = false;
            System.out.println(tape+ " "+name+" Не умеет плавать");
            return;
        }
        if (finalSwim >= l){
            System.out.println(getName()+" Проплыл дистанцию "+l);
        }else {
            onDistance = false;
            System.out.println(getName()+" Не смог проплыть дистанцию "+l);}
    }


}
