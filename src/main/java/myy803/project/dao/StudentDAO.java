package myy803.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.project.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	public Student findById(int theId);
		
}
