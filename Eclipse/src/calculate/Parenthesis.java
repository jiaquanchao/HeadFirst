package calculate;

import org.junit.Test;

public class Parenthesis {

	public static void printParenthesis(int left, int right, String str) {

		if(right == 0 && left ==0) {
			System.out.println(str);
			return;
		}
		if(left >= 0) {
			printParenthesis(left-1, right, str + "(");
		}
		if(right > 0 && left < right) {
			printParenthesis(left, right-1, str + ")");
		}
	}
	
	@Test
	public void test() {
		printParenthesis(6,6,"");
	}
}
