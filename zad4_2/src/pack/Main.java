package pack;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws IOException {

        Main instance = new Main();
        String buffer = instance.generateCharacters();
        System.out.println(buffer);

        long startTime;
        long endTime;

        //IO


        startTime = System.nanoTime();
        instance.printToFileByIO(buffer);
        String buffIO = instance.readFromFileByIO();
        endTime = System.nanoTime();

        if(buffer.equals(buffIO)) {
            System.out.println("IO Test passed with time = " + ((endTime-startTime)/1000));
        }

        //NIO

        startTime = System.nanoTime();
        instance.printToFileByNIO(buffer);
        String buffNIO = instance.readFromFileByNIO();
        endTime = System.nanoTime();

        if(buffer.equals(buffNIO)) {
            System.out.println("NIO Test passed with time = " + ((endTime-startTime)/1000));
        }

        //NIO chanel

        startTime = System.nanoTime();
        instance.printToFileByNIOChanel(buffer);
        String buffNIOChanel = instance.readFromFileByNIOChanel();
        endTime = System.nanoTime();

        if(buffer.equals(buffNIOChanel)) {
            System.out.println("NIO Chanel Test passed with time = " + ((endTime-startTime)/1000));
        }
        else System.out.println(buffNIOChanel);



    }

    public String generateCharacters() {
        String buf = new String();
        for(int i = 0; i < 100000; i++)
        {
            buf += (char)( (int) 'a' + (int)(Math.random()*('z'-'a'+1)));
        }
        return buf;
    }

    public void printToFileByIO(String buff) throws IOException {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("output.txt");

            out.write(buff.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }



    public String readFromFileByIO () throws IOException {
        FileInputStream in = null;
        String buff = new String();
        try {
            in = new FileInputStream("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try
        {
            buff = new String(in.readAllBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                in.close();
            }
        }

        return buff;
    }



    public void printToFileByNIO(String buff) throws IOException {

        Path newFilePath = Paths.get("file.txt");
        try{
            Files.createFile(newFilePath);
        } catch (FileAlreadyExistsException e) {
            //e.printStackTrace();
            // Pytanie co zrobic jak chce olać ten bład ???
        }

        Files.write(newFilePath, buff.getBytes());
    }

    public String readFromFileByNIO () throws IOException {
        String buff;
        Path filePath = Paths.get("file.txt");

        buff = Files.readString(filePath);

        return buff;
    }

    public void printToFileByNIOChanel(String buff) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("file2.txt",
                "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        fileChannel.write( Charset.forName("UTF-8").encode(buff));

        fileChannel.close();
        randomAccessFile.close();
    }

    public String readFromFileByNIOChanel () throws IOException {
        String buff;
        RandomAccessFile randomAccessFile = new RandomAccessFile("file2.txt",
                "r");
        FileChannel fileChannel = randomAccessFile.getChannel();


        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fileChannel.read( buffer );

        //System.out.println(buffer);

        //System.out.println(buffer.toString());

        buffer.rewind();

        buff = Charset.forName("UTF-8").decode(buffer).toString();

        buff = new String (buff);

        fileChannel.close();
        randomAccessFile.close();

        return buff;
    }
}
