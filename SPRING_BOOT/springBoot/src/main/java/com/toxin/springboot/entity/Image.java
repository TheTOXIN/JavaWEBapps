package com.toxin.springboot.entity;

import com.toxin.springboot.abstraction.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Image extends AbstractEntity {

    @Column
    private byte[] bytes;

}
