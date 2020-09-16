package pack;

public class WrongLengthOfPhoneNumber extends Exception{
    public WrongLengthOfPhoneNumber() {
        super("Zła dlugosc numeru telefonu");
    }
}
