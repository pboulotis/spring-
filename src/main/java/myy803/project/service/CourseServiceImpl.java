package myy803.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myy803.project.dao.CourseDAO;
import myy803.project.entity.Course;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO CourseRepository;
	
	public CourseServiceImpl() {
		super();
	}

	@Autowired
	public CourseServiceImpl(CourseDAO theCourseRepository) {
		CourseRepository = theCourseRepository;
	}
	
	@Override
	@Transactional
	public List<Course> findAll() {
		return CourseRepository.findAll();
	}

	@Override
	@Transactional
	public Course findById(int theId) {
		Course result = CourseRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the Course
			throw new RuntimeException("Did not find Course id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Course theCourse) {
		CourseRepository.save(theCourse);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		CourseRepository.deleteById(theId);
	}
}






