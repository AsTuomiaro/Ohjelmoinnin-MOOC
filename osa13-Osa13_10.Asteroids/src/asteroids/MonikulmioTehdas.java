/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.util.Random;
import javafx.scene.shape.Polygon;

/**
 *
 * @author asko
 */
public class MonikulmioTehdas {
    
    public Polygon luoMonikulmio() {
        Random rnd = new Random();
        double t = 10 + rnd.nextInt(10);
        double c1 = Math.cos(Math.PI * 2 / 5);
        double c2 = Math.cos(Math.PI * 1 / 5);
        double s1 = Math.sin(Math.PI * 2 / 5);
        double s2 = Math.sin(Math.PI * 4 / 5);
        
        Polygon monikulmio = new Polygon();
        monikulmio.getPoints().addAll(
                t, 0.0,
                t * c1, -1 * t * s1,
                -1 * t * c2, -1 * t * s2,
                -1 * t * c2, t * s2,
                t * c1, t * s1
        );
        
        for (int i = 0; i < monikulmio.getPoints().size(); i++) {
            monikulmio.getPoints().set(i, monikulmio.getPoints().get(i) + (rnd.nextInt(5) - 2));
        }
        
        return monikulmio;
    }
}
