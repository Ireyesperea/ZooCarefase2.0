package MVC.src.ui;
import java.util.Scanner;

public class ZooCareMain{
    
    private static final String Myzoo = null;
    private static MVC.src.model.Zoo myZoo = null;
    private static Scanner reader = new Scanner(System.in);
    public static void main(String [] args){

        menu();
    }

    public static void menu(){
        
        int option = 0;
        do {
            System.out.println("Bienvenido a Zoocare");
            System.out.println("1. Registrar información general del zoologico");
            System.out.println("2. Mostrar informacion");
            System.out.println("0. Salir");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    registerGeneralInformation();
                    break;

                case 2:
                    showGeneralInformation();
            
                default:
                    break;
            }

        
        } while (option != 0);
    }

    public static void registerGeneralInformation(){
        reader.nextLine();
        
        System.out.println("Digite el nombre del zoologico");
        String name = reader.nextLine();

        System.out.println("Digite la ciudad del zoologico");
        String city = reader.nextLine();

        System.out.println("Digite el presupuesto del zoologico");
        double budget = reader.nextDouble();

        myZoo = new MVC.src.model.Zoo(name, city, budget);
    }

    public static void showGeneralInformation(){

        if(myZoo == null){

            System.out.println("Registre primero un zoologico");
        
        }else{
            System.out.println("La informacion del zoologico es:");
            System.out.println(myZoo.showGeneralImformation());

        }
    }


//*
/*gestionar la imformacion general del zoologico
 */

public static void regitrerAnimall(){

    if (Myzoo != null){

        String name;
        double weight;
        String dietType;
        String lifeSTage;
        String healthStatus;
    }else{
        System.out.println("Error! No hay habitats disponibles");

    }
}else{
    System.out.println("Error! Zoologico aun no registrado");
}

}


