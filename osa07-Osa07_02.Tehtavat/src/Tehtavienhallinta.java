
import java.util.ArrayList;


public class Tehtavienhallinta {
    private ArrayList<Tehtava> tehtavat;
    
    public Tehtavienhallinta() {
        this.tehtavat = new ArrayList<>();
    }
    
    public ArrayList<String> tehtavalista() {
        ArrayList<String> palautettava = new ArrayList<>();
        for (Tehtava t : tehtavat) {
            palautettava.add(t.getNimi());
        }
        return palautettava;
    }
    
    public void lisaa(String tehtava) {
        this.tehtavat.add(new Tehtava(tehtava));
    }
    
    public void merkkaaTehdyksi(String tehtava) {
        for (Tehtava t : tehtavat) {
            if (t.getNimi().equals(tehtava)) {
                t.setTehty(true);
            }
        }
    }
    
    public boolean onTehty(String tehtava) {
        for (Tehtava t : tehtavat) {
            if (t.getNimi().equals(tehtava)) {
                return t.onTehty();
            }
        }
        return false;
    }
    
    public void poista(String tehtava) {
        Tehtava poistettava = null;
        for (Tehtava t : tehtavat) {
            if (t.getNimi().equals(tehtava)) {
                poistettava = t;
            }
        }
        
        if (poistettava != null) {
            tehtavat.remove(poistettava);
        }
    }
}
