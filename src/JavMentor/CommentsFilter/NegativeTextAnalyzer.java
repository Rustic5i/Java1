package JavMentor.CommentsFilter;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private final String[] KEYWORDS  = {":(","=(",":|"};
    private final Label LAMBER = Label.NEGATIVE_TEXT;

    @Override
    protected String[] getKeywords() {
        return KEYWORDS ;
    }

    @Override
    protected  Label getLabel() {// Вернуть метку
        return LAMBER;
    }
}
