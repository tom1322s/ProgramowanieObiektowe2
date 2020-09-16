package pack;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public Scanner in;

    public static void main(String[] args) {
        Main instance = new Main();

        instance.run();
    }

    public Main() {
        in = new Scanner(System.in);
        in.useLocale(Locale.US);
    }

    public void run()
    {
        boolean ok =true;
        while(ok) {
            ok = false;
            double[] v1 = null, v2 = null, v = null;
            try {
                System.out.println("podaj pierwszy wektor");
                v1 = getVector();
                System.out.println("podaj drugi wektor");
                v2 = getVector();
            } catch (NumberFormatException e) {
                System.out.println("ignoruje");
                System.exit(0);
            }

            try {
                v = addVectors(v1, v2);
                for (var i : v) {
                    System.out.print(i);
                }
                System.out.println();
            } catch (WektoryRoznejDlugosciException e) {
                e.printStackTrace();
                ok = true;
            }
        }



    }


    public double[] getVector() throws NumberFormatException
    {
        String line = in.nextLine();
        String separator = new String();
        for(int i = 0; i < line.length(); i++)
        {
            Character c = line.charAt(i);
            if(!Character.isDigit(c) && c!='.' && c!=',')
                separator = c.toString();
        }

        if(separator.isEmpty())
        {
            double[] v = new double[1];
            v[0] = Double.parseDouble(line);
            return v;
        }
        else {
            String[] args = line.split(separator);
            double[] v = new double[args.length];
            for (int i = 0; i < v.length; i++) {
                v[i] = Double.parseDouble(args[i]);
            }
            return v;
        }
    }

    public double[] addVectors (double[] lhs, double[] rhs) throws WektoryRoznejDlugosciException
    {
        if(lhs.length != rhs.length) throw new WektoryRoznejDlugosciException(lhs.length,rhs.length);

        double[] result = new double[lhs.length];
        for(int i = 0; i < lhs.length; i++)
        {
            result[i] = lhs[i] + rhs[i];
        }
        return result;
    }
}
