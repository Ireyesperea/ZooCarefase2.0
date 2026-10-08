package ui;

import java.util.Scanner;
import model.ZooController;

public class ZooCareMain {
   private Scanner scanner;
   private ZooController controller;

   public ZooCareMain() {
      this.scanner = new Scanner(System.in);
      this.controller = new ZooController();
   }

   public static void main(String[] var0) {
      ZooCareMain var1 = new ZooCareMain();
      var1.showMainMenu();
   }

   private String readText(String var1) {
      String var2 = "";

      while(var2.trim().isEmpty()) {
         System.out.print(var1);
         var2 = this.scanner.nextLine();
         if (var2.trim().isEmpty()) {
            System.out.println("The value cannot be empty.");
         }
      }

      return var2.trim();
   }

   private int readInt(String var1) {
      while(true) {
         System.out.print(var1);

         try {
            return Integer.parseInt(this.scanner.nextLine().trim());
         } catch (NumberFormatException var3) {
            System.out.println("Por favor, ingrese un numero entero");
         }
      }
   }

   private double readDouble(String var1) {
      while(true) {
         System.out.print(var1);

         try {
            return Double.parseDouble(this.scanner.nextLine().trim());
         } catch (NumberFormatException var3) {
            System.out.println("Por favor, ingrese un numero decimal (use a dot for decimals).");
         }
      }
   }

   public void showMainMenu() {
      int var1 = -1;

      while(var1 != 0) {
         System.out.println("          MENU               ");
         System.out.println("1. imformacion del zoo");
         System.out.println("2. Empleados");
         System.out.println("3. Habitats");
         System.out.println("4. Animales");
         System.out.println("5. Costos de alimentacion");
         System.out.println("0. Salir");
         var1 = this.readInt("Elige una opcion: ");
         switch (var1) {
            case 0:
               System.out.println("Adios!");
               break;
            case 1:
               this.zooMenu();
               break;
            case 2:
               this.staffMenu();
               break;
            case 3:
               this.habitatMenu();
               break;
            case 4:
               this.animalMenu();
               break;
            case 5:
               this.feedingMenu();
               break;
            default:
               System.out.println("Invalid option.");
         }
      }

   }

   private void zooMenu() {
      System.out.println("---- Imformacion del zoo ---");
      System.out.println("1. Register / replace information");
      System.out.println("2. View information");
      System.out.println("3. Update monthly budget");
      int var1 = this.readInt("Choose an option: ");
      if (var1 == 1) {
         String var2 = this.readText("Zoo name: ");
         String var3 = this.readText("City: ");
         String var4 = this.readText("Address: ");
         String var5 = this.readText("Legal representative ID: ");
         String var6 = this.readText("Legal representative full name: ");
         double var7 = this.readDouble("Monthly budget (COP): ");
         System.out.println(this.controller.registerZooInfo(var2, var3, var4, var5, var6, var7));
      } else if (var1 == 2) {
         System.out.println(this.controller.getZooInfo());
      } else if (var1 == 3) {
         double var9 = this.readDouble("New monthly budget (COP): ");
         System.out.println(this.controller.updateZooBudget(var9));
      } else {
         System.out.println("Invalid option.");
      }

   }

   private void staffMenu() {
      System.out.println("\n--- Empleados ---");
      System.out.println("1. Registrar empleado");
      System.out.println("2. Buscar empleado por código");
      System.out.println("3. Modificar empleado");
      System.out.println("4. Lista de empleados activos");
      int var1 = this.readInt("elige una opcion: ");
      if (var1 == 1) {
         String var2 = this.readText("Full name: ");
         String var3 = this.readText("Phone: ");
         String var4 = this.readText("Email: ");
         int var5 = this.readInt("Role (1. Keeper, 2. Veterinarian): ");
         System.out.println(this.controller.registerEmployee(var2, var3, var4, var5));
      } else if (var1 == 2) {
         System.out.println(this.controller.findEmployee(this.readText("Employee code: ")));
      } else if (var1 == 3) {
         String var6 = this.readText("Employee code: ");
         System.out.println("Field: 1. Name, 2. Phone, 3. Email, 4. Role (1 keeper, 2 vet), 5. Status (1 active, 2 inactive)");
         int var7 = this.readInt("Field to change: ");
         String var8 = this.readText("New value: ");
         System.out.println(this.controller.updateEmployee(var6, var7, var8));
      } else if (var1 == 4) {
         System.out.println(this.controller.listActiveEmployees());
      } else {
         System.out.println("Invalid option.");
      }

   }

