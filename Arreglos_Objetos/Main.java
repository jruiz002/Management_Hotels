/**
 * - Clase que posee el método main, lo cual permite ser el archivo de arranque del programa.
 * - Sistema que permite gestionar las reservas de las habitaciones de un hotel por medio de la categoría del cliente y la habitación, 
 *   el sistema permite las siguientes opciones:
 *      - 1. Crear un cliente.
 *      - 2. Crear reservación para cliente.
 *      - 3. Crear habitación
 *      - 4. Mostrar reservaciones
 *      - 5. Salir
 *  - Es importante mencionar, que si el usuario o la habitación no cumple con alguna condición no se podrá realizar la reservación; asimismo
 *     el cliente únicamente puede reservación según su categoría, podrá subir de categoría al realizar cierta cantidad de reservaciones:
 *          - Regulares, si visitan por primera vez o han visitado el hotel menos de 5 veces.         
 *          - Frecuentes, que hayan visitado el hotel 5 veces o más.          
 *          - VIP, que han visitado el hotel 10 veces o más. 
 * - @author Jose Ruiz
 * - @version 0.1, 25/08/2023
 */
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Variables de clase
        int opcion = 0;
        boolean bandera = true;
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        Cliente cliente;
        addRooms(hotel);
        
        /**
         * Loop que permite mostrar el menú
         */
        while(bandera){
            Menu();
            opcion = sc.nextInt();

            if(opcion == 1){// Crear un cliente.
                System.out.println("Ingrese el nombre del cliente: ");
                Scanner sc_2 = new Scanner(System.in);
                String nombre = sc_2.nextLine();
                System.out.println();
                //Creación de instancia de un cliente
                cliente = new Cliente(nombre, "Regular", 0);
                // Llamada a método para agregar el cliente
                hotel.agregarCliente(cliente);
                
            }else if (opcion == 2){ // Crear reservación para cliente.
                hotel.reservacion(); //Llamada a método que permite realizar la reservacion

            }else if (opcion == 3){// Crear habitación
                //Se ingresa la data para crear una habitación
                System.out.println("Ingrese el id de la habitación: ");
                int id = sc.nextInt();
                System.out.println("Ingrese el precio de la habitación: ");
                double precio = sc.nextDouble();
                System.out.println("Ingrese el tipo de cada habitación (1. Estandar, 2. Deluxe, 3. Suites): ");
                int index = sc.nextInt();
                String tipo = "";
                if (index == 1){
                    tipo = "Estandar";
                } else if (index == 2){
                    tipo = "Deluxe";
                } else if (index == 3){
                    tipo = "Suites";
                }
                System.out.println("Ingrese la capacidad máxima de la habitación: ");
                int capacidadMax = sc.nextInt();
                //Creación de instancia de tipo Habitación
                Habitacion habitacion = new Habitacion(id, precio, tipo, capacidadMax);
                // Llamada a método para crear la habitación
                hotel.agregarHabitacion(habitacion);
                System.out.println("Habitación agregada exitosamente.");
                // Se muestran las habitaciones que posee el hotel
                hotel.mostrarHabitaciones();

            }else if (opcion == 4){// Mostrar reservaciones
                hotel.mostrarReservaciones();

            }else if (opcion == 5){// Salir
                bandera = false;

            }else{
                System.out.println("Seleccione una opción válida.");
            }

        }

    }

    /**
     * 
     * @param hotel parámetro que permite hacer llamada al método para agregar habitaciones
     */
    public static void addRooms(Hotel hotel){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese 3 habitaciones por favor.");

        // Comienza un ciclo for para iterar 3 veces y recolectar información sobre las habitaciones.
        for(int i = 0; i < 3; i++){
            System.out.println("Ingrese el id de la habitación: ");
            int id = sc.nextInt();
            System.out.println("Ingrese el precio de la habitación: ");
            double precio = sc.nextDouble();
            System.out.println("Ingrese el tipo de la habitación (1. Estandar, 2. Deluxe, 3. Suites): ");
            int index = sc.nextInt();
            String tipo = "";
            if (index == 1){
                tipo = "Estandar";
            } else if (index == 2){
                tipo = "Deluxe";
            } else if (index == 3){
                tipo = "Suites";
            }
            System.out.println("Ingrese la capacidad máxima de la habitación: ");
            int capacidadMax = sc.nextInt();

            // Crea un objeto de la clase "Habitacion" con la información ingresada.
            Habitacion habitacion = new Habitacion(id, precio, tipo, capacidadMax);
            // Llamada al método "agregarHabitacion" en el objeto "hotel" para agregar la habitación.
            hotel.agregarHabitacion(habitacion);
            System.out.println("-------------------------------------------------");
        }
        System.out.println("¡Habitaciones agregadas!");
        hotel.mostrarHabitaciones();
        System.out.println();
    }

    //Método que muestra el menú de la aplicacion.
    public static void Menu(){
        System.out.println("-----------BIENVENIDO-----------");
        System.out.println("1. Crear un cliente.");
        System.out.println("2. Crear reservación para cliente.");
        System.out.println("3. Crear habitación");
        System.out.println("4. Mostrar reservaciones");
        System.out.println("5. Salir");
    }
}