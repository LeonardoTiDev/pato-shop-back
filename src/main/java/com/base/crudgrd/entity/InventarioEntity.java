package com.base.crudgrd.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "inventario")
@Table(name="tbl_inventario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InventarioEntity implements Serializable {


    @Id
    @Column(name="id_inventario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idInventario;

    @Column(name="cantidad_unidades")
    private BigDecimal cantidadUnidades;

    @Column(name="id_tienda")
    private Integer idTienda;





//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToOne
//    @JoinColumn(name = "camioneta_id", referencedColumnName = "id_camioneta")
//    private CamionetaEntity camioneta;




//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_tienda")
//    private TiendaEntity tienda;





}
