package com.boot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Client;
import com.boot.model.History;
import com.boot.model.Product;
import com.boot.repository.ClientRepo;
import com.boot.repository.HistoryRepo;
import com.boot.repository.ProductRepo;

@RestController
@RequestMapping("api/")
public class HistoryController {
	@Autowired
	private HistoryRepo hisRepo;
	@Autowired
	private ClientRepo cliRepo;
	@Autowired
	private ProductRepo proRepo;

	@RequestMapping(value = "history", method = RequestMethod.GET)
	public List<History> list() {
		return hisRepo.findAll();
	}

	@RequestMapping(value = "history", method = RequestMethod.POST)
	@Transactional
	public void create(@RequestParam Integer clientId, @RequestParam Integer productId, @RequestParam Integer amount) {
		Client c = cliRepo.findById(clientId).get();
		Product p = proRepo.findById(productId).get();
		Float value = amount * p.getPrice();
		System.out.println("Client"+c.toString()+"\nProduct"+p.toString());
		// check if available
		if (c.getCredit() + c.getAccountBalance() >= value && p.getQuantity() >= amount) {
			// SAVE
			c.setAccountBalance(c.getAccountBalance() - value);
			p.setQuantity(p.getQuantity() - amount);
			History h = new History(c, p, amount);
			h.setPrice(p.getPrice());
			cliRepo.saveAndFlush(c);
			proRepo.saveAndFlush(p);
			hisRepo.saveAndFlush(h);
		}
	}

	@RequestMapping(value = "history/{clientId}", method = RequestMethod.GET)
	public List<History> list_client(@PathVariable Integer clientId) {
		throw new UnsupportedOperationException("!!! Implement IT !!!");
	}
}
