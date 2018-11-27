/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerotiedustelu.domain;

import java.util.ArrayList;

/**
 *
 * @author asko
 */
public class Henkilo {
    private String nimi;
    private String katu, kaupunki;
    private ArrayList<String> puhelinnumerot;
    
    public Henkilo(String nimi) {
        this.nimi = nimi;
        this.katu = "";
        this.kaupunki = "";
        this.puhelinnumerot = new ArrayList<>();
    }

    public String getNimi() {
        return nimi;
    }

    public String getKatu() {
        return katu;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    public void setKatu(String katu) {
        this.katu = katu;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }
    
    public void lisaaNumero(String uusiNumero) {
        this.puhelinnumerot.add(uusiNumero);
    }

    public ArrayList<String> getPuhelinnumerot() {
        return puhelinnumerot;
    }
}
