package pack;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Player {

    public ArrayList<CardInterface> cards;
    public ArrayList<CardInterface> handCards;
    private int manaCapacity = 0;
    private  int mana = 0;
    private int height = 0;
    private int width = 0;
    private boolean isEnemy;
    public static final int MAX_HAND_CARDS = 6;
    public static final int MAX_BOARD_CARDS = 10;
    public static final int START_HAND_CARDS = 3;
    public static final int HAND_CARD_X_PROPORTION = 10;
    public static final int CARD_X_PROPORTION = 10;

    public int getManaCapacity() {
        return manaCapacity;
    }

    public void setManaCapacity(int manaCapacity) {
        this.manaCapacity = manaCapacity;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Player(boolean isEnemy) {
        cards = new ArrayList<>();
        handCards = new ArrayList<>();
        this.isEnemy = isEnemy;
    }

    public void resize(int width, int height){
        this.width = width;
        this.height = height;
        tidyUp();
    }

    public void tidyUp()
    {
        int maxRectSizeX = (int)(0.5 * width);
        int maxRectSizeY = (int)(0.2 * height);

        int spaceX = maxRectSizeX/(Player.MAX_HAND_CARDS*(HAND_CARD_X_PROPORTION+1)-1);
        int cardSizeX = spaceX*HAND_CARD_X_PROPORTION;
        int cardSizeY = maxRectSizeY;
        int cardsX = (int)(0.5*width-(0.5*maxRectSizeX));

        int cardsY=0;
        if(!isEnemy) cardsY = (int)(height-(0.02*height+maxRectSizeY));
        else cardsY = (int)(0.02*height);

        for (int i = 0; i < handCards.size(); i++) {
            CardInterface handCard = handCards.get(i);
            int nextX = cardsX + i * spaceX + i * cardSizeX;
            if(!handCard.getPoint().equals(new Point(nextX,cardsY))) {
                if(!handCard.isMoving()) {
                    handCard.setMovingGoal(nextX,cardsY);
                    handCard.setMoving(true);
                }
                else if(!handCard.isSpecialMoving()) {
                    handCard.setMovingGoal(nextX,cardsY);
                }
            }
            handCard.setSize(new Point(cardSizeX,cardSizeY));
        }

        int numberOfCardsOnBoard = cards.size();
        int maxHandRectSizeX = (int)(0.8 * width);
        int maxHandRectSizeY = (int)(0.23 * height);
        //comp2D.setColor(Color.GREEN);
        //comp2D.fillRect((int)(0.5*getWidth()-(0.5*maxHandRectSizeX)),(int)(0.25*getHeight()),maxHandRectSizeX,maxHandRectSizeY);
        //comp2D.fillRect((int)(0.5*getWidth()-(0.5*maxHandRectSizeX)),(int)(getHeight()-(0.25*getHeight()+maxHandRectSizeY)),maxHandRectSizeX,maxHandRectSizeY);

        spaceX = maxHandRectSizeX/(Player.MAX_BOARD_CARDS*(CARD_X_PROPORTION+1)-1);
        cardSizeX = spaceX * CARD_X_PROPORTION;
        cardSizeY = maxHandRectSizeY;

        cardsX = (int)(0.5*width-(numberOfCardsOnBoard*0.5*cardSizeX+(numberOfCardsOnBoard-1)*0.5*spaceX));
        if(!isEnemy) cardsY = (int)(height-(0.25*height+maxHandRectSizeY));
        else cardsY = (int)(0.25*height);

        for(int i = 0; i < cards.size(); i++)
        {
            CardInterface card = cards.get(i);
            int nextX = cardsX + i * spaceX + i * cardSizeX;
            if(!card.getPoint().equals(new Point(nextX,cardsY))) {
                if(!card.isMoving()) {
                    card.setMovingGoal(nextX,cardsY);
                    card.setMoving(true);
                }
                else if(!card.isSpecialMoving()) {
                    card.setMovingGoal(nextX,cardsY);
                }
            }
            card.setSize(cardSizeX,cardSizeY);
        }



    }

    public void paintCards(Graphics2D comp2D)
    {
        for(int i = 0; i < handCards.size(); i++)
        {
            paintCard(comp2D,handCards.get(i));
        }
        for(int i = 0; i < cards.size(); i++)
        {
            paintCard(comp2D,cards.get(i));
        }
    }


    public void paintCard(Graphics2D comp2D,CardInterface card)
    {
        int x =card.getPoint().x;
        int y = card.getPoint().y;
        int sizeX = card.getSize().x;
        int sizeY = card.getSize().y;
        //System.out.println(sizeX);

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



    public void addRandomCardToHand(ArrayList<CardInterface> cardPack) {

        Random r = new Random();
        int randomInt = r.nextInt(cardPack.size());
        handCards.add(cardPack.get(randomInt).copy());

        if(!isEnemy) {
            handCards.get(handCards.size() - 1).setPoint((int)(width-(0.29*height+0.03*width)),(int)(height-(0.135*height+0.1*height)));
        }
        else{
            handCards.get(handCards.size() - 1).setPoint((int)(width-(0.29*height+0.03*width)),(int)(0.05*height));
        }
        tidyUp();


    }

    public void startNewTurn(ArrayList<CardInterface> cardPack)
    {
        if(manaCapacity < 9) {
            manaCapacity++;
        }
        mana = manaCapacity;
        if (handCards.size() < MAX_HAND_CARDS) {
            addRandomCardToHand(cardPack);
        }

        for(int i = 0; i < cards.size(); i++)
        {
            cards.get(i).setHasGiveBack(false);
        }
    }

    public boolean anybodyToMove()
    {
        for(var i: handCards)
        {
            if(i.isMoving() || i.isSpecialMoving())
                return true;
        }
        for(var i: cards)
        {
            if(i.isMoving() || i.isSpecialMoving())
                return true;
        }
        return false;
    }

    public void moveCards()
    {
        for(int i = 0; i < handCards.size(); i++)
        {
            if(handCards.get(i).isMoving() || handCards.get(i).isSpecialMoving())
                handCards.get(i).move();
        }
        for(int i = 0; i < cards.size(); i++)
        {
            if(cards.get(i).isMoving() || cards.get(i).isSpecialMoving())
                cards.get(i).move();
        }
    }



    public boolean isAbleToTakeCardFormHand()
    {
        boolean result = false;
        for(var i : handCards)
        {
            if(mana >= i.getCost()) result = true;
        }
        return result;
    }

    public void drawCardFromHand()
    {
        int selectedCard = -1;
        while(isAbleToTakeCardFormHand() && cards.size() < Player.MAX_BOARD_CARDS)
        {
            boolean manaEnough = false;
            do {
                Random rm = new Random();
                selectedCard = rm.nextInt(handCards.size());
                //System.out.println(selectedCard);
                if(handCards.get(selectedCard).getCost() <= mana)
                {
                    mana -= handCards.get(selectedCard).getCost();
                    manaEnough = true;
                }
            }
            while(!manaEnough);

            cards.add(handCards.remove(selectedCard));
            tidyUp();
        }
    }
/*
    public boolean canStillAttack()
    {
        boolean result = false;
        for(var i : cards)
        {
            if(!i.isHasAttacked()) result=true;
        }
        return result;
    }

    public void cleanDead()
    {
        for(int i = 0; i < cards.size(); i++)
        {
            if(cards.get(i).getHealth() <= 0)
            {
                cards.remove(i);
                i--;
            }
        }
    }
*/
    public void endTheTurn()
    {
        for(int i = 0; i < cards.size(); i++)
        {
            cards.get(i).setHasAttacked(false);
        }
    }

    public int checkInList (Point point, ArrayList<CardInterface> list) {
        for(int i = 0; i < list.size(); i++)
        {
            Point start = list.get(i).getPoint();
            Point size = list.get(i).getSize();
            if(point.x>= start.x && point.x<= start.x+size.x && point.y>= start.y && point.y<= start.y+size.y)
                return i;
        }
        return -1;
    }

/*    public CardInterface findMoving()
    {
        for(int i = 0; i < cards.size();i++)
        {
            if(cards.get(i).isMoving()) return cards.get(i);
        }
        return null;
    }
*/
}
