/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;
import suosittelija.domain.Henkilo;

/**
 *
 * @author asko
 */
public class ArvioRekisteri {
    private Map<Elokuva, List<Arvio>> arviot;
    private Map<Henkilo, Map<Elokuva, Arvio>> henkiloidenTekematArviot;
    
    public ArvioRekisteri() {
        this.arviot = new HashMap<>();
        this.henkiloidenTekematArviot = new HashMap<>();
    }
    
    public void lisaaArvio(Elokuva elokuva, Arvio arvio) {
        this.arviot.putIfAbsent(elokuva, new ArrayList<>());
        this.arviot.get(elokuva).add(arvio);
    }
    
    public void lisaaArvio(Henkilo henkilo, Elokuva elokuva, Arvio arvio) {
        this.henkiloidenTekematArviot.putIfAbsent(henkilo, new HashMap<>());
        this.henkiloidenTekematArviot.get(henkilo).putIfAbsent(elokuva, arvio);
        this.lisaaArvio(elokuva, arvio);
    }
    
    public Arvio haeArvio(Henkilo henkilo, Elokuva elokuva) {
        return this.henkiloidenTekematArviot
                .getOrDefault(henkilo, new HashMap<>())
                .getOrDefault(elokuva, Arvio.EI_NAHNYT);
    }
    
    public Map<Elokuva, Arvio> annaHenkilonArviot(Henkilo henkilo) {
        return this.henkiloidenTekematArviot.getOrDefault(henkilo, new HashMap<>());
    }
    
    public List<Henkilo> arvioijat() {
        return this.henkiloidenTekematArviot.keySet().stream()
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public List<Arvio> annaArviot(Elokuva elokuva) {
        return this.arviot.getOrDefault(elokuva, new ArrayList<Arvio>());
    }
    
    public Map<Elokuva, List<Arvio>> elokuvienArviot() {
        return this.arviot;
    } 
}
