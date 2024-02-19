package com.base.crudgrd.repositories;

import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.TiendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaRepository extends JpaRepository<TiendaEntity, Integer> {
}
