package hu.david.veres.graph.service;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.entity.ProcessEntity;
import hu.david.veres.graph.repository.ProcessRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private ProcessRepository processRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Transactional(readOnly = true)
	@Override
	public ProcessDTO getProcessByIdentifier(String processIdentifier) {

		ProcessEntity processEntity = processRepository.findByProcessIdentifier(processIdentifier);

		if (processEntity == null) {
			return null;
		}

		return modelMapper.map(processEntity, ProcessDTO.class);

	}

	@Transactional(readOnly = true)
	@Override
	public List<ProcessDTO> getProcessesByUserId(Long id) {

		if (id == null) {
			return null;
		}

		List<ProcessEntity> processEntities = processRepository.findByUserId(id);

		if (processEntities == null) {
			return null;
		}

		Type listType = new TypeToken<List<ProcessDTO>>() {
		}.getType();

		return modelMapper.map(processEntities, listType);

	}

	@Transactional
	@Override
	public ProcessDTO save(ProcessDTO processDTO) {

		ProcessEntity processEntity = modelMapper.map(processDTO, ProcessEntity.class);

		ProcessEntity savedEntity = processRepository.save(processEntity);

		return modelMapper.map(savedEntity, ProcessDTO.class);

	}

	@Transactional
	@Override
	public void delete(ProcessDTO processDTO) {

		if (processDTO == null) {
			return;
		}

		// TODO: stop thread if running?

		// TODO: delete files

		ProcessEntity processEntity = modelMapper.map(processDTO, ProcessEntity.class);

		processRepository.delete(processEntity);

	}

}
