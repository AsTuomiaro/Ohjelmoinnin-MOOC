
public class Raha {

    private final int euroa;
    private final int senttia;

    public Raha(int euroa, int senttia) {

        if (senttia > 99) {
            euroa += senttia / 100;
            senttia %= 100;
        }

        this.euroa = euroa;
        this.senttia = senttia;
    }

    public int eurot() {
        return euroa;
    }

    public int sentit() {
        return senttia;
    }
    
    public Raha plus(Raha lisattava) {
        int lisattavatEurot = this.euroa + lisattava.eurot();
        int lisattavatSentit = this.senttia + lisattava.sentit();
        return new Raha(lisattavatEurot, lisattavatSentit);
    }
    
    public Raha miinus(Raha vahentaja) {
        int uusiEurot = this.euroa - vahentaja.eurot();
        int uusiSentit = this.senttia - vahentaja.sentit();
        if (uusiSentit < 0) {
            uusiEurot--;
            uusiSentit = 100 + uusiSentit;
        }
        if (uusiEurot < 0) {
            uusiEurot = 0;
            uusiSentit = 0;
        }
        return new Raha(uusiEurot, uusiSentit);
    }
    
    public boolean vahemman(Raha verrattava) {
        if (verrattava.eurot() == this.euroa) {
            return verrattava.sentit() > this.senttia;
        }
        return verrattava.eurot() > this.euroa;
    }

    public String toString() {
        String nolla = "";
        if (senttia < 10) {
            nolla = "0";
        }

        return euroa + "." + nolla + senttia + "e";
    }

}
