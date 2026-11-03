package pe.utp.backend_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.utp.backend_productos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}