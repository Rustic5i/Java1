package JavMentor.Robot.Robot;

import JavMentor.Robot.RobotConnectionException;

public class MyRobot  {
    private boolean conException;
    private boolean closException;
    private boolean moveException;

    public MyRobot(boolean conException, boolean closException, boolean moveException) {
        this.conException = conException;
        this.closException = closException;
        this.moveException = moveException;
    }

    public void getConnection() {
        if (conException ==false){
            System.out.println("Error: Ошибка подключения");
            throw new RobotConnectionException("Error: Ошибка подключения");
        }
        System.out.println("Соединились!!!");
    }
    public void close(){
        if (closException == false){
            System.out.println("Error: Ошибка закрытия соединения");
            throw new RobotConnectionException("Error: Ошибка закрытия соединения");
        }
        System.out.println("Закрыли соединение!!!");
    }
    public void moveRobotTo() {
        if (moveException == false&& closException == true){
            System.out.println("Erorr: Ошибка хода");
           // throw new Throwable();
            throw new RobotConnectionException("");
        }
        System.out.println("Робот сходил");
    }
}
