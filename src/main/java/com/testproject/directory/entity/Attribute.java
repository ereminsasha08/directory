package com.testproject.directory.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Attribute {
    private String name;

    private AttributeType type;
}
