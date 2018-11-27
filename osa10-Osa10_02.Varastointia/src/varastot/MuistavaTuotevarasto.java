/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

/**
 *
 * @author asko
 */
public class MuistavaTuotevarasto extends Tuotevarasto {
    private Muutoshistoria historia;
    
    public MuistavaTuotevarasto(String tuotenimi, double tilavuus, double alkuSaldo) {
        super(tuotenimi, tilavuus);
        this.historia = new Muutoshistoria();
        this.lisaaVarastoon(alkuSaldo);
    }

    @Override
    public void lisaaVarastoon(double maara) {
        super.lisaaVarastoon(maara);
        this.historia.lisaa(this.getSaldo());
    }

    @Override
    public double otaVarastosta(double maara) {
        double palautettava = super.otaVarastosta(maara); 
        this.historia.lisaa(this.getSaldo());
        return palautettava;
    }
    
    public String historia() {
        return this.historia.toString();
    }
    
    public void tulostaAnalyysi() {
        System.out.println("Tuote: " + this.getNimi());
        System.out.println("Historia: " + this.historia());
        System.out.println("Suurin tuotemäärä: " + this.historia.maxArvo());
        System.out.println("Pienin tuotemäärä: " + this.historia.minArvo());
        System.out.println("Keskiarvo: " + this.historia.keskiarvo());
        System.out.println("Suurin muutos: " + this.historia.suurinMuutos());
        System.out.println("Varianssi: " + this.historia.varianssi());
    }
}
