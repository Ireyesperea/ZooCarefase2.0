package MVC.src.model;

 public class Zoo{

    // Atributes
    private String name;
    private String city;
    private String address;
    private double budget; 

    public Zoo(String name, String city, String address, double budget) {

        this.name = name;
        this.city = city;
        this.address = address;
        this.budget = budget;

        Habitat[] myHabitats = new Habitat[33];

 }

 public String getInformation() {
     return name + "-" + city + "-" + address + "-" + budget;

}

     public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public char[] showGeneralImformation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showGeneralImformation'");
    }
 }
