package seismisetmittaukset;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MittausRaportoija1 implements SeismisenToiminnanMittaaja {

    MittausRaportoija1() {
    }

    public List<SuurinTaajuusRaportti> paivittaisetMaksimit(List<Double> mittausData,
            int kuukausi) {
        List<SuurinTaajuusRaportti> palautettava = new ArrayList<>();
        if (mittausData == null || mittausData.isEmpty()) {
            return palautettava;
        }

        Iterator<Double> iteraattori = mittausData.iterator();
        double data = iteraattori.next();

        // Aloituspäivämäärän formatointi.
        int aloitusPaivamaara = (int) data;
        aloitusPaivamaara = (aloitusPaivamaara / 10000) * 10000 + (kuukausi * 100);

        // Vieritetään iteraattori aloituspäivämäärän ohi.
        while (iteraattori.hasNext() && data < aloitusPaivamaara) {
            data = iteraattori.next();
        }

        while (iteraattori.hasNext() && data < aloitusPaivamaara + 100) {
            int mittauspaiva = (int) data;
            data = iteraattori.next();
            double max = -1;

            // Käsitellään päivän kaikki mittaukset.
            while (iteraattori.hasNext() && data < aloitusPaivamaara) {
                if (data > max) {
                    max = data;
                }
                data = iteraattori.next();
            }

            // Asetetaan halutut tiedot uuteen raporttiin.
            palautettava.add(new SuurinTaajuusRaportti(mittauspaiva, max));
        }

        return palautettava;
    }

}
