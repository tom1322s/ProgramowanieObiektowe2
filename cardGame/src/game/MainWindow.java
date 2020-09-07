package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private boolean endOfGame = false;
    private ArrayList<CardInterface>cardPack;
    private Player myPlayer;
    private Player enemy;

    public MainWindow(){
        super("CARD GAME");
        JPanel panel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        //setSize(1000,800);
        //FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        //setLayout(flowLayout);

        JButton endTurnButton = new JButton("Zakończ kolejkę");
        GameBoard gameBoard = new GameBoard();
        //gameBoard.setMinimumSize(new Dimension(500,500));

        endTurnButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        panel.add(endTurnButton);
        panel.add(gameBoard);


        add(panel);
        pack();

        setSize(getMaximumSize());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        myPlayer = new Player();
        enemy = new Player();

        cardPack = new ArrayList<>();
        cardPack.add(new Tank());


    }

    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            myPlayer.addRandomCardToHand(cardPack);
            enemy.addRandomCardToHand(cardPack);
        }

        while(!endOfGame)
        {
            ;
        }
    }


}
