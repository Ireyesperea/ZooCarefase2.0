package ui;

import model.Zoo;
import model.Animal;
import model.Habitat;
import java.util.Scanner;
public class ZooCareMain {
   private static Scanner reader;
   private static Zoo myZoo;

   public ZooCareMain() {
   }

   public static void main(String[] var0) {
      menu();
   }

   public static void menu() {
      System.out.print("\u001b[H\u001b[2J");
      int var0 = 0;

      do {
         System.out.println("Bienvenido a ZooCare");
         System.out.println("1. Registrar informacion general del zoologico");
         System.out.println("2. Consultar informacion general del zoologico");
         System.out.println("3. Modificar informacion general del zoologico");
         System.out.println("4. Registrar habitat");
         System.out.println("5. Registrar animal");
         System.out.println("6. Mostrar lista de animales");
         System.out.println("7. Consultar el costo mensual de alimentacion de un animal");
         System.out.println("0. Salir");
         var0 = reader.nextInt();
         switch (var0) {
            case 0:
               System.out.println("Adios!");
               break;
            case 1:
               registerZooInformation();
               break;
            case 2:
               showZooInformation();
               break;
            case 3:
               modifyZooInformation();
               break;
            case 4:
               registerHabitat();
               break;
            case 5:
               registerAnimal();
               break;
            case 6:
               showAnimalsRegistered();
               break;
            case 7:
               showAnimalMonthlyFoodCost();
         }

         if (var0 != 0) {
            clearConsole();
         }
      } while(var0 != 0);

   }

   public static int clearConsole() {
      int var0;
      for(var0 = 0; var0 != 1; var0 = reader.nextInt()) {
         System.out.println("\nDesea volver al menu principal?");
         System.out.println("1. Si");
         System.out.println("2. No");
      }

      System.out.print("\u001b[H\u001b[2J");
      return var0;
   }

   @SuppressWarnings("hiding")
public static <myZoo> void registerZooInformation() {
      if (myZoo == null) {
         reader.nextLine();
         System.out.println("\nDigite el nombre del zoologico");
         String var0 = reader.nextLine();
         System.out.println("Digite la ciudad del zoologico");
         String var1 = reader.nextLine();
         System.out.println("Digite la direccion del zoologico");
         String var2 = reader.nextLine();
         System.out.println("Digite el presupuesto del zoologico");
         double var3 = reader.nextDouble();
         myZoo = new Zoo(var0, var1, var2, var3);
         System.out.println("Exito! Zoologico registrado exitosamente!");
      } else {
         System.out.println("Error! Ya existe un zoologico registrado");
      }

   }

   public static void showZooInformation() {
      if (myZoo != null) {
         System.out.println(((Object) myZoo).getInformation());
      } else {
         System.out.println("Error! Zoologico aun no registrado");
      }

   }

   public static void modifyZooInformation() {
      if (myZoo != null) {
         System.out.println("\nMenu de cambios de informacion general del Zoologico");
         System.out.println("1. Cambiar el nombre del Zoologico");
         System.out.println("2. Cambiar la ciudad del Zoologico");
         System.out.println("3. Cambiar la direcciÃ³n del Zoologico");
         System.out.println("4. Cambiar el presupuesto del Zoologico");
         int var0 = reader.nextInt();
         switch (var0) {
            case 1:
               reader.nextLine();
               System.out.print("\nPor favor ingresa el nuevo nombre del Zoologico: ");
               String var1 = reader.nextLine();
               System.out.println("Dato registrado correctamente");
               myZoo.setName(var1);
               break;
            case 2:
               reader.nextLine();
               System.out.print("\nPor favor ingresa la nueva ciudad del Zoologico: ");
               String var2 = reader.nextLine();
               System.out.println("Dato registrado correctamente");
               myZoo.setCity(var2);
               break;
            case 3:
               reader.nextLine();
               System.out.print("\nPor favor ingresa la nueva direccion del Zoologico: ");
               String var3 = reader.nextLine();
               System.out.println("Dato registrado correctamente");
               myZoo.setCity(var3);
               break;
            case 4:
               System.out.print("\nPor favor ingresa el nuevo presupuesto del Zoologico: ");
               double var4 = reader.nextDouble();
               System.out.println("Dato registrado correctamente");
               myZoo.setBudget(var4);
               break;
            default:
               System.out.print("\nDigite una opcion valida");
         }
      } else {
         System.out.println("Error! Zoologico aun no registrado");
      }

   }

