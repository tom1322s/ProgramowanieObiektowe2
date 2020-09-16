package pack;

public class NrTelefoniczny implements Comparable{
    private int nrKierunkowy;
    private int nrTelefonu;
    public static final int KIERUNKOWY_SIZE = 2;
    public static final int TELEFON_SIZE = 9;

    public NrTelefoniczny(int nrKierunkowy, int nrTelefonu) throws WrongLengthOfPhoneNumber {
        if(countNumbers(nrKierunkowy) != KIERUNKOWY_SIZE || countNumbers(nrTelefonu) != TELEFON_SIZE)
            throw new WrongLengthOfPhoneNumber();
        this.nrKierunkowy = nrKierunkowy;
        this.nrTelefonu = nrTelefonu;
    }

    public NrTelefoniczny(String nrKierunkowy, String nrTelefonu) throws WrongLengthOfPhoneNumber, WrongInputPhoneNumberException {
        if(countNumbers(this.nrKierunkowy) != nrKierunkowy.length() || countNumbers(this.nrTelefonu) != nrTelefonu.length())
            throw new WrongLengthOfPhoneNumber();

        this.nrKierunkowy = 0;
        this.nrTelefonu = 0;

        for(int i = 0; i < nrKierunkowy.length(); i++)
        {
            if(!Character.isDigit(nrKierunkowy.charAt(i))) throw new WrongInputPhoneNumberException();
            this.nrKierunkowy *= 10;
            this.nrKierunkowy += nrKierunkowy.charAt(i) - '0';
        }
        for(int i = 0; i < nrTelefonu.length(); i++)
        {
            if(!Character.isDigit(nrTelefonu.charAt(i))) throw new WrongInputPhoneNumberException();
            this.nrTelefonu *= 10;
            this.nrTelefonu += nrTelefonu.charAt(i) - '0';
        }
    }

    public NrTelefoniczny(String phoneNumber) throws WrongLengthOfPhoneNumber, WrongInputPhoneNumberException
    {
        setPhoneNumber(phoneNumber);
    }


    public int getNrKierunkowy() {
        return nrKierunkowy;
    }

    public void setNrKierunkowy(int nrKierunkowy) throws WrongLengthOfPhoneNumber {
        if(countNumbers(nrKierunkowy) != KIERUNKOWY_SIZE) throw new WrongLengthOfPhoneNumber();
        this.nrKierunkowy = nrKierunkowy;
    }

    public int getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(int nrTelefonu) throws WrongLengthOfPhoneNumber {
        if(countNumbers(nrTelefonu) != TELEFON_SIZE) throw new WrongLengthOfPhoneNumber();
        this.nrTelefonu = nrTelefonu;
    }


    public String getPhoneNumber()
    {
        String result = new String();

        result = Integer.toString(nrKierunkowy) + Integer.toString(nrTelefonu);

        return result;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongLengthOfPhoneNumber, WrongInputPhoneNumberException
    {
        if(countNumbers(nrKierunkowy) + countNumbers(nrTelefonu) != phoneNumber.length())
            throw new WrongLengthOfPhoneNumber();

        nrKierunkowy = 0;
        nrTelefonu = 0;

        for(int i = 0; i < KIERUNKOWY_SIZE; i++)
        {
            if(!Character.isDigit(phoneNumber.charAt(i))) throw new WrongInputPhoneNumberException();
            nrKierunkowy *= 10;
            nrKierunkowy += phoneNumber.charAt(i) - '0';
        }
        for(int i = 0; i < TELEFON_SIZE; i++)
        {
            if(!Character.isDigit(phoneNumber.charAt(i+KIERUNKOWY_SIZE))) throw new WrongInputPhoneNumberException();
            nrTelefonu *= 10;
            nrTelefonu += phoneNumber.charAt(i+KIERUNKOWY_SIZE) - '0';
        }
    }

    @Override
    public int compareTo(Object o) {

        if(o == null) throw new NullPointerException();
        NrTelefoniczny nr = (NrTelefoniczny) o;

        if(nrKierunkowy-nr.nrKierunkowy != 0) return nrKierunkowy-nr.nrKierunkowy;

        return nrTelefonu-nr.nrTelefonu;
    }

    private int countNumbers(int n)
    {
        int result = 0;
        while(n>0)
        {
            n/=10;
            result++;
        }
        return result;
    }
}
