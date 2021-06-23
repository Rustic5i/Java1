package javaLvl2.Pattern.AbstractFactory.website;

import javaLvl2.Pattern.AbstractFactory.Developer;
import javaLvl2.Pattern.AbstractFactory.ProjectManager;
import javaLvl2.Pattern.AbstractFactory.ProjectTeamFactory;
import javaLvl2.Pattern.AbstractFactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}
