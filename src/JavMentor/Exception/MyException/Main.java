package JavMentor.Exception.MyException;

public class Main {
    public static void main(String[] args) {
        try {
            testExp();
        } catch (MyNewException e) {
            e.printStackTrace();
        }
    }
    public static void testExp() throws MyNewException {
            throw new MyNewException();
    }

}
