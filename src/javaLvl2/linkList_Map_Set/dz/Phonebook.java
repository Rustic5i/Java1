package javaLvl2.linkList_Map_Set.dz;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class Phonebook {
   private HashMap<String, LinkedHashSet<String>> book; // LinkedHashSet поможет боротся с дубликатами. В LinkedHashSet не могут быть дубликатов

   public Phonebook() {
       book = new HashMap<>();
    }

    public void add (String name, String phone){
       if (!book.containsKey(name)) // если там такого ключа нету то
           book.put(name, new LinkedHashSet<>()); // то в карту добавляем имя и добавляем туда ArrayList
           book.get(name).add(phone); //И в LinkedHashSet добовляем номер телефона
    }

    public LinkedHashSet<String> getBook(String name) {
        return book.get(name);
    }
}
