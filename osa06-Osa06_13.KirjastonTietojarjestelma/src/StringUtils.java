/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class StringUtils {
    public static boolean sisaltaa(String sana, String haettava) {
        if (sana == null || haettava == null) {
            return false;
        }
        
        sana = sana.toLowerCase().trim();
        haettava = haettava.toLowerCase().trim();
        
        return sana.contains(haettava);
    }
}
