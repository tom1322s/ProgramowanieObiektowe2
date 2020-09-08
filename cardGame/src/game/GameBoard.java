package game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

public class GameBoard extends JPanel {


    public Player myPlayer = new Player();
    public Player enemy = new Player();

    public static final int HAND_CARD_X_PROPORTION = 10;
    public static final int CARD_X_PROPORTION = 10;


    public void paintComponent(Graphics comp)
    {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;



        paintBases(comp2D);

        paintHandCards(comp2D);

        paintCards(comp2D);


    }

    public void paintBases(Graphics2D comp2D)
    {
        comp2D.setColor(Color.pink);
        comp2D.fillRect(0,0,getWidth(),getHeight());

        comp2D.setColor(Color.BLACK);
        comp2D.setStroke(new BasicStroke((int)(0.01*getHeight()),BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND));
        //Line2D.Float line = new Line2D.Float(60F,5F,13F,28F);
        //comp2D.draw(line);
        /*comp2D.drawLine((int)(0.15*getHeight())+(int)(0.05*getWidth()),(int)(0.05*getHeight()),getWidth()-((int)(0.25*getHeight())+(int)(0.05*getWidth())),(int)(0.05*getHeight()));
        comp2D.drawLine((int)(0.15*getHeight())+(int)(0.05*getWidth()),getHeight()-(int)(0.05*getHeight()),getWidth()-((int)(0.25*getHeight())+(int)(0.05*getWidth())),getHeight()-(int)(0.05*getHeight()));*/

        GeneralPath polly = new GeneralPath();
        polly.moveTo(0.2*getHeight()+0.03*getWidth(),0.05*getHeight());
        polly.lineTo(getWidth()-(0.3*getHeight()+0.03*getWidth()),0.05*getHeight());
        polly.lineTo(getWidth()-(0.3*getHeight()+0.03*getWidth()),0.2*getHeight());
        polly.lineTo(getWidth()-0.03*getWidth(),0.2*getHeight());


        polly.lineTo(getWidth()-0.03*getWidth(),getHeight()-0.2*getHeight());
        polly.lineTo(getWidth()-(0.3*getHeight()+0.03*getWidth()),getHeight()-0.2*getHeight());
        polly.lineTo(getWidth()-(0.3*getHeight()+0.03*getWidth()),getHeight()-0.05*getHeight());
        polly.lineTo(0.2*getHeight()+0.03*getWidth(),getHeight()-0.05*getHeight());

        polly.curveTo(0.2*getHeight()+0.03*getWidth(),getHeight()-0.05*getHeight(),0.2*getHeight()+0.03*getWidth(),getHeight()-(0.05*getHeight()+0.2*getHeight()),0.03*getWidth(),getHeight()-0.25*getHeight());
        polly.lineTo(0.03*getWidth(),0.25*getHeight());
        polly.curveTo(0.03*getWidth(),0.25*getHeight(),0.2*getHeight()+0.03*getWidth(),0.05*getHeight()+0.2*getHeight(),0.2*getHeight()+0.03*getWidth(),0.05*getHeight());
        polly.closePath();
        comp2D.draw(polly);

        comp2D.setColor(Color.BLUE);
        comp2D.fillRect((int)(getWidth()-(0.29*getHeight()+0.03*getWidth())),(int)(0.05*getHeight()),(int)(0.29*getHeight()),(int)(0.14*getHeight()));
        comp2D.fillRect((int)(getWidth()-(0.29*getHeight()+0.03*getWidth())),(int)(getHeight()-(0.135*getHeight()+0.05*getHeight())),(int)(0.29*getHeight()),(int)(0.14*getHeight()));

        comp2D.fillOval((int)(-0.05*getHeight()+0.03*getWidth()),(int)(0.02*getHeight()),(int)(0.2*getHeight()),(int)(0.2*getHeight()));
        comp2D.fillOval((int)(-0.05*getHeight()+0.03*getWidth()),(int)(getHeight()-0.22*getHeight()),(int)(0.2*getHeight()),(int)(0.2*getHeight()));

        comp2D.setColor(Color.BLACK);
        comp2D.setFont(new Font("Arial Narrow",Font.BOLD,(int)(0.15*getHeight())));
        comp2D.drawString(String.valueOf(enemy.getMana()),(int)(0.02*getHeight()+0.03*getWidth()),(int)(0.17*getHeight()));
        comp2D.drawString(String.valueOf(myPlayer.getMana()),(int)(0.02*getHeight()+0.03*getWidth()),(int)(getHeight()-0.07*getHeight()));
    }

