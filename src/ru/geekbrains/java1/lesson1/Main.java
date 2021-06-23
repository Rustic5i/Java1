package ru.geekbrains.java1.lesson1;


import java.util.Random;
import java.util.Scanner;
public class Main {
    static final char HUMAN_DOT = 'X';
    static final char AI_DOT = '0';
    static char [][] map;
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(HUMAN_DOT)){
                System.out.println("Human is a winner");
                break;
            }
            if(isMapFull()){
                System.out.println("Draw");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(AI_DOT)){
                System.out.println("Human is a winner");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }
        System.out.println("GAME OVER");
    }

     public static boolean checkWin(char dot){
        if(map[0][0] == dot && map [0][1] == dot && map[0][2] == dot)
           return true;
         if(map[1][0] == dot && map [1][1] == dot && map[1][2] == dot)
           return true;
          if (map[2][0] == dot && map [2][1] == dot && map[2][2] == dot)
          return true;

           if (map[0][0] == dot && map [1][0] == dot && map[2][0] == dot)
            return true;
           if (map[0][1] == dot && map [1][1] == dot && map[2][1] == dot)
           return true;
           if (map[0][2] == dot && map [1][0] == dot && map[2][2] == dot)
            return true;

            if (map[0][0] == dot && map [1][1] == dot && map[2][2] == dot)
            return true;
           if (map[2][0] == dot && map [1][1] == dot && map[0][2] == dot)
           return true;


     return  false;

    }

    public static boolean isMapFull() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]=='*') ;
            }

        }
        return true;

    }
    public static void aiTurn(){
        int x, y;
        do {
            x = rnd.nextInt(3);
            y= rnd.nextInt(3);
        } while (!isCellEmpty(x,y));
        map[y][x] = AI_DOT;

    }



    public static boolean isCellEmpty (int x,int y){
        if (x < 0 || y < 0 || x > 2 || y >2){
            return false;
        }
        if (map[y][x] == '*')
            return true;
        return false;

    }
    public static void humanTurn (){

        int x = -1, y=-1;
        do {
            System.out.println("Введите ячейку x y");
             x = sc.nextInt()-1;
             y = sc.nextInt()-1;
        } while (!isCellEmpty(x,y));
        map [y][x] = HUMAN_DOT;

    }

    public static void printMap (){
        System.out.println("  1 2 3");
        for (int i = 0; i < map.length; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");

            }
            System.out.println();

        }
    }

    public static void initMap() {
        map = new char[3][3];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map [i][j]='*';


            }
            
        }

    }

}
