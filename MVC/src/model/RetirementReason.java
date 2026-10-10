package model;

public enum RetirementReason {
   DEATH("Muerte"),
   TRANSFERRED("Transferido a otro zoo");

   private final String label;

   private RetirementReason(String label) {
      this.label = label;
   }

   @Override
   public String toString() {
      return this.label;
   }
}
