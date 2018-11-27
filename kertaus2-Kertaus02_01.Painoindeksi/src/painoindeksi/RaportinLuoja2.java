package painoindeksi;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RaportinLuoja2 implements Raportoiva {

    public RaportinLuoja2() {
    }

    @Override
    public PainoindeksiRaportti painoindeksiRaportti(List<Henkilo> henkilotiedot) {
        List<String> alipainoiset = henkilotiedot.stream()
                .filter(h -> {
                    return h.getPaino() / (h.getPituus() * h.getPituus()) < 18.5;
                }).map(h -> h.getNimi())
                .collect(Collectors.toCollection(ArrayList::new));
        
        List<String> normaalipainoiset = henkilotiedot.stream()
                .filter(h -> {
                    double bmi = h.getPaino() / (h.getPituus() * h.getPituus());
                    return bmi >= 18.5 && bmi < 25;
                }).map(h -> h.getNimi())
                .collect(Collectors.toCollection(ArrayList::new));
        
        List<String> ylipainoiset = henkilotiedot.stream()
                .filter(h -> {
                    double bmi = h.getPaino() / (h.getPituus() * h.getPituus());
                    return bmi >= 25 && bmi < 30;
                }).map(h -> h.getNimi())
                .collect(Collectors.toCollection(ArrayList::new));
        
        List<String> merkittavastiYlipainoiset = henkilotiedot.stream()
                .filter(h -> {
                    double bmi = h.getPaino() / (h.getPituus() * h.getPituus());
                    return bmi >= 30;
                }).map(h -> h.getNimi())
                .collect(Collectors.toCollection(ArrayList::new));
        
        return new PainoindeksiRaportti(alipainoiset, normaalipainoiset, 
                ylipainoiset, merkittavastiYlipainoiset);
    }
}
