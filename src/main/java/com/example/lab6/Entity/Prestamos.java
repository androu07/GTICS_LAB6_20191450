package com.example.lab6.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="prestamos")
public class Prestamos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_prestamos")
    private int id;
    @Column(nullable = false)
    private String profesor;
    private String estudiante;
    private String dispositivo;
    private Date fecha_inicio;
    private Date fecha_fin;

    @MapsId("id_usuarios")
    @ManyToOne
    @JoinColumn(name="id_usuarios")
    private Roles id_usuarios;

    @MapsId("id_roles")
    @ManyToOne
    @JoinColumn(name="id_roles")
    private Roles id_roles;
}
