
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;




public class TehtavienhallintaTest {
    private Tehtavienhallinta hallinta;
    
    @Before
    public void alusta() {
        hallinta = new Tehtavienhallinta();
    }
    
    @Test
    public void tehtavalistaAlussaTyhja() {
        assertEquals(0, hallinta.tehtavalista().size());
    }
    
    @Test
    public void tehtavanLisaaminenKasvattaaListanKokoaYhdella() {
        hallinta.lisaa("Kirjoita testi");
        assertEquals(1, hallinta.tehtavalista().size());
    }
    
    @Test
    public void lisattyTehtavaLoytyyTehtavalistalta() {
        hallinta.lisaa("Kirjoita testi");
        Assert.assertTrue(hallinta.tehtavalista().contains("Kirjoita testi"));
    }
    
    @Test
    public void tehtavanVoiMerkataTehdyksi() {
        hallinta.lisaa("Satunnainen tehtävä");
        hallinta.merkkaaTehdyksi("Satunnainen tehtävä");
    }
    
    @Test
    public void tehdyksiMerkattuOnTehty() {
        hallinta.lisaa("Uusi tehtävä");
        hallinta.merkkaaTehdyksi("Uusi tehtävä");
        Assert.assertTrue(hallinta.onTehty("Uusi tehtävä"));
    }
    
    @Test
    public void tehdyksiMerkkaamatonEiOleTehty() {
        hallinta.lisaa("Uusi tehtävä");
        hallinta.merkkaaTehdyksi("Uusi tehtävä");
        Assert.assertFalse(hallinta.onTehty("Joku tehtävä"));
    }
    
    @Test
    public void tehtavanVoiPoistaa() {
        hallinta.lisaa("Uusi tehtava");
        hallinta.poista("Uusi tehtava");
    }
    
    @Test
    public void poistettuTehtavaOnPois() {
        hallinta.lisaa("Uusi tehtävä");
        hallinta.poista("Uusi tehtävä");
        Assert.assertFalse(hallinta.tehtavalista().contains("Uusi tehtävä"));
    }
}
