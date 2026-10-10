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
            System.out.println("The value cannot empty.");
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
            System.out.println("Por favor, ingrese un numero decimal (use a decimals).");
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
      System.out.println("1. Registro de imformacion");
      System.out.println("2. Ver imformacion");
      System.out.println("3. Actrulizar costo mensual");
      int var1 = this.readInt("Elige una opcion: ");
      if (var1 == 1) {
         String var2 = this.readText("Nombre Zoo: ");
         String var3 = this.readText("Ciudad: ");
         String var4 = this.readText("Direccion: ");
         String var5 = this.readText("Representante legal ID: ");
         String var6 = this.readText("Nombre completo del representante legal: ");
         double var7 = this.readDouble("Presupuesto mensual (COP): ");
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
         String var2 = this.readText("Apellido: ");
         String var3 = this.readText("Celular: ");
         String var4 = this.readText("Email: ");
         int var5 = this.readInt("Role (1. personal, 2. Veterinario): ");
         System.out.println(this.controller.registerEmployee(var2, var3, var4, var5));
      } else if (var1 == 2) {
         System.out.println(this.controller.findEmployee(this.readText("Codigo Empleado: ")));
      } else if (var1 == 3) {
         String var6 = this.readText("Codigo Empleado: ");
         System.out.println("Field: 1. Nombre, 2. Telefono, 3. Email, 4. Rol (1 cuidador, 2 veterinario), 5. Estado (1 activo, 2 inactivo)");
         int var7 = this.readInt("Campo a cambiar: ");
         String var8 = this.readText("Nuevo valor: ");
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
         String var2 = this.readText("Nombre: ");
         int var3 = this.readInt("Ambiente(1. Terrestre, 2. Acuatico, 3. Avirio, 4. Medico): ");
         double var4 = this.readDouble("Temperatura (C): ");
         double var6 = this.readDouble("Area (m2): ");
         double var8 = this.readDouble("Costo Mensual (COP): ");
         int var10 = this.readInt("Capacidad Maxima: ");
         int var11 = this.readInt("Estado (1. Activo, 2. En mantenimiento, 3. En construcción): ");
         System.out.print("Responsible employee codes separated by commas (empty for none): ");
         String var12 = this.scanner.nextLine();
         System.out.println(this.controller.registerHabitat(var2, var3, var4, var6, var8, var10, var11, var12));
      } else if (var1 == 2) {
         System.out.println(this.controller.findHabitat(this.readText("Codigo Habitat: ")));
      } else if (var1 == 3) {
         String var13 = this.readText("Codigo Habitat: ");
         System.out.println("Field: 1. Nombre, 2. ambiente, 3. Temperatura, 4. Area, 5. Costo, 6. Capaciad, 7. Estado, 8. Personal");
         System.out.println("(environment: 1 terrestrial, 2 acuatico, 3 aviario, 4 medico; Estado: 1 Activo, 2 Mantenimiento, 3 Construccion, 4 retirado)");
         int var14 = this.readInt("Campo a modificar: ");
         System.out.print("Nuevo valor: ");
         String var15 = this.scanner.nextLine();
         System.out.println(this.controller.updateHabitat(var13, var14, var15));
      } else if (var1 == 4) {
         System.out.println(this.controller.listHabitats());
      } else if (var1 == 5) {
         System.out.println(this.controller.getHabitatOccupancy(this.readText("Codigo Habitat: ")));
      } else {
         System.out.println("Invalid option.");
      }

   }

   private void animalMenu() {
      System.out.println("\n--- Animales ---");
      System.out.println("1. Registrar animales");
      System.out.println("2. Buscar animal por codigo");
      System.out.println("3. Modificar animal");
      System.out.println("4. Transferir animal");
      System.out.println("5. Retire animal");
      System.out.println("6. Lista activa de animales");
      int var1 = this.readInt("elige una opcion: ");
      if (var1 == 1) {
         String var2 = this.readText("Nombre: ");
         String var3 = this.readText("Especie: ");
         String var4 = this.readText("Sexo: ");
         int var5 = this.readInt("Fecha de nacimiento: ");
         double var6 = this.readDouble("Peso (kg): ");
         int var8 = this.readInt("Dieta (1. Herbivoro, 2. Carnivoro, 3. Omnivoro, 4. Insectivoro): ");
         int var9 = this.readInt("Entorno requerido (1. Terrestre, 2. Acuatico, 3. Aviario): ");
         String var10 = this.readText("Origen: ");
         String var11 = this.readText("Fecha (yyyy-MM-dd): ");
         int var12 = this.readInt("Etapa de vida (1. Juvenil, 2. Adulto): ");
         int var13 = this.readInt("Salud (1. Saludable, 2. En cuarentena, 3. En recuperacion, 4. Bajo observacion): ");
         String var14 = this.readText("Codigo Habitat: ");
         System.out.println(this.controller.registerAnimal(var2, var3, var4, var5, var6, var8, var9, var10, var11, var12, var13, var14));
      } else if (var1 == 2) {
         System.out.println(this.controller.findAnimal(this.readText("Codigo Animal: ")));
      } else if (var1 == 3) {
         String var15 = this.readText("Codigo Animal: ");
         System.out.println("Field: 1. Nombre, 2. Especie, 3. Sexo, 4. Peso, 5. Dieta, 6. Entorno requerido, 7. Etapa de vida, 8. Salud");
         int var18 = this.readInt("Campo a cambiar: ");
         String var21 = this.readText("Nuevo valor (las opciones usan los mismos números que el registro): ");
         System.out.println(this.controller.updateAnimal(var15, var18, var21));
      } else if (var1 == 4) {
         String var16 = this.readText("Codigo Animal ");
         String var19 = this.readText("Codigo Habitat de destino: ");
         System.out.println(this.controller.transferAnimal(var16, var19));
      } else if (var1 == 5) {
         String var17 = this.readText("Codigo Animal: ");
         int var20 = this.readInt("Razon (1. Muerte, 2. Transferir a otro zoo): ");
         System.out.println(this.controller.retireAnimal(var17, var20));
      } else if (var1 == 6) {
         System.out.println(this.controller.listActiveAnimals());
      } else {
         System.out.println("Invalid option.");
      }

   }

   private void feedingMenu() {
      System.out.println("\n--- Costos de alimentacion ---");
      System.out.println("1. Costo de un animal");
      System.out.println("2. Costo de un hábitat");
      System.out.println("3. Costo del zoológico completo");
      int var1 = this.readInt("elige una oopcioon: ");
      if (var1 == 1) {
         System.out.println(this.controller.calculateHabitatFeeding(this.readText("Codigo Animal: ")));
      } else if (var1 == 2) {
         System.out.println(this.controller.calculateHabitatFeeding(this.readText("Codigo Habitat: ")));
      } else if (var1 == 3) {
         System.out.println(this.controller.calculateZooFeeding());
      } else {
         System.out.println("Invalid ooptioon.");
      }

   }
}

       