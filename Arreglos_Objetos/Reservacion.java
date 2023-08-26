/**
 * Clase que permite la creación de una reservación
 */
public class Reservacion {
    //Atributos
    private int id;
    private Cliente cliente;
    private Habitacion habitacion;

    /**
     * 
     * @param id parámetro para dar un id al cliente
     * @param cliente parámetro para asignar un cliente a la reservación
     * @param habitacion parámetro para asignar una habitación a la reservación
     */
    public Reservacion(int id, Cliente cliente, Habitacion habitacion) {
        this.id = id;
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    /**
     * 
     * @return devuelve el id de la reservación
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return devuelve el cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * 
     * @return devuelve la habitación
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }


    /**
     * Método para brindar información de una instancia de tipo reservación
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cliente='" + getCliente() + "'" +
            ", habitacion='" + getHabitacion() + "'" +
            "}";
    }


}
