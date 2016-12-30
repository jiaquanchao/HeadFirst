package offer;

import org.junit.Test;

public class Fibo {
	
	public static void f(int n) {
		Long[] res = new Long[n];
		res[0] = 1L;
		res[1] = 1L;
		int i = 2;
		while(i < n) {
			res[i] = res[i-1] + res[i-2];
			i ++;
		}
		System.out.println(res[n-1]);
		
	}
	
	public static int create(int num){
		if (num <= 2) {
			return 1;
		}
		return create(num - 1) + create(num - 2);
	}
	
	@Test
	public void test() {
		f(50);
//		System.out.println(create(50));
	}
}


