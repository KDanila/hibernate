package ru.kdv.hibernate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    private int id;
    private String title;
    private Instructor instructor;
}
