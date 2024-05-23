package com.example.lab6.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private int id;
    @Column(nullable = false)
    private String nombre;
    private String correo;
    private String password;

    @MapsId("id_roles")
    @ManyToOne
    @JoinColumn(name="id_roles")
    private Roles id_roles;
}
