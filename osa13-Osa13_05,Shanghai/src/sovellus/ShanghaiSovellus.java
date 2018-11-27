package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        NumberAxis xAkseli = new NumberAxis(2006, 2018, 1);
        NumberAxis yAkseli = new NumberAxis(0, 100, 10);
        xAkseli.setLabel("Vuosi");
        yAkseli.setLabel("Sijoitus");
        
        LineChart<Number, Number> kaavio = new LineChart<>(xAkseli, yAkseli);
        kaavio.setTitle("Helsingin yliopisto, Shanghai-ranking");
        
        XYChart.Series<Number, Number> data = new XYChart.Series<>();
        data.getData().add(new XYChart.Data<>(2007, 73));
        data.getData().add(new XYChart.Data<>(2008, 68));
        data.getData().add(new XYChart.Data<>(2009, 72));
        data.getData().add(new XYChart.Data<>(2010, 72));
        data.getData().add(new XYChart.Data<>(2011, 74));
        data.getData().add(new XYChart.Data<>(2012, 73));
        data.getData().add(new XYChart.Data<>(2013, 76));
        data.getData().add(new XYChart.Data<>(2014, 73));
        data.getData().add(new XYChart.Data<>(2015, 67));
        data.getData().add(new XYChart.Data<>(2016, 56));
        data.getData().add(new XYChart.Data<>(2017, 56));
        
        kaavio.getData().add(data);
        kaavio.setLegendVisible(false);
        
        Scene nakyma = new Scene(kaavio, 400, 300);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    public static void main(String[] args) {
        launch(ShanghaiSovellus.class);
    }

}
