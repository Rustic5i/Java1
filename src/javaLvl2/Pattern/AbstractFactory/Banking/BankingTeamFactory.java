package javaLvl2.Pattern.AbstractFactory.Banking;

import javaLvl2.Pattern.AbstractFactory.Developer;
import javaLvl2.Pattern.AbstractFactory.ProjectManager;
import javaLvl2.Pattern.AbstractFactory.ProjectTeamFactory;
import javaLvl2.Pattern.AbstractFactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
