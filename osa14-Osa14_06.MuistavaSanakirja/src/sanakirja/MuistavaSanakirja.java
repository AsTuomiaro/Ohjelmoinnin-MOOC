/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author asko
 */
public class MuistavaSanakirja {
    private Map<String, String> kaannoksetEka, kaannoksetToka;
    private String tiedosto;
    
    public MuistavaSanakirja() {
        this.kaannoksetEka = new HashMap<>();
        this.kaannoksetToka = new HashMap<>();
        this.tiedosto = "";
    }
    
    public MuistavaSanakirja(String tiedosto) {
        this();
        this.tiedosto = tiedosto;
    }
    
    public boolean lataa() {
        try (Scanner tiedostolukija = new Scanner(new File(this.tiedosto))) {
            while (tiedostolukija.hasNextLine()) {                
                String rivi = tiedostolukija.nextLine();
                String[] osat = rivi.split(":");
                lisaa(osat[0], osat[1]);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean tallenna() {
        try (PrintWriter kirjoittaja = new PrintWriter(new File(this.tiedosto))) {
            Iterator<String> iteraattori = this.kaannoksetEka.keySet().iterator();
            while (iteraattori.hasNext()) {                
                String sana = iteraattori.next();
                String kaannos = this.kaannoksetEka.get(sana);
                kirjoittaja.println(sana + ":" + kaannos);
            }
//            kirjoittaja.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public void lisaa(String sana, String kaannos) {
        this.kaannoksetEka.putIfAbsent(sana, kaannos);
        this.kaannoksetToka.putIfAbsent(kaannos, sana);
    }
    
    public String kaanna(String sana) {
        String kaannos = this.kaannoksetEka.get(sana);
        if (kaannos == null) {
            kaannos = this.kaannoksetToka.get(sana);
        }
        return kaannos;
    }
    
    public void poista(String sana) {
        String kaannos = kaanna(sana);
        this.kaannoksetEka.remove(sana);
        this.kaannoksetToka.remove(sana);
        this.kaannoksetEka.remove(kaannos);
        this.kaannoksetToka.remove(kaannos);
    }
}
