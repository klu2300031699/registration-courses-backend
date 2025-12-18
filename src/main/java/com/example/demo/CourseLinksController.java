package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseLinksController {

    @Autowired
    private CourseLinksService service;

    @PostMapping("/save")
    public ResponseEntity<?> saveCourses(@RequestBody CourseLinks courseLinks) {
        try {
            CourseLinks saved = service.saveCourseLinks(courseLinks);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Course links submitted successfully");
            response.put("data", saved);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/check/{loginID}")
    public ResponseEntity<?> checkSubmission(@PathVariable String loginID) {
        Map<String, Object> response = new HashMap<>();
        boolean hasSubmitted = service.hasSubmitted(loginID);
        response.put("hasSubmitted", hasSubmitted);
        
        if (hasSubmitted) {
            Optional<CourseLinks> courseLinks = service.getCourseLinks(loginID);
            response.put("data", courseLinks.orElse(null));
        }
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSubmissions() {
        List<CourseLinks> allSubmissions = service.getAllSubmissions();
        return ResponseEntity.ok(allSubmissions);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourseLinks(@PathVariable Long id, @RequestBody CourseLinks courseLinks) {
        try {
            CourseLinks updated = service.updateCourseLinks(id, courseLinks);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Course links updated successfully");
            response.put("data", updated);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/delete/{loginID}")
    public ResponseEntity<?> deleteCourseLinks(@PathVariable String loginID) {
        service.deleteCourseLinks(loginID);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Course links deleted successfully");
        return ResponseEntity.ok(response);
    }
}
