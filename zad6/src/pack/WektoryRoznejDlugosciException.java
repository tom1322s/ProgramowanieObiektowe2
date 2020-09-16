package pack;

public class WektoryRoznejDlugosciException extends Exception{
    WektoryRoznejDlugosciException(int size1, int size2)
    {
        super("Dlugosc pierwszego wektora to " + size1 + " a drugiego to " + size2);
    }

    WektoryRoznejDlugosciException()
    {
        super("Mamy rozna dlugosc");
    }
}
