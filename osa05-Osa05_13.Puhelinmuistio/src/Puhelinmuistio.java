
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Puhelinmuistio {
    private ArrayList<Henkilo> lista;
    
    public Puhelinmuistio() {
        this.lista = new ArrayList<>();
    }
    
    public void lisaa(String nimi, String numero) {
        this.lista.add(new Henkilo(nimi, numero));
    }
    
    public void tulostaKaikki() {
        for (Henkilo h : lista) {
            System.out.println(h);
        }
    }
    
    public String haeNumero(String nimi) {
        String palautettava = "numero ei tiedossa";
        for (Henkilo h : lista) {
            if (h.getNimi().equals(nimi)) {
                palautettava = h.getNumero();
            }
        }
        return palautettava;
    }
}
