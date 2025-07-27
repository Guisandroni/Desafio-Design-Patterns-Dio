package dev.guisandroni.Design_patterns_dio.model;

import jakarta.persistence.*;

@Entity
@Table(name= "petShop")

public class PetShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Services services;
    private int price;

    public PetShop(long id, String name, Services services, int price) {
        this.id = id;
        this.name = name;
        this.services = services;
        this.price = price;
    }

    public PetShop() {

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

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
