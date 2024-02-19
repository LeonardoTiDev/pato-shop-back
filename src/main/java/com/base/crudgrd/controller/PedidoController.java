package com.base.crudgrd.controller;


import com.base.crudgrd.infraestructure.abstract_service.IClienteService;
import com.base.crudgrd.infraestructure.abstract_service.IPedidoService;
import com.base.crudgrd.request.PedidoRequest;
import com.base.crudgrd.response.ClienteResponse;
import com.base.crudgrd.response.PedidoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "pedido")
@AllArgsConstructor
public class PedidoController {

    private final IPedidoService IPedidoService;
    @ResponseBody
    @PostMapping(value ="/crear")
    public ResponseEntity<PedidoResponse> crearPedido(@RequestBody PedidoRequest pedidoRequest){
       PedidoResponse prueba = IPedidoService.create(pedidoRequest);
        return ResponseEntity.ok(prueba);
    }


    @GetMapping(value ="/lista")
    public ResponseEntity<List<PedidoResponse>> listarPedidos(){
        List<PedidoResponse> prueba = IPedidoService.findAll();
        return ResponseEntity.ok(prueba);
    }

}
