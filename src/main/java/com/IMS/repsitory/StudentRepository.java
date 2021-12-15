package com.IMS.repsitory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.IMS.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("SELECT e FROM Student e WHERE e.name LIKE %:name% order by e.id desc")
	List<Student> listSearched(@Param("name") String name);

}
