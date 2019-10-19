package smartcat.retail.admin.model.dto;

import smartcat.retail.admin.model.Employee;
import smartcat.retail.admin.model.Shop;

import java.util.List;

public class ShopDTO {
    public long id;

    public String name;
    public String address;
    public String phone;
    public List employees;
    public long territory;

    public ShopDTO() {
    }

    public ShopDTO(long id, String name, String address, String phone, List employees, long territory) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.employees = employees;
        this.territory = territory;
    }

    public ShopDTO(Shop s){
        this.id = s.getId();
        this.name = s.getName();
        this.address = s.getAddress();
        this.phone = s.getPhone();
        this.employees = s.getEmployees();
        this.territory = s.getTerritory().getId();
    }
}
