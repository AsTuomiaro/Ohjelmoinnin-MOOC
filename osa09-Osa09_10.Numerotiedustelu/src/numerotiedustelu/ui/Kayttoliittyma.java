/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerotiedustelu.ui;

import java.util.ArrayList;
import java.util.Scanner;
import numerotiedustelu.domain.Henkilo;
import numerotiedustelu.logiikka.Numerokeskus;

/**
 *
 * @author asko
 */
public class Kayttoliittyma {

    private Scanner lukija;
    private Numerokeskus numerokeskus;

    public Kayttoliittyma(Scanner lukija, Numerokeskus keskus) {
        this.lukija = lukija;
        this.numerokeskus = keskus;
    }

    public void kaynnista() {
        System.out.println("numerotiedustelu" + "\nkäytettävissä olevat komennot:");
        System.out.println("1 lisää numero");
        System.out.println("2 hae numerot");
        System.out.println("3 hae puhelinnumeroa vastaava henkilö");
        System.out.println("4 lisää osoite");
        System.out.println("5 hae henkilön tiedot");
        System.out.println("6 poista henkilön tiedot");
        System.out.println("7 filtteröity listaus");
        System.out.println("x lopeta");

        while (true) {
            System.out.print("\nkomento: ");
            String komento = lukija.nextLine();

            if (komento.equals("x")) {
                break;
            }

            if (komento.equals("1")) {
                System.out.print("kenelle: ");
                String nimi = lukija.nextLine();
                System.out.print("numero: ");
                String numero = lukija.nextLine();
                this.numerokeskus.lisaaUusiNumero(nimi, numero);
            } else if (komento.equals("2")) {
                System.out.print("kenen: ");
                String nimi = lukija.nextLine();
                Henkilo henkilo = this.numerokeskus.haeNimella(nimi);
                if (henkilo == null || henkilo.getPuhelinnumerot().isEmpty()) {
                    System.out.println("  ei löytynyt");
                } else {
                    for (String numero : henkilo.getPuhelinnumerot()) {
                        System.out.println("  " + numero);
                    }
                }
            } else if (komento.equals("3")) {
                System.out.print("numero: ");
                String numero = lukija.nextLine();
                Henkilo henkilo = this.numerokeskus.haeNumerolla(numero);
                if (henkilo == null) {
                    System.out.println("  ei löytynyt");
                } else {
                    System.out.println("  " + henkilo.getNimi());
                }
            } else if (komento.equals("4")) {
                System.out.print("kenelle: ");
                String nimi = lukija.nextLine();

                this.numerokeskus.lisaaHenkilo(nimi);
                Henkilo henkilo = this.numerokeskus.haeNimella(nimi);

                System.out.print("katu: ");
                String uusiKatu = lukija.nextLine();

                System.out.print("kaupunki: ");
                String uusiKaupunki = lukija.nextLine();

                henkilo.setKatu(uusiKatu);
                henkilo.setKaupunki(uusiKaupunki);

            } else if (komento.equals("5")) {
                System.out.print("kenen: ");
                String nimi = lukija.nextLine();
                Henkilo henkilo = this.numerokeskus.haeNimella(nimi);
                if (henkilo == null) {
                    System.out.println("  ei löytynyt");
                } else {
                    if (henkilo.getKatu().isEmpty()) {
                        System.out.println("  osoite ei tiedossa");
                    } else {
                        System.out.println("  osoite: " + henkilo.getKatu()
                                + " " + henkilo.getKaupunki());
                    }
                    if (henkilo.getPuhelinnumerot().isEmpty()) {
                        System.out.println("  ei puhelinta");
                    } else {
                        System.out.println("  puhelinnumerot: ");
                        for (String numero : henkilo.getPuhelinnumerot()) {
                            System.out.println("    " + numero);
                        }
                    }
                }
            } else if (komento.equals("6")) {
                System.out.print("kenet: ");
                String nimi = lukija.nextLine();
                this.numerokeskus.poistaHenkilo(nimi);
            } else if (komento.equals("7")) {
                System.out.print("hakusana (jos tyhjä, listataan kaikki): ");
                String hakusana = lukija.nextLine();
                ArrayList<Henkilo> tulos = this.numerokeskus.haku(hakusana);
                if (tulos.isEmpty()) {
                    System.out.println("  ei löytynyt");
                } else {
                    for (Henkilo henkilo : tulos) {
                        System.out.println("\n  " + henkilo.getNimi());
                        if (henkilo.getKatu().isEmpty()) {
                            System.out.println("    osoite ei tiedossa");
                        } else {
                            System.out.println("    osoite: " + henkilo.getKatu()
                                    + " " + henkilo.getKaupunki());
                        }
                        if (henkilo.getPuhelinnumerot().isEmpty()) {
                            System.out.println("    ei puhelinta");
                        } else {
                            System.out.println("    puhelinnumerot: ");
                            for (String numero : henkilo.getPuhelinnumerot()) {
                                System.out.println("      " + numero);
                            }
                        }
                    }
                }
            } else {
                System.out.println("Tuntematon komento.");
            }
        }
    }
}
