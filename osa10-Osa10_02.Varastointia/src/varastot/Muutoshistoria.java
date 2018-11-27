/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

import java.util.ArrayList;

/**
 *
 * @author asko
 */
public class Muutoshistoria {
    private ArrayList<Double> historia;
    
    public Muutoshistoria() {
        this.historia = new ArrayList<>();
    }
    
    public void lisaa(double tilanne) {
        this.historia.add(tilanne);
    }
    
    public void nollaa() {
        this.historia.clear();
    }
    
    public double maxArvo() {
        double palautettava = 0;
        if (this.historia.isEmpty()) {
            return palautettava;
        }
        
        palautettava = this.historia.get(0);
        for (int i = 1; i < this.historia.size(); i++) {
            if (this.historia.get(i) > palautettava) {
                palautettava = this.historia.get(i);
            }
        }
        return palautettava;
    }
    
    public double minArvo() {
        double palautettava = 0;
        if (this.historia.isEmpty()) {
            return palautettava;
        }
        
        palautettava = this.historia.get(0);
        for (int i = 1; i < this.historia.size(); i++) {
            if (this.historia.get(i) < palautettava) {
                palautettava = this.historia.get(i);
            }
        }
        return palautettava;
    }
    
    public double keskiarvo() {
        if (this.historia.isEmpty()) {
            return 0;
        }
        
        double summa = 0;
        for (int i = 0; i < this.historia.size(); i++) {
            summa += this.historia.get(i);
        }
        return summa / this.historia.size();
    }
    
    public double suurinMuutos() {
        double palautettava = 0;
        if (this.historia.size() < 2) {
            return palautettava;
        }
        
        for (int i = 1; i < this.historia.size(); i++) {
            double muutos = Math.abs(this.historia.get(i) - this.historia.get(i - 1));
            if (muutos > palautettava) {
                palautettava = muutos;
            }
        }
        return palautettava;
    }
    
    public double varianssi() {
        double palautettava = 0;
        if (this.historia.size() < 2) {
            return palautettava;
        }
        double keskiarvo = keskiarvo();
        for (int i = 0; i < this.historia.size(); i++) {
            palautettava += (this.historia.get(i) - keskiarvo) * (this.historia.get(i) - keskiarvo);
        }
        return palautettava / (this.historia.size() - 1);
    }

    @Override
    public String toString() {
        return this.historia.toString();
    }
}
