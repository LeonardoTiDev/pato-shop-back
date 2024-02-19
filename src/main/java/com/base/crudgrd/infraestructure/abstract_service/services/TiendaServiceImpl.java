package com.base.crudgrd.infraestructure.abstract_service.services;


import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.InventarioEntity;
import com.base.crudgrd.entity.TiendaEntity;
import com.base.crudgrd.infraestructure.abstract_service.ITiendaService;
import com.base.crudgrd.repositories.CamionetaRepository;
import com.base.crudgrd.repositories.TiendaRepository;
import com.base.crudgrd.request.TiendaRequest;
import com.base.crudgrd.response.CamionetaResponse;
import com.base.crudgrd.response.TiendaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
public class TiendaServiceImpl implements ITiendaService {

    private final TiendaRepository tiendaRepository;

    public TiendaServiceImpl(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }


    @Override
    public TiendaResponse create(TiendaRequest request) {
        return null;
    }

    @Override
    public TiendaResponse find(Integer integer) {
        return null;
    }

    @Override
    public List<TiendaResponse> findAll() {
        List<TiendaEntity> tiendas  = tiendaRepository.findAll();
        return tiendas.stream()
                .map(this::mapTiendaEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TiendaResponse update(TiendaRequest request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }


    private TiendaResponse mapTiendaEntityToResponse(TiendaEntity tiendaEntity) {

        TiendaResponse response = new TiendaResponse();
        BeanUtils.copyProperties(tiendaEntity, response);
//        if (camionetaEntity.getInventario() != null) {
//            InventarioEntity responseInventario = new InventarioEntity();
//            BeanUtils.copyProperties(camionetaEntity.getInventario(), responseInventario);
//            response.setInventario(responseInventario);
//            System.out.println(1);
//        }
        return response;
    }
}
