/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siirrettava;

/**
 *
 * @author asko
 */
public class Elio implements Siirrettava {
    private int X, Y;
    
    public Elio(int x, int y) {
        this.X = x;
        this.Y = y;
    }
    
    
    @Override
    public void siirra(int dx, int dy) {
        this.X += dx;
        this.Y += dy;
    }

    @Override
    public String toString() {
        return "x: " + this.X + "; y: " + this.Y;
    }
}
