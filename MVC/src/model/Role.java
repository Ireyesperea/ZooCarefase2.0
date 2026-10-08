package model;

public enum Role {
   KEEPER("Keeper"),
   VETERINARIAN("Veterinarian");

   private final String label;

   private Role(String var3) {
      this.label = var3;
   }

   public String toString() {
      return this.label;
   }
}
