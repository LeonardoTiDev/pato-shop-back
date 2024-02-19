package com.base.crudgrd.config;


import com.base.crudgrd.entity.*;
import com.base.crudgrd.repositories.*;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Component
@Slf4j
public class Init implements ApplicationListener<ApplicationReadyEvent> {

    private final CamionetaRepository camionetaRepository;
    private final ClienteRepository clienteRepository;
    private final InventarioRepository inventarioRepository;
    private final PedidoRepository pedidoRepository;
    private final TiendaRepository tiendaRepository;
    private final VendedorRepository vendedorRepository;

    public Init(CamionetaRepository camionetaRepository,
                ClienteRepository clienteRepository,
                InventarioRepository inventarioRepository,
                PedidoRepository pedidoRepository,
                TiendaRepository tiendaRepository,
                VendedorRepository vendedorRepository) {
        this.camionetaRepository = camionetaRepository;
        this.clienteRepository = clienteRepository;
        this.inventarioRepository = inventarioRepository;
        this.pedidoRepository = pedidoRepository;
        this.tiendaRepository = tiendaRepository;
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        if(clienteRepository.findAll().isEmpty()){
            List<ClienteEntity> listCliente = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                ClienteEntity cliente = ClienteEntity.builder()
                        .nombreUsuario("Usuario" + i)
                        .nombre("Nombre" + i)
                        .apellidoPaterno("ApellidoPaterno" + i)
                        .apellidoMaterno("ApellidoMaterno" + i)
                        .dni("DNI" + i)
                        .email("email" + i + "@example.com")
                        .createdAt(LocalDate.now())
                        .updateAt(new Timestamp(System.currentTimeMillis()))
                        .build();

                // No llenar el campo "pedidos"
                cliente.setPedidos(new HashSet<>());

                // Id se generará automáticamente debido a la estrategia de generación de identificación
                //System.out.println(cliente);
                listCliente.add(cliente);

            }
            clienteRepository.saveAll(listCliente);
            log.info("Clientes creados correctamente");


        }

