/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.Random;

/**
 *
 * @author asko
 */
public class Peliruudukko {

    private int[][] taulukko;

    public Peliruudukko() {
        this.taulukko = new int[4][4];
        this.taulukko[0][0] = 1;
    }

    public int[][] getTaulukko() {
        return taulukko;
    }

    public void setTaulukko(int[][] taulukko) {
        this.taulukko = taulukko;
    }

    public void siirraOikealle() {
        boolean tehtavaaJaljella = false;

        for (int i = 0; i < this.taulukko.length; i++) {
            for (int j = this.taulukko[i].length - 2; j >= 0; j--) {
                if (this.taulukko[i][j] == 0) {
                    continue;
                }
                if (this.taulukko[i][j] == this.taulukko[i][j + 1]) {
                    this.taulukko[i][j + 1] += this.taulukko[i][j];
                    this.taulukko[i][j] = 0;
                    tehtavaaJaljella = true;
                }
                if (this.taulukko[i][j + 1] == 0) {
                    this.taulukko[i][j + 1] = this.taulukko[i][j];
                    this.taulukko[i][j] = 0;
                    tehtavaaJaljella = true;
                }
            }
        }
        if (tehtavaaJaljella) {
            siirraOikealle();
        }
    }

    public void siirraVasemmalle() {
        boolean tehtavaaJaljella = false;

        for (int i = 0; i < this.taulukko.length; i++) {
            for (int j = 1; j < this.taulukko[i].length; j++) {
                if (this.taulukko[i][j] == 0) {
                    continue;
                }
                if (this.taulukko[i][j] == this.taulukko[i][j - 1]) {
                    this.taulukko[i][j - 1] += this.taulukko[i][j];
                    this.taulukko[i][j] = 0;
                    tehtavaaJaljella = true;
                }
                if (this.taulukko[i][j - 1] == 0) {
                    this.taulukko[i][j - 1] = this.taulukko[i][j];
                    this.taulukko[i][j] = 0;
                    tehtavaaJaljella = true;
                }
            }
        }
        if (tehtavaaJaljella) {
            siirraVasemmalle();
        }
    }

    public void siirraYlos() {
        boolean tehtavaaJaljella = false;

        for (int i = 1; i < this.taulukko.length; i++) {
            for (int j = 0; j < this.taulukko[i].length; j++) {
                if (this.taulukko[i][j] == 0) {
                    continue;
                }
                if (this.taulukko[i][j] == this.taulukko[i - 1][j]) {
                    this.taulukko[i - 1][j] += this.taulukko[i][j];
                    this.taulukko[i][j] = 0;
                    tehtavaaJaljella = true;
                }
                if (this.taulukko[i - 1][j] == 0) {
                    this.taulukko[i - 1][j] = this.taulukko[i][j];
                    this.taulukko[i][j] = 0;
                    tehtavaaJaljella = true;
                }
            }
        }
        if (tehtavaaJaljella) {
            siirraYlos();
        }
    }

    public void siirraAlas() {
        boolean tehtavaaJaljella = false;

        for (int i = this.taulukko.length - 2; i >= 0; i--) {
            for (int j = 0; j < this.taulukko[i].length; j++) {
                if (this.taulukko[i][j] == 0) {
                    continue;
                }
                if (this.taulukko[i][j] == this.taulukko[i + 1][j]) {
                    this.taulukko[i + 1][j] += this.taulukko[i][j];
                    this.taulukko[i][j] = 0;
                    tehtavaaJaljella = true;
                }
                if (this.taulukko[i + 1][j] == 0) {
                    this.taulukko[i + 1][j] = this.taulukko[i][j];
                    this.taulukko[i][j] = 0;
                    tehtavaaJaljella = true;
                }
            }
        }
        if (tehtavaaJaljella) {
            siirraAlas();
        }
    }

    public void arvoUusiLukupaikka() {
        Random rnd = new Random();
        boolean tarkistus = this.peliKaynnissa();
        while (tarkistus) {
            int x = rnd.nextInt(4);
            int y = rnd.nextInt(4);
            if (this.taulukko[y][x] == 0) {
                this.taulukko[y][x] = 1;
                break;
            }
        }
    }

    public boolean peliKaynnissa() {
        for (int i = 0; i < this.taulukko.length; i++) {
            for (int j = 0; j < this.taulukko[i].length; j++) {
                if (this.taulukko[i][j] == 0) {
                    return true;
                }
                if (j > 0 && this.taulukko[i][j - 1] == this.taulukko[i][j]) {
                    return true;
                }
                if (j < this.taulukko[i].length - 1 && this.taulukko[i][j + 1] == this.taulukko[i][j]) {
                    return true;
                }
                if (i > 0 && this.taulukko[i - 1][j] == this.taulukko[i][j]) {
                    return true;
                }
                if (i < this.taulukko.length - 1 && this.taulukko[i + 1][j] == this.taulukko[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
