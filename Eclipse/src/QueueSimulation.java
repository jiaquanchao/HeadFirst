import java.util.ArrayDeque;
import java.util.Deque;

public class QueueSimulation {
	

	public static class Simulation<T>{
		
		private Deque<T> dequeAdd = new ArrayDeque<>();
		private Deque<T> dequeDel = new ArrayDeque<>();
		private Deque<T> deque = new ArrayDeque<>();
		
		public void appendTail(T t) {
			deque.push(t);
		}
		
		public void deleteHead() {
			dequeAdd = deque;
			while(!dequeAdd.isEmpty()) {
				dequeDel.push(dequeAdd.pollFirst());
			}
			System.out.println(dequeDel.pollFirst().toString());
			dequeAdd = null;
			while(!dequeDel.isEmpty()) {
				dequeAdd.push(dequeDel.pollFirst());
			}
			deque = dequeAdd;
			dequeAdd = null;
			dequeDel = null;
		}
		
		public void getContext() {
			dequeAdd = deque;
			while(!dequeAdd.isEmpty()) {
				dequeDel.push(dequeAdd.pollFirst());
			}
			while(!dequeDel.isEmpty()) {
				System.out.println(dequeDel.pollFirst().toString());
			}
			dequeAdd = null;
			dequeDel = null;
		}
				
	}
	
	public static void main(String[] args) {
		Simulation<String> s = new Simulation<>();
		s.appendTail("1");
		s.appendTail("2");
		s.appendTail("3");
		s.appendTail("4");
		s.appendTail("5");
		s.getContext();
		System.out.println("______________");
		s.deleteHead();
		System.out.println("______________");
		s.getContext();
		System.out.println("______________");
	}

}
