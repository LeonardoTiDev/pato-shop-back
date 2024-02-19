package com.base.crudgrd.controller;


import com.base.crudgrd.infraestructure.abstract_service.ICamionetaService;

import com.base.crudgrd.response.CamionetaResponse;
import com.base.crudgrd.response.InventarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "camionta")
@AllArgsConstructor
public class CamionetaController {

    private final ICamionetaService camionetaService;

    @ResponseBody
    @GetMapping(value ="/lista")
    public ResponseEntity<List<CamionetaResponse>> findAllCamionta(){
        List<CamionetaResponse> prueba = camionetaService.findAll();
        return ResponseEntity.ok(prueba);
    }
}
