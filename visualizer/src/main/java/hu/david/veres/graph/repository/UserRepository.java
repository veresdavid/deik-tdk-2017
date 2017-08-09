package hu.david.veres.graph.repository;

import hu.david.veres.graph.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);

	UserEntity findByEmail(String email);

}
