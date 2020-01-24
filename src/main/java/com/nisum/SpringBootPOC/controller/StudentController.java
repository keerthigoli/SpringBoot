package com.nisum.SpringBootPOC.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.nisum.SpringBootPOC.Exceptions.StudentNotFoundException;
import com.nisum.SpringBootPOC.Repository.StudentRepository;
import com.nisum.SpringBootPOC.ServiceImpl.StudentServiceImpl;
import com.nisum.SpringBootPOC.model.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentServiceImpl serviceimpl;
	@Autowired
	private StudentRepository studrepo;

	@GetMapping(value = "/students")
	public List<Student> retrieveAllStudents() {
		return serviceimpl.getStudentDetails();
	}

	@GetMapping(value = "/students/{id}")
	public ResponseEntity<?> retriveStudent(@PathVariable("id") Integer id) {

		try {
			serviceimpl.getStudentDetailsById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (HttpClientErrorException e1) {
			return new ResponseEntity<>(e1.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/getDetails")
	public Student addStudentDetails(@RequestBody Student student) {
		return serviceimpl.addDetails(student);
	}

	@DeleteMapping(value = "/getDetails/{id}")
	public void deleteStudentById(@PathVariable Integer id) {
		serviceimpl.deleteStudentById(id);
	}

	@PutMapping(value = "/getDetails/{id}")
	public ResponseEntity<?> updateStudentById(@PathVariable("id") Integer id, @RequestBody Student student) {
		/*
		 * try { serviceimpl.updateDetailsById(student, id); return new
		 * ResponseEntity<>(HttpStatus.OK); } catch (HttpClientErrorException e) {
		 * return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); }
		 */

		if (!studrepo.existsById(id))
			throw new StudentNotFoundException("student id not found: +id");

		return new ResponseEntity<>("product is updated sucessfully", HttpStatus.OK);

	}
}
