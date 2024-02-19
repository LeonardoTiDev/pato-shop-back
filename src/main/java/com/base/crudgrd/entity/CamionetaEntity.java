package com.base.crudgrd.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "camioneta")
@Table(name="tbl_camioneta")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CamionetaEntity implements Serializable {


    @Id
    @Column(name="id_camioneta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idCamioneta;

    @Column(name="identificador_HAWA")
    private String identificadorHAWA;

    @Column(name="precio_lista")
    private BigDecimal precioLista;

    @Column(name="descuento")
    private BigDecimal descuento;

    @Column(name="motor")
    private String motor;


    @Column(name="cilindros")
    private Integer cilindros;

    @Column(name="color")
    private String color;

    @Column(name="estatus_inventario")
    private Integer estatusInventario;


    @Column(name="created_at")
    private LocalDate createdAt;

    @Column(name="update_at")
    private Timestamp updateAt;

    @Column(name="quantity")
    private Integer quantity;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "inventario_id", referencedColumnName = "id_inventario")
    private InventarioEntity inventario;

    @Column(name="pedido_id")
    private Integer pedidoId;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pedido_id")
//    private PedidoEntity pedido;


}
