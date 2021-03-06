import java.util.ArrayList;
import java.util.Arrays;

public class MathProblems {

	/**
	 * LeetCode - Reverse Integer: Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321
	 * 
	 * Example2: x = -123, return -321
	 */
	public static int reverse(int x) {
		int reverse = 0;
		while (x != 0) {
			reverse *= 10 + (x % 10);
			x /= 10;
		}
		return reverse;
	}

	/**
	 * LeetCode – Palindrome Number
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
		int left;
		int right;
		while (x > 0) {
			left = x / div;
			right = x % 10;
			if (left != right) {
				return false;
			}
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	/**
	 * LeetCode – Valid Palindrome: Given a string, determine if it is a
	 * palindrome, considering only alphanumeric characters and ignoring cases.
	 * 
	 * For example, "Red rum, sir, is murder" is a palindrome, while
	 * "Programcreek is awesome" is not.
	 */
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() <= 1) {
			return true;
		}
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * LeetCode – Subsets: Given a set of distinct integers, S, return all
	 * possible subsets.
	 * 
	 * Note: 1) Elements in a subset must be in non-descending order. 2) The
	 * solution set must not contain duplicate subsets.
	 */
	public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		if (nums == null) {
			return null;
		}
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : result) {
				ArrayList<Integer> add = new ArrayList<Integer>(subset);
				add.add(nums[i]);
				temp.add(add);
			}
			result.addAll(temp);
			result.add(new ArrayList<Integer>(nums[i]));
		}
		return result;
	}

	/**
	 * LeetCode - Plus One: Given a non-negative number represented as an array
	 * of digits, plus one to the number.
	 */
	public int[] plusOne(int[] digits) {
		int remainder = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += remainder;
			remainder = 0;
			if (digits[i] > 9) {
				digits[i] = 0;
				remainder = 1;
			} else {
				break;
			}
		}
		if (remainder != 0) {
			int[] newDigits = new int[digits.length + 1];
			for (int i = 0; i < digits.length; i++) {
				newDigits[i + 1] = digits[i];
			}
			newDigits[0] = remainder;
			return newDigits;
		}
		return digits;
	}

	public int countDigits(int n, int digit) {
		n = Math.abs(n);
		int count = 0;
		while (n != 0) {
			if ((n % 10) == digit) {
				count++;
			}
			n /= 10;
		}
		return count;
	}

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

	// Given an integer, output all the prime factors of that integer, ex:
	// input: 6, output: 2, 3
	// input: 25, output: 5, 5
	public static ArrayList<Integer> findPrimeFactors(int number) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		if (number < 2) {
			return primeFactors;
		}
		int n = number;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				primeFactors.add(i);
				n /= i;
			}
		}
		if (primeFactors.size() == 0) {
			primeFactors.add(number);
		}
		return primeFactors;
	}

	public static void findFactors(int number) {
		int range = number;
		int i = 1;
		while (i < range) {
			if (number % i == 0) {
				System.out.println(i);
				if (i != number / i) {
					System.out.println(number / i);
				}
				range = number / i;
			}
			i++;
		}
	}

	public static void printOddNumbers(int begin, int end) {
		for (int i = 1; i <= 99; i += 2) {
			System.out.println(i);
		}
	}

	public static void multiplicationTable(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(String.format("%4d", i * j));
			}
			System.out.println();
		}
	}

	public static void printAllFactors(int n) {
		int i = 1;
		int range = n;
		while (i <= range) {
			if (n % i == 0) {
				System.out.println(i + "," + n / i);
				range = n / i;
			}
			i++;
		}
	}

	public boolean isPrime(int n) {
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(multiplesOf3And5());
		System.out.println(smallestMultiple());
		printAllFactors(100);
		multiplicationTable(12);
		printOddNumbers(1, 99);
		findFactors(2008);
	}
}
