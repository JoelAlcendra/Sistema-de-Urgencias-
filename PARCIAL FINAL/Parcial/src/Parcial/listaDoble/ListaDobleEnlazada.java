package Parcial.listaDoble;

import Parcial.Paciente;

public class ListaDobleEnlazada {
    private Nodo cabeza;
    private Nodo cola;

    public ListaDobleEnlazada() {
        cabeza = null;
        cola = null;
    }

    public boolean isVacia() {

        return cabeza == null;
    }

    // Método para insertar un elemento al principio de la lista
    public void insertarAlPrincipio(Paciente dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
    }

    // Método para eliminar un elemento de la lista
    public void eliminar(Paciente dato) {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.dato == dato) {
                if (nodoActual.anterior != null) {
                    nodoActual.anterior.siguiente = nodoActual.siguiente;
                } else {
                    cabeza = nodoActual.siguiente;
                }

                if (nodoActual.siguiente != null) {
                    nodoActual.siguiente.anterior = nodoActual.anterior;
                } else {
                    cola = nodoActual.anterior;
                }
                return;
            }
            nodoActual = nodoActual.siguiente;
        }
    }

    // Método para consultar si un elemento está en la lista
    public boolean contiene(Paciente dato) {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.dato == dato) {
                return true;
            }
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }

    // Método para imprimir la lista de izquierda a derecha
    public void imprimirIzquierdaADerecha() {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.print(nodoActual.dato + " ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println();
    }

    // Método para imprimir la lista de derecha a izquierda
    public void imprimirDerechaAIzquierda() {
        Nodo nodoActual = cola;
        while (nodoActual != null) {
            System.out.println(nodoActual.dato);
            nodoActual = nodoActual.anterior;
        }
        System.out.println();
    }

    
}
