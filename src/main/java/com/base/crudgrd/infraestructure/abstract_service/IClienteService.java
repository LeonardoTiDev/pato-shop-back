package com.base.crudgrd.infraestructure.abstract_service;

import com.base.crudgrd.request.CamionetaRequest;
import com.base.crudgrd.request.ClienteRequest;
import com.base.crudgrd.response.CamionetaResponse;
import com.base.crudgrd.response.ClienteResponse;

public interface IClienteService extends CrudService< ClienteRequest, ClienteResponse, Integer> {
}
