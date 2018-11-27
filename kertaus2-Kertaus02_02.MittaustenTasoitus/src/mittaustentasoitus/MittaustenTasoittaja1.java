package mittaustentasoitus;

import java.util.ArrayList;
import java.util.List;

public class MittaustenTasoittaja1 implements Tasoittava {

    MittaustenTasoittaja1() {
    }

    public List<Double> tasoita(List<Henkilo> henkilotiedot) {
        List<Double> palautettava = new ArrayList<>();
        
        if (henkilotiedot == null || henkilotiedot.isEmpty()) {
            return palautettava;
        }
        
        palautettava.add((double) henkilotiedot.get(0).getSyke());
        
        for (int i = 1; i < henkilotiedot.size() - 1; i++) {
            double edellinen = henkilotiedot.get(i - 1).getSyke();
            double nykyinen = henkilotiedot.get(i).getSyke();
            double seuraava = henkilotiedot.get(i + 1).getSyke();
            
            palautettava.add((edellinen + nykyinen + seuraava) / 3);
        }
        if (henkilotiedot.size() > 1) {
            palautettava.add((double) henkilotiedot.get(henkilotiedot.size() - 1).getSyke());
        }
        
        return palautettava;
    }
}
