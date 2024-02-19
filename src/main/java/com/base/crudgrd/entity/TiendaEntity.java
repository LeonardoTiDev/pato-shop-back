package com.base.crudgrd.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "tienda")
@Table(name="tbl_tienda")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TiendaEntity implements Serializable {


    @Id
    @Column(name="id_tienda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idTienda;

    @Column(name="codigo_tienda")
    private String codigoTienda;

    @Column(name="direccion")
    private String direccion;

    @Column(name="telefono")
    private String telefono;


    @Column(name="created_at")
    private LocalDate createdAt;

    @Column(name="update_at")
    private Timestamp updateAt;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "tienda"
    )
    private Set<VendedorEntity> vendedores;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "tienda"
    )
    private Set<PedidoEntity> pedidos;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @JoinColumn(name = "inventario_id")  // Indica la columna que representa la clave foránea
    private Set<InventarioEntity> inventarios;







}
