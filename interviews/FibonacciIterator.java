import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

	private int first;
	private int second;

	public FibonacciIterator() {
		first = -1;
		second = 1;
	}

	@Override
	public Integer next() {
		int current = first + second;
		first = second;
		second = current;
		return current;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public void remove() {
	}

	public static void main(String[] args) {
		FibonacciIterator iterator = new FibonacciIterator();
		for (int i = 0; i < 20; i++) {
			System.out.println(iterator.next());
		}
	}
}
