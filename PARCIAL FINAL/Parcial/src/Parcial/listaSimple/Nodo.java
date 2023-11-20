package Parcial.listaSimple;

import Parcial.Paciente;

public class Nodo {
    public Paciente dato;
    public Nodo siguiente;

    public Nodo(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
