/*
package org.learn.regsystem;

import org.learn.regsystem.entities.*;
import org.learn.regsystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.UUID;

*/
/*@Component
@ComponentScan("org.learn.regsystem")*//*

public class DataInsertion implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UndergraduateRepository undergraduateRepository;

    @Autowired
    private GraduateRepository graduateRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CoursePrerequisitesRepository coursePrerequisitesRepository;


    @Override
    public void run(String... args) {
        insertStudents();
        insertUndergraduates();
        insertGraduates();
        insertDepartments();
        insertFaculties();
        insertCourses();
        insertCoursePrerequisites();
    }

    private void insertStudents() {
        for (int i = 1; i <= 1200; i++) {
            Student student = new Student();
            student.setStudent_year(RandomDataGenerator.getRandomYear());
            student.setStudent_type("Undergraduate");
            studentRepository.save(student);
        }
    }

    private void insertUndergraduates() {
        for (int i = 1; i <= 300; i++) {
            Undergraduate undergraduate = new Undergraduate();
            undergraduate.setDept_id(UUID.randomUUID());
            undergraduate.setUndergraduate_student_type(i <= 200 ? "Full Time" : "Part Time");
            undergraduateRepository.save(undergraduate);
        }
    }

    private void insertGraduates() {
        for (int i = 1; i <= 300; i++) {
            Graduate graduate = new Graduate();
            graduate.setDept_id(UUID.randomUUID());
            if (i <= 200) {
                graduate.setGraduate_student_type("Masters");
                graduate.setProgram(RandomDataGenerator.getRandomCourse());
            } else {
                graduate.setGraduate_student_type("PhD");
                graduate.setProgram(RandomDataGenerator.getRandomCourse() + " Research");
            }
            graduateRepository.save(graduate);
        }
    }

    private void insertDepartments() {
        for (int i = 1; i <= 10; i++) {
            DepartmentDto department = new DepartmentDto();
            department.setDept_name(RandomDataGenerator.getRandomDepartment());
            department.setChair_id(i); // Example chair_id
            department.setDept_manager(RandomDataGenerator.getRandomName());
            department.setEmail(RandomDataGenerator.getRandomEmail());
            department.setPhone(RandomDataGenerator.getRandomPhoneNumber());
            department.setRoom_id(UUID.randomUUID());
            departmentRepository.save(department);
        }
    }

    private void insertFaculties() {
        for (int i = 1; i <= 400; i++) {
            Faculty faculty = new Faculty();
            faculty.setSpecialty(RandomDataGenerator.getRandomCourse());
            faculty.setFaculty_rank(i <= 200 ? "Professor" : "Lecturer");
            faculty.setFaculty_type(i <= 350 ? "Full Time" : "Part Time");
            facultyRepository.save(faculty);
        }
    }

    private void insertCourses() {
        for (int i = 1; i <= 10; i++) {
            Course course = new Course();
            course.setCourse_name(RandomDataGenerator.getRandomCourse());
            course.setDept_id(UUID.randomUUID()); // Assuming dept_id corresponds to DepartmentDto IDs
            course.setNo_of_credits(RandomDataGenerator.getRandomCredits());
            course.setDescription("Description for " + course.getCourse_name());
            course.setCourse_level(i <= 5 ? "Undergraduate" : "Graduate");
            courseRepository.save(course);
        }
    }

    private void insertCoursePrerequisites() {
        for (int i = 1; i <= 10; i++) {
            CoursePrerequisites prerequisites = new CoursePrerequisites();
            prerequisites.setPrerequisites_course_id(UUID.randomUUID());
            prerequisites.setMinimum_grade(RandomDataGenerator.getRandomMinimumGrade());
            coursePrerequisitesRepository.save(prerequisites);
        }
    }
}
*/
