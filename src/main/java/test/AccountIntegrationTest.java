// Nicole Hill
// Integration Testing

package test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import logic.Account;

import org.junit.Test;

public class AccountIntegrationTest {
	
	@Test
	public void testParseAccountInfo() {
        //smaller method testing
		String lines = "pwd,ufxx|twi,email,nmhill@calpoly.edu";
		String[] splitty = lines.split(",");
		HashMap<String, String> account = Account.parseAccountInfo(splitty);
		
		assertTrue(account.containsKey("pwd"));
		assertTrue(account.containsKey("email"));
		assertTrue(account.containsValue("password"));
		assertTrue(account.containsValue("nmhill@calpoly.edu"));
	}
	
	@Test
	public void testParseLine() {
		//method calls previously tested method
		String lines = "pwd,ufxx|twi,email,nmhill@calpoly.edu";
		HashMap<String, String> account = Account.parseLine(lines);
		
		assertTrue(account.containsKey("pwd"));
		assertTrue(account.containsKey("email"));
		assertTrue(account.containsValue("password"));
		assertTrue(account.containsValue("nmhill@calpoly.edu"));
	}
	
	@Test
	public void testParseAccountInfo2() {
        //smaller method testing again
		String lines = "firstN,Bob,lastN,Smith,pwd,ufxx|twi,email,bsmith@calpoly.edu";
		String[] splitty = lines.split(",");
		HashMap<String, String> account = Account.parseAccountInfo(splitty);
		
		assertTrue(account.containsKey("pwd"));
		assertTrue(account.containsKey("email"));
		assertTrue(account.containsKey("firstN"));
		assertTrue(account.containsKey("lastN"));
		assertTrue(account.containsValue("password"));
		assertTrue(account.containsValue("bsmith@calpoly.edu"));
		assertTrue(account.containsValue("Bob"));
		assertTrue(account.containsValue("Smith"));
	}
	
	@Test
	public void testParseLine2() {
		//method calls previously tested method again
		String lines = "firstN,Bob,lastN,Smith,pwd,ufxx|twi,email,bsmith@calpoly.edu";
		HashMap<String, String> account = Account.parseLine(lines);
		
		assertTrue(account.containsKey("pwd"));
		assertTrue(account.containsKey("email"));
		assertTrue(account.containsKey("firstN"));
		assertTrue(account.containsKey("lastN"));
		assertTrue(account.containsValue("password"));
		assertTrue(account.containsValue("bsmith@calpoly.edu"));
		assertTrue(account.containsValue("Bob"));
		assertTrue(account.containsValue("Smith"));
	}
	
	@Test
	public void testCreateAccountItem() {
		//smaller method testing
		String key = "pwd", value = "password";
		String accountItem = Account.createAccountItem(key, value);
		
		assertEquals(",pwd,ufxx|twi", accountItem);
	}
	
	@Test
	public void testCreateAccountItem2() {
		//smaller method testing again
		String key = "firstN", value = "Bob";
		String accountItem = Account.createAccountItem(key, value);
		
		assertEquals(",firstN,Bob", accountItem);
	}
	
	@Test
	public void testCreateAccountItem3() {
		//smaller method testing again
		String key = "lastN", value = "Smith";
		String accountItem = Account.createAccountItem(key, value);
		
		assertEquals(",lastN,Smith", accountItem);
	}
	
	@Test
	public void testCreateAccountItem4() {
		//smaller method testing again
		String key = "email", value = "bsmith@calpoly.edu";
		String accountItem = Account.createAccountItem(key, value);
		
		assertEquals(",email,bsmith@calpoly.edu", accountItem);
	}
	
	@Test
	public void testCreateFullAccountString() {
		//method calls previously tested method
		String acountString;
		Map<String, String> accountInfo = new HashMap<String, String>();
		
		accountInfo.put("pwd", "password");
		accountInfo.put("firstN", "Bob");
		accountInfo.put("email", "bsmith@calpoly.edu");
		accountInfo.put("lastN", "Smith");
		
		acountString = Account.createFullAccountString(accountInfo);
		assertEquals("firstN,Bob,lastN,Smith,pwd,ufxx|twi,email,bsmith@calpoly.edu", acountString);
		
	}

}
