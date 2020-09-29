package pack;

import java.awt.*;

public class Arrow {
    private Point start;
    private Point stop;
    private boolean enable;
    private int number;

    public Arrow() {
        start = new Point(0,0);
        stop = new Point(0,0);
        enable = false;
        number = -1;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setStart(int x, int y) {
        this.start.x = x;
        this.start.y = y;
    }

    public void setStart(CardInterface card) {
        this.start.x = card.getPoint().x+card.getSize().x/2;
        this.start.y = card.getPoint().y+card.getSize().y/2;
    }

    public Point getStop() {
        return stop;
    }

    public void setStop(Point stop) {
        this.stop = stop;
    }

    public void setStop(int x, int y) {
        this.stop.x = x;
        this.stop.y = y;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void paint(Graphics2D comp2D)
    {
        if(enable) {
            comp2D.drawLine(start.x, start.y, stop.x, stop.y);
        }
    }
}
