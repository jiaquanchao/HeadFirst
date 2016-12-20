package offer;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class DoublePower {

	public static double dp(double base, int e) {
		int temE = e;
		if(e==0) {
			return 1; 
		}
		if(e < 0) {
			temE = -e;
		}
		double res = jisuan(base, temE);
		if (e < 0) {
			res = 1/res;
		}
		return res;
	}
	
	public static double jisuan(double base, int e){
		double res = base;
		while(e-- > 1) {
			res *= base;
		}
		return res;
	}
	
	@Test
	public void test() {
		// TODO Auto-generated method stub
		System.out.println(dp(4,4));
		System.out.println(8 >> 1);
	}
}
