package smartcat.retail.admin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import smartcat.retail.admin.model.dto.EmployeeDTO;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname", nullable = false)
     private String firstName;

    @Column(name = "lastname", nullable = false)
     private String lastName;

     private String email;

     private String position;

     @ManyToOne
     @JsonBackReference
     private Shop shop;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, String position, Shop shop) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.shop = shop;
    }

    public Employee(EmployeeDTO dto) {
        this.firstName = dto.firstName;
        this.lastName = dto.lastName;
        this.email = dto.email;
        this.position = dto.position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void updateInfo(EmployeeDTO e) {
        this.firstName = e.firstName;
        this.lastName = e.lastName;
        this.email = e.email;
        this.position = e.position;
    }
}


