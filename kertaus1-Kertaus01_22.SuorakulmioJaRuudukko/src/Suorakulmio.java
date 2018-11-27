/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Suorakulmio {
    private final int X, Y, LEVEYS, KORKEUS;
    
    public Suorakulmio(int x, int y, int leveys, int korkeus) {
        this.X = x;
        this.Y = y;
        this.LEVEYS = leveys;
        this.KORKEUS = korkeus;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getLEVEYS() {
        return LEVEYS;
    }

    public int getKORKEUS() {
        return KORKEUS;
    }    
}
