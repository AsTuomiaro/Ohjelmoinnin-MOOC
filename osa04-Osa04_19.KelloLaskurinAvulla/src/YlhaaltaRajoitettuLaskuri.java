/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class YlhaaltaRajoitettuLaskuri {
    private int arvo;
    private int ylaraja;
    
    public YlhaaltaRajoitettuLaskuri(int ylaraja) {
        this.arvo = 0;
        this.ylaraja = ylaraja;
    }
    
    public void seuraava() {
        this.arvo++;
        if (this.arvo > this.ylaraja) {
            this.arvo = 0;
        }
    }

    public int arvo() {
        return arvo;
    }

    public void asetaArvo(int uusiArvo) {
        if (uusiArvo < 0 || uusiArvo > this.ylaraja) {
            return;
        }
        this.arvo = uusiArvo;
    }
    
    @Override
    public String toString() {
        String etuosa = "";
        if (this.arvo < 10) {
            etuosa = "0";
        }
        return etuosa + this.arvo;
    }
}
