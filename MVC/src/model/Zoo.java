package MVC.src.model;

public class Zoo {
    
    private String name;
    private String city;
    private double budget;
    private Habitat[] myHabitats;

    public Zoo(String name, String city, double budget){

        this.name = name;
        this.city = city;
        this.budget = budget;
        myHabitats = new Habitat[33];
    }

    public String  getGeneralInformation(){

        return "Nombre: " + name + "\nCiudad: " + city + "\nPresuspuesto;: " + budget;

    }


    public boolean registerHabitat(String name, String enviroment , double area){
        int position = getAvailableHabitatsSpace();

        if (position > -1) {

            Habitat newHabitat = new Habitat(name, enviroment, area);
            myHabitats[position] = newHabitat;
            return true;
        }
        return false;
    }

    private int getAvailableHabitatsSpace() {
        for (int i = 0; i < myHabitats.length; i++) {
            if (myHabitats[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void setNameZoo(String newName){

        name = newName;
    }

    public void setCityZoo(String newCity){

        city = newCity;
    }

    public void setBudgetZoo(double newBudget){

        budget = newBudget;
    }

    public char[] showGeneralImformation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showGeneralImformation'");
    }
}

