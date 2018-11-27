package testausta;

import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class OhjelmaTest {

    // toteuta tänne testit luokkaa Ohjelma-varten
    @Test
    public void kukaanEiTeeMitaan() {
        Assert.assertEquals("Pulloja: 0\nOppilaita: 0\nKeskiarvoa ei voida laskea", 
                Ohjelma.suorita(new Scanner("-1\n")));
    }
    
    @Test
    public void suoritusPalauttaaOikeanlaisenMerkkijonon() {
        Assert.assertEquals("Pulloja: 6\nOppilaita: 3\nKeskiarvo: 2.0", 
                Ohjelma.suorita(new Scanner("3\n2\n1\n-1\n")));
    }
    
    @Test
    public void suoritusSaaVainEpakelpojaArvoja() {
        Assert.assertEquals("Pulloja: 0\nOppilaita: 0\nKeskiarvoa ei voida laskea", 
                Ohjelma.suorita(new Scanner("-55\n-3\n-1\n")));
    }
    
    @Test
    public void kukaanEiPalauttanutYhtaanPulloa() {
        Assert.assertEquals("Pulloja: 0\nOppilaita: 2\nKeskiarvoa ei voida laskea", 
                Ohjelma.suorita(new Scanner("0\n0\n-1\n")));
    }
    
    @Test
    public void vainYksiPulloPalautettiin() {
        Assert.assertEquals("Pulloja: 1\nOppilaita: 2\nKeskiarvo: 0.5", 
                Ohjelma.suorita(new Scanner("1\n-55\n-3\n0\n-1\n")));
    }
    
    @Test
    public void paatosmerkkiPuuttuu() {
        Assert.assertEquals("Pulloja: 1\nOppilaita: 2\nKeskiarvo: 0.5", 
                Ohjelma.suorita(new Scanner("1\n-55\n-3\n0\n")));
    }
    
    @Test
    public void huonoSyote() {
        Assert.assertEquals("Pulloja: 23\nOppilaita: 1\nKeskiarvo: 23.0", 
                Ohjelma.suorita(new Scanner("-55\n23\nasdasdasd\n-1\n")));
    }
    
    @Test
    public void liikaaPulloja() {
        Assert.assertEquals("Pulloja: 0\nOppilaita: 4\nKeskiarvoa ei voida laskea", 
                Ohjelma.suorita(new Scanner("999999999\n999999999\n999999999\n999999999\n-1\n")));
    }
}
