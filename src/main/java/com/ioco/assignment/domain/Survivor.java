package com.ioco.assignment.domain;

import com.ioco.assignment.domain.base.LocatableEntity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SURVIVOR")
@lombok.Getter
@lombok.Setter
public class Survivor extends LocatableEntity implements Serializable {
    private static final long serialVersionUID = -6588913283847200032L;

    public enum Gender {
        MALE,
        FEMALE,
        UNKNOWN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_SURVIVOR")
    @SequenceGenerator(name = "SEQ_ID_SURVIVOR", allocationSize = 1)
    private Long id;


    @NotBlank
    private String name;
    @Positive
    private int age;
    @NotNull
    private Gender gender;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "survivor",cascade = CascadeType.ALL)
    private List<Resource> resources;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "CONTAMINATION_DETAILS",
            joinColumns = {@JoinColumn(name = "SURVIVOR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CONTAMINATED_ID")},
            uniqueConstraints = @UniqueConstraint(name = "uq_survivorContaminated",
                    columnNames = {"SURVIVOR_ID", "CONTAMINATED_ID"})
    )
    private Set<Survivor> contaminated = new HashSet<>();

    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
