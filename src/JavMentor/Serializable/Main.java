package JavMentor.Serializable;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        byte[] data = {-1};
        deserializeAnimalArray(data);

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        int animalCount = 0;
        Animal[] animals = null;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            animalCount = ois.readInt();
            animals = new Animal[animalCount];
            for (int i = 0; i < animalCount; i++) {
                animals[i] = (Animal) ois.readObject();
            }
        } catch (Exception e2) {
            throw new IllegalArgumentException();
        }
        return animals;
    }
}
