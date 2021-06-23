package ru.geekbrains.java1.lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class MyGame {
    static int [][] map;
    static Scanner sc = new Scanner(System.in);
    static final int HUMAN_DOT = 1;
    static int [][] lvl;

    public static void main(String[] args) {
        initMap();
      //  initLvl();
        do {
            initLvl();
            printMap();
            Scan();
        }while (Sravnenie()==false);
            System.out.println("Вы выйграли");
        printMap();
    }

    public static boolean Sravnenie (){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int var1;
                var1 =map[i][j];
                int var2;
                var2 = lvl[i][j];
                if (var1 != var2){
                    return false;

                }

            }
            //return true;

        }
            return true;
    }

    public static void initLvl (){
        lvl = new int[][] {{0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,2,0,0,0},
            {0,0,2,1,2,0,0},
            {0,0,0,2,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}};


            System.out.println("  1 2 3 4 5 6 7 ");
            for (int i = 0; i < lvl.length; i++) {

                System.out.print((i+1)+" ");
                for (int j = 0; j < lvl[i].length; j++) {

                    System.out.print(lvl[i][j]+" ");

                }
                System.out.println();

            }
        }



    public static void vverh (int x, int y) {
        x=x-1;
        if (x>=0 && y>=0 && x<=6 && y<=6){
            if (map[x][y]>0) {
                if (map[x][y]<4){
                for (int i = 0; i <=4 ; i++) {
                    if (i>map[x][y]){
                        map[x][y] = i;
                        break;
                    }
                }
                }else { map[x][y]=1;}
            }
        }

    }
    public static void levo (int x, int y) {
        y=y-1;
        if (x>=0 && y>=0 && x<=6 && y<=6){
            if (map[x][y]>0) {
                if (map[x][y]<4){
                    for (int i = 0; i <=4 ; i++) {
                        if (i>map[x][y]){
                            map[x][y] = i;
                            break;
                        }
                    }
                }else { map[x][y=y-1]=1;}
            }
        }

    }

    public static void pravo (int x, int y) {
        y=y+1;
        if (x>=0 && y>=0 && x<=6 && y<=6){
            if (map[x][y]>0) {
                if (map[x][y]<4){
                    for (int i = 0; i <=4 ; i++) {
                        if (i>map[x][y]){
                            map[x][y] = i;
                            break;
                        }
                    }
                }else { map[x][y]=1;}
            }
        }

    }

    public static void niz (int x, int y) {
        x=x+1;
        if (x>=0 && y>=0 && x<=6 && y<=6){
            if (map[x][y]>0) {
                if (map[x][y]<4){
                    for (int i = 0; i <=4 ; i++) {
                        if (i>map[x][y]){
                            map[x][y] = i;
                            break;
                        }
                    }
                }else { map[x][y]=1;}
            }
        }

    }


    public static boolean wow1 (int x, int y ){
        if(x > 6 || y >6 || x < 0 || y < 0) return false;
        if (map[x][y] != 0) return false;
        return true;

    }

    public static void Scan (){
        int x = 0, y= 0;
          do {

            System.out.println("Введите ячейку x y");
             x = sc.nextInt() -1;
            y = sc.nextInt() -1;

          }
          while (!wow1(x,y));// проверку на не правильный ввод
            map [x][y] = HUMAN_DOT;
            vverh(x,y);
            levo(x,y);
            pravo(x,y);
            niz(x,y);

    }
    public static void printMap(){
        System.out.println("  1 2 3 4 5 6 7 ");
        for (int i = 0; i < map.length; i++) {

            System.out.print((i+1)+" ");
            for (int j = 0; j < map[i].length; j++) {

                System.out.print(map[i][j]+" ");

            }
            System.out.println();

        }
    }
   public static void initMap (){
    map = new int[7][7];
       for (int i = 0; i < map.length; i++) {
           for (int j = 0; j < map[i].length; j++) {
               map[i][j]=0;

           }

       }
}
}
