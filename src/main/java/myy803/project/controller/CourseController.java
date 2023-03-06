package myy803.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import myy803.project.entity.*;
import myy803.project.service.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/courses")
//@SessionAttributes("courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private InstructorService instructorService;
	
	private int theId;
	
	public CourseController(CourseService thecourseService) {
		courseService = thecourseService;
	}

	// add mapping for "/list"
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listcourses(Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String currentPrincipalName = authentication.getName();
		
		List<Instructor> theInstructors = instructorService.findAll();
		
		Instructor currentInstructor = new Instructor();
		
		for(Instructor x:theInstructors) {
			if(x.getUsername().equals(currentPrincipalName)) {
				currentInstructor = x;
				theId = x.getInstructorId();
			}
		}
		
		// get courses from db
		List<Course> thecourses = courseService.findAll();
		
		List<Course> retL = new ArrayList<Course>();
		
		for (Course x:thecourses) {
			if(x.getInstructorId()==theId) {
				retL.add(x);
			}
		}
		
		// add to the spring model
		
		theModel.addAttribute("instructor", currentInstructor);
		
		theModel.addAttribute("courses", retL);
		
		/* Simple test this is how to get the 
		 * name of the person logged in to be used for other purposes 
		 * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 * String currentPrincipalName = authentication.getName();
		 * System.out.println(currentPrincipalName);
		*/
		
		return "courses/list-courses";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Course thecourse = new Course();
		
		theModel.addAttribute("course", thecourse);
		
		return "courses/submit-course";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId,
									Model theModel) {
		
		@SuppressWarnings({ "unchecked", "unused" })
		List<Course> thecourses = (List<Course>) theModel.getAttribute("courses");
		//thecourses.size();
		
		// get the course from the service
		Course thecourse = courseService.findById(theId);
		
		// set course as a model attribute to pre-populate the form
		theModel.addAttribute("course", thecourse);
		
		// send over to our form
		return "courses/submit-course";
	}
	
	
	@RequestMapping("/save")
	public String savecourse(@ModelAttribute("course") Course thecourse, Model theModel) {
		
		// save the course
		
		thecourse.setInstructorId(theId);
		
		courseService.save(thecourse);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/list";
	}
	
	//@SuppressWarnings("unchecked")
	@RequestMapping("/students/list")
	public String showStudents(@RequestParam("courseId") int courseId, Model theModel) {
		
		// get students from db
		List<Student> thestudents = studentService.findAll();
		
		List<Student> newList = new ArrayList<Student>();
		
		for (Student x:thestudents) {
			if(x.getCourseId()==courseId) {
				newList.add(x);
			}
		}
		
		// add to the spring model
		theModel.addAttribute("students", newList);
		
		
		
		
		/* Simple test this is how to get the 
		 * name of the person logged in to be used for other purposes 
		 * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 * String currentPrincipalName = authentication.getName();
		 * System.out.println(currentPrincipalName);
		*/
		
		return "students/list-students";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		
		// delete the course
		courseService.deleteById(theId);
		
		// redirect to /courses/list
		return "redirect:/courses/list";
		
	}
}



