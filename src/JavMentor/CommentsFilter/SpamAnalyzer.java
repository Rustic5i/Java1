package JavMentor.CommentsFilter;

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords; //Массив из ключевых слов
   private Label label = Label.SPAM ;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }


    @Override
    protected  String[] getKeywords() { //Вернуть ключевое слово
        return keywords;
    }

    @Override
    protected  Label getLabel() { // Вернуть метку
        return label;
    }
}
