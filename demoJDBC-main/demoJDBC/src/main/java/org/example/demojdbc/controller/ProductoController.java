package org.example.demojdbc.controller;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public static void insertar(@RequestBody Producto producto) {
        repo.insertar(producto);
    }

    @GetMapping
    public List<Producto> buscarTodos() {
        return repo.buscarTodos();
    }

    @GetMapping("/{id}")
    public static Producto buscarUno(@PathVariable int id) {
        return repo.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void borrarUno(@PathVariable int id) {
        repo.borrarPorId(id);
    }

    @DeleteMapping
    public void borrarTodos() {
        repo.borrarTodos();
    }
}
