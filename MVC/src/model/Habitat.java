package MVC.src.model;

public class Habitat {

    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private String enviroment;
    @SuppressWarnings("unused")
    private double area;

    public Habitat(String name2, String enviroment2, double area2) {
        this.name = name2;
        this.enviroment = enviroment2;
        this.area = area2;
    }

    public static void habitat(Habitat habitat, String name, String enviroment, double area) {
        habitat.name = name;
        habitat.enviroment = enviroment;
        habitat.area = area;
    }
}
