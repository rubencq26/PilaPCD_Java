/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import java.util.Random;

/**
 *
 * @author usuario
 */
public class Productor extends Thread {

    private final PilaLenta p;
    private final Random r;
    public Productor(stack.PilaLenta p) {
        this.p = p;
        r =new Random(System.nanoTime());
    }
    
    @Override
    public void run(){
        int n;
        for (int i = 0; i < 10; i++) {
            try{
                n = r.nextInt(1,100);
                p.Apila(n);
                System.out.println("P: " + n);
            }catch (Exception e){
                
            }
            
        }
        
    }
}
