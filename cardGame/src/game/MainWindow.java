package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MainWindow extends JFrame implements ActionListener {

    private boolean endOfGame = false;
    private boolean endOfTurn = false;
    private ArrayList<CardInterface>cardPack;

    private GameBoard gameBoard;
    private JButton endTurnButton;


    public MainWindow(){
        super("CARD GAME");
        JPanel panel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        //setSize(1000,800);
        //FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        //setLayout(flowLayout);

        endTurnButton = new JButton("Zakończ kolejkę");
        gameBoard = new GameBoard();
        //gameBoard.setMinimumSize(new Dimension(500,500));

        endTurnButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        endTurnButton.addActionListener(this);

        panel.add(endTurnButton);
        panel.add(gameBoard);


        add(panel);
        pack();

        setSize(getMaximumSize());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cardPack = new ArrayList<>();
        cardPack.add(new Tank());
        cardPack.add(new Archer());


    }

    public void actionPerformed (ActionEvent event)
    {
        Object source = event.getSource();
        if(source == endTurnButton) {
            //endOfTurn = true;
            gameBoard.myPlayer.endTheTurn();

            gameBoard.enemy.startNewTurn(cardPack);
            gameBoard.repaint();
            gameBoard.enemy.drawCardFromHand();
            gameBoard.repaint();

            while (gameBoard.enemy.canStillAttack())
            {
                for(int i = 0; i < gameBoard.enemy.cards.size();i++)
                {
                    if(!gameBoard.enemy.cards.get(i).isHasAttacked())
                    {
                        int mySelectedCard = i;
                        Random rm = new Random();
                        int enemySelectedCard = rm.nextInt(gameBoard.myPlayer.cards.size());

                        gameBoard.enemy.cards.get(mySelectedCard).attack(gameBoard.enemy.cards, gameBoard.myPlayer.cards, Integer.toString(enemySelectedCard));
                        gameBoard.enemy.cards.get(mySelectedCard).setHasAttacked(true);

                        gameBoard.myPlayer.cleanDead();
                        gameBoard.repaint();
                    }
                }
            }
            gameBoard.enemy.endTheTurn();

            gameBoard.myPlayer.startNewTurn(cardPack);
            gameBoard.repaint();
        }
    }

    public void run()
    {
        for(int i = 0; i < 3; i++) {
            gameBoard.myPlayer.addRandomCardToHand(cardPack);
            gameBoard.enemy.addRandomCardToHand(cardPack);
        }

        gameBoard.myPlayer.startNewTurn(cardPack);
        gameBoard.repaint();

        while(!endOfGame)
        {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*gameBoard.myPlayer.startNewTurn(cardPack);
            gameBoard.repaint();
            //gameBoard.myPlayer.chooseCardFromHand(gameBoard);
            //gameBoard.repaint();

            while(!endOfTurn)
            {
                //System.out.println("czekam");
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            endOfTurn = false;

            while (gameBoard.myPlayer.canStillAttack())
            {
                int mySelectedCard = -1;
                int enemySelectedCard = -1;
                do {
                    String response = JOptionPane.showInputDialog(null, "Kim", "", JOptionPane.QUESTION_MESSAGE);
                    mySelectedCard = Integer.parseInt(response);
                }
                while (mySelectedCard<0 || mySelectedCard>=gameBoard.myPlayer.cards.size()  || gameBoard.myPlayer.cards.get(mySelectedCard).isHasAttacked() );
                do {
                    String response = JOptionPane.showInputDialog(null, "Kogo", "", JOptionPane.QUESTION_MESSAGE);
                    enemySelectedCard = Integer.parseInt(response);
                }
                while(enemySelectedCard<0 || enemySelectedCard>=gameBoard.enemy.cards.size());

                gameBoard.myPlayer.cards.get(mySelectedCard).attack(gameBoard.myPlayer.cards,gameBoard.enemy.cards,Integer.toString(enemySelectedCard));
                gameBoard.myPlayer.cards.get(mySelectedCard).setHasAttacked(true);

                gameBoard.enemy.cleanDead();
                gameBoard.repaint();
            }

            gameBoard.myPlayer.endTheTurn();

            JOptionPane.showConfirmDialog(null,"zakoncz kolejkę");

            gameBoard.enemy.startNewTurn(cardPack);
            gameBoard.repaint();
            gameBoard.enemy.drawCardFromHand();
            gameBoard.repaint();

            while (gameBoard.enemy.canStillAttack())
            {
                for(int i = 0; i < gameBoard.enemy.cards.size();i++)
                {
                    if(!gameBoard.enemy.cards.get(i).isHasAttacked())
                    {
                        int mySelectedCard = i;
                        Random rm = new Random();
                        int enemySelectedCard = rm.nextInt(gameBoard.myPlayer.cards.size());

                        gameBoard.enemy.cards.get(mySelectedCard).attack(gameBoard.enemy.cards, gameBoard.myPlayer.cards, Integer.toString(enemySelectedCard));
                        gameBoard.enemy.cards.get(mySelectedCard).setHasAttacked(true);

                        gameBoard.myPlayer.cleanDead();
                        gameBoard.repaint();
                    }
                }
            }
            gameBoard.enemy.endTheTurn();
*/
        }
    }


}
