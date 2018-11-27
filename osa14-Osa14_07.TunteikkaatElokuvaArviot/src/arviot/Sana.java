/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arviot;


/**
 *
 * @author asko
 */
public class Sana {
    private String sana;
    private int esiintymiset;
    private int kokonaisarviot;
    
    public Sana(String sana) {
        this.sana = sana;
        this.esiintymiset = 0;
        this.kokonaisarviot = 0;
    }

    public int getEsiintymiset() {
        return esiintymiset;
    }

    public double keskimaarainenTunnearvo() {
        return 1.0 * this.kokonaisarviot / this.esiintymiset;
    }

    public void kasvataEsiintyminen() {
        this.esiintymiset++;
    }
    
    public void lisaaArvio(int arvio) {
        this.kokonaisarviot += arvio;
    }
}
