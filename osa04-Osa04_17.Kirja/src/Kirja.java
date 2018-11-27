/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Kirja {
    private String nimi;
    private String kirjailija;
    private int sivujenlkm;
    
    public Kirja(String kirjailija, String nimi, int sivuja) {
        this.kirjailija = kirjailija;
        this.nimi = nimi;
        this.sivujenlkm = sivuja;
    }

    public String getKirjailija() {
        return kirjailija;
    }

    public String getNimi() {
        return nimi;
    }

    public int getSivuja() {
        return sivujenlkm;
    }

    @Override
    public String toString() {
        return this.kirjailija + ", " + this.nimi + ", " + this.sivujenlkm + " sivua";
    }
}
