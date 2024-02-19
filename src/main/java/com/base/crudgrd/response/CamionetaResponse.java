package com.base.crudgrd.response;

import com.base.crudgrd.entity.InventarioEntity;
import com.base.crudgrd.entity.PedidoEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CamionetaResponse implements Serializable {

    public Integer idCamioneta;
    private String identificadorHAWA;
    private BigDecimal precioLista;
    private BigDecimal descuento;
    private String motor;
    private Integer cilindros;
    private String color;
    private Integer estatusInventario;
    private LocalDate createdAt;
    private Timestamp updateAt;

    private Integer quantity;

    private InventarioEntity inventario;



}
