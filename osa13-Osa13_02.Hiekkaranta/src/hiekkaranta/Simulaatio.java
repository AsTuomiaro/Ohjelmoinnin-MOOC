/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiekkaranta;

import java.util.Random;

/**
 *
 * @author asko
 */
public class Simulaatio {

    private int leveys, korkeus;
    private Tyyppi[][] taulukko;

    public Simulaatio(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.taulukko = new Tyyppi[korkeus][leveys];

        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                this.taulukko[i][j] = Tyyppi.TYHJA;
            }
        }
    }

    public void lisaa(int x, int y, Tyyppi tyyppi) {
        if (x < 0 || x >= this.leveys || y < 0 || y >= this.korkeus) {
            return;
        }
        this.taulukko[y][x] = tyyppi;
    }

    public Tyyppi sisalto(int x, int y) {
        if (x < 0 || x >= this.leveys || y < 0 || y >= this.korkeus) {
            return Tyyppi.METALLI;
        }
        return this.taulukko[y][x];
    }

    /**
     * Tämä metodi päivittää simulaation tilaa eri materiaalien
     * hierarkian suhteen. Mielenkiintoisesti johtuen päivitysjärjestyksestä
     * vesi pyrkii pakkautumaan ruudun vasempaan laitaan. Tämä johtuu siitä, että
     * vierekkäiset "vesihituset" päivitetään vasemmalta oikealle, jolloin niiden 
     * vasemmalla puolella on todennäköisemmin vapaata tilaa kuin oikealla. 
     */
    public void paivita() {
        Random rnd = new Random();

        for (int i = this.korkeus - 2; i >= 0; i--) {
            for (int j = 0; j < this.leveys; j++) {
                if (this.taulukko[i][j] == Tyyppi.HIEKKA) {
                    Tyyppi lounas = sisalto(j - 1, i + 1);
                    Tyyppi etela = sisalto(j, i + 1);
                    Tyyppi kaakko = sisalto(j + 1, i + 1);

                    // Katsotaan, voiko alemmalle tasolle edetä.
                    if ((lounas == Tyyppi.HIEKKA || lounas == Tyyppi.METALLI)
                            && (etela == Tyyppi.HIEKKA || etela == Tyyppi.METALLI)
                            && (kaakko == Tyyppi.HIEKKA || kaakko == Tyyppi.METALLI)) {
                        continue;
                    }
                    
                    // Suositaan alaspäistä kulkua, jos mahdollinen.
                    if (etela != Tyyppi.HIEKKA && etela != Tyyppi.METALLI) {
                        lisaa(j, i, etela);
                        lisaa(j, i + 1, Tyyppi.HIEKKA);
                        continue;
                    }

                    // Valitaan satunnaisesti jokin sopiva ruutu edetä.
                    int satunnainen = 0;
                    Tyyppi t = Tyyppi.METALLI;

                    while (true) {
                        satunnainen = rnd.nextInt(3);
                        t = sisalto(j - 1 + satunnainen, i + 1);
                        if (t != Tyyppi.METALLI && t != Tyyppi.HIEKKA) {
                            break;
                        }
                    }

                    lisaa(j, i, t);
                    lisaa(j - 1 + satunnainen, i + 1, Tyyppi.HIEKKA);
                }

                if (this.taulukko[i][j] == Tyyppi.VESI) {
                    Tyyppi lounas = sisalto(j - 1, i + 1);
                    Tyyppi etela = sisalto(j, i + 1);
                    Tyyppi kaakko = sisalto(j + 1, i + 1);
                    int taso = 1;

                    // Tehdään vastaava alatason tarkastelu kuin yllä, mutta
                    // lisätään myös sivujen tarkastelu. Hyväksikäytetään
                    // satunnaisen valinnan toimintaa asettamalla tarkasteltava
                    // taso olemaan yksi pienempi kuin normaalisti, jos vain
                    // sivusuuntainen liike on mahdollista.
                    if (lounas != Tyyppi.TYHJA
                            && etela != Tyyppi.TYHJA
                            && kaakko != Tyyppi.TYHJA) {
                        Tyyppi lansi = sisalto(j - 1, i);
                        Tyyppi ita = sisalto(j + 1, i);

                        if (lansi != Tyyppi.TYHJA && ita != Tyyppi.TYHJA) {
                            continue;
                        }
                        
                        taso = 0;
                    }

                    // Suositaan alaspäistä kulkua, jos mahdollinen.
                    if (etela == Tyyppi.TYHJA) {
                        lisaa(j, i, etela);
                        lisaa(j, i + 1, Tyyppi.VESI);
                        continue;
                    }
                    
                    // Muutoin satunnaistetaan eteneminen.
                    int satunnainen = 0;
                    Tyyppi t = Tyyppi.METALLI;

                    while (true) {
                        satunnainen = rnd.nextInt(3);
                        t = sisalto(j - 1 + satunnainen, i + taso);
                        if (t == Tyyppi.TYHJA) {
                            break;
                        }
                    }

                    lisaa(j, i, t);
                    lisaa(j - 1 + satunnainen, i + taso, Tyyppi.VESI);
                }
            }
        }
    }
}
