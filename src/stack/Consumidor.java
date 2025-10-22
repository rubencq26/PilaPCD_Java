/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import InterfazGrafica.CanvasPila;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Consumidor implements Runnable{
    
    private final PilaLenta p;
    private CanvasPila canvas;
    public Consumidor(stack.PilaLenta p, CanvasPila canvas) {
        this.p = p;
        this.canvas = canvas;
    }
    
    @Override
    public void run(){
        Random r = new Random(System.nanoTime());
        Object n;
        for (int i = 0; i < 40; i++) {
            try {
                n = p.Desapila();
                System.out.println("D: " + n);
                canvas.setColorPilaLlena(Color.BLACK);
                canvas.representa(p.getDatos());
                sleep(500 + r.nextInt(1500));
            } catch(InterruptedException e){
                canvas.setColorPilaVacia(Color.RED);
                canvas.repaint();
                System.out.println("Error: " + e.getMessage());
                try { sleep(800); } catch(InterruptedException ex) {}
            }

        }
    }

}
