package ui;

import java.util.Scanner;
import model.ZooController;
/**
 * Console view of ZooCare. It reads the data, checks its format and shows the results.
 * It only talks to the controller using primitive types and Strings.
 */
public class ZooCareMain {
   private final Scanner scanner;
   private final ZooController controller;
/**
     * Creates the view with its controller.
     * <b>Pre:</b> none.<br>
     * <b>Post:</b> the controller already has the veterinary clinic.
     */
   public ZooCareMain() {
      this.scanner = new Scanner(System.in);
      this.controller = new ZooController();
   }

    /**
     * Starts the program.
     *
     * <b>Pre:</b> none.<br>
     * <b>Post:</b> the menu is repeated until the user chooses the exit option.
     *
     * @param args not used
     */
   public static void main(String[] args) {
      ZooCareMain main = new ZooCareMain();
      main.showMainMenu();
   }
//  input helpers
 
    /**
     * Reads a text that is not empty.
     *
     * <b>Pre:</b> the scanner is open.<br>
     * <b>Post:</b> the returned text is not empty and has no spaces at the ends.
     *
     * @param message the question shown to the user
     * @return the text typed by the user
     */
   private String readText(String prompt) {
      String value = "";
      while (value.trim().isEmpty()) {
         System.out.print(prompt);
         value = this.scanner.nextLine();
         if (value.trim().isEmpty()) {
            System.out.println("The value cannot be empty.");
         }
      }
      return value.trim();
   }

