package ntt.devsecops.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FunctionUtilTest {

	@Test
	void testIsNullOrEmpty() {
		boolean testCheck = FunctionUtil.isNullOrEmpty(null);
		assertEquals(true, testCheck);
		testCheck = FunctionUtil.isNullOrEmpty("");
		assertEquals(true, testCheck);
		testCheck = FunctionUtil.isNullOrEmpty("test");
		assertEquals(false, testCheck);
	}

}
