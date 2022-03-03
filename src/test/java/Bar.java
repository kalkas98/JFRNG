

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Just some methods to use for examples and tests
 *
 */
public class Bar {
	private static final int N = 5000;
	private List<Integer> lst = new ArrayList<Integer>(N);
	private List<mem> doubles = new ArrayList<mem>();
	
	public Bar() {
		for (int i = 0; i < N; i++) {
			lst.add(i);
		}
	}
	
	public void foo() {
		FooEvent fe = new FooEvent();
		
		fe.begin();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				lst.set(j, j % 10);
			}
			Collections.sort(lst);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				lst.set(j, (int)(Math.sqrt(lst.get(i) % 10)));
			}
			Collections.sort(lst);
		}
		
		fe.end();
		fe.commit();
	}
	
	private class mem
	{
		ArrayList<Double> arr = new ArrayList<Double>();
		public mem()
		{
			for (int i = 0; i < 10000; i++)
			{
				arr.add((double)i);
			}
		}
	}
	
	public void mem()
	{
		for (int i = 0; i < 1000; i++)
		{
			doubles.add(new mem());
			
		}
	}

}
