package com.ada.aerolineaf.aerolineaV1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_flight;

    private String name;

    private String origin_city;

    private String destination_city;

    @OneToOne
    @JoinColumn(name = "pilot", referencedColumnName = "id_pilot")
    private Pilot pilot;

    @OneToOne
    @JoinColumn(name = "airplane", referencedColumnName = "id_airplane")
    private Airplane airplane;

    private Date departure_date;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "flight_crew",
            joinColumns = @JoinColumn(name = "id_flight"),
            inverseJoinColumns = @JoinColumn(name = "id_crew"))
    private Set<Crew> flightCrew;

    public int getId_flight() {
        return id_flight;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin_city() {
        return origin_city;
    }

    public void setOrigin_city(String origin_city) {
        this.origin_city = origin_city;
    }

    public String getDestination_city() {
        return destination_city;
    }

    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Set<Crew> getFlightCrew() {
        return flightCrew;
    }

    public void setFlightCrew(Set<Crew> flightCrew) {
        this.flightCrew = flightCrew;
    }
}
