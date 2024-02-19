package com.base.crudgrd.repositories;

import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {
}
