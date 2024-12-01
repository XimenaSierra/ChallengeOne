import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String[] planets = {"Marte", "Jupiter", "Saturno"};
    static double[] distances = {54.0, 587.0, 1345.0};

    static String [] ships = {"Explorer", "Innovation", "Life"};
    static double[] speeds = {28000.0, 15000.0, 30000.0};
    

    public static void main(String[] args) throws Exception {
       
        int opcion;
        do{
            showMenu();
            opcion = scanner.nextInt();
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

                default:
                    break;
            }

        }while(opcion != 4)



    }

    public static void showMenu(){
        System.out.println("\n---- Menú Principal----");
        System.out.println("1. Seleccionar planeta de destino");
        System.out.println("2. Seleccionar nave de viaje");
        System.out.println("3. Iniciar la simulación del viaje");
        System.out.println("4. Salir ");
        System.out.println("Por favor, elige una opción: ");

    }

    public static void selectShip(){

    }

    public static void selectPlanet(){

    }
    public static void calculateResources(){

    }

    public static void startSimulation(){

    }


    //Métodos auxiliares
    public static void printPlanets(){

    }
}
