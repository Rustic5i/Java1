package javaLvl2.Pattern.Factory;

public class Program {
    public static void main(String[] args) {
       DeveloperFactory developerFactory = creatDeveloperBySpecialty("c++");
       Developer developer = developerFactory.createDeveloper();
       developer.writeCode();
    }
    static DeveloperFactory creatDeveloperBySpecialty(String specialry){
        if (specialry.equalsIgnoreCase("java")){
            return new JavaDeveloperFactory();
        }
        else if (specialry.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        }else {
            throw new RuntimeException(specialry+" ERROR: ");
        }
    }
}
