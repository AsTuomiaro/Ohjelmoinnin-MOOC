package vaalit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Tekstimalli {
    private HashMap<String, Sanajakauma> sanat;
    
    public Tekstimalli() {
        this.sanat = new HashMap<>();
    }

    public void lisaaAineisto(String aineisto) {
        String[] sanatArrayna = aineisto.split("\\s+");
        this.sanat.putIfAbsent(sanatArrayna[0], new Sanajakauma());
        
        for (int i = 1; i < sanatArrayna.length; i++) {
            this.sanat.putIfAbsent(sanatArrayna[i], new Sanajakauma());
            this.sanat.get(sanatArrayna[i - 1]).lisaaSana(sanatArrayna[i]);
        }
    }

    public String annaSana(String edeltava) {
        Sanajakauma jakauma = this.sanat.get(edeltava);
        if (jakauma == null) {
            return null;
        }
        return jakauma.annaSana();
    }
    
    public List<String> sanat() {
        return this.sanat.keySet().stream()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
