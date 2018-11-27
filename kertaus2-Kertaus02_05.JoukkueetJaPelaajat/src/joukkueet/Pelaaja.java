/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joukkueet;

/**
 *
 * @author asko
 */
public class Pelaaja {
    private String nimi;
    private int maalit;
    
    public Pelaaja(String nimi, int maalit) {
        this(nimi);
        this.maalit = maalit;
    }
    
    public Pelaaja(String nimi) {
        this.maalit = 0;
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getMaalit() {
        return maalit;
    }

    @Override
    public String toString() {
        return this.nimi + ", maaleja " + this.maalit;
    }
}
