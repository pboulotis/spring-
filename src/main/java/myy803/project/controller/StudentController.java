package myy803.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import myy803.project.entity.*;
import myy803.project.service.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/students")
//@SessionAttributes("Students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	private int percentile = new Random().nextInt(100) + 1;
	
	public StudentController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	// add mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		
		// get Students from db
		List<Student> theStudents = studentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("students", theStudents);
		
		/* Simple test this is how to get the 
		 * name of the person logged in to be used for other purposes 
		 * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 * String currentPrincipalName = authentication.getName();
		 * System.out.println(currentPrincipalName);
		*/
		
		return "redirect:/courses/list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("courseId") int courseId, Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theStudent.setCourseId(courseId);
		
		theModel.addAttribute("student", theStudent);
		
		return "students/submit-student";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int course, @RequestParam("studentId") int theId,
									Model theModel) {
		
		@SuppressWarnings({ "unchecked", "unused" })
		List<Student> theStudents = (List<Student>) theModel.getAttribute("students");
		//theStudents.size();
		
		// get the Student from the service
		Student theStudent = studentService.findById(theId);
		
		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);
		
		// send over to our form
		return "students/submit-student";	
	}
	
	
	@RequestMapping("/save")
	public String saveStudent(@RequestParam("courseId") int course, @ModelAttribute("student") Student theStudent, Model theModel) {
		
		// save the Student after setting courseId
		
		theStudent.setCourseId(course);
		
		studentService.save(theStudent);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/students/list?courseId="+course;
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("courseId") int course, @RequestParam("studentId") int theId) {
		
		// delete the Student
		studentService.deleteById(theId);
		
		// redirect to /Students/list
		return "redirect:/courses/students/list?courseId="+course;
		
	}
	
	@RequestMapping("/showstats")
	public String redirectStats(@RequestParam("courseId") int theId, Model theModel) {
		//theModel.addAttribute("percentile", percentile);
		return "redirect:/students/showStats?percentile="+percentile+"&courseId="+theId;
	}
	
	@RequestMapping("/showStats")
	public String showStats(@RequestParam("percentile") int thepercent, @RequestParam("courseId") int courseId, Model theModel) {
		
		List<Student> theStudents = studentService.findAll();
		
		percentile = thepercent;
		
		List<Student> tmp = GetAllStudents(courseId, theStudents);
		
		Grades gd = new Grades();
		
		DescriptiveStatistics ds = new DescriptiveStatistics();
		
		List<Double> list = new ArrayList<Double>();
		
		for(Student x:tmp) {
			list.add((double) x.getLabGrade());
		}
		
		list.forEach(ds::addValue);
		
		gd.setLabMin(ds.getMin());	gd.setLabMax(ds.getMax());	gd.setLabMean(ds.getMean());
		
		gd.setLabStDev(ds.getStandardDeviation()); gd.setLabVar(ds.getVariance());
		
		gd.setLabPercentiles(ds.getPercentile(percentile));
		
		gd.setLabSkewness(ds.getSkewness()); gd.setLabKurtosis(ds.getKurtosis());
		
		gd.setLabMedian(ds.getPercentile(50));
		
		list = new ArrayList<Double>();
		
		ds = new DescriptiveStatistics();
		
		for(Student x:tmp) {
			list.add((double) x.getFinalGrade());
		}
		
		list.forEach(ds::addValue);
		
		gd.setFinalMin(ds.getMin());	gd.setFinalMax(ds.getMax());	gd.setFinalMean(ds.getMean());
		
		gd.setFinalStDev(ds.getStandardDeviation()); gd.setFinalVar(ds.getVariance());
		
		gd.setFinalPercentiles(ds.getPercentile(percentile));
		
		gd.setFinalSkewness(ds.getSkewness()); gd.setFinalKurtosis(ds.getKurtosis());
		
		gd.setFinalMedian(ds.getPercentile(50));
		
		theModel.addAttribute("percentile", percentile);
		
		theModel.addAttribute("grades" , gd);
		
		return "/students/show-stats";
	}
	
	public List<Student> GetAllStudents(int theId, List<Student> tmp){
		
		List<Student> ret = new ArrayList<Student>();
		
		for(Student x:tmp) {
			if(theId == x.getCourseId()) {
				ret.add(x);
			}
		}
		
		return ret;
	}
}



