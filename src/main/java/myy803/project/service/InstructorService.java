package myy803.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import myy803.project.entity.Instructor;

@Service
public interface InstructorService {

	public List<Instructor> findAll();
	
	public Instructor findById(int theId);
	
	public void save(Instructor theInstructor);
	
	public void deleteById(int theId);
	
}
