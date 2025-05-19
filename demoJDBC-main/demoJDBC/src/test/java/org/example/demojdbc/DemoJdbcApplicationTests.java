package org.example.demojdbc;

import jakarta.transaction.Transactional;
import org.example.demojdbc.controller.ProductoController;
import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Sql({"/schema.sql"}) // Asegúrate de tener este archivo en tu directorio de recursos para crear la tabla
class DemoJdbcApplicationTests {

    @Autowired
    ProductoRepository repositorio;

    @Test
    void borrarTodos() {
        repositorio.borrarTodos();
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarProducto() {
        Producto producto = new Producto(100, "Teclado", 29.99);
        repositorio.insertar(producto);
        producto = new Producto(200, "Ratón", 19.99);
        repositorio.insertar(producto);
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarTodos() {
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }


    @Transactional
    public void borrar(Producto producto) {
        String sql = "DELETE FROM producto WHERE id = ?";
        repositorio.update(sql, producto.getId());
    }
 
    @Test
    void insertarYBuscarProducto() {
        // Asegúrate de que el nombre no sea null
        Producto producto = new Producto(1, "Teclado", 29.99);  // Aquí "Teclado" es el nombre, que no debe ser null

        // Insertar el producto
        ProductoController ProductoRepository;
        ProductoController.insertar(producto);

        // Buscar el producto por id
        Producto productoRecuperado = ProductoController.buscarUno(1);

        // Verificar que el producto recuperado no sea null
        assertNotNull(productoRecuperado);

        // Verificar que el nombre y el precio sean correctos
        assertEquals("Teclado", productoRecuperado.getNombre());
        assertEquals(29.99, productoRecuperado.getPrecio(), 0.01);
    }
}
