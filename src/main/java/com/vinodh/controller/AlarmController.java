package com.vinodh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinodh.entity.Alarm;
import com.vinodh.exceptionhandling.AlarmNotFoundException;
import com.vinodh.exceptionhandling.AlarmUnSupportedFieldPatchException;
import com.vinodh.repository.AlarmRepository;

@RestController
public class AlarmController {
	@Autowired
	private AlarmRepository repository;

	@GetMapping("/alarm")
	public List<Alarm> findAll() {
		return repository.findAll();
	}

	@PostMapping("/alarm")
	public Alarm newBook(@RequestBody Alarm alarm) {
		return repository.save(alarm);
	}

	@GetMapping("/alarm/{id}")
	public Alarm findOne(@PathVariable Long id) {
		if(id==0){
			throw new AlarmNotFoundException(id);
		}else if (id==1) {
			throw new AlarmUnSupportedFieldPatchException("vinodh");
		}else if (id==2) {
			throw new NumberFormatException("number formate Exception");
		}else if (id==3) {
			throw new ArithmeticException("can't divide with zero");
		}
		return repository.findById(id).get();
	}

	@PutMapping("/alarm/{id}")
	public Alarm saveOrUpdate(@RequestBody Alarm newBook, @PathVariable Long id) {
		return repository.save(newBook);
	}

	@DeleteMapping("/alarm/{id}")
	public void deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
