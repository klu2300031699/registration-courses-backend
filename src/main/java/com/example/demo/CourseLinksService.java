package com.example.demo;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

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

    public void deleteCourseLinks(String loginID) {
        Optional<CourseLinks> existing = repository.findByLoginID(loginID);
        existing.ifPresent(courseLinks -> repository.delete(courseLinks));
    }
}

