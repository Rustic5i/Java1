package javaLvl2.Pattern.AbstractFactory.Banking;

import javaLvl2.Pattern.AbstractFactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void managerProject() {
        System.out.println("BankingPM упровляет проектом банка");
    }
}
