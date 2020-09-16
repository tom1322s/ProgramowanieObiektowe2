package pack;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public Scanner in;

    public static void main(String[] args) {
        Main instance = new Main();

        instance.run();
    }

    public Main() {
        in = new Scanner(System.in);
    }

    public void run()
    {
        BufferedReader inputFile = openFile();

        printRandomChars(inputFile);

        try
        {
            inputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BufferedReader openFile()
    {
        FileReader fr = null;

        boolean ok = false;
        String inputName = new String();
        while (!ok) {
            System.out.println("Podaj sciezke do pliku ktory chcesz otworzyc");

            inputName = in.next();
            //System.out.println(inputName);
            ok = true;
            try {
                fr = new FileReader(inputName);
            } catch (IOException e) {
                //e.printStackTrace();
                ok = false;
            }

        }

        BufferedReader br = new BufferedReader(fr);

        RandomAccessFile out = null;

        try {
            out = new RandomAccessFile("logs.txt","rw");

            ArrayList<String> logs = new ArrayList<>();
            String inString = new String("c");
            while(inString!=null)
            {
                inString = out.readLine();
                System.out.println(inString);
                if(inString!=null) logs.add(new String(inString));
            }

            if(!logs.contains(inputName)) {
                out.seek(out.length());
                inputName += new String("\n");
                out.write(inputName.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return br;
    }

    public void printRandomChars(BufferedReader inputFile)
    {
        char[] c = new char[1];
        c[0] = '1';
        while(c[0]!=0)
        {
            System.out.print("press enter");
            try{
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            c= new char[(int) (1+(Math.random()*5))];
            try {
                inputFile.read(c);
            } catch (IOException e) {
                e.printStackTrace();
                //break;
            }
            System.out.println(c);
        }
    }
}
