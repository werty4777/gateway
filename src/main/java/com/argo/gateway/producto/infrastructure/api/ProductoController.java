package com.argo.gateway.producto.infrastructure.api;

import com.argo.gateway.producto.application.OrdenCompraService;
import com.argo.gateway.producto.application.ProductoService;
import com.argo.gateway.producto.application.models.detalles.ordenCompramodeloDetalles;
import com.argo.gateway.producto.application.models.ordenCompraModel;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping({"/inventario/producto","/api/inventario/producto"})
public class ProductoController {


    public static final String AUTH = "Authorization";

    private final OrdenCompraService ordenCompraService;
    private final ProductoService productoService;

    public ProductoController(OrdenCompraService ordenCompraService, ProductoService productoService) {
        this.ordenCompraService = ordenCompraService;
        this.productoService = productoService;
    }

    @GetMapping("")
    public List cargarListaProductos(HttpServletRequest request) {


        String token = request.getHeader("Authorization");

        return this.productoService.listaCodigoProductos(token);

    }

    @GetMapping("/todos")
    public List todos(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return this.productoService.todos2(token);
    }


    @PostMapping("/orden")
    public void crearOrdenCompra(HttpServletRequest request, @RequestBody ordenCompraModel modelo) {

        String token = request.getHeader(AUTH);


        this.ordenCompraService.crearOrdenCompraNuevo(token, modelo);

    }

    @PostMapping("/orden/{id}")
    public void confirmarOrden(HttpServletRequest request, @PathVariable("id") String id) {
        String token = request.getHeader("Authorization");

        this.ordenCompraService.confirmarOrdenCompra(id, token);

    }


    @GetMapping("/{id}/{almacen}")
    public List buscarPorNombre(HttpServletRequest request, @PathVariable("id") String codigo, @PathVariable("almacen") int almacen) {


        String token = request.getHeader(AUTH);


        return this.productoService.buscarPorNombre(almacen, codigo);
    }

    @GetMapping("/orden")
    public List misOrdenesDeCompra(HttpServletRequest request) {


        String token = request.getHeader("Authorization");


        return this.ordenCompraService.misOrdenes(token);

    }

    @GetMapping("/orden/{id}")
    public ordenCompramodeloDetalles detallesOrden(HttpServletRequest request, @PathVariable("id") String id) {

        String token = request.getHeader("Authorization");


        return this.ordenCompraService.detalesOrden(token, id);

    }

    @GetMapping("/nombres")
    public List nombresLista(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaNombres();

    }

    @GetMapping("/tipo")
    public List tipo(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaTipo();

    }

    @GetMapping("/modelo")
    public List modelo(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaModelo();

    }

    @GetMapping("/marca")
    public List marca(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaMarca();

    }

    @GetMapping("/color")
    public List color(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaColor();

    }

    @GetMapping("/talla")
    public List talla(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        return this.productoService.listaTalla();

    }

    @GetMapping("/precio")
    public List precio(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaPrecio();

    }

    @PostMapping("/unidad")
    public List unidad(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaUnidadMedida();

    }


}
