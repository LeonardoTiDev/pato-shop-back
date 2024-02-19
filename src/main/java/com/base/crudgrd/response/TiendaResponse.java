package com.base.crudgrd.response;

import com.base.crudgrd.entity.InventarioEntity;
import com.base.crudgrd.entity.PedidoEntity;
import com.base.crudgrd.entity.VendedorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TiendaResponse  implements Serializable {

    public Integer idTienda;
    private String codigoTienda;
    private String direccion;
    private String telefono;
    private LocalDate createdAt;
    private Timestamp updateAt;


}
