package ilmoitin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class IlmoitinSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        TextField tekstikentta = new TextField();
        Button nappi = new Button("Päivitä");
        Label teksti = new Label();
        
        VBox asettelu = new VBox();
        asettelu.getChildren().add(tekstikentta);
        asettelu.getChildren().add(nappi);
        asettelu.getChildren().add(teksti);
        
        nappi.setOnAction((t) -> {
            teksti.setText(tekstikentta.getText());
        });
        
        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.setTitle("Sovellus");
        ikkuna.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(IlmoitinSovellus.class);
    }

}
