package myy803.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import myy803.project.entity.Student;

@Service
public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);

}
