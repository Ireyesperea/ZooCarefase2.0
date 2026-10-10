// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).

   package model;


import java.time.LocalDate;

public class Animal {
   private final String code;
   private String name;
   private String species;
   private String sex;
   private int birthYear;
   private double weight;
   private DietType diet;
   private EnvironmentType requiredEnvironment;
   private String originCountry;
   private LocalDate entryDate;
   private LifeStage lifeStage;
   private HealthStatus health;
   private Habitat habitat;
   private boolean active;
   private LocalDate retirementDate;
   private RetirementReason retirementReason;

   public Animal(String var1, String var2, String var3, String var4, int var5, double var6, DietType var8, EnvironmentType var9, String var10, LocalDate var11, LifeStage var12, HealthStatus var13) {
      this.code = var1;
      this.name = var2;
      this.species = var3;
      this.sex = var4;
      this.birthYear = var5;
      this.weight = var6;
      this.diet = var8;
      this.requiredEnvironment = var9;
      this.originCountry = var10;
      this.entryDate = var11;
      this.lifeStage = var12;
      this.health = var13;
      this.active = true;
   }

   public String getCode() {
      return this.code;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public String getSpecies() {
      return this.species;
   }

   public void setSpecies(String var1) {
      this.species = var1;
   }

   public String getSex() {
      return this.sex;
   }

   public void setSex(String var1) {
      this.sex = var1;
   }

   public int getBirthYear() {
      return this.birthYear;
   }

   public double getWeight() {
      return this.weight;
   }

   public void setWeight(double var1) {
      this.weight = var1;
   }

   public DietType getDiet() {
      return this.diet;
   }

   public void setDiet(DietType var1) {
      this.diet = var1;
   }

   public EnvironmentType getRequiredEnvironment() {
      return this.requiredEnvironment;
   }

   public void setRequiredEnvironment(EnvironmentType var1) {
      this.requiredEnvironment = var1;
   }

   public LifeStage getLifeStage() {
      return this.lifeStage;
   }

   public void setLifeStage(LifeStage var1) {
      this.lifeStage = var1;
   }

   public HealthStatus getHealth() {
      return this.health;
   }

   public void setHealth(HealthStatus var1) {
      this.health = var1;
   }

   public Habitat getHabitat() {
      return this.habitat;
   }

   public void setHabitat(Habitat var1) {
      this.habitat = var1;
   }

   public boolean isActive() {
      return this.active;
   }

   public void retire(LocalDate var1, RetirementReason var2) {
      this.active = false;
      this.retirementDate = var1;
      this.retirementReason = var2;
   }

   public double calculateDailyRation() {
      double var1 = this.weight * this.diet.getRationFactor();
      double var3 = (double)0.0F;
      if (this.lifeStage == LifeStage.JUVENIL) {
         var3 = 0.2;
      }

      if ((this.health == HealthStatus.QUARANTINE || this.health == HealthStatus.RECOVERY) && var3 < 0.15) {
         var3 = 0.15;
      }

      if (this.health == HealthStatus.UNDER_OBSERVATION && var3 < 0.1) {
         var3 = 0.1;
      }

      return var1 * ((double)1.0F + var3);
   }

   public double calculateMonthlyFeedingCost() {
      return this.calculateDailyRation() * this.diet.getCostPerKg() * (double)30.0F;
   }

   public String getDetails() {
      String var10000 = this.code;
      String var1 = "Code: " + var10000 + "\nName: " + this.name + "\nSpecies: " + this.species + "\nSex: " + this.sex + "\nBirth year: " + this.birthYear + "\nWeight: " + this.weight + " kg\nDiet: " + String.valueOf(this.diet) + "\nRequired environment: " + String.valueOf(this.requiredEnvironment) + "\nOrigin country: " + this.originCountry + "\nEntry date: " + String.valueOf(this.entryDate) + "\nLife stage: " + String.valueOf(this.lifeStage) + "\nHealth: " + String.valueOf(this.health) + "\nRegistration: " + (this.active ? "Active" : "Retired");
      if (this.habitat != null) {
         var1 = var1 + "\nHabitat: " + this.habitat.getName() + " (" + this.habitat.getCode() + ")";
      } else {
         var1 = var1 + "\nHabitat: none";
      }

      if (!this.active) {
         var1 = var1 + "\nRetirement date: " + String.valueOf(this.retirementDate) + "\nRetirement reason: " + String.valueOf(this.retirementReason);
      }

      return var1;
   }
}
