package com.ada.aerolineaf.aerolineaV1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @OneToOne
    @JoinColumn(name = "base_code", referencedColumnName = "id_base")
    private Base base;

    private String position;

    @JsonBackReference
    @ManyToMany(mappedBy = "flightCrew")
    private Set<Flight> flights;

    public int getId() { return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @ManyToMany
    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
}
