package pack;

public class Main {
    public static void main(String[] args) {

        for(String i:args) {
            System.out.print(i);
        }
        System.out.println();

        if(args.length != 3)
        {
            System.out.println("Zła liczba argumentow");
        }

        int start = Integer.parseInt(args[1]);
        int stop = Integer.parseInt(args[2]);

        if(start<0 || stop<0)
            System.out.println("Złe liczby");

        if(start>stop)
            System.out.println("start musi byc mniejszy niz stop");

        if(stop>=args[0].length())
            System.out.println("Zbyt krótkie słowo");

        for(int i = start; i<=stop; i++)
        {
            System.out.print(args[0].charAt(i));
        }
        System.out.println();
    }
}
