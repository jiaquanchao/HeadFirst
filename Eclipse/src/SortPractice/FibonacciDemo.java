package SortPractice;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class FibonacciDemo {

	private static FibonacciDemo INSTANCE;
	private int lo = 0;
	private int hi = 1;
	private int LENGTH = 16;
	private int l = 2;
	private int i = 1;
	int[] ints;;
	public FibonacciDemo(){
		ints = new int[LENGTH];
		ints[0] = 0;
		ints[1] = 1;
	}
	public static FibonacciDemo getInstance() {
		if(INSTANCE==null){
			INSTANCE = new FibonacciDemo();
		}
		return INSTANCE;
	}
	
	public int getFb(int gIndex) {
		if(gIndex <= l) {
			return ints[gIndex - 1];
		}
		return calculate(gIndex);
	}
	
	public int calculate(int cIndex) {
		if (cIndex > LENGTH*i) {
			i  = cIndex/LENGTH + 1;
			ints = Arrays.copyOf(ints, LENGTH*i);
		}
		for(int j = l; j < cIndex; j ++) {
			l ++;
			ints[j] = lo + hi;
			lo = hi;
			hi = ints[j];
		}
		return ints[l-1];
	}
	
}
