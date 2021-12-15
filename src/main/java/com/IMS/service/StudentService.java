package com.IMS.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IMS.model.Student;
import com.IMS.model.Search;
import com.IMS.repsitory.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public List<Student> listAll() {
        return repo.findAll();
    }
     
    public void save(Student student) {
        repo.save(student);
    }
     
    public Student get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

	public List<Student> listSearched(Search search) {
		return repo.listSearched(search.getName());
	}
	

}
