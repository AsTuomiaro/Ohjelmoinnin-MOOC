package hirsipuu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hirsipuu {

    private Sanalista sanalista;
    private int arvauksiaJaljella;
    private String arvattava;
    private List<Character> arvaukset, vaaratArvaukset;
    private boolean onLoppu;

    public Hirsipuu(Sanalista sanalista, int arvauksiaAlussa) {
        this.sanalista = sanalista;
        this.arvauksiaJaljella = arvauksiaAlussa;

        Collections.shuffle(this.sanalista.sanat());
        this.arvattava = this.sanalista.sanat().get(0);

        this.arvaukset = new ArrayList<>();
        this.vaaratArvaukset = new ArrayList<>();
        this.onLoppu = false;
    }

    public List<Character> arvaukset() {
        return this.arvaukset;
    }

    public int arvauksiaJaljella() {
        return this.arvauksiaJaljella;
    }

    public boolean arvaa(Character kirjain) {
        this.arvaukset.add(kirjain);

        if (this.arvattava.indexOf(kirjain) < 0) {
            this.arvauksiaJaljella--;
            this.vaaratArvaukset.add(kirjain);
            return false;
        }

        String nykyinenSana = this.sana();

        for (int i = 0; i < this.vaaratArvaukset.size(); i++) {
            this.sanalista = this.sanalista
                    .sanatJoissaEiEsiinnyKirjainta(this.vaaratArvaukset.get(i));
        }
        
        this.sanalista = this.sanalista.sanatJoissaMerkit(nykyinenSana);
        Collections.shuffle(this.sanalista.sanat());
        this.arvattava = this.sanalista.sanat().get(0);

        if (this.arvattava.equals(nykyinenSana)) {
            this.onLoppu = true;
        }
        return true;
    }

    public String sana() {
        String palautettava = "";
        for (int i = 0; i < this.arvattava.length(); i++) {
            char merkki = this.arvattava.charAt(i);
            if (this.arvaukset.contains(merkki)) {
                palautettava += merkki;
            } else {
                palautettava += '-';
            }
        }
        return palautettava;
    }

    public String oikeaSana() {
        return this.arvattava;
    }

    public boolean onLoppu() {
        return this.onLoppu;
    }

}
