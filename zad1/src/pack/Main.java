package pack;

public class Main {
    public static void main(String[] args) {

        System.out.println("hi");
        for(String i:args) {
            System.out.println(i);
        }
        int[] numb = new int[args.length];
        for(int i = 0; i<args.length; i++)
        {
            numb[i] = Integer.parseInt(args[i]);
        }

        double delta = (Math.pow( numb[1],2)) - 4 * numb[0] * numb[2];

        if(delta<0)
        {
            System.out.println("nie ma pierwiastków");
        }
        else if(delta == 0)
        {
            System.out.print("x = ");
            System.out.println(-numb[1]/(2.0*numb[0]));
        }
        else
        {
            System.out.print("x1 = ");
            System.out.println((-numb[1]-Math.sqrt(delta))/(2*numb[0]));
            System.out.print("x2 = ");
            System.out.println((-numb[1]+Math.sqrt(delta))/(2*numb[0]));
        }
    }
}
