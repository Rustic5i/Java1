package OOP;

import OOP.animal.Animal;

public class Workman extends Animal {


    public Workman (String name, String post, int ega){
        this.name = name;
        this.post = post;

        this.ega = ega;
    }

    @Override
    public void voic (){ // ТАКОЙ МЕТОД НАЗЫВАЕТСЯ ПЕРЕОПРЕДЕЛЕНИЕ !!! ОВЕРРАЙД
        System.out.println("Мяу Мяу");// Тоесть перераспределяет метод класса родителя (Animal).
    }
    public  void run (int l){
        if (5 > l){
            System.out.println(name+"Прибежал дистанцию"+l);
        }
    }

}
