package JavMentor;
/*
Вам дан список ролей и сценарий пьесы в виде массива строчек.
Каждая строчка сценария пьесы дана в следующем виде:
Роль: текст
Текст может содержать любые символы.
Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового текста (см. пример). Каждая группа распечатывается в следующем виде:
Роль:
i) текст
j) текст2
...
==перевод строки==
i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует в соответствии с порядком ролей. Переводы строк между группами обязательны, переводы строк в конце текста не учитываются.
Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно, неправильная сборка результирующей строчки может выйти за ограничение по времени.
Sample Input:
roles:
Городничий
Аммос Федорович
Артемий Филиппович
Лука Лукич
textLines:
Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
Аммос Федорович: Как ревизор?
Артемий Филиппович: Как ревизор?
Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
Аммос Федорович: Вот те на!
Артемий Филиппович: Вот не было заботы, так подай!
Лука Лукич: Господи боже! еще и с секретным предписаньем!
Sample Output:
Городничий:
1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
Аммос Федорович:
2) Как ревизор?
5) Вот те на!
Артемий Филиппович:
3) Как ревизор?
6) Вот не было заботы, так подай!
Лука Лукич:
7) Господи боже! еще и с секретным предписаньем!
*/
public class RolesAndTexts {
    public static void main(String[] args) throws Exception {
        String[] roles = {"Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич",
                "Бобик"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole2(roles, textLines));
        //напишите тут ваш ко

//        Scanner sc = new Scanner(System.in);
//        int b = Integer.MAX_VALUE;
//        Integer b2 = Integer.MIN_VALUE;
//        while(sc.hasNextInt()){
//            int c = sc.nextInt();
//            if (c>b&&c<)
//            if(c < b){
//                b = c;
//                if (b>b2){
//                    b2=b;
//                }
//            }
//
//        }
//        System.out.println(b2);

    }


    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            st.append(roles[i]);
            st.append(":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i]+":")) {
                    st.append(j + 1);
                    st.append(")");
                    st.append(textLines[j].replaceAll(roles[i] + ": ", ""));
                    st.append("\n");
                }
            }
            st.append("\n");
        }
        return String.valueOf(st);
    }
    private static String printTextPerRole1(String[] roles, String[] textLines) { // это второй вариант решения.
        StringBuilder answer = new StringBuilder();
        for (String role : roles) {
            answer.append(role + ":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")) {
                    answer.append((i+1) + ")" + textLines[i].substring(role.length() + 1) + "\n");
                }
            }
            answer.append("\n");
        }
        return answer.toString();
    }
    public static String printTextPerRole2(String[] roles, String[] textLines) { //ПРАВИЛЬНО РЕШЕНИЕ ПОСЛЕ РЕВЬЮ
        //Замечание, убери канкатинацию строк.
        StringBuilder answer = new StringBuilder();
        for (String role : roles) {
            answer.append(role);
            answer.append(":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")) {
                    answer.append(i+1);
                    answer.append(")");
                    answer.append(textLines[i].substring(role.length() + 1));
                    answer.append("\n");
                }
            }
            answer.append("\n");
        }
        return answer.toString();
    }
}

