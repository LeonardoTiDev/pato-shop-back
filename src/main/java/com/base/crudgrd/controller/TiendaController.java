package com.base.crudgrd.controller;


import com.base.crudgrd.infraestructure.abstract_service.ICamionetaService;
import com.base.crudgrd.infraestructure.abstract_service.ITiendaService;
import com.base.crudgrd.response.CamionetaResponse;
import com.base.crudgrd.response.TiendaResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "tienda")
@AllArgsConstructor
public class TiendaController {

    private final ITiendaService iTiendaService;

    @ResponseBody
    @GetMapping(value ="/lista")
    public ResponseEntity<List<TiendaResponse>> findAllTiendas(){
        List<TiendaResponse> prueba = iTiendaService.findAll();
        return ResponseEntity.ok(prueba);
    }

}
