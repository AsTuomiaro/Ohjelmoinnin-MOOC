/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Lypsyrobotti {
    private Maitosailio maitosailio;
    
    public Lypsyrobotti() {
        
    }

    public Maitosailio getMaitosailio() {
        return maitosailio;
    }

    public void setMaitosailio(Maitosailio maitosailio) {
        this.maitosailio = maitosailio;
    }
    
    public void lypsa(Lypsava lypsava) {
        if (this.maitosailio == null) {
            System.out.println("Maidot menevät hukkaan!");
            return;
        }
        this.maitosailio.lisaaSailioon(lypsava.lypsa());
    }
}
