package game;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public class Player {

    private ArrayList<CardInterface> cards;
    private ArrayList<CardInterface> handCards;
    private int manaCapacity = 1;
    private  int mana = 1;

    public Player() {
        cards = new ArrayList<>();
        handCards = new ArrayList<>();
    }

    public void addRandomCardToHand(ArrayList<CardInterface> cardPack) {

        Random r = new Random();
        int randomInt = r.nextInt(cardPack.size());


        if(cardPack.get(randomInt) instanceof Tank){
            System.out.println("System rule is instance of Rule");
        }
        //handCards.add(cardPack.get(randomInt));

        //Object obj = cardPack.get(randomInt).getClass().cast(cardPack.get(randomInt));
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

    }
}
