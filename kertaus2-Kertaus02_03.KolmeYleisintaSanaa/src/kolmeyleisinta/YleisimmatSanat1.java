package kolmeyleisinta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class YleisimmatSanat1 implements ToistonTunnistin {

    YleisimmatSanat1() {
    }

    public List<String> yleisetSanat(List<String> sanat) {
        Map<String, Integer> sanojenEsiintymat = new HashMap<>();
        for (int i = 0; i < sanat.size(); i++) {
            sanojenEsiintymat.putIfAbsent(sanat.get(i), 0);
            sanojenEsiintymat.put(sanat.get(i), sanojenEsiintymat.get(sanat.get(i)) + 1);
        }

        String eka = "eiMitään";
        String toka = "eiMitään";
        String kolmas = "eiMitään";
        
        int ekaEsiinymat = 0;
        int tokaEsiinymat = 0;
        int kolmasEsiinymat = 0;

        Iterator<String> iteraattori = sanojenEsiintymat.keySet().iterator();
        while (iteraattori.hasNext()) {            
            String tarkasteltava = iteraattori.next();
            int esiintymat = sanojenEsiintymat.get(tarkasteltava);
            
            if (esiintymat > ekaEsiinymat || (esiintymat == ekaEsiinymat 
                    && tarkasteltava.length() < eka.length())) {
                kolmas = toka;
                toka = eka;
                eka = tarkasteltava;
                
                kolmasEsiinymat = tokaEsiinymat;
                tokaEsiinymat = ekaEsiinymat;
                ekaEsiinymat = esiintymat;
            } else if (esiintymat > tokaEsiinymat || (esiintymat == tokaEsiinymat 
                    && tarkasteltava.length() < toka.length())) {
                kolmas = toka;
                toka = tarkasteltava;
                
                kolmasEsiinymat = tokaEsiinymat;
                tokaEsiinymat = esiintymat;
            } else if (esiintymat > kolmasEsiinymat || (esiintymat == kolmasEsiinymat 
                    && tarkasteltava.length() < kolmas.length())) {
                kolmas = tarkasteltava;
                kolmasEsiinymat = esiintymat;
            }
        }
        
        List<String> palautettava = new ArrayList<>();
        palautettava.add(eka);
        palautettava.add(toka);
        palautettava.add(kolmas);

        return palautettava;
    }
}
