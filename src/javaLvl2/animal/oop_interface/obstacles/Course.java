package javaLvl2.animal.oop_interface.obstacles;

import javaLvl2.animal.oop_interface.main.Team;

public class Course {
    private Obstacles [] obstacles;

    public Course(Obstacles[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team){
     for (int i = 0; i < team.getArrTeam().length; i++) {
        for (int j = 0; j < obstacles.length; j++) {
            obstacles[j].doIt(team.getArrTeam()[i]);
            if (!team.getArrTeam()[i].isOnDistance()){
                break;
            }
        }

    }
    }
}
