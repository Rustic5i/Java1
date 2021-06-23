package JavMentor.CommentsFilter;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;
    private Label label;
    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {//Обработать текст
        if (text.length() >= maxLength) return label.TOO_LONG;
        return label.OK;
    }
}
