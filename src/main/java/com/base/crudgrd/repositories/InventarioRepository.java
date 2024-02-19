package com.base.crudgrd.repositories;

import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<InventarioEntity, Integer> {
}
