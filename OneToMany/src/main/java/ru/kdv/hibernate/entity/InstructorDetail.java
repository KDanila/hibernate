package main.java.ru.kdv.hibernate.entity;

import lombok.*;

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

    @ToString.Exclude
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    //Use to delete only instructorDetail without instructor.
    //@OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private Instructor instructor;

    public InstructorDetail(String youtubeChanel, String hobby) {
        this.youtubeChanel = youtubeChanel;
        this.hobby = hobby;
    }
}

