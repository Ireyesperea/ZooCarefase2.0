package model;

public enum LifeStage {
   JUVENIL("Juvenil"),
   ADULT("Adulto");

   private final String label;

   private LifeStage(String var3) {
      this.label = var3;
   }

   public String toString() {
      return this.label;
   }
}
