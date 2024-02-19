package com.base.crudgrd.repositories;

import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<VendedorEntity, Integer> {
}
