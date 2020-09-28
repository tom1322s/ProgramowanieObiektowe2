package pack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame implements ActionListener {

    private ArrayList<CardInterface> cardPack;
    private GameBoard gameBoard;
    private JButton endTurnButton;

    public MainWindow() {
        super("CARD GAME");
        JPanel panel = new JPanel();

        cardPack = new ArrayList<>();
        //cardPack.add(new Tank());
        cardPack.add(new Archer());
        /*cardPack.add(new Peasant());
        cardPack.add(new Magician());
        cardPack.add(new Dragon());
        cardPack.add(new Healer());
        cardPack.add(new Fairy());
        cardPack.add(new Cannon());
        cardPack.add(new MagicCannon());*/

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);


        endTurnButton = new JButton("Zakończ kolejkę");
        gameBoard = new GameBoard(cardPack);
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
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == endTurnButton) {
            gameBoard.playerEndTurn();
        }
    }
    public void run()
    {
        gameBoard.startGame();

        /*gameBoard.myPlayer.startNewTurn(cardPack);
        gameBoard.repaint();*/

        //while(!endOfGame) {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

         /*   if (gameBoard.myPlayer.getManaCapacity() > 5) {
                if (gameBoard.myPlayer.cards.size() == 0 || gameBoard.enemy.cards.size() == 0) {
                    endOfGame = true;
                }
            }*/
        }
    }
}
