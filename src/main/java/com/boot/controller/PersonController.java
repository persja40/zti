package com.boot.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.boot.model.Person;
import com.boot.repository.PersonRepo;

@RestController
@RequestMapping("api/v1/")
public class PersonController {
	@Autowired
	private PersonRepo perRepo;

	@RequestMapping(value = "person", method = RequestMethod.GET)
	public List<Person> list() {
		return perRepo.findAll();
	}

	@RequestMapping(value = "in", method = RequestMethod.POST)
	public void in() {
		Person person = new Person("Bala", "Balecka", "Bity", "Bmail", "Bel", 5);
		perRepo.saveAndFlush(person);
	}

	@RequestMapping(value = "person", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void create(@RequestBody Person person) {
		System.out.println(person);
		perRepo.saveAndFlush(person);
	}

	@RequestMapping(value = "person/{id}", method = RequestMethod.GET)
	public Optional<Person> get(@PathVariable Integer id) {
		return perRepo.findById(id);
	}

	@RequestMapping(value = "person/{id}", method = RequestMethod.PUT)
	public void put(@PathVariable int id, @RequestBody Person person) {
		try {
			Person current = perRepo.findById(id).get();
			BeanUtils.copyProperties(person, current);
			current.setId(id);
			perRepo.saveAndFlush(current);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		perRepo.deleteById(id);
	}
}
