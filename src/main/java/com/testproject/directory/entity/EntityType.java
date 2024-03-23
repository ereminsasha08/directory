package com.testproject.directory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "entity_type")
@Getter
@Setter
public class EntityType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ElementCollection(fetch = EAGER)
    @CollectionTable(
            name = "attribute",
            joinColumns = @JoinColumn(name = "entity_type_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"name", "entity_type_id"}),
            indexes = {@Index(columnList = "entity_type_id")}
    )
    @Fetch(FetchMode.SUBSELECT)
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private Set<Attribute> attributes;
}
