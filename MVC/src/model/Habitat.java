package model;

import java.util.ArrayList;

public class Habitat {
   private final String code;
   private String name;
   private EnvironmentType environment;
   private double temperature;
   private double area;
   private double monthlyBudget;
   private int capacity;
   private HabitatStatus status;
   private ArrayList<Employee> staff;
   private ArrayList<Animal> animals;

   public Habitat(String code, String name, EnvironmentType environment,
                 double temperature, double area, double monthlyBudget, int capacity, HabitatStatus status) {
      this.code = code;
      this.name = name;
      this.environment = environment;
      this.temperature = temperature;
      this.area = area;
      this.monthlyBudget = monthlyBudget;
      this.capacity = capacity;
      this.status = status;
      this.staff = new ArrayList<>();
      this.animals = new ArrayList<>();
   }

   public String getCode() {
      return this.code;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public EnvironmentType getEnvironment() {
      return this.environment;
   }

   public void setEnvironment(EnvironmentType environment) {
      this.environment = environment;
   }

   public double getTemperature() {
      return this.temperature;
   }

   public void setTemperature(double temperature) {
      this.temperature = temperature;
   }

   public double getArea() {
      return this.area;
   }

   public void setArea(double area) {
      this.area = area;
   }

   public double getMonthlyBudget() {
      return this.monthlyBudget;
   }

   public void setMonthlyBudget(double monthlyBudget) {
      this.monthlyBudget = monthlyBudget;
   }

   public int getCapacity() {
      return this.capacity;
   }

   public void setCapacity(int capacity) {
      this.capacity = capacity;
   }

   public HabitatStatus getStatus() {
      return this.status;
   }

   public void setStatus(HabitatStatus status) {
      this.status = status;
   }

   public ArrayList<Employee> getStaff() {
      return this.staff;
   }

   public void setStaff(ArrayList<Employee> staff) {
      this.staff = staff;
   }

   public ArrayList<Animal> getAnimals() {
      return this.animals;
   }

   public int getOccupancy() {
      return this.animals.size();
   }

   public double getOccupancyPercentage() {
      if (this.capacity <= 0) {
         return 0.0;
      }
      return (double) this.animals.size() * 100.0 / (double) this.capacity;
   }

   public boolean isOccupancyAlert() {
      return this.getOccupancyPercentage() >= 90.0;
   }

   public boolean hasFreeSpace() {
      return this.animals.size() < this.capacity;
   }

   public boolean hasStaffMember(Employee employee) {
      return this.staff != null && this.staff.contains(employee);
   }

   public boolean isCompatibleWith(Animal animal) {
      if (this.environment == EnvironmentType.MEDICAL) {
         return true;
      }
      return animal != null && this.environment == animal.getRequiredEnvironment();
   }

   public boolean addAnimal(Animal animal) {
      if (animal == null || this.animals.contains(animal)) {
         return false;
      }
      this.animals.add(animal);
      animal.setHabitat(this);
      return true;
   }

   public void removeAnimal(Animal animal) {
      if (animal == null) {
         return;
      }
      this.animals.remove(animal);
      animal.setHabitat(null);
   }

   public String getDetails() {
      String details = "Code: " + this.code + "\nName: " + this.name + "\nEnvironment: " + String.valueOf(this.environment)
            + "\nTemperature: " + this.temperature + " C\nArea: " + this.area + " m2\nMonthly budget: "
            + String.format("%,.0f", this.monthlyBudget) + " COP\nCapacity: " + this.capacity + "\nStatus: "
            + String.valueOf(this.status) + "\nOccupancy: " + this.getOccupancy() + "/" + this.capacity
            + " (" + String.format("%.1f", this.getOccupancyPercentage()) + "%)\nResponsible staff: ";

      if (this.staff.isEmpty()) {
         details += "none";
      } else {
         for (int i = 0; i < this.staff.size(); i++) {
            details += this.staff.get(i).getFullName() + " (" + this.staff.get(i).getClass() + ")";
            if (i < this.staff.size() - 1) {
               details += ", ";
            }
         }
      }

      return details;
   }

   public String getAnimalList() {
    
    throw new UnsupportedOperationException("Unimplemented method 'getAnimalList'");
   }
}
