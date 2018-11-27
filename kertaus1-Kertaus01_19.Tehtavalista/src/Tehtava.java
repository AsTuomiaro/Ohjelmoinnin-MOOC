/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Tehtava {
    private String nimi;
    private boolean onTehty;
    
    public Tehtava(String nimi) {
        this.nimi = nimi;
        this.onTehty = false;
    }
    
    public void asetaTehdyksi() {
        this.onTehty = true;
    }
    
    public void asetaTekemattomaksi() {
        this.onTehty = false;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        String tehty = "ei tehty";
        if (onTehty) {
            tehty = "tehty";
        }
        return this.nimi + " (" + tehty + ")";
    }
}
