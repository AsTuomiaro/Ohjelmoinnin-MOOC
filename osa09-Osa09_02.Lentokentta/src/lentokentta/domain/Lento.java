/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lentokentta.domain;

/**
 *
 * @author asko
 */
public class Lento {
    private Lentokone lentokone;
    private String lahtotunnus, kohdetunnus;
    
    public Lento(Lentokone lentokone, String lahtotunnus, String kohdetunnus) {
        this.lentokone = lentokone;
        this.lahtotunnus = lahtotunnus;
        this.kohdetunnus = kohdetunnus;
    }

    @Override
    public String toString() {
        return this.lentokone + " (" + this.lahtotunnus + "-" + this.kohdetunnus + ")";
    }
}
