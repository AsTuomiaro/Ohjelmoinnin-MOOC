/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Ympyra {
    private final double X, Y, SADE;
    
    public Ympyra(double x, double y, double sade) {
        this.X = x;
        this.Y = y;
        this.SADE = sade;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getSADE() {
        return SADE;
    }

    public boolean osuuko(Ympyra toinen) {
        return !(Math.sqrt((this.X - toinen.getX()) * (this.X - toinen.getX()) 
                + (this.Y - toinen.getY()) * (this.Y - toinen.getY())) 
                > (this.SADE + toinen.getSADE()));
    }
    
    @Override
    public String toString() {
        return "{(x, y) : d((x, y), (" + this.X + "; " + this.Y +")) = " + this.SADE + "}";
    }
}
