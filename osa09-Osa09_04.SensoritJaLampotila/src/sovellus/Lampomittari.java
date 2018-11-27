/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.Random;

/**
 *
 * @author asko
 */
public class Lampomittari implements Sensori {
    private boolean onPaalla;
    
    public Lampomittari() {
        this.onPaalla = false;
    }
    
    @Override
    public boolean onPaalla() {
        return this.onPaalla;
    }

    @Override
    public void paalle() {
        this.onPaalla = true;
    }

    @Override
    public void poisPaalta() {
        this.onPaalla = false;
    }

    @Override
    public int mittaa() {
        if (!onPaalla) {
            throw new IllegalStateException();
        }
        return -30 + new Random().nextInt(61);
    }
    
}
