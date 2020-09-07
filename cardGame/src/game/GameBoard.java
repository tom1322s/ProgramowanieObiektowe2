package game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

public class GameBoard extends JPanel {

    private int turnCounter = 0;

    public  void nextTurn()
    {
        turnCounter++;
    }


    public void paintComponent(Graphics comp)
    {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;



        paintBases(comp2D);


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
        comp2D.drawString(String.valueOf(turnCounter),(int)(0.02*getHeight()+0.03*getWidth()),(int)(0.17*getHeight()));
        comp2D.drawString(String.valueOf(turnCounter),(int)(0.02*getHeight()+0.03*getWidth()),(int)(getHeight()-0.07*getHeight()));
    }


}
