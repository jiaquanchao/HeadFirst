import java.util.ArrayDeque;
import java.util.Deque;

public class QueueSimulation {
	

	public static class Simulation<T>{
		
		private Deque<T> dequeAdd = new ArrayDeque<>();
		private Deque<T> dequeDel = new ArrayDeque<>();
		private Deque<T> deque = new ArrayDeque<>();
		
		public void appendTail(T t) {
			dequeAdd.push(t);
		}
		
		public void deleteHead() {

			if()
			while(!dequeAdd.isEmpty()) {
				System.out.println(dequeAdd.pollFirst().toString());
			}
			dequeAdd = deque;
			deque.clear();
			while(!dequeAdd.isEmpty()) {
				dequeDel.push(dequeAdd.pollFirst());
			}
			dequeAdd.clear();
			while(!dequeDel.isEmpty()) {
				System.out.println(dequeDel.pollFirst().toString());
			}
			while(!dequeDel.isEmpty()) {
				dequeAdd.push(dequeDel.pollFirst());
			}
			while(!dequeAdd.isEmpty()) {
				System.out.println(dequeAdd.pollFirst().toString());
			}
			deque = dequeAdd;
			dequeAdd.clear();
			dequeDel.clear();
		}
		
		public void getContext() {
			dequeAdd = deque;
			while(!dequeAdd.isEmpty()) {
				dequeDel.push(dequeAdd.pollFirst());
			}
			while(!dequeDel.isEmpty()) {
				System.out.println(dequeDel.pollFirst().toString());
			}
			dequeAdd.clear();
			dequeDel.clear();
		}
				
	}
	
	public static void main(String[] args) {
		Simulation<String> s = new Simulation<>();
		s.appendTail("1");
		s.appendTail("2");
		s.appendTail("3");
		s.appendTail("4");
		s.appendTail("5");
//		s.getContext();
		System.out.println("______________");
		s.deleteHead();
		System.out.println("______________");
		s.getContext();
		System.out.println("______________");
	}

}
