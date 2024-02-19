package com.base.crudgrd.controller;


import com.base.crudgrd.infraestructure.abstract_service.ICamionetaService;
import com.base.crudgrd.infraestructure.abstract_service.IClienteService;
import com.base.crudgrd.response.CamionetaResponse;
import com.base.crudgrd.response.ClienteResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "cliente")
@AllArgsConstructor
public class ClienteController {

    private final IClienteService IClienteService;

    @ResponseBody
    @GetMapping(value ="/lista")
    public ResponseEntity<List<ClienteResponse>> findAllClientes(){
        List<ClienteResponse> prueba = IClienteService.findAll();
        return ResponseEntity.ok(prueba);
    }
}
