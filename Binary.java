import java.util.LinkedList;
import java.util.Queue;

public class Binary {
	static void generatePrintBinary(int n) {
		Queue<String> queue = new LinkedList<>();
		queue.add("1");

		while (n-- > 0) {
			String current = queue.peek();
			queue.remove();
			System.out.println(current);
			queue.add(current + "0");
			queue.add(current + "1");
		}
	}

	public static void main(String[] args) {
		int n = 11;
		generatePrintBinary(n);
	}
}