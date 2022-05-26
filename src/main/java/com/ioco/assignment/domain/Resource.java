package com.ioco.assignment.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A survivor also has an inventory of resources (which you need to declare upon the registration of the survivor).
 * This can include Water, Food, Medication and Ammunition
 * <p>
 * Thought: I would opt for below arrangement, provided we've different details to maintain in inventory per resource type.
 * <p>
 * 1. Resource could be defined as an abstract type
 * 2. With Water, Food, Medication and Ammunition representing the concrete sub-classes.
 * <p>
 * The arrangement suits when we keep different inventory details per resource type.
 * Example: Quantity (in litres) for water; Disease, quantity etc. for medication and so on.
 */
@Entity
@Table(name = "RESOURCES")

@lombok.Getter
@lombok.Setter
public class Resource implements Serializable {

    public static final long serialVersionUID = -7749077614744449271L;

    public enum ResourceType {
        WATER,
        FOOD,
        MEDICATION,
        AMMUNITION
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_RESOURCES")
    @SequenceGenerator(name = "SEQ_ID_RESOURCES", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Resource.ResourceType resourceType;

    /**
     * For simplicity, assuming we only maintain quantity for each resource type.
     * Quantity can be read as different depending upon the context.
     * Example: For water - it's litres, for food - it's number of servings for single person etc.
     */
    private Integer quantity;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_RESOURCES_SURVIVOR_ID"), nullable = false)
    private Survivor survivor;

}
