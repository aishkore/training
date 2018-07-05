package com.example.demo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Course;
public interface CourseRepository extends CrudRepository <Course,Long> {
	List<Course> findByname (String name);

	
}
