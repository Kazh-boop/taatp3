package fr.kazhboop.taatp3.domain.animals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.kazhboop.taatp3.domain.persons.Owner;
import jakarta.persistence.*;


import java.io.Serializable;

@Entity
public class Animal implements Serializable {

    private Long id;

    protected EAnimalType animalType;

    protected String name;

    protected int age;

    protected Owner owner;

    public Animal() {
    }

    public Animal(EAnimalType animalsTypes, String name, int age, Owner owner) {
        this.animalType = animalsTypes;
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public Animal(EAnimalType animalsTypes, String name, int age) {
        this.animalType = animalsTypes;
        this.name = name;
        this.age = age;
    }

    public Animal(EAnimalType animalsTypes, String name) {
        this.animalType = animalsTypes;
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public EAnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(EAnimalType animalType) {
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne
    @JsonIgnore
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String toString() {
        return this.name + " is " + this.age + " years old " + getClass().getSimpleName().toLowerCase();
    }
}
