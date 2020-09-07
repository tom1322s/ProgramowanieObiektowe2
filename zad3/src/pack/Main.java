package pack;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean game = true;
        while(game)
        {
            int num = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            int myNum = -1;
            int counter = 0;
            while(num != myNum)
            {
                System.out.println("podaj liczbe");
                myNum=in.nextInt();
                if(myNum>num) System.out.println("za duza");
                else if(myNum<num) System.out.println("za mala");
                counter++;
            }
            System.out.println("wykonales "+String.valueOf(counter)+" podejsc");
            System.out.println("Chcesz sprobowac raz jeszcze?");
            System.out.println("y or n");

            String input = in.next();
            if(input.equals("n"))
                game = false;
        }
    }
}
