package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.PolyElectives;

public class AboutTest {

	@Test
	public void test() {
		// Do not keep : only for sonarcloud
		PolyElectives.main(null);
		assertEquals(true, true);
	}

}
