package fr.kazhboop.taatp3.domain.persons;

import fr.kazhboop.taatp3.domain.Appointment;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Veterinarian extends User implements Serializable {

    private String cabinet;

    private List<Appointment> appointments = new ArrayList<>();

    public Veterinarian() {
    }

    public Veterinarian(String name, String cabinet) {
        this.name = name;
        this.cabinet = cabinet;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    @OneToMany(mappedBy = "veterinarian", cascade=CascadeType.PERSIST)
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
