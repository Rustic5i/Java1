package OOP;

import OOP.animal.Animal;

public class Cat extends Animal {

    public Cat(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
        catCounter++;
    }
    public Cat(String barsik) {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void Jump (){
        System.out.println(name+" jump");
    }
    public Cat (Cat c){
        this.name = c.getName();
        this.color = c.getColor();
        this.age = c.getAge();
    }

    @Override
    public void voic (){ // ТАКОЙ МЕТОД НАЗЫВАЕТСЯ ПЕРЕОПРЕДЕЛЕНИЕ !!! ОВЕРРАЙД
        System.out.println("Мяу Мяу");// Тоесть перераспределяет метод класса родителя (Animal).
    }

}
