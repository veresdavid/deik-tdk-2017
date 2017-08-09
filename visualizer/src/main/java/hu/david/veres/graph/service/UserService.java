package hu.david.veres.graph.service;

import hu.david.veres.graph.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	UserDTO getUserById(Long id);

	UserDTO getUserByUsername(String username);

	boolean isThereUserWithUsername(String username);

	boolean isThereUserWithEmail(String email);

	UserDTO save(UserDTO userDTO);

	void delete(UserDTO userDTO);

}
