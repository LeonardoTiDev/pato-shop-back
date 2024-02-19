package com.base.crudgrd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;


@Entity(name = "cliente")
@Table(name="tbl_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClienteEntity implements Serializable {


    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idCliente;

    @Column(name="nombre_usuario")
    private String nombreUsuario;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido_paterno")
    private String apellidoPaterno;

    @Column(name="apellido_materno")
    private String apellidoMaterno;

    @Column(name="dni")
    private String dni;

    @Column(name="email")
    private String email;

    @Column(name="created_at")
    private LocalDate createdAt;

    @Column(name="update_at")
    private Timestamp updateAt;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "cliente"
    )
    private Set<PedidoEntity> pedidos;




}
