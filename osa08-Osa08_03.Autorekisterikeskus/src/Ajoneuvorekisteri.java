
import java.util.ArrayList;
import java.util.Collection;
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
public class Ajoneuvorekisteri {
    private HashMap<Rekisterinumero, String> omistajat;
    
    public Ajoneuvorekisteri() {
        omistajat = new HashMap<>();
    }
    
    public boolean lisaa(Rekisterinumero rekkari, String omistaja) {
        if (hae(rekkari) == null) {
            this.omistajat.put(rekkari, omistaja);
            return true;
        }
        return false;
    }
    
    public String hae(Rekisterinumero rekkari) {
        return this.omistajat.get(rekkari);
    }
    
    public boolean poista(Rekisterinumero rekkari) {
        if (hae(rekkari) == null) {
            return false;
        }
        this.omistajat.remove(rekkari);
        return true;
    }
    
    public void tulostaRekisterinumerot() {
        Set<Rekisterinumero> rekkarit = this.omistajat.keySet();
        for (Rekisterinumero rekkari : rekkarit) {
            System.out.println(rekkari);
        }
    }
    
    public void tulostaOmistajat() {
        Collection<String> omistajienNimet = this.omistajat.values();
        ArrayList<String> erillisetNimet = new ArrayList<>();
        
        for (String omistaja : omistajienNimet) {
            if (!erillisetNimet.contains(omistaja)) {
                erillisetNimet.add(omistaja);
            }
        }
        
        for (String omistaja : erillisetNimet) {
            System.out.println(omistaja);
        }
    }
}
