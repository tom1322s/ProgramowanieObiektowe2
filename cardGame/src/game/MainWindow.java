package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private boolean endOfGame = false;
    private ArrayList<CardInterface>cardPack;

    private GameBoard gameBoard;

    public MainWindow(){
        super("CARD GAME");
        JPanel panel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        //setSize(1000,800);
        //FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        //setLayout(flowLayout);

        JButton endTurnButton = new JButton("Zakończ kolejkę");
        gameBoard = new GameBoard();
        //gameBoard.setMinimumSize(new Dimension(500,500));

        endTurnButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        panel.add(endTurnButton);
        panel.add(gameBoard);


        add(panel);
        pack();

        setSize(getMaximumSize());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cardPack = new ArrayList<>();
        cardPack.add(new Tank());


    }

    public void run()
    {
        for(int i = 0; i < 3; i++) {
            gameBoard.myPlayer.addRandomCardToHand(cardPack);
            gameBoard.enemy.addRandomCardToHand(cardPack);
        }

        while(!endOfGame)
        {
            gameBoard.myPlayer.startNewTurn(cardPack);
            gameBoard.repaint();

            gameBoard.myPlayer.chooseCardFromHand(gameBoard);


            gameBoard.enemy.startNewTurn(cardPack);
            gameBoard.repaint();

            JOptionPane.showConfirmDialog(
                    null,"twoj ruch"
            );

        }
    }


}
