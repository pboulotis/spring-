package myy803.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import myy803.project.controller.CourseController;
import myy803.project.controller.StudentController;
import myy803.project.entity.Course;
import myy803.project.entity.Student;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
@AutoConfigureMockMvc
class TestControllers {
	
	@Autowired
    private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	CourseController courseController;
	
	@Autowired
	StudentController studentController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
	
	@Test
	void testCourseControllerIsNotNull() {
		Assertions.assertNotNull(courseController);
	}
	
	@Test
	void testStudentControllerIsNotNull() {
		Assertions.assertNotNull(studentController);
	}
	
	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}
	
	
	@WithMockUser(value = "deadpool")
	@Test 
	void testReturnPage() throws Exception {
		mockMvc.perform(get("/courses/list")).
		andExpect(status().isOk()).
		andExpect(model().attributeExists("courses")).
		andExpect(view().name("courses/list-courses"));
		
		
		Student student = new Student(15,4,"Doyle","Dormammu",
	    		200,"Male",2020,"Spring",
	    		(float) 6.5,6,"dormammuson@mcu.mar","Theory of Everything","Undergraduate");
		
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("studentId", Integer.toString(student.getCourseId()));
	    multiValueMap.add("courseId",  Integer.toString(student.getCourseId()));
	    multiValueMap.add("firstName",student.getFirstName());
	    multiValueMap.add("lastName", student.getLastName());
	    multiValueMap.add("am", Integer.toString(student.getAm()));
	    multiValueMap.add("gender", Integer.toString(student.getRegistrationYear()));
	    multiValueMap.add("registrationYear", Integer.toString(student.getRegistrationYear()));
	    multiValueMap.add("registrationSemester", student.getRegistrationSemester());
	    multiValueMap.add("labGrade", Float.toString(student.getLabGrade()));
	    multiValueMap.add("finalGrade", Float.toString(student.getFinalGrade()));
	    multiValueMap.add("email", student.getEmail());
	    multiValueMap.add("department", student.getDepartment());
	    multiValueMap.add("graduateStatus", student.getGraduateStatus());
		
		mockMvc.perform(get("/courses/students/list?courseId="+student.getCourseId())).
		andExpect(status().isOk()).
		andExpect(model().attributeExists("students")).
		andExpect(view().name("students/list-students"));
		
		mockMvc.perform(get("/students/showStats?percentile=65&courseId="
				+student.getCourseId())).
		andExpect(status().isOk()).
		andExpect(model().attributeExists("percentile")).
		andExpect(model().attributeExists("grades")).
		andExpect(view().name("/students/show-stats"));
		
		/*
		 * A way to check stuff that are in the model
		 * andExpect(MockMvcResultMatchers.model().attribute("msg", "Hi there, Joe."))
		 */
	}

	@WithMockUser(value = "deadpool")
	@Test 
	void testSaveReturnsPage() throws Exception {
		
	    Course course = new Course(10,"Blah",3,"Creating artificial small talk",
	    		"Chapters 1 and 2 of the recommended book",2021,"Fall","Mandatory",
	    		(float) 6.5,6,"Mocking everyone");
	    	    
	    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	    multiValueMap.add("courseId", Integer.toString(course.getCourseId()));
	    multiValueMap.add("name", course.getName());
	    multiValueMap.add("instructorId", Integer.toString(course.getInstructorId()));
	    multiValueMap.add("description", course.getDescription());
	    multiValueMap.add("syllabus", course.getSyllabus());
	    multiValueMap.add("year", Integer.toString(course.getYear()));
	    multiValueMap.add("semester", course.getSemester());
	    multiValueMap.add("type", course.getType());
	    multiValueMap.add("ects", Float.toString(course.getEcts()));
	    multiValueMap.add("dm", Float.toString(course.getDm()));
	    multiValueMap.add("department", course.getDepartment()); 
	    
		mockMvc.perform(
				post("/courses/save").
			    params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/courses/list"));	
		
		Student student = new Student(15,4,"Doyle","Dormammu",
	    		200,"Male",2020,"Spring",
	    		(float) 6.5,6,"dormamuson@mcu.mar",
	    		"Theory of Everything","Undergraduate");
		
		multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("studentId", Integer.toString(student.getCourseId()));
	    multiValueMap.add("courseId",  Integer.toString(student.getCourseId()));
	    multiValueMap.add("firstName",student.getFirstName());
	    multiValueMap.add("lastName", student.getLastName());
	    multiValueMap.add("am", Integer.toString(student.getAm()));
	    multiValueMap.add("gender", Integer.toString(student.getRegistrationYear()));
	    multiValueMap.add("registrationYear", Integer.toString(student.getRegistrationYear()));
	    multiValueMap.add("registrationSemester", student.getRegistrationSemester());
	    multiValueMap.add("labGrade", Float.toString(student.getLabGrade()));
	    multiValueMap.add("finalGrade", Float.toString(student.getFinalGrade()));
	    multiValueMap.add("email", student.getEmail());
	    multiValueMap.add("department", student.getDepartment());
	    multiValueMap.add("graduateStatus", student.getGraduateStatus());
	    
	    mockMvc.perform(
				post("/students/save").
			    params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/courses/students/list?courseId="+student.getCourseId()));
		
	}
	
	
}
