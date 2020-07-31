package cn.xpbootcamp.tennis;

public class Player {

    private String name;
    private int point;

    public Player(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void increasePoint() {
        this.point = this.point + 1;
    }

    public void clearPoint() {
        this.point = 0;
    }

    public void addPoint(int point) {
        this.point = this.point + point;
    }

    public String getName() {
        return name;
    }
}
