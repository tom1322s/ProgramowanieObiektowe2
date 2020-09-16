package pack;

public class WrongInputPhoneNumberException extends Exception{
    public WrongInputPhoneNumberException() {
        super("numer musi skladac sie tylko z cyfr");
    }
}
