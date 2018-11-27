/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Kirja {
    private String nimi;
    private int sivuja;
    private int kirjoitusvuosi;
    
    public Kirja(String kirjanNimi, int sivujenMaara, int kirjanKirjoitusvuosi) {
        this.nimi = kirjanNimi;
        this.sivuja = sivujenMaara;
        this.kirjoitusvuosi = kirjanKirjoitusvuosi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getSivuja() {
        return sivuja;
    }

    public int getKirjoitusvuosi() {
        return kirjoitusvuosi;
    }
}
