package javaLvl2.multithreading;

public class Main {
    static int x;
    public static void main(String[] args) {

        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        m1.start(); // m1 и m2 запускаются выполняться метод run в классе MyThread паралельно
        m2.start();
        ///////////////////////////////////////////
        m1.run(); // если пишим выполнить просто run. То они просто запустяться последовательно, главным поком main
        m2.run();
        System.out.println(Thread.currentThread().getName());// Печатаем имя потока. Данный поток тут это поток main


        //////////////////////- через интерфейс Runnable----///////////////////////
        MyRunnable mr1 = new MyRunnable();
        MyRunnable mr2 = new MyRunnable(); // Создаем обьект MyRunnable
        Thread t1 = new Thread(m1); // И заворачиаем в поток Thread
        Thread t2 = new Thread(m2); // Тоесть мы потоку передаем обьект, который реализует метод run;

        t1.start();
        t2.start();
///////////////////////////////////////////                      ////////////////////////////////////////////////////////
/////////////////// Что б не создавать отдельные файлы с классами под эти задачи. Можно написать ананимный класс в Main1
/////////////////// Ананимный класс - это класс без имени

        new Thread(new Runnable() {  //Мы тут прям к конструкторе Tread`а, создали ананимный класс, который реализует интерфейс Runnable  и сразу же прописали метод run;
            @Override
            public void run() { // и сразу же прописали метод run;
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+" Казявки =>" +i);
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



        ////////////////////////////////  Обьявление простого класс My Class, /////////////////////////////////////////////////////////
///////////////////////////////// и таже запись ниже, только в виде ананимного класса ////////////////////////////////////////////////
        class  MyClass implements Runnable {
            @Override
            public void run() {

            }
        }

        new Thread(new MyClass()).start();

        /////////////////////////////  АНАНИМНЫЙ КЛАСС ////////////////////////////////////////////////////////////////

//Если нам всего один раз нужен будет этот класс, то с именем можно не заморачиваться, УБИРАЕМ ИМЯ
        new Thread(new Runnable() {  // По сколько мне от класса нужен интерфейс Runnable. Я могу написать new Runnable().
            @Override
            public void run() {  // И далее прям в конструкторе прописать метод run;

            }
        }).start();             //после скобочки ...).start();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    }

    static class Main2 {
        public static void main(String[] args) {

            Thread w1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    x++;
                }
            }
        });

            Thread w2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        x--;
                    }

                }
            });

            w1.start();
            w2.start();
            try {
                w1.join(); //Когда мы это написали тоесть join. Это означает что поток в котором мы написали, в данном случает это Main1 поток
                w2.join(); // main будет сидеть и ждать пока поток w1 закончит свою работу. когда w1 закончит. он передет ниже и будет ждать
                            // пока закончит поток w2.
            } catch (InterruptedException e) { // Защита от не предвиденого прерывание потока или остановки
                e.printStackTrace();
            }
            System.out.println("Выходи!!! подлый трус. "+x);

        }

    }

    static class Main3 {
        public static void main(String[] args) {
            Counter counter = new Counter();
            Counter counter1 = new Counter();
           Thread w1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        counter.inc();
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread w2 =  new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        counter.dec();
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            Thread w3 =  new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        counter.dec();
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread w4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        counter.inc();
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            w1.start();
            w2.start();
            w3.start();
            w4.start();
            try {
                w1.join();
                w2.join();
                w3.join();
                w4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Число : "+counter.getValue());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.testCount();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.testCount();
                }
            }).start();

        }
    }
}