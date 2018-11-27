
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-25")
public class AjatustenLukijaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void syotteetPelkkaaHta() {
        String syote = "";
        for (int i = 0; i < 50; i++) {
            syote += "h\n";
        }

        tarkista(syote, "pelkkää h:ta", "Pelaajan voitot: 0", "Tietokoneen voitot: 25");
        tarkistaEi(syote, "pelkkää h:ta", "Pelaajan voitot: 1", "Tietokoneen voitot: 26");
    }

    @Test
    public void syotteetPelkkaaTta() {
        String syote = "";
        for (int i = 0; i < 50; i++) {
            syote += "t\n";
        }

        tarkista(syote, "pelkkää t:ta", "Pelaajan voitot: 3", "Tietokoneen voitot: 25");
        tarkistaEi(syote, "pelkkää t:ta", "Pelaajan voitot: 4", "Tietokoneen voitot: 26");
    }

    @Test
    public void vaihteluJaHta() {
        String syote = "";
        for (int i = 0; i < 10; i++) {
            syote += "t\n";
        }
        for (int i = 0; i < 40; i++) {
            syote += "h\n";
        }

        String kuvaus = "ensin kymmenen t:tä sitten pelkkää h:ta";
        tarkista(syote, kuvaus, "Pelaajan voitot: 6", "Tietokoneen voitot: 25");
        tarkistaEi(syote, kuvaus, "Pelaajan voitot: 7", "Tietokoneen voitot: 26");
    }

    @Test
    public void vaihteluJaTta() {
        String syote = "";
        for (int i = 0; i < 10; i++) {
            syote += "h\n";
        }
        for (int i = 0; i < 40; i++) {
            syote += "t\n";
        }

        String kuvaus = "ensin kymmenen h:tä sitten pelkkää t:ta";
        tarkista(syote, kuvaus, "Pelaajan voitot: 1", "Tietokoneen voitot: 25");
        tarkistaEi(syote, kuvaus, "Pelaajan voitot: 2", "Tietokoneen voitot: 26");
    }

    @Test
    public void testi1() {
        String kuvaus = "h h t t h t h h h h t t t h t h t h t h h h h h t h t t t h t t t t t t t t t t h h h h h h h h h h h h h h h h";
        tarkista(kuvaus, kuvaus, "Pelaajan voitot: 21", "Tietokoneen voitot: 25");
        tarkistaEi(kuvaus, kuvaus, "Pelaajan voitot: 22", "Tietokoneen voitot: 26");
    }

    @Test
    public void testi2() {
        String kuvaus = "h h t t h t h h h h t t t h t h t h t h h h h h t h t t t h t t h t t h t h t t h h h h h h h h h h h h h h h h";
        tarkista(kuvaus, kuvaus, "Pelaajan voitot: 22", "Tietokoneen voitot: 25");
        tarkistaEi(kuvaus, kuvaus, "Pelaajan voitot: 23", "Tietokoneen voitot: 26");
    }

    @Test
    public void testi3() {
        String kuvaus = "t t h t h t h h h h t t t h t h t h t h h h h h t h t t t h t t h t t h t h t t h h h h h h h h h h h h h h h h";
        tarkista(kuvaus, kuvaus, "Pelaajan voitot: 18", "Tietokoneen voitot: 25");
        tarkistaEi(kuvaus, kuvaus, "Pelaajan voitot: 19", "Tietokoneen voitot: 26");
    }

    private void tarkista(String syote, String syotteenKuvaus, String... odotettuLopussa) {
        if (syote.contains(" ")) {
            syote = syote.replaceAll(" ", "\n");
        }

        int oldOut = io.getSysOut().length();

        io.setSysIn(syote);
        callMain(Ajatustenlukija.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        assertTrue("Tulostuksessa pitäisi esiintyä teksti \"Tietokoneen voitot: \". Nyt ei esiintynyt.", io.getSysOut().contains("Tietokoneen voitot: "));
        assertTrue("Tulostuksessa pitäisi esiintyä teksti \"Pelaajan voitot: \". Nyt ei esiintynyt.", io.getSysOut().contains("Pelaajan voitot: "));

        for (String s : odotettuLopussa) {
            assertTrue("Kun syöte on\n" + syotteenKuvaus + "\ntulostuksessa pitäisi esiintyä teksti \"" + s + "\". Nyt ei esiintynyt.", io.getSysOut().contains(s));
        }
    }

    private void tarkistaEi(String syote, String syotteenKuvaus, String... eiOdotettuLopussa) {
        if (syote.contains(" ")) {
            syote = syote.replaceAll(" ", "\n");
        }

        int oldOut = io.getSysOut().length();

        io.setSysIn(syote);
        callMain(Ajatustenlukija.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        assertTrue("Tulostuksessa pitäisi esiintyä teksti \"Tietokoneen voitot: \". Nyt ei esiintynyt.", io.getSysOut().contains("Tietokoneen voitot: "));
        assertTrue("Tulostuksessa pitäisi esiintyä teksti \"Pelaajan voitot: \". Nyt ei esiintynyt.", io.getSysOut().contains("Pelaajan voitot: "));

        for (String s : eiOdotettuLopussa) {
            assertFalse("Kun syöte on " + syotteenKuvaus + ", tulostuksessa ei pitäisi esiintyä tekstiä \"" + s + "\".", io.getSysOut().contains(s));
        }
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("Ohjelmasi koitti lukea liikaa syötettä. Muista lukea nextLine()-metodilla!");
        } catch (Throwable e) {
            fail(kl + "-luokan public static void main(String[] args) -metodi on hävinnyt "
                    + "tai jotain muuta odottamatonta tapahtunut, lisätietoja " + e);
        }
    }
}
