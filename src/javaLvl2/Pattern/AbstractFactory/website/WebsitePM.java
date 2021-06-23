package javaLvl2.Pattern.AbstractFactory.website;

import javaLvl2.Pattern.AbstractFactory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void managerProject() {
        System.out.println("WebsitePM упровляет проектом сайта");
    }
}
