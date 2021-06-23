package javaLvl2.animal.oop_interface.obstacles;

import javaLvl2.animal.oop_interface.main.Participant;

public class Cross extends Obstacles {
  private int distance;
    public Cross(int distance) {
        this.distance = distance;
    }



    public void doIt(Participant participant) {
        participant.run(distance);
    }
}
