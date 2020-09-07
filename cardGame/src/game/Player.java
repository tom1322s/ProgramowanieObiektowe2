package game;

import javax.swing.*;
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


        if(cardPack.get(randomInt) instanceof Tank){
            //System.out.println("System rule is instance of Rule");
            handCards.add(new Tank((Tank)cardPack.get(randomInt)));
        }

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
    }

    public void chooseCardFromHand(GameBoard gb)
    {
        int selectedCard = -1;
        //System.out.println(selectedCard!=0);
        while(isAbleToTakeCardFormHand()  && selectedCard!=0)
        {
            System.out.println("jestem");
            boolean manaEnough = false;
            do {
                JOptionPane.showConfirmDialog(
                        null,"ruch"
                );
                String response = JOptionPane.showInputDialog(null, "Wybierz karte \n 0 jesli nic", "", JOptionPane.QUESTION_MESSAGE);
                selectedCard = Integer.parseInt(response);
                if(handCards.get(selectedCard).getCost() <= mana)
                {
                    mana -= handCards.get(selectedCard).getCost();
                    manaEnough = true;
                }
            }
            while(selectedCard!=0 && !manaEnough);

            cards.add(handCards.remove(selectedCard));
        }
    }

    private boolean isAbleToTakeCardFormHand()
    {
        boolean result = false;
        for(var i : handCards)
        {
            if(mana >= i.getCost()) result = true;
        }
        return result;
    }
}
