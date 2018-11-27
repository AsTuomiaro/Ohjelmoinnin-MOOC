package laatikot;

import java.util.Objects;

public class Tavara {

    private String nimi;
    private int paino;

    public Tavara(String nimi, int paino) {
        if (paino < 0) {
            throw new IllegalArgumentException();
        }
        this.nimi = nimi;
        this.paino = paino;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tavara other = (Tavara) obj;
        if (!this.nimi.equals(other.getNimi())) {
            return false;
        }
        return true;
    }

    public Tavara(String nimi) {
        this(nimi, 0);
    }

    public String getNimi() {
        return nimi;
    }

    public int getPaino() {
        return paino;
    }

}
