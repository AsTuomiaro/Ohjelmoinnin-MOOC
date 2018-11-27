
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class UseanKaannoksenSanakirja {
    private HashMap<String, ArrayList<String>> sanakirja;
    
    public UseanKaannoksenSanakirja() {
        this.sanakirja = new HashMap<>();
    }
    
    public void lisaa(String sana, String kaannos) {
        ArrayList<String> kaannokset = kaanna(sana);
        kaannokset.add(kaannos);
        this.sanakirja.put(sana, kaannokset);
    }
    
    public void poista(String sana) {
        this.sanakirja.remove(sana);
    }
    
    public ArrayList<String> kaanna(String sana) {
        return this.sanakirja.getOrDefault(sana, new ArrayList<>());
    }
}
