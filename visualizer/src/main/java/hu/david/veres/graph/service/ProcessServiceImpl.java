package hu.david.veres.graph.service;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.entity.ProcessEntity;
import hu.david.veres.graph.repository.ProcessRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    @Override
    public ProcessDTO getProcessByIdentifier(String processIdentifier) {

        ProcessEntity processEntity = processRepository.findByProcessIdentifier(processIdentifier);

        if (processEntity == null) {
            return null;
        }

        return modelMapper.map(processEntity, ProcessDTO.class);

    }

    @Transactional
    @Override
    public ProcessDTO save(ProcessDTO processDTO) {

        ProcessEntity processEntity = modelMapper.map(processDTO, ProcessEntity.class);

        ProcessEntity savedEntity = processRepository.save(processEntity);

        return modelMapper.map(savedEntity, ProcessDTO.class);

    }

}
