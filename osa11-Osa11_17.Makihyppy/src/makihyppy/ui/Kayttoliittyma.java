/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy.ui;

import java.util.Scanner;
import makihyppy.kilpailu.Kilpailu;

/**
 *
 * @author asko
 */
public class Kayttoliittyma {
    private Scanner lukija;
    private Kilpailu kisa;
    
    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.kisa = new Kilpailu();
    }
    
    public void kaynnista() {
        System.out.println("Kumpulan mäkiviikot");
        System.out.println("\nSyötä kilpailun osallistujat yksi kerrallaan, tyhjällä merkkijonolla siirtyy hyppyvaiheeseen.");
        
        while (true) {            
            System.out.print("  Osallistujan nimi: ");
            String nimi = lukija.nextLine();
            if (nimi.isEmpty()) {
                break;
            }
            kisa.lisaaKilpailija(nimi);
        }
        
        System.out.println("\nKilpailu alkaa!");
        
        while (true) {            
            System.out.print("\nKirjoita \"hyppaa\" niin hypätään, muuten lopetetaan: ");
            String komento = lukija.nextLine();
            if (!komento.equals("hyppaa")) {
                break;
            }
            this.kisa.uusiKierros();
        }
        
        System.out.println("\nKiitos!");
        this.kisa.tulostaLopputulokset();
    }
}
