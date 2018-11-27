package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsSovellus extends Application {

    public static int LEVEYS = 600;
    public static int KORKEUS = 400;

    @Override
    public void start(Stage ikkuna) throws Exception {

        Pane ruutu = new Pane();
        ruutu.setPrefSize(LEVEYS, KORKEUS);

        Text pisteTilanne = new Text(10, 20, "Points: 0");
        AtomicInteger pisteet = new AtomicInteger(0);

        Alus alus = new Alus(LEVEYS / 2, KORKEUS / 2);
        List<Ammus> ammukset = new ArrayList<>();
        List<Asteroidi> asteroidit = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            asteroidit.add(new Asteroidi(rnd.nextInt(LEVEYS / 3), rnd.nextInt(KORKEUS)));
        }

        ruutu.getChildren().add(pisteTilanne);
        ruutu.getChildren().add(alus.getHahmo());
        asteroidit.forEach((t) -> ruutu.getChildren().add(t.getHahmo()));

        Scene nakyma = new Scene(ruutu);
        Map<KeyCode, Boolean> painetutNapit = new HashMap<>();

        nakyma.setOnKeyPressed((t) -> {
            painetutNapit.put(t.getCode(), Boolean.TRUE);
        });

        nakyma.setOnKeyReleased((t) -> {
            painetutNapit.put(t.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {

            @Override
            public void handle(long nykyhetki) {

                if (painetutNapit.getOrDefault(KeyCode.LEFT, false)) {
                    alus.kaannaVasemmalle();
                }

                if (painetutNapit.getOrDefault(KeyCode.RIGHT, false)) {
                    alus.kaannaOikealle();
                }

                if (painetutNapit.getOrDefault(KeyCode.UP, false)) {
                    alus.kiihdyta();
                }

                if (painetutNapit.getOrDefault(KeyCode.SPACE, false) && ammukset.size() < 3) {
                    int x = (int) alus.getHahmo().getTranslateX();
                    int y = (int) alus.getHahmo().getTranslateY();
                    Ammus ammus = new Ammus(x, y);
                    ammus.getHahmo().setRotate(alus.getHahmo().getRotate());
                    ammukset.add(ammus);

                    ammus.kiihdyta();
                    ammus.setLiike(ammus.getLiike().normalize().multiply(3));

                    ruutu.getChildren().add(ammus.getHahmo());
                }

                alus.liiku();
                asteroidit.forEach((t) -> t.liiku());
                ammukset.forEach((t) -> t.liiku());

                ammukset.forEach((ammus) -> {
                    asteroidit.forEach((asteroidi) -> {
                        if (asteroidi.tormaa(ammus)) {
                            asteroidi.setElossa(false);
                            ammus.setElossa(false);
                        }
                    });
                    
                    if (!ammus.isElossa()) {
                        pisteTilanne.setText("Points: " + pisteet.addAndGet(1000));
                    }
                });

                ammukset.stream()
                        .filter(ammus -> !ammus.isElossa())
                        .forEach((t) -> {
                            ruutu.getChildren().remove(t.getHahmo());
                        });
                ammukset.removeAll(ammukset.stream()
                        .filter(t -> !t.isElossa())
                        .collect(Collectors.toList()));

                asteroidit.stream()
                        .filter(asteroidi -> !asteroidi.isElossa())
                        .forEach((t) -> {
                            ruutu.getChildren().remove(t.getHahmo());
                        });
                asteroidit.removeAll(asteroidit.stream()
                        .filter(t -> !t.isElossa())
                        .collect(Collectors.toList()));

                asteroidit.forEach((t) -> {
                    if (alus.tormaa(t)) {
                        stop();
                    }
                });

                if (Math.random() < 0.005) {
                    Asteroidi asteroidi = new Asteroidi(0, 0);
                    if (!asteroidi.tormaa(alus)) {
                        asteroidit.add(asteroidi);
                        ruutu.getChildren().add(asteroidi.getHahmo());
                    }
                }
            }

        }.start();

        ikkuna.setScene(nakyma);
        ikkuna.setTitle("Asteroids");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(AsteroidsSovellus.class);
    }

    public static int osiaToteutettu() {
        return 4;
    }

}
