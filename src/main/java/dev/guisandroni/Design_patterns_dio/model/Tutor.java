package dev.guisandroni.Design_patterns_dio.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Tutor(long id, String name, Animal animal) {
        this.id = id;
        this.name = name;
        this.animal = animal;
    }

    public Tutor() {

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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
