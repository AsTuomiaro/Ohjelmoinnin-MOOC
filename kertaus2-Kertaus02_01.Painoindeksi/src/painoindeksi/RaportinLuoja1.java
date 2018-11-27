package painoindeksi;

import java.util.ArrayList;
import java.util.List;

public class RaportinLuoja1 implements Raportoiva {

    public RaportinLuoja1() {
    }

    @Override
    public PainoindeksiRaportti painoindeksiRaportti(List<Henkilo> henkilotiedot) {
        List<String> alipainoiset, normaalipainoiset, ylipainoiset, merkittavastiYlipainoiset;
        alipainoiset = new ArrayList<>();
        normaalipainoiset = new ArrayList<>();
        ylipainoiset = new ArrayList<>();
        merkittavastiYlipainoiset = new ArrayList<>();
        
        
        for (int i = 0; i < henkilotiedot.size(); i++) {
            Henkilo h = henkilotiedot.get(i);
            double bmi = h.getPaino() / (h.getPituus() * h.getPituus());
            if (bmi < 18.5) {
                alipainoiset.add(h.getNimi());
            } else if (bmi < 25) {
                normaalipainoiset.add(h.getNimi());
            } else if (bmi < 30) {
                ylipainoiset.add(h.getNimi());
            } else {
                merkittavastiYlipainoiset.add(h.getNimi());
            }
        }
        
        return new PainoindeksiRaportti(alipainoiset, 
                normaalipainoiset, ylipainoiset, merkittavastiYlipainoiset);
    }
}
