import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 3
 * Status: Incomplete
 * Last update: 02/28/18
 * Submitted:  02/28/18
 * Comment: Incomplete
 * @author: Michael Zacierka
 * @version: 2018.02.28
 */
public class DriverP3 {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static Deq<String> deq = new Deq<String>();
	static int count = 0;
	static int left = 0;
	static int right = 0;
	static boolean star = false;
	public static void main(String[] args) {
		boolean repeat = true;
		String entry = "";
		System.out.println("*****************************************************************************");
		do {
			try {
				System.out.print("Enter character: ");
				entry = stdin.readLine().trim().toLowerCase();
				if (entry.equals("!")) {
					repeat = false;
					test();
				} else if (entry.equals("*")) {
					star = true;
				} else {
					deq.enqueue(entry);
					count++;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (repeat);

	}

	static void test() {
		boolean palindrome = true;
		boolean sameContent = false;
		if (star == true) {
			for (int i = 0; i < count; i++) {
				if (!deq.isEmpty()) {
					if (deq.peek().equals(deq.peekLast())) {
						deq.dequeue();
						left++;
						deq.dequeueLast();
						right++;
					} else {
						count = count / 2;
						for(int z = 0; z < count; z++) {
							deq.enqueue(deq.peekLast());
							if(deq.peek().equals(deq.peekLast())) {
								sameContent = true;
							}
							right++;
						}
						palindrome = false;
						left++;
					}
				}
			}
		} else {
			System.out.println("No Star");
		}
		if (palindrome) {
			System.out.println("Same Length and Same Content, Palindrome");
		} else {
			if (left > right) {
				System.out.println(">> Left Longer");
			} else {
				System.out.println(">> Right Longer");
			}
			System.out.println("Not Palindrome");
		}
	}

}
