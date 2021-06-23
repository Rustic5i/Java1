package javaLvl2.dz2_Exception;

public class Main {
    public static void main(String[] args) {
       // String [] st;
        String [] st = {"1","2","30","6"};
        try {

            array(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void array(String [] arry)throws Exception{
        int b = 0;
        if(arry.length == 4){
            for (int i = 0; i < arry.length; i++) {
                if (isDigit(arry[i]))
                b= b+Integer.parseInt(arry[i]);
                else {
                    throw new Exception(arry[i]+" Неявляеться цифрой");
                }
            }
            System.out.println(b);
        } else {
           throw new Exception ("Массив не подходит по размеру");
        }
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
