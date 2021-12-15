
package com.IMS.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.IMS.model.Exam;
import com.IMS.model.eSearch;
import com.IMS.repsitory.ExamRepository;

@Service
@Transactional
public class ExamService {
	
	@Autowired
	private ExamRepository repo;
	
	public List<Exam> listAll() {
        return repo.findAll();
    }
     
    public void save(Exam exam) {
        repo.save(exam);
    }
     
    public Exam get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

	public List<Exam> listSearched(eSearch esearch) {
		return repo.listSearched(esearch.getModule());
	}
	

}
