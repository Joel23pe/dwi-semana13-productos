package pe.utp.backend_productos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pe.utp.backend_productos.model.Producto;
import pe.utp.backend_productos.repository.ProductoRepository;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repo;

    @GetMapping
    public List<Producto> listar() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto p) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(p));
    }
}