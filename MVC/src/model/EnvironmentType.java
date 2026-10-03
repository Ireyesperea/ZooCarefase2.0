package model;

public enum EnvironmentType {
   LAND("Terrestre"),
   WATER("Acuatico"),
   AVIARY("Aviario"),
   MEDICAL("Medico");

   private String typeName;

   private EnvironmentType(String var3) {
      this.typeName = var3;
   }

   public String getTypeName() {
      return this.typeName;
   }
}
