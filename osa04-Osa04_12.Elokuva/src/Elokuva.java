/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Elokuva {
    private String nimi;
    private int ikaraja;
    
    public Elokuva(String elokuvaNimi, int elokuvanIkaraja) {
        this.nimi = elokuvaNimi;
        this.ikaraja = elokuvanIkaraja;
    }
    
    public String nimi() {
        return this.nimi;
    }
    
    public int ikaraja() {
        return this.ikaraja;
    }
}
