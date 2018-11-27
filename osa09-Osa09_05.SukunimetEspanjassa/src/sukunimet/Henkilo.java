/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukunimet;

/**
 *
 * @author asko
 */
public class Henkilo {
    private String etunimi, ensimmainenSukunimi, toinenSukunimi;
    private Henkilo isa, aiti;
    
    public Henkilo(String etunimi, String ensimmainenSukunimi, String toinenSukunimi) {
        this.etunimi = etunimi;
        this.ensimmainenSukunimi = ensimmainenSukunimi;
        this.toinenSukunimi = toinenSukunimi;
        this.isa = null;
        this.aiti = null;
    }
    
    public Henkilo(String etunimi, Henkilo isa, Henkilo aiti) {
        this.etunimi = etunimi;
        this.aiti = aiti;
        this.isa = isa;
        this.ensimmainenSukunimi = isa.getEnsimmainenSukunimi();
        this.toinenSukunimi = aiti.getEnsimmainenSukunimi();
    }

    public String getEnsimmainenSukunimi() {
        return ensimmainenSukunimi;
    }

    @Override
    public String toString() {
        return this.etunimi + " " + this.ensimmainenSukunimi + " " + this.toinenSukunimi;
    }
    
    
}
