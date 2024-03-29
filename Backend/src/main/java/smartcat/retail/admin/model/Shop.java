package smartcat.retail.admin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import smartcat.retail.admin.model.dto.ShopDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column( nullable = false )
    private String name;

    private String address;

    private String phone;
    @ManyToOne
    @JsonBackReference
    private Territory territory;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Employee> employees;

    public Shop() {
    }

    public Shop(String name, String address, String phone, Territory territory, List<Employee> employees) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.territory = territory;
        this.employees = employees;
    }

    public Shop(ShopDTO dto){
        this.name = dto.name;
        this.address = dto.address;
        this.phone = dto.phone;
        this.employees = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void updateInfo(ShopDTO s) {
        this.name = s.name;
        this.address = s.address;
        this.phone = s.phone;
    }
}
