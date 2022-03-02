package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Bar {
	private static final int N = 5000;
	private List<Integer> lst = new ArrayList<Integer>(N);
	
	public Bar() {
		for (int i = 0; i < N; i++) {
			lst.add(i);
		}
	}
	
	public void foo() {
		
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
	}

}
