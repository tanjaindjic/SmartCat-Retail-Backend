package smartcat.retail.admin.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Territory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column( nullable = false )
    private String city;

    private String postal;

    @Column( nullable = false )
    private String country;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Shop> shops;

    public Territory() {
    }

    public Territory(String city, String postal, String country, List<Shop> shops) {
        this.city = city;
        this.postal = postal;
        this.country = country;
        this.shops = shops;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
