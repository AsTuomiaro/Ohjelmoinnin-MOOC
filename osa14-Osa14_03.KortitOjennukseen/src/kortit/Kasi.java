/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author asko
 */
public class Kasi implements Comparable<Kasi>{
    private ArrayList<Kortti> kortit;
    
    public Kasi() {
        this.kortit = new ArrayList<>();
    }
    
    public void lisaa(Kortti kortti) {
        this.kortit.add(kortti);
    }

    public ArrayList<Kortti> getKortit() {
        return kortit;
    }
    
    public void tulosta() {
        kortit.stream().forEach((kortti) -> System.out.println(kortti));
    }
    
    public void jarjesta() {
        Collections.sort(kortit);
    }
    
    public void jarjestaMaittain() {
        Collections.sort(kortit, new SamatMaatVierekkainArvojarjestykseen());
    }

    @Override
    public int compareTo(Kasi t) {
        int omaArvo = this.kortit.stream().mapToInt(kortti -> kortti.getArvo()).sum();
        int vertailtava = t.getKortit().stream().mapToInt(kortti -> kortti.getArvo()).sum();
        
        return omaArvo - vertailtava;
    }
}
