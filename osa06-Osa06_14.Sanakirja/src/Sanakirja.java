
import java.util.ArrayList;
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
public class Sanakirja {
    private HashMap<String, String> sanat;
    
    public Sanakirja() {
        this.sanat = new HashMap<>();
    }
    
    public String kaanna(String sana) {
        return this.sanat.get(sana);
    }
    
    public void lisaa(String sana, String kaannos) {
        this.sanat.putIfAbsent(sana, kaannos);
    }
    
    public int sanojenLukumaara() {
        return this.sanat.size();
    }
    
    public ArrayList<String> kaannoksetListana() {
        Set<String> avaimet = this.sanat.keySet();
        ArrayList<String> palautettava = new ArrayList<>();
        for (String avain : avaimet) {
            palautettava.add(avain + " = " + this.sanat.get(avain));
        }
        return palautettava;
    }
}
