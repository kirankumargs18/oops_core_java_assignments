package com.globallogic.service;

import java.util.List;

import com.globallogic.model.Student;

public class StudentService {

	public String addStudent(Student student, List<Student> students) {

		if (students.contains(student)) {
			return "Student already exists in the List";
		}
		students.add(student);
		return "Student added successfully";
	}

	public String removeStudent(int id, List<Student> students) {

		Student student2 = null;
		boolean isFound = false;

		for (Student student3 : students) {
			if (student3.getId() == id) {
				student2 = student3;
				isFound = true;
			}
		}
		if (!isFound) {
			return "Student not found";
		}
		students.remove(student2);
		return "Student removed successfully";
	}

	public String updateStudent(int id, Student student, List<Student> students) {

		Student student2 = null;
		boolean isFound = false;

		for (Student student3 : students) {
			if (student3.getId() == id) {
				student2 = student3;
				isFound = true;
			}
		}
		if (!isFound) {
			return "Student not found";
		}
		student2.setName(student.getName());
		student2.setFatherName(student.getFatherName());
		student2.setPhoneNumber(student.getPhoneNumber());
		student2.setAddress(student.getAddress());

		return "Student updated successfully";
	}

	public void viewAllStudents(List<Student> students) {
		if (students.isEmpty()) {
			System.out.println("No Students found");
		} else {
			students.forEach(System.out::println);
		}
	}
	
	
	
}
