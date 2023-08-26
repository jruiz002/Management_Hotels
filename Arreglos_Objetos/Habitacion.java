/**
 * Clase que permite la creación de una habitación
 */

public class Habitacion {
    //Atributos
    private int id;
    private double precio;
    private String tipo;
    private int capacidadMax;

    /**
     * 
     * @param id parámetro que indica el id de la habitación
     * @param precio parámetro que indica el precio de la habitación
     * @param tipo parámetro que indica el tipo de la habitación
     * @param capacidadMax parámetro que indica la capacidad de la habitación
     */
    public Habitacion(int id, double precio, String tipo, int capacidadMax) {
        this.id = id;
        this.precio = precio;
        this.tipo = tipo;
        this.capacidadMax = capacidadMax;
    }

    /**
     * 
     * @return devuelve el id de la habitación
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @param id setea el id de la habitación
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return devuelve el precio de la habitación
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * 
     * @param precio setea el precio de la habitación
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * 
     * @return devuelve el tipo de la habitación
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * 
     * @param tipo setea el tipo de la habitación
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return devuelve la capacidad de personas de la habitación
     */
    public int getCapacidadMax() {
        return this.capacidadMax;
    }

    /**
     * 
     * @param capacidadMax setea la capacidad de personas de la habitación
     */
    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }


    /**
     * Método que devuelve la información de una instancia de tipo Habitación.
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", capacidadMax='" + getCapacidadMax() + "'" +
            "}";
    }

}