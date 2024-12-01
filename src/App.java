import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    //Planets
    static String[] planets = {"Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};
    static double[] distances = {69.0, 108.0, 228.0, 779.0, 1400.0, 2889.0, 4500.0}; // millions km/h
    static String[] descriptions = {
        "Es el planeta más pequeño del sistema solar y el más cercano al Sol.",
        "El brillo de Venus es debido a su cercanía con la Tierra.",
        "El cuarto planeta desde el Sol, conocido por su color rojo.",
        "El gigante gaseoso, es el planeta más grande del sistema solar.",
        "El elemento más llamativo son sus 7 anillos.",
        "Está compuesto por una mezcla de agua, amoníaco y metano.",
        "Es uno de los gigantes de hielo, con una atmósfera muy densa."
    };
     

    // Ships
    static String [] ships = {"Explorer", "Innovation", "Life"};
    static double[] speeds = {28000.0, 15000.0, 30000.0};
    
    //Selection storage
    static int selectedPlanetIndex = -1; //Se realiza el decremento para que la elección sea apartir de 1
    static int selectedShipIndex = -1;
    static int passengers = 0;

    static double fuelConsumptioRate = 0.5; // for hour in liters
    static double oxygenConsumptionRate = 0.2; // for passenger  for hour


    public static void main(String[] args) throws Exception {
       
        int opcion;
        boolean runProgram = true; 

        while (runProgram) {
            showMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    selectPlanet();
                    
                    break;
                case 2: 
                    selectShip();

                    break;
                case 3:
                    startSimulation();
                    break;
                case 4: 
                    System.out.println("Esperamos que haya sido de tu agrado el viaje. Finalizando viaje!");
                    runProgram = false;
                    break;

                default:
                    System.out.println("Opción incorrecta. Intentalo de nuevo!");
                    break; // revisar
            }

        }

    }

    //Display the main menu
    public static void showMenu(){
        System.out.println("\n---- Menú Principal----");
        System.out.println("1. Seleccionar planeta de destino");
        System.out.println("2. Seleccionar nave de viaje");
        System.out.println("3. Iniciar la simulación del viaje");
        System.out.println("4. Salir ");
        System.out.println("Por favor, elige una opción: ");

    }

    //Select destination planet
    public static void selectPlanet(){
        
        System.out.println("Selecciona el planeta: ");
 

        for (int i = 0; i < planets.length; i++) {
            System.out.println((i+1) + ". " + planets[i]);
        }

        System.out.print("Selecciona un planeta (1-" + planets.length + "): ");

        int planetOption = scanner.nextInt() - 1;  
        
        if (planetOption >= 0 && planetOption < planets.length) {
            selectedPlanetIndex = planetOption;
            System.out.println("Has seleccionado el planeta: " + planets[selectedPlanetIndex]);
            System.out.println("Distancia al planeta escogido: " + distances[selectedPlanetIndex] + " millones de km");
            System.out.println("Descripción del planeta: " + descriptions[selectedPlanetIndex]);
        } else {
            System.out.println("Opción incorrecta. Digitalo nuevamente.");

        }

    }

    //Ship selection
    public static void selectShip(){
        System.out.println("\n --- Selección de nave ---" );
      

        for (int i = 0; i < ships.length; i++) {
            System.out.println((i + 1) + ". " + ships[i] + " (Velocidad: " + speeds[i] + " km/h)");
        }

        System.out.println("Selecciona una nave (1-" + ships.length + "): ");
        int shipOption = scanner.nextInt() -1;

        if (shipOption >= 0 && shipOption < ships.length) {
            selectedShipIndex = shipOption;
            System.out.println("Has seleccionado la nave: " + ships[selectedShipIndex]);
            System.out.println("Digita el número de pasajeros: ");
            passengers = scanner.nextInt();

            if (passengers <= 0) {
                System.out.println("Opción no valida, los numeros deben ser positivos. Digita nuevamente tu opción");
                passengers = 0;
                
            } else {
                System.out.println("Los pasajeros asignados para este viaje son: " + passengers);

            } 

            }else {
                System.out.println("Opción no valida. Digitala nuevamente.");
        }


    }

    public static void startSimulation(){

        if (selectedPlanetIndex == -1 || selectedShipIndex == -1) {
            System.out.println("Para iniciar el viaje debes seleccionar un planeta y una nave.");
            return;
        }

        //Data conversions
        double distance = distances[selectedPlanetIndex] * 1_000_000; // Convertir a kilómetros
        double speed = speeds[selectedShipIndex]; // Velocidad en km/h
        double travelTime = distance / speed / 24; // Tiempo en días

        System.out.println("\nIniciando viaje a " + planets[selectedPlanetIndex]);
        System.out.println("La distancia al destino es de: " + distances[selectedPlanetIndex] + " millones de km");
        System.out.println("Descripción del planeta destino: " + descriptions[selectedPlanetIndex]);
        System.out.println("El tiempo estimado para este viaje es: " + travelTime + " días");

        //Simulation of travel progress
        simulateProgress(travelTime);


    }

    //Fuel consumption
    public static double calculateFuel(double travelTime) {
        return fuelConsumptioRate * travelTime * 24; 
    }

    //Oxygen consumption
    public static double calculateOxygen (double travelTime) {
        return oxygenConsumptionRate * passengers * travelTime * 24; 
    }

    //Simulation of travel progress
    public static void simulateProgress(double travelTime) {
        double progress = 0;
        Random random = new Random();

        while (progress < 100) {
            try {
            Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Random event: Meteor shower con el 10% de probabilidad
            if (random.nextInt(10) == 0) {
                System.out.println("¡Atención! Se acerca una lluvia de meteoritos. ¡Evadela! ");
            }

            progress += 10;
            System.out.println("El progreso del viaje es: " + (int) progress + "%");

            if (progress == 50) {
                System.out.println("Vamos en el " + (int) progress + "% del viaje hacia " + planets[selectedPlanetIndex] + "...");
            }

            if (progress == 100) {
                System.out.println("\n ¡Hemos llegado al planeta " + planets[selectedPlanetIndex] + " exitosamente!");
            }

            
        }
    }

    public static void calculateResources(){

    }

    
}
