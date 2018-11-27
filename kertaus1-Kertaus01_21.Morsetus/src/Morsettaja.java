
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Morsettaja {
    private HashMap<Character, String> aakkosto;
    
    public Morsettaja() {
        this.aakkosto = new HashMap<>();
        
        // Latinalaiset aakkoset.
        aakkosto.put('a', ".-");
        aakkosto.put('b', "-...");
        aakkosto.put('c', "-.-.");
        aakkosto.put('d', "-..");
        aakkosto.put('e', ".");
        aakkosto.put('f', "..-.");
        aakkosto.put('g', "--.");
        aakkosto.put('h', "....");
        aakkosto.put('i', "..");
        aakkosto.put('j', ".---");
        aakkosto.put('k', "-.-");
        aakkosto.put('l', ".-..");
        aakkosto.put('m', "--");
        aakkosto.put('n', "-.");
        aakkosto.put('o', "---");
        aakkosto.put('p', ".--.");
        aakkosto.put('q', "--.-");
        aakkosto.put('r', ".-.");
        aakkosto.put('s', "...");
        aakkosto.put('t', "-");
        aakkosto.put('u', "..-");
        aakkosto.put('v', "...-");
        aakkosto.put('w', ".--");
        aakkosto.put('x', "-..-");
        aakkosto.put('y', "-.--");
        aakkosto.put('z', "--..");
        aakkosto.put('å', ".--.-");
        aakkosto.put('ä', ".-.-");
        aakkosto.put('ö', "---.");
        
        // Numerot.
        aakkosto.put('0', "-----");
        aakkosto.put('1', ".----");
        aakkosto.put('2', "..---");
        aakkosto.put('3', "...--");
        aakkosto.put('4', "....-");
        aakkosto.put('5', ".....");
        aakkosto.put('6', "-....");
        aakkosto.put('7', "--...");
        aakkosto.put('8', "---..");
        aakkosto.put('9', "----.");
        
        // Erikoismerkit.
        aakkosto.put('!', "..--.");
        aakkosto.put('?', "..--..");
        aakkosto.put('/', "-..-.");
        aakkosto.put('=', "-...-");
        aakkosto.put(':', "---...");
        aakkosto.put(',', "--..--");
        aakkosto.put('.', ".-.-.-");
        aakkosto.put('-', "-....-");
        aakkosto.put('(', "-.--.");
        aakkosto.put(')', "-.--.-");
    }
    
    public void kaanna(String sana) {
        for (int i = 0; i < sana.length(); i++) {
            System.out.println(this.aakkosto.get(sana.charAt(i)));
        }
    }
}
