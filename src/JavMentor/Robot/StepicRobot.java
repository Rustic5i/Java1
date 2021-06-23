package JavMentor.Robot;

import JavMentor.Robot.Robot.Direction;
import JavMentor.Robot.Robot.Robot;

//На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y. Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)
//        В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз, направо или налево. Ваша задача — привести робота в заданную точку игрового поля.
//        Робот описывается классом Robot.
//
//        Вы можете пользоваться следующими его методами (реализация вам неизвестна):
//
//public class Robot {
//    public Direction getDirection() {         // текущее направление взгляда     }
//        public int getX() {         // текущая координата X     }
//            public int getY() {         // текущая координата Y     }
//                public void turnLeft() {         // повернуться на 90 градусов против часовой стрелки     }
//                    public void turnRight() {         // повернуться на 90 градусов по часовой стрелке     }
//                        public void stepForward() {
//// шаг в направлении взгляда
//// за один шаг робот изменяет одну свою координату на единицу     } }
//                            Direction, направление взгляда робота,  — это перечисление:
//                            public enum Direction {     UP,     DOWN,     LEFT,     RIGHT }
//                            Как это выглядит:
//
//                            alt text
//
//                            Пример  В метод передано: toX == 3, toY == 0;
//                            начальное состояние робота такое: robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP
//                            Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
//                            robot.turnRight();
//                            robot.stepForward();
//                            robot.stepForward();
//                            robot.stepForward();
//                            P.S. Если вам понравилось это задание, то вам может прийтись по душе игра
//                            Robocode, в которой надо написать алгоритм управления танком.
//                            Алгоритмы, написанные разными людьми, соревнуются между собой.
public class StepicRobot {
    public static void main(String[] args) {
        Robot robot = new Robot(5, -10, Direction.DOWN);
        moveRobot(robot, 1, 20);
        System.out.println(robot.getX()+" "+ robot.getY());
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        //1)Узнаем самый большой вектор напровления и устремляем туда взгляд
        int distanceX = toX-robot.getX();
        int distanceY = toY- robot.getY();
        String myDirection;
        while (true) {
            if (!(distanceX == 0) && (distanceX < 0)) { //если условие верное то разворот на ЛЕВО
                myDirection = "LEFT";
                turnTheRobot(robot, myDirection);
                stepRobot(distanceX, robot);
                distanceX=0;
            } else if ((distanceX == 0) && (distanceY < 0)) { // если по X= 0 то значит передвигаем только по Y вниз
                myDirection = "DOWN";
                turnTheRobot(robot, myDirection);
                stepRobot(distanceY, robot);
            } else if ((distanceX == 0) && (distanceY > 0)) { // по Y Вверх
                myDirection = "UP";
                turnTheRobot(robot, myDirection);
                stepRobot(distanceY, robot);
                distanceY=0;
            } else if (!(toX == robot.getX())&&(!(distanceX == 0) && (distanceX > 0))) { // По X ВПРАВА
                myDirection = "RIGHT";
                turnTheRobot(robot, myDirection);
                stepRobot(distanceX, robot);
                distanceX = 0;
            }
            if ((toX== robot.getX()) && (toY == robot.getY())){
                return;
            }
        }
    }
    public static void turnTheRobot(Robot robot, String myDirection){
        while (true){
            robot.turnRight();
            if (myDirection.equals(robot.getDirection().toString())){
                return;
            }
        }
    }
    public static void stepRobot(int distance, Robot robot){
        for (int i = 0; i < Math.abs(distance); i++) {
            robot.stepForward();
        }
    }

}
