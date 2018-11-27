
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Ostoskori {
    private Map<String, Ostos> ostokset;
    
    public Ostoskori() {
        this.ostokset = new HashMap<>();
    }
    
    public void lisaa(String tuote, int hinta) {
        this.ostokset.putIfAbsent(tuote, new Ostos(tuote, 0, hinta));
        Ostos ostos = this.ostokset.get(tuote);
        ostos.kasvataMaaraa();
    }
    
    public int hinta() {
        Collection<Ostos> o = this.ostokset.values();
        int palautettava = 0;
        for (Ostos p : o) {
            palautettava += p.hinta();
        }
        return palautettava;
    }
    
    public void tulosta() {
        Collection<Ostos> o = this.ostokset.values();
        for (Ostos p : o) {
            System.out.println(p);
        }
    }
}
