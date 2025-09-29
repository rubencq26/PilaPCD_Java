/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author usuario
 */
public class Consumidor implements Runnable{
    
    private final PilaLenta p;
    public Consumidor(stack.PilaLenta p) {
        this.p = p;
    }
    
    @Override
    public void run(){
        Object n;
        for (int i = 0; i < 10; i++) {
            try {
                n = p.Desapila();
                System.out.println("D: " + n);
            } catch(Exception e){

            }

        }
    }

}
