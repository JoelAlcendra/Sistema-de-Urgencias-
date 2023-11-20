package Parcial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Urgencias objUrgencias = new Urgencias();
        String servicio = "";
        int op = 0;
        int op2 = 0;
        int op3 =0;

        do {
               System.out.println("\n|------------------BIENVENIDO A LA CLÍNICA GENERAL DEL NORTE DE SOLEDAD ------------------|");
               System.out.println("1. Admisiones.");
               System.out.println("2. Urgencias(Triaje)");
               System.out.println("3. Salir.");
               System.out.print("Escoja una opcion: ");
               op = s.nextInt();

            
                switch (op) {
                    case 1:
                       do {
                            System.out.println("\n |----------Admisiones---------|");
                            System.out.println("1. Registrar Paciente.");
                            System.out.println("2. Actualizar dato de un Paciente.");
                            System.out.println("3. Mostrar Pacientes registrados.");
                            System.out.println("4. Volver.");
                            System.out.print("Escoja una opcion: ");
                            
                           
                            op = s.nextInt();

                            switch (op){
                                
                                case 1:  
                                    System.out.println();
                                    System.out.print("Ingrese su cedula : ");
                                    String id = s.next();

                                    if (objUrgencias.existeId(id)) {
                                     System.err.println("\nERROR, has ingresado la cedula de un paciente ya registrado");
                                     break;
                                    } 

                                    System.out.print("Ingrese su nombre : ");
                                    String nombre = s.next();

                                    System.out.print("Ingrese su apellido : ");
                                    String apellido = s.next();

                                    System.out.print("Ingrese su edad: ");
                                    String edad = s.next();

                                    System.out.print("Ingrese la EPS a la que pertenece(SALUDTOTAL, NUEVAEPS, SURA, SANITAS...): ");
                                    String EPS = s.next();

                                    Paciente NuevoPaciente = new Paciente(nombre, apellido, id, edad, EPS);
                                    objUrgencias.REGISTRARPACIENTE(NuevoPaciente);

                                break;

                                case 2:
                                    if (objUrgencias.PacientesRegistrados().isVacia()) {
                                    System.out.println();
                                    System.out.println("NO HAY PACIENTES PARA ACTUALIZAR!!!");
                                    break;
                                }  
                                    System.out.println();
                                    System.out.print("Ingrese el número de cédula del paciente a actualizar: ");
                                    String cedulaActualizar = s.next();

                                    Paciente pacienteEncontrado = objUrgencias.buscarPacientePorCedula(cedulaActualizar);
                                    if (pacienteEncontrado == null) {
                                        System.out.println();
                                        System.out.println("Paciente no encontrado,verifique la cedula.");
                                        
                                    }
                                    else {
                                        System.out.println();
                                        System.out.print("Ingrese el nuevo nombre: ");
                                        String nuevoNombre = s.next();                                          
                                        
                                        System.out.print("Ingrese el nuevo apellido: ");
                                        String nuevoApellido = s.next();    
                                        
                                        System.out.print("Ingrese la nueva edad: ");
                                        String nuevaEdad = s.next();
                                          
                                        System.out.print("Ingrese la nueva EPS: ");
                                       String nuevaEPS = s.next();
                                
                                       objUrgencias.actualizarInformacionPaciente(cedulaActualizar, nuevoNombre, nuevoApellido, nuevaEdad, nuevaEPS);

                                    }

                                    
                            
                                    
                                break;
                                  
                                case 3:
                                    System.out.println();
                                    objUrgencias.listarRegistrados();
                                break;

                                case 4:
                                    System.out.println("Volviendo...");
                                break;

                                default:
                                    System.out.println("Opcion invalida!!");
                                break;
                           }

                        } while (op !=4);
                       
                    break;

                    case 2:
                        do {

                            System.out.println("\n|--------------Urgencias---------------|");
                            System.out.println("1. Atender Paciente.");
                            System.out.println("2. Mostrar Pacientes Atendidos.");
                            System.out.println("3. Volver.");
                            System.out.print("Escoja una opcion:");
                            op2 = s.nextInt();

                            switch (op2) {
                                case 1:

                                    if (objUrgencias.PacientesRegistrados().isVacia()) {
                                        System.out.println();
                                        System.out.println("NO HAY PACIENTES PARA ATENDER!");
                                        break;
                                    }

                                    else{
                                           System.out.println();
                                           objUrgencias.listarEspera();

                                           System.out.println("|------------------------------------------------|");
                                           System.out.print("Digite la identificacion del paciente para atender: ");
                                           String buscarid = s.next();

                                           Paciente pacienteEncontrado = objUrgencias.buscarPacientePorCedula(buscarid);
                                           
                                           if (pacienteEncontrado != null) {
                                                System.out.println();
                                                System.out.println("Paciente encontrado: " + pacienteEncontrado);
                                                System.out.println();
                                                 
                                            

                                                System.out.println("\n |------------Urgencias(triaje)-------------|"); 
                                                System.out.println("(determinará el grado de urgencia de un paciente)");
                                                System.out.println();
                                                System.out.println("1. Admitir a urgencias...");
                                                System.out.println("2. Dar De alta con Tratamiento...");
                                                System.out.println("3. Dar de alta por Consulta Prioritaria...");
                                                System.out.println("4. volver.");
                                                System.out.print("Escoja una opcion: ");
                                                op3 = s.nextInt();

                                             switch (op3) {
                                                case 1: 
                                                   System.out.println("\n------->Asignarle un servicio:");
                                                   System.out.println("1. Cirugía...");
                                                   System.out.println("2. Medicina interna...");
                                                   System.out.println("3. Hospitalización...");
                                                   System.out.println("4. Cuidado intermedio...");
                                                   System.out.println("5. otra...");
                                                   System.out.println("6. volver:");
                                                   System.out.print("Escoja un opcion:");
                                                   int op4 = s.nextInt();

                                                   servicio = "";

                                                   switch (op4) {
                                                       case 1:
                                                         servicio = "Paciente remitido a Cirugia.";
                                                         objUrgencias.actualizarServicio(buscarid, servicio);
                                                        break;

                                                        case 2:
                                                         servicio="Paciente remitido a Medicina interna.";
                                                         objUrgencias.actualizarServicio(buscarid, servicio);
                                                        break;

                                                        case 3:
                                                         servicio = "Paciente remitido a Hospitalización.";
                                                         objUrgencias.actualizarServicio(buscarid, servicio);
                                                        break;

                                                        case 4:
                                                         servicio = "Paciente remitido a Cuidado intermedio.";
                                                         objUrgencias.actualizarServicio(buscarid, servicio);
                                                        break;

                                                        case 5:
                                                         servicio="Paciente remitido a otro servicio.";
                                                         objUrgencias.actualizarServicio(buscarid, servicio);
                                                        break;

                                                        case 6:
                                                         System.out.println("Volviendo...");
                                                        break;

                                                        default:
                                                         System.out.println("Servicio no encontrado o invalido.");
                                                        break;                                                        
                                                   }
                                                  objUrgencias.atenderPaciente(buscarid);
                                                break;

                                                case 2:
                                                    objUrgencias.mostrarInventarioMedicamentos();
                                                    System.out.print("Escoja un Tratamiento: ");
                                                    int opcionMedicamento = s.nextInt();

                                                    servicio = "";
                                                    int cantidad;
                                                    switch (opcionMedicamento) {
                                                        case 1:
                                                            System.out.print("Ingrese cantidad: ");
                                                            cantidad = s.nextInt();
                                                            System.out.println();
                                                            servicio="Dado de alta con Tratamiento de " + "[" + cantidad+ "]" + " Acetaminofen";
                                                            objUrgencias.actualizarServicio(buscarid, servicio);
                                                            
                                                            break;
                                                        case 2:
                                                            System.out.print("Ingrese cantidad: ");
                                                            cantidad = s.nextInt();
                                                            System.out.println();
                                                            servicio="Dado de alta con Tratamiento de " + "[" + cantidad+ "]" + " Ibuprfeno";
                                                            objUrgencias.actualizarServicio(buscarid, servicio);
                                                            
                                                          break;
                                                        case 3:
                                                            System.out.print("Ingrese cantidad: ");
                                                            cantidad = s.nextInt();
                                                            System.out.println();
                                                            servicio="Dado de alta con Tratamiento de " + "[" + cantidad+ "]" + " Azitromicina";
                                                            objUrgencias.actualizarServicio(buscarid, servicio);
                                                        
                                                        break;

                                                        case 4:
                                                            System.out.print("Ingrese cantidad: ");
                                                            cantidad = s.nextInt();
                                                            System.out.println();
                                                            servicio="Dado de alta con Tratamiento de " + "[" + cantidad+ "]" + " Paracetamol";
                                                            objUrgencias.actualizarServicio(buscarid, servicio);
                                                        break;

                                                        case 5:
                                                            System.out.print("Ingrese cantidad: ");
                                                            cantidad = s.nextInt();
                                                            System.out.println();
                                                            servicio="Dado de alta con Tratamiento de " + "[" + cantidad+ "]" + " Dolex";
                                                            objUrgencias.actualizarServicio(buscarid, servicio);
                                                        break;

                                                        default:
                                                            System.out.println("Medicamento No encontrado!");
                                                        break;
                                                    }

        
                                                    objUrgencias.atenderPaciente(buscarid);
                                                break;

                                                case 3:
                                                      servicio ="Remitido a cita con su EPS";
                                                      System.out.println("El cliente no presenta una urgencia, remitido para que solicite una cita posteriormente a su EPS.");
                                                      objUrgencias.actualizarServicio(buscarid, servicio);
                                                      System.out.println();   
                                                      objUrgencias.atenderPaciente(buscarid);
                                                 break;

                                                case 4:
                                                  System.out.println("volviendo");
                                                break;

                                                default:
                                                 System.out.println("Opcion invalida");
                                                break;
                                            }   
                                            
                                       
                                                 
                                        } else {
                                            System.out.println();
                                            System.out.println("Paciente no encontrado, verifique el número de cédula.");
                                            break;
                                        }
                                    }

                                break;
                                
                                case 2:
                                  objUrgencias.listarAtendidos();
                                break;

                                case 3:
                                  System.out.println("Volviendo...");
                                break;

                                default:
                                System.out.println("Opcion invalida!");
                                break;
                                              
                            }
                            
                        } while(op2 !=3);

                    break;

                    case 3:

                      System.out.println("saliendo...");
                      
                    break;

                    default:
                      System.out.println("Opcion invalida!!");
                    break;
                }
            } while (op != 3);
    } 
}  
