package model;

public enum HealthStatus {
   HEALTHY("Saludable"),
   QUARANTINE("Cuarentena"),
   RECOVERY("Recuperación"),
   UNDER_OBSERVATION("Bajo observación");

   private final String label;

   private HealthStatus(String var3) {
      this.label = var3;
   }

   public String toString() {
      return this.label;
   }
}


