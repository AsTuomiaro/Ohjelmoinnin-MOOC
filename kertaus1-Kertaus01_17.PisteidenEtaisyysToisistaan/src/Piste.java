/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Piste {
    private final double X, Y;
    
    public Piste(double x, double y) {
        this.X = x;
        this.Y = y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }
    /**
     * Kahden pisteolion välinen etäisyys. Tässä oletetaan, että
     * käytettävä metriikka on Euklidinen.
     * @param toinen
     * @return Pisteiden välinen etäisyys käyttäen tavallista Eulkidista metriikkaa.
     */
    public double etaisyys(Piste toinen) {
        return Math.sqrt((this.X - toinen.getX()) * (this.X - toinen.getX()) 
                + (this.Y - toinen.getY()) * (this.Y - toinen.getY()));
    }

    @Override
    public String toString() {
        return "(" + this.X + ";" + this.Y + ")";
    }
}
