package Parcial.listaDoble;

import Parcial.Paciente;

public class Nodo {
    public Paciente dato;
    public Nodo siguiente;
    public Nodo anterior;

    public Nodo(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
