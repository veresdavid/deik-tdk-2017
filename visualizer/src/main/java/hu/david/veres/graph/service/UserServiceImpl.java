package hu.david.veres.graph.service;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.dto.UserDTO;
import hu.david.veres.graph.entity.UserEntity;
import hu.david.veres.graph.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProcessService processService;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	@Override
	public UserDTO getUserById(Long id) {

		if (id == null) {
			return null;
		}

		UserEntity userEntity = userRepository.findOne(id);

		if (userEntity == null) {
			return null;
		}

		return modelMapper.map(userEntity, UserDTO.class);

	}

	@Transactional(readOnly = true)
	@Override
	public UserDTO getUserByUsername(String username) {

		if (username == null) {
			return null;
		}

		UserEntity userEntity = userRepository.findByUsername(username);

		if (userEntity == null) {
			return null;
		}

		return modelMapper.map(userEntity, UserDTO.class);

	}

	@Transactional(readOnly = true)
	@Override
	public boolean isThereUserWithUsername(String username) {

		if (username == null) {
			return false;
		}

		UserEntity userEntity = userRepository.findByUsername(username);

		if (userEntity == null) {
			return false;
		} else {
			return true;
		}

	}

	@Transactional(readOnly = true)
	@Override
	public boolean isThereUserWithEmail(String email) {

		if (email == null) {
			return false;
		}

		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null) {
			return false;
		} else {
			return true;
		}

	}

	@Transactional
	@Override
	public UserDTO save(UserDTO userDTO) {

		if (userDTO == null) {
			return null;
		}

		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

		UserEntity savedUserEntity = userRepository.save(userEntity);

		return modelMapper.map(savedUserEntity, UserDTO.class);

	}

	@Transactional
	@Override
	public void delete(UserDTO userDTO) {

		if (userDTO == null) {
			return;
		}

		List<ProcessDTO> processDTOS = processService.getProcessesByUserId(userDTO.getId());

		if (processDTOS != null) {
			for (ProcessDTO processDTO : processDTOS) {
				processService.delete(processDTO);
			}
		}

		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

		userRepository.delete(userEntity);

	}

}
