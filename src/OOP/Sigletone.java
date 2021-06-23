package OOP;

public class Sigletone {
    private static Sigletone inctance = new Sigletone("Oleg");
    private String name;

    private Sigletone getInctance(){
        return inctance;
    }
    public Sigletone (String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void PrintInfo (){
        System.out.println("name "+name);
    }

}
