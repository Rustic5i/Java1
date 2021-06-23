package javaLvl2.animal.oop_interface.main;

public class Team {
    private  String nameTeam;
    private Participant [] arrTeam;

    public Participant[] getArrTeam() {
        return arrTeam;
    }

    public Team(String nameTeam, Participant[] arrTeam) {
        this.nameTeam = nameTeam;
        this.arrTeam = arrTeam;
    }

    public void showInfo (){
        System.out.println("Команада "+nameTeam);
        for (int i = 0; i < arrTeam.length; i++) {
            arrTeam[i].info();
        }
    }
    public void showResults (){
        System.out.println("Команада "+nameTeam);
        for (int i = 0; i < arrTeam.length; i++) {
            if(arrTeam[i].isOnDistance()){
                arrTeam[i].printWin();
            }
        }
    }
}
