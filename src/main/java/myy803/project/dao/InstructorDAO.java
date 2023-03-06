package myy803.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.project.entity.Instructor;

@Repository
public interface InstructorDAO extends JpaRepository<Instructor, Integer> {
	
	public Instructor findById(int theId);
		
}
