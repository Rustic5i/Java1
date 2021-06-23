package javaLvl2.linkList_Map_Set.dz;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        String [] array = {"Привет","ada", "Катя", "Вася","Привет","Света","Андрей","Петя","Андрей","Привет",
                "Андрей","Антон","Антон", "Женя", "Оля",
                "Руслан","Андрей","Петя","Андрей","Привет",
                "Андрей","Антон","Антон", "Женя", "Оля", "Руслан"};

        HashMap<String, Integer> counter = new HashMap<>();

        for (String n : array) {
            int cnt = 0;
            for (String s: array) {
                if (n.equals(s)){
                    counter.put(s,cnt++);
                }
            }

        }
        System.out.println(counter);

        for (String n: counter.keySet()) {
            if (counter.get(n)==0) System.out.print(n+", ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------------");
        /////////////////////////////////////////////////////////////////////////////

        HashMap<String, Integer> phnBook = new HashMap<>();
        phnBook.put("Rusl", 89375852);
        phnBook.put("Andru", 852);
        phnBook.put("Ola", 8);
        System.out.println(phnBook.get("Rusl"));

        System.out.println();
        System.out.println("----------------------------------------------------------------------");


        Phonebook phonebook = new Phonebook();
        phonebook.add("I","1111");
        phonebook.add("Вася","4444");
        phonebook.add("Петя","77778");
        phonebook.add("Петя","77777");
        phonebook.add("Петя","77779");
        phonebook.add("Вова","3333");
        System.out.println(phonebook.getBook("Петя"));

        Phonebook phonebook1 = new Phonebook();
        phonebook1.add("Иванов", "+79771122334");
        phonebook1.add("Иванов", "+79771122335");
        phonebook1.add("Иванов", "+79771122336");
        phonebook1.add("Смирнов", "+79772233445");
        phonebook1.add("Петров", "+79773344556");
        phonebook1.add("Ушаков", "+79774455667");
        phonebook1.add("Емлютин", "+79775566778");
        System.out.println(phonebook1.getBook("Иванов"));

    }
}
