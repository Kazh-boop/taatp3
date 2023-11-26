package fr.kazhboop.taatp3.domain.persons;

import fr.kazhboop.taatp3.domain.Appointment;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;

@Entity
public abstract class User implements Serializable {

    private Long id;

    protected String name;

    protected List<Appointment> appointments;

    protected User() {
    }

    protected User(String name) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
