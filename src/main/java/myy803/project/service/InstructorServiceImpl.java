package myy803.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myy803.project.dao.InstructorDAO;
import myy803.project.entity.Instructor;


@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO InstructorRepository;
	
	public InstructorServiceImpl() {
		super();
	}

	@Autowired
	public InstructorServiceImpl(InstructorDAO theInstructorRepository) {
		InstructorRepository = theInstructorRepository;
	}
	
	@Override
	@Transactional
	public List<Instructor> findAll() {
		return InstructorRepository.findAll();
	}

	@Override
	@Transactional
	public Instructor findById(int theId) {
		Instructor result = InstructorRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the Instructor
			throw new RuntimeException("Did not find Instructor id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		InstructorRepository.save(theInstructor);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		InstructorRepository.deleteById(theId);
	}
}






