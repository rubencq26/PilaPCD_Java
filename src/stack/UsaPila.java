/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stack;

import java.util.Random;

/**
 *
 * @author rubco
 */
public class UsaPila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PilaLenta p = new PilaLenta(10);
        
        Productor h1 = new Productor(p);
        Productor h2 = new Productor(p);
        
        Consumidor r1 = new Consumidor(p);
        Consumidor r2 = new Consumidor(p);
        
        Thread h3 = new Thread(r1);
        Thread h4 = new Thread(r2);
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        
        
    }

}
