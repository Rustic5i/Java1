package javaLvl2.Pattern.AbstractFactory.website;

import javaLvl2.Pattern.AbstractFactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php разработчик пишет код");
    }
}
