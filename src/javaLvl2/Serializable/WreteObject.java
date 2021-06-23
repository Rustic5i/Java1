package javaLvl2.Serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WreteObject {
    public static void main(String[] args) {
      //  Person person1 = new Person(1,"Popa");
      //  Person person2 = new Person(2,"Yasa");
        Person[] people =  {new Person(1,"Popa"),new Person(2,"Yasa"),new Person(3,"Katy")};

        try {
            FileOutputStream fos = new FileOutputStream("People.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(people);
           // oos.writeInt(people.length);
          //  for (Person person: people) {
            //    oos.writeObject(person);
           // }
        //    oos.writeObject(person1);
        //    oos.writeObject(person2);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
