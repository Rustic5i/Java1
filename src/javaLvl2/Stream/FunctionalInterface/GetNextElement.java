package javaLvl2.Stream.FunctionalInterface;
@FunctionalInterface
public interface GetNextElement {
    public int Get ();

    public boolean equals(Object o); // -> если сигнатура метода совподает с методами класса Object
                                   // такой интрефейс продолжает быть функциональным !!!
}
