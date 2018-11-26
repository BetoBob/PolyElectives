//Nicole Hill
package test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AccountTestSuit extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(AccountTestSuit.class.getName());
		//$JUnit-BEGIN$

		//$JUnit-END$
		return suite;
	}

}
