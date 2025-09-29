/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import static java.lang.Thread.sleep;

/**
 * @version 1.0
 * @author rubco
 */
public class PilaLenta implements IPila {

    private Object[] datos;
    private int cima;
    private int capacidad;
    private int numelementos;

    /**
     * Constructor de la clase, se pasa por parámetro el tamaño máximo de pila
     *
     * @param n
     */
    public PilaLenta(int n) {
        cima = -1;
        capacidad = n;
        numelementos = 0;
        datos = new Object[capacidad];
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
    public void Apila(Object elemento) throws Exception {
        sleep(100);
        if (!pilallena()) {
            sleep(100);
            cima++;
            sleep(100);
            datos[cima] = elemento;
            sleep(100);
            numelementos++;
            sleep(100);
        } else {
            throw new Exception("La pila esta llena");
        }
    }

    /**
     * Saca el elemento en la cima de la pila, si la pila esta vacia lanza una
     * Excepcion
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object Desapila() throws Exception {
        sleep(100);
        if (pilavacia()) {
            sleep(100);
            throw new Exception("La pila esta vacia");
        }
        sleep(100);
        numelementos--;
        return datos[cima--];
    }
    
    /**
     * Devuelve el elemento mas alto de la pila sin sacarlo
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
    
    
    public boolean pilavacia(){
        return cima == -1;
    }
    
    public boolean pilallena(){
        return numelementos == capacidad;
    }

}
