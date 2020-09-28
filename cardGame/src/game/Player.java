package game;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public class Player {

    public ArrayList<CardInterface> cards;
    public ArrayList<CardInterface> handCards;
    private int manaCapacity = 0;
    private  int mana = 0;
    public static final int MAX_HAND_CARDS = 6;
    public static final int MAX_BOARD_CARDS = 10;

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

    public Player() {
        cards = new ArrayList<>();
        handCards = new ArrayList<>();
    }

    public void addRandomCardToHand(ArrayList<CardInterface> cardPack) {

        Random r = new Random();
        int randomInt = r.nextInt(cardPack.size());


        /*if(cardPack.get(randomInt) instanceof Tank){
            //System.out.println("System rule is instance of Rule");
            handCards.add(new Tank((Tank)cardPack.get(randomInt)));
        }
        else if(cardPack.get(randomInt) instanceof Archer){
            handCards.add(new Archer((Archer)cardPack.get(randomInt)));
        }*/

        handCards.add(cardPack.get(randomInt).clonee());

        //System.out.println(cardPack.get(randomInt).getClass().getName());
        //System.out.println(cardPack.get(randomInt).getClass().descriptorString());

        //AnnotatedType a = cardPack.get(randomInt).getClass().getAnnotatedSuperclass();
        //System.out.println(a.toString());
        //System.out.println(a.getType().getClass().getName());
        //AnnotatedType b = a.getClass().getAnnotatedSuperclass();
        //System.out.println(b.toString());
        //handCards.add(cardPack.get(randomInt).clone());



        //Tank tank = (Tank) cardPack.get(randomInt);
        //handCards.add(new Tank(tank));

        //Object obj = cardPack.get(randomInt).getClass().cast(cardPack.get(randomInt));
        //handCards.add();
        /*Constructor constructor = cardPack.get(randomInt).getClass().getEnclosingConstructor();

        try {
            handCards.add(
                    (CardInterface) (constructor.newInstance(cardPack.get(randomInt)))
            );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

        //https://www.tutorialspoint.com/java/lang/java_lang_class.htm

        //Class obj = cardPack.get(randomInt).getClass();


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

    /*public void chooseCardFromHand(GameBoard gb)
    {
        int selectedCard = 0;
        //System.out.println(selectedCard!=0);
        while(isAbleToTakeCardFormHand()  && selectedCard!=-1)
        {
            boolean manaEnough = false;
            do {
                String response = JOptionPane.showInputDialog(null, "Wybierz karte \n -1 jesli nic", "", JOptionPane.QUESTION_MESSAGE);
                if(response.isEmpty()) selectedCard = -1;
                else selectedCard = Integer.parseInt(response);

                if(selectedCard>=0 && selectedCard<handCards.size())
                {
                    if (handCards.get(selectedCard).getCost() <= mana) {
                        mana -= handCards.get(selectedCard).getCost();
                        manaEnough = true;
                        gb.repaint();
                    }
                }
            }
            while(selectedCard!=-1 && !manaEnough);

            if(selectedCard != -1)
                cards.add(handCards.remove(selectedCard));
        }
    }*/

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
        while(isAbleToTakeCardFormHand())
        {
            boolean manaEnough = false;
            do {
                Random rm = new Random();
                selectedCard = rm.nextInt(handCards.size());
                System.out.println(selectedCard);
                if(handCards.get(selectedCard).getCost() <= mana)
                {
                    mana -= handCards.get(selectedCard).getCost();
                    manaEnough = true;
                }
            }
            while(!manaEnough);

            cards.add(handCards.remove(selectedCard));
        }
    }

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

    public CardInterface findMoving()
    {
        for(int i = 0; i < cards.size();i++)
        {
            if(cards.get(i).isMoving()) return cards.get(i);
        }
        return null;
    }


}
