package hu.david.veres.graph.service;

import hu.david.veres.graph.dto.ProcessDTO;

import java.util.List;

public interface ProcessService {

    ProcessDTO getProcessByIdentifier(String processIdentifier);

    List<ProcessDTO> getProcessesByUserId(Long id);

    ProcessDTO save(ProcessDTO processDTO);

    void delete(ProcessDTO processDTO);

    List<ProcessDTO> getWaitingProcesses();

}
