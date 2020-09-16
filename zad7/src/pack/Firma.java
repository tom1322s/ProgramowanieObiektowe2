package pack;

public class Firma extends Wpis{

    private String nazwa;

    public Firma( String nazwa, String adres, int nrKierunkowy, int nrTelefonu) throws WrongLengthOfPhoneNumber {
        super(adres, new NrTelefoniczny(nrKierunkowy, nrTelefonu));
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String opis() {
        String result = new String();
        result += getNrTelefoniczny().getPhoneNumber();
        result += "\t";
        result += getAdres();
        result += "\t";
        result += getNazwa();

        return result;
    }
}
