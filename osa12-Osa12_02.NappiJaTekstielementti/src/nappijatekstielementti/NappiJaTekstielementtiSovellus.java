package nappijatekstielementti;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class NappiJaTekstielementtiSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        Button nappi = new Button("Nappi");
        Label teksti = new Label("Tekstielementti");
        
        FlowPane asettelu = new FlowPane();
        asettelu.getChildren().add(nappi);
        asettelu.getChildren().add(teksti);
        
        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.setTitle("Sovellus");
        ikkuna.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(NappiJaTekstielementtiSovellus.class);
    }

}
