package com.IMS.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.IMS.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{

	@Query("SELECT e FROM Exam e WHERE e.module LIKE %:module% order by e.id desc")
	List<Exam> listSearched(@Param("module") String module);

}
