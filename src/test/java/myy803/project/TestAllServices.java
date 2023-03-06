package myy803.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import myy803.project.entity.*;
import myy803.project.service.*;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
class TestAllServices {

	@Autowired 
	CourseService courseService;
	
	@Autowired 
	InstructorService instructorService;
	
	@Autowired 
	StudentService studentService;
	
	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}

	@Test
	void testFindByIdReturnsCourse() {
		Course storedCourse = courseService.findById(4);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Mandatory", storedCourse.getType());
	}
	
	@Test
	void testFindByIdReturnsInstructor() {
		Instructor storedInstructor = instructorService.findById(2);
		Assertions.assertNotNull(storedInstructor);
		Assertions.assertEquals("Strange Academy", storedInstructor.getDepartment());
	}
	
	@Test
	void testFindByIdReturnsStudent() {
		Student storedStudent = studentService.findById(9);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Dormammu", storedStudent.getLastName());
	}
	
}
