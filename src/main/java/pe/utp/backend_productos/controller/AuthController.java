package pe.utp.backend_productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pe.utp.backend_productos.security.JwtUtil;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
        if ("admin".equals(datos.get("username")) && "1234".equals(datos.get("password"))) {
            return ResponseEntity.ok(Map.of("token", jwtUtil.generar("admin")));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("mensaje", "Credenciales incorrectas"));
    }
}