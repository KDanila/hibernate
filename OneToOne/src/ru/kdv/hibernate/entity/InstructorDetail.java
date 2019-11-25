package ru.kdv.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChanel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail(String youtubeChanel, String hobby) {
        this.youtubeChanel = youtubeChanel;
        this.hobby = hobby;
    }
}

