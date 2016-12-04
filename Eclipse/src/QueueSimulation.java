import java.util.ArrayDeque;
import java.util.Deque;

public class QueueSimulation {
	

	public static class Simulation<T>{
		
		private Deque<T> dequeAdd = new ArrayDeque<>();
		private Deque<T> dequeDel = new ArrayDeque<>();
		
		public void appendTail(T t) {
			dequeAdd.push(t);
		}
		
		public void deleteHead() {
			if(dequeDel.isEmpty()) {
				while(!dequeAdd.isEmpty()) {
					dequeDel.push(dequeAdd.pollFirst());
				}
			}
			System.out.println("delete: " + dequeDel.pollFirst());
		}
		
				
	}
	
	public static void main(String[] args) {
		Simulation<String> s = new Simulation<>();
		s.appendTail("1");
		s.appendTail("2");
		s.appendTail("3");
		s.appendTail("4");
		s.appendTail("5");

	}

}
