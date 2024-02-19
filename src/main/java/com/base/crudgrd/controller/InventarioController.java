//package com.base.crudgrd.controller;
//
//
//import com.base.crudgrd.infraestructure.abstract_service.IInventarioService;
//import com.base.crudgrd.response.InventarioResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "inventario")
//@AllArgsConstructor
//public class InventarioController {
//
//    private final IInventarioService InventarioService;
//
//
//
//    @ResponseBody
//    @GetMapping(value ="/lista")
//    public ResponseEntity<List<InventarioResponse>> findAllInventario( ){
//        return ResponseEntity.ok(InventarioService.findAll());
//    }
//}
