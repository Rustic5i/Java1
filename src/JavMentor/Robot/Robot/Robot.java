package JavMentor.Robot.Robot;

public  class Robot {
    private int x = 15;
    private int y = 1;
    Direction dir;

    public Robot(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir; // текущее направление взгляда
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnRight() {
        if (dir == Direction.UP) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.LEFT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.UP;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.DOWN;
        } // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        if (dir == Direction.UP) {
            y++;
        }
        if (dir == Direction.DOWN) {
            y--;
        }
        if (dir == Direction.LEFT) {
            x--;
        }
        if (dir == Direction.RIGHT) {
            x++;
        }
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}
