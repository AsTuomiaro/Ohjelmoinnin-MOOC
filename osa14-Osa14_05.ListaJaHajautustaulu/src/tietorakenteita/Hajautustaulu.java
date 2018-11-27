/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteita;


/**
 *
 * @author asko
 */
public class Hajautustaulu<K, V> {
    private Lista<Pari<K, V>>[] pariListat;
    private int indeksi;
    
    public Hajautustaulu() {
        this.pariListat = new Lista[32];
        this.indeksi = 0;
    }
    
    public V hae(K avain) {
        int hajautusarvo = Math.abs(avain.hashCode() % this.pariListat.length);
        
        if (this.pariListat[hajautusarvo] == null) {
            return null;
        }
        
        Lista<Pari<K, V>> listaIndeksissa = this.pariListat[hajautusarvo];
        
        for (int i = 0; i < listaIndeksissa.koko(); i++) {
            if (listaIndeksissa.arvo(i).getAvain().equals(avain)) {
                return listaIndeksissa.arvo(i).getArvo();
            }
        }
        
        return null;
    }
    
    public void lisaa(K avain, V arvo) {
        int hajautusarvo = Math.abs(avain.hashCode() % this.pariListat.length);
        if (this.pariListat[hajautusarvo] == null) {
            this.pariListat[hajautusarvo] = new Lista<>();
        }
        
        Lista<Pari<K, V>> listaIndeksissa = this.pariListat[hajautusarvo];
        boolean eiLoytynyt = true;
        
        for (int i = 0; i < listaIndeksissa.koko(); i++) {
            if (listaIndeksissa.arvo(i).getAvain().equals(avain)) {
                listaIndeksissa.arvo(i).setArvo(arvo);
                eiLoytynyt = false;
                break;
            }
        }
        
        if (eiLoytynyt) {
            listaIndeksissa.lisaa(new Pari<>(avain, arvo));
            this.indeksi++;
        }
        
        if (1.0 * this.indeksi / this.pariListat.length > 0.75) {
            kasvata();
        }
    }
    
    public V poista(K avain) {
        int hajautusarvo = Math.abs(avain.hashCode() % this.pariListat.length);
        if (this.pariListat[hajautusarvo] == null) {
            return null;
        }
        
        Lista<Pari<K, V>> listaIndeksissa = this.pariListat[hajautusarvo];
        
        for (int i = 0; i < listaIndeksissa.koko(); i++) {
            if (listaIndeksissa.arvo(i).getAvain().equals(avain)) {
                Pari<K,V> haettuPari = listaIndeksissa.arvo(i);
                listaIndeksissa.poista(haettuPari);
                return haettuPari.getArvo();
            }
        }
        
        return null;
    }
    
    private void kasvata() {
        Lista<Pari<K,V>>[] uusiPariLista = new Lista[this.pariListat.length * 2 + 1];
        
        for (int i = 0; i < this.pariListat.length; i++) {
            kopioi(uusiPariLista, i);
        }
        
        this.pariListat = uusiPariLista;
    }
    
    private void kopioi(Lista<Pari<K,V>>[] uusiLista, int indeksista) {
        int raja = 0;
        
        if (this.pariListat[indeksista] != null) {
            raja = this.pariListat[indeksista].koko();
        }
        
        for (int i = 0; i < raja; i++) {
            Pari<K,V> pari = this.pariListat[indeksista].arvo(i);
            int hajautusarvo = Math.abs(pari.getAvain().hashCode() % uusiLista.length);
            
            if (uusiLista[hajautusarvo] == null) {
                uusiLista[hajautusarvo] = new Lista<>();
            }
            
            uusiLista[hajautusarvo].lisaa(pari);
        }
    }
}
