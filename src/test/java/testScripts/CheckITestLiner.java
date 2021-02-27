package testScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(base.TestNGListener.class)
public class CheckITestLiner extends TestBase {

	@Test
	public void m1() {
		System.out.println("m1");
	}

	@Test
	public void m2() throws Exception {
		throw new Exception();
	}

}
