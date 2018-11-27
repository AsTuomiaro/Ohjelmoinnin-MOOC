/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Kertoja {
    private int kertoja;
    
    public Kertoja(int luku) {
        this.kertoja = luku;
    }
    
    public int kerro(int luku) {
        return luku * this.kertoja;
    }
}
