
import java.util.HashMap;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Tietokanta {
    private HashMap<String, Lintu> lintukirjasto;
    
    public Tietokanta() {
        this.lintukirjasto = new HashMap<>();
    }
    
    public void lisaaLintu(String nimi, String latinankielinenNimi) {
        this.lintukirjasto.put(nimi, new Lintu(nimi, latinankielinenNimi));
    }
    
    public void naytaLintu(String nimi) {
        Lintu lintu = this.lintukirjasto.get(nimi);
        if (lintu != null) {
            System.out.println(lintu);
        } else {
            System.out.println("Ei löydy tämän nimistä lintua.");
        }
    }
    
    public void lisaaHavainto(String nimi) {
        Lintu lintu = this.lintukirjasto.get(nimi);
        if (lintu != null) {
            lintu.havaitse();
        } else {
            System.out.println("Ei ole lintu!");
        }
    }
    
    public void tulostaLinnut() {
        Set<String> avaimet = this.lintukirjasto.keySet();
        for (String avain : avaimet) {
            System.out.println(this.lintukirjasto.get(avain));
        }
    }
}
