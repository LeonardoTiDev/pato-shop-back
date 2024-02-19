package com.base.crudgrd.repositories;

import com.base.crudgrd.entity.CamionetaEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CamionetaRepository extends JpaRepository<CamionetaEntity, Integer> {

    List<CamionetaEntity> findByPedidoId(Integer idPedido);
}
