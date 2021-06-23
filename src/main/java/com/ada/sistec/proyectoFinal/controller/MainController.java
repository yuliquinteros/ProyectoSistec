package com.ada.sistec.proyectoFinal.controller;

import com.ada.sistec.proyectoFinal.model.*;
import com.ada.sistec.proyectoFinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/proyecto/sistec")
public class MainController {

    @Autowired //inyecta/trae el repository, porque voy a operar con él
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OperacionRepository operacionRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private TipoProdRepository tipoProdRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private RemitoRepository remitoRepository;


    // - READ
    @GetMapping(path = "/rol/all")
    public @ResponseBody
    Iterable<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @GetMapping(path = "/rol/{id}")
    public @ResponseBody
    Optional<Rol> getRolById(@PathVariable("id") int id) {
        return rolRepository.findById(id);
    }

    @GetMapping(path = "/usuario/all")
    public @ResponseBody
    Iterable<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping(path = "/usuario/{id}")
    public @ResponseBody
    Optional<Usuario> getUsuarioById(@PathVariable("id") int id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping(path = "/operacion/all")
    public @ResponseBody
    Iterable<Operacion> getAllOperaciones() {
        return operacionRepository.findAll();
    }

    @GetMapping(path = "/operacion/{id}")
    public @ResponseBody
    Optional<Operacion> getOperacionById(@PathVariable("id") int id) {
        return operacionRepository.findById(id);
    }

    @GetMapping(path = "/proveedor/all")
    public @ResponseBody
    Iterable<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @GetMapping(path = "/proveedor/{id}")
    public @ResponseBody
    Optional<Proveedor> getProveedorById(@PathVariable("id") int id) {
        return proveedorRepository.findById(id);
    }

    @GetMapping(path = "/tipoprod/all")
    public @ResponseBody
    Iterable<TipoProd> getAllTipoProd() {
        return tipoProdRepository.findAll();
    }

    @GetMapping(path = "/tipoprod/{id}")
    public @ResponseBody
    Optional<TipoProd> getTipoProdById(@PathVariable("id") int id) {
        return tipoProdRepository.findById(id);
    }

    @GetMapping(path = "/producto/all")
    public @ResponseBody
    Iterable<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @GetMapping(path = "/producto/{id}")
    public @ResponseBody
    ResponseEntity<ProductoResponse> getProductoById(@PathVariable("id") int id) {
        ProductoResponse response = new ProductoResponse();
        try {
            response.setProducto(productoRepository.findById(id).get());
            response.setMensaje("Encontrado!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            //response.setProducto(productoRepository.findById(1).get());
            response.setProducto(null);
            response.setMensaje("Id del producto no encontrado: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/remito/all")
    public @ResponseBody
    Iterable<Remito> getAllRemitos() {
        return remitoRepository.findAll();
    }

    @GetMapping(path = "/remito/{id}")
    public @ResponseBody
    Optional<Remito> getRemitoById(@PathVariable("id") int id) {
        return remitoRepository.findById(id);
    }


    // ========= CONSULTAS PERSONALIZADA -- CUSTOM QUERIES

    @GetMapping(path = "/producto/nombre/like/{nombreProd}")
    public @ResponseBody
    Iterable<Producto> getProductosByNombre(@PathVariable("nombreProd") String nombreProd) {
        return productoRepository.getProductosByNombre(nombreProd);
    }


    @GetMapping(path = "/proveedor/nombre/like/{nombre}")
    public @ResponseBody
    Iterable<Proveedor> getProveedorByName(@PathVariable("nombre") String nombre) {
        return proveedorRepository.getProveedorByName(nombre);
    }

    @GetMapping(path = "/remito/pordia/{day}")
    public @ResponseBody
    Iterable<Remito> getRemitoByDate(@PathVariable("day") int day) {
        return remitoRepository.getRemitoByDate(day);
    }

    @GetMapping(path = "/remito/porMesyDia/{month}/{day}")
    public @ResponseBody
    Iterable<Remito> getRemitoByDate(@PathVariable("month") int month, @PathVariable("day") int day) {
        return remitoRepository.getRemitoByDate(month, day);
    }

    @GetMapping(path = "/usuario/nombre/{nom_y_ap}")
    public @ResponseBody
    Iterable<Usuario> getUsuarioByName(@PathVariable("nom_y_ap") String nom_y_ap) {
        return usuarioRepository.getUsuarioByName(nom_y_ap);
    }


    //-CREATE
    @PostMapping(path = "/producto/create", consumes = "application/json", produces = "application/json")
    public Producto createProducto(@RequestBody Producto nuevoproducto) {
        return productoRepository.save(nuevoproducto);
    }

    @PostMapping(path = "/tipoprod/create", consumes = "application/json", produces = "application/json")
    public TipoProd createTipoProd(@RequestBody TipoProd nuevotipo) {
        return tipoProdRepository.save(nuevotipo);
    }

    @PostMapping(path = "/proveedor/create", consumes = "application/json", produces = "application/json")
    public Proveedor createProveedor(@RequestBody Proveedor nuevoprov) {
        return proveedorRepository.save(nuevoprov);
    }

    @PostMapping(path = "/remito/create", consumes = "application/json", produces = "application/json")
    public Remito createRemito(@RequestBody Remito nuevoremito) {
        return remitoRepository.save(nuevoremito);
    }



    //-UPDATE

    @PutMapping(path = "/tipoprod/update", consumes = "application/json", produces = "application/json")
    public TipoProd updateTipoProd(@RequestBody TipoProd updateTipoProd) {
        return tipoProdRepository.save(updateTipoProd);
    }

    @PutMapping(path = "/producto/update", consumes = "application/json", produces = "application/json")
    public Producto updateProducto(@RequestBody Producto corregirProducto) {
        return productoRepository.save(corregirProducto);
    }

    @PutMapping(path = "/producto/{id}/update/proveedor/{id_proveedor}")
    public Producto updateProveedor(@PathVariable("id") int id, @PathVariable("id_proveedor") int id_proveedor) {

        Producto producto = productoRepository.findById(id).get();
        Proveedor proveedor = proveedorRepository.findById(id_proveedor).get();

        producto.setProveedor(proveedor);
        productoRepository.save(producto);

        return producto;
    }


    @PutMapping(path = "/user/{userId}/proveedor/updateByRole")
    public ResponseEntity<GeneralResponse> updateProveedorByRole(@PathVariable("userId") String userId, @RequestBody Proveedor updateProveedor) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Rol> roles = rolRepository.getRolesByUser(userId);

            for (Rol r : roles) {
                if (r.getNombre().equals("Supervisor/a")) {
                    proveedorRepository.save(updateProveedor);
                    response.setCode(HttpStatus.OK.value());
                    response.setMensaje("El proveedor " + updateProveedor.getNombre() + " fue actualizado con éxito!");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMensaje("Usuario no autorizado a actualizar proveedores");
            return ResponseEntity.ok(response);

        } catch (Exception e) {

            response.setCode(HttpStatus.CONFLICT.value());
            response.setMensaje(HttpStatus.CONFLICT.getReasonPhrase());
            return ResponseEntity.badRequest().body(response);
        }

    }

    //-DELETE
    @DeleteMapping(path = "/usuario/{id_user}/producto/borrar2/{id_prod}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deleteProductoById2(@PathVariable("id_user") String id_user, @PathVariable("id_prod") int id_prod) {

        GeneralResponse response = new GeneralResponse();

        Collection<Rol> rolesByUser = rolRepository.getRolesByUser(id_user);
        for (Rol r : rolesByUser) {
            if (r.getNombre().equals("Supervisor/a")) {

                productoRepository.deleteById(id_prod);
                response.setCode(200);
                response.setMensaje("Fue eliminado el producto id: " + id_prod + " correctamente");
                return ResponseEntity.ok(response);
            }
        }
        response.setCode(401);
        response.setMensaje("Usuario no autorizado a eliminar productos");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/usuario/{id_user}/proveedor/borrar/{id_proveedor}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deleteProveedorById2(@PathVariable("id_user") String id_user, @PathVariable("id_proveedor") int id_proveedor) {

        GeneralResponse response = new GeneralResponse();

        Collection<Rol> rolesByUser = rolRepository.getRolesByUser(id_user);
        for (Rol r : rolesByUser) {
            if (r.getNombre().equals("Supervisor/a")) {

                proveedorRepository.deleteById(id_proveedor);
                response.setCode(200);
                response.setMensaje("Fue eliminado el proveedor id: " + id_proveedor + " correctamente");
                return ResponseEntity.ok(response);
            }
        }
        response.setCode(403);
        response.setMensaje("Usuario no autorizado a eliminar proveedores");
        return ResponseEntity.ok(response);
    }

}
