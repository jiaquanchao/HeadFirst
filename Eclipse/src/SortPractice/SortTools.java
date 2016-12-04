package SortPractice;
import java.util.ArrayList;
import java.util.List;

public class SortTools {
	
	public static void sort(Comparable[] a){ }
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j) {
		Comparable tem = a[i];
		a[i] = a[j];
		a[j] = tem;
	}
	
	public static void show(Comparable[] a){
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i].toString() + " ");
		}
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i <a.length; i ++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		class Zhengshu implements Comparable<Zhengshu> {
			int val;
			
			public Zhengshu(int val) {
				this.val = val;
			}
			@Override
			public int compareTo(Zhengshu z) {
				if (this.val >= z.val) {
					return 1;
				} else {
					return 0;
				}
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return ("num: " + this.val);
			}
			
		}
		Zhengshu[] zhengshus = new Zhengshu[15];
		for(int i = 0; i < 15; i++) {
			zhengshus[i] = new Zhengshu((int)(1+Math.random()*100));
		}
		
		show(zhengshus);
		
	}
}
