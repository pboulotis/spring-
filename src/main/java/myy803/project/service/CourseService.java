package myy803.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import myy803.project.entity.Course;

@Service
public interface CourseService {

	public List<Course> findAll();
	
	public Course findById(int theId);
	
	public void save(Course theCourse);
	
	public void deleteById(int theId);
	
}
