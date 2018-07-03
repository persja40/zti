package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boot.model.Product;

public class ProductTest {
	@Test
	public void testNegativePrice() {
		String name = "Lalka";
		Float price = (float) 1.99, price2 = (float) -3.20;
		Integer quantity = 33;
		Product p = new Product(name, price, quantity);
		p.setPrice(price2);
		assertEquals(price, p.getPrice());
	}

	@Test
	public void testNegativeQuantity() {
		String name = "Lalka";
		Float price = (float) 1.99;
		Integer quantity = 33, quantity2 = -3;
		Product p = new Product(name, price, quantity);
		p.setQuantity(quantity2);
		assertEquals(quantity, p.getQuantity());
	}
}
