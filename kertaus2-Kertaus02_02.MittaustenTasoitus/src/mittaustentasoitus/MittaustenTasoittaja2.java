package mittaustentasoitus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MittaustenTasoittaja2 implements Tasoittava {

    MittaustenTasoittaja2() {
    }

    public List<Double> tasoita(List<Henkilo> henkilotiedot) {
        List<Double> palautettava = new ArrayList<>();
        
        if (henkilotiedot == null || henkilotiedot.isEmpty()) {
            return palautettava;
        }
        
        Iterator<Henkilo> iteraattori = henkilotiedot.iterator();
        
        double edellinen = iteraattori.next().getSyke();
        double seuraava = edellinen;
        
        if (iteraattori.hasNext()) {
            palautettava.add(edellinen);
            seuraava = iteraattori.next().getSyke();
        }
        while (iteraattori.hasNext()) {            
            double nykyinen = seuraava;
            seuraava = iteraattori.next().getSyke();
            palautettava.add((edellinen + nykyinen + seuraava) / 3);
            edellinen = nykyinen;
        }
        
        palautettava.add(seuraava);
        
        return palautettava;
    }
}
