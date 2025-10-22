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
    private int id;
    public Productor(stack.PilaLenta p, CanvasPila canvas, int id) {
        this.p = p;
        r =new Random(System.nanoTime());
        this.canvas = canvas;
        this.id = id;
    }
    
    @Override
    public void run(){
        int n;
        for (int i = 0; i < 15; i++) {
            try{
                n = r.nextInt(1,100);
                p.Apila(n, id);
                System.out.println("P" + id + ": "+ n);
                canvas.setColorPilaVacia(Color.BLACK);
                canvas.representa(p.getDatos());
                sleep(1000 + r.nextInt(2000));
            }catch (InterruptedException e){
                canvas.setColorPilaLlena(Color.RED);
                canvas.repaint();
                System.out.println("Error: " + e.getMessage());
                try { sleep(800); } catch(InterruptedException ex) {}
            }
            
            if(Consumidor.getFinish()){
                System.out.println("El productor " + id + " finaliza su ejecucion");
                break;
            }
        }
        
    }
    
    
}
