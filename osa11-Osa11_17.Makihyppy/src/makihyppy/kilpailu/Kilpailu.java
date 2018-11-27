/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy.kilpailu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author asko
 */
public class Kilpailu {
    private int kierros;
    private Tuomari tuomari;
    private List<Kilpailija> kilpailijat;
    
    public Kilpailu() {
        this.kierros = 0;
        this.tuomari = new Tuomari();
        this.kilpailijat = new ArrayList<>();
    }
    
    public void lisaaKilpailija(String nimi) {
        this.kilpailijat.add(new Kilpailija(nimi));
    }
    
    public void uusiKierros() {
        this.kierros++;
        Random rnd = new Random();
        
        System.out.println("\n" + this.kierros + ". kierros");
        System.out.println("\nHyppyjärjestys:");
        
        Collections.sort(kilpailijat, (k1, k2) -> {
            return k1.getPisteet() - k2.getPisteet();
        });
        
        for (int i = 0; i < this.kilpailijat.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + this.kilpailijat.get(i));
        }
        
        System.out.println("\nKierroksen " + this.kierros + " tulokset");
        
        for (int i = 0; i < this.kilpailijat.size(); i++) {
            Kilpailija k = this.kilpailijat.get(i);
            int hyppypituus = rnd.nextInt(61) + 60;
            this.tuomari.tuomaroi();
            
            k.lisaaPituus(hyppypituus);
            k.lisaaPisteita(hyppypituus + this.tuomari.annaPisteet());
            
            System.out.println("  " + k.getNimi());
            System.out.println("    pituus: " + hyppypituus);
            System.out.println("    tuomaripisteet: " + this.tuomari);
        }
    }
    
    public void tulostaLopputulokset() {
        System.out.println("\nKilpailun lopputulokset:");
        System.out.println("Sija    Nimi");
        Collections.sort(kilpailijat, (k1,k2) -> {
            return k2.getPisteet() - k1.getPisteet();
        });
        
        for (int i = 0; i < this.kilpailijat.size(); i++) {
            Kilpailija k = this.kilpailijat.get(i);
            System.out.println((i + 1) 
                    + "       " + k 
                    + "\n          hyppyjen pituudet: " + k.getPituudet());
        }
    }
}
