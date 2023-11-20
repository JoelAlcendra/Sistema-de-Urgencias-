package Parcial;

import java.util.*;

import Parcial.listaDoble.ListaDobleEnlazada;
import Parcial.listaSimple.ListaEnlazaada;
import Parcial.listaSimple.Nodo;


public class Urgencias {
    private Scanner s = new Scanner(System.in);
    
    private ListaEnlazaada pacientesRegistrados;// Se usa la estructura de lista simple para el registro de los
    // paciente
    
    public Stack<Paciente> pacientesAtendidos; // Estructura PILA para los pacientes ATENDIDOS;
                                               // USA LIFO(LAST IN FIRST OUT)
    private ListaDobleEnlazada pacientesEspera; // lista doble para los pacientes en espera

    private List<medicamentos> inventarioMedicamentos;
   

    public Urgencias() {
        pacientesRegistrados = new ListaEnlazaada();
 
        pacientesAtendidos = new Stack<>();

        pacientesEspera = new ListaDobleEnlazada();

        inventarioMedicamentos = new ArrayList<>();

        inventarioMedicamentos.add(new medicamentos("1. Acetaminofen", 01, 150));
        inventarioMedicamentos.add(new medicamentos("2. Ibuprofeno", 02, 150));
        inventarioMedicamentos.add(new medicamentos("3. Azitromicina", 03, 150));
        inventarioMedicamentos.add(new medicamentos("4. Paracetamol", 04, 150));
        inventarioMedicamentos.add(new medicamentos("5. Dolex", 05, 150));

    }

    public void REGISTRARPACIENTE(Paciente paciente) {
        pacientesRegistrados.insertarAlPrincipio(paciente);
        pacientesEspera.insertarAlPrincipio(paciente);
        System.out.println();
        System.out.println("-------------------Paciente Registrado-------------------");
        System.out.println();
        System.out.println("informacion del paciente:");
        System.out.println(paciente);

        System.out.println();

    }

    public void MOSTRARPACIENTES() {

        if (pacientesRegistrados.isVacia()) {
            System.out.println("NO HAY PACIENTES REGISTRADOS!!");
        } else {
            System.out.println("------------------Todos los pacientes--------------------");
            pacientesRegistrados.imprimir();

        }

    }

    public Paciente buscarPaciente(String id, int numeroLista) {

        if (numeroLista == -1) {
            Nodo nodoActual = pacientesRegistrados.getCabeza();
            while (nodoActual != null) {
                if (nodoActual.dato.getId().equals(id)) {
                    return nodoActual.dato;
                }
                nodoActual = nodoActual.siguiente;
            }
        }
        return null;
    }

    public Paciente buscarPacientePorCedula(String id) {
        Nodo nodoActual = pacientesRegistrados.getCabeza();
        while (nodoActual != null) {
            if (nodoActual.dato.getId().equals(id)) {
                return nodoActual.dato;
            }
            nodoActual = nodoActual.siguiente;
        }
        return null;
        
    }

    
    public void actualizarInformacionPaciente(String id, String nuevoNombre, String nuevoApellido, String nuevaEdad, String nuevaEPS) {

        Paciente paciente = buscarPaciente(id, -1);

        if (paciente != null) {
           paciente.actualizarInformacion(nuevoNombre, nuevoApellido, nuevaEdad,nuevaEPS);
            System.out.println("La información del paciente ha sido actualizada.");
            System.out.println(paciente);

        } else {
            System.out.println("Paciente no encontrado, Verifique el número de cédula.");
            
        }

    }

    public void actualizarServicio(String id,String servicio){
        Paciente paciente = buscarPaciente(id, -1);

        if (paciente != null) {
            paciente.actualizarInformacionPa(servicio);
            System.out.println();
            System.out.println("-|-----------Paciente atendido con exito-------------|-");
            System.out.println(paciente);

            pacientesAtendidos.push(paciente);// se añade a la lista de pacientes atendidos
        }

      

    }

    public void listarRegistrados(){

        // Validar que existan registros.
        if (pacientesRegistrados.isVacia()) {
            System.out.println("NO SE HA REGISTRADO PACIENTES AL MOMENTO!!!!");
            return;
        }

        System.out.println("\n-----------------Pacientes registrados hasta el momento------------------");
        pacientesRegistrados.imprimir();

    }
   
    public void listarAtendidos() {

        // Validar que existan registros.
        if (pacientesRegistrados.isVacia()) {
            System.out.println("NO SE HA REGISTRADO PACIENTES AL MOMENTO!!!!");
            return;
        }
        // validar que existan pacientes atendidos.
        if (pacientesAtendidos.empty()) {
            System.out.println("NO SE HAN ATENDIDO PACIENTES HASTA EL MOMENTO!!!!");
            return;
        }

        System.out.println(
                "\n---------------------------Pacientes atendidos hasta el momento---------------------------");
        for (Paciente p : pacientesAtendidos) {

            System.out.println(p);
        }

    }


    public void listarEspera() {
        if (pacientesRegistrados.isVacia()) {
            System.out.println("\nNO SE HAN REGISTRADO PACIENTES HASTA EL MOMENTO !!!!");
            return;
        }

        // Validar que existan pacientes en espera hasta el momento.
        if (pacientesEspera.isVacia()) {
            System.out.println("\nNO HAY PACIENTES EN ESPERA HASTA EL MOMENTO !!!!");
            return;
        }

        System.out.println(
                "\n|---------------------------Pacientes en espera de atencion---------------------------|");
               pacientesEspera.imprimirDerechaAIzquierda();
        
        
    }

    public void atenderPaciente(String id){
        
       Paciente paciente = buscarPaciente(id, -1);

        if (paciente != null) {

            pacientesEspera.eliminar(paciente);// se elimina de la lista de pacientes en espera

        }
            
    }

    public boolean existeId(String id) {

        Nodo nuevo = pacientesRegistrados.getCabeza();

        while (nuevo != null) {
            if (nuevo.dato.getId().equals(id)) {
                return true;
            }
            nuevo = nuevo.siguiente;
        }

        return false;
    }

    public ListaEnlazaada PacientesRegistrados() {
        return pacientesRegistrados;
    }

    public Stack pacientesAtendidos(){
        
        return pacientesAtendidos;
    }

    public void mostrarInventarioMedicamentos() {
        System.out.println("\nInventario de Medicamentos:");
        for (medicamentos medicamento : inventarioMedicamentos) {
            System.out.println(medicamento);
        }
    }

    

}
