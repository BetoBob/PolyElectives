// Nicole Hill
// Unit testing and loop testing

package test;

import static org.junit.Assert.*;
import java.io.IOException;
import logic.Account;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testEncryptBase() {
        //loop executed typical number of times
		String toEncrypt = "Password";
		String encrypt = Account.encrypt(toEncrypt);
		assertEquals("Ufxx|twi", encrypt);
	}
	
	@Test
	public void testDecryptBase() {
		//loop executed typical number of times
		String toDecrypt = "Ufxx|twi";
		String decrypt = Account.decrypt(toDecrypt);
		assertEquals("Password", decrypt);
	}
	
	@Test
	public void testEncryptLoopNone() {
        //loop isnt executed
		String toEncrypt = "";
		String encrypt = Account.encrypt(toEncrypt);
		assertEquals("", encrypt);
	}
	
	@Test
	public void testEncryptOne() {
        //loop executed once
		String toEncrypt = "P";
		String encrypt = Account.encrypt(toEncrypt);
		assertEquals("U", encrypt);
	}
	
	@Test
	public void testEncryptTwo() {
        //loop executed exactly twice
		String toEncrypt = "Pa";
		String encrypt = Account.encrypt(toEncrypt);
		assertEquals("Uf", encrypt);
	}
	
	@Test
	public void testDecryptLoopNone() {
        //loop isnt executed
		String toDecrypt = "";
		String decrypt = Account.decrypt(toDecrypt);
		assertEquals("", decrypt);
	}
	
	@Test
	public void testDecryptOne() {
        //loop executed once
		String toDecrypt = "U";
		String decrypt = Account.decrypt(toDecrypt);
		assertEquals("P", decrypt);
	}
	
	@Test
	public void testDecryptTwo() {
        //loop executed exactly twice
		String toDecrypt = "Uf";
		String decrypt = Account.decrypt(toDecrypt);
		assertEquals("Pa", decrypt);
	}
	

}
