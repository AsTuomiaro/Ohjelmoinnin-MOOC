/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjallisuutta;

/**
 *
 * @author asko
 */
public class Kirja {
    private String nimi;
    private int kohdeika;
    
    public Kirja(String nimi, int kohdeika) {
        this.nimi = nimi;
        this.kohdeika = kohdeika;
    }

    public String getNimi() {
        return nimi;
    }

    public int getKohdeika() {
        return kohdeika;
    }

    @Override
    public String toString() {
        return this.nimi + " (" + this.kohdeika + " vuotiaille ja vanhemmille)";
    }
}
