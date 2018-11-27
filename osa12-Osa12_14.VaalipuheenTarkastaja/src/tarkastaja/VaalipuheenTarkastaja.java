package tarkastaja;

import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VaalipuheenTarkastaja extends Application {

    private Ennustaja ennustaja;

    @Override
    public void init() throws Exception {
        this.ennustaja = new Ennustaja();
        Files.lines(Paths.get("vaalidata.csv"))
                .map(rivi -> rivi.split(";"))
                .forEach(palat -> {
                    if (palat[0].equals("1")) {
                        this.ennustaja.lisaa(true, palat[1]);
                    } else {
                        this.ennustaja.lisaa(false, palat[1]);
                    }
                });
    }

    @Override
    public void start(Stage stage) throws Exception {
        Ennustaja en = this.ennustaja;

        TextArea tekstikentta = new TextArea();
        tekstikentta.setWrapText(true);

        Label sanojenPerusteella = new Label("Sanojen esiintymien perusteella: ???");
        Label mystisenPerusteella = new Label("Mystisen ennustajan perusteella: ???");

        tekstikentta.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                int tulos = en.valitaanSanojenLukumaariinPerustuen(t1);
                int tulos2 = en.valitaanMystisellaEnnustajalla(t1);
                
                
                if (tulos > 0) {
                    sanojenPerusteella.setText("Sanojen esiintymien perusteella: Kyllä");
                }
                if (tulos < 0) {
                    sanojenPerusteella.setText("Sanojen esiintymien perusteella: Ei");
                }
                if (tulos == 0) {
                    sanojenPerusteella.setText("Sanojen esiintymien perusteella: ???");
                }
                
                if (tulos2 > 0) {
                    mystisenPerusteella.setText("Mystisen ennustajan perusteella: Kyllä");
                }
                if (tulos2 < 0) {
                    mystisenPerusteella.setText("Mystisen ennustajan perusteella: Ei");
                }
                if (tulos2 == 0 || t1.isEmpty()) {
                    mystisenPerusteella.setText("Mystisen ennustajan perusteella: ???");
                }
            }
        });

        VBox alanakyma = new VBox(sanojenPerusteella, mystisenPerusteella);
        alanakyma.setSpacing(0);
        alanakyma.setPadding(new Insets(20));

        BorderPane komponenttiryhma = new BorderPane();
        komponenttiryhma.setCenter(tekstikentta);
        komponenttiryhma.setBottom(alanakyma);

        Scene nakyma = new Scene(komponenttiryhma);

        stage.setScene(nakyma);
        stage.show();
    }
    // END SOLUTION

    public static void main(String[] args) {
        launch(VaalipuheenTarkastaja.class);
        
    }
}
