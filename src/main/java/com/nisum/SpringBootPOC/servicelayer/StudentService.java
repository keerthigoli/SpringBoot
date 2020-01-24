package com.nisum.SpringBootPOC.servicelayer;

import java.util.List;

import com.nisum.SpringBootPOC.model.Student;

public interface StudentService {

	public List<Student> getStudentDetails();
	void updateDetailsById(Student student, Integer sid);

}

