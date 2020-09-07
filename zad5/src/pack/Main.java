package pack;

import java.io.*;
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
        FileInputStream inputFile = openFile();

        printRandomChars(inputFile);

        try
        {
            inputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public FileInputStream openFile()
    {
        FileInputStream inputFile = null;

        boolean ok = false;
        String inputName = new String("blad");
        while (!ok) {
            System.out.println("Podaj sciezke do pliku ktory chcesz otworzyc");

            inputName = in.next();
            //System.out.println(inputName);
            ok = true;
            try {
                inputFile = new FileInputStream(inputName);
            }
            catch (FileNotFoundException e) {
                //e.printStackTrace();
                ok = false;
            }
        }

        RandomAccessFile out = null;

        try {
            out = new RandomAccessFile("logs.txt","rw");

            /*
            kod sprawdzajacy czy sie nie powtarza

             */

            out.seek(out.length());
            inputName += new String("\n");
            out.write(inputName.getBytes());
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


        return inputFile;
    }

    public void printRandomChars(FileInputStream inputFile)
    {
        byte[] bytes = new byte[1];
        bytes[0] = 1;
        while(bytes[0]!=0)
        {
            try{
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bytes= new byte[(int) (1+(Math.random()*5))];
            try {
                inputFile.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
                //break;
            }
            System.out.println(new String(bytes));
        }
    }
}
