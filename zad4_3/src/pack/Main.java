package pack;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Main instance = new Main();
        String randChars = instance.generateCharacters();

        System.out.println(randChars);



        long startTime;
        long endTime;

        //IO

        boolean ok = true;
        startTime = System.nanoTime();
        for(int i = 0; i < 10_000; i++) {
            instance.printToFileByIO(randChars);
            String buffIO = instance.readFromFileByIO();
            if(!randChars.equals(buffIO)) {
                ok = false;
            }
        }
        endTime = System.nanoTime();

        if(ok) {
            System.out.println("IO Test passed with time = " + ((endTime-startTime)/1_000_000));
        }

        //NIO

        startTime = System.nanoTime();
        for(int i = 0; i < 10_000; i++) {
            instance.printToFileByNIO(randChars);
            String buffNIO = instance.readFromFileByNIO();
            if(!randChars.equals(buffNIO)) {
                ok = false;
            }
        }
        endTime = System.nanoTime();

        if(ok) {
            System.out.println("NIO Test passed with time = " + ((endTime-startTime)/1_000_000));
        }



    }

    public String generateCharacters() {
        String buf = new String();
        for(int i = 0; i < 1000; i++)
        {
            buf += (char)( (int) 'a' + (int)(Math.random()*('z'-'a'+1)));
        }
        return buf;
    }

    public void printToFileByIO(String buff) {

        try {
            FileWriter fw = new FileWriter("outputIO");
            BufferedWriter out = new BufferedWriter(fw);

            out.write(buff);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String readFromFileByIO () {
        String buff = new String();
        try {
            FileReader fr = new FileReader("outputIO");
            BufferedReader in = new BufferedReader(fr);

            buff = in.readLine();

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buff;
    }

    public void printToFileByNIO(String buff)  {

        try
        {
            FileOutputStream outData = new FileOutputStream("outputNIO");
            FileChannel outChanel = outData.getChannel();
            ByteBuffer source = ByteBuffer.wrap(buff.getBytes());

            outChanel.write(source);

            outChanel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFileByNIO () {
        try {
            FileInputStream inData = new FileInputStream("outputNIO");
            FileChannel inChanel = inData.getChannel();
            ByteBuffer source = ByteBuffer.allocate((int) inChanel.size());
            String buff = new String();

            inChanel.read(source, 0);

            /*source.position(0);
            for (int i = 0; source.remaining() > 0; i++) {
                buff += (char) source.get();
            }*/

            source.position(0);
            Charset ascii = Charset.forName("US-ASCII");
            CharsetDecoder toAscii = ascii.newDecoder();
            CharBuffer charBuff = toAscii.decode(source);
            buff = charBuff.toString();

            inChanel.close();

            return buff;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String();
    }
}
