package reseptit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reseptikirja {

    // lisää tänne oliomuuttujia
    private Map<String, Resepti> reseptit;
    
    public Reseptikirja() {
        // täydennä konstruktoria sopivasti -- pidä konstruktori
        // parametrittomana
        this.reseptit = new HashMap<>();
    }

    public void lisaaResepti(Resepti resepti) {
        // tee täällä jotain sopivaa
        this.reseptit.putIfAbsent(resepti.getNimi(), resepti);
    }

    public Resepti haeNimella(String nimi) {
        // toteuta tänne toiminnallisuus, joka palauttaa reseptin, jonka
        // nimi on täsmälleen haluttu. muulloin metodi palauttaa arvon null

        return this.reseptit.get(nimi);
    }

    public List<Resepti> haeRaakaAineella(String raakaAine) {
        // toteuta tänne toiminnallisuus, joka palauttaa kaikki reseptit, joissa
        // esiintyy haettu raaka-aine. Mikäli reseptejä ei ole lainkaan, palauta
        // tyhjä lista.
        ArrayList<Resepti> palautettava = new ArrayList<>();

        for (Resepti r : this.reseptit.values()) {
            if (r.getRaakaAineet().contains(raakaAine)) {
                palautettava.add(r);
            }
        }
        return palautettava;
    }

}
