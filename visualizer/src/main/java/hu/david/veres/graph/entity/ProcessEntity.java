package hu.david.veres.graph.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "processes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProcessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "process_identifier")
    private String processIdentifier;

    private boolean done;

    private boolean error;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "state_space_file_name")
    private String stateSpaceFileName;

    @Column(name = "solution_file_name")
    private String solutionFileName;

    @Column(name = "java_package_name")
    private String javaPackageName;

    private String name;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "search_algorithm")
    private String searchAlgorithm;

}
