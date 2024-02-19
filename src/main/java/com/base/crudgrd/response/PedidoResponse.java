package com.base.crudgrd.response;


import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.ClienteEntity;
import com.base.crudgrd.entity.TiendaEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PedidoResponse implements Serializable {

    public Integer idPedido;
    private String estatusPedido;
    private BigDecimal totalUnidades;
    private BigDecimal total;
    private BigDecimal totalDescuento;
    private LocalDateTime createdAt;
    public String nombreCliente;
    public String nombreTienda;
    public List<CamionetaResponse> camionetas ;

}
