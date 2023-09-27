package fr.kazhboop.taatp3.domain.persons;

import fr.kazhboop.taatp3.domain.Appointment;
import fr.kazhboop.taatp3.domain.animals.Animal;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner extends User implements Serializable {

    private List<Animal> animals = new ArrayList<Animal>();

    private List<Appointment> appointments = new ArrayList<>();

    public Owner() {}

    public Owner(String name) {
        this.name = name;
    }

    public Owner(String name, List<Animal> animals) {
        this.name = name;
        this.animals = animals;
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public String toString() {
        return "Owner: " + this.name;
    }
}
