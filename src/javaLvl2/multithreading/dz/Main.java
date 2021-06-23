package javaLvl2.multithreading.dz;

public class Main {
    final int SIZE = 100000000;

    public static void main(String[] args) {
        final int SIZE = 100000000;
        float [] arr = new float[SIZE];

        System.out.println("Метод 1 заполняем '1'");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
         //   System.out.print( +arr[i]+", ");
        }
      //  System.out.println();
        System.out.println("Метод 2 высчитываем новые значение:");
        long time = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) { //тут будет бегать 10 раз
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
         //   System.out.print(arr[i]+", ");
        }
      //  System.out.println("");
        System.out.print("Время выполнения: ");
        System.out.println(System.currentTimeMillis() - time);





        //  System.arraycopy(from, fromIndex, to, toIndex, count);
      //  from - массив, который копируем
       // to - массив в которой копируем
       // fromIndex - индекс в массиве from начиная с которого берем элементы для копирования
       // toIndex - индекс в массиве to начиная с которого вставляем элементы
       // count - количество элементов которые берем из массива from и вставляем в массив to
       // Массив to должен иметь достаточный размер, чтобы в нем уместились все копируемые элементы.
    }


}

class Main1 {
    public static void main(String[] args) {
        final int SIZE = 100000000;
        float [] arr = new float[SIZE];

        System.out.println("Метод 1 заполняем '1'");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
           // System.out.print(arr[i]+", ");
        }
       // System.out.println();
        float[] arr1 = new float[SIZE/2];
        float[] arr2 = new float[SIZE/2];
        long time = System.currentTimeMillis();
        System.arraycopy(arr,0,arr1,0,SIZE/2);
        System.arraycopy(arr,SIZE/2,arr2,0,SIZE/2);

        for (int i = 0; i < arr1.length; i++) {
           // System.out.print(arr1[i]+", ");
        }
      //  System.out.println();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                 //   System.out.print(arr1[i]+", ");
                }
                System.out.println();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                  //  System.out.print(arr2[i]+", ");
                }
               // System.out.println();
            }

        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // System.out.println();
        System.arraycopy(arr1,0,arr,0,SIZE/2);
        System.arraycopy(arr2,0,arr,SIZE/2,SIZE/2);
        for (int i = 0; i < arr.length; i++) {
           // System.out.print(arr[i]+", ");
        }
       // System.out.println();
        System.out.println("Время двух поточности: "+(System.currentTimeMillis() - time));
    }
}
