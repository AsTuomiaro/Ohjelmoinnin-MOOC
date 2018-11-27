package hiekkaranta;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HiekkarantaSovellus extends Application {


    @Override
    public void start(Stage ikkuna) throws Exception {
        Simulaatio sim = new Simulaatio(200, 200);
        
        BorderPane asettelu = new BorderPane();

        Canvas piirtoalusta = new Canvas(200, 200);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        ToggleGroup ryhma = new ToggleGroup();
        RadioButton metallinappi = new RadioButton("Metalli");
        RadioButton hiekkanappi = new RadioButton("Hiekka");
        RadioButton vesinappi = new RadioButton("Vesi");

        metallinappi.setToggleGroup(ryhma);
        hiekkanappi.setToggleGroup(ryhma);
        vesinappi.setToggleGroup(ryhma);

        VBox valikko = new VBox(metallinappi, hiekkanappi, vesinappi);
        valikko.setSpacing(0);
        valikko.setPadding(new Insets(0));

        asettelu.setCenter(piirtoalusta);
        asettelu.setRight(valikko);

        Piirtotyyppi piirtotyyppi = new Piirtotyyppi();

        piirtoalusta.setOnMouseDragged((t) -> {
            int kohtaX = (int) t.getX();
            int kohtaY = (int) t.getY();
            Tyyppi tyyppi = piirtotyyppi.getTyyppi();

            sim.lisaa(kohtaX, kohtaY, tyyppi);
        });

        metallinappi.setOnAction((t) -> piirtotyyppi.setTyyppi(Tyyppi.METALLI));
        hiekkanappi.setOnAction((t) -> piirtotyyppi.setTyyppi(Tyyppi.HIEKKA));
        vesinappi.setOnAction((t) -> piirtotyyppi.setTyyppi(Tyyppi.VESI));

        new AnimationTimer() {
            long edellinen = 0;
            long edellinen2 = 0;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - this.edellinen2 > 50000000) {
                    sim.paivita();
                    this.edellinen2 = nykyhetki;
                }
                
                if (nykyhetki - this.edellinen < 100000000) {
                    return;
                }

                piirturi.setFill(Color.BLACK);
                piirturi.fillRect(0, 0, 250, 250);

                for (int i = 0; i < 200; i++) {
                    for (int j = 0; j < 200; j++) {
                        if (sim.sisalto(i, j) == Tyyppi.TYHJA) {
                            continue;
                        }
                        if (sim.sisalto(i, j) == Tyyppi.METALLI) {
                            piirturi.setFill(Color.WHITE);
                        }
                        if (sim.sisalto(i, j) == Tyyppi.HIEKKA) {
                            piirturi.setFill(Color.ORANGE);
                        }
                        if (sim.sisalto(i, j) == Tyyppi.VESI) {
                            piirturi.setFill(Color.LIGHTBLUE);
                        }
                        piirturi.fillRect(i, j, 2, 2);
                    }
                }

                this.edellinen = nykyhetki;
            }
        }.start();

        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(HiekkarantaSovellus.class);
    }
}
