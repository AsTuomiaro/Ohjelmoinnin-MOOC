
public class Asunto {

    private int huoneita;
    private int nelioita;
    private int neliohinta;

    public Asunto(int huoneita, int nelioita, int neliohinta) {
        this.huoneita = huoneita;
        this.nelioita = nelioita;
        this.neliohinta = neliohinta;
    }

    public int getNelioita() {
        return nelioita;
    }

    public int getNeliohinta() {
        return neliohinta;
    }

    
    public int getHuoneita() {
        return huoneita;
    }
    
    public boolean suurempi(Asunto verrattava) {
        return this.nelioita > verrattava.getNelioita();
    }
    
    public int hintaero(Asunto verrattava) {
        return Math.abs((this.neliohinta * this.nelioita) 
                - (verrattava.getNeliohinta() * verrattava.getNelioita()));
    }
    
    public boolean kalliimpi(Asunto verrattava) {
        return this.nelioita * this.neliohinta 
                > verrattava.getNelioita() * verrattava.getNeliohinta();
    }
}
