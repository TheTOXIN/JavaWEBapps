package com.toxin.todo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String description;
    
    @Column(nullable = false)
    private Boolean finished;

    @Column(nullable = false)
    private LocalDate date;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private User user;

}
