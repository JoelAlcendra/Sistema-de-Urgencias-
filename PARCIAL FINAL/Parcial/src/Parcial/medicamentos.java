package Parcial;

import java.util.ArrayList;
import java.util.List;

class medicamentos {
    private String nombre;
    private int codigo;
    private int existencias;

    public medicamentos(String nombre, int codigo, int existencias) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.existencias = existencias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getExistencias() {
        return existencias;
    }

    public void actualizarExistencias(int cantidad) {
        existencias -= cantidad;
    }

    @Override
    public String toString() {
        return "Medicamento: " + nombre + " (Código: " + codigo + ", Existencias: " + existencias + ")";
    }
}