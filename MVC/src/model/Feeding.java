package model;

public class Feeding extends Activity {
    
    private String animalId;
    private String habiatatId;
    private String dietType;
    private double rationWeight;

    public Feeding(String id, String sheduleDate , String executionDate , double rationWeight, String dietType, String animalId ){
        
        super(id, sheduleDate, executionDate, PersonInCharge());
        this.animalId = animalId;
        String habitatId = null;
        this.habiatatId = habitatId;
        this.dietType = dietType;
        this.rationWeight = rationWeight;
    }

    private static String PersonInCharge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PersonInCharge'");
    }

    @Override 
    public String getActivityType(){
      
        return "Alimentacion";

    }
    
    public String getAnimalId(){ return animalId;}
    public String getHabiataId(){ return habiatatId;}
    public String getDiteType() { return dietType;}
    public double getRationWeight() {return rationWeight;}

}
