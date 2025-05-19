package org.example.demojdbc.repository;

import org.example.demojdbc.model.Producto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertar(Producto producto) {
        jdbcTemplate.update("INSERT INTO producto (id, nombre, precio) VALUES (?, ?, ?)",
                producto.getId(), producto.getNombre(), producto.getPrecio());
    }


    public List<Producto> buscarTodos() {
        return jdbcTemplate.query("SELECT * FROM producto", new ProductoMapper());
    }

    public Producto buscarPorId(int id) {
        List<Producto> productos = jdbcTemplate.query("SELECT * FROM producto WHERE id = ?", new ProductoMapper(), id);
        return productos.isEmpty() ? null : productos.get(0);
    }

    @Transactional
    public void borrarPorId(int id) {
        jdbcTemplate.update("DELETE FROM producto WHERE id = ?", id);
    }

    @Transactional
    public void borrarTodos() {
        jdbcTemplate.update("DELETE FROM producto");
    }

    public void update(String sql, int id) {
    }
}
