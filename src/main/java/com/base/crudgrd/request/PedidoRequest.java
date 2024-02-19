package com.base.crudgrd.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PedidoRequest implements Serializable {

    Integer idCliente;
    String statusPedido;
    BigDecimal total;
    Integer idTienda;
    BigDecimal totalUnidades;
    Map<Integer, BigDecimal> macthCamCantidad;
}
