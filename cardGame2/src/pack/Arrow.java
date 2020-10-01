package pack;

import java.awt.*;

public class Arrow {
    private Point start;
    private Point stop;
    private boolean enable;
    private int number;
    private Color color;
    private Point cardSize;

    public Arrow() {
        start = new Point(0,0);
        stop = new Point(0,0);
        enable = false;
        number = -1;
        color = Color.BLACK;
        cardSize = new Point(0,0);
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
            comp2D.setColor(color);
            comp2D.drawLine(start.x, start.y, stop.x, stop.y);

            if(color.equals(Color.BLACK))
            {
                comp2D.drawLine(stop.x - cardSize.x/4, stop.y - cardSize.x/4, stop.x + cardSize.x/4, stop.y + cardSize.x/4);
                comp2D.drawLine(stop.x - cardSize.x/4, stop.y + cardSize.x/4, stop.x + cardSize.x/4, stop.y - cardSize.x/4);
            }
            else if(color.equals(Color.RED))
            {
                comp2D.drawLine(stop.x - cardSize.x/2, stop.y - cardSize.y/2, stop.x + cardSize.x/2, stop.y + cardSize.y/2);
                comp2D.drawLine(stop.x - cardSize.x/2, stop.y + cardSize.y/2, stop.x + cardSize.x/2, stop.y - cardSize.y/2);
            }
            else
            {
                comp2D.drawLine(stop.x - 60, stop.y - 40, stop.x + 60, stop.y + 40);
                comp2D.drawLine(stop.x - 60, stop.y + 40, stop.x + 60, stop.y - 40);
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getCardSize() {
        return cardSize;
    }

    public void setCardSize(Point cardSize) {
        this.cardSize = cardSize;
    }
}
