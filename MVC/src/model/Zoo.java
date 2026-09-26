package model;

public class Zoo {
   private String name;
   private String city;
   private String address;
   private double budget;
   private Habitat[] myHabitats;

   public Zoo(String var1, String var2, String var3, double var4) {
      this.name = var1;
      this.city = var2;
      this.address = var3;
      this.budget = var4;
      this.myHabitats = new Habitat[33];
   }

   public String getInformation() {
      return this.name + "-" + this.city + "-" + this.address + "-" + this.budget;
   }

   public boolean addHabitat(String var1, String var2, double var3) {
      if (this.myHabitats != null) {
         for(int var5 = 0; var5 < this.myHabitats.length; ++var5) {
            if (this.myHabitats[var5] == null) {
               this.myHabitats[var5] = new Habitat(var1, var2, var3);
               return true;
            }
         }
      }

      return false;
   }

   public boolean hasAvailableHabitat() {
      if (this.myHabitats != null) {
         for(int var1 = 0; var1 < this.myHabitats.length; ++var1) {
            if (this.myHabitats[var1] != null) {
               return true;
            }
         }
      }

      return false;
   }

   public String getHabitatList() {
      String var1 = "";
      if (this.myHabitats != null) {
         for(int var2 = 0; var2 < this.myHabitats.length; ++var2) {
            if (this.myHabitats[var2] != null) {
               var1 = var1 + "\n" + this.myHabitats[var2].getName() + "-" + this.myHabitats[var2].getEnvironment();
            }
         }
      }

      return var1;
   }

   public boolean addAnimalInHabitat(String var1, String var2, double var3, String var5, String var6, String var7) {
      if (this.myHabitats != null) {
         for(int var8 = 0; var8 < this.myHabitats.length; ++var8) {
            if (this.myHabitats[var8] != null && this.myHabitats[var8].getName().equals(var1)) {
               Animal var9 = new Animal(var2, var3, var5, var6, var7);
               return this.myHabitats[var8].addAnimal(var9);
            }
         }
      }

      return false;
   }

   public String getAllAnimalList() {
      String var1 = "";
      if (this.myHabitats != null) {
         for(int var2 = 0; var2 < this.myHabitats.length; ++var2) {
            if (this.myHabitats[var2] != null) {
               var1 = var1 + this.myHabitats[var2].getAnimalList() + "\n";
            }
         }
      }

      return var1;
   }

   public double getMonthlyFoodCostFromAnimal(String var1) {
      double var2 = (double)-1.0F;
      if (this.myHabitats != null) {
         for(int var4 = 0; var4 < this.myHabitats.length; ++var4) {
            if (this.myHabitats[var4] != null && this.myHabitats[var4].hasAnimal(var1)) {
               return this.myHabitats[var4].getAnimalMonthlyFoodCost(var1);
            }
         }
      }

      return var2;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setCity(String var1) {
      this.city = var1;
   }

   public void setAddress(String var1) {
      this.address = var1;
   }

   public void setBudget(double var1) {
      this.budget = var1;
   }
}
