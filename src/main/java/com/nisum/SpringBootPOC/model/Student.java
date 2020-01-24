package com.nisum.SpringBootPOC.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student_Details")
public class Student {
	@Id
	private int sid;
	private String sname;
	private String  course;
	// @Column
	// @ElementCollection(targetClass = Address.class)
	// private List<Address> address;

	// @OneToMany(targetEntity = Address.class, mappedBy = "student", cascade =
	// CascadeType.ALL, fetch = FetchType.EAGER)
	// public List<Address> getAddress() {
	// return address;
	// }

	// public void setAddress(List<Address> address) {
	// this.address = address;
	// }

	public int getSid() {
		return sid;}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
  
	
public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

public Student(int sid, String sname, String  course) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.course = course;
	}
public Student() {
	}

@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", course=" + course + "]";
}


}
