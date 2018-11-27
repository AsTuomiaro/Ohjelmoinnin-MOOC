/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joukkueet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asko
 */
public class Joukkue {
    private String nimi;
    private List<Pelaaja> pelaajat;
    private int maksimikoko;
    
    public Joukkue(String nimi) {
        this.nimi = nimi;
        this.pelaajat = new ArrayList<>();
        this.maksimikoko = 16;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPelaajienLukumaara() {
        return this.pelaajat.size();
    }
    
    public void setMaksimikoko(int maksimikoko) {
        this.maksimikoko = maksimikoko;
    }
    
    public void lisaaPelaaja(Pelaaja uusiPelaaja) {
        if (this.getPelaajienLukumaara() < this.maksimikoko) {
            this.pelaajat.add(uusiPelaaja);
        }
    }
    
    public void tulostaPelaajat() {
        for (Pelaaja p : this.pelaajat) {
            System.out.println(p);
        }
    }
    
    public int yhteismaalit() {
        return this.pelaajat.stream().mapToInt(t -> t.getMaalit()).sum();
    }
}
