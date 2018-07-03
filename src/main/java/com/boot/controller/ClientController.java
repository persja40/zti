package com.boot.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Client;
import com.boot.repository.ClientRepo;

@RestController
@RequestMapping("api/")
public class ClientController {
	@Autowired
	private ClientRepo cliRepo;

	@RequestMapping(value = "client", method = RequestMethod.GET)
	public List<Client> list() {
		return cliRepo.findAll();
	}

	@RequestMapping(value = "client", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void create(@RequestBody Client client) {
		cliRepo.saveAndFlush(client);
	}

	@RequestMapping(value = "client/{id}", method = RequestMethod.GET)
	public Optional<Client> get(@PathVariable Integer id) {
		return cliRepo.findById(id);
	}

	@RequestMapping(value = "client/account/{id}", method = RequestMethod.PUT)
	public void setAccountBalance(@PathVariable Integer id, @RequestParam Float accountBalance) {
		try {
			Client current = cliRepo.findById(id).get();
			current.setAccountBalance(accountBalance);
			cliRepo.saveAndFlush(current);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "client/credit/{id}", method = RequestMethod.PUT)
	public void setCredit(@PathVariable Integer id, @RequestParam Float credit) {
		if (credit >= 0)
			try {
				Client current = cliRepo.findById(id).get();
				current.setCredit(credit);
				cliRepo.saveAndFlush(current);
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
	}
}
