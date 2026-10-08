package model;

public enum HabitatStatus {

    ACTIVE("Activo"),
    MAINTENANCE("En mantenimiento"),
    UNDER_CONSTRUCTION("En construcción"),
    RETIRED("Retirado");

    private final String label;

    HabitatStatus(String label) {
        this.label = label;
    }

  
    public String toString() {
        return this.label;
    }
}



