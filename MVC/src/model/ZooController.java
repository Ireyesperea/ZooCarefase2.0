 package model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ZooController {
   private Zoo zoo = new Zoo(null, null, null, null, null, 0);

   public ZooController() {
      Habitat var1 = new Habitat(this.zoo.generateHabitatCode(), "Veterinary Clinic", EnvironmentType.MEDICAL, (double)27.0F, (double)400.0F, (double)4.0E7F, 25, HabitatStatus.ACTIVE);
      this.zoo.getHabitats().add(var1);
   }

   private <T> T optionToValue(T[] var1, int var2) {
      return (T)(var2 >= 1 && var2 <= var1.length ? var1[var2 - 1] : null);
   }

   private boolean isFilled(String var1) {
      return var1 != null && !var1.trim().isEmpty();
   }

   private String money(double var1) {
      Object[] var10001 = new Object[]{var1};
      return "$" + String.format("%,.0f", var10001) + " COP";
   }

   private Habitat findClinic() {
      for(int var1 = 0; var1 < this.zoo.getHabitats().size(); ++var1) {
         if (((Habitat)this.zoo.getHabitats().get(var1)).getEnvironment() == EnvironmentType.MEDICAL) {
            return (Habitat)this.zoo.getHabitats().get(var1);
         }
      }

      return null;
   }

   private ArrayList<Employee> parseStaff(String var1) {
      ArrayList<Employee> var2 = new ArrayList<>();
      if (!this.isFilled(var1)) {
         return var2;
      } else {
         String[] var3 = var1.split(",");

         for(int var4 = 0; var4 < var3.length; ++var4) {
            Employee var5 = this.zoo.findEmployee(var3[var4].trim());
            if (var5 == null || !var5.isActive()) {
               return null;
            }

            if (!var2.contains(var5)) {
               var2.add(var5);
            }
         }

         return var2;
      }
   }

   private String validateAssignment(Habitat var1, Animal var2) {
      if (var1.getStatus() != HabitatStatus.ACTIVE) {
         String var4 = var1.getCode();
         return "The habitat " + var4 + " is not active (" + String.valueOf(var1.getStatus()) + ").";
      } else if (!var1.hasFreeSpace()) {
         return "The habitat " + var1.getCode() + " has no free capacity.";
      } else if (!var1.isCompatibleWith(var2)) {
         String var10000 = var1.getCode();
         return "The habitat " + var10000 + " is " + String.valueOf(var1.getEnvironment()) + " but the animal needs " + String.valueOf(var2.getRequiredEnvironment()) + ".";
      } else {
         boolean var3 = var2.getHealth() == HealthStatus.QUARANTINE || var2.getHealth() == HealthStatus.RECOVERY;
         return var3 && var1.getEnvironment() != EnvironmentType.MEDICAL ? "Animals in quarantine or recovery must stay in the veterinary clinic." : null;
      }
   }

   private String occupancyWarning(Habitat var1) {
      if (var1.isOccupancyAlert()) {
         String var10000 = var1.getName();
         return "ARLETT!!: occupancy alert in " + var10000 + " (" + String.format("%.1f", var1.getOccupancyPercentage()) + "%).";
      } else {
         return "";
      }
   }

   public String registerZooInfo(String var1, String var2, String var3, String var4, String var5, double var6) {
      if (this.isFilled(var1) && this.isFilled(var2) && this.isFilled(var3) && this.isFilled(var4) && this.isFilled(var5)) {
         if (var6 < (double)0.0F) {
            return "Error: the budget cannot be negative.";
         } else {
            this.zoo.setInfo(var1.trim(), var2.trim(), var3.trim(), var4.trim(), var5.trim(), var6);
            return "Zoo information saved.";
         }
      } else {
         return "Error: all the text fields are required.";
      }
   }

   public String getZooInfo() {
      return !this.zoo.isInfoRegistered() ? "The zoo information has not been registered yet." : this.zoo.getInfoDetails();
   }

   public String updateZooBudget(double var1) {
      if (!this.zoo.isInfoRegistered()) {
         return "Error: register the zoo information first.";
      } else if (var1 < (double)0.0F) {
         return "Error: the budget cannot be negative.";
      } else {
         this.zoo.setMonthlyBudget(var1);
         String var10000 = this.money(var1);
         return "Zoo budget updated to " + var10000 + ".";
      }
   }

   public String registerEmployee(String var1, String var2, String var3, int var4) {
      Role var5 = (Role)this.optionToValue(Role.values(), var4);
      if (this.isFilled(var1) && this.isFilled(var2) && this.isFilled(var3)) {
         if (!var2.trim().matches("[0-9]+")) {
            return "Error: the phone must contain only digits.";
         } else if (!var3.contains("@")) {
            return "Error: the email is not valid.";
         } else if (var5 == null) {
            return "Error: invalid role option.";
         } else {
            Employee var6 = new Employee(this.zoo.generateEmployeeCode(), var1.trim(), var2.trim(), var3.trim(), var5);
            this.zoo.getEmployees().add(var6);
            return "Employee registered with code " + var6.getCode() + ".";
         }
      } else {
         return "Error: name, phone and email are required.";
      }
   }

   public String findEmployee(String var1) {
      Employee var2 = this.zoo.findEmployee(var1);
      return var2 == null ? "Error: there is no employee with code " + var1 + "." : var2.getDetails();
   }

   public String updateEmployee(String var1, int var2, String var3) {
      Employee var4 = this.zoo.findEmployee(var1);
      if (var4 == null) {
         return "Error: there is no employee with code " + var1 + ".";
      } else if (!this.isFilled(var3)) {
         return "Error: the new value cannot be empty.";
      } else {
         var3 = var3.trim();
         switch (var2) {
            case 1:
               var4.setFullName(var3);
               break;
            case 2:
               if (!var3.matches("[0-9]+")) {
                  return "Error: the phone must contain only digits.";
               }

               var4.setPhone(var3);
               break;
            case 3:
               if (!var3.contains("@")) {
                  return "Error: the email is not valid.";
               }

               var4.setEmail(var3);
               break;
            case 4:
               if (!var3.matches("[0-9]+")) {
                  return "Error: invalid role option.";
               }

               Role var5 = (Role)this.optionToValue(Role.values(), Integer.parseInt(var3));
               if (var5 == null) {
                  return "Error: invalid role option.";
               }

               var4.setRole(var5);
               break;
            case 5:
               if (var3.equals("1")) {
                  var4.setActive(true);
               } else {
                  if (!var3.equals("2")) {
                     return "Error: invalid status option.";
                  }

                  for(int var6 = 0; var6 < this.zoo.getHabitats().size(); ++var6) {
                     if (((Habitat)this.zoo.getHabitats().get(var6)).hasStaffMember(var4)) {
                        Habitat var10000 = (Habitat)this.zoo.getHabitats().get(var6);
                        return "Error: the employee is responsible for habitat " + var10000.getCode() + ". Reassign it first.";
                     }
                  }

                  var4.setActive(false);
               }
               break;
            default:
               return "Error: invalid field.";
         }

         return "Employee " + var1 + " updated.";
      }
   }

   public String listActiveEmployees() {
      String var1 = "";

      for(int var2 = 0; var2 < this.zoo.getEmployees().size(); ++var2) {
         Employee var3 = (Employee)this.zoo.getEmployees().get(var2);
         if (var3.isActive()) {
            var1 = var1 + var3.getCode() + " | " + var3.getFullName() + " | " + String.valueOf(var3.getRole()) + "\n";
         }
      }

      if (var1.isEmpty()) {
         return "There are no active employees.";
      } else {
         return var1;
      }
   }

   public String registerHabitat(String var1, int var2, double var3, double var5, double var7, int var9, int var10, String var11) {
      EnvironmentType var12 = (EnvironmentType)this.optionToValue(EnvironmentType.values(), var2);
      HabitatStatus var13 = (HabitatStatus)this.optionToValue(HabitatStatus.values(), var10);
      if (!this.isFilled(var1)) {
         return "Error: the name is required.";
      } else if (var12 != null && var13 != null && var13 != HabitatStatus.RETIRED) {
         if (!(var5 <= (double)0.0F) && var9 > 0) {
            if (var7 < (double)0.0F) {
               return "Error: the budget cannot be negative.";
            } else {
               ArrayList<Employee> var14 = this.parseStaff(var11);
               if (var14 == null) {
                  return "Error: some responsible employee does not exist or is inactive.";
               } else {
                  Habitat var15 = new Habitat(this.zoo.generateHabitatCode(), var1.trim(), var12, var3, var5, var7, var9, var13);
                  var15.setStaff(var14);
                  this.zoo.getHabitats().add(var15);
                  return "Habitat registered with code " + var15.getCode() + ".";
               }
            }
         } else {
            return "Error: area and capacity must be greater than zero.";
         }
      } else {
         return "Error: invalid environment or status option.";
      }
   }

   public String findHabitat(String var1) {
      Habitat var2 = this.zoo.findHabitat(var1);
      return var2 == null ? "Error: there is no habitat with code " + var1 + "." : var2.getDetails();
   }

   public String updateHabitat(String var1, int var2, String var3) {
      Habitat var4 = this.zoo.findHabitat(var1);
      if (var4 == null) {
         return "Error: there is no habitat with code " + var1 + ".";
      } else if (var4.getStatus() == HabitatStatus.RETIRED) {
         return "Error: a retired habitat cannot be modified.";
      } else if (var2 != 8 && !this.isFilled(var3)) {
         return "Error: the new value cannot be empty.";
      } else {
         try {
            switch (var2) {
               case 1:
                  var4.setName(var3.trim());
                  break;
               case 2:
                  EnvironmentType var5 = (EnvironmentType)this.optionToValue(EnvironmentType.values(), Integer.parseInt(var3.trim()));
                  if (var5 == null) {
                     return "Error: invalid environment option.";
                  }

                  if (var4.getOccupancy() <= 0 && var4.getEnvironment() != EnvironmentType.MEDICAL) {
                     var4.setEnvironment(var5);
                     break;
                  }

                  return "Error: the environment cannot change (it has animals or it is the clinic).";
               case 3:
                  var4.setTemperature(Double.parseDouble(var3.trim()));
                  break;
               case 4:
                  double var6 = Double.parseDouble(var3.trim());
                  if (var6 <= (double)0.0F) {
                     return "Error: the area must be greater than zero.";
                  }

                  var4.setArea(var6);
                  break;
               case 5:
                  double var8 = Double.parseDouble(var3.trim());
                  if (var8 < (double)0.0F) {
                     return "Error: the budget  negative.";
                  }

                  var4.setMonthlyBudget(var8);
                  break;
               case 6:
                  int var10 = Integer.parseInt(var3.trim());
                  if (var10 < 0) {
                     return "Error: the capacity must be greater than or equal to zero.";
                  }

                  if (var10 < var4.getOccupancy()) {
                     return "Error: the capacity cannot be lower than the current occupancy (" + var4.getOccupancy() + ").";
                  }

                  var4.setCapacity(var10);
                  break;
               case 7:
                  HabitatStatus var11 = (HabitatStatus)this.optionToValue(HabitatStatus.values(), Integer.parseInt(var3.trim()));
                  if (var11 == null) {
                     return "Error: invalid status optioon.";
                  }

                  if (var11 != HabitatStatus.ACTIVE && var4.getOccupancy() > 0) {
                     return "Error: a habitat with animals muust stay actiive.";
                  }

                  if (var11 == HabitatStatus.RETIRED && var4.getEnvironment() == EnvironmentType.MEDICAL) {
                     return "Error: thee veterinary clinic cannot be retired.";
                  }

                  var4.setStatus(var11);
                  break;
               case 8:
                  ArrayList<Employee> var12 = this.parseStaff(var3);
                  if (var12 == null) {
                     return "Error: some responsible emplloyee does not exist or is inactive.";
                  }

                  var4.setStaff(var12);
                  break;
               default:
                  return "Error: invalidd field.";
            }
         } catch (NumberFormatException var13) {
            return "Error: the value must be a number.";
         }

         return "Habitat " + var1 + " updated." + this.occupancyWarning(var4);
      }
   }

   public String getHabitatOccupancy(String var1) {
      Habitat var2 = this.zoo.findHabitat(var1);
      if (var2 == null) {
         return "Error: there is no habitat with code " + var1 + ".";
      } else {
         String var10000 = var2.getName();
         return "Habitat " + var10000 + ": " + var2.getOccupancy() + " of " + var2.getCapacity() + " animals (" + String.format("%.1f", var2.getOccupancyPercentage()) + "%)." + this.occupancyWarning(var2);
      }
   }

   public String listHabitats() {
      String var1 = "";

      for(int var2 = 0; var2 < this.zoo.getHabitats().size(); ++var2) {
         Habitat var3 = (Habitat)this.zoo.getHabitats().get(var2);
         var1 = var1 + var3.getCode() + " | " + var3.getName() + " | " + String.valueOf(var3.getEnvironment()) + " | " + var3.getArea() + " m2 | capacity " + var3.getCapacity() + " | occupancy " + var3.getOccupancy() + " | " + String.format("%.1f", var3.getOccupancyPercentage()) + "%\n";
      }

      return var1;
   }

   public String registerAnimal(String var1, String var2, String var3, int var4, double var5, int var7, int var8, String var9, String var10, int var11, int var12, String var13) {
      DietType var14 = (DietType)this.optionToValue(DietType.values(), var7);
      EnvironmentType var15 = (EnvironmentType)this.optionToValue(EnvironmentType.values(), var8);
      LifeStage var16 = (LifeStage)this.optionToValue(LifeStage.values(), var11);
      HealthStatus var17 = (HealthStatus)this.optionToValue(HealthStatus.values(), var12);
      if (this.isFilled(var1) && this.isFilled(var2) && this.isFilled(var3) && this.isFilled(var9)) {
         if (var14 != null && var15 != null && var15 != EnvironmentType.MEDICAL && var16 != null && var17 != null) {
            if (var5 <= (double)0.0F) {
               return "Error: the weight must be greater than zero.";
            } else if (var4 > LocalDate.now().getYear()) {
               return "Error: the date birth year cannot be in the future.";
            } else {
               LocalDate var18;
               try {
                  var18 = LocalDate.parse(var10.trim());
               } catch (DateTimeParseException var22) {
                  return "Error: the date must have the format yyyy-MM-dd.";
               }

               if (var18.isAfter(LocalDate.now())) {
                  return "Error: the entry date cannot be in the future.";
               } else {
                  Habitat var19 = this.zoo.findHabitat(var13);
                  if (var19 == null) {
                     return "Error: there is no habitat with code " + var13 + ".";
                  } else {
                     Animal var20 = new Animal(this.zoo.generateAnimalCode(), var1.trim(), var2.trim(), var3.trim(), var4, var5, var14, var15, var9.trim(), var18, var16, var17);
                     String var21 = this.validateAssignment(var19, var20);
                     if (var21 != null) {
                        return "Error: the animal could not be registered. " + var21;
                     } else {
                        var19.addAnimal(var20);
                        this.zoo.getAnimals().add(var20);
                        String var10000 = var20.getCode();
                        return "Animal registered with code " + var10000 + "." + this.occupancyWarning(var19);
                     }
                  }
               }
            }
         } else {
            return "Error: invalid option for diet, environment, life stage or health.";
         }
      } else {
         return "Error: name, species, sex and origin country are required.";
      }
   }

   public String findAnimal(String var1) {
      Animal var2 = this.zoo.findAnimal(var1);
      if (var2 == null) {
         return "Error: there is no animal with code " + var1 + ".";
      } else {
         String var10000 = var2.getDetails();
         return var10000 + "\nDaily ration: " + String.format("%.2f", var2.calculateDailyRation()) + " kg";
      }
   }

   public String updateAnimal(String var1, int var2, String var3) {
      Animal var4 = this.zoo.findAnimal(var1);
      if (var4 == null) {
         return "Error: there is no animal with code " + var1 + ".";
      } else if (!var4.isActive()) {
         return "Error: a retired animal cannot be modified.";
      } else if (!this.isFilled(var3)) {
         return "Error: the new value cannot be empty.";
      } else {
         try {
            switch (var2) {
               case 1:
                  var4.setName(var3.trim());
                  break;
               case 2:
                  var4.setSpecies(var3.trim());
                  break;
               case 3:
                  var4.setSex(var3.trim());
                  break;
               case 4:
                  double var5 = Double.parseDouble(var3.trim());
                  if (var5 <= (double)0.0F) {
                     return "Error: the weight must be greater than zero.";
                  }

                  var4.setWeight(var5);
                  break;
               case 5:
                  DietType var7 = (DietType)this.optionToValue(DietType.values(), Integer.parseInt(var3.trim()));
                  if (var7 == null) {
                     return "Error: invalid diet option.";
                  }

                  var4.setDiet(var7);
                  break;
               case 6:
                  EnvironmentType var8 = (EnvironmentType)this.optionToValue(EnvironmentType.values(), Integer.parseInt(var3.trim()));
                  if (var8 != null && var8 != EnvironmentType.MEDICAL) {
                     Habitat var9 = var4.getHabitat();
                     if (var9.getEnvironment() != EnvironmentType.MEDICAL && var9.getEnvironment() != var8) {
                        return "Error: the current habitat is not compatible with that environment. Transfer the animal first.";
                     }

                     var4.setRequiredEnvironment(var8);
                     break;
                  }

                  return "Error: invalid environment option.";
               case 7:
                  LifeStage var10 = (LifeStage)this.optionToValue(LifeStage.values(), Integer.parseInt(var3.trim()));
                  if (var10 == null) {
                     return "Error: invalid life stage option.";
                  }

                  var4.setLifeStage(var10);
                  break;
               case 8:
                  HealthStatus var11 = (HealthStatus)this.optionToValue(HealthStatus.values(), Integer.parseInt(var3.trim()));
                  if (var11 == null) {
                     return "Error: invalid health option.";
                  }

                  return this.changeHealth(var4, var11);
               default:
                  return "Error: invalid field.";
            }
         } catch (NumberFormatException var12) {
            return "Error: the value must be a number.";
         }

         return "Animal " + var1 + " updated.";
      }
   }

   private String changeHealth(Animal var1, HealthStatus var2) {
      boolean var3 = var2 == HealthStatus.QUARANTINE || var2 == HealthStatus.RECOVERY;
      if (var3 && var1.getHabitat().getEnvironment() != EnvironmentType.MEDICAL) {
         Habitat var4 = this.findClinic();
         String var5 = this.validateAssignment(var4, var1);
         if (var5 != null) {
            return "Error: the health was not changed because the animal cannot go to the clinic. " + var5;
         } else {
            var1.getHabitat().removeAnimal(var1);
            var4.addAnimal(var1);
            var1.setHealth(var2);
            String var10000 = var4.getName();
            return "Health updated. The animal was moved to the " + var10000 + "." + this.occupancyWarning(var4);
         }
      } else {
         var1.setHealth(var2);
         return "Health updated.";
      }
   }

   public String transferAnimal(String var1, String var2) {
      Animal var3 = this.zoo.findAnimal(var1);
      Habitat var4 = this.zoo.findHabitat(var2);
      if (var3 == null) {
         return "Error: there is no animal with code " + var1 + ".";
      } else if (var4 == null) {
         return "Error: there is no habitat with code " + var2 + ".";
      } else if (!var3.isActive()) {
         return "Error: a retired animal cannot be transferred.";
      } else if (var3.getHabitat() == var4) {
         return "Error: the animal is already in that habitat.";
      } else {
         String var5 = this.validateAssignment(var4, var3);
         if (var5 != null) {
            return "Error: the transfer was not done. " + var5;
         } else {
            var3.getHabitat().removeAnimal(var3);
            var4.addAnimal(var3);
            return "Animal " + var1 + " transferred to " + var4.getName() + "." + this.occupancyWarning(var4);
         }
      }
   }

   public String retireAnimal(String var1, int var2) {
      Animal var3 = this.zoo.findAnimal(var1);
      RetirementReason var4 = (RetirementReason)this.optionToValue(RetirementReason.values(), var2);
      if (var3 == null) {
         return "Error: there is no animal with code " + var1 + ".";
      } else if (!var3.isActive()) {
         return "Error: the animal is already retired.";
      } else if (var4 == null) {
         return "Error: invalid reason option.";
      } else {
         var3.getHabitat().removeAnimal(var3);
         var3.retire(LocalDate.now(), var4);
         return "Animal " + var1 + " retired (" + String.valueOf(var4) + "). Its data was kept.";
      }
   }

   public String listActiveAnimals() {
      String var1 = "";

      for(int var2 = 0; var2 < this.zoo.getAnimals().size(); ++var2) {
         Animal var3 = (Animal)this.zoo.getAnimals().get(var2);
         if (var3.isActive()) {
            var1 = var1 + var3.getCode() + " | " + var3.getName() + " | " + var3.getSpecies() + " | " + String.valueOf(var3.getHealth()) + "\n";
         }
      }

      if (var1.isEmpty()) {
         return "There are no active animals.";
      } else {
         return var1;
      }
   }

   public char[] calculateHabitatFeeding(String text) {
      throw new UnsupportedOperationException("Unimplemented method 'calculateHabitatFeeding'");
   }

   public char[] calculateZooFeeding() {
      throw new UnsupportedOperationException("Unimplemented method 'calculateZooFeeding'");
   }
}


