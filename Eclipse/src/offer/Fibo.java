package offer;

import org.junit.Test;

public class Fibo {
	
	public static void f(int n) {
		int[] res = new int[n];
		if (n <= 2) {
			System.out.println(1);
		}
		Long first = 1L;
		Long second = 1L;
		int i = 2;
		while(i++ < n) {
			Long tem = first + second;
			first = second;
			second = tem;
		}
		System.out.println(second);
		
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


