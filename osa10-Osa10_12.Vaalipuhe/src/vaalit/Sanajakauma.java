package vaalit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Sanajakauma {
    private Map<String, Integer> sanojenLukumaarat;
    
    public Sanajakauma() {
        this.sanojenLukumaarat = new HashMap<>();
    }

    public void lisaaSana(String sana) {
        this.sanojenLukumaarat.putIfAbsent(sana, 0);
        this.sanojenLukumaarat.put(sana, this.sanojenLukumaarat.get(sana) + 1);
    }

    public int esiintymiskertoja(String sana) {
        return this.sanojenLukumaarat.getOrDefault(sana, 0);
    }

    public String annaSana() {
        Set<String> sanat = this.sanojenLukumaarat.keySet();
        if (sanat.isEmpty()) {
            return null;
        }
        
        int kokonaissumma = sanat.stream().mapToInt(sana -> this.sanojenLukumaarat.get(sana)).sum();
        int rnd = new Random().nextInt(kokonaissumma);
        
        Iterator<String> iteraattori = sanat.iterator();
        String palautettava = iteraattori.next();
        int summa = this.sanojenLukumaarat.get(palautettava);
        
        while (summa <= rnd) {
            palautettava = iteraattori.next();
            summa += this.sanojenLukumaarat.get(palautettava);
        }
        return palautettava;
    }
}
