/**
 * Clase que permite la creación de un cliente.
 */
public class Cliente {
    //Atributos
    private String nombre;
    private String tipo;
    private int reservaciones;


    /**
     * 
     * @param nombre parámtro para dar un nombre al cliente
     * @param tipo parámetro para asignar el tipo de cliente que es
     * @param reservaciones parámetro para indicar el número de reservaciones
     */
    public Cliente(String nombre, String tipo, int reservaciones) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.reservaciones = reservaciones;
    }

    /**
     * 
     * @return nombre, devuelve el nombre del cliente.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param nombre parámetro, para dar el nombre al cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return tipo, devuelve el tipo de cliente que es.
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * 
     * @param tipo, setea el tipo de cliente.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return reservaciones, devuelve el número de reservaciones
     */
    public int getReservaciones() {
        return this.reservaciones;
    }

    /**
     * 
     * @param reservaciones, setea el número de reservaciones hechas por cliente
     */
    public void setReservaciones(int reservaciones) {
        this.reservaciones = reservaciones;
    }


    /**
     * Método que devuelve la información de una instancia
     */
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", reservaciones='" + getReservaciones() + "'" +
            "}";
    }



}
