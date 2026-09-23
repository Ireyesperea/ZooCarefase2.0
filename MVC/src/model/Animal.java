package MVC.src.model;

public class Animal {

private double weight;
private String dietType;
private String lifeStage;
private String healthStatus;

public Animal(String name, double weight, String dietType, String lifeStage, String healthStatus) {
    this.weight = weight;
    this.dietType = dietType;
    this.lifeStage = lifeStage;
    this.healthStatus = healthStatus;
}

public double getWeight() {
    return weight;
}

public String getDietType() {
    return dietType;
}

public String getLifeStage() {
    return lifeStage;
}

public String getHealthStatus() {
    return healthStatus;
}
    
}
