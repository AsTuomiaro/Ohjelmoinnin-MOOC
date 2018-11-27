/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Kirja implements Talletettava {
    private String nimi, kirjailija;
    private double paino;
    
    public Kirja(String kirjailija, String nimi, double paino) {
        this.nimi = nimi;
        this.kirjailija = kirjailija;
        this.paino = paino;
    }
    
    @Override
    public double paino() {
        return this.paino;
    }

    @Override
    public String toString() {
        return this.kirjailija + ": " + this.nimi;
    }
}
