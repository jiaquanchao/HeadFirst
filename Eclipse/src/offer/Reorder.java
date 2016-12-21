package offer;

import java.util.Arrays;

import org.junit.Test;

public class Reorder {

	public static void swap(int[] ints, int a, int b) {
		int tem = ints[a];
		ints[a] = ints[b];
		ints[b] = tem;
	}
	
	public static void reorder(int[] ints) {
		int l = ints.length - 1;
		int s = 0;
		int e = l;
		while(s < e) {
			while(ints[s]%2 == 1) {s++;};
			while(ints[e]%2 == 0) {e--;};
			if(s >= e) {
				return;
			}
			System.out.println(s+" & "+e);
			swap(ints, s, e);
		}
	}
	
	
	@Test
	public void test() {
		// TODO Auto-generated method stub

		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		reorder(array);
        System.out.println(Arrays.toString(array));
        System.out.println(1%2);
	}
}
