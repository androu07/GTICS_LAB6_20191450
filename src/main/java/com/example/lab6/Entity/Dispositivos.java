package com.example.lab6.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="dispositivos")
public class Dispositivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dispositivos")
    private int id;
    @Column(nullable = false)
    private String nombre;
    private int cantidad;
    private int stock;

    @MapsId("id_usuarios")
    @ManyToOne
    @JoinColumn(name="id_usuarios")
    private Roles id_usuarios;

    @MapsId("id_roles")
    @ManyToOne
    @JoinColumn(name="id_roles")
    private Roles id_roles;
}