   public static void registerHabitat() {
      if (myZoo != null) {
         reader.nextLine();
         System.out.println("\nDigite el nombre del habitat");
         String var0 = reader.nextLine();
         System.out.println("Digite el ambiente del habitat (acuatico, terrestre, etc.");
         String var1 = reader.nextLine();
         System.out.println("Digite el area del habitat");
         double var2 = reader.nextDouble();
         boolean var4 = myZoo.addHabitat(var0, var1, var2);
         if (var4) {
            System.out.println("Exito! Habitat registrado");
         } else {
            System.out.println("Error. Habitat no registrado");
         }
      } else {
         System.out.println("Error! Zoologico aun no registrado");
      }

   }

   public static void registerAnimal() {
      if (myZoo != null) {
         if (myZoo.hasAvailableHabitat()) {
            reader.nextLine();
            System.out.println("\nDigite el nombre del animal");
            String var0 = reader.nextLine();
            System.out.println("\nDigite el peso del animal");
            double var1 = reader.nextDouble();
            reader.nextLine();
            System.out.println("\nDigite el tipo de dieta del animal (herbivora, carnivora, omnivora, insectivora)");
            String var3 = reader.nextLine();
            System.out.println("\nDigite la etapa de vida del animal (juvenil o adulto)");
            String var4 = reader.nextLine();
            System.out.println("\nDigite el estado de salud del animal (saludable, cuarentena, recuperacion, en observacion)");
            String var5 = reader.nextLine();
            System.out.println("\nA continuacion se presenta el listado de habitats registrados:");
            System.out.println(myZoo.getHabitatList());
            System.out.println("\nDigite el nombre del habitat al que se registrara el animal");
            String var6 = reader.nextLine();
            boolean var7 = myZoo.addAnimalInHabitat(var6, var0, var1, var3, var4, var5);
            if (var7) {
               System.out.println("Animal registrado exitosamente");
            } else {
               System.out.println("Error! No se pudo registrar el animal");
            }
         } else {
            System.out.println("Error! Habitats aun no registrados");
         }
      } else {
         System.out.println("Error! Zoologico aun no registrado");
      }

   }

   @SuppressWarnings("hiding")
public static <myZoo> void showAnimalsRegistered() {
      if (myZoo != null) {
         System.out.println("Lista de animales registrados");
         System.out.println(myZoo.getAllAnimalList());
      } else {
         System.out.println("Error! Zoologico aun no registrado");
      }

   }

   @SuppressWarnings("hiding")
public static <myZoo> void showAnimalMonthlyFoodCost() {
      if (myZoo != null) {
         showAnimalsRegistered();
         reader.nextLine();
         System.out.println("\nDigite el nombre del animal a consultar su costo mensual de alimentaciÃ³n");
         String var0 = reader.nextLine();
         double var1 = ((Object) myZoo).getMonthlyFoodCostFromAnimal(var0);
         if (var1 >= (double)0.0F) {
            System.out.printf("\nEl costo mensual de alimentacion de " + var0 + " es: $ %.2f%n", var1);
         } else {
            System.out.println("Error! No se pudo calcular el costo mensual de alimentacion para el animal proporcionado");
         }
      } else {
         System.out.println("Error! Zoologico aun no registrado");
      }

   }

   static {
      reader = new Scanner(System.in);
   }
}
