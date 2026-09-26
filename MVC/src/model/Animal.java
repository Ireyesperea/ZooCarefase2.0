// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package model;

public class Animal {
   private String name;
   private double weight;
   private String dietType;
   private String lifeStage;
   private String healthStatus;

   public Animal(String var1, double var2, String var4, String var5, String var6) {
      this.name = var1;
      this.weight = var2;
      this.dietType = var4;
      this.lifeStage = var5;
      this.healthStatus = var6;
   }

   public double calculateMonthlyRationCost() {
      double var1 = (double)0.0F;
      double var3 = (double)0.0F;
      double var5 = (double)0.0F;
      switch (this.dietType) {
         case "carnivora":
            var1 = 0.03;
            var3 = (double)25500.0F;
            break;
         case "herbivora":
            var1 = 0.04;
            var3 = (double)8800.0F;
            break;
         case "omnivora":
            var1 = 0.035;
            var3 = (double)15200.0F;
            break;
         case "insectivora":
            var1 = 0.025;
            var3 = (double)18300.0F;
      }

      if (this.lifeStage.equals("juvenil")) {
         var5 = 0.2;
      } else if (!this.healthStatus.equals("cuarentena") && !this.healthStatus.equals("recuperacion")) {
         if (this.healthStatus.equals("en observacion")) {
            var5 = 0.1;
         }
      } else {
         var5 = 0.15;
      }

      return this.weight * var1 * ((double)1.0F + var5) * var3 * (double)30.0F;
   }

   public String getName11() {
      return this.name;
   }

   public String getName() {
	// TODO Auto-generated method stub
	throw new UnsupportedOperationException("Unimplemented method 'getName'");
   }

   public String getName1() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
   }
}
