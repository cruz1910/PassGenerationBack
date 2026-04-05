package com.example.passgeneration.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import com.example.passgeneration.Service.AuthService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Map<String, String> body) {

        service.signup(
                body.get("nome"),
                body.get("email"),
                body.get("password"),
                body.get("confirmPassword"));

        return ResponseEntity.ok("Usuário criado");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody Map<String, String> body) {

        String token = service.signin(
                body.get("email"),
                body.get("password"));

        return ResponseEntity.ok(Map.of("token", token));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @GetMapping("/signout")
    public ResponseEntity<?> signout() {
        return ResponseEntity.ok("Logout feito");
    }
}