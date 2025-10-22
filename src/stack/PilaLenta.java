/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import InterfazGrafica.CanvasPila;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @author rubco
 */
public class PilaLenta implements IPila {

    private Object[] datos;
    private int cima;
    private int capacidad;
    private int numelementos;
    private CanvasPila cv;

    /**
     * Constructor de la clase, se pasa por parámetro el tamaño máximo de pila
     *
     * @param n
     */
    public PilaLenta(int n, CanvasPila cv) {
        cima = -1;
        capacidad = n;
        numelementos = 0;
        datos = new Object[capacidad];
        this.cv = cv;
    }

    /**
     * Devuelve el número de elementos apilados en la pila
     *
     * @return
     */
    @Override
    public int GetNum() {
        return this.numelementos;
    }

    /**
     * Apila el elemento encima de la pila, si no se puede salta error
     *
     * @param elemento
     * @throws java.lang.Exception
     */
    @Override
    public synchronized void Apila(Object elemento, int id) throws Exception {
        int contador = 0;
        

        while(pilallena() && contador < 3){
            if(Consumidor.getFinish()){
            break;
        }
            System.out.println("El productor " + id + " se queda en espera");
            cv.setColorPilaLlena(Color.RED);
            wait();
            contador++;
            System.out.println("El productor " + id + " sale de la espera");
        }
        
        if(!pilallena()){
            
            datos[++cima] = elemento;
            
            
            
            numelementos++;
            cv.setColorPilaVacia(Color.BLACK);
            if(pilallena()){
                cv.setColorPilaLlena(Color.red);
            }
            System.out.println("El productor " + id + " apila " + elemento);
            notifyAll();
        }else{
            cv.setColorPilaLlena(Color.RED);
            throw new Exception("El productor " + id + " desiste y termina su ejecucion");
        }
    }

    /**
     * Saca el elemento en la cima de la pila, si la pila esta vacia lanza una
     * Excepcion
     *
     * @return
     * @throws java.lang.InterruptedException
     */
    @Override
    public synchronized Object Desapila() throws Exception {
        int contador = 0;
        
        while(pilavacia() && contador < 3){
            cv.setColorPilaVacia(Color.RED);
            wait();
            contador++;
        }
        
        if(!pilavacia()){
            
            numelementos--;
            
            cv.setColorPilaLlena(Color.BLACK);
            notifyAll();
            return datos[cima--];
            
            
        }else{
            cv.setColorPilaVacia(Color.RED);
            finalizarNotificar();
            throw new Exception("El consumidor desiste y abandona la ejecucion");
        }
    }

    /**
     * Devuelve el elemento mas alto de la pila sin sacarlo
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object Primero() throws Exception {
        if (pilavacia()) {
            throw new Exception("La pila esta vacia");
        }
        return datos[cima];
    }

    public boolean pilavacia() {
        return cima == -1;
    }

    public boolean pilallena() {
        return numelementos == capacidad;
    }

    public synchronized List<Object> getDatos() {
        List<Object> lista = new ArrayList<>();
        for (int i = cima; i >= 0; i--) {
            lista.add(datos[i]);
        }
        return lista;
    }
    
    public synchronized void finalizarNotificar(){
        Consumidor.setFinish(true);
        notifyAll();
    }

}
