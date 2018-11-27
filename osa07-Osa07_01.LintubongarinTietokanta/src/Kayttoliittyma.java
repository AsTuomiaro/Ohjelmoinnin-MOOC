
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Kayttoliittyma {
    private Scanner lukija;
    private Tietokanta tietokanta;
    
    public Kayttoliittyma(Scanner lukija, Tietokanta tietokanta) {
        this.lukija = lukija;
        this.tietokanta = tietokanta;
    }
    
    public void kaynnista() {
        System.out.println("Komennot:");
        System.out.println("Lisaa - lisää linnun tietokantaan.");
        System.out.println("Havainto - lisää havainnon annetusta linnusta.");
        System.out.println("Tilasto - tulostaa kaikki linnut ja niiden havainnot.");
        System.out.println("Nayta - tulostaa halutun linnun ja sen havainnot.");
        System.out.println("Lopeta - lopettaa ohjelman.");
        System.out.println("");
        
        while (true) {            
            System.out.print("? ");
            String komento = lukija.nextLine();
            if (komento.equals("Lisaa")) {
                System.out.print("Nimi: ");
                String nimi = lukija.nextLine();
                
                System.out.print("Latinankielinen nimi: ");
                String latinankielinenNimi = lukija.nextLine();
                
                this.tietokanta.lisaaLintu(nimi, latinankielinenNimi);
            } else if (komento.equals("Havainto")) {
                System.out.print("Mikä havaittu: ");
                String nimi = lukija.nextLine();
                
                this.tietokanta.lisaaHavainto(nimi);
            } else if (komento.equals("Tilasto")) {
                tietokanta.tulostaLinnut();
            } else if (komento.equals("Nayta")) {
                System.out.print("Mikä: ");
                String nimi = lukija.nextLine();
                
                this.tietokanta.naytaLintu(nimi);
            } else if (komento.equals("Lopeta")) {
                break;
            } else {
                System.out.println("Tuntematon komento.");
            }
        }
    }
}
