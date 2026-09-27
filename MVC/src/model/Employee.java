package model;

public class Employee {
    private String id;
    private String fullName;
    private String phone;
    private String email;
    private String role; // rol de veterinario o cuidador
    private String status; // estado de activo o inactivo 

    public Employee(String id, String fullName, String phone , String email, String role){

        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.status = "activo";
    }

    public void desactivate() {
        this.status = "inactivo";
    }
    public String getSummary() {
        return "Codigo:" + id + "| Nombre: " + fullName + "|Rol:" + role + "|Estado: " + status;
    }
    public String getIdString () { return id;}
    public String getFullName () { return phone;}
    public String getEmail () { return email;}
    public String getRole() {return role;}
    public String getStatus() { return status;}
   
    public void setFullName(String fullName) {this.fullName = fullName;

 } 
    public void setPhone(String phone) {this.phone = phone;}
    public void setEmial(String email) {this.email = email;}

}
