/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lentokentta.logiikka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import lentokentta.domain.Lentokone;
import lentokentta.domain.Lento;

/**
 *
 * @author asko
 */
public class Lentohallinta {
    private HashMap<String, Lentokone> lentokoneet;
    private ArrayList<Lento> lennot;
    
    public Lentohallinta() {
        this.lentokoneet = new HashMap<>();
        this.lennot = new ArrayList<>();
    }
    
    public void lisaaLentokone(String tunnus, int kapasiteetti) {
        this.lentokoneet.putIfAbsent(tunnus, new Lentokone(tunnus, kapasiteetti));
    }
    
    public void lisaaLento(Lentokone lentokone, String lahtotunnus, String kohdetunnus) {
        this.lennot.add(new Lento(lentokone, lahtotunnus, kohdetunnus));
    }
    
    public Lentokone haeLentokone(String tunnus) {
        return this.lentokoneet.get(tunnus);
    }

    public ArrayList<Lento> getLennot() {
        return lennot;
    }

    public Collection<Lentokone> getLentokoneet() {
        return this.lentokoneet.values();
    }
}
