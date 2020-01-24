package com.nisum.SpringBootPOC.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.SpringBootPOC.Exceptions.StudentNotFoundException;
import com.nisum.SpringBootPOC.Repository.StudentRepository;
import com.nisum.SpringBootPOC.model.Student;
import com.nisum.SpringBootPOC.servicelayer.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private StudentRepository studentrepo;
	@Override
	public List<Student> getStudentDetails() {
	
		return studentrepo.findAll();
	}
	public Student addDetails(Student student) {
		return studentrepo.save(student);
	}
	public void getStudentDetailsById(Integer id) {
		
		Optional<Student> student = studentrepo.findById(id);
		if(!student.isPresent())
		throw new StudentNotFoundException("student id is not present : +id");	
		
	}
	
	
	public void deleteStudentById(Integer id) {
		
		 studentrepo.deleteById(id);;
	}
	public void updateDetailsById(Student student,Integer sid) {
		
		studentrepo.save(student);
	}
	
}