   private int readInt(String prompt) {
      while (true) {
         System.out.print(prompt);
         try {
            return Integer.parseInt(this.scanner.nextLine().trim());
         } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un numero entero");
         }
      }
   }

   private double readDouble(String prompt) {
      while (true) {
         System.out.print(prompt);
         try {
            return Double.parseDouble(this.scanner.nextLine().trim());
         } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un numero decimal (use a decimals).");
         }
      }
   }

   public void showMainMenu() {
      int option = -1;

      while (option != 0) {
         System.out.println("          MENU               ");
         System.out.println("1. imformacion del zoo");
         System.out.println("2. Empleados");
         System.out.println("3. Habitats");
         System.out.println("4. Animales");
         System.out.println("5. Costos de alimentacion");
         System.out.println("0. Salir");
         option = this.readInt("Elige una opcion: ");
         switch (option) {
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
      int option = this.readInt("Elige una opcion: ");
      if (option == 1) {
         String name = this.readText("Nombre Zoo: ");
         String city = this.readText("Ciudad: ");
         String address = this.readText("Direccion: ");
         String legalId = this.readText("Representante legal ID: ");
         String legalName = this.readText("Nombre completo del representante legal: ");
         double monthlyBudget = this.readDouble("Presupuesto mensual (COP): ");
         System.out.println(this.controller.registerZooInfo(name, city, address, legalId, legalName, monthlyBudget));
      } else if (option == 2) {
         System.out.println(this.controller.getZooInfo());
      } else if (option == 3) {
         double newBudget = this.readDouble("New monthly budget (COP): ");
         System.out.println(this.controller.updateZooBudget(newBudget));
      } else {
         System.out.println("Invalid option.");
      }
   }

   /**
     * Shows the staff menu.
     *
     * <b>Pre:</b> the controller has been created.<br>
     * <b>Post:</b> the chosen staff operation was done and its result was shown.
     */
   private void staffMenu() {
      System.out.println("\n--- Empleados ---");
      System.out.println("1. Registrar empleado");
      System.out.println("2. Buscar empleado por código");
      System.out.println("3. Modificar empleado");
      System.out.println("4. Lista de empleados activos");
      int option = this.readInt("elige una opcion: ");
      if (option == 1) {
         String lastname = this.readText("Apellido: ");
         String cellPhone = this.readText("Celular: ");
         String email = this.readText("Email: ");
         int role = this.readInt("Role (1. personal, 2. Veterinario): ");
         System.out.println(this.controller.registerEmployee(lastname, cellPhone, email, role));
      } else if (option == 2) {
         System.out.println(this.controller.findEmployee(this.readText("Codigo Empleado: ")));
      } else if (option == 3) {
         String employeeCode = this.readText("Codigo Empleado: ");
         System.out.println("Field: 1. Nombre, 2. Telefono, 3. Email, 4. Rol (1 cuidador, 2 veterinario), 5. Estado (1 activo, 2 inactivo)");
         int field = this.readInt("Campo a cambiar: ");
         String newValue = this.readText("Nuevo valor: ");
         System.out.println(this.controller.updateEmployee(employeeCode, field, newValue));
      } else if (option == 4) {
         System.out.println(this.controller.listActiveEmployees());
      } else {
         System.out.println("Invalid option.");
      }
   }
 /**
     * Shows the habitat menu.
     *
     * <b>Pre:</b> the controller has been created.<br>
     * <b>Post:</b> the chosen habitat operation was done and its result was shown.
     */
   private void habitatMenu() {
      System.out.println("\n--- Habitats ---");
      System.out.println("1. registrar habitat");
      System.out.println("2. Find habitat by code");
      System.out.println("3. Modificar habitat");
      System.out.println("4. Lista de habitats");
      System.out.println("5. ocupacion de habitats");
      int option = this.readInt("elige una opcion: ");
      if (option == 1) {
         String name = this.readText("Nombre: ");
         int environment = this.readInt("Ambiente(1. Terrestre, 2. Acuatico, 3. Avirio, 4. Medico): ");
         double temperature = this.readDouble("Temperatura (C): ");
         double area = this.readDouble("Area (m2): ");
         double monthlyCost = this.readDouble("Costo Mensual (COP): ");
         int capacity = this.readInt("Capacidad Maxima: ");
         int status = this.readInt("Estado (1. Activo, 2. En mantenimiento, 3. En construcción): ");
         System.out.print("Responsible employee codes separated by commas (empty for none): ");
         String employees = this.scanner.nextLine();
         System.out.println(this.controller.registerHabitat(name, environment, temperature, area, monthlyCost, capacity, status, employees));
      } else if (option == 2) {
         System.out.println(this.controller.findHabitat(this.readText("Codigo Habitat: ")));
      } else if (option == 3) {
         String habitatCode = this.readText("Codigo Habitat: ");
         System.out.println("Field: 1. Nombre, 2. ambiente, 3. Temperatura, 4. Area, 5. Costo, 6. Capaciad, 7. Estado, 8. Personal");
         System.out.println("(environment: 1 terrestrial, 2 acuatico, 3 aviario, 4 medico; Estado: 1 Activo, 2 Mantenimiento, 3 Construccion, 4 retirado)");
         int field = this.readInt("Campo a modificar: ");
         System.out.print("Nuevo valor: ");
         String newValue = this.scanner.nextLine();
         System.out.println(this.controller.updateHabitat(habitatCode, field, newValue));
      } else if (option == 4) {
         System.out.println(this.controller.listHabitats());
      } else if (option == 5) {
         System.out.println(this.controller.getHabitatOccupancy(this.readText("Codigo Habitat: ")));
      } else {
         System.out.println("Invalid option.");
      }
   }
/**
     * Shows the animal menu.
     *
     * <b>Pre:</b> the controller has been created.<br>
     * <b>Post:</b> the chosen animal operation was done and its result was shown.
     */
   private void animalMenu() {
      System.out.println("\n--- Animales ---");
      System.out.println("1. Registrar animales");
      System.out.println("2. Buscar animal por codigo");
      System.out.println("3. Modificar animal");
      System.out.println("4. Transferir animal");
      System.out.println("5. Retire animal");
      System.out.println("6. Lista activa de animales");
      int option = this.readInt("elige una opcion: ");
      if (option == 1) {
         String name = this.readText("Nombre: ");
         String species = this.readText("Especie: ");
         String sex = this.readText("Sexo: ");
         int birthDate = this.readInt("Fecha de nacimiento: ");
         double weight = this.readDouble("Peso (kg): ");
         int diet = this.readInt("Dieta (1. Herbivoro, 2. Carnivoro, 3. Omnivoro, 4. Insectivoro): ");
         int environment = this.readInt("Entorno requerido (1. Terrestre, 2. Acuatico, 3. Aviario): ");
         String origin = this.readText("Origen: ");
         String date = this.readText("Fecha (yyyy-MM-dd): ");
         int lifeStage = this.readInt("Etapa de vida (1. Juvenil, 2. Adulto): ");
         int health = this.readInt("Salud (1. Saludable, 2. En cuarentena, 3. En recuperacion, 4. Bajo observacion): ");
         String habitatCode = this.readText("Codigo Habitat: ");
         System.out.println(this.controller.registerAnimal(name, species, sex, birthDate, weight, diet, environment, origin, date, lifeStage, health, habitatCode));
      } else if (option == 2) {
         System.out.println(this.controller.findAnimal(this.readText("Codigo Animal: ")));
      } else if (option == 3) {
         String animalCode = this.readText("Codigo Animal: ");
         System.out.println("Field: 1. Nombre, 2. Especie, 3. Sexo, 4. Peso, 5. Dieta, 6. Entorno requerido, 7. Etapa de vida, 8. Salud");
         int field = this.readInt("Campo a cambiar: ");
         String newValue = this.readText("Nuevo valor (las opciones usan los mismos números que el registro): ");
         System.out.println(this.controller.updateAnimal(animalCode, field, newValue));
      } else if (option == 4) {
         String animalCode = this.readText("Codigo Animal ");
         String destination = this.readText("Codigo Habitat de destino: ");
         System.out.println(this.controller.transferAnimal(animalCode, destination));
      } else if (option == 5) {
         String animalCode = this.readText("Codigo Animal: ");
         int reason = this.readInt("Razon (1. Muerte, 2. Transferir a otro zoo): ");
         System.out.println(this.controller.retireAnimal(animalCode, reason));
      } else if (option == 6) {
         System.out.println(this.controller.listActiveAnimals());
      } else {
         System.out.println("Invalid option.");
      }
   }

     /**
     * Shows the feeding menu.
     *
     * <b>Pre:</b> the controller has been created.<br>
     * <b>Post:</b> the chosen feeding calculation was shown; no data is modified.
     */
   private void feedingMenu() {
      System.out.println("\n--- Costos de alimentacion ---");
      System.out.println("1. Costo de un animal");
      System.out.println("2. Costo de un hábitat");
      System.out.println("3. Costo del zoológico completo");
      int option = this.readInt("elige una oopcioon: ");
      if (option == 1) {
         System.out.println(this.controller.calculateHabitatFeeding(this.readText("Codigo Animal: ")));
      } else if (option == 2) {
         System.out.println(this.controller.calculateHabitatFeeding(this.readText("Codigo Habitat: ")));
      } else if (option == 3) {
         System.out.println(this.controller.calculateZooFeeding());
      } else {
         System.out.println("Invalid ooptioon.");
      }
   }
}
