package myy803.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_Id")
	private int courseId;//not null
	
	@Column(name="name")
	private String name;
	
	@Column(name="instructor_Id")
	private int instructorId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="syllabus")
	private String syllabus;
	
	@Column(name="year")
	private int year;

	@Column(name="semester")
	private String semester;
	
	@Column(name="type")
	private String type;
	
	@Column(name="ects")
	private float ects;
	
	@Column(name="dm")
	private float dm;
	
	@Column(name="department")
	private String department;
	
	public Course(int courseId, String name, int instructorId, String description, String syllabus,
					int year, String semester, String type, float ects, float dm, String department) {
		// super();
		this.courseId = courseId;//not null
		this.name = name;
		this.instructorId = instructorId;
		this.description = description;
		this.syllabus = syllabus;
		this.year = year;
		this.semester = semester;
		this.type = type;
		this.ects = ects;
		this.dm = dm;
		this.department = department;
	}

	public Course() {
		
	}
	
	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}


	public int getInstructorID() {
		return instructorId;
	}

	public void setInstructorID(int instructorId) {
		this.instructorId = instructorId;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		
		this.year = year;
	}
	
	
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public float getEcts() {
		return ects;
	}

	public void setEcts(float ects) {
		this.ects = ects;
	}
	
	
	public float getDm() {
		return dm;
	}

	public void setDm(float dm) {
		this.dm = dm;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", courseId=" + courseId + ", instructorId=" + instructorId + ", description=" + description
				+ ", syllabus=" + syllabus + ", year=" + year + ", semester=" + semester + ", type=" + type + ", ects=" + ects + ", dm=" + dm + ", department=" + department
				+ "]";
	}
	
}


