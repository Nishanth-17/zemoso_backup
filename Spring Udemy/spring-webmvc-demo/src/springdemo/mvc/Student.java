package springdemo.mvc;

import javax.validation.constraints.*;

import springdemo.mvc.customvalidation.CourseCode;

public class Student {
	
	@NotNull(message="Is Required")
	@Size(min=1,message="Is Required")
	private String firstName;
	@NotNull(message="Is Required")
	@Size(min=1,message="Is Required")
	private String lastName;
	private String country;
	private String gender;
	private String subject;
	private String[] operatingsystem;
	@Min(value=1,message="Must be a value between 1 and 5")
	@Max(value=5,message="Must be a value between 1 and 5")
	private int credits;
	@Pattern(regexp="[0-9]{10}",message="Requires 10 Digits")
	private String mobile;
	@Pattern(regexp="[A-Za-z0-9]{5}",message="only 5 chars/digits allowed")
	private String postalcode;
	@CourseCode
	private String courseCode;
	public Student() {}
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	

	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String[] getOperatingsystem() {
		return operatingsystem;
	}
	public void setOperatingsystem(String[] operatingsystem) {
		this.operatingsystem = operatingsystem;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
}
