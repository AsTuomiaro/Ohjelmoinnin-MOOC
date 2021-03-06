
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

@Points("05-06")
public class KappaleTest {

    @Test
    public void vertailuToimii1() throws Throwable {
        Kappale kpl = new Kappale("The Lonely Island", "Jack Sparrow", 196);
        Kappale kpl2 = new Kappale("The Lonely Island", "Jack Sparrow", 196);

        assertEquals("Kokeile ohjelmaa:\n"
                + "Kappale kpl = new Kappale(\"The Lonely Island\", \"Jack Sparrow\", 196);\n"
                + "Kappale kpl2 = new Kappale(\"The Lonely Island\", \"Jack Sparrow\", 196);"
                + "if(kpl.equals(kpl2)) {\n"
                + "    System.out.println(\"Samat!\");\n"
                + "}\n", kpl, kpl2);
    }

    @Test
    public void vertailuToimii2() throws Throwable {
        Kappale kpl = new Kappale("Ismo Leikola", "Pendolino", 194);
        Kappale kpl2 = new Kappale("Ismo Leikola", "Pendolino", 194);

        assertEquals("Kokeile ohjelmaa:\n"
                + "Kappale kpl = new Kappale(\"Ismo Leikola\", \"Pendolino\", 194);\n"
                + "Kappale kpl2 = new Kappale(\"Ismo Leikola\", \"Pendolino\", 194);"
                + "if(kpl.equals(kpl2)) {\n"
                + "    System.out.println(\"Samat!\");\n"
                + "}\n", kpl, kpl2);
    }

    @Test
    public void vertailuToimii3() throws Throwable {
        Kappale kpl = new Kappale("The Lonely Island", "Jack Sparrow", 196);
        Kappale kpl2 = new Kappale("Ismo Leikola", "Pendolino", 194);

        Assert.assertNotSame("Kokeile ohjelmaa:\n"
                + "Kappale kpl = new Kappale(\"The Lonely Island\", \"Jack Sparrow\", 196);\n"
                + "Kappale kpl2 = new Kappale(\"Ismo Leikola\", \"Pendolino\", 194);"
                + "if(kpl.equals(kpl2)) {\n"
                + "    System.out.println(\"Samat!\");\n"
                + "}\n", kpl, kpl2);
    }
}
