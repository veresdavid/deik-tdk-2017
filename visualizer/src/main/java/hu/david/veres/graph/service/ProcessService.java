package hu.david.veres.graph.service;

import hu.david.veres.graph.dto.ProcessDTO;

public interface ProcessService {

    ProcessDTO getProcessByIdentifier(String processIdentifier);

    ProcessDTO save(ProcessDTO processDTO);

}
