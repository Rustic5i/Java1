package javaLvl2.animal.oop_interface.obstacles;

import javaLvl2.animal.oop_interface.main.Participant;

public class Water extends Obstacles{
    private int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Participant participant) {
        participant.swim(distance);
    }
}
