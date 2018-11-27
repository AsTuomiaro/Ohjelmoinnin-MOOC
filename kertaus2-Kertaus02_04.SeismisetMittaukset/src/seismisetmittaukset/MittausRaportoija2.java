package seismisetmittaukset;

import java.util.ArrayList;
import java.util.List;

public class MittausRaportoija2 implements SeismisenToiminnanMittaaja {

    MittausRaportoija2() {
    }

    public List<SuurinTaajuusRaportti> paivittaisetMaksimit(List<Double> mittausData,
            int kuukausi) {
        List<SuurinTaajuusRaportti> palautettava = new ArrayList<>();
        if (mittausData == null || mittausData.isEmpty()) {
            return palautettava;
        }

        // Aloituspäivän formatointi.
        double data = mittausData.get(0);
        int aloitusPaivamaara = (int) data;
        aloitusPaivamaara = (aloitusPaivamaara / 10000) * 10000 + (kuukausi * 100);

        // Eristetään se osa listasta, josta ollaan kiinnostuneita, ja
        // tehdään sille halutut operaatiot.
        int aloitusIndeksi = 0;
        int lopetusIndeksi = 0;
        
        while (data < aloitusPaivamaara) {            
            aloitusIndeksi++;
            data = mittausData.get(aloitusIndeksi);
        }
        
        while (data < aloitusPaivamaara + 100) {
            lopetusIndeksi++;
            data = mittausData.get(lopetusIndeksi);
        }
        
        int i = aloitusIndeksi;
        while (i < lopetusIndeksi) {            
            data = mittausData.get(i);
            int mittauspaiva = (int) data;
            double max = -1;
            
            i++;
            data = mittausData.get(i);
            while (data < aloitusPaivamaara) {                
                if (data > max) {
                    max = data;
                }
                i++;
                data = mittausData.get(i);
            }
            
            palautettava.add(new SuurinTaajuusRaportti(mittauspaiva, max));
        }

        return palautettava;
    }
}
