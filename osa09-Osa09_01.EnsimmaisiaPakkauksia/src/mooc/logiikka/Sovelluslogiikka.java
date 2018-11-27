/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc.logiikka;

import mooc.ui.Kayttoliittyma;

/**
 *
 * @author asko
 */
public class Sovelluslogiikka {
    private Kayttoliittyma liittyma;
    
    public Sovelluslogiikka(Kayttoliittyma kayttoliittyma) {
        this.liittyma = kayttoliittyma;
    }
    
    public void suorita(int montakoKertaa) {
        for (int i = 0; i < montakoKertaa; i++) {
            System.out.println("Sovelluslogiikka toimii");
            this.liittyma.paivita();
        }
    }
}
