package pack;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class main {

    public static final String zmienna = "odpowiednik has define w c++";


    public static void main(String[] args) throws IOException, MyExp {

        main instance = new main();
        char[] buffer = instance.generateCharacters();

        for(char i:buffer) System.out.print(i);
        System.out.println();

        instance.printToFileByIO(buffer);

        buffer = instance.readFromFileByIO();
        for(char i:buffer) System.out.print(i);
        System.out.println();

        Vector v = instance.readFromFileByIOVector();
        instance.printVec(v);
        //System.out.print(v);
        //System.out.println();
        for(Iterator it = v.iterator();it.hasNext();)
            System.out.print(it.next());
        System.out.println();

        instance.printToFileByNIO(buffer);

        System.out.println(instance.readFromFileByNIO());



    }

    public char[] generateCharacters() throws MyExp {
        char[] buf = new char[1000];
        for(int i = 0; i < 1000; i++)
        {
            //buf[i] = (char)( (int) 'a' + (int)(Math.random()*26));
            buf[i] = (char)( (int) 'a' + (int)(Math.random()*('z'-'a'+1)));
        }
        if(buf[0]=='a')
            throw new MyExp("blad");
        return buf;
    }

    public void printToFileByIO(char[] buff) throws IOException {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("output.txt");

            for(var i:buff) {
                out.write(i);
            }
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

    public void printVec(final Vector v)
    {
        //for(Object i:v)
        for(var i:v)
        {
            System.out.print(i);
        }
        System.out.println();
    }

    public char[] readFromFileByIO () throws IOException {
        FileInputStream in = null;
        char[] buff = null;
        try {
            in = new FileInputStream("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            int c;
            int size = 0, capacity = 0;
            while ((c = in.read()) != -1) {
                size++;
                if(size>capacity)
                {
                    if(capacity==0) capacity=1;
                    else capacity*=2;

                    char[] temp = new char[capacity];
                    if(buff!=null) {
                        /*for(int i = 0; i < buff.length; i++)
                            temp[i] = buff[i];*/

                        //temp=buff.clone();
                        System.arraycopy(buff, 0, temp, 0,buff.length);


                    }
                    //buff.finalize();
                    buff = temp;
                }
                //System.out.println(buff.length);
                buff[size-1] = (char) c;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                in.close();
            }
        }

        return buff;
    }

    public Vector readFromFileByIOVector () throws IOException {
        FileInputStream in = null;
        Vector buff = new Vector();
        try {
            in = new FileInputStream("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            int c;
            while ((c = in.read()) != -1) {

                buff.add((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                in.close();
            }
        }

        return buff;
    }

    public void printToFileByNIO(char[] buff) throws IOException {
        /*Set<StandardOpenOption> options = new HashSet<>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);
        Path path = Paths.get("file.txt");*/
        //FileChannel fileChannel = FileChannel.open(path, options);
        //FileChannel fileChannel = FileChannel.open("file.txt", StandardOpenOption.CREATE | StandardOpenOption.APPEND);
        //Charset charset = Charset.forName("US-ASCII");

        //fileChannel.write(charset.encode(buff));

        //fileChannel.close();

        Path newFilePath = Paths.get("file.txt");

        //Files.createFile(newFilePath);

//        for(var i:buff)
        Files.write(newFilePath, new String(buff).getBytes());
    }

    public String readFromFileByNIO () throws IOException {
        String buff;
        Path filePath = Paths.get("file.txt");

        buff = Files.readString(filePath);

        return buff;
    }
}



