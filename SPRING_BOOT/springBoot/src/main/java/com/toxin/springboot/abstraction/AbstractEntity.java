package com.toxin.springboot.abstraction;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue
    private Long id;

}
