/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Maitosailio {
    private double tilavuus, saldo;
    
    public Maitosailio(double tilavuus) {
        this.tilavuus = tilavuus;
        this.saldo = 0;
    }
    
    public Maitosailio() {
        this(2000);
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTilavuus() {
        return tilavuus;
    }
    
    public double paljonkoTilaaJaljella() {
        return this.tilavuus - this.saldo;
    }
    
    public void lisaaSailioon(double maara) {
        this.saldo += maara;
        if (this.saldo > this.tilavuus) {
            this.saldo = this.tilavuus;
        }
    }
    
    public double otaSailiosta(double maara) {
        if (maara > this.saldo) {
            maara = this.saldo;
        }
        this.saldo -= maara;
        return maara;
    }

    @Override
    public String toString() {
        return Math.ceil(this.saldo) + "/" + Math.ceil(this.tilavuus);
    }
    
}
