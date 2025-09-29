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
        
        
        Random rd = new Random(System.nanoTime());
        int num = 0;
        for (int i = 0; i < 10; i++) {
            num = rd.nextInt(100);
            try {
                if (num % 2 == 0) {
                    p.Apila(num);
                } else {
                    System.out.println(p.Desapila()); 
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage() + "  " + num);
            }

        }
    }

}
