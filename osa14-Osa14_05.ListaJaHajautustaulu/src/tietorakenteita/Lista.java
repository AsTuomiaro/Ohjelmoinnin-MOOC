/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteita;

/**
 *
 * @author asko
 * @param <T>
 */
public class Lista<T> {
    
    // Yksityiset kentät.
    private T[] taulukko;
    private int indeksi;
    
    
    // Julkiset metodit
    public Lista() {
        this.taulukko = (T[]) new Object[9];
        this.indeksi = 0;
    }
    
    public boolean sisaltaa(T arvo) {
        int i = arvonIndeksi(arvo);
        return i != -1;
    }
    
    public void lisaa(T arvo) {
        if (this.indeksi == this.taulukko.length) {
            kasvata();
        }
        
        this.taulukko[this.indeksi] = arvo;
        this.indeksi++;
    }
    
    public void poista(T arvo) {
        int arvonIndeksi = 0;
        while (arvonIndeksi < this.indeksi && !this.taulukko[arvonIndeksi].equals(arvo)) {            
            arvonIndeksi++;
        }
        
        if (arvonIndeksi == this.indeksi) {
            return;
        }
        
        while (arvonIndeksi < this.indeksi - 1) {            
            this.taulukko[arvonIndeksi] = this.taulukko[arvonIndeksi + 1];
            arvonIndeksi++;
        }
        
        this.indeksi--;
        if (this.indeksi <= this.taulukko.length / 2) {
            kutista();
        }
    }
    
    public T arvo(int i) {
        if (i < 0 || i >= this.indeksi) {
            throw new IndexOutOfBoundsException("Indeksi " + i + " alueen [0, " 
                    + this.indeksi + "[ ulkopuolella.");
        }
        return this.taulukko[i];
    }
    
    public int arvonIndeksi(T arvo) {
        for (int i = 0; i < this.indeksi; i++) {
            if ((arvo == null && this.taulukko[i] == null) || this.taulukko[i].equals(arvo)) {
                return i;
            }
        }
        return -1;
    }
    
    public int koko() {
        return this.indeksi;
    }
    
    public boolean onTyhja() {
        return this.indeksi == 0;
    }
    
    // Yksityiset metodit.
    private void kasvata() {
        int koko = this.taulukko.length;
        koko = koko * 3/2 + 1;
        
        T[] uusiTaulukko = (T[]) new Object[koko];
        for (int i = 0; i < this.taulukko.length; i++) {
            uusiTaulukko[i] = this.taulukko[i];
        }
        
        this.taulukko = uusiTaulukko;
    }
    
    private void kutista() {
        int koko = this.taulukko.length;
        koko = koko / 2 + 1;
        
        T[] uusiTaulukko = (T[]) new Object[koko];
        for (int i = 0; i < koko; i++) {
            uusiTaulukko[i] = this.taulukko[i];
        }
        
        this.taulukko = uusiTaulukko;
    }
}
