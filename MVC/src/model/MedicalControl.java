package model;

public class MedicalControl extends Activity {

    private String animalId;
    private String reason;
    private double weightRecorded;
    private String observations;
    private String medications;
    private String resultingHealthStatus;
    private String nextFollowUpDate;
    

    public MedicalControl(String id, String scheduleDate, String executionDate, String personInCharge, String animalId, String reason, double weightRecorded, String observations, String medications, String resultingHealthStatus, String nextFollowUpDate){

        super(id, scheduleDate, executionDate, personInCharge);
        this.animalId = animalId;
        this.reason = reason;
        this.weightRecorded = weightRecorded;
        this.observations = observations;
        this.medications = medications;
        this.resultingHealthStatus = resultingHealthStatus;
        this.nextFollowUpDate = nextFollowUpDate;

    }

    @Override 
    public String getActivityType(){
 
        return "Control medico";
    }
    
    public String getAnimalId() { return animalId;}
    public String getreason()  { return reason;}
    public double getWeightRecorded() {return weightRecorded;}
    public String getObservations() {return observations;}
    public String getMedications() {return medications;}
    public String getResultingHealthStatus() {return resultingHealthStatus;}
    public String getNextFollowUpDate() {return nextFollowUpDate;}
    
}
