/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiekkaranta;

/**
 *
 * @author asko
 */
public class Piirtotyyppi {
    private Tyyppi tyyppi;
    
    public Piirtotyyppi() {
        this.tyyppi = Tyyppi.TYHJA;
    }

    public void setTyyppi(Tyyppi tyyppi) {
        this.tyyppi = tyyppi;
    }

    public Tyyppi getTyyppi() {
        return tyyppi;
    }
}
