
/**
 * 在这个题目里面，要写一个寻找最小值的函数，用于最后的遍历
 * 在写另一个函数的时候通过改编头尾坐标来改
 * @author user
 *
 */
public class RollMin {
	
	public static int findMin(int[] ints) {
		int head = 0;
		int tail = ints.length-1;
		if (tail == 0) {
			return ints[tail];
		}
		int m = head;
		while(head <= tail) {
			if (tail-head == 1) {
				return fm(ints, head, tail);
			}
			m = (head+tail)/2;
			if (ints[head]==ints[m]&&ints[m]==ints[tail]) {
				fm(ints, head, tail);
			}
			if(ints[m] < ints[head]){
				tail = m;
			} else {
				head = m;
			}
		}
		return m;
		
	}
	public static int fm(int[] ints, int s, int e) {
		int tem = ints[s];
		for(int i=s+1; i<=e; i++) {
			if(ints[i] < tem){
				return ints[i];
			}
		}
		return tem;
	}
	
	public static void main(String[] args) {
		int[] ints = new int[]{3,4,5, 6, 7,1, 1, 1, 1,2};
//		int[] ints1 = new int[]{5, 2, 3,4};
		System.out.println(findMin(ints));
	}

}
