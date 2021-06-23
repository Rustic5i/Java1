package ru.geekbrains.java1.lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class Fox {
    static Scanner in = new Scanner(System.in);
    static char[] charIgnor;
    static char [] chArray28;
    static char [] w;
    static int leng;
    static String myStr;

    public static void main(String[] args) {
      stringIncil();
      ignor();
      int chek = ChekWorld();
        int chekLeter = 0; // переменая для считчика букв. как перевернули слова ему нужно дать номер от куда начать считать количесво букв в слове
        int gdeZakochili = 0;
        for (int i = 0; i < chek ; i++) { // тут считает количество слов


            for (int j = 0; j < LengWord(chekLeter)  ; j++) { // тут считает количесво букв;
                for (int k = gdeZakochili; k < chArray28.length; k++) {
                    if (chArray28[k] ==  ' '){  // если мы если пробел, оставить его на месте
                            w[k] = chArray28[k];
                            gdeZakochili = k+1;
                            break;
                    }
                    if (Proverka(k) ){
                        //сюда зайдем если, то что пытаемся переместить игнорируемое
                    }
                    else {// тут перемещаем символ, но прежде нужно проверить, не затято ли там, куда мы перемещаем. если занято
                           // сместится на один и проверить занова.
                        int a =0;
                        for (int x = chekLeter+ LengWord(chekLeter); true; x--) {  // это цикл РАБОТАЕТ !!! // тут он заходит в метод и пробегая по массиву

                            if (Oop((chekLeter + LengWord(chekLeter) - a))) {
                                w[x-1] = chArray28[k];

                                break;
                            }
                            a++;
                        }
                    }

                }

                chekLeter = gdeZakochili;
                System.out.println(w);
                break;
            }

        }


    }

    public static boolean Oop (int x){
        x=x-1;
        for (int i = 0; i < chArray28.length; i++) {
            if (w[x]==chArray28[i]){
                return false;
            }

        }
        return true;
    }

    public static int ChekWorld (){ // узнаем количество слов
        int chek= 1;
        for (int i = 0; i < chArray28.length; i++) {
            if (chArray28[i]==' '){

                chek ++;
            }

        }

        return chek;
    }

    public static void stringIncil(){
        String name;
        String ignorWorld;

        System.out.print("Вееди текст: ");
        name = in.nextLine();

        System.out.println("Символы которые нужно игнорировать");
        ignorWorld = in.next();



        chArray28= name.toCharArray();
        charIgnor= ignorWorld.toCharArray();
        leng = chArray28.length;
        w = new char[leng+1];
        myStr = null;



    }


    public static int LengWord (int i) { // узнаем длину слова
        int intlengWord=0;
        if (chArray28[i]==' '){ i=i+1;} //усли ячейка уже пуста, начни считать со следующей
        for ( int x = 0+i; x < chArray28.length; x++) {
            if (chArray28[x] == ' '){


                return intlengWord;
            }
            intlengWord++;
        }


        return intlengWord;
    }
    public static boolean Proverka (int world ){ // проверяем значение которое хотим переместить на то что игнорируемре оно или нет.
        for (int i = 0; i < charIgnor.length; i++) {
            if ( charIgnor[i] == chArray28[world]){
                return true;
            }

        }
        return false;
    }

    public static void ignor (){  // заполняем игнорируемые символы
        for (int i = 0; i < charIgnor.length ; i++) {
            for (int j = 0; j < chArray28.length ; j++) {
                if (charIgnor[i]==chArray28[j]){
                    w[j]= chArray28[j];
                }
            }
        }
        for (int i = 0; i < chArray28.length; i++) {

            myStr = new String(w);
        }
        System.out.println(myStr);
    }

        }



