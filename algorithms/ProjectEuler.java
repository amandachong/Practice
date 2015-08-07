public class ProjectEuler {
	/**
	 * Multiples of 3 and 5
	 * 
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
	 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * 
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	public static int multiplesOf3And5() {
		int n = 1000;
		int sum = 0;
		for (int i = 3; i < n; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	/**
	 * Even Fibonacci numbers
	 * 
	 * Each new term in the Fibonacci sequence is generated by adding the
	 * previous two terms. By starting with 1 and 2, the first 10 terms will be:
	 * 
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 * 
	 * By considering the terms in the Fibonacci sequence whose values do not
	 * exceed four million, find the sum of the even-valued terms.
	 */
	public static int evenFibonacci() {
		int n = 4000000;
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		int sum = 0;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
			if (fib[i] % 2 == 0) {
				sum += fib[i];
			}
		}
		return sum;
	}

	/**
	 * Smallest multiple Problem 5
	 * 
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 */
	public static int smallestMultiple() {
		int i = 20;
		while (true) {
			if (i % 19 == 0 && i % 18 == 0 && i % 17 == 0 && i % 16 == 0
					&& i % 15 == 0 && i % 14 == 0 && i % 13 == 0 && i % 12 == 0
					&& i % 11 == 0 && i % 9 == 0 && i % 8 == 0 && i % 7 == 0
					&& i % 6 == 0 && i % 3 == 0) {
				return i;
			}
			i += 20;
		}
	}

	/**
	 * Largest product in a series Problem 8
	 * 
	 * The four adjacent digits in the 1000-digit number that have the greatest
	 * product are 9 × 9 × 8 × 9 = 5832.
	 * 
	 * 73167176531330624919225119674426574742355349194934
	 * 96983520312774506326239578318016984801869478851843
	 * 85861560789112949495459501737958331952853208805511
	 * 12540698747158523863050715693290963295227443043557
	 * 66896648950445244523161731856403098711121722383113
	 * 62229893423380308135336276614282806444486645238749
	 * 30358907296290491560440772390713810515859307960866
	 * 70172427121883998797908792274921901699720888093776
	 * 65727333001053367881220235421809751254540594752243
	 * 52584907711670556013604839586446706324415722155397
	 * 53697817977846174064955149290862569321978468622482
	 * 83972241375657056057490261407972968652414535100474
	 * 82166370484403199890008895243450658541227588666881
	 * 16427171479924442928230863465674813919123162824586
	 * 17866458359124566529476545682848912883142607690042
	 * 24219022671055626321111109370544217506941658960408
	 * 07198403850962455444362981230987879927244284909188
	 * 84580156166097919133875499200524063689912560717606
	 * 05886116467109405077541002256983155200055935729725
	 * 71636269561882670428252483600823257530420752963450
	 * 
	 * Find the thirteen adjacent digits in the 1000-digit number that have the
	 * greatest product. What is the value of this product?
	 */
	public static int largestProductInSeries() {
		int[] digits = new int[] { 7, 3, 1, 6, 7, 1, 7, 6, 5, 3, 1, 3, 3, 0, 6,
				2, 4, 9, 1, 9, 2, 2, 5, 1, 1, 9, 6, 7, 4, 4, 2, 6, 5, 7, 4, 7,
				4, 2, 3, 5, 5, 3, 4, 9, 1, 9, 4, 9, 3, 4, 9, 6, 9, 8, 3, 5, 2,
				0, 3, 1, 2, 7, 7, 4, 5, 0, 6, 3, 2, 6, 2, 3, 9, 5, 7, 8, 3, 1,
				8, 0, 1, 6, 9, 8, 4, 8, 0, 1, 8, 6, 9, 4, 7, 8, 8, 5, 1, 8, 4,
				3, 8, 5, 8, 6, 1, 5, 6, 0, 7, 8, 9, 1, 1, 2, 9, 4, 9, 4, 9, 5,
				4, 5, 9, 5, 0, 1, 7, 3, 7, 9, 5, 8, 3, 3, 1, 9, 5, 2, 8, 5, 3,
				2, 0, 8, 8, 0, 5, 5, 1, 1, 1, 2, 5, 4, 0, 6, 9, 8, 7, 4, 7, 1,
				5, 8, 5, 2, 3, 8, 6, 3, 0, 5, 0, 7, 1, 5, 6, 9, 3, 2, 9, 0, 9,
				6, 3, 2, 9, 5, 2, 2, 7, 4, 4, 3, 0, 4, 3, 5, 5, 7, 6, 6, 8, 9,
				6, 6, 4, 8, 9, 5, 0, 4, 4, 5, 2, 4, 4, 5, 2, 3, 1, 6, 1, 7, 3,
				1, 8, 5, 6, 4, 0, 3, 0, 9, 8, 7, 1, 1, 1, 2, 1, 7, 2, 2, 3, 8,
				3, 1, 1, 3, 6, 2, 2, 2, 9, 8, 9, 3, 4, 2, 3, 3, 8, 0, 3, 0, 8,
				1, 3, 5, 3, 3, 6, 2, 7, 6, 6, 1, 4, 2, 8, 2, 8, 0, 6, 4, 4, 4,
				4, 8, 6, 6, 4, 5, 2, 3, 8, 7, 4, 9, 3, 0, 3, 5, 8, 9, 0, 7, 2,
				9, 6, 2, 9, 0, 4, 9, 1, 5, 6, 0, 4, 4, 0, 7, 7, 2, 3, 9, 0, 7,
				1, 3, 8, 1, 0, 5, 1, 5, 8, 5, 9, 3, 0, 7, 9, 6, 0, 8, 6, 6, 7,
				0, 1, 7, 2, 4, 2, 7, 1, 2, 1, 8, 8, 3, 9, 9, 8, 7, 9, 7, 9, 0,
				8, 7, 9, 2, 2, 7, 4, 9, 2, 1, 9, 0, 1, 6, 9, 9, 7, 2, 0, 8, 8,
				8, 0, 9, 3, 7, 7, 6, 6, 5, 7, 2, 7, 3, 3, 3, 0, 0, 1, 0, 5, 3,
				3, 6, 7, 8, 8, 1, 2, 2, 0, 2, 3, 5, 4, 2, 1, 8, 0, 9, 7, 5, 1,
				2, 5, 4, 5, 4, 0, 5, 9, 4, 7, 5, 2, 2, 4, 3, 5, 2, 5, 8, 4, 9,
				0, 7, 7, 1, 1, 6, 7, 0, 5, 5, 6, 0, 1, 3, 6, 0, 4, 8, 3, 9, 5,
				8, 6, 4, 4, 6, 7, 0, 6, 3, 2, 4, 4, 1, 5, 7, 2, 2, 1, 5, 5, 3,
				9, 7, 5, 3, 6, 9, 7, 8, 1, 7, 9, 7, 7, 8, 4, 6, 1, 7, 4, 0, 6,
				4, 9, 5, 5, 1, 4, 9, 2, 9, 0, 8, 6, 2, 5, 6, 9, 3, 2, 1, 9, 7,
				8, 4, 6, 8, 6, 2, 2, 4, 8, 2, 8, 3, 9, 7, 2, 2, 4, 1, 3, 7, 5,
				6, 5, 7, 0, 5, 6, 0, 5, 7, 4, 9, 0, 2, 6, 1, 4, 0, 7, 9, 7, 2,
				9, 6, 8, 6, 5, 2, 4, 1, 4, 5, 3, 5, 1, 0, 0, 4, 7, 4, 8, 2, 1,
				6, 6, 3, 7, 0, 4, 8, 4, 4, 0, 3, 1, 9, 9, 8, 9, 0, 0, 0, 8, 8,
				9, 5, 2, 4, 3, 4, 5, 0, 6, 5, 8, 5, 4, 1, 2, 2, 7, 5, 8, 8, 6,
				6, 6, 8, 8, 1, 1, 6, 4, 2, 7, 1, 7, 1, 4, 7, 9, 9, 2, 4, 4, 4,
				2, 9, 2, 8, 2, 3, 0, 8, 6, 3, 4, 6, 5, 6, 7, 4, 8, 1, 3, 9, 1,
				9, 1, 2, 3, 1, 6, 2, 8, 2, 4, 5, 8, 6, 1, 7, 8, 6, 6, 4, 5, 8,
				3, 5, 9, 1, 2, 4, 5, 6, 6, 5, 2, 9, 4, 7, 6, 5, 4, 5, 6, 8, 2,
				8, 4, 8, 9, 1, 2, 8, 8, 3, 1, 4, 2, 6, 0, 7, 6, 9, 0, 0, 4, 2,
				2, 4, 2, 1, 9, 0, 2, 2, 6, 7, 1, 0, 5, 5, 6, 2, 6, 3, 2, 1, 1,
				1, 1, 1, 0, 9, 3, 7, 0, 5, 4, 4, 2, 1, 7, 5, 0, 6, 9, 4, 1, 6,
				5, 8, 9, 6, 0, 4, 0, 8, 0, 7, 1, 9, 8, 4, 0, 3, 8, 5, 0, 9, 6,
				2, 4, 5, 5, 4, 4, 4, 3, 6, 2, 9, 8, 1, 2, 3, 0, 9, 8, 7, 8, 7,
				9, 9, 2, 7, 2, 4, 4, 2, 8, 4, 9, 0, 9, 1, 8, 8, 8, 4, 5, 8, 0,
				1, 5, 6, 1, 6, 6, 0, 9, 7, 9, 1, 9, 1, 3, 3, 8, 7, 5, 4, 9, 9,
				2, 0, 0, 5, 2, 4, 0, 6, 3, 6, 8, 9, 9, 1, 2, 5, 6, 0, 7, 1, 7,
				6, 0, 6, 0, 5, 8, 8, 6, 1, 1, 6, 4, 6, 7, 1, 0, 9, 4, 0, 5, 0,
				7, 7, 5, 4, 1, 0, 0, 2, 2, 5, 6, 9, 8, 3, 1, 5, 5, 2, 0, 0, 0,
				5, 5, 9, 3, 5, 7, 2, 9, 7, 2, 5, 7, 1, 6, 3, 6, 2, 6, 9, 5, 6,
				1, 8, 8, 2, 6, 7, 0, 4, 2, 8, 2, 5, 2, 4, 8, 3, 6, 0, 0, 8, 2,
				3, 2, 5, 7, 5, 3, 0, 4, 2, 0, 7, 5, 2, 9, 6, 3, 4, 5, 0 };
		FrontBackQueue queue = new FrontBackQueue();
		int max = 0;
		for (int i = 0; i < 13; i++) {
			queue.enqueueFront(digits[i]);
			max += digits[i];
		}
		int current = max;
		for (int i = 13; i < digits.length; i++) {
			int value = queue.dequeueBack();
			current /= value == 0 ? 1 : value;
			queue.enqueueFront(digits[i]);
			current *= digits[i];
			max = Math.max(max, current);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(multiplesOf3And5());
		System.out.println(evenFibonacci());
		System.out.println(smallestMultiple());
		System.out.println(largestProductInSeries());
	}
}
