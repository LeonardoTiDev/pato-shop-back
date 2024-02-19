package com.base.crudgrd.infraestructure.abstract_service.services;

import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.InventarioEntity;
import com.base.crudgrd.infraestructure.abstract_service.ICamionetaService;
import com.base.crudgrd.repositories.CamionetaRepository;
import com.base.crudgrd.request.CamionetaRequest;
import com.base.crudgrd.request.InventarioRequest;
import com.base.crudgrd.response.CamionetaResponse;
import com.base.crudgrd.response.InventarioResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Service
@Slf4j
public class CamionetaService implements ICamionetaService {

    private final CamionetaRepository camionetaRepository;

    public CamionetaService(CamionetaRepository camionetaRepository) {
        this.camionetaRepository = camionetaRepository;
    }


    @Override
    public CamionetaResponse create(CamionetaRequest request) {
        return null;
    }

    @Override
    public CamionetaResponse find(Integer integer) {
        return null;
    }

    @Override
    public List<CamionetaResponse> findAll() {
        List<CamionetaEntity> inventarios = camionetaRepository.findAll();
        return inventarios.stream()
                .map(this::mapCamionetaEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CamionetaResponse update(CamionetaRequest request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    private CamionetaResponse mapCamionetaEntityToResponse(CamionetaEntity camionetaEntity) {

        CamionetaResponse response = new CamionetaResponse();
        BeanUtils.copyProperties(camionetaEntity, response);
        if (camionetaEntity.getInventario() != null) {
            InventarioEntity responseInventario = new InventarioEntity();
            BeanUtils.copyProperties(camionetaEntity.getInventario(), responseInventario);
            response.setInventario(responseInventario);

        }
        return response;
    }
}
