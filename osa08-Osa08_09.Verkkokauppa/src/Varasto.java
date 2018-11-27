
import java.util.HashMap;
import java.util.Map;
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
public class Varasto {
    private Map<String, Integer> tuotteidenHinnat;
    private Map<String, Integer> tuotteidenSaldot;
    
    public Varasto() {
        this.tuotteidenHinnat = new HashMap<>();
        this.tuotteidenSaldot = new HashMap<>();
    }
    
    public void lisaaTuote(String tuote, int hinta, int saldo) {
        this.tuotteidenHinnat.put(tuote, hinta);
        if (saldo < 0) {
            saldo = 0;
        }
        this.tuotteidenSaldot.put(tuote, saldo);
    }
    
    public int hinta(String tuote) {
        return this.tuotteidenHinnat.getOrDefault(tuote, -99);
    }
    
    public int saldo(String tuote) {
        return this.tuotteidenSaldot.getOrDefault(tuote, 0);
    }
    
    public boolean ota(String tuote) {
        if (saldo(tuote) == 0) {
            return false;
        }
        this.tuotteidenSaldot.put(tuote, saldo(tuote) - 1);
        return true;
    }
    
    public Set<String> tuotteet() {
        return this.tuotteidenHinnat.keySet();
    }
}
