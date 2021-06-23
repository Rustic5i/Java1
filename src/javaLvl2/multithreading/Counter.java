package javaLvl2.multithreading;

public class Counter {
    private int c;
    private Object object = new Object();

    public Counter() {
        c = 0;
    }

    public int getValue (){
       return c;
    }

    public synchronized void inc(){
        c++;
    }
    public synchronized void dec(){
        c--;
    }
    public void testCount(){
        System.out.println(Thread.currentThread().getName()+" ABS");
        synchronized (object){

        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" "+"START");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" "+"END");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }}
}
