package smartcat.retail.admin.model.dto;

import smartcat.retail.admin.model.Employee;

public class EmployeeDTO {
    public long id;
    public String firstName;
    public String lastName;
    public String email;
    public String position;
    public long shop;

    public EmployeeDTO() {
    }

    public EmployeeDTO(long id, String firstName, String lastName, String email, String position, long shop) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.shop = shop;
    }

    public EmployeeDTO(Employee e){
        this.id = e.getId();
        this.firstName = e.getFirstName();
        this.lastName = e.getLastName();
        this.email = e.getEmail();
        this.position = e.getPosition();
        this.shop = e.getShop().getId();
    }
}
