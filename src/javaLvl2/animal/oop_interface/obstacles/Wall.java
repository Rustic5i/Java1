package javaLvl2.animal.oop_interface.obstacles;

import javaLvl2.animal.oop_interface.main.Participant;

public class Wall extends Obstacles {
    private int heght;

    public Wall(int heght) {
        this.heght = heght;
    }

    @Override
    public void doIt(Participant participant) {
        participant.jump(heght);
    }

}
