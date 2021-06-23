package javaLvl2.Pattern.AbstractFactory;

import javaLvl2.Pattern.AbstractFactory.Banking.BankingTeamFactory;

public class SuperBankSystem {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer developer =  projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("Работаем !!!!");
        developer.writeCode();
        tester.testCode();
        projectManager.managerProject();
    }
}
