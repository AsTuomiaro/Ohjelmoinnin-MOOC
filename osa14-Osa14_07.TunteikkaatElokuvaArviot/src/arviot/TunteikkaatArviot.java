package arviot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TunteikkaatArviot {
    private Map<String, Sana> sanat;

    // Huom! Älä muuta konstruktorin parametrien määrää -- konstruktoria
    // saa toki muuten muuttaa
    public TunteikkaatArviot(List<String> rivit) {
        this.sanat = new HashMap<>();
        for (String rivi : rivit) {
            String[] sanatRivilla = rivi.split(" ");
            for (int i = 1; i < sanatRivilla.length; i++) {
                this.sanat.putIfAbsent(sanatRivilla[i].toLowerCase(), new Sana(sanatRivilla[i]));
                Sana sana = this.sanat.get(sanatRivilla[i].toLowerCase());
                sana.kasvataEsiintyminen();
                sana.lisaaArvio(Integer.parseInt(sanatRivilla[0]));
            }
        }
    }

    public int sanojenLukumaara(String sana) {
        Sana sanaOlio = this.sanat.get(sana);
        if (sanaOlio == null) {
            return 0;
        }
        return sanaOlio.getEsiintymiset();
    }

    public double sananTunne(String sana) {
        Sana sanaOlio = this.sanat.get(sana);
        if (sanaOlio == null) {
            return 2.0;
        }
        return sanaOlio.keskimaarainenTunnearvo();
    }

    public String sananTunneMerkkijonona(String sana) {
        double arvio = sananTunne(sana);
        if (arvio > 2.1) {
            return "positiivinen";
        } else if (arvio > 1.9) {
            return "neutraali";
        } else {
            return "negatiivinen";
        }
    }

    public double lauseenTunne(String lause) {
        if (lause.isEmpty()) {
            return -1;
        }
        
        String[] lauseenSanat = lause.split("\\s+");
        double summa = 0;
        for (int i = 0; i < lauseenSanat.length; i++) {
            summa += sananTunne(lauseenSanat[i]);
        }
        return summa / lauseenSanat.length;
    }

    public String lauseenTunneMerkkijonona(String lause) {
        double arvio = lauseenTunne(lause);
        if (arvio > 2.1) {
            return "positiivinen";
        } else if (arvio > 1.9) {
            return "neutraali";
        } else {
            return "negatiivinen";
        }
    }

}
