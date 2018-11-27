
public class Kappale {

    private String esittaja;
    private String nimi;
    private int pituusSekunteina;

    public Kappale(String esittaja, String nimi, int pituusSekunteina) {
        this.esittaja = esittaja;
        this.nimi = nimi;
        this.pituusSekunteina = pituusSekunteina;
    }

    public String getEsittaja() {
        return esittaja;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPituusSekunteina() {
        return pituusSekunteina;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Kappale)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        
        Kappale verrattava = (Kappale) o;
        if (this.esittaja.equals(verrattava.getEsittaja()) 
                && this.nimi.equals(verrattava.getNimi()) 
                && this.pituusSekunteina == verrattava.getPituusSekunteina()) {
            return true;
        }
        return false;
    }

    
    
    @Override
    public String toString() {
        return this.esittaja + ": " + this.nimi + " (" + this.pituusSekunteina + " s)";
    }


}
