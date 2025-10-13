/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import InterfazGrafica.CanvasPila;
import java.awt.Color;
import java.util.Random;


/**
 *
 * @author usuario
 */
public class Productor extends Thread {

    private final PilaLenta p;
    private final Random r;
    private final CanvasPila canvas;
    public Productor(stack.PilaLenta p, CanvasPila canvas) {
        this.p = p;
        r =new Random(System.nanoTime());
        this.canvas = canvas;
    }
    
    @Override
    public void run(){
        int n;
        for (int i = 0; i < 30; i++) {
            try{
                n = r.nextInt(1,100);
                p.Apila(n);
                System.out.println("P: " + n);
                canvas.setColorPilaVacia(Color.BLACK);
                canvas.representa(p.getDatos());
                sleep(500 + r.nextInt(1500));
            }catch (Exception e){
                canvas.setColorPilaLlena(Color.RED);
                canvas.repaint();
                System.out.println("Error: " + e.getMessage());
                try { sleep(800); } catch(InterruptedException ex) {}
            }
            
        }
        
    }
}
