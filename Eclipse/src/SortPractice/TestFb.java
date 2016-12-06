package SortPractice;

public class TestFb {

	public static void main(String[] args) {
		FibonacciDemo fb = FibonacciDemo.getInstance();
//		System.out.println(fb.ints[1]);
		int num = fb.getFb(30);
		System.out.println(num);
		fb = null;
		System.gc();
		FibonacciDemo fb1 = FibonacciDemo.getInstance();
		for(int i :
			fb1.ints) {
			System.out.println(i);
		}
//		fb = null;
//		System.gc();

	}
}
