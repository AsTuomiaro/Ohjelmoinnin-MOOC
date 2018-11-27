
import java.util.ArrayList;

// luo tänne luokkaan oma tekoälysi Uno-peliä varten
public class Tekoalypelaaja implements Pelaaja {

    // Saat luoda tarvittaessa oliomuuttujia. Jos luot konstruktorin, varmista
    // että tekoäly toimii myös parametrittomalla konstruktorilla, eli kutsulla
    // Tekoalypelaaja pelaaja = new Tekoalypelaaja();
    
    // Tekijän huomio: Tämä tekoäly ei yritä pelata järkevästi, vaan
    // pyrkii ylipäätään pelaamaan jotain. Se teenkö tähän vielä muutoksia
    // jää nähtäväksi.
    @Override
    public int pelaa(ArrayList<Kortti> omatKortit, Kortti paallimmaisin, String vari, Pelitilanne tilanne) {
        int palautettava = -1;
        int villikortti = -1;
        for (int i = 0; i < omatKortit.size(); i++) {
            Kortti k = omatKortit.get(i);
            if (k.getVari().equals(vari) || k.getVari().equals(paallimmaisin.getVari())
                    || (k.getKorttityyppi().equals("Numero") && k.getNumero() == paallimmaisin.getNumero())) {
                palautettava = i;
            }
            if (k.getKorttityyppi().equals(paallimmaisin.getKorttityyppi()) && k.getNumero() < 0) {
                palautettava = i;
            }

            if (k.onVillikortti()) {
                villikortti = i;
            }
        }
        if (palautettava == -1 && villikortti >= 0) {
            palautettava = villikortti;
        }
        if (palautettava >= 0 && !omatKortit.get(palautettava).saaPelataKortin(paallimmaisin, vari)) {
            palautettava = -1;
        }

        return palautettava;
    }

    @Override
    public String valitseVari(ArrayList<Kortti> omatKortit) {
        String[] okVarit = {"Punainen", "Vihreä", "Sininen", "Keltainen"};
        return okVarit[0];
    }

    @Override
    public String nimi() {
        // kirjoita tänne nimimerkkisi, jonka haluat mahdollisesti näkyvän 
        // myös muualla

        return "Erkki Esimerkki";
    }

}
