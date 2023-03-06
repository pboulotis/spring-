package myy803.project;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myy803.project.dao.*;
import myy803.project.entity.*;
import myy803.project.service.*;


//@SpringBootTest
//@TestPropertySource(
//  locations = "classpath:application.properties")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class TestAllServicesWithMocks {

	@TestConfiguration
    static class AllServicesImplTestContextConfiguration {
 
        @Bean
        public CourseService courseService() {
            return new CourseServiceImpl();
        }
        
        @Bean
        public InstructorService instructorService() {
            return new InstructorServiceImpl();
        }
        
        @Bean
        public StudentService studentService() {
            return new StudentServiceImpl();
        }
        
    }

	@Autowired 
	CourseService courseService;
	
	@Autowired 
	InstructorService instructorService;
	
	@Autowired 
	StudentService studentService;
	
	@MockBean
	CourseDAO courseDAO;
	
	@MockBean
	InstructorDAO instructorDAO;
	
	@MockBean
	StudentDAO studentDAO;
	
	@Test
	void testCourseDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}
	
	@Test
	void testInstructorDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(instructorService);
	}
	
	@Test
	void testStudentDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentService);
	}

	@Test
	void testFindByIdReturnsCourse() {
		Mockito.when(courseDAO.findById(1)).thenReturn(new Course(1, "Something Cold", 0, 
				"","",0,"","",0,0,""));
		Course storedCourse = courseService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Something Cold", storedCourse.getName());
	}
	
	@Test
	void testFindByIdReturnsInstructor() {
		Mockito.when(instructorDAO.findById(1)).thenReturn(new Instructor(1, "Dead", "Pool", 
				"","","","",""));
		Instructor instructorCourse = instructorService.findById(1);
		Assertions.assertNotNull(instructorCourse);
		Assertions.assertEquals("Pool", instructorCourse.getLastName());
	}
	
	@Test
	void testFindByIdReturnsStudent() {
		Mockito.when(studentDAO.findById(1)).thenReturn(new Student(1,0, "John", "Doe",
				0,"",0,"",0,0,"","",""));
		Student storedstudent = studentService.findById(1);
		Assertions.assertNotNull(storedstudent);
		Assertions.assertEquals("John", storedstudent.getFirstName());
	}
	/*
	 * See also Mockito.mock(), Mockito.spy(), Mockito.verify(<objectCalled>).<methodCalled>()
	 * 
	 */
}
