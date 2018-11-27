package sovellus;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PuolueetSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        Pane asettelu = new Pane();
        NumberAxis xAkseli = new NumberAxis(1968, 2008, 4);
        NumberAxis yAkseli = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Puolueiden suhteellinen kannatus");
        
        Map<String, Map<Integer, Double>> kannatusluvut = new HashMap<>();
        
        try (Scanner tiedostolukija = new Scanner(new File("puoluedata.tsv"))) {
            while (tiedostolukija.hasNextLine()) {                
                String rivi = tiedostolukija.nextLine();
                String[] palat = rivi.split("\t");
                if (palat[0].equals("Puolue")) {
                    continue;
                }
                kannatusluvut.putIfAbsent(palat[0], new HashMap<>());
                Map<Integer, Double> luvut = kannatusluvut.get(palat[0]);
                for (int i = 1; i < palat.length; i++) {
                    if (!palat[i].equals("-")) {
                        luvut.put(1964 + 4 * i, Double.parseDouble(palat[i]));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Kannatuslukujen lukemisessa tapahtui virhe: " 
                    + e.getMessage());
        }
        
        kannatusluvut.keySet().stream().forEach((puolue) -> {
            XYChart.Series<Number, Number> data = new XYChart.Series<>();
            data.setName(puolue);
            
            kannatusluvut.get(puolue).entrySet().stream().forEach((pari) -> {
                data.getData().add(new XYChart.Data<>(pari.getKey(), pari.getValue()));
            });
            
            viivakaavio.getData().add(data);
        });
        
        Scene nakyma = new Scene(viivakaavio, 400, 300);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    public static void main(String[] args) {
        launch(PuolueetSovellus.class);
    }

}
