package br.com.school.educanet.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.school.educanet.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User>
	findByEmail(String UsuarioEmail);
		Optional<User>
	 findBySenha(String UsuarioSenha);
}