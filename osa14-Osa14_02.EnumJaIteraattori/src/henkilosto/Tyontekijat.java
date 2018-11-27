/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilosto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author asko
 */
public class Tyontekijat {
    private List<Henkilo> henkilosto;
    
    public Tyontekijat() {
        this.henkilosto = new ArrayList<>();
    }
    
    public void lisaa(Henkilo lisattava) {
        this.henkilosto.add(lisattava);
    }
    
    public void lisaa(List<Henkilo> lisattavat) {
        Iterator<Henkilo> iteraattori = lisattavat.iterator();
        while (iteraattori.hasNext()) {            
            lisaa(iteraattori.next());
        }
    }
    
    public void tulosta() {
        Iterator<Henkilo> iteraattori = this.henkilosto.iterator();
        while (iteraattori.hasNext()) {            
            System.out.println(iteraattori.next());
        }
    }
    
    public void tulosta(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = this.henkilosto.iterator();
        while (iteraattori.hasNext()) {            
            Henkilo h = iteraattori.next();
            if (koulutus.equals(h.getKoulutus())) {
                System.out.println(h);
            }
        }
    }
    
    public void irtisano(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = this.henkilosto.iterator();
        while (iteraattori.hasNext()) {            
            Henkilo h = iteraattori.next();
            if (koulutus.equals(h.getKoulutus())) {
                iteraattori.remove();
            }
        }
    }
}
