package br.com.school.educanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.school.educanet.entity.User;
import br.com.school.educanet.service.ValidationService;

public class ValidationController {
	@Autowired
    private final ValidationService validationService;

    public ValidationController(ValidationService  validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/validate-user")
    public ResponseEntity<String> validateUser(@RequestBody User user) {
        return ResponseEntity.ok("Endpoint de validação de usuário");
    }
}
