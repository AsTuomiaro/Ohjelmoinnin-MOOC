/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerotiedustelu.logiikka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import numerotiedustelu.domain.Henkilo;

/**
 *
 * @author asko
 */
public class Numerokeskus {

    private Map<String, Henkilo> henkilotNimenPerusteella, henkilotNumeronPerusteella;

    public Numerokeskus() {
        this.henkilotNimenPerusteella = new HashMap<>();
        this.henkilotNumeronPerusteella = new HashMap<>();
    }

    public void lisaaUusiNumero(String nimi, String numero) {
        lisaaHenkilo(nimi);
        Henkilo henkilo = haeNimella(nimi);

        henkilo.lisaaNumero(numero);
        this.henkilotNumeronPerusteella.put(numero, henkilo);
    }

    public void lisaaHenkilo(String nimi) {
        this.henkilotNimenPerusteella.putIfAbsent(nimi, new Henkilo(nimi));
    }

    public Henkilo haeNimella(String nimi) {
        return this.henkilotNimenPerusteella.get(nimi);
    }

    public Henkilo haeNumerolla(String numero) {
        return this.henkilotNumeronPerusteella.get(numero);
    }

    public void poistaHenkilo(String nimi) {
        Henkilo henkilo = haeNimella(nimi);
        if (henkilo == null) {
            return;
        }
        this.henkilotNimenPerusteella.remove(nimi);
        for (String numero : henkilo.getPuhelinnumerot()) {
            this.henkilotNumeronPerusteella.remove(numero);
        }
    }

    public ArrayList<Henkilo> haku(String hakusana) {
        ArrayList<Henkilo> tulos = new ArrayList<>();
        Collection<Henkilo> kaikkiHenkilot = this.henkilotNimenPerusteella.values();
        for (Henkilo henkilo : kaikkiHenkilot) {
            if (henkilo.getNimi().indexOf(hakusana) > -1
                    || henkilo.getKatu().indexOf(hakusana) > -1 
                    || henkilo.getKaupunki().indexOf(hakusana) > -1) {
                tulos.add(henkilo);
            }
        }

        return tulos;
    }
}
