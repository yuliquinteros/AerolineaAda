package com.ada.aerolineaf.aerolineaV1.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_airplane;

    private String type;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "base_code", referencedColumnName = "id_base")
    private Base base;

    public int getId_airplane() {
        return id_airplane;
    }

    public void setId_airplane(int id_airplane) {
        this.id_airplane = id_airplane;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
}
