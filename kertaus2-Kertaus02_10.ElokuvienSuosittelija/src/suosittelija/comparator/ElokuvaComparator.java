/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;

/**
 *
 * @author asko
 */
public class ElokuvaComparator implements Comparator<Elokuva>{
    public Map<Elokuva, List<Arvio>> arviot;
    
    public ElokuvaComparator(Map<Elokuva, List<Arvio>> arviot) {
        this.arviot = arviot;
    }

    @Override
    public int compare(Elokuva t, Elokuva t1) {
        double keskiarvo1 = this.arviot
                .getOrDefault(t, new ArrayList<>())
                .stream()
                .map(arvio -> arvio.getArvo())
                .mapToDouble(n -> n)
                .average().getAsDouble();
        
        double keskiarvo2 = this.arviot
                .getOrDefault(t1, new ArrayList<>())
                .stream()
                .map(arvio -> arvio.getArvo())
                .mapToDouble(n -> n)
                .average().getAsDouble();
        
        if (keskiarvo2 - keskiarvo1 > 0) {
            return 1;
        }
        if (keskiarvo2 - keskiarvo1 < 0) {
            return -1;
        }
        return 0;
    }
}
