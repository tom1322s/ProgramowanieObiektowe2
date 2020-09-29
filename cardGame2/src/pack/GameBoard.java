package pack;

import com.sun.nio.sctp.SendFailedNotification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JPanel implements MouseListener, ComponentListener, ActionListener, MouseMotionListener {

    private Player myPlayer = new Player(false);
    private Player enemy = new Player(true);
    private ArrayList<CardInterface> cardPack;
    private Timer timerMove = new Timer(5,this);
    private Timer timerEnemyTurn = new Timer(100,this);
    private Timer timerDestruction = new Timer(1000,this);
    private char enemyVariable = 0;
    private Arrow arrow = new Arrow();
    //private Timer shouldMove = new Timer(100,this);
    /*private Timer timer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            CardInterface card = myPlayer.findMoving();
            if(card == null) card = enemy.findMoving();
            if(card.getMovingGoal().equals(card.getPoint()))
            {
                System.out.println("c "+ card.getMovingGoal());
                if(card.getMovingGoal().equals(tempPoint)) {
                    //System.out.println("jestem o");
                    card.setMoving(false);
                    boolean tempBool = false;
                    if(enemy.cards.contains(card)) tempBool = true;
                    enemy.cleanDead();
                    myPlayer.cleanDead();
                    repaint();
                    timer.stop();
                    if(tempBool) enemyAttack();
                }
                else{
                    card.setMovingGoal(tempPoint);
                    card.moveStepTo();
                    repaint();
                    //System.out.println("jestem w");
                }
            }
            else
            {
                card.moveStepTo();
                repaint();
            }
        }
    });*/


    public GameBoard(ArrayList<CardInterface> cardPack) {
        addMouseListener(this);
        addComponentListener(this);
        addMouseMotionListener(this);
        this.cardPack = cardPack;
        myPlayer.resize(getWidth(),getHeight());
        enemy.resize(getWidth(),getHeight());
        //shouldMove.start();
        timerMove.start();
    }


    public void paintComponent(Graphics comp)
    {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        paintBases(comp2D);

        //paintHandCards(comp2D);

        myPlayer.paintCards(comp2D);
        enemy.paintCards(comp2D);
        arrow.paint(comp2D);
        myPlayer.paintCardsSpecial(comp2D);
        enemy.paintCardsSpecial(comp2D);

        if(timerDestruction.isRunning())
        {
            myPlayer.paintDestruction(comp2D);
            enemy.paintDestruction(comp2D);
        }

        //paintMovingCards(comp2D);
    }


    public void paintBases(Graphics2D comp2D)
    {
        comp2D.setColor(Color.pink);
        comp2D.fillRect(0,0,getWidth(),getHeight());

        comp2D.setColor(Color.BLACK);
        comp2D.setStroke(new BasicStroke((int)(0.01*getHeight()),BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND));
        //Line2D.Float line = new Line2D.Float(60F,5F,13F,28F);
        //comp2D.draw(line);
        //comp2D.drawLine((int)(0.15*getHeight())+(int)(0.05*getWidth()),(int)(0.05*getHeight()),getWidth()-((int)(0.25*getHeight())+(int)(0.05*getWidth())),(int)(0.05*getHeight()));
        //comp2D.drawLine((int)(0.15*getHeight())+(int)(0.05*getWidth()),getHeight()-(int)(0.05*getHeight()),getWidth()-((int)(0.25*getHeight())+(int)(0.05*getWidth())),getHeight()-(int)(0.05*getHeight()));

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




    /*public void paintCard(Graphics2D comp2D,CardInterface card, int x, int y, int sizeX, int sizeY)
    {
        if(card.isHasAttacked())
            comp2D.setColor(Color.RED);
        else if(underAttackFlag)
            comp2D.setColor(Color.BLUE);
        else
            comp2D.setColor(Color.GREEN);
        comp2D.fillRect(x,y,sizeX,sizeY);

        card.setPoint(new Point(x,y));
        card.setSize(new Point(sizeX,sizeY));

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

    }*/






   /* public void enemyAttack()
    {
        if (enemy.canStillAttack() && myPlayer.cards.size()!=0)
        {
            for(int i = 0; i < enemy.cards.size();i++)
            {
                if(!enemy.cards.get(i).isHasAttacked())
                {
                    int mySelectedCard = i;
                    Random rm = new Random();
                    int enemySelectedCard = rm.nextInt(myPlayer.cards.size());

                    enemy.cards.get(mySelectedCard).attack(enemy.cards, myPlayer.cards, Integer.toString(enemySelectedCard));
                    enemy.cards.get(mySelectedCard).setHasAttacked(true);

                    //gameBoard.myPlayer.cleanDead();
                    //gameBoard.enemy.cleanDead();
                    //gameBoard.repaint();

                    tempPoint.setLocation(enemy.cards.get(mySelectedCard).getPoint());
                    System.out.println("set"+tempPoint);

                    enemy.cards.get(mySelectedCard).setMoving(true);
                    enemy.cards.get(mySelectedCard).setMovingGoal(myPlayer.cards.get(enemySelectedCard).getPoint());
                    timer.start();
                    break;

                }
            }
        }
        else {
            enemy.endTheTurn();

            myPlayer.startNewTurn(cardPack);
            repaint();
        }
    }*/

    public void startGame()
    {
        for(int i = 0; i < Player.START_HAND_CARDS; i++) {
            myPlayer.addRandomCardToHand(cardPack);
            enemy.addRandomCardToHand(cardPack);
        }
        myPlayer.startNewTurn(cardPack);
        repaint();
    }

    public void playerEndTurn()
    {
        myPlayer.endTheTurn();
        timerEnemyTurn.start();
    }


//COMPONENT LISNERS

    @Override
    public void componentResized(ComponentEvent e) {
        myPlayer.resize(getWidth(),getHeight());
        enemy.resize(getWidth(),getHeight());

        //złap delte przesaniecia i przenies karty które sa podczas ruchu o tą delte w celu unikniecia blokady

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
//Action LISNER
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == timerMove) {
            if (myPlayer.anybodyToMove() || enemy.anybodyToMove()) {
                if (myPlayer.anybodyToMove()) {
                    myPlayer.moveCards();
                }
                if (enemy.anybodyToMove()) {
                    enemy.moveCards();
                }
                repaint();
            }
            else if(myPlayer.anybodyToSpecialMove() || enemy.anybodyToSpecialMove())
            {
                timerDestruction.start();
                repaint();
            }

        }
        else if (source == timerEnemyTurn){
            //System.out.println("s");
            if(!enemy.anybodyToMove() && !enemy.anybodyToSpecialMove())
            {
                //System.out.println("w");
                if(enemyVariable == 0) {
                    enemy.startNewTurn(cardPack);
                    enemyVariable = 1;
                }
                else if(enemyVariable == 1) {
                    enemy.drawCardFromHand();
                    enemyVariable = 2;
                }
                else if(enemyVariable == 2) {
                    if(enemy.canStillAttack()){
                        CardInterface cardA = enemy.firstToAttack();
                        CardInterface cardB = cardA.enemyFindToAttack(myPlayer.cards);
                        cardA.setMovingGoalEnemy(cardB);

                        cardA.attack(enemy.cards, myPlayer.cards, Integer.toString(myPlayer.cards.indexOf(cardB)));
                        cardA.setHasAttacked(true);
                    }
                    else {
                        //System.out.println("J");
                        enemyVariable = 3;
                        //enemy.finishSpecial();
                    }
                }
                else if(enemyVariable == 3) {
                    enemy.endTheTurn();
                    enemyVariable = 4;
                }
                else if(enemyVariable == 4) {
                    timerEnemyTurn.stop();
                    myPlayer.startNewTurn(cardPack);
                    enemyVariable = 0;
                }
            }
        }
        else if (source == timerDestruction){
            timerDestruction.stop();
            //myPlayer.finishSpecial();
            //enemy.finishSpecial();
            myPlayer.executeDamage();
            enemy.executeDamage();
            myPlayer.cleanDead();
            enemy.cleanDead();
            myPlayer.tidyUp();
            enemy.tidyUp();

        }
    }
//Mouse LISNER

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!timerEnemyTurn.isRunning()){
            if (arrow.isEnable()) {
                arrow.setEnable(false);
                repaint();
            }
            myPlayer.finishSpecial();
            enemy.finishSpecial();
            //System.out.println("jestem");
            Point point = e.getPoint();

            int selectedCard = myPlayer.checkInList(point, myPlayer.handCards);
            //System.out.println(selectedCard);
            if (selectedCard >= 0 && myPlayer.cards.size() < Player.MAX_BOARD_CARDS) {
                if (myPlayer.getMana() >= myPlayer.handCards.get(selectedCard).getCost()) {
                    //System.out.println("jestem w");
                    myPlayer.setMana(myPlayer.getMana() - myPlayer.handCards.get(selectedCard).getCost());
                    myPlayer.cards.add(myPlayer.handCards.remove(selectedCard));
                    myPlayer.tidyUp();
                    repaint();
                }
            }

            selectedCard = myPlayer.checkInList(point, myPlayer.cards);
            //System.out.println(selectedCard);
            if (selectedCard >= 0) {
                if (!myPlayer.cards.get(selectedCard).isHasAttacked()) {
                    arrow.setNumber(selectedCard);
                    arrow.setStart(myPlayer.cards.get(selectedCard));
                    arrow.setStop(arrow.getStart());
                    arrow.setEnable(true);
                    repaint();
                }
            }

            selectedCard = myPlayer.checkInList(point, enemy.cards);
            //System.out.println(selectedCard);
            if (selectedCard >= 0 && arrow.getNumber()>=0 && arrow.getNumber()<enemy.cards.size()) {

                CardInterface cardA = myPlayer.cards.get(arrow.getNumber());
                CardInterface cardB = enemy.cards.get(selectedCard);
                cardA.setMovingGoalPlayer(cardB);

                cardA.attack(myPlayer.cards, enemy.cards, Integer.toString(selectedCard));
                cardA.setHasAttacked(true);
                arrow.setNumber(-1);
                //tempPoint.setLocation(myPlayer.cards.get(who).getPoint());

                /*myPlayer.cards.get(who).setMoving(true);
                myPlayer.cards.get(who).setMovingGoal(enemy.cards.get(selectedCard).getPoint());
                timer.start();*/

            }
        }




    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

//Mouse motion lisner
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(arrow.isEnable())
        {
            arrow.setStop(e.getPoint());
            repaint();
        }
    }
}

