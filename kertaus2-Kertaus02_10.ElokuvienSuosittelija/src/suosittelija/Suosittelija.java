/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import suosittelija.domain.*;
import suosittelija.comparator.*;

/**
 *
 * @author asko
 */
public class Suosittelija {

    private ArvioRekisteri rekisteri;

    public Suosittelija(ArvioRekisteri rekisteri) {
        this.rekisteri = rekisteri;
    }

    public Elokuva suositteleElokuva(Henkilo henkilo) {
        Elokuva palautettava = null;
        if (henkilo == null) {
            return null;
        }

        // Tarkistetaan, onko henkilö arvioinut yhtään elokuvaa.
        if (rekisteri.annaHenkilonArviot(henkilo).isEmpty()) {
            Map<Elokuva, List<Arvio>> arviot = rekisteri.elokuvienArviot();
            ElokuvaComparator vertailija = new ElokuvaComparator(arviot);

            List<Elokuva> elokuvat = arviot.keySet().stream()
                    .sorted(vertailija)
                    .collect(Collectors.toCollection(ArrayList::new));

            if (elokuvat.isEmpty()) {
                return null;
            }
            palautettava = elokuvat.get(0);
        } else {
            Set<Elokuva> nahdyt = rekisteri.annaHenkilonArviot(henkilo).keySet();
            List<Henkilo> arvioijat = rekisteri.arvioijat();
            
            // Jos kukaan muu ei ole arvioinut elokuvia, niin lopetetaan tähän.
            if (arvioijat.size() < 2) {
                return null;
            }
            
            // Kerätään vertaisarviot yhteen paikkaan, ja asetetaan ne järjestykseen.
            Map<Henkilo, Integer> vertailut = new HashMap<>();
            for (int i = 0; i < arvioijat.size(); i++) {
                Henkilo h = arvioijat.get(i);
                if (h.equals(henkilo)) {
                    continue;
                }
                
                int vertailuLuku = 0;
                Iterator<Elokuva> iteraattori = nahdyt.iterator();
                while (iteraattori.hasNext()) {                    
                    Elokuva leffa = iteraattori.next();
                    vertailuLuku += rekisteri.haeArvio(henkilo, leffa).getArvo() 
                            * rekisteri.haeArvio(h, leffa).getArvo();
                }
                
                vertailut.put(h, vertailuLuku);
            }
            arvioijat.sort(new HenkiloComparator(vertailut));
            
            // Tarkastellaan sopivimman henkilön arvioimia elokuvia, ja
            // palautetaan sellainen, joka on arvioitu olemaan joko OK tai HYVA.
            Henkilo haluttu = arvioijat.get(0);
            Set<Elokuva> mahdollisetElokuvat = rekisteri.annaHenkilonArviot(haluttu).keySet();
            Iterator<Elokuva> uusiIteraattori = mahdollisetElokuvat.iterator();
            
            while (uusiIteraattori.hasNext()) {                
                Elokuva uusiLeffa = uusiIteraattori.next();
                if (!nahdyt.contains(uusiLeffa) && rekisteri.haeArvio(haluttu, uusiLeffa).getArvo() > 1) {
                    palautettava = uusiLeffa;
                }
            }
        }
        
        return palautettava;
    }
}
