package com.argo.gateway.producto.application;

import com.argo.gateway.almacen.domain.repository.IAlmacen;
import com.argo.gateway.producto.application.models.CodigoList;
import com.argo.gateway.producto.domain.CodigoProducto;
import com.argo.gateway.producto.domain.ProductoAlmacen;
import com.argo.gateway.producto.domain.repository.CodigoListNuevo;
import com.argo.gateway.producto.domain.repository.ICodigoProducto;
import com.argo.gateway.producto.domain.repository.IProduct;
import com.argo.gateway.producto.domain.repository.IType;
import com.argo.gateway.util.obtenerusuario;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class ProductoService {


    @Autowired
    private final ICodigoProducto iCodigoProducto;
    private final IProduct iProduct;
    private final IType iType;
    private final IAlmacen iAlmacen;

    @Autowired
    private obtenerusuario obtenerusuario;

    public ProductoService(ICodigoProducto iCodigoProducto, IProduct iProduct, IType iType, IAlmacen iAlmacen) {
        this.iCodigoProducto = iCodigoProducto;
        this.iProduct = iProduct;
        this.iType = iType;
        this.iAlmacen = iAlmacen;
    }


    public List listaCodigoProductos(String token) {


        int idAlmacen = this.obtenerusuario.getUser(token).getIdAlmacen().getIdAlmacen();
        return this.iCodigoProducto.listaCodigoProductosMovil(idAlmacen);


    }


    public List buscarPorNombre(int idalmacen, String codigo) {

        Almacen almacen = this.iAlmacen.findById(idalmacen).get();


        return this.iCodigoProducto.buscarPorNombre().stream().filter(productoAlmacen -> {

            String descripcion = productoAlmacen.getId().getCodigo().getDescripcion().toUpperCase();
            return productoAlmacen.getId().getIdAlmacen() == almacen && descripcion.contains(codigo.toUpperCase());


        }).map(productoAlmacen -> {

            CodigoProducto codigo1 = productoAlmacen.getId().getCodigo();
            return new CodigoList() {
                @Override
                public String getCodigo() {
                    return codigo1.getCodigo();
                }

                @Override
                public String getDescripcion() {
                    return codigo1.getDescripcion();
                }

                @Override
                public String getModelo() {
                    return codigo1.getModelo();
                }

                @Override
                public String getMarca() {
                    return codigo1.getMarca();
                }

                @Override
                public String getColor() {
                    return codigo1.getColor();
                }

                @Override
                public String getTalla() {
                    return codigo1.getTalla();
                }

                @Override
                public String getTipo() {
                    return codigo1.getTipo().getTipo();
                }

                @Override
                public int getCantidad() {
                    return productoAlmacen.getStock();
                }
            };


        }).collect(Collectors.toList());


    }

    public List todos(String token) {

        User user = this.obtenerusuario.getUser(token);
        Almacen idAlmacen = user.getIdAlmacen();
        return this.iProduct.listaEntera(idAlmacen);


    }

    public List todos2(String token) {
        User user = this.obtenerusuario.getUser(token);
        Almacen idAlmacen = user.getIdAlmacen();
        List<ProductoAlmacen> producto = this.iProduct.getProducto(idAlmacen.getIdAlmacen());
        List<ProductoAlmacen> producto2 = new ArrayList<>(producto);


        AtomicReference<List<ProductoAlmacen>> valoresRepetidos = new AtomicReference<>();
        valoresRepetidos.set(new ArrayList<>());
        return producto.stream().map(productoAlmacen -> {

            List<ProductoAlmacen> collect1 = producto2.stream().filter(pros -> pros.getId().getIndex().equals(productoAlmacen.getId().getIndex()) && pros.getId().getCodigo().equals(productoAlmacen.getId().getCodigo())).collect(Collectors.toList());

            if (!valoresRepetidos.get().contains(productoAlmacen)) {
                System.out.println("no lo contiene");
                valoresRepetidos.get().addAll(collect1);
                return collect1;
            }
            return null;

        }).filter(Objects::nonNull)

                .map(productoAlmacens -> {

                    int stock = productoAlmacens.stream().mapToInt(ProductoAlmacen::getStock).sum();
                    ProductoAlmacen productoAlmacen = productoAlmacens.get(productoAlmacens.size() - 1);


                    return new CodigoListNuevo() {
                        @Override
                        public String getCodigo() {
                            return productoAlmacen.getId().getCodigo().getCodigo();
                        }

                        @Override
                        public String getDescripcion() {
                            return productoAlmacen.getId().getCodigo().getDescripcion();
                        }

                        @Override
                        public String getModelo() {
                            return productoAlmacen.getId().getCodigo().getModelo();
                        }

                        @Override
                        public String getMarca() {
                            return productoAlmacen.getId().getCodigo().getMarca();
                        }

                        @Override
                        public String getColor() {
                            return productoAlmacen.getId().getCodigo().getColor();
                        }

                        @Override
                        public String getTalla() {
                            return productoAlmacen.getId().getCodigo().getTalla();
                        }

                        @Override
                        public String getTipo() {
                            return productoAlmacen.getId().getCodigo().getTipo().getTipo();

                        }

                        @Override
                        public BigDecimal getPrecio() {
                            return productoAlmacen.getId().getCodigo().getPrecioUnitario();
                        }

                        @Override
                        public int getCantidad() {
                            return stock;
                        }
                    };

                }).filter(Objects::nonNull).collect(Collectors.toList());

    }


    public List listaTipo() {


        return this.iCodigoProducto.listaTipo().stream().map(tipoProducto -> {
            Map mapa = new HashMap();
            mapa.put("tipo", tipoProducto.getTipo());
            mapa.put("id", tipoProducto.getIdTipo());
            return mapa;

        }).collect(Collectors.toList());


    }

    public List listaNombres() {


        return this.iCodigoProducto.findNombres().stream().map(s -> {


            Map mapa = new HashMap();
            mapa.put("nombre", s);
            return mapa;

        }).collect(Collectors.toList());


    }


    public List listaModelo() {


        return this.iCodigoProducto.listaModelo().stream().map(s -> {


            Map mapa = new HashMap();
            mapa.put("modelo", s);
            return mapa;


        }).collect(Collectors.toList());


    }


    public List listaMarca() {


        return this.iCodigoProducto.listaMarca().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("marca", s);
            return mapa;


        }).collect(Collectors.toList());

    }

    public List listaColor() {


        return this.iCodigoProducto.listaColor().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("color", s);
            return mapa;


        }).collect(Collectors.toList());

    }


    public List listaTalla() {


        return this.iCodigoProducto.listaTalla().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("talla", s);
            return mapa;


        }).collect(Collectors.toList());

    }


    public List listaPrecio() {


        return this.iCodigoProducto.listaPrecio().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("precio", s);
            return mapa;


        }).collect(Collectors.toList());

    }

    public List listaUnidadMedida() {


        return this.iCodigoProducto.listaUnidadMedida().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("unidad", s);
            return mapa;


        }).collect(Collectors.toList());

    }


}
