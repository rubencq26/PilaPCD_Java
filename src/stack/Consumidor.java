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
    private static boolean finish;
    public Consumidor(stack.PilaLenta p, CanvasPila canvas) {
        this.p = p;
        this.canvas = canvas;
        finish = false;
    }
    
    @Override
    public void run(){
        Random r = new Random(System.nanoTime());
        Object n;
        for (int i = 0; i < 15; i++) {
            try {
                n = p.Desapila();
                System.out.println("D: " + n);
                canvas.setColorPilaLlena(Color.BLACK);
                canvas.representa(p.getDatos());
                sleep(1000 + r.nextInt(2000));
            } catch(Exception e){
                canvas.setColorPilaVacia(Color.RED);
                canvas.repaint();
                System.out.println("Error: " + e.getMessage());
                p.finalizarNotificar();
                break;
            }

        }
        System.out.println("Consumidor finaliza su ejecucion");
        p.finalizarNotificar();
        
    }
    
    public static boolean getFinish(){
        
        return finish;
    }
    
    public static void setFinish(boolean f){
        finish = f;
    }

}
