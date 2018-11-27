package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TervehtijaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        Label aloitusteksti = new Label("Kirjoita nimesi ja aloita.");
        TextField tekstikentta = new TextField();
        Button aloitusnappi = new Button("Aloita");
        
        GridPane asettelu = new GridPane();
        asettelu.add(aloitusteksti, 0, 0);
        asettelu.add(tekstikentta, 0, 1);
        asettelu.add(aloitusnappi, 0, 2);
        
        asettelu.setPrefSize(300, 180);
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(20));
        
        Scene aloitusNakyma = new Scene(asettelu);
        
        Label tervehdys = new Label();
        StackPane tervehdysAsettelu = new StackPane();
        tervehdysAsettelu.getChildren().add(tervehdys);
        
        tervehdysAsettelu.setPrefSize(300, 180);
        tervehdysAsettelu.setAlignment(Pos.CENTER);
        
        Scene tervehdysNakyma = new Scene(tervehdysAsettelu);
        
        aloitusnappi.setOnAction((t) -> {
            String nimi = tekstikentta.getText();
            tervehdys.setText("Tervetuloa " + nimi.trim() + "!");
            
            ikkuna.setScene(tervehdysNakyma);
        });
        
        ikkuna.setScene(aloitusNakyma);
        ikkuna.setTitle("Tervehtijä");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(TervehtijaSovellus.class);
    }
}
