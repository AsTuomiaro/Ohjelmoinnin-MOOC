/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Henkilo {
    private String nimi;
    private String puhelinnumero;
    
    public Henkilo(String nimi, String puhelinnumero) {
        this.nimi = nimi;
        this.puhelinnumero = puhelinnumero;
    }

    public String getNimi() {
        return nimi;
    }

    public String getNumero() {
        return puhelinnumero;
    }
    
    public void vaihdaNumeroa(String uusiNumero) {
        this.puhelinnumero = uusiNumero;
    }

    @Override
    public String toString() {
        return this.nimi + " puh: " + this.puhelinnumero;
    }
}
