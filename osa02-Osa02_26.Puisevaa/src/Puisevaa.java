
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Luokka (ohjelma) Puisevaa "perii" graafisen käyttöliittymän rakentamiseen
// tarvittavia ominaisuuksia Application-luokalta (ohjelmalta)
public class Puisevaa extends Application {

    // Käyttöliittymän käynnistäminen kutsuu metodia alla olevaa
    // metodia
    @Override
    public void start(Stage ikkuna) throws Exception {

        // luodaan 640 pikseliä leveä ja 480 pikseliä korkea alusta
        // piirtämiselle ja otetaan alustaan liittyvä piirtoväline
        // käyttöön
        Canvas piirtoalusta = new Canvas(640, 480);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        // kutsutaan piirtämiseen käytettävää metodia piirrä
        // -- metodiin tullaan toteuttamaan piirtotoiminnallisuus
        piirra(piirturi);

        // asetetaan käyttöliittymän osat paikalleen ja 
        // näytetään se käyttäjälle
        Pane ruutu = new Pane(piirtoalusta);
        Scene nakyma = new Scene(ruutu);

        ikkuna.setTitle("Niin hyvää puuta!");
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    // Ohjelma käynnistetään metodilla public static void main. 
    // Metodissa kutsutaan Application luokalta perittyä toiminnallisuutta, 
    // joka lopulta suorittaa yllä kuvatun start-metodin
    public static void main(String[] args) {
        launch(Puisevaa.class);
    }

    // Oma piirra-metodimme, jonne toteutetaan piirtotoiminnallisuus
    public static void piirra(GraphicsContext piirturi) {

        // viivan piirtäminen kohdasta (0,0) kohtaan (100, 100)
        piirturi.strokeLine(0, 400, 640, 400);
        
        piirturi.strokeOval(100, 100, 60, 60);
        piirturi.strokeLine(130, 420, 130, 160);
        
        piirturi.strokeOval(200, 100, 60, 60);
        piirturi.strokeLine(230, 420, 230, 160);
        
        piirturi.strokeOval(300, 100, 60, 60);
        piirturi.strokeLine(330, 420, 330, 160);
        
        piirturi.strokeOval(400, 100, 60, 60);
        piirturi.strokeLine(430, 420, 430, 160);
        
        piirturi.strokeOval(500, 100, 60, 60);
        piirturi.strokeLine(530, 420, 530, 160);

    }

}
