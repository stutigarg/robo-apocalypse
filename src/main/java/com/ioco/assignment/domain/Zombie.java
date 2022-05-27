package com.ioco.assignment.domain;

import com.ioco.assignment.domain.base.LocatableEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
@lombok.Setter
@lombok.Getter
@Entity
/**
 * Thought:
 * <p>
 * Survivor and Zombie should be kept separate, because as lehman it makes sense to keep both separate. They are 2 different entities. Period.
 * Also, for zombies, definition for standard attributes may differ that we've for survivor, for example: gender, age (debatable).
 * Also, we don't know what happens with resources once a survivor turns into a zombie.
 * <p>
 * Thereby, whenever a survivor is reported to have contaminated 3 peers, make an entry to Zombies (and delete from Survivor).
 * This migration may look like an additional cost, but it'll help with all subsequent processes.
 */
public class Zombie extends LocatableEntity implements Serializable {

    private static final long serialVersionUID = -6853515541145301632L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_ZOMBIE")
    @SequenceGenerator(name = "SEQ_ID_ZOMBIE", allocationSize = 1)
    private Long id;
    
    private Long personId; // Good to have. Not a FK.
    // Other attributes that we've carried over from origin Survivor class

    private LocalDateTime transformedAt;

}
