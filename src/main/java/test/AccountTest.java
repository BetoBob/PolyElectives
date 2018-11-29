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
		String encrypt = Account.encryption(toEncrypt, "encrypt");
		assertEquals("Ufxx|twi", encrypt);
	}
	
	@Test
	public void testDecryptBase() {
		//loop executed typical number of times
		String toDecrypt = "Ufxx|twi";
		String decrypt = Account.encryption(toDecrypt, "decrypt");
		assertEquals("Password", decrypt);
	}
	
	@Test
	public void testEncryptLoopNone() {
        //loop isnt executed
		String toEncrypt = "";
		String encrypt = Account.encryption(toEncrypt, "encrypt");
		assertEquals("", encrypt);
	}
	
	@Test
	public void testEncryptOne() {
        //loop executed once
		String toEncrypt = "P";
		String encrypt = Account.encryption(toEncrypt, "encrypt");
		assertEquals("U", encrypt);
	}
	
	@Test
	public void testEncryptTwo() {
        //loop executed exactly twice
		String toEncrypt = "Pa";
		String encrypt = Account.encryption(toEncrypt, "encrypt");
		assertEquals("Uf", encrypt);
	}
	
	@Test
	public void testDecryptLoopNone() {
        //loop isnt executed
		String toDecrypt = "";
		String decrypt = Account.encryption(toDecrypt, "decrypt");
		assertEquals("", decrypt);
	}
	
	@Test
	public void testDecryptOne() {
        //loop executed once
		String toDecrypt = "U";
		String decrypt = Account.encryption(toDecrypt, "decrypt");
		assertEquals("P", decrypt);
	}
	
	@Test
	public void testDecryptTwo() {
        //loop executed exactly twice
		String toDecrypt = "Uf";
		String decrypt = Account.encryption(toDecrypt, "decrypt");
		assertEquals("Pa", decrypt);
	}
	
}
