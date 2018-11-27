
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Lehma implements Lypsava, Eleleva {
    private String nimi;
    private double tilavuus;
    private double maara;
    
    private static final String[] NIMIA = new String[]{
    "Anu", "Arpa", "Essi", "Heluna", "Hely",
    "Hento", "Hilke", "Hilsu", "Hymy", "Matti", "Ilme", "Ilo",
    "Jaana", "Jami", "Jatta", "Laku", "Liekki",
    "Mainikki", "Mella", "Mimmi", "Naatti",
    "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
    "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Lehma(String nimi) {
        this.nimi = nimi;
        this.tilavuus = 15 + new Random().nextInt(26);
        this.maara = 0;
    }
    
    public Lehma() {
        this(NIMIA[new Random().nextInt(NIMIA.length)]);
    }

    @Override
    public double lypsa() {
        double palautettava = this.maara;
        this.maara = 0;
        return palautettava;
    }

    @Override
    public void eleleTunti() {
        this.maara += 0.7 + 1.3 * new Random().nextDouble();
        if (this.maara > this.tilavuus) {
            this.maara = this.tilavuus;
        }
    }

    public String getNimi() {
        return nimi;
    }

    public double getTilavuus() {
        return tilavuus;
    }

    public double getMaara() {
        return maara;
    }

    @Override
    public String toString() {
        return this.nimi + " " + Math.ceil(this.maara) + "/" + this.tilavuus;
    }
}
