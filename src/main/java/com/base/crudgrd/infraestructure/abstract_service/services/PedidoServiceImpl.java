package com.base.crudgrd.infraestructure.abstract_service.services;


import com.base.crudgrd.entity.CamionetaEntity;
import com.base.crudgrd.entity.InventarioEntity;
import com.base.crudgrd.entity.PedidoEntity;
import com.base.crudgrd.infraestructure.abstract_service.IPedidoService;
import com.base.crudgrd.repositories.CamionetaRepository;
import com.base.crudgrd.repositories.ClienteRepository;
import com.base.crudgrd.repositories.PedidoRepository;
import com.base.crudgrd.repositories.TiendaRepository;
import com.base.crudgrd.request.PedidoRequest;
import com.base.crudgrd.response.CamionetaResponse;
import com.base.crudgrd.response.PedidoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
public class PedidoServiceImpl implements IPedidoService {

    private final PedidoRepository pedidoRepository;
    private final CamionetaRepository camionetaRepository;

    private final ClienteRepository clienteRepository;

    private final TiendaRepository tiendaRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, CamionetaRepository camionetaRepository, ClienteRepository clienteRepository, TiendaRepository tiendaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.camionetaRepository = camionetaRepository;
        this.clienteRepository = clienteRepository;
        this.tiendaRepository = tiendaRepository;

    }

    @Override
    public PedidoResponse create(PedidoRequest request) {
        BigDecimal total = request.getTotal();
        BigDecimal porcentajeDescuento = new BigDecimal("0.10"); // 10%
        BigDecimal descuento = total.multiply(porcentajeDescuento);

        // Restamos el descuento del total
        BigDecimal totalConDescuento = total.subtract(descuento);
        PedidoEntity pedido = PedidoEntity.builder()
                .estatusPedido("1")
                .totalDescuento(totalConDescuento)
                .totalDescuento(totalConDescuento)
                .total(request.getTotal())
                .totalUnidades(request.getTotalUnidades())
                .cliente(clienteRepository.getReferenceById(request.getIdCliente()))
                .tienda(tiendaRepository.getReferenceById(request.getIdTienda())).build();

       PedidoEntity pedidoSave =  pedidoRepository.save(pedido);

        List<CamionetaEntity> camionetas = new ArrayList<>();


//        for (CamionetaEntity sub : camionetaRepository.findAll()) {
//            BigDecimal totalExistenuni = BigDecimal.valueOf(sub.getInventario().getIdInventario());
//            sub.getInventario().setIdInventario(totalExistenuni.subtract());
//
//        }
        Map<Integer, BigDecimal> miMapa = request.getMacthCamCantidad();

        for (Map.Entry<Integer, BigDecimal> entry : miMapa.entrySet()) {
            CamionetaEntity cam = camionetaRepository.getReferenceById(entry.getKey());
            BigDecimal totalExistenuni = cam.getInventario().getCantidadUnidades();
            cam.getInventario().setCantidadUnidades(totalExistenuni.subtract(entry.getValue()));
            cam.setPedidoId(pedidoSave.getIdPedido());
            camionetas.add(cam);
        }

        camionetaRepository.saveAll(camionetas);

        return mapPedidoEntityToResponse(pedidoSave);
    }

    @Override
    public PedidoResponse find(Integer integer) {
        return null;
    }

    @Override
    public List<PedidoResponse> findAll() {
        List<PedidoEntity> pediddos = pedidoRepository.findAll();
        return pediddos.stream()
                .map(this::mapPedidoEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoResponse update(PedidoRequest request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    private PedidoResponse mapPedidoEntityToResponse(PedidoEntity pedido) {
        List<CamionetaResponse> camsRs = camionetaRepository.findByPedidoId(pedido.getIdPedido()).stream()
                .map(this::mapCamionetaEntityToResponse)
                .collect(Collectors.toList());

        PedidoResponse response = new PedidoResponse();
        response.setIdPedido(pedido.getIdPedido());
        response.setEstatusPedido(pedido.getEstatusPedido());
        response.setTotalUnidades(pedido.getTotalUnidades());
        response.setTotal(pedido.getTotal());
        response.setTotalDescuento(pedido.getTotalDescuento());
        response.setCreatedAt(pedido.getCreatedAt());
        response.setNombreCliente(pedido.getCliente().getNombre());
        response.setNombreTienda(pedido.getTienda().getCodigoTienda());
        response.setCamionetas(camsRs);

        return response;
    }

    private CamionetaResponse mapCamionetaEntityToResponse(CamionetaEntity camionetaEntity) {

        CamionetaResponse response = new CamionetaResponse();
        BeanUtils.copyProperties(camionetaEntity, response);
        if (camionetaEntity.getInventario() != null) {
            InventarioEntity responseInventario = new InventarioEntity();
            BeanUtils.copyProperties(camionetaEntity.getInventario(), responseInventario);
            response.setInventario(responseInventario);
            System.out.println(1);
        }
        return response;
    }
}
