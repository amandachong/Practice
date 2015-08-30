import java.util.ArrayList;

public class BigInteger {

	private ArrayList<String> longer;
	private ArrayList<String> shorter;
	private Integer segment = 9;

	public BigInteger(String a, String b) {
		longer = new ArrayList<String>();
		shorter = new ArrayList<String>();

		String longString = a.length() > b.length() ? a : b;
		String shortString = b.length() >= a.length() ? b : a;

		longer = segment(longString);
		shorter = segment(shortString);
	}

	private ArrayList<String> segment(String s) {
		ArrayList<String> list = new ArrayList<String>();
		while (s.length() - segment > 0) {
			list.add(s.substring(s.length() - segment));
			s = s.substring(0, s.length() - segment);
		}
		if (s.length() > 0) {
			list.add(s);
		}
		return list;
	}

	public ArrayList<Integer> add() {
		ArrayList<Integer> answer = new ArrayList<Integer>();

		Integer carry = 0;
		for (int i = 0; i < shorter.size(); i++) {
			Integer first = Integer.parseInt(longer.get(i));
			Integer second = Integer.parseInt(shorter.get(i));
			Integer added = first + second + carry;
			carry = added / (int) Math.pow(10, segment);
			answer.add(added);
		}

		for (int i = shorter.size(); i < longer.size(); i++) {
			Integer num = Integer.parseInt(longer.get(i));
			Integer added = num + carry;
			carry = added % (int) Math.pow(10, segment);
			answer.add(added);
		}

		if (carry > 0) {
			answer.add(carry);
		}

		return answer;
	}

	public static void main(String[] args) {
		BigInteger test = new BigInteger("9", "9");
		ArrayList<Integer> answer = test.add();
		for (int i = answer.size() - 1; i >= 0; i--) {
			System.out.print(answer.get(i));
		}
	}
}
