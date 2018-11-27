package gameoflife;

import java.util.Random;

public class GameOfLife {

    private int[][] taulukko;

    public GameOfLife(int leveys, int korkeus) {
        this.taulukko = new int[leveys][korkeus];
    }

    public void alustaSatunnaisesti() {
        Random satunnaistaja = new Random();

        int x = 0;
        while (x < taulukko.length) {

            int y = 0;
            while (y < taulukko[x].length) {
                if (satunnaistaja.nextDouble() < 0.2) {
                    taulukko[x][y] = 1;
                }

                y++;
            }
            x++;
        }
    }

    public void kehity() {
        // säännöt kehittymiselle:

        // 1. jokainen elossa oleva alkio, jolla on alle 2 elossa olevaa naapuria kuolee
        // 2. jokainen elossa oleva alkio, jolla on 2 tai 3 elossa olevaa naapuria pysyy hengissä
        // 3. jokainen elossa oleva alkio, jolla on 4 tai enemmän naapureita kuolee
        // 4. jokainen kuollut alkio, jolla on tasan 3 naapuria muuttuu eläväksi
        // taulukossa arvo 1 kuvaa elävää alkiota, arvo 0 kuollutta alkiota
        int[][] kopio = new int[this.taulukko.length][this.taulukko[0].length];

        for (int i = 0; i < this.taulukko.length; i++) {
            for (int j = 0; j < this.taulukko[0].length; j++) {

                int elossaOlevatNaapurit = elossaOleviaNaapureita(taulukko, i, j);
                
                if (this.taulukko[i][j] == 1) {
                    if (elossaOlevatNaapurit == 2 || elossaOlevatNaapurit == 3) {
                        kopio[i][j] = 1;
                    }
                } else {
                    if (elossaOlevatNaapurit == 3) {
                        kopio[i][j] = 1;
                    }
                }
            }
        }
        
        this.taulukko = kopio;
    }

    public int[][] getTaulukko() {
        return taulukko;
    }

    public void setTaulukko(int[][] taulukko) {
        this.taulukko = taulukko;
    }

    public int elossaOleviaNaapureita(int[][] taulukko, int x, int y) {
        int summa = 0;
        int i = x - 1;
        int j = y - 1;

        if (i < 0) {
            i++;
        }
        if (j < 0) {
            j++;
        }

        for (int k = i; k < x + 2 && k < taulukko.length; k++) {
            for (int l = j; l < y + 2 && l < taulukko[0].length; l++) {
                if (k != x || l != y) {
                    summa += taulukko[k][l];
                }
            }
        }
        return summa;
    }
}
