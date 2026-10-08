package model;

public enum EnvironmentType {
   TERRESTRIAL("Terrestre"),
   AQUATIC("Acuatico"),
   AVIARY("Aviario"),
   MEDICAL("Medico");

   private final String label;

   private EnvironmentType(String var3) {
      this.label = var3;
   }

   public String toString() {
      return this.label;
   }
}
