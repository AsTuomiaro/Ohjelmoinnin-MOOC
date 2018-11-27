
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Navetta {
    private Maitosailio maitosailio;
    private Lypsyrobotti robotti;
    
    public Navetta(Maitosailio maitosailio) {
        this.maitosailio = maitosailio;
    }

    public Maitosailio getMaitosailio() {
        return maitosailio;
    }
    
    public void asennaLypsyrobotti(Lypsyrobotti lypsyrobotti) {
        this.robotti = lypsyrobotti;
        this.robotti.setMaitosailio(this.maitosailio);
    }
    
    public void hoida(Lehma lehma) {
        if (this.robotti == null) {
            throw new IllegalStateException("Ei löydetty lypsyrobottia!");
        }
        this.robotti.lypsa(lehma);
    }
    
    public void hoida(Collection<Lehma> lehmat) {
        if (this.robotti == null) {
            throw new IllegalStateException("Ei löydetty lypsyrobottia!");
        }
        for (Lehma lehma : lehmat) {
            this.robotti.lypsa(lehma);
        }
    }

    @Override
    public String toString() {
        return this.maitosailio.toString();
    }
}