   private void habitatMenu() {
      System.out.println("\n--- Habitats ---");
      System.out.println("1. registrar habitat");
      System.out.println("2. Find habitat by code");
      System.out.println("3. Modificar habitat");
      System.out.println("4. Lista de habitats");
      System.out.println("5. ocupacion de habitats");
      int var1 = this.readInt("elige una opcion: ");
      if (var1 == 1) {
         String var2 = this.readText("Name: ");
         int var3 = this.readInt("Environment (1. Terrestrial, 2. Aquatic, 3. Aviary, 4. Medical): ");
         double var4 = this.readDouble("Temperature (C): ");
         double var6 = this.readDouble("Area (m2): ");
         double var8 = this.readDouble("Monthly budget (COP): ");
         int var10 = this.readInt("Maximum capacity: ");
         int var11 = this.readInt("Status (1. Active, 2. Under maintenance, 3. Under construction): ");
         System.out.print("Responsible employee codes separated by commas (empty for none): ");
         String var12 = this.scanner.nextLine();
         System.out.println(this.controller.registerHabitat(var2, var3, var4, var6, var8, var10, var11, var12));
      } else if (var1 == 2) {
         System.out.println(this.controller.findHabitat(this.readText("Habitat code: ")));
      } else if (var1 == 3) {
         String var13 = this.readText("Habitat code: ");
         System.out.println("Field: 1. Name, 2. Environment, 3. Temperature, 4. Area, 5. Budget, 6. Capacity, 7. Status, 8. Staff");
         System.out.println("(environment: 1 terrestrial, 2 aquatic, 3 aviary, 4 medical; status: 1 active, 2 maintenance, 3 construction, 4 retired)");
         int var14 = this.readInt("Field to change: ");
         System.out.print("New value: ");
         String var15 = this.scanner.nextLine();
         System.out.println(this.controller.updateHabitat(var13, var14, var15));
      } else if (var1 == 4) {
         System.out.println(this.controller.listHabitats());
      } else if (var1 == 5) {
         System.out.println(this.controller.getHabitatOccupancy(this.readText("Habitat code: ")));
      } else {
         System.out.println("Invalid option.");
      }

   }

   private void animalMenu() {
      System.out.println("\n--- Animales ---");
      System.out.println("1. Registarar animales");
      System.out.println("2. Buscar animal por codigo");
      System.out.println("3. Modificar animal");
      System.out.println("4. Transferir animal");
      System.out.println("5. Retire animal");
      System.out.println("6. Lista activa de animales");
      int var1 = this.readInt("elige una opcion: ");
      if (var1 == 1) {
         String var2 = this.readText("Name: ");
         String var3 = this.readText("Species: ");
         String var4 = this.readText("Sex: ");
         int var5 = this.readInt("Birth year: ");
         double var6 = this.readDouble("Weight (kg): ");
         int var8 = this.readInt("Diet (1. Herbivore, 2. Carnivore, 3. Omnivore, 4. Insectivore): ");
         int var9 = this.readInt("Required environment (1. Terrestrial, 2. Aquatic, 3. Aviary): ");
         String var10 = this.readText("Origin country: ");
         String var11 = this.readText("Entry date (yyyy-MM-dd): ");
         int var12 = this.readInt("Life stage (1. Juvenile, 2. Adult): ");
         int var13 = this.readInt("Health (1. Healthy, 2. Quarantine, 3. Recovery, 4. Under observation): ");
         String var14 = this.readText("Habitat code: ");
         System.out.println(this.controller.registerAnimal(var2, var3, var4, var5, var6, var8, var9, var10, var11, var12, var13, var14));
      } else if (var1 == 2) {
         System.out.println(this.controller.findAnimal(this.readText("Animal code: ")));
      } else if (var1 == 3) {
         String var15 = this.readText("Animal code: ");
         System.out.println("Field: 1. Name, 2. Species, 3. Sex, 4. Weight, 5. Diet, 6. Required environment, 7. Life stage, 8. Health");
         int var18 = this.readInt("Field to change: ");
         String var21 = this.readText("New value (options use the same numbers as the registration): ");
         System.out.println(this.controller.updateAnimal(var15, var18, var21));
      } else if (var1 == 4) {
         String var16 = this.readText("Animal code: ");
         String var19 = this.readText("Destination habitat code: ");
         System.out.println(this.controller.transferAnimal(var16, var19));
      } else if (var1 == 5) {
         String var17 = this.readText("Animal code: ");
         int var20 = this.readInt("Reason (1. Death, 2. Transferred to another zoo): ");
         System.out.println(this.controller.retireAnimal(var17, var20));
      } else if (var1 == 6) {
         System.out.println(this.controller.listActiveAnimals());
      } else {
         System.out.println("Invalid option.");
      }

   }

   private void feedingMenu() {
      System.out.println("\n--- Costos de alimentacion ---");
      System.out.println("1. Cost of an animal");
      System.out.println("2. Cost of a habitat");
      System.out.println("3. Cost of the whole zoo");
      int var1 = this.readInt("Choose an option: ");
      if (var1 == 1) {
         System.out.println(this.controller.calculateAnimalFeeding(this.readText("Animal code: ")));
      } else if (var1 == 2) {
         System.out.println(this.controller.calculateHabitatFeeding(this.readText("Habitat code: ")));
      } else if (var1 == 3) {
         System.out.println(this.controller.calculateZooFeeding());
      } else {
         System.out.println("Invalid option.");
      }

   }
}

       