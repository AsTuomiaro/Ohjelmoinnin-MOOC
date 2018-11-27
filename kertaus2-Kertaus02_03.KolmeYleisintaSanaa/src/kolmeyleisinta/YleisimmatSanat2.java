package kolmeyleisinta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YleisimmatSanat2 implements ToistonTunnistin {

    YleisimmatSanat2() {
    }

    @Override
    public List<String> yleisetSanat(List<String> sanat) {
        Map<String, Integer> sanojenEsiintymat = new HashMap<>();
        for (int i = 0; i < sanat.size(); i++) {
            sanojenEsiintymat.putIfAbsent(sanat.get(i), 0);
            sanojenEsiintymat.put(sanat.get(i), sanojenEsiintymat.get(sanat.get(i)) + 1);
        }
        
        List<String> palautettava = sanojenEsiintymat
                .keySet()
                .stream()
                .sorted((t, t1) -> {
                    int eka = sanojenEsiintymat.getOrDefault(t, 0);
                    int toka = sanojenEsiintymat.getOrDefault(t1, 0);
                    if (toka == eka) {
                        return t.length() - t1.length();
                    }
                    return toka - eka;
                }).collect(Collectors.toCollection(ArrayList::new));
        
        return palautettava.subList(0, 3);
    }
}
