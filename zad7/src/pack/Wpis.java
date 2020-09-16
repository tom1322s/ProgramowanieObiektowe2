package pack;

abstract public class Wpis{

    private String adres;
    private NrTelefoniczny nrTelefoniczny;

    public Wpis(String adres, NrTelefoniczny nrTelefoniczny) {
        this.adres = adres;
        this.nrTelefoniczny = nrTelefoniczny;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public NrTelefoniczny getNrTelefoniczny() {
        return nrTelefoniczny;
    }

    public void setNrTelefoniczny(NrTelefoniczny nrTelefoniczny) {
        this.nrTelefoniczny = nrTelefoniczny;
    }

    abstract public String opis();
}
