package pack;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        long startTime;
        long endTime;


        // for java.io
        String randomCharacters = generateCharacters();

        System.out.println(randomCharacters);

        startTime = System.nanoTime();
        writeFileIO("characters_io.txt", randomCharacters);
        String readCharacters = readFileIO("characters_io.txt");
        endTime = System.nanoTime();
        if(randomCharacters.equals(readCharacters)) {
            System.out.println("IO Test passed with time = " + ((endTime-startTime)/1000));
        }
        else{
            System.out.println(randomCharacters);
            System.out.println(readCharacters);
        }
        /*System.out.println("Odczyt pliku java.io: ");
        for(int i=0; i<readCharacters.length; i++) {
            System.out.println(i + ". " + readCharacters[i]);
        }*/

        // for java.nio
        startTime = System.nanoTime();
        Path path = Paths.get("characters_nio.txt");
        writeFileNIO(path, randomCharacters);
        readCharacters = readFileNIO(path);
        endTime = System.nanoTime();
        if(randomCharacters.equals(readCharacters)) {
            System.out.println("NIO Test passed with time = " + ((endTime-startTime)/1000));
        }
        else{
            System.out.println(randomCharacters);
            System.out.println(readCharacters);
        }
        /*System.out.println("Odczyt pliku java.nio: ");
        for(int i=0; i< readCharacters.length; i++) {
            System.out.println(i + ". " + readCharacters[i]);
        }*/
    }

    public static String generateCharacters() {
        Random r = new Random();
        String randomCharacters = new String();
        for(int i=0; i<1000; i++) {
            char c = (char)(r.nextInt(26) + 'a');
            randomCharacters += Character.toString(c);
        }
        return randomCharacters;
    }

    public static void writeFileIO(String fileName, String source) throws IOException {
        try(FileWriter randomFile = new FileWriter(fileName)) {
                randomFile.write(source);
        }
    }

    public static String readFileIO(String fileName) throws IOException {
        Scanner scanner = null;
        String readCharacters = new String();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                readCharacters += input;
            }
        } catch(IOException e) {
            System.out.println("Nie mozna wczytac java.io!");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return readCharacters;
    }

    public static void writeFileNIO(Path path, String source) throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {

            writer.write(source);

        } catch(IOException e) {
            System.out.println("Nie mozna zapisac w java.nio");
        }
    }

    public static String readFileNIO(Path path) throws IOException {
        String readCharacters = new String();
        String line = null;
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            while((line = reader.readLine()) != null) {
                readCharacters += line;
            }
        } catch(IOException e) {
            System.out.println("Nie mozna wczytac java.nio");
        }
        return readCharacters;
    }
}
