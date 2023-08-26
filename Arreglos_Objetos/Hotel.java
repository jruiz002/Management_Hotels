/**
 * Clase controladora que permite toda la gestión de la reservación de las habitaciones.
 */
import java.util.Scanner;

public class Hotel {
    // Atributos
    private Cliente[] listaEspera;
    private Habitacion[] listaHabitaciones;
    private Reservacion[] listaReservaciones;
    
    /**
     * Método constructor que brinda un tamaño a los arreglos de las listas.
     */
    public Hotel() {
        listaEspera = new Cliente[100];
        listaHabitaciones  = new Habitacion[100];
        listaReservaciones = new Reservacion[100];
    }

    /**
     * 
     * @param habitacion parámetro que contiene la habitación a agregar a la lista.
     */
    public void agregarHabitacion(Habitacion habitacion){
        boolean bandera = false;
        //Loop que recorre la lista para posteriormete agregar
        for (int i = 0; i < listaHabitaciones.length; i++){
            if(!bandera){
                if (listaHabitaciones[i] == null){
                    listaHabitaciones[i] = habitacion;
                    bandera = true;
                }
            }
        }
    }

    /** 
     * Método que muestra las habitaciones realizadas.
    */
    public void mostrarHabitaciones(){
        for (Habitacion habitacion2 : listaHabitaciones) {
            if(habitacion2 != null){
                System.out.println(habitacion2.toString());
            }
        }
    }

    /**
     * 
     * @param cliente parámetro que almance el cliente a agregar a la lista
     */
    public void agregarCliente(Cliente cliente){
        boolean bandera = false;
        //Loop que recorre la lista para posteriormete agregar
        for (int i = 0; i < listaEspera.length; i++){
            if(!bandera){
                if (listaEspera[i] == null){
                    listaEspera[i] = cliente;
                    bandera = true;
                }
            }
        }
        System.out.println("Cliente agregado exitosamente.");
    }

    /**
     * Método que muestra los clientes de la lista
     */
    public void mostrarClientes(){
        for(int i = 0; i < listaEspera.length; i++){
            if (listaEspera[i] != null){
                System.out.println(" - " + i + ": " + listaEspera[i].toString());
            }
        }
    }

    /**
     * 
     * @param reservacion parámetro que contiene la reseración a agregar a la lista
     */
    public void agregarReservacion(Reservacion reservacion){
        boolean bandera = false;
        //Loop que recorre la lista para posteriormete agregar
        for (int i = 0; i < listaReservaciones.length; i++){
            if(!bandera){
                if (listaReservaciones[i] == null){
                    listaReservaciones[i] = reservacion;
                    bandera = true;
                }
            }
        }
        System.out.println("Reservación agregada exitosamente.");
    }

    /**
     * Método para mostrar las reservaciones
     */
    public void mostrarReservaciones(){
        for(int i = 0; i < listaReservaciones.length; i++){
            if (listaReservaciones[i] != null){
                System.out.println(" - " + i + ": " + listaReservaciones[i].toString());
            }
        }
    }

    /**
     * Método que realiza la reservación con cada una de las validaciones.
     */
    public void reservacion(){
        Scanner sc = new Scanner(System.in);
        // Se selecciona al cliente, para realizar la reservación
        System.out.println("Seleccione al cliente al cuál desea asignar por medio de su ID: ");
        mostrarClientes();
        int idCliente = sc.nextInt();
        Cliente cliente = listaEspera[idCliente];
        System.out.println("--------------------------------------");
        System.out.println("Cliente seleccionado: " + cliente.getNombre());
        System.out.println();
        //Se muestran las habitaciones correspondientes según el tipo de cliente
        System.out.println("Habitaciones disponibles: ");
        for(int i = 0; i < listaHabitaciones.length; i++){
            if (cliente.getTipo() == "VIP"){ // Cliente VIP
                if (listaHabitaciones[i] != null){
                    System.out.println(" - " + i + ": " + listaHabitaciones[i].toString());
                }               
            }else if (cliente.getTipo() == "Frecuente"){ // Cliente Frecuente
                if (listaHabitaciones[i] != null){
                    if (listaHabitaciones[i].getTipo() == "Deluxe" || listaHabitaciones[i].getTipo() == "Estandar"){
                        System.out.println(" - " + i + ": " + listaHabitaciones[i].toString());
                    }
                }
            }else if (cliente.getTipo() == "Regular"){ // Cliente regular
                if (listaHabitaciones[i] != null){
                    if (listaHabitaciones[i].getTipo() == "Estandar"){
                        System.out.println(" - " + i + ": " + listaHabitaciones[i].toString());
                    }                    
                }
            }
        }
        System.out.println("--------------------------------------");
        // Se da la opción para seleccionar la habitación
        System.out.println("Elija la habitación que desea seleccionar: ");
        int id_habitacion = sc.nextInt();
        //Se asigna la habitación seleccionada.
        Habitacion habitacion = listaHabitaciones[id_habitacion];
        System.out.println();
        System.out.println("Habitación seleccionada: " + habitacion.toString());
        System.out.println();

        // Validaciones para ver si cumple el cliente y la habitación para poder ser reservada.
        if (habitacion.getCapacidadMax() > 0){
            System.out.println("Ingrese el ID de su reservación: ");
            int id = sc.nextInt();
            // Se crea la reservación
            Reservacion reservacion = new Reservacion(id, cliente, habitacion);
            agregarReservacion(reservacion);
            System.out.println("--------------------------------------");
            int reservacionesCliente = cliente.getReservaciones() + 1;
            cliente.setReservaciones(reservacionesCliente);
            // Se válida el tipo de cliente según su número de reservaciones
            if(cliente.getReservaciones() >= 5 && cliente.getReservaciones() < 10){
                cliente.setTipo("Frecuente");
            }else if (cliente.getReservaciones() >= 10){
                cliente.setTipo("VIP");
            }
            // Se actualiza la capacidad de la habitación
            int newCapacidadHabitacion = habitacion.getCapacidadMax() - 1;
            habitacion.setCapacidadMax(newCapacidadHabitacion);
            
            System.out.println(cliente.toString());
            System.out.println(habitacion.toString());

        }else{ // Si no cumple con la condición se le indica que ya no hay espacios disponibles
            System.out.println("Lo sentimos, esta habitación ya no tiene espacios disponibles.");
        }
    }
}
