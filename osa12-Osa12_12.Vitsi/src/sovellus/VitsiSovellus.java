package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VitsiSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        BorderPane asettelu = new BorderPane();
        
        Button vitsinappi = new Button("Vitsi");
        Button vastausnappi = new Button("Vastaus");
        Button selitysnappi = new Button("Selitys");
        
        HBox nappiasettelu = new HBox(vitsinappi, vastausnappi, selitysnappi);
        nappiasettelu.setSpacing(10);
        nappiasettelu.setPadding(new Insets(20));
        
        asettelu.setTop(nappiasettelu);
        
        StackPane eka, toka, kolmas;
        eka = uusiAsettelu("What do you call a bear with no teeth?");
        toka = uusiAsettelu("A gummy bear.");
        kolmas = uusiAsettelu("Because the bear is all gums and no teeth.");
        
        vitsinappi.setOnAction((t) -> asettelu.setCenter(eka));
        vastausnappi.setOnAction((t) -> asettelu.setCenter(toka));
        selitysnappi.setOnAction((t) -> asettelu.setCenter(kolmas));
        
        asettelu.setCenter(eka);
        
        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.setTitle("Vitsinaattori 9000");
        ikkuna.show();
    }
    
    private StackPane uusiAsettelu(String teksti) {
        StackPane palautettava = new StackPane();
        palautettava.setPrefSize(300, 180);
        palautettava.getChildren().add(new Label(teksti));
        palautettava.setAlignment(Pos.CENTER);
        
        return palautettava;
    }

    public static void main(String[] args) {
        launch(VitsiSovellus.class);
    }
}
