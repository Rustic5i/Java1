package JavMentor.Exception.tryWithResourcesAutoCloseable;
//нужно имплементить интерфейс AutoCloseable и переопределить метод close
//И тогда в try(){ будет автоматический вызывать метод close().
public class Main {
    public static void main(String[] args) {
        try (Car car = new Car()) {
            car.drive();
        } catch (Exception e) {
            //ignore
        }
    }

    public static class Car implements AutoCloseable { //нужно имплементить интерфейс AutoCloseable и переопределить метод close
                                                      //И тогда в try(){ будет автоматический вызывать метод close().
        @Override
        public void close() throws Exception {
            System.out.println("Машина закрывается...");
        }
        public void drive() {
            System.out.println("Машина поехала.");
        }
    }
}
