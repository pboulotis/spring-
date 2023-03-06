package myy803.project;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import myy803.project.dao.*;
import myy803.project.entity.*;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
class TestAllDaos {
	
	@Autowired 
	CourseDAO courseDAO;
	
	@Autowired 
	StudentDAO studentDAO;
	
	@Autowired 
	InstructorDAO instructorDAO;
	
	@Test
	void testCourseDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseDAO);
	}
	
	@Test
	void testInstructorDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(instructorDAO);
	}
	
	@Test
	void testStudentDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentDAO);
	}

	@Test
	void testFindByIdReturnsCourse() {
		Course storedCourse = courseDAO.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Telepathy", storedCourse.getName());
	}
	
	@Test
	void testFindByIdReturnsStudent() {
		Student storedStudent = studentDAO.findById(1);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Female", storedStudent.getGender());
	}
	
	@Test
	void testFindByIdReturnsInstructor() {
		Instructor storedInstructor = instructorDAO.findById(3);
		Assertions.assertNotNull(storedInstructor);
		Assertions.assertEquals("Wilson", storedInstructor.getLastName());
	}
}
