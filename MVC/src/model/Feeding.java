package model;

public class Feeding {
    
    private String animalId;
    private String habiatatId;
    private String dietType;
    private double rationWeight;

    public Feeding(String id, String scheduleDate , String executionDate , double rationWeight, String dietType, String animalId ){
        
        super();
        this.animalId = animalId;
        String habitatId = null;
        this.habiatatId = habitatId;
        this.dietType = dietType;
        this.rationWeight = rationWeight;
    }

    public String getActivityType(){
      
        return "Alimentacion";

    }
    
    public String getAnimalId(){ return animalId;}
    public String getHabiataId(){ return habiatatId;}
    public String getDiteType() { return dietType;}
    public double getRationWeight() {return rationWeight;}

}
