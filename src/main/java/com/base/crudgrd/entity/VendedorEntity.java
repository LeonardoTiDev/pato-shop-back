package com.base.crudgrd.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "vendedor")
@Table(name="tbl_vendedor")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VendedorEntity implements Serializable {



    @Id
    @Column(name="id_vendedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idVendedor;

    @Column(name="codigo_vendedor")
    private String codigoVendedor;

    @Column(name="ip_usuario")
    private String ipusuario;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTienda")
    private TiendaEntity tienda;



}
