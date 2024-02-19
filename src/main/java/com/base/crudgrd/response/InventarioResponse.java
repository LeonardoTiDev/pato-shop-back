package com.base.crudgrd.response;

import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.InventarioEntity;
import com.base.crudgrd.entity.PedidoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InventarioResponse implements Serializable {

    private Integer idInventario;
    private BigDecimal cantidadUnidades;
    private CamionetaEntity camioneta;

}
