package com.base.crudgrd.infraestructure.abstract_service;

import java.util.List;

public interface CrudService <RQ ,RS,ID>{

    RS create(RQ request);
    RS find(ID id);
    List<RS> findAll();
    RS update(RQ request, ID id);
    void delete(ID id);
}
