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
public class Item extends AbstractEntity {

    @Column
    private String name;

    @Column
    private int count;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image picture;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