    public void paintHandCards(Graphics2D comp2D)
    {
        int maxHandRectSizeX = (int)(0.5 * getWidth());
        int maxHandRectSizeY = (int)(0.2 * getHeight());
        comp2D.setColor(Color.RED);
        //comp2D.fillRect((int)(0.5*getWidth()-(0.5*maxHandRectSizeX)),(int)(getHeight()-(0.02*getHeight()+maxHandRectSizeY)),maxHandRectSizeX,maxHandRectSizeY);

        int spaceX = maxHandRectSizeX/(Player.MAX_HAND_CARDS*(HAND_CARD_X_PROPORTION+1)-1);
        int cardSizeX = spaceX*HAND_CARD_X_PROPORTION;
        int cardSizeY = maxHandRectSizeY;
        int cardsX = (int)(0.5*getWidth()-(0.5*maxHandRectSizeX));
        int cardsY = (int)(getHeight()-(0.02*getHeight()+maxHandRectSizeY));
        int enemyCardsY = (int)(0.02*getHeight());

        for(int i = 0; i < myPlayer.handCards.size(); i++)
        {
            paintCard(comp2D, myPlayer.handCards.get(i),cardsX + i * spaceX + i *cardSizeX,cardsY,cardSizeX,cardSizeY);
        }

        comp2D.setColor(Color.BLUE);
        for(int i = 0; i < enemy.handCards.size(); i++)
        {
            comp2D.fillRect(cardsX + i * spaceX + i *cardSizeX,enemyCardsY,cardSizeX,cardSizeY);
        }
    }

    public void paintCard(Graphics2D comp2D,CardInterface card, int x, int y, int sizeX, int sizeY)
    {
        comp2D.setColor(Color.RED);
        comp2D.fillRect(x,y,sizeX,sizeY);

        Font f = new Font("Dialog", Font.BOLD,(int)(0.12*sizeY));
        comp2D.setFont(f);
        comp2D.setColor(Color.BLACK);

        comp2D.drawString(Integer.toString(card.getCost()),(int) (x+0.1*sizeX),(int) (y+0.1*sizeY));
        comp2D.drawString(card.getName(),(int) (x+0.3*sizeX),(int) (y+0.1*sizeY));

        Font f2 = new Font("Dialog", Font.BOLD,(int)(0.08*sizeY));
        comp2D.setFont(f2);

        comp2D.drawString("AD: " + Integer.toString(card.getAttackDamage()),(int) (x+0.1*sizeX),(int) (y+0.23*sizeY));
        comp2D.drawString("MD: " + Integer.toString(card.getMagicDamage()),(int) (x+0.1*sizeX),(int) (y+0.31*sizeY));
        comp2D.drawString("H: " + Integer.toString(card.getHealth()),(int) (x+0.1*sizeX),(int) (y+0.39*sizeY));
        comp2D.drawString("A: " + Double.toString(card.getArmor()),(int) (x+0.1*sizeX),(int) (y+0.47*sizeY));
        comp2D.drawString("MR: " + Double.toString(card.getMagicResistance()),(int) (x+0.1*sizeX),(int) (y+0.55*sizeY));

        Font f3 = new Font("Dialog", Font.PLAIN,(int)(0.08*sizeY));
        comp2D.setFont(f3);

        comp2D.drawString(card.getDescription(),(int) (x+0.1*sizeX),(int) (y+0.65*sizeY));

    }

    public void paintCards(Graphics2D comp2D)
    {
        int numberOfCardsOnBoard = myPlayer.cards.size();
        int numberOfCardsOnBoardEnemy = enemy.cards.size();
        int maxHandRectSizeX = (int)(0.8 * getWidth());
        int maxHandRectSizeY = (int)(0.23 * getHeight());
        comp2D.setColor(Color.GREEN);
        comp2D.fillRect((int)(0.5*getWidth()-(0.5*maxHandRectSizeX)),(int)(0.25*getHeight()),maxHandRectSizeX,maxHandRectSizeY);
        comp2D.fillRect((int)(0.5*getWidth()-(0.5*maxHandRectSizeX)),(int)(getHeight()-(0.25*getHeight()+maxHandRectSizeY)),maxHandRectSizeX,maxHandRectSizeY);

        int spaceX = maxHandRectSizeX/(Player.MAX_BOARD_CARDS*(CARD_X_PROPORTION+1)-1);
        int cardSizeX = spaceX * CARD_X_PROPORTION;
        int cardSizeY = maxHandRectSizeY;

        int cardsX = (int)(0.5*getWidth()-(numberOfCardsOnBoard*0.5*cardSizeX+(numberOfCardsOnBoard-1)*0.5*spaceX));
        int cardsY = (int)(getHeight()-(0.25*getHeight()+maxHandRectSizeY));
        int enemyCardsX = (int)(0.5*getWidth()-(numberOfCardsOnBoardEnemy*0.5*cardSizeX+(numberOfCardsOnBoardEnemy-1)*0.5*spaceX));
        int enemyCardsY = (int)(0.25*getHeight());

        for(int i = 0; i < myPlayer.cards.size(); i++)
        {
            paintCard(comp2D, myPlayer.cards.get(i),cardsX + i * spaceX + i *cardSizeX,cardsY,cardSizeX,cardSizeY);
        }

        for(int i = 0; i < enemy.cards.size(); i++)
        {
            paintCard(comp2D, enemy.cards.get(i),enemyCardsX + i * spaceX + i *cardSizeX,enemyCardsY,cardSizeX,cardSizeY);
        }
    }


}
