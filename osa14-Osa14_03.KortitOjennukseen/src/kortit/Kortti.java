package kortit;

public class Kortti implements Comparable<Kortti>{

    private int arvo;
    private Maa maa;

    public Kortti(int arvo, Maa maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    @Override
    public int compareTo(Kortti t) {
        int palautettava = this.arvo - t.getArvo();
        if (palautettava == 0) {
            palautettava = this.maa.ordinal() - t.getMaa().ordinal();
        }
        return palautettava;
    }
    
    @Override
    public String toString() {
        String arvoTekstina = "" + this.arvo;
        if (arvo == 11) {
            arvoTekstina = "J";
        } else if (arvo == 12) {
            arvoTekstina = "Q";
        } else if (arvo == 13) {
            arvoTekstina = "K";
        } else if (arvo == 14) {
            arvoTekstina = "A";
        }

        return maa + " " + arvoTekstina;
    }

    public int getArvo() {
        return arvo;
    }

    public Maa getMaa() {
        return maa;
    }

}
