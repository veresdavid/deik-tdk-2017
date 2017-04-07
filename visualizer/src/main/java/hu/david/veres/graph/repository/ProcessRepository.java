package hu.david.veres.graph.repository;

import hu.david.veres.graph.entity.ProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepository extends JpaRepository<ProcessEntity, Long> {

    ProcessEntity findByProcessIdentifier(String processIdentifier);

}
