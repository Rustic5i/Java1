package JavMentor.Exception.suppressedExceptions;

// стоит обратить внимание,
//         так это, что подавленные исключения работают только в блоке try,
//         в следующем примере будет сгенерировано два самостоятельных
//         и независимых друг от друга исключения:
//Даже, если в методе close() будет сгенерировано исключение
//        и оно добавится к подавленным исключения для блока try,
//        все они заменятся исключением, которое будет сгенерировано блоком finally.
public class Example_1 implements AutoCloseable{
    public static void main(String[] args){
        try(Example ex1 = new Example()){
            throw new RuntimeException("Exception try");
        } finally{
            throw new IllegalStateException("Exception finaly");
        }
    }

    @Override
    public void close(){
        System.out.println("close");
    }
}
