package jarjestaminen;

import java.util.Arrays;

public class Valintajarjestaminen {
    
    public int pienin(int[] taulukko) {
        if (taulukko == null || taulukko.length == 0) {
            return -1;
        }
        
        int palautettava = taulukko[0];
        
        for (int i = 1; i < taulukko.length; i++) {
            if (palautettava > taulukko[i]) {
                palautettava = taulukko[i];
            }
        }
        
        return palautettava;
    }
    
    public int pienimmanIndeksi(int[] taulukko) {
        if (taulukko == null || taulukko.length == 0) {
            return -1;
        }
        
        int pienin = taulukko[0];
        int indeksi = 0;
        
        for (int i = 1; i < taulukko.length; i++) {
            if (pienin > taulukko[i]) {
                pienin = taulukko[i];
                indeksi = i;
            }
        }
        
        return indeksi;
    }
    
    public int pienimmanIndeksiAlkaen(int[] taulukko, int aloitusindeksi) {
        if (taulukko == null || taulukko.length == 0 || aloitusindeksi >= taulukko.length) {
            return -1;
        }
        
        int pienin = taulukko[aloitusindeksi];
        int indeksi = aloitusindeksi;
        
        for (int i = aloitusindeksi + 1; i < taulukko.length; i++) {
            if (pienin > taulukko[i]) {
                pienin = taulukko[i];
                indeksi = i;
            }
        }
        
        return indeksi;
    }
    
    public void vaihda(int[] taulukko, int indeksi1, int indeksi2) {
        int temp = taulukko[indeksi1];
        taulukko[indeksi1] = taulukko[indeksi2];
        taulukko[indeksi2] = temp;
    }
    
    public void jarjesta(int[] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            System.out.println(Arrays.toString(taulukko));
            int indeksi = pienimmanIndeksiAlkaen(taulukko, i);
            vaihda(taulukko, i, indeksi);
        }
    }
}
