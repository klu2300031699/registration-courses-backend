package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "course_links")
public class CourseLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String loginID;
    
    private String name;
    private String mobileNumber;
    
    private String courseName1;
    private String course1;
    private String courseName2;
    private String course2;
    private String courseName3;
    private String course3;
    private String courseName4;
    private String course4;

    public CourseLinks() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLoginID() { return loginID; }
    public void setLoginID(String loginID) { this.loginID = loginID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getCourseName1() { return courseName1; }
    public void setCourseName1(String courseName1) { this.courseName1 = courseName1; }

    public String getCourse1() { return course1; }
    public void setCourse1(String course1) { this.course1 = course1; }

    public String getCourseName2() { return courseName2; }
    public void setCourseName2(String courseName2) { this.courseName2 = courseName2; }

    public String getCourse2() { return course2; }
    public void setCourse2(String course2) { this.course2 = course2; }

    public String getCourseName3() { return courseName3; }
    public void setCourseName3(String courseName3) { this.courseName3 = courseName3; }

    public String getCourse3() { return course3; }
    public void setCourse3(String course3) { this.course3 = course3; }

    public String getCourseName4() { return courseName4; }
    public void setCourseName4(String courseName4) { this.courseName4 = courseName4; }

    public String getCourse4() { return course4; }
    public void setCourse4(String course4) { this.course4 = course4; }
}
