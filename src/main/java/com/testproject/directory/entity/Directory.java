package com.testproject.directory.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import static jakarta.persistence.EnumType.STRING;
import static org.hibernate.annotations.FetchMode.JOIN;

@Entity
@Table(name = "directory", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToOne
    @JoinColumn(name = "id", updatable = false, insertable = false, nullable = false)
    @JoinTable(foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
    @Fetch(JOIN)
    private EntityType entityType;
    @Enumerated(STRING)
    private StructureType structureType;
}
