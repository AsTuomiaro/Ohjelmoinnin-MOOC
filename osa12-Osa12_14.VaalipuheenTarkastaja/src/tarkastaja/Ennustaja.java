package tarkastaja;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Ennustaja {
    private Map<String, Integer> valitut, eiValitut;
    private int valitutLauseet, eiValitutLauseet, lauseitaYhteensa;
    
    public Ennustaja() {
        this.valitut = new HashMap<>();
        this.eiValitut = new HashMap<>();
        this.lauseitaYhteensa = 0;
        this.valitutLauseet = 0;
        this.eiValitutLauseet = 0;
    }

    public void lisaa(boolean valitaan, String lause) {
        String[] sanat = lause.trim().split("\\s+");
        if (valitaan) {
            Arrays.stream(sanat).forEach(sana -> {
                this.valitut.putIfAbsent(sana, 0);
                this.valitut.put(sana, this.valitut.get(sana) + 1);
            });
            this.valitutLauseet++;
        } else {
            Arrays.stream(sanat).forEach(sana -> {
                this.eiValitut.putIfAbsent(sana, 0);
                this.eiValitut.put(sana, this.eiValitut.get(sana) + 1);
            });
            this.eiValitutLauseet++;
        }
        this.lauseitaYhteensa++;
    }

    public int valitaanSanojenLukumaariinPerustuen(String lause) {
        String[] sanat = lause.trim().split("\\s+");
        int summa = 0;
        
        for (int i = 0; i < sanat.length; i++) {
            summa += this.valitut.getOrDefault(sanat[i], 0) 
                    - this.eiValitut.getOrDefault(sanat[i], 0);
        }
        
        if (summa < 0) {
            return -1;
        }
        if (summa > 0) {
            return 1;
        }
        return 0;
    }

    public int valitaanMystisellaEnnustajalla(String lause) {
        double valitaan = 1.0 * this.valitutLauseet / this.lauseitaYhteensa;
        double hylataan = 1.0 * this.eiValitutLauseet / this.lauseitaYhteensa;
        
        String[] sanat = lause.trim().split("\\s+");
        
        for (int i = 0; i < sanat.length; i++) {
            int esiintymat = this.valitut.getOrDefault(sanat[i], 0) 
                    + this.eiValitut.getOrDefault(sanat[i], 0);
            if (esiintymat < 5) {
                continue;
            }
            valitaan = valitaan * this.valitut.get(sanat[i]) / esiintymat;
            hylataan = hylataan * this.eiValitut.get(sanat[i]) / esiintymat;
        }
        
        if (valitaan > hylataan) {
            return 1;
        }
        if (valitaan < hylataan) {
            return -1;
        }
        return 0;
    }
}
