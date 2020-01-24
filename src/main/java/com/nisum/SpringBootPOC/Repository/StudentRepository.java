package com.nisum.SpringBootPOC.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nisum.SpringBootPOC.model.Student;
public interface StudentRepository  extends JpaRepository<Student, Integer>{

	}

