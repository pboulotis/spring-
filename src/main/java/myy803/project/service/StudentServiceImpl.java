package myy803.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myy803.project.dao.StudentDAO;
import myy803.project.entity.Student;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO StudentRepository;
	
	public StudentServiceImpl() {
		super();
	}

	@Autowired
	public StudentServiceImpl(StudentDAO theStudentRepository) {
		StudentRepository = theStudentRepository;
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {
		return StudentRepository.findAll();
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		Student result = StudentRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the Student
			throw new RuntimeException("Did not find Student id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		StudentRepository.save(theStudent);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		StudentRepository.deleteById(theId);
	}
}






