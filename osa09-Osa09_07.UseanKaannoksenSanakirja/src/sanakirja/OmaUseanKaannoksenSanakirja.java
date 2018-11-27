/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author asko
 */
public class OmaUseanKaannoksenSanakirja implements UseanKaannoksenSanakirja {
    private Map<String, Set<String>> kaannokset;
    
    public OmaUseanKaannoksenSanakirja() {
        this.kaannokset = new HashMap<>();
    }
    
    @Override
    public Set<String> kaanna(String sana) {
        return this.kaannokset.getOrDefault(sana, new HashSet<>());
    }

    @Override
    public void lisaa(String sana, String kaannos) {
        this.kaannokset.putIfAbsent(sana, new HashSet<>());
        this.kaannokset.get(sana).add(kaannos);
    }

    @Override
    public void poista(String sana) {
        this.kaannokset.remove(sana);
    }
}
