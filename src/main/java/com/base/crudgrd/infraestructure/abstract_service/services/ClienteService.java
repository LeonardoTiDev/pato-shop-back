package com.base.crudgrd.infraestructure.abstract_service.services;


import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.ClienteEntity;
import com.base.crudgrd.entity.TiendaEntity;
import com.base.crudgrd.infraestructure.abstract_service.IClienteService;
import com.base.crudgrd.repositories.CamionetaRepository;
import com.base.crudgrd.repositories.ClienteRepository;
import com.base.crudgrd.request.CamionetaRequest;
import com.base.crudgrd.request.ClienteRequest;
import com.base.crudgrd.response.CamionetaResponse;
import com.base.crudgrd.response.ClienteResponse;
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
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    private ClienteResponse mapClienteEntityToResponse(ClienteEntity clienteEntity) {

        ClienteResponse response = new ClienteResponse();
        BeanUtils.copyProperties(clienteEntity, response);
//        if (camionetaEntity.getInventario() != null) {
//            InventarioEntity responseInventario = new InventarioEntity();
//            BeanUtils.copyProperties(camionetaEntity.getInventario(), responseInventario);
//            response.setInventario(responseInventario);
//            System.out.println(1);
//        }
        return response;
    }

    @Override
    public ClienteResponse create(ClienteRequest request) {
        return null;
    }

    @Override
    public ClienteResponse find(Integer integer) {
        return null;
    }

    @Override
    public List<ClienteResponse> findAll() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(this::mapClienteEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponse update(ClienteRequest request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
