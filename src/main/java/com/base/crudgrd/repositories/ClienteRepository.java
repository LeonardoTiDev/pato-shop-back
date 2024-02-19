package com.base.crudgrd.repositories;

import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
