package dev.guisandroni.Design_patterns_dio.model;


import jakarta.persistence.*;

@Entity
@Table(name= "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private String race;
    private Gender gender;
    private int age;
    private double weight;

    public Animal(long id, String name, String race, int age, double weight, Gender gender) {
        Id = id;
        this.name = name;
        this.race = race;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    public Animal() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