        if(tiendaRepository.findAll().isEmpty()){
            List<TiendaEntity> listTiendas = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                TiendaEntity tienda = TiendaEntity.builder()
                        .codigoTienda("CodigoTienda" + i)
                        .direccion("Direccion" + i)
                        .telefono("Telefono" + i)
                        .createdAt(LocalDate.now())
                        .updateAt(new Timestamp(System.currentTimeMillis()))
                        .vendedores(new HashSet<>())
                        //.inventario(null)  // Inventario vacío
                        .pedidos(new HashSet<>())
                        .build();

                tienda.setInventarios(new HashSet<>());
                tienda.setPedidos(new HashSet<>());
                // Id se generará automáticamente debido a la estrategia de generación de identificación
                //System.out.println(tienda);
                listTiendas.add(tienda);
            }
            tiendaRepository.saveAll(listTiendas);
            log.info("Tiendas creadas correctamente");
        }

        if(vendedorRepository.findAll().isEmpty()){
            List<VendedorEntity> listVendedor = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                Random random = new Random();
                VendedorEntity vendedor = VendedorEntity.builder()
                        .codigoVendedor("CodigoVendedor" + i)
                        .ipusuario("IPUsuario" + i)
                        .nombre("Nombre" + i)
                        .apellidoPaterno("ApellidoPaterno" + i)
                        .apellidoMaterno("ApellidoMaterno" + i)
                        .dni("DNI" + i)
                        .email("email" + i + "@example.com")
                        .createdAt(LocalDate.now())
                        .updateAt(new Timestamp(System.currentTimeMillis()))
                        .tienda(tiendaRepository.findById(random.nextInt(20) + 1).orElseThrow())
                        .build();

                // Id se generará automáticamente debido a la estrategia de generación de identificación
                //System.out.println(vendedor);

                listVendedor.add(vendedor);
            }
            vendedorRepository.saveAll(listVendedor);
            log.info("Vendedores Creados correctamente");
        }

        if(camionetaRepository.findAll().isEmpty()){
            List<CamionetaEntity> listCamioneta = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                CamionetaEntity camioneta = CamionetaEntity.builder()
                        .identificadorHAWA("Hawa-" + generateRandomString(6))  // Genera una cadena aleatoria de 6 caracteres
                        .precioLista(generateRandomBigDecimal(350000, 1650000)) // Genera un número aleatorio entre 350000 y 1650000
                        .descuento(new BigDecimal(12))  // Genera un número aleatorio entre 5 y 15
                        .motor(getRandomMotor())  // Elige aleatoriamente entre "Gasolina" y "Diesel"
                        .cilindros(getRandomCilindros())  // Elige aleatoriamente entre 4, 6 u 8
                        .color(getRandomColor())  // Elige aleatoriamente un color
                        .estatusInventario(1)  // Establece el valor de estatusInventario en 1
                        .createdAt(LocalDate.now())
                        .updateAt(new Timestamp(System.currentTimeMillis()))
                        .quantity(1)
                        .build();

               // System.out.println(camioneta);
                listCamioneta.add(camioneta);
            }
            camionetaRepository.saveAll(listCamioneta);
            log.info("Camionetas creadas correctamente ");
        }

        if(inventarioRepository.findAll().isEmpty()) {

            List<InventarioEntity> inventarioList = new ArrayList<>();
            List<TiendaEntity> tiendas = tiendaRepository.findAll();
            for (int i = 1; i <= 100; i++) {
                InventarioEntity inventario = InventarioEntity.builder()
                        .cantidadUnidades(generateRandomBigDecimal(0, 100))
                        .idTienda(generateRandomBigDecimalGer(1,99))
                        //.camioneta(camionetaRepository.findById(i).orElseThrow())
                        .build();

                // Id se generará automáticamente debido a la estrategia de generación de identificación
                //System.out.println(inventario);

                inventarioList.add(inventario);
            }
            inventarioRepository.saveAll(inventarioList);

            List<CamionetaEntity>ccamionetas = camionetaRepository.findAll();

            for (int i = 1; i < ccamionetas.size(); i++) {
                CamionetaEntity cam = ccamionetas.get(i);
                cam.setInventario(inventarioRepository.findById(i).get());
            }

            camionetaRepository.saveAll(ccamionetas);

            log.info("Inventarios creados correctamente ");
        }


    }

    private static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomString.append(chars.charAt(random.nextInt(chars.length())));
        }

        return randomString.toString();
    }

    private static BigDecimal generateRandomBigDecimal(int min, int max) {
        Random random = new Random();
        int randomValue = random.nextInt(max - min + 1) + min;
        return BigDecimal.valueOf(randomValue);
    }

    private static Integer generateRandomBigDecimalGer(int min, int max) {
        Random random = new Random();
        int randomValue = random.nextInt(max - min + 1) + min;
        return randomValue;
    }

    private static String getRandomMotor() {
        String[] opcionesMotor = {"Gasolina", "Diesel"};
        Random random = new Random();
        return opcionesMotor[random.nextInt(opcionesMotor.length)];
    }

    private static int getRandomCilindros() {
        int[] opcionesCilindros = {4, 6, 8};
        Random random = new Random();
        return opcionesCilindros[random.nextInt(opcionesCilindros.length)];
    }

    private static String getRandomColor() {
        String[] opcionesColor = {"Rojo", "Azul", "Verde", "Blanco", "Negro", "Gris", "Plateado", "Amarillo"};
        Random random = new Random();
        return opcionesColor[random.nextInt(opcionesColor.length)];
    }
    @Transactional
    private static Set<TiendaEntity> getRandomTiendas(List<TiendaEntity> tiendas) {
        Random random = new Random();
        int numberOfTiendas = random.nextInt(tiendas.size() + 1);  // Número aleatorio de tiendas (hasta todas)

        Set<TiendaEntity> tiendasAleatorias = new HashSet<>();
        for (int i = 0; i < numberOfTiendas; i++) {
            TiendaEntity tienda = tiendas.get(random.nextInt(tiendas.size()));
            tiendasAleatorias.add(tienda);
        }

        return tiendasAleatorias;
    }
}
