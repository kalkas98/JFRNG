import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import testUtil.Bar;



public class BarTestNG
{
	@Test
	public void Test1()
	{
		Bar b = new Bar();
		b.foo();
		System.gc();
		assertTrue(1 == 1);
	}
}
