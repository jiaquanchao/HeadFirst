package mergeDemo;

import java.util.ArrayList;
import java.util.Arrays;;

public class MergeTools {
	
	public static void merge(int[] ori, int s, int m, int e) {
		int[] tem = new int[e-s+1];
		int flag_b = s;
		int flag_a = m + 1;
		int flag = 0;
		while (flag_b <= m && flag_a <= e) {
			if (ori[flag_b] > ori[flag_a]) {
				tem[flag++] = ori[flag_a++];
			} else {
				tem[flag++] = ori[flag_b++];
			}
		}
		
		while(flag_b <= m) {
			tem[flag++] = ori[flag_b++];
		}
		while(flag_a <= e) {
			tem[flag++] = ori[flag_a++];
		}
		for(int i = 0; i < tem.length; i++){
			ori[s+i] = tem[i];
		}
	}
	
	public static int[] mergeSort(int[] ori, int s, int e) {
		int m = (s+e)/2;
		if (s < e) {
			mergeSort(ori, s, m);
			mergeSort(ori, m+1, e);
			merge(ori, s, m, e);
		}
		return ori;
	}
	
	public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };  
        System.out.println(Arrays.toString(nums));
        MergeTools.mergeSort(nums, 0, nums.length-1);  
        System.out.println(Arrays.toString(nums));  

	}
}
