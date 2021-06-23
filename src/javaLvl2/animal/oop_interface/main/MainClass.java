package javaLvl2.animal.oop_interface.main;

import javaLvl2.animal.oop_interface.animal.Cat;
import javaLvl2.animal.oop_interface.animal.Dog;
import javaLvl2.animal.oop_interface.obstacles.*;

public class MainClass {
    public static void main(String[] args) {

       Course course = new Course(new Obstacles[]{ new Cross(500),new Wall(4), new Water(20)});
Cat cat1 = new Cat("Barsik");
        Team team = new Team ("Команад-1",
                new Participant[]{
                new Robot("Chappy", 20000,300),
                new Cat("Viki"),
                new Dog("Bob"),
                new Cat("Barsic")});
        Team team2 = new Team ("Команад-2",
                new Participant[]{
                        new Robot("Chappy-2", 20000,300),
                        new Cat("Viki-2"),
                        new Dog("Bob-2"),
                        new Cat("Barsic-2")});

        course.doIt(team);
        course.doIt(team2);
        System.out.println("-----------------------------------------");
        team.showResults();
        team2.showResults();
    }
}
