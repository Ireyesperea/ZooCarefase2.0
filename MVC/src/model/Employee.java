package model;

public class Employee {
   private final String code;
   private String fullName;
   private String phone;
   private String email;
   private Role role;
   private boolean active;

   public Employee(String var1, String var2, String var3, String var4, Role var5) {
      this.code = var1;
      this.fullName = var2;
      this.phone = var3;
      this.email = var4;
      this.role = var5;
      this.active = true;
   }

   public String getCode() {
      return this.code;
   }

   public String getFullName() {
      return this.fullName;
   }

   public void setFullName(String var1) {
      this.fullName = var1;
   }

   public String getPhone() {
      return this.phone;
   }

   public void setPhone(String var1) {
      this.phone = var1;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public Role getRole() {
      return this.role;
   }

   public void setRole(Role var1) {
      this.role = var1;
   }

   public boolean isActive() {
      return this.active;
   }

   public void setActive(boolean var1) {
      this.active = var1;
   }

   public String getDetails() {
      String var10000 = this.code;
      return "Code: " + var10000 + "\nName: " + this.fullName + "\nPhone: " + this.phone + "\nEmail: " + this.email + "\nRole: " + String.valueOf(this.role) + "\nStatus: " + (this.active ? "Active" : "Inactive");
   }
}
