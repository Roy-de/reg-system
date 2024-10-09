package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "course_section")
@Getter
@Setter
@RequiredArgsConstructor
public class CourseSection {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID crnno;
    private UUID course_id;
    private int section_no;
    private int faculty_id;
    private String timeslot;
    private int room_id;
    private int available_seats;
    private int semester_id;
}
