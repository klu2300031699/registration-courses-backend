package com.example.demo;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class CourseLinksService {

    @Autowired
    private CourseLinksRepository repository;

    public CourseLinks saveCourseLinks(CourseLinks courseLinks) {
        // Check if student already submitted
        if (repository.existsByLoginID(courseLinks.getLoginID())) {
            throw new RuntimeException("Student has already submitted course links. Please contact admin to update.");
        }
        return repository.save(courseLinks);
    }

    public boolean hasSubmitted(String loginID) {
        return repository.existsByLoginID(loginID);
    }

    public Optional<CourseLinks> getCourseLinks(String loginID) {
        return repository.findByLoginID(loginID);
    }

    public List<CourseLinks> getAllSubmissions() {
        return repository.findAll();
    }

    public CourseLinks updateCourseLinks(Long id, CourseLinks updatedData) {
        Optional<CourseLinks> existing = repository.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Submission not found");
        }
        
        CourseLinks courseLinks = existing.get();
        courseLinks.setName(updatedData.getName());
        courseLinks.setMobileNumber(updatedData.getMobileNumber());
        courseLinks.setCourseName1(updatedData.getCourseName1());
        courseLinks.setCourse1(updatedData.getCourse1());
        courseLinks.setCourseName2(updatedData.getCourseName2());
        courseLinks.setCourse2(updatedData.getCourse2());
        courseLinks.setCourseName3(updatedData.getCourseName3());
        courseLinks.setCourse3(updatedData.getCourse3());
        courseLinks.setCourseName4(updatedData.getCourseName4());
        courseLinks.setCourse4(updatedData.getCourse4());
        
        return repository.save(courseLinks);
    }

    public void deleteCourseLinks(String loginID) {
        Optional<CourseLinks> existing = repository.findByLoginID(loginID);
        existing.ifPresent(courseLinks -> repository.delete(courseLinks));
    }
}

