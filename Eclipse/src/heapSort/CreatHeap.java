package heapSort;

import java.util.Arrays;

import org.junit.Test;

public class CreatHeap {
	
	public void swap(int[] ints, int a, int b) {
		int tem = ints[a];
		ints[a] = ints[b];
		ints[b] = tem;
	}

	public void creatNode(int[] ints, int s, int n) {
		System.out.println(s+" - "+n);
		int child = 2*s + 1;
		int childR = child + 1;
		if (childR<=n){
			child = (ints[child]<ints[childR])?(childR):child;
		}
		if (child > n){
			return;
		}
		if (ints[s] < ints[child]){
			swap(ints, s, child);
		} else {
			return;
		}
		s = child;
		creatNode(ints, s, n);
	}
	
	public void heapSort(int[] ints) {
		int n = ints.length-1;
		while (n >= 0){
			for (int i = n/2; i >= 0; i--){
				creatNode(ints, i, n);
			}
			swap(ints, 0, n);
			n--;
		}
	}
	
	
	@Test
	public void test() {
		int[] ints = {4,2,5,6,2,1,9,0,4,7};
		heapSort(ints);
		System.out.println(Arrays.toString(ints));
		
	}
}
