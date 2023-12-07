package com.JavaProject.Entity;

//importing the neccessary packages
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    private String courseCode;
    private int courseFees;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Student> students;

    // Default constructor
    public Course() {
        super();
    }

    // Parameterized constructor to initialize the attributes
    public Course(Long courseId, String courseName, String courseCode, int courseFees) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseFees = courseFees;
    }

    // Getter and Setter methods for each attribute
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(int courseFees) {
        this.courseFees = courseFees;
    }

    // Additional getters and setters for students
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseCode=" + courseCode
                + ", courseFees=" + courseFees + ", students=" + students + "]";
    }
}
