package com.boot;

import com.boot.model.Client;

import junit.framework.TestCase;

public class ClientTest extends TestCase{
	public ClientTest( String testName )
    {
        super( testName );
    }
	
	public void testAdd() {
		String name="ala", email="ala@wp.pl", phone="555";
		Float credit=(float) 5.2, accountBalance=(float) 2351.2;
		Client c = new Client(name, email, phone, credit, accountBalance);
		assertEquals(name, c.getName());
		assertEquals(email, c.getEmail());
		assertEquals(phone, c.getPhone());
		assertEquals(credit, c.getCredit());
		assertEquals(accountBalance, c.getAccountBalance());
	}
	
	public void testChangeCredit() {
		Float credit=(float) 5.2, credit2=(float) 2351.2;
		Client c = new Client("", "", "", credit, (float) 0);
		c.setCredit(credit2);
		assertEquals(credit2, c.getCredit());
	}
	
	public void testChangeAccount() {
		Float account=(float) 5.2, account2=(float) 2351.2;
		Client c = new Client("", "", "", (float) 0, account);
		c.setCredit(account2);
		assertEquals(account2, c.getCredit());
	}
}
