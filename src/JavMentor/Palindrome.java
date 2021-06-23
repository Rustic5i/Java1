package JavMentor;
//Урок с кодом
//        Реализуйте метод, проверяющий, является ли заданная строка палиндромом. Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая). При определении "палиндромности" строки должны учитываться только буквы и цифры. А пробелы, знаки препинания, а также регистр символов должны игнорироваться. Гарантируется, что в метод попадают только строки, состоящие из символов ASCII (цифры, латинские буквы, знаки препинания). Т.е. русских, китайских и прочих экзотических символов в строке не будет.
//        Для удаления из строки всех символов, не являющихся буквами и цифрами, можно воспользоваться регулярным выражением "[^a-zA-Z0-9]".Найдите в классе String метод, выполняющий замену по регулярному выражению и воспользуйтесь им.
//
//        Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
//
//        Пример ввода 1: Was it a cat I saw?
//        Пример вывода 1: true
//        Пример ввода 2: A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward, such as madam or racecar or the number 10801.
//        Пример вывода 2: false
//        Требования:
//        1. Должен быть доступный статический метод boolean isPalindrome(String text)
//        2. Работа метода должна удовлетворять условию
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Doc, Note: I Dissent. A Fast Never Prevents A Fatness. I Diet On Cod."));
    }
    public static boolean isPalindrome(String text) {
        String[] charString = text.split("\\?|,|-|!|’|\\.|:| ");
        String textString = String.join("", charString);
        StringBuilder stringBuilder = new StringBuilder(textString);
        stringBuilder.reverse();
        return textString.equalsIgnoreCase(String.valueOf(stringBuilder));
        //Твой код здесь
    }


}
