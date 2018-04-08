package com.toxin.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toxin.springboot.abstraction.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity{

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image avatar;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Item> items = new HashSet<>();

}

