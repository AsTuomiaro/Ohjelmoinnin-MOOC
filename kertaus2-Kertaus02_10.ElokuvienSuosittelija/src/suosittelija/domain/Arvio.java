/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.domain;

/**
 *
 * @author asko
 */
public enum Arvio {
    HUONO, VALTTAVA, EI_NAHNYT, NEUTRAALI, OK, HYVA;

    public int getArvo() {
        if (this == HUONO) {
            return -5;
        } else if (this == VALTTAVA) {
            return -3;
        } else if (this == EI_NAHNYT) {
            return 0;
        } else if (this == NEUTRAALI) {
            return 1;
        } else if (this == OK) {
            return 3;
        }
        return 5;
    }
}
