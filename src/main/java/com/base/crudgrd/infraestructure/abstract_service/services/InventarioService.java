//package com.base.crudgrd.infraestructure.abstract_service.services;
//
//import com.base.crudgrd.entity.CamionetaEntity;
//import com.base.crudgrd.entity.InventarioEntity;
//import com.base.crudgrd.infraestructure.abstract_service.IInventarioService;
//import com.base.crudgrd.repositories.CamionetaRepository;
//import com.base.crudgrd.repositories.InventarioRepository;
//import com.base.crudgrd.request.InventarioRequest;
//import com.base.crudgrd.response.InventarioResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Transactional
//@Service
//@Slf4j
//public class InventarioService implements IInventarioService {
//
//    private final CamionetaRepository camionetaRepository;
//    private final InventarioRepository inventarioRepository;
//
//    public InventarioService(CamionetaRepository camionetaRepository, InventarioRepository inventarioRepository) {
//        this.camionetaRepository = camionetaRepository;
//        this.inventarioRepository = inventarioRepository;
//    }
//
//
//    @Override
//    public InventarioResponse create(InventarioRequest request) {
//        return null;
//    }
//
//    @Override
//    public InventarioResponse find(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public List<InventarioResponse> findAll() {
//        List<InventarioEntity> inventarios = inventarioRepository.findAll();
//         return inventarios.stream()
//                .map(this::mapInventarioEntityToResponse)
//                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public InventarioResponse update(InventarioRequest request, Integer integer) {
//        return null;
//    }
//
//    @Override
//    public void delete(Integer integer) {
//
//    }
//
//    InventarioResponse inventarioEntityToResponse(InventarioEntity inventarioEntity){
//        var response = new InventarioResponse();
//        BeanUtils.copyProperties(inventarioEntity, response);
//        var responseCamioneta = new CamionetaEntity();
//        BeanUtils.copyProperties(inventarioEntity.getCamioneta(), responseCamioneta);
//        response.setCamioneta(responseCamioneta);
//        return response;
//    }
//
//    private InventarioResponse mapInventarioEntityToResponse(InventarioEntity inventarioEntity) {
//        InventarioResponse response = new InventarioResponse();
//        BeanUtils.copyProperties(inventarioEntity, response);
//        if (inventarioEntity.getCamioneta() != null) {
//            CamionetaEntity responseCamioneta = new CamionetaEntity();
//            BeanUtils.copyProperties(inventarioEntity.getCamioneta(), responseCamioneta);
//            response.setCamioneta(responseCamioneta);
//        }
//
//        return response;
//    }
//
//
//}
