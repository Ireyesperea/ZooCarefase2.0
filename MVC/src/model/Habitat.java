// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package model;

public class Habitat {
   private String name;
   private String environment;
   private Animal[] myAnimals;

   public Habitat(String var1, String var2, double var3) {
      this.name = var1;
      this.environment = var2;
      this.myAnimals = new Animal[10];
   }

   public boolean addAnimal(Animal var1) {
      for(int var2 = 0; var2 < this.myAnimals.length; ++var2) {
         if (this.myAnimals[var2] == null) {
            this.myAnimals[var2] = var1;
            return true;
         }
      }

      return false;
   }

   public String getName() {
      return this.name;
   }

   public String getEnvironment() {
      return this.environment;
   }

   public String getAnimalList() {
      String var1 = "";

      for(int var2 = 0; var2 < this.myAnimals.length; ++var2) {
         if (this.myAnimals[var2] != null) {
            var1 = var1 + this.myAnimals[var2].getName() + "\n";
         }
      }

      return var1;
   }

   public boolean hasAnimal(String var1) {
      for(int var2 = 0; var2 < this.myAnimals.length; ++var2) {
         if (this.myAnimals[var2] != null && this.myAnimals[var2].getName1().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public double getAnimalMonthlyFoodCost(String var1) {
      for(int var2 = 0; var2 < this.myAnimals.length; ++var2) {
         if (this.myAnimals[var2] != null && this.myAnimals[var2].getName().equals(var1)) {
            return this.myAnimals[var2].calculateMonthlyRationCost();
         }
      }

      return (double)0.0F;
   }
}
