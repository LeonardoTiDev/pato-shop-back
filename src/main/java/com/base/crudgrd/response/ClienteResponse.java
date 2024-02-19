package com.base.crudgrd.response;


import com.base.crudgrd.entity.PedidoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ClienteResponse {

    public Integer idCliente;
    private String nombreUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String dni;
    private String email;
    private LocalDate createdAt;
    private Timestamp updateAt;

}
