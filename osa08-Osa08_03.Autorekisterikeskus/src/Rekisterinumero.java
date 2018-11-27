
import java.util.Objects;


public class Rekisterinumero {
    // älä muuta luokan jo valmiina olevia osia

    // oliomuuttujille on lisätty määre final, jolloin niiden arvoa ei asetuksen
    // jälkeen voi enää muuttaa
    private final String rekNro;
    private final String maa;

    public Rekisterinumero(String maa, String rekNro) {
        this.rekNro = rekNro;
        this.maa = maa;
    }

    public String getMaa() {
        return maa;
    }

    public String getRekNro() {
        return rekNro;
    }

    @Override
    public String toString() {
        return maa + " " + rekNro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.rekNro);
        hash = 31 * hash + Objects.hashCode(this.maa);
        hash = 11 * hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        final Rekisterinumero other = (Rekisterinumero) obj;
        if (!(this.rekNro.equals(other.getRekNro())) 
                || !(this.maa.equals(other.getMaa()))) {
            return false;
        }
        return true;
    }

}
