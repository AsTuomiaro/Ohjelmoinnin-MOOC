
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Kirjasto {
    private ArrayList<Kirja> kirjat;
    
    public Kirjasto() {
        this.kirjat = new ArrayList<>();
    }
    
    public void lisaaKirja(Kirja uusiKirja) {
        this.kirjat.add(uusiKirja);
    }
    
    public void tulostaKirjat() {
        for (Kirja k : kirjat) {
            System.out.println(k);
        }
    }
    
    public ArrayList<Kirja> haeKirjaNimekkeella(String nimike) {
        ArrayList<Kirja> palautettava = new ArrayList<>();
        for (Kirja k : kirjat) {
            if (StringUtils.sisaltaa(k.nimeke(), nimike)) {
                palautettava.add(k);
            }
        }
        return palautettava;
    }
    
    public ArrayList<Kirja> haeKirjaJulkaisijalla(String julkaisija) {
        ArrayList<Kirja> palautettava = new ArrayList<>();
        for (Kirja k : kirjat) {
            if (StringUtils.sisaltaa(k.julkaisija(), julkaisija)) {
                palautettava.add(k);
            }
        }
        return palautettava;
    }
    
    public ArrayList<Kirja> haeKirjaJulkaisuvuodella(int julkaisuvuosi) {
        ArrayList<Kirja> palautettava = new ArrayList<>();
        for (Kirja k : kirjat) {
            if (k.julkaisuvuosi() == julkaisuvuosi) {
                palautettava.add(k);
            }
        }
        return palautettava;
    }
}
