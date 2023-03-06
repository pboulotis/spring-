package myy803.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_Id")
	private int studentId;
	
	@Column(name="course_Id")
	private int courseId;

	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column(name="am")
	private int am;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="registration_Year")
	private int registrationYear;
	
	@Column(name="registration_Semester")
	private String registrationSemester;
	
	@Column(name="lab_Grade")
	private float labGrade;
	
	@Column(name="final_Grade")
	private float finalGrade;
	
	@Column(name="email")
	private String email;
	
	@Column(name="department")
	private String department;
	
	@Column(name="graduate_Status")
	private String graduateStatus;
	
	public Student(int id, int courseId, String firstName, 
			String lastName, int am, 
			String gender, int registrationYear,
			String registrationSemester, float labGrade,
			float finalGrade, String email, String department,
			String graduateStatus) {
		// super();
		this.studentId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.am = am;
		this.gender = gender;
		this.registrationYear = registrationYear;
		this.registrationSemester = registrationSemester;
		this.labGrade = labGrade;
		this.finalGrade = finalGrade;
		this.email = email;
		this.department = department;
		this.graduateStatus = graduateStatus;
	}

	public Student() {
		
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	

	public void setStudentId(int id) {
		this.studentId = id;
	}
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAm() {
		return am;
	}

	public void setAm(int am) {
		this.am = am;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getRegistrationYear() {
		return registrationYear;
	}
	
	public void setRegistrationYear(int registrationYear) {
		this.registrationYear = registrationYear;
	}
	
	public String getRegistrationSemester() {
		return registrationSemester;
	}

	public void setRegistrationSemester(String registrationSemester) {
		this.registrationSemester = registrationSemester;
	}
	
	public float getLabGrade() {
		return labGrade;
	}

	public void setLabGrade(float labGrade) {
		this.labGrade = labGrade;
	}

	public float getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGraduateStatus() {
		return graduateStatus;
	}

	public void setGraduateStatus(String graduateStatus) {
		this.graduateStatus = graduateStatus;
	}

	@Override
	public String toString() {
		return "Student [first name=" + firstName + ", last name" + lastName + ", am=" + am + ", gender=" + gender
				+ ", registration year=" + registrationYear + ", registration semester=" + registrationSemester 
				+ ", lab grade=" + finalGrade + ", final grade=" + finalGrade + ", email=" + email 
				+ ", department=" + department + ", graduate status=" + graduateStatus
				+ "]";
	}
	
}
