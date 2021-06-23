package javaLvl2.Pattern.AbstractFactory.Banking;

import javaLvl2.Pattern.AbstractFactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java разработчик пишет код....");
    }
}
