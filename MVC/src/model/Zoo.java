package model;

import java.util.ArrayList;

public class Zoo {
   private String name;
   private String city;
   private String legalRepId;
   private String legalRepName;
   private double monthlyBudget;
   private boolean infoRegistered = false;
   private ArrayList<Employee> employees = new ArrayList<Employee>();
   private ArrayList<Habitat> habitats = new ArrayList<Habitat>();
   private ArrayList<Animal> animals = new ArrayList<Animal>();
   private int employeeCounter;
   private int habitatCounter;
   private int animalCounter;
   private String address;

   public Zoo(String var1, String var2, String var3, String var4, String var5, double var6) {
       this.name = var1;
      this.city = var2;
      this.address = var3;
      this.legalRepId = var4;
      this.legalRepName = var5;
      this.monthlyBudget = var6;
      this.infoRegistered = true;
   }

    public boolean isInfoRegistered() {
      return this.infoRegistered;
   }

   public double getMonthlyBudget() {
      return this.monthlyBudget;
   }

   public void setMonthlyBudget(double var1) {
      this.monthlyBudget = var1;
   }

   public String getInfoDetails() {
      String var10000 = this.name;
      return "Name: " + var10000 + "\nCity: " + this.city + "\nAddress: " + this.address + "\nLegal representative ID: " + this.legalRepId + "\nLegal representative: " + this.legalRepName + "\nMonthly budget: " + String.format("%,.0f", this.monthlyBudget) + " COP";
   }

   public ArrayList<Employee> getEmployees() {
      return this.employees;
   }

   public ArrayList<Habitat> getHabitats() {
      return this.habitats;
   }

   public ArrayList<Animal> getAnimals() {
      return this.animals;
   }

   public String generateEmployeeCode() {
      ++this.employeeCounter;
      return String.format("E%03d", this.employeeCounter);
   }

   public String generateHabitatCode() {
      ++this.habitatCounter;
      return String.format("H%02d", this.habitatCounter);
   }

   public String generateAnimalCode() {
      ++this.animalCounter;
      return String.format("A%03d", this.animalCounter);
   }

   public Employee findEmployee(String var1) {
      for(int var2 = 0; var2 < this.employees.size(); ++var2) {
         if (((Employee)this.employees.get(var2)).getCode().equalsIgnoreCase(var1)) {
            return (Employee)this.employees.get(var2);
         }
      }

      return null;
   }

   public Habitat findHabitat(String var1) {
      for(int var2 = 0; var2 < this.habitats.size(); ++var2) {
         if (((Habitat)this.habitats.get(var2)).getCode().equalsIgnoreCase(var1)) {
            return (Habitat)this.habitats.get(var2);
         }
      }

      return null;
   }

   public Animal findAnimal(String var1) {
      for(int var2 = 0; var2 < this.animals.size(); ++var2) {
         if (((Animal)this.animals.get(var2)).getCode().equalsIgnoreCase(var1)) {
            return (Animal)this.animals.get(var2);
         }
      }

      return null;
   }

   public void setName(String var1) {

	throw new UnsupportedOperationException("Unimplemented method 'setName'");
   }

   public void setCity(String var2) {
    
    throw new UnsupportedOperationException("Unimplemented method 'setCity'");
   }

   public char[] getInformation() {

    throw new UnsupportedOperationException("Unimplemented method 'getInformation'");
   }

   public char[] getEnvironmentTypeList() {

	throw new UnsupportedOperationException("Unimplemented method 'getEnvironmentTypeList'");
   }

   public boolean addHabitat(String var0, int var1, double var2, int var4) {
	
	throw new UnsupportedOperationException("Unimplemented method 'addHabitat'");
   }

   public boolean addAnimalInHabitat(String var6, String var0, double var1, String var3, String var4, String var5) {
	
	throw new UnsupportedOperationException("Unimplemented method 'addAnimalInHabitat'");
   }

   public boolean hasAvailableHabitat() {
	
	throw new UnsupportedOperationException("Unimplemented method 'hasAvailableHabitat'");
   }

   public char[] getAllAnimalList() {
	
	throw new UnsupportedOperationException("Unimplemented method 'getAllAnimalList'");
   }

   public void setInfo(String trim, String trim2, String trim3, String trim4, String trim5, double var6) {
    
    throw new UnsupportedOperationException("Unimplemented method 'setInfo'");
   }
}
