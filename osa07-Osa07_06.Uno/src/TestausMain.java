
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
public class TestausMain {
    public static void main(String[] args) {
        Tekoalypelaaja pelaaja = new Tekoalypelaaja();
        
        ArrayList<Kortti> kasi = new ArrayList<>();
//        kasi.add(new Kortti("Ohitus", "Vihreä", -1));
        kasi.add(new Kortti("Numero", "Punainen", 5));
//        kasi.add(new Kortti("Villi kortti", "Punainen", -1));
        
        System.out.println("Pelaaja pelaa: ");
        System.out.println(pelaaja.pelaa(kasi, new Kortti("Suunnanvaihto", "Punainen", -1)
                , "-", new Pelitilanne(1)));
        
    }
}
