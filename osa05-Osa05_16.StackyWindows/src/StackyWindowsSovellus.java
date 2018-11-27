
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StackyWindowsSovellus extends Application {

    public void start(Stage stage) {
        final int ikkunanLeveys = 640;
        final int ikkunanKorkeus = 480;

        stage.setTitle("StackyWindows 1.0");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas piirtoalusta = new Canvas(ikkunanLeveys, ikkunanKorkeus);
        root.getChildren().add(piirtoalusta);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        ArrayList<Ikkuna> ikkunat = new ArrayList<>();
        ikkunat.add(new Ikkuna(200, 40, 200, 400, Color.GREEN));
        ikkunat.add(new Ikkuna(250, 70, 250, 300, Color.RED));
        ikkunat.add(new Ikkuna(30, 80, 200, 300, Color.BLUE));

        // Sijaintipiste, joka ilmaisee lähtöpisteen, kun tehdään siirtymä
        // hiirtä vedettäessä. Tämä asetetaan hiirtä painaessa ja tehdessä
        // siirtymää näitä vastaavissa EventHandlereissa.
        Piste piste = new Piste(0, 0);

        root.setOnMousePressed((MouseEvent event) -> {
            System.out.println("mouse click " + event.getSource());
            System.out.println("\t" + event.getX());
            System.out.println("\t" + event.getY());

            // Asetetaan painalluksen alussa sijaintipisteen paikka.
            piste.setX(event.getX());
            piste.setY(event.getY());

            Ikkuna haluttuIkkuna = null;
            for (Ikkuna ikkuna : ikkunat) {
                if (!ikkuna.ulkopuolella((int) event.getX(), (int) event.getY())) {
                    haluttuIkkuna = ikkuna;
                }
            }
            if (haluttuIkkuna != null) {
                ikkunat.remove(haluttuIkkuna);
                ikkunat.add(haluttuIkkuna);
            }
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            System.out.println("moving mouse, mouse down!");
            System.out.println("\t" + event.getX());
            System.out.println("\t" + event.getY());

            // Tässä lasketaan edellisen sijainnin ja nykyisen sijainnin
            // välinen siirtymä komponenteittain.
            double deltaX = event.getX() - piste.getX();
            double deltaY = event.getY() - piste.getY();

            // Päivitetään nykyinen sijainti.
            piste.setX(event.getX());
            piste.setY(event.getY());

            // Tehdään haluttu siirto ikkunalle, jos sellainen löytyy.
            Ikkuna siirrettavaIkkuna = null;
            if (!ikkunat.get(ikkunat.size() - 1)
                    .ulkopuolella((int) event.getX(), (int) event.getY())) {
                siirrettavaIkkuna = ikkunat.get(ikkunat.size() - 1);
            }
            if (siirrettavaIkkuna != null) {
                siirrettavaIkkuna.setX(siirrettavaIkkuna.getX() + (int) deltaX);
                siirrettavaIkkuna.setY(siirrettavaIkkuna.getY() + (int) deltaY);
            }
        });

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                piirturi.clearRect(0, 0, ikkunanLeveys, ikkunanKorkeus);

                for (Ikkuna ikkuna : ikkunat) {
                    piirturi.setFill(ikkuna.getVari());
                    piirturi.fillRect(ikkuna.getX(), ikkuna.getY(), ikkuna.getLeveys(), ikkuna.getKorkeus());
                }
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
