package OOP.animal;

public abstract class   Animal {
    protected   String name;
    protected   int age;
    protected   String color;
    public static int catCounter;
    protected String post;

    public int ega;

    public void PrintInfo (){
        System.out.println("name "+name+" age "+age+" color "+color);
    }
    public void FilterMan (){
        if (ega > 40){
            System.out.println(name);
        }
    }

    public static int add (int a, int b, int c, int d){ // Эти методы называются ПЕРЕГРУЗКА - овелорд
        return a+b+c+d;
    }
    public static int add (int a, int b, int c){
        return a+b+c;
    }
    public static int add (int a){
        return a;
    }
    public static int add (int a, int b, int c, double d){
        return (int) (a+b+c+d);
    }


    public abstract void voic (); // ТАКОЙ МЕТОД НАЗЫВАЕТСЯ ПЕРЕОПРЕДЕЛЕНИЕ !!! ОВЕРРАЙД
    // abstract это значит переопредели этот метод в классах потомках
        // если есть хоть один абсрактный метод, то мы должны определить весб класс как абстрактный
    // и обязательно во всех классах переопределить
}
