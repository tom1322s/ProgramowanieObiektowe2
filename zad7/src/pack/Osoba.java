package pack;

public class Osoba extends Wpis{

    private String imie;
    private String nazwisko;


    public Osoba(String imie, String nazwisko,String adres,int nrKierunkowy, int nrTelefonu) throws WrongLengthOfPhoneNumber {
        super(adres, new NrTelefoniczny(nrKierunkowy, nrTelefonu));
        this.imie=imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String opis() {
        String result = new String();
        result += getNrTelefoniczny().getPhoneNumber();
        result += "\t";
        result += getAdres();
        result += "\t";
        result += getImie();
        result += "\t";
        result += getNazwisko();

        return result;
    }
}
