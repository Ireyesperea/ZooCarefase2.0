package model;

import java.util.ArrayList;

public class Habitat {
   private String name;
   private EnvironmentType environment;
   private int maxCapacity;
   private ArrayList<Animal> myAnimals;

   public Habitat(String var1, EnvironmentType var2, double var3, int var5) {
      this.name = var1;
      this.environment = var2;
      this.maxCapacity = var5;
      this.myAnimals = new ArrayList<Animal>();
   }

   public boolean addAnimal(Animal var1) {
      return this.myAnimals.size() <= this.maxCapacity ? this.myAnimals.add(var1) : false;
   }

   public String getName() {
      return this.name;
   }

   public EnvironmentType getEnvironment() {
      return this.environment;
   }

   public String getAnimalList() {
      String var1 = "";

      for(int var2 = 0; var2 < this.myAnimals.size(); ++var2) {
         var1 = var1 + ((Animal)this.myAnimals.get(var2)).getName() + "\n";
      }

      return var1;
   }
}
