
import java.util.Objects;

public class Henkilo {

    private String nimi;
    private Paivays syntymaPaiva;
    private int pituus;
    private int paino;

    public Henkilo(String nimi, Paivays syntymaPaiva, int pituus, int paino) {
        this.nimi = nimi;
        this.syntymaPaiva = syntymaPaiva;
        this.pituus = pituus;
        this.paino = paino;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPaino() {
        return paino;
    }

    public int getPituus() {
        return pituus;
    }

    public Paivays getSyntymaPaiva() {
        return syntymaPaiva;
    }

    
    // toteuta tänne equals-metodi, jolla tarkastellaan olioiden samuutta

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Henkilo)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        Henkilo verrattava = (Henkilo) o;
        if (this.nimi.equals(verrattava.getNimi()) 
                && this.paino == verrattava.getPaino()
                && this.pituus == verrattava.getPituus()
                && this.syntymaPaiva.equals(verrattava.getSyntymaPaiva())) {
            return true;
        }
        return false;
    }
    
}
