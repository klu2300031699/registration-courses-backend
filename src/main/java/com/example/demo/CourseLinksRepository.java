package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CourseLinksRepository extends JpaRepository<CourseLinks, Long> {
    Optional<CourseLinks> findByLoginID(String loginID);
    boolean existsByLoginID(String loginID);
}
