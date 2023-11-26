package fr.kazhboop.taatp3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.kazhboop.taatp3.domain.persons.Owner;
import fr.kazhboop.taatp3.domain.persons.Veterinarian;
import jakarta.persistence.*;


import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Appointment implements Serializable {
    private Long id;

    private Owner owner;

    private Veterinarian veterinarian;

    private Timestamp startTime;

    public Appointment() {
    }

    public Appointment(Owner owner, Veterinarian vet, Timestamp startTime) {
        this.owner = owner;
        this.veterinarian = vet;
        this.startTime = startTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JsonIgnore
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @ManyToOne
    @JsonIgnore
    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian vet) {
        this.veterinarian = vet;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp timestamp) {
        this.startTime = timestamp;
    }

    public String toString() {
        return "Meeting between " + owner.getName() + " and " + veterinarian.getName() + " at " + startTime;
    }
}
