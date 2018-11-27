package hirsipuu;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Sanalista {

    private List<String> sanat;

    public Sanalista(List<String> sanat) {
        this.sanat = sanat;
    }

    public List<String> sanat() {
        return this.sanat;
    }

    public Sanalista sanatJoidenPituusOn(int pituus) {
        List<String> valitutSanat = this.sanat.stream()
                .filter(sana -> sana.length() == pituus)
                .collect(Collectors.toCollection(ArrayList::new));
        return new Sanalista(valitutSanat);
    }

    public Sanalista sanatJoissaEiEsiinnyKirjainta(char kirjain) {
        List<String> valitutSanat = this.sanat.stream()
                .filter(sana -> {
                    return sana.indexOf(kirjain) < 0;
                })
                .collect(Collectors.toCollection(ArrayList::new));
        return new Sanalista(valitutSanat);
    }

    public Sanalista sanatJoissaMerkit(String merkkijono) {
        String regex = "";
        for (int i = 0; i < merkkijono.length(); i++) {
            char merkki = merkkijono.charAt(i);
            if (merkki == '-') {
                regex += "(\\w|ä|ö)";
            } else {
                regex += merkki;
            }
        }
        
        final String verrattava = regex;
        List<String> valitutSanat = this.sanat.stream()
                .filter(sana -> {
                    return sana.matches(verrattava);
                })
                .collect(Collectors.toCollection(ArrayList::new));
        return new Sanalista(valitutSanat);
    }

    public int koko() {
        return this.sanat.size();
    }
}
