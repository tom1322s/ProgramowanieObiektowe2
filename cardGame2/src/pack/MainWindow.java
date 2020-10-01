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
        cardPack.add(new Gibbering());
        cardPack.add(new Archer());
        cardPack.add(new Neardenthal());
        cardPack.add(new Dwarf());
        cardPack.add(new BrainMole());
        cardPack.add(new KouToa());
        cardPack.add(new Manticore());
        cardPack.add(new OrcChieftain());
        cardPack.add(new InsectSwarm());
        cardPack.add(new LavaImp());
        cardPack.add(new ArcaneMage());
        cardPack.add(new MountainGigant());
        cardPack.add(new Phoenix());
        cardPack.add(new MindFlyer());
        cardPack.add(new DollGolem());

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
        while(gameBoard.gameLast()) {
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
