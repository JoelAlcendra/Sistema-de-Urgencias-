package Parcial;

public class Paciente {

    private String nombre;
    private String apellido;
    private String id;
    private String edad;
   private String EPS;
    private String servicio;
    

    public Paciente(String nombre, String apellido, String id, String edad, String EPS) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.edad = edad;
        this.EPS = EPS;
        this.servicio = "En espera";
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void actualizarInformacion(String nombre, String apellido, String edad, String EPS) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.EPS = EPS;
    }


    public void actualizarInformacionPa(String servicio) {
        this.servicio = servicio;
        
    }

   

    public String toString() {
        return "\nCedula:  " + id + "," + "   Nombre: " + nombre + "," + "   Apellido: " + apellido + "," + "   Edad: " + edad + "," + "   EPS: " + EPS + "," + "   Servicio: "
                 + servicio + ".";
    }

}
