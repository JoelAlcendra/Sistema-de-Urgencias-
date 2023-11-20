package Parcial.listaSimple;

import Parcial.Paciente;

public class ListaEnlazaada {
    private Nodo cabeza;

    public ListaEnlazaada() {
        cabeza = null;
    }

    // Método para insertar un elemento al principio de la lista
    public void insertarAlPrincipio(Paciente dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;

    }

    public boolean isVacia() {

        return cabeza == null;
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

    // Método para imprimir la lista
    public void imprimir() {
        if (isVacia()) {
            System.out.println("La lista de registros esta vacia");
            return;
        }
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.println("\n"+nodoActual.dato);
            nodoActual = nodoActual.siguiente;
        }
        System.out.println();
    }

    public Nodo getCabeza() {
        return cabeza;
    } 

}
