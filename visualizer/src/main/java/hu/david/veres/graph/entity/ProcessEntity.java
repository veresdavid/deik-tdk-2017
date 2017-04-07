package hu.david.veres.graph.entity;

import lombok.*;

import javax.persistence.*;

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

}
