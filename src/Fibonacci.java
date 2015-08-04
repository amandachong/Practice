import java.util.HashMap;

public class Fibonacci {

	/**
	 * Recursive method for computing fibonacci.
	 */
	public int fibonacci(int n) {
		if (n <= 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	/**
	 * Recursive method for computing fibonacci in one line.
	 */
	public int fib(int n) {
		return (n <= 2) ? 1 : fib(n - 2) + fib(n - 1);
	}

	/**
	 * Top-down memoization method for computing fibonacci numbers.
	 */
	public int fibonacciTD(int n) {
		if (n <= 2) {
			return 1;
		}

		HashMap<Integer, Integer> computedValues = new HashMap<Integer, Integer>();
		computedValues.put(1, 1);
		computedValues.put(2, 1);

		return fibonacciTD(n, computedValues);
	}

	public int fibonacciTD(int n, HashMap<Integer, Integer> computedValues) {
		if (computedValues.containsKey(n)) {
			return computedValues.get(n);
		}

		computedValues.put(n - 1, fibonacciTD(n - 1, computedValues));
		computedValues.put(n - 2, fibonacciTD(n - 2, computedValues));

		int newValue = computedValues.get(n - 1) + computedValues.get(n - 2);
		computedValues.put(n, newValue);
		return newValue;
	}

	/**
	 * Bottom-up dynamic programming approach to solving fibonacci numbers.
	 */
	public int fibonacciDP(int n) {
		int[] results = new int[n + 1];
		results[1] = 1;
		results[2] = 2;
		for (int i = 3; i <= n; i++) {
			results[i] = results[i - 1] + results[i - 2];
		}
		return results[n];
	}

	/**
	 * Bottom-up dynamic programming approach to solving fibonacci numbers and
	 * optimizing for memory.
	 */
	public int fibonacciDPOptimized(int n) {
		int n1 = 1;
		int n2 = 1;
		int current = 1;
		for (int i = 3; i <= n; i++) {
			current = n1 + n2;
			n2 = n1;
			n1 = current;
		}
		return current;
	}
}
