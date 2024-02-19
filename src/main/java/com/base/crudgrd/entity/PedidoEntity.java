package com.base.crudgrd.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity(name = "pedido")
@Table(name="tbl_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PedidoEntity  implements Serializable {

    @Id
    @Column(name="id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idPedido;

    @Column(name="estatus_pedido")
    private String estatusPedido;

    @Column(name="total_unidades")
    private BigDecimal totalUnidades;

    @Column(name="total")
    private BigDecimal total;

    @Column(name="total_descuento")
    private BigDecimal totalDescuento;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="update_at")
    private LocalDateTime updateAt;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private Set<CamionetaEntity> camionetas;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tienda")
    private TiendaEntity tienda;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;








}
