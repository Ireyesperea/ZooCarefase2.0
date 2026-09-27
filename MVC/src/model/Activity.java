package model;

public abstract class Activity {
    
    private  String id;
    protected  String scheduleDate;
    private  String executionDate;
    public  String personInCharge;
    private  String status; // estado de asignacion , de finalizacion y cancelacion
    private  double cost;

    public Activity(String id, String sheduleDate, String executionDate, String personInCharge){

        this.id = id;
        this.scheduleDate = sheduleDate;
        this.executionDate = executionDate;
        this.personInCharge = personInCharge;
        this.status = "asiganda";
        this.cost = 0;
    }
    public abstract  String getActivityType();
    
    public void finish(double finalCost){
        this.status = "finalizada";
        this.cost = finalCost;
    }

    public void cancel() {

    this.status = "cancelada";
    }

    public String getSummary(){
        return  "Codigo:" + id +" | Tipo: " + getActivityType() + " | Encargado:" + personInCharge + " |Estado: " + status +" | Costo $ " + cost;

    }

    public String getId() { return id;}
    public String getSheduleDate() { return scheduleDate;}
    public String getExecutionDate() { return executionDate;}
    public String getPersonInCharge() { return personInCharge;}
    public String getStatus() { return status;}
    public double getCost() { return cost;} 
}
