package offer;

import org.junit.Test;

public class CountOne {

	public static void countOne(int n) {
		int num = 0;
		while(n != 0) {
			num++;
			n = n & (n - 1);
		}
		System.out.println(num);
	}
	
	@Test
	public void test() {
		// TODO Auto-generated method stub
		countOne(9);
	}
}
