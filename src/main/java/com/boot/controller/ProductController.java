package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.model.Product;
import com.boot.repository.ProductRepo;

@RestController
@RequestMapping("api/")
public class ProductController {
	@Autowired
	private ProductRepo proRepo;

	@RequestMapping(value = "product", method = RequestMethod.GET)
	public List<Product> list() {
		return proRepo.findAll();
	}

	@RequestMapping(value = "product", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void create(@RequestBody Product p) {
		proRepo.saveAndFlush(p);
	}

	@RequestMapping(value = "product/{code}", method = RequestMethod.GET)
	public Optional<Product> get(@PathVariable Integer code) {
		return proRepo.findById(code);
	}

	@RequestMapping(value = "product/price/{id}", method = RequestMethod.PUT)
	public void setPrice(@PathVariable Integer id, @RequestParam Float price) {
		if (price >= 0) {
			try {
				Product current = proRepo.findById(id).get();
				current.setPrice(price);
				proRepo.saveAndFlush(current);
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "product/quantity/{id}", method = RequestMethod.PUT)
	public void setQuantity(@PathVariable Integer id, @RequestParam Integer quantity) {
		if (quantity >= 0)
			try {
				Product current = proRepo.findById(id).get();
				current.setQuantity(quantity);
				proRepo.saveAndFlush(current);
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
	}

}
