package br.com.school.educanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.school.educanet.entity.User;
import br.com.school.educanet.service.UserService;

@RestController
public class UsuarioController {
	@Autowired
	private final UserService userService;

    UsuarioController(UserService userService) {
        this.userService = userService;
    }
	
	@PostMapping("/registre-se")
	public ResponseEntity<String> saveUser(@RequestBody User user) {		
        return ResponseEntity.ok("Endpoint de validação de usuário");
	}

}
