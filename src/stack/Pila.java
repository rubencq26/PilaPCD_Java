/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 * @version 1.0
 * @author rubco
 */
public class Pila implements IPila {

    private Object[] datos;
    private int cima;
    private int capacidad;
    private int numelementos;

    /**
     * Constructor de la clase, se pasa por parámetro el tamaño máximo de pila
     *
     * @param n
     */
    public Pila(int n) {
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
        if (!pilallena()) {
            cima++;
            datos[cima] = elemento;
            numelementos++;
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
        if (pilavacia()) {
            throw new Exception("La pila esta vacia");
        }
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
