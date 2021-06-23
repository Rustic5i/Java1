package javaLvl2.linkList_Map_Set;

public class Box {
   private int size;

    public Box(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) { //Переопределяем наследуемый метод от Обжикт, метод equals. По умолчанию метод equals сравнивает как бы ссылки. а нам нужносравнить чесло size
        if (o instanceof Box) {
            Box another = (Box)o;
            if (this.size == another.size) return true;

        }
        return false;
    }

}
